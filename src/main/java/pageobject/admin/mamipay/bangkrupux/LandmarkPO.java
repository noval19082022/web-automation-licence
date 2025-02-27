package pageobject.admin.mamipay.bangkrupux;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;


public class LandmarkPO {
    private Page page;
    private PlaywrightHelpers playwright;
    Locator searchInputText;
    Locator searchButton;


    public LandmarkPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        searchButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Search"));
        searchInputText = page.getByRole(AriaRole.TEXTBOX);
    }

    /**
     * is main menu visible
     * @param text
     */
    public void isLandmarkMainMenuVisible(String text){
        playwright.hardWait(10000);
        Locator mainMenuText = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(text));
        playwright.waitTillLocatorIsVisible(mainMenuText, 300.0);
    }

    /**
     * click search type category
     * @param text
     */
    public void clickSearchType(String text){
        Locator searchByType = page.locator("select[name=\"search_by\"]");
        Locator filterCategory = page.locator("select[name=\"category_id\"]");
        Locator categorySrp = page.locator("select[name=\"is_shown_srp\"]");
        if (text.equalsIgnoreCase("id")){
            playwright.selectDropdownByValue(searchByType, "id");
        }
        else if(text.equalsIgnoreCase("name")){
            playwright.selectDropdownByValue(searchByType, "name");
        }
        else if(text.equalsIgnoreCase("category")){
            playwright.selectDropdownByValue(filterCategory, "3");
        }
        else if(text.equalsIgnoreCase("show srp yes")){
            playwright.selectDropdownByValue(categorySrp, "yes");
        }
    }

    /**
     * input search data
     * @param text
     */
    public void inputSearchDataText(String text){
        playwright.forceFill(searchInputText, text);
    }

    /**
     * click search button
     */
    public void clickSearchButton(){
        playwright.clickOn(searchButton);
    }

    /**
     * get text data result
     * @param text
     */
    public void getIdAndNameText(String text){
        Locator idNameText = page.locator("//*[contains(text(),'"+text+"')]");
        playwright.getText(idNameText);
    }

}
