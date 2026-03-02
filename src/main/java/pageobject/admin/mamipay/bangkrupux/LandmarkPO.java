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
    Locator remappingButton;
    Locator successAlertRemapping;
    Locator editButton;
    Locator editPageText;
    Locator scoreInput;
    Locator saveButton;
    Locator searchByTypeDropdown;
    Locator filterCategoryDropdown;
    Locator categorySrpDropdown;
    Locator getSrpStatusYesLabel;
    Locator getSrpStatusNoLabel;

    public LandmarkPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        searchButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Search"));
        searchInputText = page.getByRole(AriaRole.TEXTBOX);
        remappingButton = page.locator("a.btn:nth-child(3)");
        successAlertRemapping = page.locator("//div[@class=\"alert alert-success alert-dismissable\"]");
        editButton = page.locator("a.btn:nth-child(2)");
        editPageText = page.locator("//*[contains(text() , 'Edit Landmark')]");
        scoreInput = page.locator("//input[@id=\"input-score\"]");
        saveButton = page.locator("//button[@class=\"btn btn-primary\"]");
        searchByTypeDropdown = page.locator("select[name=\"search_by\"]");
        filterCategoryDropdown = page.locator("select[name=\"category_id\"]");
        categorySrpDropdown = page.locator("select[name=\"is_shown_srp\"]");
        getSrpStatusYesLabel = page.locator("(//span[@class='label label-success'][normalize-space()='Yes'])[1]");
        getSrpStatusNoLabel = page.locator("(//span[@class='label label-danger'][normalize-space()='No'])[1]");
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
        if (text.equalsIgnoreCase("id")){
            playwright.selectDropdownByValue(searchByTypeDropdown, "id");
        }
        else if(text.equalsIgnoreCase("name")){
            playwright.selectDropdownByValue(searchByTypeDropdown, "name");
        }
    }

    /**
     * choose category landmark
     * @param text
     */
    public void filterCatrgory(String text){
        if(text.equalsIgnoreCase("Food Stalls")){
            playwright.selectDropdownByValue(filterCategoryDropdown, "1");
        }
        else if(text.equalsIgnoreCase("Shopping")){
            playwright.selectDropdownByValue(filterCategoryDropdown, "2");
        }
        else if(text.equalsIgnoreCase("Mosque")){
            playwright.selectDropdownByValue(filterCategoryDropdown, "3");
        }
        if(text.equalsIgnoreCase("Church")){
            playwright.selectDropdownByValue(filterCategoryDropdown, "4");
        }
        if(text.equalsIgnoreCase("Pagoda")){
            playwright.selectDropdownByValue(filterCategoryDropdown, "5");
        }
    }

    /**
     * select filter srp
     * @param text
     */
    public void filterShowSrp(String text){
        if(text.equalsIgnoreCase("show srp yes")){
            playwright.selectDropdownByValue(categorySrpDropdown, "yes");
        }
        else if(text.equalsIgnoreCase("show srp no")){
            playwright.selectDropdownByValue(categorySrpDropdown, "no");
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
        Locator idNameText = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(text).setExact(true)).first();
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
        if(text.equalsIgnoreCase("Yes")){
            return getSrpStatusYesLabel.isVisible();
        }
        else if(text.equalsIgnoreCase("No")){
            return getSrpStatusNoLabel.isVisible();
        }
        return false;
    }

    /**
     * click remapping button
     */
    public void clickRemappingButton(){
        playwright.clickOn(remappingButton);
    }

    /**
     * validate success alert remapping
     * @return
     */
    public boolean getSuccessAlertRemapping(){
        return playwright.waitTillLocatorIsVisible(successAlertRemapping);
    }

    /**
     * click edit button
     */
    public void clickEditButton(){
        playwright.clickOn(editButton);
    }

    /**
     * validate edit page
     * @return
     */
    public boolean getEditPageText(){
        return playwright.waitTillLocatorIsVisible(editPageText);
    }

    /**
     * fill update score and click save button
     * @param score
     */
    public void updateScore(String score){
        playwright.fill(scoreInput, score);
        playwright.clickOn(saveButton);
    }

}
