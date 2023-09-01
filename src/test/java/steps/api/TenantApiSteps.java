package steps.api;

import api.Requirement;
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
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utilities.ApiPlaywrightHelpers;
import utilities.JsonHelpers;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TenantApiSteps {
    private Page page = ActiveContext.getActivePage();
    private List<Cookie> cookieList;
    private String cookieString;
    private Map<String, String> headers = new HashMap<>();
    private APIRequestContext tenantProfileRequest;
    private APIResponse tenantProfileResponse;
    private ApiPlaywrightHelpers apiPwHelpers = new ApiPlaywrightHelpers(page);
    private Map<Object, Object> createBookingBody = new HashMap<>();
    private Map<String, String> roomIdOrSongId = new HashMap<>();

    @When("playwright collect tenant cookies")
    public void playwrightCollectTenantCookies() {
        cookieList = apiPwHelpers.getCookieList();
        cookieString = apiPwHelpers.parseCookieToString(cookieList);
        UserCookies.setTenantCookie(cookieString);
        System.out.println(UserCookies.getTenantCookie());
    }

    @When("playwright get tenant data profile")
    public void playwrightGetTenantDataProfile() throws NoSuchAlgorithmException, InvalidKeyException {
        var tenantProfileEndpoint = ApiEndpoints.V1_PREFIX + ApiEndpoints.TENANT_PROFILE;
        var signature = Requirement.createSignatureKey("GET", tenantProfileEndpoint);
        tenantProfileRequest = ApiPlaywrightHelpers.setBaseUrl(Mamikos.URL, Requirement.mamikosStandardHeaders(signature));
        tenantProfileResponse = tenantProfileRequest.get(tenantProfileEndpoint, RequestOptions.create().setQueryParam("devel_access_token", ApiEndpoints.DEVEL_ACCESS_TOKEN));
        System.out.println(tenantProfileResponse.url());
        System.out.println(tenantProfileResponse.text());
        Assert.assertEquals(tenantProfileResponse.status(), 200);
        Assert.assertTrue(tenantProfileResponse.ok());
        CreateBooking.setTenantProfileResponse(tenantProfileResponse.text());
    }

    @When("playwright get kos detail:")
    public void playwrightGetKosDetail(DataTable table) throws NoSuchAlgorithmException, InvalidKeyException {
        roomIdOrSongId = table.asMap(String.class, String.class);
        var roomId = roomIdOrSongId.get("songId");
        var kosDetailEndpoint = ApiEndpoints.V1_PREFIX + ApiEndpoints.KOS_DETAIL + "/" + roomIdOrSongId.get("songId");
        var signature = Requirement.createSignatureKey("GET", kosDetailEndpoint);
        tenantProfileRequest = ApiPlaywrightHelpers.setBaseUrl(Mamikos.URL, Requirement.mamikosStandardHeaders(signature));
        tenantProfileResponse = tenantProfileRequest.get(kosDetailEndpoint, RequestOptions.create().setQueryParam("devel_access_token", ApiEndpoints.DEVEL_ACCESS_TOKEN));
        System.out.println(tenantProfileResponse.url());
        Assert.assertTrue(tenantProfileResponse.ok());

        JsonHelpers.createJsonFileFromJsonString(tenantProfileResponse.text(), "target/tenantProfile"+roomId+".json");
        JsonElement kosDetailJson = JsonHelpers.createJsonElementFromJsonFile("target/tenantProfile"+roomId+".json");
        JsonObject kosDetailObject = JsonHelpers.createJsonObject(kosDetailJson);
        JsonObject dataObject = JsonHelpers.createJsonObject(kosDetailObject.get("data"));
        JsonObject roomObject = JsonHelpers.createJsonObject(dataObject.get("room"));
        CreateBooking.setFlashSale(roomObject.get("is_flash_sale").getAsBoolean());
        CreateBooking.setDownPaymentActive(roomObject.get("down_payment_is_active").getAsBoolean());
    }
}
