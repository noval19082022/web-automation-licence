package steps.api;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import data.api.CreateDeviceId;
import data.mamikos.ApiEndpoints;
import data.mamikos.Mamikos;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utilities.ApiPlaywrightHelpers;
import utilities.JavaHelpers;
import utilities.JsonHelpers;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class CreateDeviceIdAndLogin {
    private APIRequestContext request;
    private APIResponse apiResponse;
    private Map<String, String> createDeviceIdTable;
    private Map<Object, Object> loginBody = new HashMap<>();

    @When("playwright create register device id for tenant/owner with parameters:")
    public void playwrightCreateRegisterDeviceIdForTenantWithParameters(DataTable table) {
        createDeviceIdTable = table.asMap(String.class, String.class);
        CreateDeviceId.setDeviceIdentifier(createDeviceIdTable.get("device_identifier"));
        CreateDeviceId.setDeviceUuid(createDeviceIdTable.get("device_uuid"));
        CreateDeviceId.setDevicePlatform(createDeviceIdTable.get("device_platform"));
        CreateDeviceId.setPhoneNumber(createDeviceIdTable.get("phone_number"));
        CreateDeviceId.setPassword(createDeviceIdTable.get("password"));
        request = ApiPlaywrightHelpers.setBaseUrl(Mamikos.URL);
        apiResponse = request.post(ApiEndpoints.V1_PREFIX + ApiEndpoints.CREATE_DEVICE_ID,
            RequestOptions.create()
                .setQueryParam("device_identifier", CreateDeviceId.getDeviceIdentifier())
                .setQueryParam("device_uuid", CreateDeviceId.getDeviceUuid())
                .setQueryParam("device_platform", CreateDeviceId.getDevicePlatform()));

        System.out.println(apiResponse.url());
        Assert.assertEquals(apiResponse.status(), 200);

        // Create json file from api response
        JsonHelpers.createJsonFileFromJsonString(apiResponse.text(), "target/createDeviceId"+CreateDeviceId.getDeviceIdentifier()+".json");
        JsonElement registeredDeviceId = JsonHelpers.createJsonElementFromJsonFile("target/createDeviceId"+CreateDeviceId.getDeviceIdentifier()+".json");
        JsonObject registerObject = registeredDeviceId.getAsJsonObject().getAsJsonObject("register");
        CreateDeviceId.setDeviceId(registerObject.get("device_id").getAsString());
        CreateDeviceId.setDeviceToken(registerObject.get("device_token").getAsString());
        System.out.println("Device token is: " + CreateDeviceId.getDeviceToken());
        System.out.println("Device ID is : " + CreateDeviceId.getDeviceId());
    }

    @When("tenant login trough api")
    public void tenantLoginTroughApi() throws NoSuchAlgorithmException {
        var md5Password = JavaHelpers.generateMd5(CreateDeviceId.getPassword());
        loginBody.put("phone_number", CreateDeviceId.getPhoneNumber());
        loginBody.put("device_identifier", CreateDeviceId.getDeviceIdentifier());
        loginBody.put("device_uuid", CreateDeviceId.getDeviceUuid());
        loginBody.put("device_platform", CreateDeviceId.getDevicePlatform());
        apiResponse = request.post(ApiEndpoints.V1_PREFIX + ApiEndpoints.TENANT_LOGIN, RequestOptions.create().setData(loginBody).setQueryParam("password", md5Password));
        System.out.println(apiResponse.url());
        Assert.assertEquals(apiResponse.status(), 200);
        System.out.println("Login response is: " + apiResponse.text());
    }

    @When("owner login trough api")
    public void ownerLoginTroughApi() throws NoSuchAlgorithmException {
        var md5Password = JavaHelpers.generateMd5(CreateDeviceId.getPassword());
        loginBody.put("phone_number", CreateDeviceId.getPhoneNumber());
        loginBody.put("device_identifier", CreateDeviceId.getDeviceIdentifier());
        loginBody.put("device_uuid", CreateDeviceId.getDeviceUuid());
        loginBody.put("device_platform", CreateDeviceId.getDevicePlatform());
        apiResponse = request.post(ApiEndpoints.V1_PREFIX + ApiEndpoints.OWNER_LOGIN, RequestOptions.create().setData(loginBody).setQueryParam("password", md5Password));
        System.out.println(apiResponse.url());
        Assert.assertEquals(apiResponse.status(), 200);
        System.out.println(apiResponse.text());
    }
}
