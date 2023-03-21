package pageobject.admin.mamipay.invoiceManual;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class InvoiceManualPO {

    private Page page;

    private Locator buatInvoiceButton;
    private Locator propertyNameText;
    private Locator propertySuggestionText;
    private Locator tenantNameText;
    private Locator tenantNameSuggestionText;
    private Locator noHPTenantText;
    private Locator noKamarTenantText;
    public InvoiceManualPO(Page page){
        buatInvoiceButton = page.getByTestId("create-invoice-btn");
        propertyNameText = page.getByPlaceholder("Masukkan nama listing");
        tenantNameText = page.getByPlaceholder("Masukkan nama penyewa");
        propertySuggestionText = page.locator("(//a[@role='button'])[1]");
        tenantNameSuggestionText = page.locator("(//a[@role='button'])[1]");
        noHPTenantText = page.getByTestId("tenant-phone-number");
        noKamarTenantText = page.getByTestId("tenant-room-number");
    }

    /**
     * Click buat invoice in Invoice Manual
     */
    public void clickBuatInvoice() {
        buatInvoiceButton.click();
    }

    /**
     * Fill listing name in Nama Listing field
     * @param listing
     */
    public void inputListingName(String listing) {
        propertyNameText.click();
        propertyNameText.fill(listing);
        propertySuggestionText.waitFor();
        propertySuggestionText.click();
    }

    /**
     * Fill tenant name in Nama Penyewa field
     * @param tenant
     */
    public void inputTenantName(String tenant) {
        tenantNameText.click();
        tenantNameText.fill(tenant);
        tenantNameSuggestionText.waitFor();
        tenantNameSuggestionText.click();
    }

    /**
     * Assert No HP Penyewa value are equal, and field is disabled
     * @param noHP
     */
    public void assertNoHPTenant(String noHP) {
        assertThat(noHPTenantText).isDisabled();
        assertThat(noHPTenantText).hasValue(noHP);
    }

    /**
     * Assert No Kamar value are equal, and field is disabled
     * @param noKamar
     */
    public void assertNoKamarTenant(String noKamar) {
        assertThat(noKamarTenantText).isDisabled();
        assertThat(noKamarTenantText).hasValue(noKamar);
    }
}
