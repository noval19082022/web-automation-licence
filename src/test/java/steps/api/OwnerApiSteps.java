package steps.api;

import api.Requirement;
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
    APIRequestContext ownerProfileRequest;
    APIResponse ownerProfileResponse;

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

    @When("playwright create accept booking body for owner")
    public void playwrightCreateAcceptBookingBodyForOwner() throws NoSuchAlgorithmException, InvalidKeyException {
        var ownerBookingListEndpoint = ApiEndpoints.V1_PREFIX + ApiEndpoints.OWNER_BOOKING_LIST;
        var signature = Requirement.createSignatureKey("GET", ownerBookingListEndpoint, ApiEndpoints.X_GIT_TIME_APP);
        var headers = Requirement.mamikosAppHeaders(signature);
        var ownerBookingListRequest = ApiPlaywrightHelpers.setBaseUrl(ApiEndpoints.PAY_JAMBU, headers);
        var ownerBookingListResponse = ownerBookingListRequest.get(ownerBookingListEndpoint, RequestOptions.create()
                .setQueryParam("limit", "1")
                .setQueryParam("offset", "0")
                .setQueryParam("group[]", "0")
                .setQueryParam("access", ApiEndpoints.ACCESS)
                .setQueryParam("devel_access_token", ApiEndpoints.DEVEL_ACCESS_TOKEN));
        System.out.println(ownerBookingListResponse.url());
        System.out.println(ownerBookingListResponse.text());
        Assert.assertEquals(ownerBookingListResponse.status(), 200);
        Assert.assertTrue(ownerBookingListResponse.ok());
        AcceptBooking.setRoomId(1);
        AcceptBooking.setName(CreateBooking.getContactName());
        AcceptBooking.setPhoneNumber(String.valueOf(CreateBooking.getContactPhone()));
        AcceptBooking.setRoomNumber(1);
        AcceptBooking.setGender(CreateBooking.getContactGender());
        AcceptBooking.setEmail("");
        AcceptBooking.setOccupation(CreateBooking.getContactJob());
        AcceptBooking.setQuestion(Collections.singletonList(""));
        AcceptBooking.setMaritalStatus(String.valueOf(CreateBooking.isMarried()));
        AcceptBooking.setStartDate(CreateBooking.getCheckIn());
        AcceptBooking.setRentType(CreateBooking.getRentCountType());
        AcceptBooking.setAmount(10000000);
        AcceptBooking.setDuration(1);
        AcceptBooking.setPhotoId(1);
        AcceptBooking.setParentName("");
        AcceptBooking.setParentPhoneNumber("");
        AcceptBooking.setPhotoIdentifierId(null);
        AcceptBooking.setPhotoDocumentId(null);
        AcceptBooking.setFixedBilling("");
        AcceptBooking.setBillingDate("");
        AcceptBooking.setFirstAmount(0);
        AcceptBooking.setDepositAmount(0);
        AcceptBooking.setFineAmount(0);
        AcceptBooking.setFineMaximumLength("");
        AcceptBooking.setFineDurationType("");
        AcceptBooking.setExistingTenant("");
        AcceptBooking.setOwnerAccept(true);
        AcceptBooking.setAdditionalCosts(Collections.emptyList());
        AcceptBooking.setSaveCostGroup(false);
        AcceptBooking.setUseDp(false);
        AcceptBooking.setDpAmount(0);
        AcceptBooking.setDpDate(CreateBooking.getCheckIn());
        AcceptBooking.setDpSettlementDate(CreateBooking.getCheckIn());
        AcceptBooking.setDesignerRoomId(309175);
    }
}
