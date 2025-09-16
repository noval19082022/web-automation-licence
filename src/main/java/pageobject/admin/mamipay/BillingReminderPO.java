package pageobject.admin.mamipay;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class BillingReminderPO {

    private static final String AUTOMATION_TEXT = "untuk automation";
    private static final double DROPDOWN_LOAD_WAIT = 1500;
    private static final double PERIOD_DROPDOWN_WAIT = 500;
    private static final double MENU_RELOAD_WAIT = 2000;

    private Page page;
    private PlaywrightHelpers playwright;
    private Locator billingReminderMenu;
    private Locator addTemplateButton;
    private Locator selectPeriodDropdown;
    private Locator subjectTextField;
    private Locator titleTextField;
    private Locator contentTextField;
    private Locator createTemplateButton;
    private Locator templateCreatedText;
    private Locator templateSubjectText;
    private Locator cannotCreateTemplateText;
    private Locator saveTemplateButton;
    private Locator SMSTextField;
    private Locator selectWATemplateDropdown;
    private Locator WATemplateSubjectText;
    private Locator selectWAPeriodDropdown;

    public BillingReminderPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        billingReminderMenu = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Billing Reminder Template "));
        addTemplateButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add Template"));
        selectPeriodDropdown = page.getByRole(AriaRole.COMBOBOX);
        selectWAPeriodDropdown = page.locator("select[name=\"period\"]");
        selectWATemplateDropdown = page.locator("select[name=\"notification_whatsapp_template_id\"]");
        subjectTextField =  page.locator("input[name=\"subject\"]");
        titleTextField = page.locator("input[name=\"title\"]");
        SMSTextField = page.getByRole(AriaRole.TEXTBOX);
        contentTextField = page.locator("textarea[name=\"content\"]");
        createTemplateButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Create"));
        templateCreatedText = page.getByText("Template created.");
        templateSubjectText = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("-1").setExact(true));
        WATemplateSubjectText = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("recurringbooking_voucher_d_plus_1_update"));
        cannotCreateTemplateText = page.getByText("Cannot create template.");
        saveTemplateButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save"));

    }

    /**
     * click on Billing Reminder Menu
     */
    public void clickOnBillingReminderMenu() {
        page.reload();
        playwright.hardWait(MENU_RELOAD_WAIT);
        playwright.forceClickOn(billingReminderMenu);
    }

    /**
     * Select dropdown on billing reminder menu
     *
     */
    public void clickOnBillingTemplateMenu(String menu) {
        playwright.clickOn(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(menu)));
    }

    /**
     *  Delete billing reminder period
     */
    public void deleteBillingReminderPeriod(String period){
        playwright.clickOn(page.getByRole(AriaRole.ROW, new Page.GetByRoleOptions().setName(period)).getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Delete")));
    }

    /**
     *  Edit billing reminder period
     */
    public void editBillingReminderPeriod(String day){
        playwright.clickOn(page.getByRole(AriaRole.ROW, new Page.GetByRoleOptions().setName(day)).getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Edit")));
    }

    /**
     * Check if table content template is displayed
     * @param content input string that will search element text
     * @return true if template is displayed, false otherwise
     */
    public boolean isTableContentTemplateDisplayed(String content){
        return playwright.waitTillLocatorIsVisible(page.getByRole(AriaRole.ROW, new Page.GetByRoleOptions().setName(content)).getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Delete")));
    }

    /**
     * Check Email template Day -1 is present
     * @return true / false
     */
    public boolean isBillingTemplateDisplayed() {
        playwright.waitFor(templateSubjectText);
        return playwright.waitTillLocatorIsVisible(templateSubjectText);
    }

    /**
     * Set Email Template
     */
    public void setBillingTemplate(String day) {
        if (!isBillingTemplateDisplayed()){
            playwright.clickOn(addTemplateButton);
            playwright.selectDropdownByValue(selectPeriodDropdown, day);
            if (playwright.waitTillLocatorIsVisible(subjectTextField))
                playwright.fill(subjectTextField, AUTOMATION_TEXT);
            else if (playwright.waitTillLocatorIsVisible(titleTextField)){
                playwright.fill(titleTextField, AUTOMATION_TEXT);
            }
            else if (playwright.waitTillLocatorIsVisible(SMSTextField)){
                playwright.fill(SMSTextField, AUTOMATION_TEXT);
            }
            playwright.fill(contentTextField, AUTOMATION_TEXT);
            playwright.clickOn(createTemplateButton);
            playwright.waitFor(templateCreatedText);
        }

    }

    /**
     * Check Email template Day -1 is present
     * @return true / false
     */
    public boolean isWABillingTemplateDisplayed(){
        return playwright.waitTillLocatorIsVisible(WATemplateSubjectText);
    }

    /**
     * Set Email Template
     */
    public void setWABillingTemplate(String day, String WATemplate) {
        if (!isWABillingTemplateDisplayed()){
            playwright.clickOn(addTemplateButton);
            playwright.selectDropdownByValue(selectWAPeriodDropdown, day);
            fillWATemplate(WATemplate);
            playwright.clickOn(createTemplateButton);
            playwright.waitFor(templateCreatedText);
        }

    }

    /**
     * click on Add Template Button
     */
    public void clickOnAddTemplateButton() {
        playwright.clickOn(addTemplateButton);
    }

    /**
     * click on Create Template Button
     */
    public void clickOnCreateTemplateButton() {
        playwright.clickOn(createTemplateButton);
    }

    /**
     * click on Save Template Button
     */
    public void clickOnSaveTemplateButton() {
        playwright.clickOn(saveTemplateButton);
    }

    /**
     * Fill template title field
     * @param title input string that will be used to fill template title
     */
    public void fillTemplateTitle(String title) {
        playwright.fill(titleTextField, title);
    }

    /**
     * Fill template subject field
     * @param subject input string that will be used to fill template subject
     */
    public void fillTemplateSubject(String subject) {
        playwright.fill(subjectTextField, subject);
    }

    /**
     * Fill template content field
     * @param content input string that will be used to fill template content
     */
    public void fillTemplateContent(String content) {
        playwright.fill(contentTextField, content);
    }

    /**
     * Fill SMS text box field
     * @param text input string that will be used to fill SMS text content
     */
    public void fillSMSTextBox(String text) {
        playwright.fill(SMSTextField, text);
    }

    /**
     * Fill template period dropdown
     * @param day input string that will be used to select template period
     */
    public void fillTemplatePeriod(String day) {
        playwright.selectDropdownByValue(selectPeriodDropdown, day);
    }

    /**
     * Fill WhatsApp template period dropdown
     * @param day input string that will be used to select WhatsApp template period
     */
    public void fillWATemplatePeriod(String day) {
        // Wait for dropdown to be visible and enabled before selecting option
        playwright.waitFor(selectWAPeriodDropdown);
        playwright.hardWait(PERIOD_DROPDOWN_WAIT);
        playwright.selectDropdownByValue(selectWAPeriodDropdown, day);
    }

    /**
     * Fill WhatsApp template dropdown with specified template
     * @param WATemplate input string for the WhatsApp template to select
     */
    public void fillWATemplate(String WATemplate) {
        // Wait for dropdown to be visible and enabled before selecting option
        playwright.waitFor(selectWATemplateDropdown);
        
        // Wait for dropdown options to be loaded
        playwright.hardWait(DROPDOWN_LOAD_WAIT);
        
        // Directly select the option by value using PlaywrightHelpers
        playwright.selectDropdownByValue(selectWATemplateDropdown, WATemplate);
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
        return playwright.waitTillLocatorIsVisible(cannotCreateTemplateText);
    }

    /**
     * Get Table Subject Template
     * @param subject input string that will search element text
     * @return string
     */
    public String getTableSubjectTemplate(String subject){
        // Wait for table to be loaded before getting text
        playwright.waitFor(page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(subject).setExact(true)));
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
