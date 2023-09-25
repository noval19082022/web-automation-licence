package pageobject.pms;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class HomepagePO {
    private Page page;
    private PlaywrightHelpers playwright;

    Locator actionBtn;
    Locator seeDetailBtn;
    Locator roomAllotmentBtn;
    Locator searchInput;
    Locator cariButton;
    Locator unduhCsvButton;

    public HomepagePO(Page page){
        this.page = page;
        playwright = new PlaywrightHelpers(page);
        actionBtn = page.getByTestId("table-action-trigger").first();
        seeDetailBtn = page.locator("//*[contains(text(),'Lihat Detail')]").first();
        roomAllotmentBtn = page.locator("//*[contains(text(),'Ketersediaan Kamar')]").first();
        searchInput = page.getByPlaceholder("Cari berdasarkan ID, Nama Properti");
        cariButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cari"));
        unduhCsvButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Unduh CSV"));
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

    /**
     * Search property Homepage
     * @param name name or id property
     */
    public void searchProperty(String name) {
        searchInput.fill(name);
        cariButton.click();
    }

    /**
     * Check button is exist or not in page
     * @param button
     * @return boolean
     */
    public boolean isButtonExist(String button) {
        boolean exist = false;
        switch (button){
            case "Lihat Detail":
                if (playwright.isLocatorVisibleAfterLoad(actionBtn,3000.0)){
                    playwright.clickOn(actionBtn);
                    exist = playwright.isLocatorVisibleAfterLoad(seeDetailBtn,1000.0);
                    playwright.clickOn(actionBtn);
                }
                break;
            case "Ketersediaan Kamar":
                if (playwright.isLocatorVisibleAfterLoad(actionBtn,3000.0)){
                    playwright.clickOn(actionBtn);
                    exist = playwright.isLocatorVisibleAfterLoad(roomAllotmentBtn,1000.0);
                    playwright.clickOn(actionBtn);
                }
                break;
            case "Unduh CSV":
                exist = playwright.isLocatorVisibleAfterLoad(unduhCsvButton,3000.0);
                break;
            default:
                System.out.println("Invalid button");
        }
        return exist;
    }
}
