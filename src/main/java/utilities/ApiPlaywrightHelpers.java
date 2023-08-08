package utilities;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.Cookie;
import config.playwright.PlaywrightSourceManager;

import java.util.List;
import java.util.Map;

public class ApiPlaywrightHelpers {
    private Page page;
    private StringBuilder stringBuilder = new StringBuilder();

    public ApiPlaywrightHelpers(Page page) {
        this.page = page;
    }

    /**
     * Set base URL and headers
     * @param URL base URL
     * @param headers headers
     * @return APIRequestContext
     */
    public static APIRequestContext setBaseUrlAndHeaders(String URL, Map<String, String> headers) {
        return PlaywrightSourceManager.getLocalPlaywright().request().newContext(new APIRequest.NewContextOptions().setBaseURL(URL).setExtraHTTPHeaders(headers));
    }

    /**
     * get cookies list
     * @return List<Cookie>
     */
    public List<Cookie> getCookieList() {
        return page.context().cookies();
    }

    /**
     * Get cookie as string
     * @param cookies List<Cookie>
     * @return String data type
     */
    public String parseCookieToString(List<Cookie> cookies) {
        for (Cookie cookie : cookies) {
            stringBuilder.append(cookie.name);
            stringBuilder.append("=");
            stringBuilder.append(cookie.value);
            stringBuilder.append("; ");
        }
        return stringBuilder.toString();
    }
}
