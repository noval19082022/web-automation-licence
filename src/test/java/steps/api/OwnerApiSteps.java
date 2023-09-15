package steps.api;

import api.Requirement;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.RequestOptions;
import config.playwright.context.ActiveContext;
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
    public void playwrightCreateAcceptBookingBodyForOwner() {
        System.out.println("playwright create accept booking body for owner");
    }
}
