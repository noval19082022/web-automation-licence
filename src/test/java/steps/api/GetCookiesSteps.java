package steps.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.Cookie;
import com.microsoft.playwright.options.RequestOptions;
import config.playwright.context.ActiveContext;
import data.api.CreateBooking;
import data.api.UserCookies;
import data.mamikos.ApiEndpoints;
import data.mamikos.Mamikos;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utilities.ApiPlaywrightHelpers;
import utilities.JavaHelpers;
import utilities.JsonHelpers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetCookiesSteps {
    private Page page = ActiveContext.getActivePage();
    private List<Cookie> cookieList;
    private String cookieString;
    private Map<String, String> headers = new HashMap<>();
    private APIRequestContext tenantProfileRequest;
    private APIResponse tenantProfileResponse;
    private ApiPlaywrightHelpers apiPwHelpers = new ApiPlaywrightHelpers(page);
    private Map<Object, Object> createBookingBody = new HashMap<>();

    @When("playwright collect tenant cookies")
    public void playwrightCollectTenantCookies() {
        cookieList = apiPwHelpers.getCookieList();
        cookieString = apiPwHelpers.parseCookieToString(cookieList);
        UserCookies.setTenantCookie(cookieString);
    }

    @When("playwright get tenant data profile")
    public void playwrightGetTenantDataProfile() {
        //headers.put("Accept", "application/json");
        headers.put("Cookie", UserCookies.getTenantCookie());
        headers.put("X-GIT-Time", ApiEndpoints.X_GIT_TIME);
        tenantProfileRequest = apiPwHelpers.setBaseUrlAndHeaders(Mamikos.URL, headers);
        tenantProfileResponse = tenantProfileRequest.get(ApiEndpoints.TENANT_PROFILE);
        Assert.assertEquals(tenantProfileResponse.status(), 200);
        Assert.assertTrue(tenantProfileResponse.ok());
    }

    @When("playwright make json file for tenant booking from tenant profile data")
    public void playwrightMakeJsonFileForTenantBookingFromTenantProfileData() {
        String todayDate = JavaHelpers.getCostumDateOrTime("yyyy-MM-dd", 0, 0, 0);
        String plusOneMonthDate = JavaHelpers.getCostumDateOrTime("yyyy-MM-dd", 0, 1, 0);
        String jsonString = tenantProfileResponse.text();
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

        String phoneNumber = profileObject.get("phone").getAsString();
        String cleanedPhoneNumber = phoneNumber.replaceFirst("^0+", "");
        long acceptablePhoneNumber = Long.parseLong(cleanedPhoneNumber);
        CreateBooking.setRentCountType("monthly");
        CreateBooking.setCheckIn(todayDate);
        CreateBooking.setCheckOut(plusOneMonthDate);
        CreateBooking.setDuration(1);
        CreateBooking.setContactName(profileObject.get("name").getAsString());
        CreateBooking.setContactPhone(acceptablePhoneNumber);
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
        createBookingBody.put("check_in", CreateBooking.getCheckIn());
        createBookingBody.put("check_out", CreateBooking.getCheckOut());
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
}
