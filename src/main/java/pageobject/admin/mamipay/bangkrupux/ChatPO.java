package pageobject.admin.mamipay.bangkrupux;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

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

    public ChatPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        tenantChatList = page.getByRole(AriaRole.ROW, new Page.GetByRoleOptions().setName("CS Sarah Consultant")).getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Consultant"));
        chatRoomMenu = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Chat Room"));
        kostTitleList = page.getByText("Krisna : kost gp regression 193 duplikat 2");
        chatKosTitle = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Krisna : kost gp regression 193 duplikat 2"));
        chatSearchDropdown = page.locator("#search_type");
        chatSearchInput = page.getByPlaceholder("Cari Chat");
        allChatMenu = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Terbaru"));
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
        searchType = page.locator("(//label[@for='filter_kost_level']//following::div)[2]");
        playwright.clickOn(searchType);
        playwright.hardWait(5);
        Locator searchTypeChat = page.locator("//select[@name='search_type']");
        if(type.equalsIgnoreCase("kos")) {
            playwright.selectDropdownByValue(searchTypeChat, "kos");
        }
        else if (type.equalsIgnoreCase("kos/tenant")) {
            playwright.selectDropdownByValue(searchTypeChat, "kos/tenant");
        }
        else if (type.equalsIgnoreCase("tenant")) {
            playwright.selectDropdownByValue(searchTypeChat, "tenant");
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
        Locator textTitle = page.locator("//*[@id='group_list']");
        return playwright.getText(textTitle);
    }
}
