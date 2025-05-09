package pageobject.admin.mamipay.bangkrupux;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class ListingFeaturedPO {
    private Page page;
    private PlaywrightHelpers playwright;

    Locator searchButton;
    Locator confirmButton;

    public ListingFeaturedPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        searchButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search"));
        confirmButton = page.locator("//button[@class=\"swal2-confirm swal2-styled\"]");
    }

    /**
     * search by type kost name, kost id, phone number
     * @param type
     * @param text
     */
    public void searchKosID(String type, String text){
        Locator searchBoxInput = page.locator("//input[@name='"+type+"']");
        playwright.fill(searchBoxInput, text);
    }

    /**
     * click search button
     */
    public void clickSearchButton(){
        playwright.clickOn(searchButton);
    }

    /**
     * filtering by status (good, not_good)
     * @param status
     */
    public void filteringByStatus(String status){
        Locator filterStatus = page.locator("//select[@name='featured_status']");
        if(status.equalsIgnoreCase("good")){
            playwright.selectDropdownByValue(filterStatus, "good");
        }
        else if(status.equalsIgnoreCase("not_good")){
            playwright.selectDropdownByValue(filterStatus, "not_good");
        }
    }

    /**
     * validate search result data
     * @param text
     * @return
     */
    public String validateSearchData(String text){
        Locator searchData = page.locator("//*[contains(text(),'"+text+"')]");
        return playwright.getText(searchData);
    }

    /**
     * click mark as featured or unmark as featured
     * @param text
     */
    public void clickMarkAsFeatured(String text) {
        if (text.equalsIgnoreCase("Mark as Featured")) {
            Locator markAsFeatured = page.locator("//a[@class=\"change-feature-status\"]/i[contains(@class, 'glyphicon glyphicon-thumbs-up')]");;
            playwright.clickOn(markAsFeatured);
        }
        else if (text.equalsIgnoreCase("Unmark as Featured")) {
            Locator markAsUnFeatured = page.locator("//a[@class=\"change-feature-status\"]/i[contains(@class, 'glyphicon glyphicon-circle-arrow-down')]");;
            playwright.clickOn(markAsUnFeatured);
        }
        playwright.clickOn(confirmButton);
    }

}
