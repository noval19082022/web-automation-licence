package pageobject.pms;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import config.global.GlobalConfig;
import utilities.PlaywrightHelpers;

public class DisbursementPO {
    private Page page;
    private PlaywrightHelpers playwright;

    Locator actionBtn;
    Locator konfirmasiBtn;
    Locator seeDetailBtn;
    Locator statusMenungguKonfirmasi;
    Locator statusTransferWaiting;
    Locator batalkanKonfirmasiBtn;
    Locator filter;
    Locator statusDataPendapatanDropdown;
    Locator statusDtPndptn;
    Locator terapkanBtn;
    Locator cariBtn;

    public DisbursementPO(Page page) {
        this.page = page;
        playwright = new PlaywrightHelpers(page);

        actionBtn = page.getByTestId("table-action-trigger").first();
        konfirmasiBtn = page.getByRole(AriaRole.ROW, new Page.GetByRoleOptions()).getByText("Konfirmasi", new Locator.GetByTextOptions().setExact(true)).first();
        seeDetailBtn = page.locator("//*[contains(text(),'Lihat Detail')]").first();
        statusMenungguKonfirmasi = page.locator("((//tr)[2]/td)[3]");
        statusTransferWaiting = page.locator("((//tr)[2]/td)[4]");
        batalkanKonfirmasiBtn = page.getByText("Batalkan Konfirmasi").first();
        filter = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("filterFilter"));
        statusDataPendapatanDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih status data pendapatan dropdown-down"));
        terapkanBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Terapkan"));
        cariBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cari"));
    }

    /**
     * Check button is exist or not in page
     * @param button
     * @return boolean
     */
    public boolean isButtonExist(String button) {
        boolean exist = false;
        switch (button){
            case "Konfirmasi":
                if (isStatusDataPendapatanMenungguKonfirmasi()){
                    if (playwright.isLocatorVisibleAfterLoad(actionBtn, GlobalConfig.DEFAULT_NAVIGATION_TIMEOUT)){
                        playwright.clickOn(actionBtn);
                        exist = playwright.isLocatorVisibleAfterLoad(konfirmasiBtn, GlobalConfig.DEFAULT_NAVIGATION_TIMEOUT);
                        playwright.clickOn(actionBtn);
                    }
                }
                break;
            case "Lihat Detail":
                if (playwright.isLocatorVisibleAfterLoad(actionBtn,GlobalConfig.DEFAULT_NAVIGATION_TIMEOUT)){
                    playwright.clickOn(actionBtn);
                    exist = playwright.isLocatorVisibleAfterLoad(seeDetailBtn,GlobalConfig.DEFAULT_NAVIGATION_TIMEOUT);
                    playwright.clickOn(actionBtn);
                }
                break;
            default:
                System.out.println("Invalid button");
        }
        return exist;
    }

    /**
     * Check if Status Data Pendapatan is Menunggu Konfirmasi
     * @return
     */
    public boolean isStatusDataPendapatanMenungguKonfirmasi(){
        playwright.isLocatorVisibleAfterLoad(statusMenungguKonfirmasi, GlobalConfig.DEFAULT_NAVIGATION_TIMEOUT);
        return statusMenungguKonfirmasi.textContent().contains("Menunggu Konfirmasi");
    }

    /**
     * Clicks Filter on Disbursement menu
     */
    public void clicksFilter(){
        playwright.clickOn(filter);
    }

    /**
     * Tick value on Status Data Pendapatan dropdown
     * @param filter
     */
    public void tickStatusDataPendapatan(String filter){
        playwright.clickOn(statusDataPendapatanDropdown);

        statusDtPndptn = page.getByRole(AriaRole.PARAGRAPH).filter(new Locator.FilterOptions().setHasText(filter));
        playwright.clickOn(statusDtPndptn);

        playwright.clickOn(terapkanBtn);
    }

    /**
     * Clicks Cari button
     */
    public void clicksCariBtn(){
        playwright.clickOn(cariBtn);
    }

    /**
     * Refresh page on Disbursement menu
     */
    public void refreshPage(){
        playwright.reloadPage();
    }
}
