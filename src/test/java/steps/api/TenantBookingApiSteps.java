package steps.api;

import api.Requirement;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import data.api.AjukanSewaStatus;
import data.api.CreateDeviceId;
import data.mamikos.ApiEndpoints;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import utilities.ApiPlaywrightHelpers;
import utilities.JavaHelpers;
import utilities.JsonHelpers;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TenantBookingApiSteps {
    private APIRequestContext requestTenantBookingStatus, batalkanPengajuanSewaRequest;
    private APIResponse tenantBookingStatusResponse, batalkanPengajuanSewaResponse;
    private Map<Object, Object> batalkanBookingBody = new HashMap<>();
    private Map<String, String> dataTable;
    private List<String> booked = new ArrayList<>(), confirmed = new ArrayList<>(), verified = new ArrayList<>(), checkedIn = new ArrayList<>();

    @Then("playwright get tenant booking status with parameter:")
    public void playwrightGetTenantBookingStatusWithParameter(DataTable table) throws NoSuchAlgorithmException, InvalidKeyException {
        dataTable = table.asMap(String.class, String.class);
        var page = dataTable.get("page") == null ? "" : dataTable.get("page");
        var sort = dataTable.get("sort") == null ? "" : dataTable.get("sort");
        var status = dataTable.get("status") == null ? "" : dataTable.get("status");
        var bookingStatusEndpoint = ApiEndpoints.V1_PREFIX + ApiEndpoints.TENANT_BOOKING_LIST;
        var bookingStatusTargetPath = "target/tenantBookingStatus"+ CreateDeviceId.getPhoneNumber()+".json";
        requestTenantBookingStatus = ApiPlaywrightHelpers.setBaseUrl(ApiEndpoints.STAGING, Requirement.mamikosStandardHeaders(Requirement.createSignatureKey("GET", bookingStatusEndpoint)));
        tenantBookingStatusResponse = requestTenantBookingStatus.get(bookingStatusEndpoint, RequestOptions.create()
            .setQueryParam("page", page).setQueryParam("sort", sort).setQueryParam("status", status)
            .setQueryParam("devel_access_token", ApiEndpoints.DEVEL_ACCESS_TOKEN));
        System.out.println(tenantBookingStatusResponse.url());
        Assert.assertEquals(tenantBookingStatusResponse.status(), 200);
        Assert.assertTrue(tenantBookingStatusResponse.ok());
        System.out.println("apiResponse.text() = " + tenantBookingStatusResponse.text());
        JsonHelpers.createJsonFileFromJsonString(tenantBookingStatusResponse.text(), bookingStatusTargetPath);
        JsonObject tenantBookingStatus = JsonHelpers.createJsonElementFromJsonFile(bookingStatusTargetPath).getAsJsonObject();
        JsonObject tenantBookingStatusData = JsonHelpers.createJsonObject(tenantBookingStatus.get("data"));
        JsonArray tenantBookingStatusJsonArray = JsonHelpers.createJsonArray(tenantBookingStatusData, "data");
        if (!tenantBookingStatusJsonArray.isEmpty()) {
            for (int i = 0; i < tenantBookingStatusJsonArray.size(); i++) {
                String statusValue = tenantBookingStatusJsonArray.get(i).getAsJsonObject().get("booking_code").getAsString();
                switch (status) {
                    case "booked":
                        booked.add(statusValue);
                        AjukanSewaStatus.setBooked(booked);
                        break;
                    case "confirmed":
                        confirmed.add(statusValue);
                        AjukanSewaStatus.setConfirmed(booked);
                        break;
                    case "verified":
                        verified.add(statusValue);
                        AjukanSewaStatus.setVerified(verified);
                        break;
                    case "checked_in":
                        checkedIn.add(statusValue);
                        AjukanSewaStatus.setCheckedIn(checkedIn);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + status);
                }
            }
        }
        System.out.println("AjukanSewaStatus.getBooked() = " + AjukanSewaStatus.getBooked());
        System.out.println("AjukanSewaStatus.getConfirmed() = " + AjukanSewaStatus.getConfirmed());
        System.out.println("AjukanSewaStatus.getVerified() = " + AjukanSewaStatus.getVerified());
        System.out.println("AjukanSewaStatus.getCheckedIn() = " + AjukanSewaStatus.getCheckedIn());
    }

    @Then("playwright batalkan pengajuan sewa for tenant")
    public void playwrightBatalkanPengajuanSewaForTenant() throws NoSuchAlgorithmException, InvalidKeyException {
        batalkanBookingBody.put("cancel_reason", "Mamitest Automation Alasan Lainnya Batalkan Pengajuan Sewa");
        batalkanBookingBody.put("reason_id", null);

        for (int i = 0; i < AjukanSewaStatus.getBooked().size(); i++ ) {
            var bookingId = AjukanSewaStatus.getBooked().get(i);
            var batalkanPengajuanSewaEndpoint = ApiEndpoints.V1_PREFIX + JavaHelpers.formatString(ApiEndpoints.TENANT_BATALKAN_BOOKING, "{bookingId}", bookingId);
            var batalkanPengajuanSewaSignature = Requirement.createSignatureKey("POST", batalkanPengajuanSewaEndpoint);
            var batalkanPengajuanSewaHeaders = Requirement.mamikosStandardHeaders(batalkanPengajuanSewaSignature);
            var batalkanPengajuanSewaRequestOptions = RequestOptions.create().setData(batalkanBookingBody).setQueryParam("devel_access_token", ApiEndpoints.DEVEL_ACCESS_TOKEN);
            batalkanPengajuanSewaRequest = ApiPlaywrightHelpers.setBaseUrl(ApiEndpoints.STAGING, batalkanPengajuanSewaHeaders);
            batalkanPengajuanSewaResponse = batalkanPengajuanSewaRequest.post(batalkanPengajuanSewaEndpoint, batalkanPengajuanSewaRequestOptions);
            System.out.println(batalkanPengajuanSewaResponse.url());
            Assert.assertEquals(batalkanPengajuanSewaResponse.status(), 200);
            Assert.assertTrue(batalkanPengajuanSewaResponse.ok());
            System.out.println("apiResponse.text() = " + batalkanPengajuanSewaResponse.text());
        }
    }
}
