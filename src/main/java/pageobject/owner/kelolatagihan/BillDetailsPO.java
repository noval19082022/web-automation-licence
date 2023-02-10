package pageobject.owner.kelolatagihan;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.PlaywrightHelpers;

public class BillDetailsPO {
    Page page;
    PlaywrightHelpers playwright;
    Locator invoiceDetailContent;
    public BillDetailsPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        invoiceDetailContent = page.locator("div.detail-bill-invoice");
    }

    /**
     * Get additional price value text
     * @param additionalTextTitle String data type additional text name/title
     * @return
     */
    public String getAdditionalPriceValueText(String additionalTextTitle){
        Locator additionalPrice = page.locator("//*[.='"+ additionalTextTitle +"']/following-sibling::*");
        return playwright.getText(additionalPrice);
    }
}
