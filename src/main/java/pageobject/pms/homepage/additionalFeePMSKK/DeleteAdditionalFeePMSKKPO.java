package pageobject.pms.homepage.additionalFeePMSKK;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.PlaywrightHelpers;

public class DeleteAdditionalFeePMSKKPO {
    private Page page;
    PlaywrightHelpers playwright;

    private Locator kebabBtn;
    private Locator hapusBtn;
    private Locator hapusBtnInPopUp;
    private Locator expandBtn;

    public DeleteAdditionalFeePMSKKPO(Page page){
        this.page = page;
        playwright = new PlaywrightHelpers(page);

        kebabBtn = page.locator("//div[@data-testid='additional-fee-action']");
        hapusBtn = page.locator("//div[@class='bg-c-dropdown__menu-item-content'][contains(., 'Hapus')]");
        hapusBtnInPopUp = page.locator("//button[@class='bg-c-button bg-c-button--primary bg-c-button--lg'][contains(., 'Hapus')]");
        expandBtn = page.locator("//button[@class='bg-c-button bg-c-button--tertiary bg-c-button--sm']");
    }

    /**
     * Clicks Kebab button
     */
    public void clicksKebabBtn() {
        playwright.waitTillPageLoaded(10000.0);
        playwright.pageScrollInView(kebabBtn);
        playwright.clickOn(kebabBtn);
    }

    /**
     * Clicks Hapus button
     */
    public void clicksHapusBtn() {
        playwright.clickOn(hapusBtn);
    }

    /**
     * Clicks Hapus button in Biaya Tambahan Pop Up
     */
    public void clicksHapusBtnInPopUp() {
        playwright.clickOn(hapusBtnInPopUp);
    }

    /**
     * Reload page in Kontrak Kerja Sama tab
     */
    public void reloadKontrakKerjaSamaPage() {
        playwright.reloadPage();
    }

    /**
     * Check if Additional Fee data is visible
     * true = visible
     * false = not visible
     * @return Additional Fee data
     */
    public boolean isAdditionalFeeVisible() {
        return playwright.isLocatorVisibleAfterLoad(expandBtn, 10000.0);
    }
}