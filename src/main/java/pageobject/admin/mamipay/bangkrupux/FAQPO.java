package pageobject.admin.mamipay.bangkrupux;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class FAQPO {
    private Page page;
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);

    private Locator faqMenu;
    private Locator menuTitleFaqText;
    private Locator columnNameText;

    //---Search FAQ---//
    private Locator searchFaq;
    private Locator searchBtn;
    private Locator searchResult;

    //---Add FAQ---//
    private Locator addLevelFaq;
    private Locator questionField;
    private Locator answerField;
    private Locator saveBtn;

    //---Delete FAQ---//
    private Locator deleteBtn;
    private Locator alertMessage;

    public FAQPO(Page page) {
        this.page = page;
        playwright = new PlaywrightHelpers(page);

        faqMenu = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("FAQ"));
        menuTitleFaqText = page.locator("h3");
        columnNameText = page.locator("th");

        //---Search FAQ---//
        searchFaq = page.getByPlaceholder("Search");
        searchBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search"));

        //---Add FAQ---//
        addLevelFaq = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add Level FAQ"));
        questionField = page.getByLabel("Question");
        answerField = page.getByLabel("Answer");
        saveBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save"));
        deleteBtn = page.locator("//i[@class='fa fa-trash']");
        alertMessage = page.locator("//div[@class='alert alert-success alert-dismissable']");
    }

    /**
     * Clicks FAQ Menu
     */
    public void clicksFAQMenu() {
        playwright.clickOn(faqMenu);
    }

    /**
     * Clicks Search bar
     * And Input keyword
     * And Clicks Search button
     * @param search
     * @param keyword
     */
    public void searchFAQ(String search, String keyword) {
        if (search.equalsIgnoreCase("Question")){
            playwright.fill(searchFaq, keyword);
            playwright.clickOn(searchBtn);
        } else if (search.equalsIgnoreCase("Answer")) {
            playwright.fill(searchFaq, keyword);
            playwright.clickOn(searchBtn);
        } else {
            System.out.println("Invalid searching in FAQ");
        }
    }

    /**
     * Get String Result Question
     * @return String Result Question
     */
    public String getSearchResultQuestion() {
        searchResult = page.locator("tr td:nth-of-type(1)");
        return playwright.getText(searchResult);
    }

    /**
     * Get String Result Answer
     * @return String Result Answer
     */
    public String getSearchResultAnswer() {
        searchResult = page.locator("tr td:nth-of-type(2)");
        return playwright.getText(searchResult);
    }

    /**
     * Clicks Add Level FAQ button in FAQ page
     */
    public void clicksAddsFaqBtn() {
        playwright.clickOn(addLevelFaq);
    }

    /**
     * Inputs Question FAQ in Question field
     * @param question
     */
    public void inputsQuestionFaq(String question) {
        playwright.fill(questionField, question);
    }

    /**
     * Inputs Answer FAQ in Answer field
     * @param addAnswer
     */
    public void inputsAnswerFaq(String addAnswer) {
        playwright.fill(answerField, addAnswer);
    }

    /**
     * Clicks Save button in Create Level FAQ page
     */
    public void clicksSaveButtonInAddFaq() {
        playwright.clickOn(saveBtn);
    }

    /**
     * Clicks Delete button in FAQ page
     */
    public void clicksDelete() {
        searchResult = page.locator("tr td:nth-of-type(2)");
        if (playwright.isLocatorVisibleAfterLoad(searchResult, 5000.0)){
            playwright.clickOn(deleteBtn);
            playwright.acceptDialog(deleteBtn);
        }
    }

    /**
     * Get String Alert Message
     * Alert Message for Added successfully
     * Alert Message for Deleted successfully
     * @return Alert Message
     */
    public String getAlertMessage() {
        return playwright.getText(alertMessage).substring(7);
    }

    /**
     * Check if Level FAQ is displayed
     * True = visible
     * False = Invisible
     * @return Level FAQ
     */
    public boolean isLevelFaqDisplayed() {
        searchResult = page.locator("tr td:nth-of-type(2)");
        return playwright.isLocatorVisibleAfterLoad(searchResult, 5000.0);
    }

    /**
     * Get menu title FAQ
     * @return String
     */
    public String getMenuTitleFAQ() {
        return playwright.getText(menuTitleFaqText);
    }

    /**
     * Check button add level faq
     * @return Boolean
     */
    public boolean isAddLevelFaqButtonVisible() {
        return playwright.isLocatorVisibleAfterLoad(addLevelFaq,5000.0);
    }

    /**
     * Check search field
     * @return Boolean
     */
    public boolean isSearchFieldFaqVisible() {
        return playwright.isLocatorVisibleAfterLoad(searchFaq,5000.0);
    }

    /**
     * Check button search faq
     * @return Boolean
     */
    public boolean isSearchFaqButtonVisible() {
        return playwright.isLocatorVisibleAfterLoad(searchBtn, 5000.0);
    }

    /**
     * Get column name
     * @param i index
     * @return Boolean
     */
    public String getColumnName(int i) {
        return playwright.getText(columnNameText.nth(i));
    }
}