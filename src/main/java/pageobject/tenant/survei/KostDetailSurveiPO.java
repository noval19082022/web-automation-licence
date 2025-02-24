package pageobject.tenant.survei;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.PlaywrightHelpers;

public class KostDetailSurveiPO {
    private Page page;
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);

    private Locator kosAndalanOnTable;

    public KostDetailSurveiPO(Page page) {
        this.page = page;

      //  this.kosAndalanOnTable = page.locator("//p[contains(text(),'Kos ini bisa di-booking dan dibayar di situs dan a')]");

    }

    /**
     * Assert Kost andalan on table
     * @param name
     */
    public String assertkosAndalanOnTable(String name){
        kosAndalanOnTable = page.locator("//p[contains(text(),'"+ name +"')]");
        playwright.pageScrollInView(kosAndalanOnTable);
        return playwright.getText(kosAndalanOnTable);
    }
}
