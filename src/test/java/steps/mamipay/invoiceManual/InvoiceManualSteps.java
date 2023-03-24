package steps.mamipay.invoiceManual;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.admin.mamipay.AdminMamipayDashboardPO;
import pageobject.admin.mamipay.invoiceManual.InvoiceManualPO;
import utilities.PlaywrightHelpers;

import java.util.List;
import java.util.Map;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class InvoiceManualSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    private AdminMamipayDashboardPO admin = new AdminMamipayDashboardPO(page);
    private InvoiceManualPO manualInvoice = new InvoiceManualPO(page);

    private List<Map<String, String>> tenantInfo;
    private List<Map<String, String>> tenantDetail;
    @When("admin input nama penyewa in buat invoice manual")
    public void admin_input_nama_penyewa_in_buat_invoice_manual(DataTable tables) {
        String listing = "";
        String tenant = "";

        tenantInfo = tables.asMaps(String.class, String.class);

        if (Mamikos.ENV.equalsIgnoreCase("stag")){
            listing = tenantInfo.get(0).get("property name");
            tenant = tenantInfo.get(0).get("tenant name");
        } else if (Mamikos.ENV.equalsIgnoreCase("prod")) {
            listing = tenantInfo.get(1).get("property name");
            tenant = tenantInfo.get(1).get("tenant name");
        }

        admin.NavigateToMamipayMenu("Invoice Manual");
        manualInvoice.clickBuatInvoice();
        manualInvoice.inputListingName(listing);
        manualInvoice.inputTenantName(tenant);
    }

    @Then("tenant information should be auto fill")
    public void tenant_information_should_be_auto_fill(DataTable tables) {
        String noHP = "";
        String noKamar = "";

        tenantDetail = tables.asMaps(String.class, String.class);

        if (Mamikos.ENV.equalsIgnoreCase("stag")){
            noHP = tenantDetail.get(0).get("No HP");
            noKamar = tenantDetail.get(0).get("No Kamar");
        } else if (Mamikos.ENV.equalsIgnoreCase("prod")) {
            noHP = tenantDetail.get(1).get("No HP");
            noKamar = tenantDetail.get(1).get("No Kamar");
        }

        manualInvoice.assertNoHPTenant(noHP);
        manualInvoice.assertNoKamarTenant(noKamar);
    }
}
