package steps.mamikos.backofficedmin;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.admin.mamipay.BillingReminderPO;

import java.util.List;
import java.util.Map;

/**
 * Step definitions for Billing Reminder Template functionality
 */
public class BillingReminderTemplateSteps {
    private final Page page = ActiveContext.getActivePage();
    private final BillingReminderPO billingReminderPO = new BillingReminderPO(page);
    private List<Map<String, String>> inputBillingReminderData;

    @Then("user open {string} submenu of Billing Reminder Template")
    public void userOpenSubmenuOfBillingReminderTemplate(String menu) {
        billingReminderPO.clickOnBillingReminderMenu();
        billingReminderPO.clickOnBillingTemplateMenu(menu);
    }

    @When("user set the initial state to display Billing template Day {string}")
    public void userSetTheInitialStateToDisplayBillingTemplate(String day) {
        billingReminderPO.setBillingTemplate(day);
    }

    @When("user delete billing Template with content {string}")
    public void userDeleteBillingTemplateWithContent(String period) {
        billingReminderPO.deleteBillingReminderPeriod(period);
    }

    @Then("user verify delete billing Template with content {string}")
    public void userVerifyDeleteBillingTemplateWithContent(String content) {
        Assert.assertFalse(billingReminderPO.isTableContentTemplateDisplayed(content), "Template table content " + content + " is still appeared");
    }

    @Given("user create new template:")
    public void userCreateNewTemplate(DataTable table) {
        inputBillingReminderData = table.asMaps(String.class, String.class);
        var day = inputBillingReminderData.get(0).get("day");
        var subject = inputBillingReminderData.get(0).get("subject");
        var content = inputBillingReminderData.get(0).get("content");
        billingReminderPO.clickOnAddTemplateButton();
        billingReminderPO.fillTemplatePeriod(day);
        billingReminderPO.fillTemplateSubject(subject);
        billingReminderPO.fillTemplateContent(content);
        billingReminderPO.clickOnCreateTemplateButton();
    }

    @Then("user verify cannot create billing reminder template")
    public void userVerifyCannotCreateBillingReminderTemplate() {
        if (billingReminderPO.waitTemplateErrorVisible()) {
            Assert.assertEquals(billingReminderPO.getTemplateErrorText().trim(), "Cannot create template.");
        }
    }

    @Then("user verify Template subject with {string}")
    public void userVerifyTemplateSubjectWith(String subject) {
        Assert.assertEquals(billingReminderPO.getTableSubjectTemplate(subject), subject, "Template table content is not equal to " + subject);
    }

    @Then("user verify Template content with {string}")
    public void userVerifyTemplateContentWith(String content) {
        Assert.assertEquals(billingReminderPO.getTableContentTemplate(content), content, "Template table content is not equal to " + content);
    }

    @Given("user edit template:")
    public void userEditTemplate(DataTable table) {
        inputBillingReminderData = table.asMaps(String.class, String.class);
        var day = inputBillingReminderData.get(0).get("day");
        var subject = inputBillingReminderData.get(0).get("subject");
        var content = inputBillingReminderData.get(0).get("content");
        billingReminderPO.editBillingReminderPeriod(day);
        billingReminderPO.fillTemplateSubject(subject);
        billingReminderPO.fillTemplateContent(content);
        billingReminderPO.clickOnSaveTemplateButton();
    }

    @Given("user create new PN template:")
    public void userCreateNewPNTemplate(DataTable table) {
        inputBillingReminderData = table.asMaps(String.class, String.class);
        var day = inputBillingReminderData.get(0).get("day");
        var title = inputBillingReminderData.get(0).get("title");
        var content = inputBillingReminderData.get(0).get("content");
        billingReminderPO.clickOnAddTemplateButton();
        billingReminderPO.fillTemplatePeriod(day);
        billingReminderPO.fillTemplateTitle(title);
        billingReminderPO.fillTemplateContent(content);
        billingReminderPO.clickOnCreateTemplateButton();
    }

    @Given("user edit PN template:")
    public void userEditPNTemplate(DataTable table) {
        inputBillingReminderData = table.asMaps(String.class, String.class);
        var day = inputBillingReminderData.get(0).get("day");
        var title = inputBillingReminderData.get(0).get("title");
        var content = inputBillingReminderData.get(0).get("content");
        billingReminderPO.editBillingReminderPeriod(day);
        billingReminderPO.fillTemplateTitle(title);
        billingReminderPO.fillTemplateContent(content);
        billingReminderPO.clickOnSaveTemplateButton();
    }

    @Given("user create new SMS template:")
    public void userCreateNewSMSTemplate(DataTable table) {
        inputBillingReminderData = table.asMaps(String.class, String.class);
        var day = inputBillingReminderData.get(0).get("day");
        var text = inputBillingReminderData.get(0).get("text");
        billingReminderPO.clickOnAddTemplateButton();
        billingReminderPO.fillTemplatePeriod(day);
        billingReminderPO.fillSMSTextBox(text);
        billingReminderPO.clickOnCreateTemplateButton();
    }

    @Given("user edit SMS template:")
    public void userEditSMSTemplate(DataTable table) {
        inputBillingReminderData = table.asMaps(String.class, String.class);
        var day = inputBillingReminderData.get(0).get("day");
        var text = inputBillingReminderData.get(0).get("text");
        billingReminderPO.editBillingReminderPeriod(day);
        billingReminderPO.fillSMSTextBox(text);
        billingReminderPO.clickOnSaveTemplateButton();
    }

    @Given("user create new WhatsApp template:")
    public void userCreateNewWhatsAppTemplate(DataTable table) {
        inputBillingReminderData = table.asMaps(String.class, String.class);
        var day = inputBillingReminderData.get(0).get("day");
        var WATemplate = inputBillingReminderData.get(0).get("WATemplate");
        billingReminderPO.clickOnAddTemplateButton();
        billingReminderPO.fillWATemplatePeriod(day);
        billingReminderPO.fillWATemplate(WATemplate);
        billingReminderPO.clickOnCreateTemplateButton();
    }

    @Given("user edit WhatsApp template:")
    public void userEditWhatsAppTemplate(DataTable table) {
        inputBillingReminderData = table.asMaps(String.class, String.class);
        var day = inputBillingReminderData.get(0).get("day");
        var WATemplate = inputBillingReminderData.get(0).get("WATemplate");
        billingReminderPO.editBillingReminderPeriod(day);
        billingReminderPO.fillWATemplate(WATemplate);
        billingReminderPO.clickOnSaveTemplateButton();
    }

    @When("user set the initial state to display Billing template Day {string} {string}")
    public void userSetTheInitialStateToDisplayBillingTemplateDay(String day, String template) {
        billingReminderPO.setWABillingTemplate(day, template);
    }

}
