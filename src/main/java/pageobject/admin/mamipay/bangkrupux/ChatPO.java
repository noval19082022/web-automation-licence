package pageobject.admin.mamipay.bangkrupux;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

import java.util.regex.Pattern;

public class ChatPO {
    Page page;
    PlaywrightHelpers playwright;
    Locator tenantChatList;
    Locator chatRoomMenu;
    Locator kostTitleList;
    Locator chatKosTitle;
    Locator chatSearchDropdown;
    Locator chatSearchInput;
    Locator allChatMenu;
    Locator searchType;
    Locator textTitle;

    //-----important---//
    Locator markImportantButton;
    Locator importantMark;


    public ChatPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        tenantChatList = page.getByRole(AriaRole.ROW, new Page.GetByRoleOptions().setName("CS Okta Consultant")).getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Consultant"));
        chatRoomMenu = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Chat Room"));
        kostTitleList = page.locator("//div[@class=\"channel-list-item__content\"]").first();
        chatKosTitle = page.locator(".chat-room-header a");
        chatSearchDropdown = page.locator("#search_type");
        chatSearchInput = page.getByPlaceholder("Cari Chat");
        allChatMenu = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("All"));
        textTitle = page.locator("//div[@class=\"channel-list-item__content\"]").first();

        //--------important----//
        markImportantButton = page.locator("//div[@class=\"channel-list-item__important-button-icon\"]").first();
        importantMark = page.locator("//div[@data-testid=\"important-button-active\"]").first();
    }

    /**
     * Click on one of chat from chat list
     *
     */
    public void clickOnTenantChat() {
        playwright.clickOn(tenantChatList);
    }

    /**
     * Click on Segment Menu on Point Management Left Bar
     *
     */
    public void clickOnChatRoomMenu() {
        playwright.clickOn(chatRoomMenu);
    }

    /**
     * Get kost name
     * @return kost name from chat
     */
    public String getChatKosTitle() {
        return playwright.getAttributeValue(chatKosTitle,"href");
    }

    /**
     * Click on KosTitle from chat list
     */
    public void clickOnKosTitleChatList() {
        playwright.clickOn(kostTitleList);
    }

    /**
     * Click on KosTitle from chat header
     */
    public void clickOnKosTitleChatHeader() {
        playwright.clickOn(chatKosTitle);
    }

    /**
     * Click on Chat type search
     */
    public void setChatSearchType(String type) {
        searchType = page.locator("//span[@class=\"bg-c-select__trigger-text\"]");
        playwright.clickOn(searchType);
        playwright.hardWait(2);

        if(type.equalsIgnoreCase("kos")) {
            page.locator("a").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Kos$"))).click();
        }
        else if (type.equalsIgnoreCase("kos/tenant")) {
            page.locator("a").filter(new Locator.FilterOptions().setHasText("Kos/Tenant")).click();
        }
        else if (type.equalsIgnoreCase("tenant")) {
            page.locator("a").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Tenant$"))).click();
        }
    }

    /**
     * Click and fill note for search field
     * @param text refers to text that wanna fill to
     */
    public void fillSearch(String text) {
        playwright.forceFill(chatSearchInput, text);
    }

    /**
     * Click on All category
     */
    public void clickOnAllCategory() {
        playwright.clickOn(allChatMenu);
    }

    /**
     * Get result data search
     * @return data search
     */
    public String getResutlSearch() {
        return playwright.getText(textTitle);
    }

    //--------important----//

    /**
     * click on mark important in list
     */
    public void clickMarkImportant(){
        playwright.clickOn(markImportantButton);
        playwright.hardWait(2);
    }

    /**
     * click important or unread on filter data
     * @param text
     */
    public void clickImportantFilterButton(String text){
        Locator filterButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(""+text+""));
        playwright.clickOn(filterButton);
    }

    /**
     * verify mark important button on list
     * @return
     */
    public boolean getImportantButtonOnList(){
        return playwright.waitTillLocatorIsVisible(importantMark);
    }

    /**
     * click unmark important
     */
    public void clickUnmarkImportan(){
        playwright.clickOn(importantMark);
        playwright.hardWait(2);
    }

    /**
     * get unread counter text on list
     * @param number
     * @return number
     */
    public boolean getUnreadCounterText(String number){
        Locator unreadChatCountertext = page.getByText(""+number+"", new Page.GetByTextOptions().setExact(true)).nth(1);
        return playwright.waitTillLocatorIsVisible(unreadChatCountertext);
    }
}
