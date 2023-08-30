package steps.api;

import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.RequestOptions;
import config.playwright.context.ActiveContext;
import data.api.UserCookies;
import data.mamikos.ApiEndpoints;
import data.mamikos.Mamikos;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import utilities.ApiPlaywrightHelpers;
import utilities.JavaHelpers;

import java.util.HashMap;
import java.util.Map;

public class TenantBookingApiSteps {
    private Page page = ActiveContext.getActivePage();
    private Map<String, String> headers = new HashMap<>();
    private APIRequestContext request;
    private APIResponse apiResponse;
    private ApiPlaywrightHelpers apiPwHelpers = new ApiPlaywrightHelpers(page);
    private Map<Object, Object> batalkanBookingBody = new HashMap<>();
    private Map<String, String> dataTable;

    @Then("playwright get tenant booking status with parameter:")
    public void playwrightGetTenantBookingStatusWithParameter(DataTable table) {
        dataTable = table.asMap(String.class, String.class);
        var page = dataTable.get("page");
        var sort = dataTable.get("sort") == null ? "" : dataTable.get("sort");
        var status = dataTable.get("status");
        var bookingListFinalEndpoint = JavaHelpers.formatString(ApiEndpoints.TENANT_BOOKING_LIST, page, sort, status);
        headers.put("Cookie", UserCookies.getTenantCookie());
        headers.put("X-GIT-Time", ApiEndpoints.X_GIT_TIME);
        request = ApiPlaywrightHelpers.setBaseUrlAndHeaders(Mamikos.URL, headers);
        apiResponse = request.get(ApiEndpoints.GARUDA + bookingListFinalEndpoint);
        System.out.println(apiResponse.url());
        Assert.assertEquals(apiResponse.status(), 200);
        Assert.assertTrue(apiResponse.ok());
        System.out.println("apiResponse.text() = " + apiResponse.text());
    }

    @Then("playwright batalkan tenant booking")
    public void playwrightBatalkanTenantBooking() {
        batalkanBookingBody.put("cancel_reason", "Sudah dapat kost lain");
        batalkanBookingBody.put("reason_id", 59);
        apiResponse = request.get(ApiEndpoints.GARUDA + ApiEndpoints.TENANT_BATALKAN_BOOKING_REASON);

        System.out.println(apiResponse.url());
        Assert.assertEquals(apiResponse.status(), 200);
        Assert.assertTrue(apiResponse.ok());
        System.out.println("apiResponse.text() = " + apiResponse.text());
        apiResponse = request.post(ApiEndpoints.GARUDA + ApiEndpoints.TENANT_BATALKAN_BOOKING, RequestOptions.create().setData(batalkanBookingBody));
        System.out.println(apiResponse.url());
        Assert.assertEquals(apiResponse.status(), 200);
        Assert.assertTrue(apiResponse.ok());
        System.out.println("apiResponse.text() = " + apiResponse.text());
    }
}
