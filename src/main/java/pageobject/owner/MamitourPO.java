package pageobject.owner;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class MamitourPO {
    private Page page;
    private PlaywrightHelpers playwright;

    private Locator pesanSekarangBtn;
    private Locator titleBelumAdaPropertiPopup;
    private Locator subtitleBelumAdaPropertiPopup;
    private Locator pusatBantuan;
    private Locator riwayatBtn;
    private Locator pesanSkrgPaket3Bulan;
    // ---    Riwayat    --- //
    private Locator dalamProsesTab;
    private Locator selesaiTab;
    private Locator emptyStateTitleText;
    private Locator emptyStateDalamProsesSubtitleText;
    private Locator emptyStateSelesaiSubtitleText;
    private Locator firstHistoryList;
    // ---   Detail Tagihan    --- //
    private Locator choosePackageDropdown;
    private Locator pesanSekarangDetailPemesanan;
    private Locator bacaPanduanButton;
    private Locator titleOrderAcceptedPopup;
    private Locator subtitleOrderAcceptedPopup;
    private Locator closePopupOrderMamitour;
    private Locator titlePanduanMamitourPoup;
    private Locator closePopupPanduan;
    private Locator addExtraButton;
    private Locator removeExtraButton;
    private Locator totalPriceText;

    public MamitourPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.pesanSekarangBtn = page.getByTestId("mamitour-landing-header-button");
        this.titleBelumAdaPropertiPopup = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Belum Ada Properti Aktif"));
        this.subtitleBelumAdaPropertiPopup = page.getByText("Tambahkan kos/apartemen terlebih dahulu untuk bisa memesan MamiTour.");
        this.pusatBantuan = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ke Pusat Bantuan"));
        this.riwayatBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lihat Riwayat"));
        this.pesanSkrgPaket3Bulan = page.getByTestId("mamitour-landing-package-button").first();
        this.dalamProsesTab = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Dalam Proses"));
        this.selesaiTab = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Selesai"));
        this.emptyStateTitleText = page.getByText("Belum Ada Transaksi");
        this.emptyStateDalamProsesSubtitleText = page.getByText("Transaksi yang masih dalam proses akan muncul di halaman ini.");
        this.emptyStateSelesaiSubtitleText = page.getByText("Transaksi yang telah selesai akan muncul di halaman ini.");
        this.firstHistoryList = page.getByTestId("mamitour-history-card").first();
        this.choosePackageDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih paket Anda dropdown-down"));
        this.pesanSekarangDetailPemesanan = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pesan Sekarang"));
        this.bacaPanduanButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Baca Panduan"));
        this.titleOrderAcceptedPopup = page.getByText("Pesanan MamiTour Telah Diterima");
        this.subtitleOrderAcceptedPopup = page.getByText("Dalam 3 hari kerja, Anda akan dihubungi tim Mamikos untuk pembayaran dan pembuat");
        this.closePopupOrderMamitour =  page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("close"));
        this.titlePanduanMamitourPoup = page.getByText("Panduan persiapan foto/video");
        this.closePopupPanduan = page.locator("//div[@data-testid='mamitour-guides-modal']//button").nth(1);
        this.totalPriceText = page.getByTestId("mamitourTotalPayment");
    }

    /**
     * click on pesan sekarang in mamitour landing page
     */
    public void clickOnPesanSekarang() {
        playwright.clickOn(pesanSekarangBtn);
    }

    /**
     * get text title on popup belum ada properti aktif
     * @return String
     */
    public String getTitleBelumAdaProperti() {
        return playwright.getText(titleBelumAdaPropertiPopup);
    }

    /**
     * get text subtitle on popup belum ada properti aktif
     * @return String
     */
    public String getSubtitleBelumAdaProperti() {
        return playwright.getText(subtitleBelumAdaPropertiPopup);
    }

    /**
     * click on pusat bantuan on mamitour
     * Opens a new tab with the help center page
     */
    public void clickOnPusatBantuan() {
        playwright.waitTillLocatorIsVisible(pusatBantuan, 10000.0);
        Page helpPage = page.waitForPopup(() -> {
            pusatBantuan.click();
        });
        helpPage.waitForLoadState();
        helpPage.bringToFront();
    }

    /**
     * Check is it title content is visible
     * @return boolean type, appear true otherwise false
     */
    public boolean isContentOnMamitourVisible(String titleContent) {
        Locator title = page.getByText(titleContent);
        playwright.waitTillLocatorIsVisible(title);
        return playwright.waitTillLocatorIsVisible(title);
    }

    /**
     * check is riwayat button visible in mamitour dashboard
     * @return boolean
     */
    public boolean isRiwayatButtonVisible() {
        playwright.waitTillPageLoaded();
        playwright.waitTillLocatorIsVisible(riwayatBtn,10000.0);
        return playwright.waitTillLocatorIsVisible(riwayatBtn);
    }

    /**
     * click on lihat riwayat button on mamitour dashboard
     */
    public void clickOnRiwayatButton() {
        playwright.clickOn(riwayatBtn);
    }

    /**
     * click on dalam proses tab in riwayat
     */
    public void clickOnDalamProsesTab() {
        playwright.clickOn(dalamProsesTab);
    }

    /**
     * click on selesai tab in riwayat
     */
    public void clickOnSelesaiTab() {
        playwright.clickOn(selesaiTab);
    }

    /**
     * get title of empty state in riwayat
     * @return String
     */
    public String getEmptyStateTitleText() {
        playwright.waitTillLocatorIsVisible(emptyStateTitleText);
        return playwright.getText(emptyStateTitleText);
    }

    /**
     * get subtitle of empty state in riwayat
     * @return String
     */
    public String getEmptyStateSubtitleText() {
        playwright.waitTillLocatorIsVisible(emptyStateSelesaiSubtitleText.or(emptyStateDalamProsesSubtitleText));
        return playwright.getText(emptyStateSelesaiSubtitleText.or(emptyStateDalamProsesSubtitleText));
    }

    /**
     * check is first history on mamitour visible or not
     * @return boolean
     */
    public boolean isHistoryListVisible() {
        return playwright.waitTillLocatorIsVisible(firstHistoryList);
    }

    /**
     * check is package dropdown still in default state or not
     * @return boolean
     */
    public boolean isChooseMamitourPackageDropdownVisible() {
        return playwright.waitTillLocatorIsVisible(choosePackageDropdown);
    }

    /**
     * check is pesan sekarang button enable or not
     * @return boolean
     */
    public boolean isPesanSekarangDetailPemesananEnable() {
        return pesanSekarangDetailPemesanan.isEnabled();
    }

    /**
     * click on pesan sekarang button
     */
    public void clickOnPesanSekarangDetail() {
        playwright.clickOn(pesanSekarangDetailPemesanan);
    }

    /**
     * click and choose mamitour package
     * @param packageName
     */
    public void clickAndChooseMamitourPackage(String packageName) {
        Locator choosenPackage = page.locator("a").filter(new Locator.FilterOptions().setHasText(packageName));
        playwright.clickOn(choosePackageDropdown);
        playwright.clickOn(choosenPackage);
    }

    /**
     * click on baca panduan button on pesanan dirima popup
     */
    public void clickOnBacaPanduan() {
        playwright.clickOn(bacaPanduanButton);
    }

    /**
     * check is it order accepted title is visible or not
     * @return boolean
     */
    public boolean isTitleOrderAcceptedPopupVisible() {
        return playwright.waitTillLocatorIsVisible(titleOrderAcceptedPopup);
    }

    /**
     * check is it order accepted subtitle is visible or not
     * @return boolean
     */
    public boolean isSubtitleOrderAcceptedPopupVisible() {
        return playwright.waitTillLocatorIsVisible(subtitleOrderAcceptedPopup);
    }

    /**
     * click on close button on popup after purchase mamitour
     */
    public void clickOnClosePopupOrderMamitour() {
        playwright.clickOn(closePopupOrderMamitour);
    }

    /**
     * check is popup panduan visible or not
     * @return boolean
     */
    public boolean isPopupPanduanVisible() {
        return playwright.waitTillLocatorIsVisible(titlePanduanMamitourPoup);
    }

    /**
     * click on close button in panduan mamitour popup
     */
    public void clickOnClosePanduanPopup() {
        playwright.clickOn(closePopupPanduan);
    }

    /**
     * click on add extra lantai/ruangan button
     */
    public void clickOnAddExtra(int number, String extra) {
        addExtraButton = page.locator("//*[.='Ekstra "+ extra +"']/../../../following-sibling::*//button[.='add-plus']");
        for (int i = 1; i<=number; i++) {
            playwright.clickOn(addExtraButton);
        }
    }

    /**
     * click on remove extra lantai/ruangan button
     */
    public void clickOnRemoveExtra(int number, String extra) {
        removeExtraButton = page.locator("//*[.='Ekstra "+ extra +"']/../../../following-sibling::*//button[.='add-minus']");
        for (int i = 1; i<=number; i++) {
            playwright.clickOn(removeExtraButton);
        }
    }

    /**
     * get total price text on detail tagihan mamitour
     * @return String
     */
    public String getTotalPriceText() {
        return playwright.getText(totalPriceText);
    }

    /**
     * click on pesan sekarang paket 3 bulan on landing page
     */
    public void clickOnPesanSekarangPaket3Bulan() {
        playwright.clickOn(pesanSkrgPaket3Bulan);
    }
}
