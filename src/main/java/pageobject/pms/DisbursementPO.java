package pageobject.pms;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import config.global.GlobalConfig;
import config.playwright.context.ActiveContext;
import utilities.PlaywrightHelpers;

public class DisbursementPO {
    private Page page;
    private PlaywrightHelpers playwright;

    //---Disbursement Page---//
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
    Locator searchProperty;

    //---Detail Transfer Pendapatan Page---//
    Locator tambahkanTransaksiBtn;
    Locator rincianPenjualanSection;
    Locator tambahkanBtnBiayaLainnya;
    Locator biayaPenguranganSection;
    Locator tambahkanBtnTambahanPendapatan;
    Locator tambahanPendapatanSection;
    Locator riwayatTransferPendapatanBtn;
    Locator refreshHalamanIniBtn;

    public DisbursementPO(Page page) {
        this.page = page;
        playwright = new PlaywrightHelpers(page);

        //---Disbursement Page---//
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
        searchProperty = page.getByPlaceholder("Cari Nama Properti");

        //---Detail Transfer Pendapatan Page---//
        tambahkanTransaksiBtn = page.locator("//button[contains(., 'Tambahkan Transaksi')]");
        tambahkanBtnBiayaLainnya = page.locator("//button[contains(., 'Tambahkan')]").nth(1);
        tambahkanBtnTambahanPendapatan = page.locator("//button[contains(., 'Tambahkan')]").nth(2);
        rincianPenjualanSection = page.locator("//div[@class='invoice-interaction mb-24']");
        biayaPenguranganSection = page.locator("//div[@class='flex align-center justify-space-between mb-24']").nth(0);
        tambahanPendapatanSection = page.locator("//div[@class='flex align-center justify-space-between mb-24']").nth(1);
        riwayatTransferPendapatanBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("calendar Riwayat Transfer Pendapatan"));
        refreshHalamanIniBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("reload Refresh Halaman ini"));
    }

    /**
     * Check button is exist or not in Disbursement page
     * @param button
     * @return boolean
     */
    public boolean isButtonExistInDisbursement(String button) {
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
     * Check button is exist or not in Disbursement - Detail Transfer Pendapatan page
     * @param button
     * @return
     */
    public boolean isButtonExistInDetailTransferPendapatan(String button){
        boolean exist = false;
        switch (button){
            case "Tambahkan Transaksi":
                if (playwright.isLocatorVisibleAfterLoad(actionBtn, GlobalConfig.DEFAULT_NAVIGATION_TIMEOUT)){
                   playwright.clickOn(actionBtn);
                   playwright.clickOn(seeDetailBtn);
                   playwright.pageScrollInView(rincianPenjualanSection);
                   exist = playwright.isLocatorVisibleAfterLoad(tambahkanTransaksiBtn, GlobalConfig.DEFAULT_NAVIGATION_TIMEOUT);
                }
                break;
            case "Tambahkan in Biaya Lainnya":
                playwright.pageScrollInView(biayaPenguranganSection);
                if (playwright.isLocatorVisibleAfterLoad(tambahkanBtnBiayaLainnya, GlobalConfig.DEFAULT_NAVIGATION_TIMEOUT)){
                    exist = playwright.isLocatorVisibleAfterLoad(tambahkanBtnBiayaLainnya, GlobalConfig.DEFAULT_NAVIGATION_TIMEOUT);
                }
                break;
            case "Tambahkan in Tambahan Pendapatan":
                playwright.pageScrollInView(tambahanPendapatanSection);
                if (playwright.isLocatorVisibleAfterLoad(tambahkanBtnTambahanPendapatan, GlobalConfig.DEFAULT_NAVIGATION_TIMEOUT)){
                    exist = playwright.isLocatorVisibleAfterLoad(tambahkanBtnTambahanPendapatan, GlobalConfig.DEFAULT_NAVIGATION_TIMEOUT);
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

//    /**
//     * Clicks Cari button
//     */
//    public void clicksCariBtn(){
//        playwright.clickOn(cariBtn);
//    }

    /**
     * Refresh page on Disbursement menu
     */
    public void refreshPage(){
        playwright.reloadPage();
    }

    public void searchProperty(String property){
        playwright.fill(searchProperty, property);
        playwright.clickOn(cariBtn);
    }

    public void clicksLihatDetail(){
        playwright.clickOn(actionBtn);
        playwright.clickOn(seeDetailBtn);
    }

    public Page clicksRiwayatTransferPendapatan(){
        page = page.waitForPopup(() -> {playwright.clickOn(riwayatTransferPendapatanBtn);});
        ActiveContext.setActivePage(page);
        return ActiveContext.getActivePage();

//        page = page.waitForPopup(() -> {invoiceNumberLast.click();});
//        ActiveContext.setActivePage(page);
//        return ActiveContext.getActivePage();
//        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("reload Refresh Halaman ini")).click();
    }

    public void clicksRefreshHalamanIniBtn() {
        playwright.clickOn(refreshHalamanIniBtn);
    }
}
