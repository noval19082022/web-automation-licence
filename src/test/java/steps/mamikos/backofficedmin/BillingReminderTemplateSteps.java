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

public class BillingReminderTemplateSteps {
    Page page = ActiveContext.getActivePage();
    private BillingReminderPO BillingReminderPO = new BillingReminderPO(page);
    private List<Map<String, String>> inputBillingReminderData;


    @Then("user open {string} submenu of Billing Reminder Template")
    public void userOpenSubmenuOfBillingReminderTemplate(String menu) {
        BillingReminderPO.clickOnBillingReminderMenu();
        BillingReminderPO.clickOnBillingTemplateMenu(menu);

    }

    @When("user set the initial state to display Billing template Day {string}")
    public void user_set_the_initial_state_to_display_billing_template(String day){
        BillingReminderPO.setBillingTemplate(day);

    }


    @When("user delete billing Template with content {string}")
    public void userDeleteBillingTemplateWithContent(String period) {
        BillingReminderPO.deleteBillingReminderPeriod(period);
    }

    @Then("user verify delete billing Template with content {string}")
    public void userVerifyDeleteBillingTemplateWithContent(String content) {
        Assert.assertFalse(BillingReminderPO.isTableContentTemplateAppeared(content), "Template table content " + content + " is still appeared");

    }

    @Given("user create new template:")
    public void userCreateNewTemplate(DataTable table) {
        inputBillingReminderData = table.asMaps(String.class, String.class);
        var day = inputBillingReminderData.get(0).get("day");
        var subject = inputBillingReminderData.get(0).get("subject");
        var content = inputBillingReminderData.get(0).get("content");
        BillingReminderPO.clickOnAddTemplateButton();
        BillingReminderPO.fillTemplatePeriod(day);
        BillingReminderPO.fillTemplateSubject(subject);
        BillingReminderPO.fillTemplateContent(content);
        BillingReminderPO.clickOnCreateTemplateButton();
    }

    @Then("user verify cannot create billing reminder template")
    public void user_verify_cannot_create_billing_reminder_template() {
        if (BillingReminderPO.waitTemplateErrorVisible()) {
            Assert.assertEquals(BillingReminderPO.getTemplateErrorText().trim(), "Cannot create template.");
        }

    }

    @Then("user verify Template subject with {string}")
    public void userVerifyTemplateSubjectWith(String subject) {
        Assert.assertEquals(BillingReminderPO.getTableSubjectTemplate(subject), subject, "Template table content is not equal to " + subject);
    }

    @Then("user verify Template content with {string}")
    public void userVerifyTemplateContentWith(String content) {
        Assert.assertEquals(BillingReminderPO.getTableContentTemplate(content), content, "Template table content is not equal to " + content);
    }

    @Given("user edit template:")
    public void userEditTemplate(DataTable table) {
        inputBillingReminderData = table.asMaps(String.class, String.class);
        var day = inputBillingReminderData.get(0).get("day");
        var subject = inputBillingReminderData.get(0).get("subject");
        var content = inputBillingReminderData.get(0).get("content");
        BillingReminderPO.editBillingReminderPeriod(day);
        BillingReminderPO.fillTemplateSubject(subject);
        BillingReminderPO.fillTemplateContent(content);
        BillingReminderPO.clickOnSaveTemplateButton();
    }

    @Given("user create new PN template:")
    public void userCreateNewPNTemplate(DataTable table) {
        inputBillingReminderData = table.asMaps(String.class, String.class);
        var day = inputBillingReminderData.get(0).get("day");
        var title = inputBillingReminderData.get(0).get("title");
        var content = inputBillingReminderData.get(0).get("content");
        BillingReminderPO.clickOnAddTemplateButton();
        BillingReminderPO.fillTemplatePeriod(day);
        BillingReminderPO.fillTemplateTitle(title);
        BillingReminderPO.fillTemplateContent(content);
        BillingReminderPO.clickOnCreateTemplateButton();
    }

    @Given("user edit PN template:")
    public void userEditPNTemplate(DataTable table) {
        inputBillingReminderData = table.asMaps(String.class, String.class);
        var day = inputBillingReminderData.get(0).get("day");
        var title = inputBillingReminderData.get(0).get("title");
        var content = inputBillingReminderData.get(0).get("content");
        BillingReminderPO.editBillingReminderPeriod(day);
        BillingReminderPO.fillTemplateTitle(title);
        BillingReminderPO.fillTemplateContent(content);
        BillingReminderPO.clickOnSaveTemplateButton();
    }

    @Given("user create new SMS template:")
    public void userCreateNewSMSTemplate(DataTable table) {
        inputBillingReminderData = table.asMaps(String.class, String.class);
        var day = inputBillingReminderData.get(0).get("day");
        var text = inputBillingReminderData.get(0).get("text");
        BillingReminderPO.clickOnAddTemplateButton();
        BillingReminderPO.fillTemplatePeriod(day);
        BillingReminderPO.fillSMSTextBox(text);
        BillingReminderPO.clickOnCreateTemplateButton();
    }

    @Given("user edit SMS template:")
    public void userEditSMSTemplate(DataTable table) {
        inputBillingReminderData = table.asMaps(String.class, String.class);
        var day = inputBillingReminderData.get(0).get("day");
        var text = inputBillingReminderData.get(0).get("text");
        var content = inputBillingReminderData.get(0).get("content");
        BillingReminderPO.editBillingReminderPeriod(day);
        BillingReminderPO.fillSMSTextBox(text);
        BillingReminderPO.clickOnSaveTemplateButton();
    }

}
