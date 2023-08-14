package steps.mamikos.admin;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.admin.mamipay.AdminMamipayDashboardPO;
import pageobject.admin.mamipay.SearchInvoicePO;
import pageobject.admin.mamipay.invoice.MamikosListInvoicePO;
import utilities.PlaywrightHelpers;

import java.util.List;

public class SearchInvoiceSteps {
    private Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);

    private AdminMamipayDashboardPO admin = new AdminMamipayDashboardPO(page);
    private MamikosListInvoicePO invoicePO = new MamikosListInvoicePO(page);
    private SearchInvoicePO searchInvoice = new SearchInvoicePO(page);

    @When("admin want to reactivate invoice by invoice number {string}")
    public void reactivateInvoice(String invoiceNumber) {
        admin.clickOnTextHyperlink("Search Invoice");
        invoicePO.selectSearchInvoiceBy("Invoice Number");
        invoicePO.fillInputSearchValue(invoiceNumber);
        invoicePO.clickOnCariInvoice();
        // change to unpaid
        admin.clickOnTextHyperlink("Change Status");
        // unpaid
        invoicePO.setStatusPaidOrUnpaid("unpaid");
        // date
        invoicePO.setDate("2021-02-04 16:35:11");
        admin.clickOnTextHyperlink("Submit Change");
        // change to paid to activate the invoice
        admin.clickOnTextHyperlink("Change Status");
        // paid
        invoicePO.setStatusPaidOrUnpaid("paid");
        // date
        invoicePO.setDate("2021-02-04 16:35:11");
        admin.clickOnTextHyperlink("Submit Change");
    }


    @And("user select {string} on auto extend selection")
    public void user_select_on_auto_extend_selection(String item) {
        searchInvoice.selectOnAutoExtendSelection(item);
    }

    @And("user click search invoice button on search invoice admin page")
    public void userClickSearchInvoiceButtonOnSearchInvoiceAdminPage() {
        searchInvoice.clickOnSearchInvoiceButton();
    }

    @Then("user verify search invoice results have auto extend {string}, {string}")
    public void userVerifySearchInvoiceResultsHaveAutoExtend(String value, String status) {
        for (int i = 0; i < searchInvoice.getResultsElement(value,status).size(); i++) {
            Assert.assertTrue(searchInvoice.isSearchInvoiceResultsHaveAutoExtendCorrectValue(value, status, i), "Auto extend value is not appeared as " + value);
            Assert.assertEquals(searchInvoice.getAutoExtendValueOfSearchInvoiceResults(value, status, i), value, "Auto extend value is not equal to " + value);
        }
    }

    @And("admin clicks on see log button with link value {string}")
    public void adminClicksOnSeeLogButtonWithLinkValue(String link) {
        searchInvoice.clickOnSeeLogButton(link);
    }

    @Then("admin verify invoice log has {string} as {string}")
    public void adminVerifyInvoiceLogHasAs(String biliingReminder, String reminderType) {
        Assert.assertEquals(searchInvoice.getBiliingReminderTypeTableValue(biliingReminder), biliingReminder, "Billing reminder is not equal to " + biliingReminder);
        Assert.assertEquals(searchInvoice.getReminderTypeTableText(reminderType), reminderType, "Billing reminder type is not equal to " + reminderType);
    }

    @And("user verify PN Template content with {string}")
    public void userVerifyPNTemplateContentWith(String content) {
        Assert.assertEquals(searchInvoice.getTableContentTemplate(content), content, "Content Table is not equal to " + content);
    }

    @Then("admin verify PN reminder status information")
    public void admin_verify_PN_reminder_status_information(DataTable dataTable) {
        List<List<String>> list = dataTable.asLists(String.class);
        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(searchInvoice.getTableHeadData(i), list.get(0).get(i), "Table head text is not equal to " + list.get(0).get(i));
            for (int j = 0; j < list.size(); j++) {
                Assert.assertEquals(searchInvoice.getPushNotifTableData(j), list.get(1).get(j), "Push notif table data is not equal to " + list.get(1).get(j));
            }
        }
    }

    @Then("admin verify WhatsApp reminder status information")
    public void admin_verify_WhatsApp_reminder_status_information(DataTable dataTable) {
        List<List<String>> list = dataTable.asLists(String.class);
        for (int i = 0; i < list.get(0).size(); i++) {
            Assert.assertEquals(searchInvoice.getTableHeadData(i), list.get(0).get(i), "Table head text is not equal to " + list.get(0).get(i));
            for (int j = 0; j < list.get(1).size(); j++) {
                Assert.assertEquals(searchInvoice.getWhatsAppTableData(j), list.get(1).get(j), "WhatsApp table data is not equal to " + list.get(1).get(j));
            }
        }
    }

    @And("admin bangkerupux want to search invoice by {string} and input field {string}")
    public void adminBangkerupuxWantToSearchInvoiceByAndInputField(String searchBy, String inputField) {
        admin.clickOnTextHyperlink("Search Invoice");
        invoicePO.selectSearchInvoiceBy(searchBy);
        invoicePO.fillInputSearchValue(inputField);
        invoicePO.clickOnCariInvoice();
    }

    @And("admin bangkerupux click on shorlink invoice on invoice list {string}")
    public void adminBangkerupuxClickOnShorlinkInvoiceOnInvoiceList(String link) {
        admin.clickOnTextHyperlink(link);
        ActiveContext.setActivePage(ActiveContext.getActiveBrowserContext().pages().get(1));
    }
}
