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
import io.cucumber.java.it.Ma;
import org.testng.Assert;
import utilities.ApiPlaywrightHelpers;
import utilities.JavaHelpers;
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
    private Map<Object, Object> acceptBookingBody = new HashMap<>();
    private Map<String, String> dataTable;
    private Map<Object, Object> roomId = new HashMap<>();

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
        //accept booking details data
        JsonObject ownerBookingAcceptDetailsJson = JsonHelpers.createJsonObject(JsonHelpers.createJsonElementFromJsonFile("target/ownerBookingAcceptDetails.json"));
        JsonObject ownerBookingAcceptDetailData = JsonHelpers.createJsonObject(ownerBookingAcceptDetailsJson.get("data"));
        JsonElement roomAdditionalPriceElement = ownerBookingAcceptDetailData.get("room_additional_price");
        JsonArray roomAdditionalPrice = JsonHelpers.createJsonArray(roomAdditionalPriceElement);
        JsonObject additionalPriceList = JsonHelpers.createJsonObject(roomAdditionalPrice.get(0));
        JsonObject deposit = JsonHelpers.createJsonObject(roomAdditionalPrice.get(2));
        JsonArray depositData = JsonHelpers.createJsonArray(deposit.get("data"));
        JsonObject depositDataObject = JsonHelpers.createJsonObject(depositData.get(0));
        JsonObject fine = JsonHelpers.createJsonObject(roomAdditionalPrice.get(1));
        JsonArray fineData = JsonHelpers.createJsonArray(fine.get("data"));
        JsonElement tenantPhotoDocumentElement = ownerBookingAcceptDetailData.get("tenant_photo_document");
        JsonElement tenantPhotoIdentifierElement = ownerBookingAcceptDetailData.get("tenant_photo_identifier_id");
        var depositAmount = depositData.isEmpty() ? 0 : JsonHelpers.getJsonObjectValueAsInt(depositDataObject, "price");
        var fineAmount = fineData.isEmpty() ? 0 : JsonHelpers.getJsonObjectValueAsInt(fineData.get(0).getAsJsonObject(), "price");
        var tenantPhotoDocumentId = tenantPhotoDocumentElement.isJsonNull() ? 0 : JsonHelpers.getJsonObjectValueAsInt(ownerBookingAcceptDetailData, "tenant_photo_document_id");
        var tenantPhotoIdentifierId = tenantPhotoIdentifierElement.isJsonNull() ? 0 : JsonHelpers.getJsonObjectValueAsInt(ownerBookingAcceptDetailData, "tenant_photo_identifier_id");
        //accept booking details data

        //app flow
        AcceptBooking.setAdditionalCosts(additionalPriceList.get("data").getAsJsonArray());
        AcceptBooking.setAmount(JsonHelpers.getJsonObjectValueAsInt(ownerBookingAcceptDetailData, "amount"));
        AcceptBooking.setDepositAmount(depositAmount);

        //get random id from designer id end point
        AcceptBooking.setDuration(JsonHelpers.getJsonObjectValueAsInt(ownerBookingAcceptDetailData, "duration"));
        AcceptBooking.setEmail(JsonHelpers.getJsonObjectValueAsString(ownerBookingAcceptDetailData, "email"));
        AcceptBooking.setFineAmount(fineAmount);
        AcceptBooking.setFineDurationType("Day");
        AcceptBooking.setFineMaximumLength(0);
        AcceptBooking.setFixedBilling(false);
        AcceptBooking.setGender(JsonHelpers.getJsonObjectValueAsString(ownerBookingAcceptDetailData, "gender"));
        AcceptBooking.setName(JsonHelpers.getJsonObjectValueAsString(ownerBookingAcceptDetailData, "name"));
        AcceptBooking.setOccupation(JsonHelpers.getJsonObjectValueAsString(ownerBookingAcceptDetailData, "occupation"));
        //cari dari mana
        AcceptBooking.setOwnerAccept(JsonHelpers.getJsonObjectValueAsBoolean(ownerBookingAcceptDetailData, "owner_agreement"));
        AcceptBooking.setParentName(JsonHelpers.getJsonObjectValueAsString(ownerBookingAcceptDetailData, "parent_name"));
        AcceptBooking.setParentPhoneNumber(JsonHelpers.getJsonObjectValueAsString(ownerBookingAcceptDetailData, "parent_phone_number"));
        AcceptBooking.setPhoneNumber(JsonHelpers.getJsonObjectValueAsString(ownerBookingAcceptDetailData, "phone_number"));
        //lets check booking detail
        AcceptBooking.setPhotoDocumentId(tenantPhotoDocumentId);
        AcceptBooking.setPhotoId(JsonHelpers.getJsonObjectValueAsInt(ownerBookingAcceptDetailData, "tenant_photo_id"));
        //lets check booking detail
        AcceptBooking.setPhotoIdentifierId(tenantPhotoIdentifierId);
        AcceptBooking.setQuestion(question);
        AcceptBooking.setRentType(AcceptBooking.rentType(JsonHelpers.getJsonObjectValueAsString(ownerBookingAcceptDetailData, "rent_type")));
        AcceptBooking.setRoomId(JsonHelpers.getJsonObjectValueAsInt(ownerBookingAcceptDetailData, "room_id"));
        AcceptBooking.setSaveCostGroup(false);
        AcceptBooking.setStartDate(JsonHelpers.getJsonObjectValueAsString(ownerBookingAcceptDetailData, "start_date"));
        //app
    }

    @When("playwright get owner room booking detail")
    public void playwrightGetOwnerRoomBookingDetail() throws NoSuchAlgorithmException, InvalidKeyException {
        var ownerRoomBookingDetailEndpoint = ApiEndpoints.V1_PREFIX + ApiEndpoints.OWNER_ROOM_BOOKING_DETAIL;
        var signature = Requirement.createSignatureKey("GET", ownerRoomBookingDetailEndpoint, ApiEndpoints.X_GIT_TIME_APP);
        var headers = Requirement.mamikosAppHeaders(signature);
        var ownerRoomBookingDetailRequest = ApiPlaywrightHelpers.setBaseUrl(ApiEndpoints.PAY_JAMBU, headers);
        var ownerRoomBookingDetailResponse = ownerRoomBookingDetailRequest.get(ownerRoomBookingDetailEndpoint, RequestOptions.create()
                .setQueryParam("booking_id", 77492)
                .setQueryParam("access", ApiEndpoints.ACCESS)
                .setQueryParam("devel_access_token", ApiEndpoints.DEVEL_ACCESS_TOKEN));
        System.out.println(ownerRoomBookingDetailResponse.url());
        System.out.println(ownerRoomBookingDetailResponse.text());
        Assert.assertEquals(ownerRoomBookingDetailResponse.status(), 200);
        Assert.assertTrue(ownerRoomBookingDetailResponse.ok());
    }

    @When("playwright create body accept booking for owner")
    public void playwrightCreateBodyAcceptBookingForOwner() {
        acceptBookingBody.put("additional_costs", AcceptBooking.getAdditionalCosts());
        acceptBookingBody.put("amount", AcceptBooking.getAmount());
        acceptBookingBody.put("deposit_amount", AcceptBooking.getDepositAmount());
        acceptBookingBody.put("designer_room_id", AcceptBooking.getDesignerRoomId());
        acceptBookingBody.put("duration", AcceptBooking.getDuration());
        acceptBookingBody.put("email", AcceptBooking.getEmail());
        acceptBookingBody.put("fine_amount", AcceptBooking.getFineAmount());
        acceptBookingBody.put("fine_duration_type", AcceptBooking.getFineDurationType());
        acceptBookingBody.put("fine_maximum_length", AcceptBooking.getFineMaximumLength());
        acceptBookingBody.put("fixed_billing", AcceptBooking.isFixedBilling());
        acceptBookingBody.put("gender", AcceptBooking.getGender());
        acceptBookingBody.put("name", AcceptBooking.getName());
        acceptBookingBody.put("occupation", AcceptBooking.getOccupation());
        acceptBookingBody.put("owner_accept", AcceptBooking.isOwnerAccept());
        acceptBookingBody.put("parent_name", AcceptBooking.getParentName());
        acceptBookingBody.put("parent_phone_number", AcceptBooking.getParentPhoneNumber());
        acceptBookingBody.put("phone_number", AcceptBooking.getPhoneNumber());
        acceptBookingBody.put("photo_document_id", AcceptBooking.getPhotoDocumentId());
        acceptBookingBody.put("photo_id", AcceptBooking.getPhotoId());
        acceptBookingBody.put("photo_identifier_id", AcceptBooking.getPhotoIdentifierId());
        acceptBookingBody.put("question", AcceptBooking.getQuestion());
        acceptBookingBody.put("rent_type", AcceptBooking.getRentType());
        acceptBookingBody.put("room_id", AcceptBooking.getRoomId());
        acceptBookingBody.put("save_cost_group", AcceptBooking.isSaveCostGroup());
        acceptBookingBody.put("start_date", AcceptBooking.getStartDate());
        var acceptBookingBodyJsonString = JsonHelpers.createJsonStringFromMap(acceptBookingBody);
        JsonHelpers.createJsonFileFromJsonString(acceptBookingBodyJsonString, "target/acceptBookingBody" + AcceptBooking.getBookingId() + ".json");
    }

    @When("playwright get owner booking accept details")
    public void playwrightGetOwnerBookingAcceptDetails() throws NoSuchAlgorithmException, InvalidKeyException {
        var ownerBookingAcceptDetailsSafeFilePath = "target/ownerBookingAcceptDetails.json" + AcceptBooking.getBookingId();
        var ownerBookingAcceptDetailsEndpoint = ApiEndpoints.V1_PREFIX + ApiEndpoints.OWNER_BOOKING_ACCEPT + AcceptBooking.getBookingId();
        var signature = Requirement.createSignatureKey("GET", ownerBookingAcceptDetailsEndpoint, ApiEndpoints.X_GIT_TIME_APP);
        var headers = Requirement.mamikosAppHeaders(signature);
        var ownerBookingAcceptDetailsRequest = ApiPlaywrightHelpers.setBaseUrl(ApiEndpoints.PAY_JAMBU, headers);
        var ownerBookingAcceptDetailsResponse = ownerBookingAcceptDetailsRequest.get(ownerBookingAcceptDetailsEndpoint, RequestOptions.create()
                .setQueryParam("access", ApiEndpoints.ACCESS)
                .setQueryParam("devel_access_token", ApiEndpoints.DEVEL_ACCESS_TOKEN));
        System.out.println(ownerBookingAcceptDetailsResponse.url());
        System.out.println(ownerBookingAcceptDetailsResponse.text());
        Assert.assertEquals(ownerBookingAcceptDetailsResponse.status(), 200);
        Assert.assertTrue(ownerBookingAcceptDetailsResponse.ok());
        JsonHelpers.createJsonFileFromJsonString(ownerBookingAcceptDetailsResponse.text(), ownerBookingAcceptDetailsSafeFilePath);
    }

    @When("playwright get owner available room for kos with id:")
    public void playwrightGetOwnerAvailableRoomForKosWithId(DataTable table) throws NoSuchAlgorithmException, InvalidKeyException {
        dataTable = table.asMap(String.class, String.class);
        var kosId = dataTable.get("kos id");
        var roomAllotmentSaveFilePath = "target/ownerRoomAllotment" + kosId + ".json";
        var startDate = JavaHelpers.getCostumDateOrTime("yyyy-MM-dd", 0, 0, 0);
        var endDate = JavaHelpers.getCostumDateOrTime("yyyy-MM-dd", 0, 1, 0);
        var ownerRoomAllotmentEndpoint = ApiEndpoints.V1_PREFIX + ApiEndpoints.OWNER_ROOM_ALLOTMENT + kosId;
        var signature = Requirement.createSignatureKey("GET", ownerRoomAllotmentEndpoint, ApiEndpoints.X_GIT_TIME_APP);
        var ownerRoomAllotmentRequest = ApiPlaywrightHelpers.setBaseUrl(ApiEndpoints.PAY_JAMBU, Requirement.mamikosAppHeaders(signature));
        var ownerRoomAllotmentResponse = ownerRoomAllotmentRequest.get(ownerRoomAllotmentEndpoint, RequestOptions.create()
                .setQueryParam("start_date", startDate)
                .setQueryParam("end_date", endDate)
                .setQueryParam("access", ApiEndpoints.ACCESS)
                .setQueryParam("devel_access_token", ApiEndpoints.DEVEL_ACCESS_TOKEN));
        System.out.println("Playwriht hit endpoint: " + ownerRoomAllotmentResponse.url());
        System.out.println(ownerRoomAllotmentResponse.text());
        Assert.assertEquals(ownerRoomAllotmentResponse.status(), 200);
        Assert.assertTrue(ownerRoomAllotmentResponse.ok());
        JsonHelpers.createJsonFileFromJsonString(ownerRoomAllotmentResponse.text(), roomAllotmentSaveFilePath);
    }

    @And("playwright get room allotment or available room for kos with id:")
    public void playwrightGetRoomAllotmentOrAvailableRoomForKosWithId(DataTable table) {
        dataTable = table.asMap(String.class, String.class);
        var kosId = dataTable.get("kos id");
        var roomAllotmentSaveFilePath = "target/ownerRoomAllotment" + kosId + ".json";
        JsonElement ownerRoomAllotmentJson = JsonHelpers.createJsonElementFromJsonFile(roomAllotmentSaveFilePath);
        JsonObject ownerRoomAllotmentData = JsonHelpers.createJsonObject(ownerRoomAllotmentJson.getAsJsonObject().get("data"));
        JsonArray ownerRoomAllotmentAvailableUnits = JsonHelpers.createJsonArray(ownerRoomAllotmentData.get("units"));
        System.out.println("Available units: " + ownerRoomAllotmentAvailableUnits.size());
        JsonObject ownerRoomAllotmentAvailableLastUnit = JsonHelpers.createJsonObject(ownerRoomAllotmentAvailableUnits.get(ownerRoomAllotmentAvailableUnits.size() - 1));
        AcceptBooking.setDesignerRoomId(ownerRoomAllotmentAvailableLastUnit.get("id").getAsInt());
        System.out.println("Designer room id: " + AcceptBooking.getDesignerRoomId());
    }
}
