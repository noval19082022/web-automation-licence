package steps.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.Cookie;
import config.playwright.context.ActiveContext;
import data.api.CreateBooking;
import data.api.UserCookies;
import data.mamikos.ApiEndpoints;
import data.mamikos.Mamikos;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import utilities.ApiPlaywrightHelpers;
import utilities.JavaHelpers;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetCookiesSteps {
    private Page page = ActiveContext.getActivePage();
    private List<Cookie> cookieList;
    private String cookieString;
    private Map<String, String> headers = new HashMap<>();
    private APIRequestContext request;
    private APIResponse apiResponse;
    private ApiPlaywrightHelpers apiPwHelpers = new ApiPlaywrightHelpers(page);
    private Map<Object, Object> createBookingBody = new HashMap<>();

    @When("playwright collect tenant cookies")
    public void playwrightCollectTenantCookies() {
        cookieList = apiPwHelpers.getCookieList();
        cookieString = apiPwHelpers.parseCookieToString(cookieList);
        UserCookies.setTenantCookie(cookieString);
        System.out.println(cookieString);
    }

    @When("playwright get tenant data profile")
    public void playwrightGetTenantDataProfile() {
        //headers.put("Accept", "application/json");
        headers.put("Cookie", UserCookies.getTenantCookie());
        headers.put("X-GIT-Time", ApiEndpoints.X_GIT_TIME);
        request = ApiPlaywrightHelpers.setBaseUrlAndHeaders(Mamikos.URL, headers);
        apiResponse = request.get(ApiEndpoints.TENANT_PROFILE);
        System.out.println(apiResponse.status());
        System.out.println(apiResponse.text());
        System.out.println(apiResponse.ok());
    }

    @When("playwright make json file for tenant booking from tenant profile data")
    public void playwrightMakeJsonFileForTenantBookingFromTenantProfileData() {
        String todayDate = JavaHelpers.getCostumDateOrTime("yyyy-MM-dd", 0, 0, 0);
        String plusOneMonthDate = JavaHelpers.getCostumDateOrTime("yyyy-MM-dd", 0, 1, 0);
//        String jsonString = apiResponse.text();
//
//        try {
//            // Parse JSON string to JSON object
//            ObjectMapper objectMapper = new ObjectMapper();
//            Object json = objectMapper.readValue(jsonString, Object.class);
//
//            // Write JSON object to file
//            File outputFile = new File("target/output1.json");
//            objectMapper.writeValue(outputFile, json);
//
//            System.out.println("JSON file created successfully.");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try {
            JsonElement jsonElement = JsonParser.parseReader(new FileReader("target/output.json"));
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            JsonArray dataArray = jsonObject.getAsJsonArray("data");

            JsonObject dataObject = dataArray.get(0).getAsJsonObject();
            JsonObject profileObject = jsonObject.getAsJsonObject("profile");
            String gender = profileObject.get("gender").getAsString().toLowerCase()
                    .equalsIgnoreCase("laki-laki") ? "male" : "female";
            boolean isMarried = false;
            boolean isMarriedNull = false;
            if (profileObject.get("marital_status").isJsonNull()) {
                System.out.println("saya ke sini karena marital status isNull");
                isMarried = false;
                isMarriedNull = true;
            }

            if (!isMarriedNull) {
                System.out.println(profileObject.get("marital_status"));
                System.out.println(profileObject.get("marital_status").getAsString()
                        .equalsIgnoreCase("belum kawin"));
                isMarried = !profileObject.get("marital_status").getAsString()
                        .equalsIgnoreCase("belum kawin");
                System.out.println(isMarried);
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
            CreateBooking.setContactJob(dataObject.get("description").getAsString());
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
        } catch (IOException e) {
            e.printStackTrace();
        }

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
        Gson gson = new Gson();
        String jsonData = gson.toJson(createBookingBody);
        System.out.println(jsonData);
    }
}
