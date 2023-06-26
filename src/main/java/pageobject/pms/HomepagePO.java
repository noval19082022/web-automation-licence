package pageobject.pms;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomepagePO {
    private Page page;

    Locator actionBtn;
    Locator seeDetailBtn;
    Locator roomAllotmentBtn;

    public HomepagePO(Page page){
        this.page = page;
        actionBtn = page.getByTestId("table-action-trigger").first();
        seeDetailBtn = page.locator("//*[contains(text(),'Lihat Detail')]").first();
        roomAllotmentBtn = page.locator("//*[contains(text(),'Ketersediaan Kamar')]").first();
    }

    /**
     * Click action button in homepage
     */
    public void clickActionButton() {
        actionBtn.waitFor();
        actionBtn.click();
    }

    /**
     * Click lihat detail menu in homepage
     */
    public void clickSeeDetail() {
        seeDetailBtn.click();
    }

    /**
     * Click ketersediaan kamar menu in homepage
     */
    public void clickRoomAllotment() {
        roomAllotmentBtn.click();
    }
}
