package steps.api;

import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.Cookie;
import com.microsoft.playwright.options.RequestOptions;
import config.playwright.context.ActiveContext;
import data.mamikos.ApiEndpoints;
import data.mamikos.Mamikos;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import org.testng.Assert;
import utilities.ApiPlaywrightHelpers;

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

    @Given("playwright create owner login auth:")
    public void playwrightCreateOwnerLoginAuth(DataTable table) {
        phoneNumberCredential = table.asMaps(String.class, String.class);
        var phone = phoneNumberCredential.get(0).get("phone "+ Mamikos.ENV);
        var password = phoneNumberCredential.get(0).get("password");
        ownerLoginBody.put("phone_number", phone);
        ownerLoginBody.put("password", password);
        baseUrl = ApiEndpoints.BAKPAO;
        request = apiPwHelpers.setBaseUrl(baseUrl);
        apiResponse = request.post(ApiEndpoints.V1_PREFIX + ApiEndpoints.OWNER_LOGIN, RequestOptions.create().setData(ownerLoginBody));
        Assert.assertEquals(apiResponse.status(), 200);
        Assert.assertTrue(apiResponse.ok());
    }
}
