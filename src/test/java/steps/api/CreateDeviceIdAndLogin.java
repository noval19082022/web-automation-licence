package steps.api;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import data.api.CreateDeviceId;
import data.mamikos.ApiEndpoints;
import data.mamikos.Mamikos;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utilities.ApiPlaywrightHelpers;
import utilities.JavaHelpers;
import utilities.JsonHelpers;

import java.util.Map;

public class CreateDeviceIdAndLogin {
    private APIRequestContext request;
    private APIResponse apiResponse;
    private Map<String, String> createDeviceIdTable;

    @When("playwright create register device id for tenant with parameters:")
    public void playwrightCreateRegisterDeviceIdForTenantWithParameters(DataTable table) {
        createDeviceIdTable = table.asMap(String.class, String.class);
        CreateDeviceId.setDeviceIdentifier(createDeviceIdTable.get("device_identifier"));
        CreateDeviceId.setDeviceToken(createDeviceIdTable.get("device_uuid"));
        CreateDeviceId.setDevicePlatform(createDeviceIdTable.get("device_platform"));
        var createDeviceIdFinalEndpoint = JavaHelpers.formatString(ApiEndpoints.CREATE_DEVICE_ID, CreateDeviceId.getDeviceIdentifier(), CreateDeviceId.getDeviceToken(), CreateDeviceId.getDevicePlatform());
        request = ApiPlaywrightHelpers.setBaseUrl(Mamikos.URL);
        apiResponse = request.post(ApiEndpoints.V1_PREFIX + createDeviceIdFinalEndpoint);
        Assert.assertEquals(apiResponse.status(), 200);
        JsonHelpers.createJsonFileFromJsonString(apiResponse.text(), "target/createDeviceId"+CreateDeviceId.getDeviceIdentifier()+".json");
        JsonElement registeredDeviceId = JsonHelpers.createJsonElementFromJsonFile("target/createDeviceId"+CreateDeviceId.getDeviceIdentifier()+".json");
        JsonObject registerObject = registeredDeviceId.getAsJsonObject().getAsJsonObject("register");
        CreateDeviceId.setDeviceId(registerObject.get("device_id").getAsString());
        CreateDeviceId.setDeviceToken(registerObject.get("device_token").getAsString());
        System.out.println("Device token is: " + CreateDeviceId.getDeviceToken());
        System.out.println("Device ID is : " + CreateDeviceId.getDeviceId());
    }
}
