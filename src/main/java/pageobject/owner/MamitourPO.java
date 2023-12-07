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
    // ---    Riwayat    --- //
    private Locator dalamProsesTab;
    private Locator selesaiTab;
    private Locator emptyStateTitleText;
    private Locator emptyStateDalamProsesSubtitleText;
    private Locator emptyStateSelesaiSubtitleText;
    private Locator firstHistoryList;

    public MamitourPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.pesanSekarangBtn = page.getByTestId("mamitour-landing-header-button");
        this.titleBelumAdaPropertiPopup = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Belum Ada Properti Aktif"));
        this.subtitleBelumAdaPropertiPopup = page.getByText("Tambahkan kos/apartemen terlebih dahulu untuk bisa memesan MamiTour.");
        this.pusatBantuan = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ke Pusat Bantuan"));
        this.riwayatBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lihat Riwayat"));
        this.dalamProsesTab = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Dalam Proses"));
        this.selesaiTab = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Selesai"));
        this.emptyStateTitleText = page.getByText("Belum Ada Transaksi");
        this.emptyStateDalamProsesSubtitleText = page.getByText("Transaksi yang masih dalam proses akan muncul di halaman ini.");
        this.emptyStateSelesaiSubtitleText = page.getByText("Transaksi yang telah selesai akan muncul di halaman ini.");
        this.firstHistoryList = page.getByTestId("mamitour-history-card").first();
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
     */
    public void clickOnPusatBantuan() {
        playwright.clickOn(pusatBantuan);
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
}
