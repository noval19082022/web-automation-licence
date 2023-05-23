package pageobject.admin.mamipay;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class BillingReminderPO {

    private Page page;
    private PlaywrightHelpers playwright;
    Locator billingReminderMenu;
    Locator addTemplateButton;
    Locator selectPeriodDropdown;
    Locator subjectTextField;
    Locator contentTextField;
    Locator createTemplateButton;
    Locator templateCreatedText;
    Locator templateSubjectText;
    Locator cannotCreateTemplateText;
    Locator saveTemplateButton;

    public BillingReminderPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        billingReminderMenu = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Billing Reminder Template "));
        addTemplateButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add Template"));
        selectPeriodDropdown = page.getByRole(AriaRole.COMBOBOX);
        subjectTextField =  page.locator("input[name=\"subject\"]");
        contentTextField = page.locator("textarea[name=\"content\"]");
        createTemplateButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Create"));
        templateCreatedText = page.getByText("Template created.");
        templateSubjectText = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("untuk automation").setExact(true));
        cannotCreateTemplateText = page.getByText("Cannot create template.");
        saveTemplateButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save"));

    }

    /**
     * click on Billing Reminder Menu
     */

    public void clickOnBillingReminderMenu() {
        page.reload();
        playwright.hardWait(2);
        playwright.forceClickOn(billingReminderMenu);
    }

    /**
     * Select dropdown on billing reminder menu
     *
     */

    public void clickOnBillingTemplateMenu(String menu) {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(menu)).click();
    }

    /**
     *  Delete billing reminder period
     */

    public void deleteBillingReminderPeriod(String period){
        page.getByRole(AriaRole.ROW, new Page.GetByRoleOptions().setName(period)).getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Delete")).click();
    }

    /**
     *  Edit billing reminder period
     */

    public void editBillingReminderPeriod(String day){
        page.getByRole(AriaRole.ROW, new Page.GetByRoleOptions().setName(day)).getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Edit")).click();
    }

    /**
     * Is Table Content Template Appeared?
     * @param content input string that will search element text
     * @return true or false
     */
    public Boolean isTableContentTemplateAppeared(String content){
        return page.getByRole(AriaRole.ROW, new Page.GetByRoleOptions().setName(content)).getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Delete")).isVisible();
    }


    /**
     * Check Email template Day -1 is present
     * @return true / false
     */
    public boolean isEmailTemplateDisplayed(){
        return templateSubjectText.isVisible();
    }

    /**
     * Set Email Template
     */
    public void setEmailTemplate() {
        if (!isEmailTemplateDisplayed()){
            addTemplateButton.click();
            selectPeriodDropdown.selectOption("-1");
            subjectTextField.fill("untuk automation");
            contentTextField.fill("untuk automation");
            createTemplateButton.click();
            templateCreatedText.waitFor();
        }

    }

    public void clickOnAddTemplateButton() {
        addTemplateButton.click();
    }

    public void clickOnCreateTemplateButton() {
        createTemplateButton.click();
    }

    public void clickOnSaveTemplateButton() {
        saveTemplateButton.click();
    }

    /**
     * Fill Email Template Subject
     * @param subject input string that will be used to fill Email Template Subject
     */
    public void fillTemplateSubject(String subject) {
        subjectTextField.fill(subject);
    }

    /**
     * Fill Email Template Content
     * @param content input string that will be used to fill Email Template Subject
     */
    public void fillTemplateContent(String content) {
        contentTextField.fill(content);
    }

    /**
     * Fill Email Template period
     * @param day input string that will be used to fill Email Template Subject
     */
    public void fillTemplatePeriod(String day) {
        selectPeriodDropdown.selectOption(day);
    }

    /**
     * Get cannot create template text
     *
     * @return String data type
     */
    public String getTemplateErrorText(){
        return playwright.getText(cannotCreateTemplateText);
    }

    /**
     * Wait until cannot create template text visible
     *
     * @return
     */
    public boolean waitTemplateErrorVisible() {
        return cannotCreateTemplateText.isVisible();
    }

    /**
     * Get Table Subject Template
     * @param subject input string that will search element text
     * @return string
     */
    public String getTableSubjectTemplate(String subject){
        return playwright.getText(page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(subject).setExact(true)));
    }

    /**
     * Get Table Content Template
     * @param content input string that will search element text
     * @return string
     */
    public String getTableContentTemplate(String content){
        return playwright.getText(page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(content).setExact(true)));
    }

}
