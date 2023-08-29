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
import data.api.CreateDeviceId;
import data.api.UserCookies;
import data.mamikos.ApiEndpoints;
import data.mamikos.Mamikos;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utilities.ApiPlaywrightHelpers;
import utilities.JavaHelpers;
import utilities.JsonHelpers;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
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
        System.out.println(UserCookies.getTenantCookie());
    }

    @When("playwright get tenant data profile")
    public void playwrightGetTenantDataProfile() throws NoSuchAlgorithmException, InvalidKeyException {
        var tenantProfileEndpoint = ApiEndpoints.V1_PREFIX + ApiEndpoints.TENANT_PROFILE;
        var data = "GET" + " " + tenantProfileEndpoint + " " +  ApiEndpoints.X_GIT_TIME;
        var signature = JavaHelpers.bytesToHexString(JavaHelpers.generateHmacSha256(ApiEndpoints.SECRET_KEY, data));
        headers.put("Authorization", "GIT "+ signature + ":" + CreateDeviceId.getDeviceToken());
        headers.put("X-GIT-Time", ApiEndpoints.X_GIT_TIME);
        headers.put("Content-Type", "application/json");
        tenantProfileRequest = ApiPlaywrightHelpers.setBaseUrlAndHeaders(Mamikos.URL, headers);
        tenantProfileResponse = tenantProfileRequest.get(tenantProfileEndpoint, RequestOptions.create().setQueryParam("devel_access_token", ApiEndpoints.DEVEL_ACCESS_TOKEN));
        System.out.println(tenantProfileResponse.url());
        System.out.println(tenantProfileResponse.text());
        Assert.assertEquals(tenantProfileResponse.status(), 200);
        Assert.assertTrue(tenantProfileResponse.ok());
        CreateBooking.setTenantProfileResponse(tenantProfileResponse.text());
    }
}
