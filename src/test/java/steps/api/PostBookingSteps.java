package steps.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Request;
import com.microsoft.playwright.options.Cookie;
import com.microsoft.playwright.options.RequestOptions;
import config.playwright.context.ActiveContext;
import data.api.CreateBooking;
import data.api.UserCookies;
import data.mamikos.ApiEndpoints;
import data.mamikos.Mamikos;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utilities.ApiPlaywrightHelpers;
import utilities.JavaHelpers;
import utilities.JsonHelpers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostBookingSteps {
    private Page page = ActiveContext.getActivePage();
    private Map<String, String> createBookingHeaders = new HashMap<>();
    private APIRequestContext createBookingRequest;
    private APIResponse createBookingResponse;
    private Map<Object, Object> createBookingBody = new HashMap<>();
    private ApiPlaywrightHelpers apiHelpers = new ApiPlaywrightHelpers(page);

    @When("playwright create booking for tenant")
    public void playwrightCreateBookingForTenant() {
//        String createBookingEndpoints = JavaHelpers.formatString(ApiEndpoints.CREATE_BOOKING, "{roomId}", "39645784");
//        createBookingEndpoints =  JavaHelpers.formatString(createBookingEndpoints, "{roomTypeId}", "6230");
        System.out.println(ApiEndpoints.CREATE_BOOKING);
        createBookingBody = CreateBooking.getCreateBookingBody();
        System.out.println(createBookingBody);
        createBookingHeaders.put("Accept", "application/json");
        createBookingHeaders.put("Cookie", UserCookies.getTenantCookie());
        createBookingHeaders.put("X-GIT-Time", ApiEndpoints.X_GIT_TIME);
        createBookingResponse = apiHelpers.setBaseUrlAndHeaders("https://jambu.kerupux.com", createBookingHeaders).post("/garuda/user/booking/39645784/6230", RequestOptions.create().setData(createBookingBody));
        System.out.println(createBookingResponse.url());
        System.out.println(createBookingResponse.text());
        System.out.println(createBookingResponse.status());
        page.pause();
    }
}
