package pageobject.tenant.survei;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.PlaywrightHelpers;

public class KostDetailSurveiPO {
    private Page page;
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);

    private Locator kosAndalanOnTable;
    private Locator newLabelIndetailKos;

    public KostDetailSurveiPO(Page page) {
        this.page = page;

        this.newLabelIndetailKos = page.locator("//div[@class='bg-u-ml-xxxs bg-c-label bg-c-label--pill bg-c-label--pill-yellow']");

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

    /**
     * New label survei
     * @return
     */
    public boolean userSeeNewLabelIndetailkos() {
        return playwright.waitTillLocatorIsVisible(newLabelIndetailKos);
    }
}
