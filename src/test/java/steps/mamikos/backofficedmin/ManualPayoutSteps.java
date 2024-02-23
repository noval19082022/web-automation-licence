package steps.mamikos.backofficedmin;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.admin.mamipay.AdminMamipayDashboardPO;
import pageobject.admin.mamipay.invoice.MamikosListInvoicePO;
import pageobject.admin.mamipay.manualPayout.ManualPayoutPO;
import utilities.PlaywrightHelpers;

public class ManualPayoutSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    private AdminMamipayDashboardPO admin = new AdminMamipayDashboardPO(page);
    private MamikosListInvoicePO invoicePO = new MamikosListInvoicePO(page);
    private ManualPayoutPO manualPayout = new ManualPayoutPO(page);

    @And("admin want to search invoice number in manual payout menu {string}")
    public void adminWantToSearchInvoiceNumberInManualPayoutMenu(String invoiceNumber) {
        admin.clickOnTextHyperlink("Manual Payout");
        invoicePO.selectSearchInvoiceBy("Invoice Number");
        invoicePO.fillInputSearchValue(invoiceNumber);
        manualPayout.clickOnSearchButton();
    }

    @Then("admin will see the search result in manual payout menu is {string}")
    public void adminWillSeeTheSearchResultInManualPayoutMenuIs(String searchResult) {
        manualPayout.getSearchResult(searchResult);
    }

    @And("admin want to search account name in manual payout menu {string}")
    public void adminWantToSearchAccountNameInManualPayoutMenu(String accountName) {
        admin.clickOnTextHyperlink("Manual Payout");
        invoicePO.selectSearchInvoiceBy("Account Name");
        invoicePO.fillInputSearchValue(accountName);
        manualPayout.clickOnSearchButton();
    }

    @And("admin want to search invoice in manual payout menu with select type {string}")
    public void adminWantToSearchInvoiceInManualPayoutMenuWithSelectType(String type) {
        admin.clickOnTextHyperlink("Manual Payout");
        manualPayout.selectInvoiceType(type);
        manualPayout.clickOnSearchButton();
    }

    @And("admin want to search invoice in manual payout menu with select status {string}")
    public void adminWantToSearchInvoiceInManualPayoutMenuWithSelectStatus(String status) {
        admin.clickOnTextHyperlink("Manual Payout");
        manualPayout.selectInvoiceStatus(status);
        manualPayout.clickOnSearchButton();
    }

    @And("admin want to search invoice in manual payout menu with start date from {string} to {string}")
    public void adminWantToSearchInvoiceInManualPayoutMenuWithStartDateFromTo(String startDate, String endDate) {
        admin.clickOnTextHyperlink("Manual Payout");
        manualPayout.fillStartDateValue(startDate);
        manualPayout.fillEndDateValue(endDate);
        manualPayout.clickOnSearchButton();
    }

    @Then("admin verify transaction based on create date from {string} to {string}")
    public void adminVerifyTransactionBasedOnCreateDateFromTo(String createFrom, String createTo) throws InterruptedException {
        manualPayout.vefirytTransactionbyCreateDate(createFrom, createTo);
    }

    @And("admin want to create payout without input the mandatory data")
    public void adminWantToCreatePayoutWithoutInputTheMandatoryData() {
        admin.clickOnTextHyperlink("Manual Payout");
        manualPayout.clickOnCreatePayoutButton();
        manualPayout.clickOnConfirmButton();
    }

    @Then("admin see warning cannot input payout data")
    public void adminSeeWarningCannotInputPayoutData() {
        Assert.assertTrue(manualPayout.isAmountWarningVisible(), "Amount pop up warning is not visible");
        Assert.assertTrue(manualPayout.isReasonWarningVisible(), "Reason pop up warning is not visible");
    }

    @And("admin want to create invalid payout data")
    public void adminWantToCreateInvalidPayoutData() {
        admin.clickOnTextHyperlink("Manual Payout");
        manualPayout.clickOnCreatePayoutButton();
        manualPayout.selectPayoutType("Disbursement");
        manualPayout.fillAccountNumber("test AT");
        manualPayout.fillAccountName("4343353553223");
        manualPayout.selectBankAccount("Mandiri");
        manualPayout.fillAmount("11000");
        manualPayout.fillReason("testing AT");
        manualPayout.fillInvoice("DP/61392246/2021/05/0037");
        manualPayout.clickOnConfirmButton();
    }

    @Then("admin see warning not allowed input payout data")
    public void adminSeeWarningNotAllowedInputPayoutData() {
        Assert.assertTrue(manualPayout.isNotAllowedErrorMessageVisible(), "Error message is not display!");
    }

    @And("admin want to create payout with amount less than 10000")
    public void adminWantToCreatePayoutWithAmountLessThan10000() {
        playwright.navigateTo(Mamikos.ADMINMAMIPAY + "/backoffice/manual-payout");
        if (playwright.isTextDisplayed("429") || playwright.isTextDisplayed("502") || playwright.isTextDisplayed("504")) {
            playwright.reloadPage();
        }
        manualPayout.clickOnCreatePayoutButton();
        manualPayout.selectPayoutType("Disbursement");
        manualPayout.fillAccountNumber("test AT");
        manualPayout.fillAccountName("4343353553223");
        manualPayout.selectBankAccount("Mandiri");
        manualPayout.fillAmount("1000");
        manualPayout.fillReason("testing AT");
        manualPayout.fillInvoice("79370282/2021/04/0037");
        manualPayout.clickOnConfirmButton();
    }

    @Then("admin see warning minimal amount")
    public void adminSeeWarningMinimalAmount() {
        Assert.assertTrue(manualPayout.isMinimalAmountWarningVisible(), "Minimal Amount Warning is not display!");
    }

    @And("admin want to create payout with type {string}")
    public void adminWantToCreatePayoutWithType(String type) {
        playwright.navigateTo(Mamikos.ADMINMAMIPAY + "/backoffice/manual-payout");
        if (playwright.isTextDisplayed("429") || playwright.isTextDisplayed("502") || playwright.isTextDisplayed("504")) {
            playwright.reloadPage();
        }
        manualPayout.clickOnCreatePayoutButton();
        manualPayout.selectPayoutType(type);
        manualPayout.fillAccountNumber("test AT");
        manualPayout.fillAccountName("4343353553223");
        manualPayout.selectBankAccount("Mandiri");
        manualPayout.fillAmount("11000");
        manualPayout.fillReason("testing AT");
        manualPayout.fillInvoice("79370282/2021/04/0037");
        manualPayout.clickOnConfirmButton();
    }

    @Then("admin see payout ready to processed message")
    public void adminSeePayoutReadyToProcessedMessage() {
        Assert.assertTrue(manualPayout.isPayoutReadyToPrecessedMessageVisible(), "Payout Ready to Precessed message is not display!");
    }

    @And("admin cancel payout transaction")
    public void adminCancelPayoutTransaction() {
        manualPayout.clickCancelButtonOnMainPage();
        if (playwright.isTextDisplayed("429") || playwright.isTextDisplayed("502") || playwright.isTextDisplayed("504")) {
            playwright.reloadPage();
        }
    }

    @And("admin see payout canceled message")
    public void adminSeePayoutCanceledMessage() {
        Assert.assertTrue(manualPayout.isPayoutCanceledMessageVisible(), "Payout Canceled message is not display!");
    }

    @And("admin want to change payout type into {string}")
    public void adminWantToChangePayoutTypeInto(String type) {
        playwright.navigateTo(Mamikos.ADMINMAMIPAY + "/backoffice/manual-payout");
        if (playwright.isTextDisplayed("429") || playwright.isTextDisplayed("502") || playwright.isTextDisplayed("504")) {
            playwright.reloadPage();
        }
        manualPayout.clickOnChangeTypeButton();
        manualPayout.changePayoutType(type);
        manualPayout.clickOnSubmitChangeButton();
    }

    @Then("admin see payout data successfully updated message")
    public void adminSeePayoutDataSuccessfullyUpdatedMessage() {
        Assert.assertTrue(manualPayout.isSuccessUpdateMessageVisible(), "Payout Canceled message is not display!");
    }

    @And("admin want to change invoice number into {string}")
    public void adminWantToChangeInvoiceNumberInto(String invoice) {
        playwright.navigateTo(Mamikos.ADMINMAMIPAY + "/backoffice/manual-payout");
        manualPayout.clickOnChangeInvoiceButton();
        manualPayout.fillInvoice(invoice);
        manualPayout.clickOnSubmitChangeButton();
    }

    @And("admin want to edit bank name, account, amount, and reason payout")
    public void adminWantToEditBankNameAccountAmountAndReasonPayout() {
        playwright.navigateTo(Mamikos.ADMINMAMIPAY + "/backoffice/manual-payout");
        manualPayout.clickEditButtonOnMainPage();
        manualPayout.fillAccountNumber("111111111111");
        manualPayout.fillAccountName("111111111111");
        manualPayout.selectBankAccount("BRI");
        manualPayout.fillAmount("12011");
        manualPayout.fillReason("change reason AT");
        manualPayout.fillInvoice("79370282/2021/04/0037");
        manualPayout.clickOnUpdatePayoutButton();
    }

    @And("admin want to transfer on manual payout menu")
    public void adminWantToTransferOnManualPayoutMenu() {
        playwright.navigateTo(Mamikos.ADMINMAMIPAY + "/backoffice/manual-payout");
        manualPayout.clickOnTransferButtonOnMainPage();
    }

    @Then("admin see processing payout message")
    public void adminSeeProcessingPayoutMessage() {
        Assert.assertTrue(manualPayout.isProcessingPayoutMessageVisible(), "Processing Payout message is not display!");
    }
}
