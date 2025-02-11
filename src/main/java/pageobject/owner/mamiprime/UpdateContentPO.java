package pageobject.owner.mamiprime;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.PlaywrightHelpers;

public class UpdateContentPO {

    private Page page;
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);

    // Invoice List Page
    private Locator tanyaJawabOnTable;
    private Locator textSini;
    private Locator autoSelectFirstOrder;

    public UpdateContentPO(Page page) {
        this.page = page;

        this.textSini = page.locator("//a[normalize-space()='sini']");
        this.autoSelectFirstOrder = page.locator("//a[@class='bg-c-link prime-property-list__list-item bg-c-link--high-naked prime-property-list__list-item--active']");

    }

        /**
         * Assert Tanya Jawab on table
         * @param name
         */
        public String assertTanyaJawabOnTable(String name){
            tanyaJawabOnTable = page.locator("//p[normalize-space()='"+name+"']");
            playwright.pageScrollInView(tanyaJawabOnTable);
            return playwright.getText(tanyaJawabOnTable);
        }

    /**
     * Click on text sini
     */

    public void clickOnTextSini(){
        playwright.clickOn(textSini);
    }

    /**
     * Get locator auto select first order
     */

    public void ownerSeeAutoSelectFirstOrder(){
        playwright.getLocators(autoSelectFirstOrder);
    }

}

