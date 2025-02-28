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
        if (text.equalsIgnoreCase("id")){
            playwright.selectDropdownByValue(searchByType, "id");
        }
        else if(text.equalsIgnoreCase("name")){
            playwright.selectDropdownByValue(searchByType, "name");
        }
    }

    /**
     * choose category landmark
     * @param text
     */
    public void filterCatrgory(String text){
        Locator filterCategory = page.locator("select[name=\"category_id\"]");
        if(text.equalsIgnoreCase("Food Stalls")){
            playwright.selectDropdownByValue(filterCategory, "1");
        }
        else if(text.equalsIgnoreCase("Shopping")){
            playwright.selectDropdownByValue(filterCategory, "2");
        }
        else if(text.equalsIgnoreCase("Mosque")){
            playwright.selectDropdownByValue(filterCategory, "3");
        }
        if(text.equalsIgnoreCase("Church")){
            playwright.selectDropdownByValue(filterCategory, "4");
        }
        if(text.equalsIgnoreCase("Pagoda")){
            playwright.selectDropdownByValue(filterCategory, "5");
        }
    }

    /**
     * select filter srp
     * @param text
     */
    public void filterShowSrp(String text){
        Locator categorySrp = page.locator("select[name=\"is_shown_srp\"]");
        if(text.equalsIgnoreCase("show srp yes")){
            playwright.selectDropdownByValue(categorySrp, "yes");
        }
        else if(text.equalsIgnoreCase("show srp no")){
            playwright.selectDropdownByValue(categorySrp, "no");
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
    public boolean getIdAndNameText(String text){
        Locator idNameText = page.locator("//*[contains(text(),'"+text+"')]");
        return playwright.waitTillLocatorIsVisible(idNameText);
    }

    /**
     * verify text for category landmark
     */
    public boolean getCategory(String name){
        Locator categoryText = page.locator("//*[@class=\"table table-striped\"]//td[contains(text(),'"+name+"')]").first();
        return playwright.waitTillLocatorIsVisible(categoryText);
    }

    /**
     * get text for show in srp
     */
    public boolean getShowSrp(String text){
        Locator getSrpStatus = page.locator("(//span[@class='label label-success'][normalize-space()='Yes'])[1]");
        return page.getByText(String.valueOf(getSrpStatus)).isVisible();
    }
}
