package pageobject.admin.mamipay.bangkrupux;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.PlaywrightHelpers;
import com.microsoft.playwright.options.AriaRole;

public class FAQPO {
    private Page page;
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);

    private Locator faqMenu;
    private Locator searchFaq;
    private Locator searchBtn;
    private Locator searchResult;

    public FAQPO(Page page) {
        this.page = page;
        playwright = new PlaywrightHelpers(page);

        faqMenu = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("FAQ"));
        searchFaq = page.getByPlaceholder("Search");
        searchBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search"));

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
     * @param result
     * @return String SResult Question
     */
    public String getSearchResultQuestion(String result) {
        searchResult = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(result));
        return playwright.getText(searchResult.nth(1));
    }

    /**
     * Get String Result Answer
     * @param result
     * @return String Result Answer
     */
    public String getSearchResultAnswer(String result) {
        searchResult = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(result));
        System.out.println(searchResult.first());
        return playwright.getText(searchResult.first());
    }
}