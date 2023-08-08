package steps.api;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.Cookie;
import config.playwright.context.ActiveContext;
import data.api.UserCookies;
import data.mamikos.ApiEndpoints;
import data.mamikos.Mamikos;
import io.cucumber.java.en.When;
import utilities.ApiPlaywrightHelpers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetCookiesSteps {
    private Page page = ActiveContext.getActivePage();
    private List<Cookie> cookieList;
    private String cookieString;
    private Map<String, String> headers = new HashMap<>();
    private APIRequestContext request;
    private APIResponse apiResponse;
    private ApiPlaywrightHelpers apiPwHelpers = new ApiPlaywrightHelpers(page);

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
}
