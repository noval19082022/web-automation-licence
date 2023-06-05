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

    public ChatPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        tenantChatList = page.getByRole(AriaRole.ROW, new Page.GetByRoleOptions().setName("CS Sarah Consultant")).getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Consultant"));
        chatRoomMenu = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Chat Room"));
        kostTitleList = page.getByText("Krisna : kost gp regression 193 duplikat 2");
        chatKosTitle = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Krisna : kost gp regression 193 duplikat 2"));
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
}
