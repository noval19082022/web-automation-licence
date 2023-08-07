package steps.api;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.Cookie;
import config.playwright.context.ActiveContext;
import data.api.UserCookies;
import io.cucumber.java.en.When;

import java.util.List;

public class GetCookiesSteps {
    private Page page = ActiveContext.getActivePage();
    private List<Cookie> cookieList;
    private StringBuilder stringBuilder = new StringBuilder();
    private String cookieString;

    @When("playwright collect tenant cookies")
    public void playwrightCollectTenantCookies() {
        cookieList = page.context().cookies();
        for (Cookie cookie : cookieList) {
            stringBuilder.append(cookie.name);
            stringBuilder.append("=");
            stringBuilder.append(cookie.value);
            stringBuilder.append("; ");
        }
        cookieString = stringBuilder.toString();
        UserCookies.setTenantCookie(cookieString);
        System.out.println(UserCookies.getTenantCookie());
    }
}
