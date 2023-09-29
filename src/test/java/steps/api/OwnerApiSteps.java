package steps.api;

import api.Requirement;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.RequestOptions;
import config.playwright.context.ActiveContext;
import data.api.AcceptBooking;
import data.api.CreateBooking;
import data.mamikos.ApiEndpoints;
import data.mamikos.Mamikos;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utilities.ApiPlaywrightHelpers;
import utilities.JsonHelpers;

import javax.xml.crypto.Data;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OwnerApiSteps {
    private Page page = ActiveContext.getActivePage();
    private Map<String, String> headers = new HashMap<>();
    private APIRequestContext request;
    private APIResponse apiResponse;
    private ApiPlaywrightHelpers apiPwHelpers = new ApiPlaywrightHelpers(page);
    private Map<Object, Object> ownerLoginBody = new HashMap<>();
    private List<Map<String, String>> phoneNumberCredential;
    private String baseUrl = "";
    private String listBookingJson = "";
    private APIRequestContext ownerProfileRequest;
    private APIResponse ownerProfileResponse;
    private Map<String, String> listBookingParams;

    @When("playwright get owner profile")
    public void playwrightGetOwnerProfile() throws NoSuchAlgorithmException, InvalidKeyException {
        var ownerProfileEndpoint = ApiEndpoints.V1_PREFIX + ApiEndpoints.OWNER_PROFILE;
        var signature = Requirement.createSignatureKey("GET", ownerProfileEndpoint);
        ownerProfileRequest = ApiPlaywrightHelpers.setBaseUrl(Mamikos.URL, Requirement.mamikosStandardHeaders(signature));
        ownerProfileResponse = ownerProfileRequest.get(ownerProfileEndpoint, RequestOptions.create().setQueryParam("devel_access_token", ApiEndpoints.DEVEL_ACCESS_TOKEN));
        System.out.println(ownerProfileResponse.url());
        System.out.println(ownerProfileResponse.text());
        Assert.assertEquals(ownerProfileResponse.status(), 200);
        Assert.assertTrue(ownerProfileResponse.ok());
    }

    @When("playwright get owner booking list with parameters:")
    public void playwrightGetOwnerBookingListWithParameters(DataTable table) throws NoSuchAlgorithmException, InvalidKeyException {
        listBookingParams = table.asMap(String.class, String.class);
        var limit = listBookingParams.get("limit") == null ? "" : listBookingParams.get("limit");
        var offset = listBookingParams.get("offset") == null ? "" : listBookingParams.get("offset");
        var group = listBookingParams.get("group") == null ? "" : listBookingParams.get("group");
        var ownerBookingListEndpoint = ApiEndpoints.V1_PREFIX + ApiEndpoints.OWNER_BOOKING_LIST;
        var signature = Requirement.createSignatureKey("GET", ownerBookingListEndpoint, ApiEndpoints.X_GIT_TIME_APP);
        var headers = Requirement.mamikosAppHeaders(signature);
        var ownerBookingListRequest = ApiPlaywrightHelpers.setBaseUrl(ApiEndpoints.PAY_JAMBU, headers);
        var ownerBookingListResponse = ownerBookingListRequest.get(ownerBookingListEndpoint, RequestOptions.create()
                .setQueryParam("limit", limit)
                .setQueryParam("offset", offset)
                .setQueryParam("group[]", group)
                .setQueryParam("access", ApiEndpoints.ACCESS)
                .setQueryParam("devel_access_token", ApiEndpoints.DEVEL_ACCESS_TOKEN));
        System.out.println(ownerBookingListResponse.url());
        System.out.println(ownerBookingListResponse.text());
        Assert.assertEquals(ownerBookingListResponse.status(), 200);
        Assert.assertTrue(ownerBookingListResponse.ok());
        listBookingJson = ownerBookingListResponse.text();
        JsonHelpers.createJsonFileFromJsonString(listBookingJson, "target/ownerBookingList.json");
    }

    @When("playwright create accept booking body for owner")
    public void playwrightCreateAcceptBookingBodyForOwner() {
        JsonElement listBookingJsonElement = JsonHelpers.createJsonElementFromJsonFile("target/ownerBookingList.json");
        JsonObject listBookingJsonObject = JsonHelpers.createJsonObject(listBookingJsonElement);
        JsonArray listBookingData = JsonHelpers.createJsonArray(listBookingJsonObject, "data");
        JsonObject bookingObject = JsonHelpers.createJsonObject(listBookingData.get(0));
        Boolean isMarried = JsonHelpers.getJsonObjectValueAsInt(bookingObject, "is_married") == 0 ? null : bookingObject.get("is_married").getAsBoolean();
        //Boolean isMarried = JsonHelpers
        AcceptBooking.setRoomId(JsonHelpers.getJsonObjectValueAsInt(bookingObject, "room_id"));
        AcceptBooking.setName(JsonHelpers.getJsonObjectValueAsString(bookingObject, "name"));
        AcceptBooking.setPhoneNumber(JsonHelpers.getJsonObjectValueAsString(bookingObject, "phone_number"));
        //later
        AcceptBooking.setRoomNumber(1);
        AcceptBooking.setGender(JsonHelpers.getJsonObjectValueAsString(bookingObject, "gender"));
        AcceptBooking.setEmail(JsonHelpers.getJsonObjectValueAsString(bookingObject, "email"));
        AcceptBooking.setOccupation(JsonHelpers.getJsonObjectValueAsString(bookingObject, "job"));
        //later
        AcceptBooking.setQuestion(Collections.singletonList(""));
        AcceptBooking.setMaritalStatus(isMarried);
        AcceptBooking.setStartDate(JsonHelpers.getJsonObjectValueAsString(bookingObject, "checkin_date"));
        //later
        AcceptBooking.setRentType(JsonHelpers.getJsonObjectValueAsString(bookingObject, "rent_type"));
        AcceptBooking.setAmount(JsonHelpers.getJsonObjectValueAsInt(bookingObject, "remaining_payment"));
        AcceptBooking.setDuration(JsonHelpers.getJsonObjectValueAsInt(bookingObject, "duration_count"));
        //later
        AcceptBooking.setPhotoId(1);
        AcceptBooking.setParentName(JsonHelpers.getJsonObjectValueAsString(bookingObject, "parent_name"));
        AcceptBooking.setParentPhoneNumber(JsonHelpers.getJsonObjectValueAsString(bookingObject, "parent_phone_number"));
        AcceptBooking.setPhotoIdentifierId(JsonHelpers.getJsonObjectValueAsInt(bookingObject, "photo_identifier_id"));
        AcceptBooking.setPhotoDocumentId(JsonHelpers.getJsonObjectValueAsInt(bookingObject, "photo_document_id"));
        //later
        AcceptBooking.setFixedBilling(false);
        //later
        AcceptBooking.setBillingDate(0);
        //later
        AcceptBooking.setFirstAmount(0);
        //later
        AcceptBooking.setDepositAmount(0);
        //later
        AcceptBooking.setFineAmount(0);
        //later
        AcceptBooking.setFineMaximumLength("");
        //later
        AcceptBooking.setFineDurationType("");
        //later
        AcceptBooking.setExistingTenant("");
        //owner_aggerment?
        AcceptBooking.setOwnerAccept(true);
        //later
        AcceptBooking.setAdditionalCosts(Collections.emptyList());
        //later
        AcceptBooking.setSaveCostGroup(false);
        //later
        AcceptBooking.setUseDp(false);
        //later
        AcceptBooking.setDpAmount(0);
        //later
        AcceptBooking.setDpDate(CreateBooking.getCheckIn());
        //later
        AcceptBooking.setDpSettlementDate(CreateBooking.getCheckIn());
        //designer id room available
        AcceptBooking.setDesignerRoomId(309175);
    }
}
