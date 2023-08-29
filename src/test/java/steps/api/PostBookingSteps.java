package steps.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Request;
import com.microsoft.playwright.options.Cookie;
import com.microsoft.playwright.options.RequestOptions;
import config.playwright.context.ActiveContext;
import data.api.CreateBooking;
import data.api.CreateDeviceId;
import data.api.UserCookies;
import data.mamikos.ApiEndpoints;
import data.mamikos.Mamikos;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import org.testng.Assert;
import utilities.ApiPlaywrightHelpers;
import utilities.JavaHelpers;
import utilities.JsonHelpers;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostBookingSteps {
    private Page page = ActiveContext.getActivePage();
    private Map<String, String> createBookingHeaders = new HashMap<>();
    private APIRequestContext createBookingRequest;
    private APIResponse createBookingResponse;
    private Map<Object, Object> createBookingBody = new HashMap<>();
    private Map<Object, Object> bookingBody = new HashMap<>();
    private ApiPlaywrightHelpers apiHelpers = new ApiPlaywrightHelpers(page);
    private String bookingDataFile = "src/test/resources/testdata/ajukanSewa/ajukanSewa.properties";
    private String songId = JavaHelpers.getPropertyValue(bookingDataFile, "songId1");
    private String roomTypeId = JavaHelpers.getPropertyValue(bookingDataFile, "roomTypeId1");

    @When("playwright make json file for tenant booking from tenant profile data")
    public void playwrightMakeJsonFileForTenantBookingFromTenantProfileData() {
        String todayDate = JavaHelpers.getCostumDateOrTime("yyyy-MM-dd", 0, 0, 0);
        String plusOneMonthDate = JavaHelpers.getCostumDateOrTime("yyyy-MM-dd", 0, 1, 0);
        String jsonString = CreateBooking.getTenantProfileResponse();
        boolean isMarried = false;
        boolean isMarriedNull = false;

        JsonHelpers.createJsonFileFromJsonString(jsonString, "target/tenantProfile.json");

        JsonElement tenantProfile = JsonHelpers.createJsonElementFromJsonFile("target/tenantProfile.json");
        JsonObject tenantProfileObject = JsonHelpers.createJsonObject(tenantProfile);
        JsonArray tenantDataArray = JsonHelpers.createJsonArray(tenantProfileObject, "data");

        JsonObject tenantProfileData = tenantDataArray.get(0).getAsJsonObject();
        JsonObject profileObject = tenantProfileObject.getAsJsonObject("profile");
        String gender = profileObject.get("gender").getAsString().toLowerCase()
                .equalsIgnoreCase("laki-laki") ? "male" : "female";

        if (profileObject.get("marital_status").isJsonNull()) {
            isMarried = false;
            isMarriedNull = true;
        }

        if (!isMarriedNull) {
            isMarried = !profileObject.get("marital_status").getAsString()
                    .equalsIgnoreCase("belum kawin");
        }
        CreateBooking.setRentCountType("monthly");
        CreateBooking.setCheckIn(todayDate);
        CreateBooking.setCheckOut(plusOneMonthDate);
        CreateBooking.setDuration(1);
        CreateBooking.setContactName(profileObject.get("name").getAsString());
        CreateBooking.setContactPhone(profileObject.get("phone").getAsString());
        CreateBooking.setContactJob(tenantProfileData.get("description").getAsString());
        CreateBooking.setContactGender(gender);
        CreateBooking.setContactIdentity("Mamitest" + CreateBooking.getContactPhone());
        CreateBooking.setContactIntroduction("Saya dari tadi cuman ingin tidur");
        CreateBooking.setContactWorkPlace("Mamitest Workplace");
        CreateBooking.setFlashSale(false);
        CreateBooking.setMarried(isMarried);
        CreateBooking.setBringChild(isMarried);
        CreateBooking.setMarriageBookId(0);
        CreateBooking.setFamilyCardId(0);
        CreateBooking.setPhotoSelfieId(0);
        CreateBooking.setPhotoIdentityId(0);
        CreateBooking.setSessionId("QA Mamitest Session");
        CreateBooking.setTotalRenter(1);
        CreateBooking.setFirstPaymentType("full");

        createBookingBody.put("rent_count_type", CreateBooking.getRentCountType());
        createBookingBody.put("checkin", CreateBooking.getCheckIn());
        createBookingBody.put("checkout", CreateBooking.getCheckOut());
        createBookingBody.put("duration", CreateBooking.getDuration());
        createBookingBody.put("contact_name", CreateBooking.getContactName());
        createBookingBody.put("contact_phone", CreateBooking.getContactPhone());
        createBookingBody.put("contact_job", CreateBooking.getContactJob());
        createBookingBody.put("contact_gender", CreateBooking.getContactGender());
        createBookingBody.put("contact_identity", CreateBooking.getContactIdentity());
        createBookingBody.put("contact_introduction", CreateBooking.getContactIntroduction());
        createBookingBody.put("contact_work_place", CreateBooking.getContactWorkPlace());
        createBookingBody.put("is_flash_sale", CreateBooking.isFlashSale());
        createBookingBody.put("is_married", CreateBooking.isMarried());
        createBookingBody.put("is_bring_child", CreateBooking.isBringChild());
        createBookingBody.put("marriage_book_id", CreateBooking.getMarriageBookId());
        createBookingBody.put("family_card_id", CreateBooking.getFamilyCardId());
        createBookingBody.put("photo_selfie_id", CreateBooking.getPhotoSelfieId());
        createBookingBody.put("photo_identity_id", CreateBooking.getPhotoIdentityId());
        createBookingBody.put("session_id", CreateBooking.getSessionId());
        createBookingBody.put("total_renter", CreateBooking.getTotalRenter());
        createBookingBody.put("first_payment_type", CreateBooking.getFirstPaymentType());

        JsonHelpers.createJsonFileFromJsonString(JsonHelpers.createJsonStringFromMap(createBookingBody),
                "target/createBookingBody.json");
        CreateBooking.setCreateBookingBody(createBookingBody);
    }

    @When("playwright create booking for tenant")
    public void playwrightCreateBookingForTenant() throws NoSuchAlgorithmException, InvalidKeyException {
        var createBookingEndpoint = ApiEndpoints.V1_PREFIX + ApiEndpoints.CREATE_BOOKING.replace("{songId}/{roomTypeId}", songId + "/" + roomTypeId);
        var data = "POST" + " " + createBookingEndpoint + " " +  ApiEndpoints.X_GIT_TIME;
        var signature = JavaHelpers.bytesToHexString(JavaHelpers.generateHmacSha256(ApiEndpoints.SECRET_KEY, data));
        bookingBody = CreateBooking.getCreateBookingBody();
        System.out.println(bookingBody);
        createBookingHeaders.put("Authorization", "GIT "+ signature + ":" + CreateDeviceId.getDeviceToken());
        createBookingHeaders.put("X-GIT-Time", ApiEndpoints.X_GIT_TIME);
        createBookingHeaders.put("Content-Type", "application/json");
        createBookingRequest = ApiPlaywrightHelpers.setBaseUrlAndHeaders(ApiEndpoints.STAGING, createBookingHeaders);
        createBookingResponse = createBookingRequest.post(createBookingEndpoint, RequestOptions.create()
                .setQueryParam("devel_access_token", ApiEndpoints.DEVEL_ACCESS_TOKEN)
                .setData(bookingBody));
        System.out.println(createBookingResponse.url());
        System.out.println(createBookingResponse.text());
        System.out.println(createBookingResponse.status());
    }
}
