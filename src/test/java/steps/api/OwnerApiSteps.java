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
import java.util.*;

public class OwnerApiSteps {
    private String listBookingJson = "";
    private APIRequestContext ownerProfileRequest;
    private APIResponse ownerProfileResponse;
    private Map<String, String> listBookingParams;
    private List<Map<String, String>> question = new ArrayList<>();

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

    @When("playwright set accept booking data for owner")
    public void playwrightSetAcceptBookingDataForOwner() {
        JsonElement listBookingJsonElement = JsonHelpers.createJsonElementFromJsonFile("target/ownerBookingList.json");
        JsonObject listBookingJsonObject = JsonHelpers.createJsonObject(listBookingJsonElement);
        JsonArray listBookingData = JsonHelpers.createJsonArray(listBookingJsonObject, "data");
        JsonObject bookingObject = JsonHelpers.createJsonObject(listBookingData.get(0));
        //app flow
        //later
        AcceptBooking.setAdditionalCosts(Collections.emptyList());
        AcceptBooking.setAmount(JsonHelpers.getJsonObjectValueAsInt(bookingObject, "remaining_payment"));
        AcceptBooking.setDepositAmount(0);
        //get random id from designer id end point
        AcceptBooking.setDesignerRoomId(309175);
        AcceptBooking.setDuration(JsonHelpers.getJsonObjectValueAsInt(bookingObject, "duration_count"));
        AcceptBooking.setEmail(JsonHelpers.getJsonObjectValueAsString(bookingObject, "email"));
        AcceptBooking.setFineAmount(0);
        AcceptBooking.setFineDurationType("Day");
        AcceptBooking.setFineMaximumLength(0);
        AcceptBooking.setFixedBilling(false);
        AcceptBooking.setGender(JsonHelpers.getJsonObjectValueAsString(bookingObject, "gender"));
        AcceptBooking.setName(JsonHelpers.getJsonObjectValueAsString(bookingObject, "name"));
        AcceptBooking.setOccupation(JsonHelpers.getJsonObjectValueAsString(bookingObject, "job"));
        //cari dari mana
        AcceptBooking.setOwnerAccept(true);
        AcceptBooking.setParentName(JsonHelpers.getJsonObjectValueAsString(bookingObject, "parent_name"));
        AcceptBooking.setParentPhoneNumber(JsonHelpers.getJsonObjectValueAsString(bookingObject, "parent_phone_number"));
        AcceptBooking.setPhoneNumber(JsonHelpers.getJsonObjectValueAsString(bookingObject, "phone_number"));
        //lets check booking detail
        AcceptBooking.setPhotoDocumentId(0);
        AcceptBooking.setPhotoId(62255);
        //lets check booking detail
        AcceptBooking.setPhotoIdentifierId(0);
        AcceptBooking.setQuestion(question);
        AcceptBooking.setRentType(AcceptBooking.rentType(JsonHelpers.getJsonObjectValueAsString(bookingObject, "duration_type")));
        AcceptBooking.setRoomId(JsonHelpers.getJsonObjectValueAsInt(bookingObject, "room_id"));
        AcceptBooking.setSaveCostGroup(false);
        AcceptBooking.setStartDate(JsonHelpers.getJsonObjectValueAsString(bookingObject, "checkin_date"));
        //app
    }
}
