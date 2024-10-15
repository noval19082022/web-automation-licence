package pageobject.owner.mamiprime;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;
import config.global.GlobalConfig;
import data.mamikos.Mamikos;
import utilities.PlaywrightHelpers;

public class MamiprimeRiwayatPembelianPO {
    private Page page;
    private PlaywrightHelpers playwright;
    Locator noTransactionDalamProsesText;
    Locator noTransactionDalamProsesDescText;
    Locator noTransactionSelesaiText;
    Locator noTransactionSelesaiDescText;
    Locator mamiprimeSelesaiTab;
    Locator unpaidTransactionMamiprimeList;

    public MamiprimeRiwayatPembelianPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.noTransactionDalamProsesText = page.getByTestId("prime-history-on-progress").getByText("Belum Ada Transaksi");
        this.noTransactionDalamProsesDescText = page.getByTestId("prime-history-on-progress").getByText("Transaksi yang masih dalam proses akan muncul di halaman ini.");
        this.noTransactionSelesaiText = page.getByTestId("prime-history-done").getByText("Belum Ada Transaksi");
        this.noTransactionSelesaiDescText = page.getByTestId("prime-history-done").getByText("Transaksi yang telah selesai akan muncul di halaman ini.");
        this.mamiprimeSelesaiTab = page.locator("//a[contains(.,'Selesai')]");
        this.unpaidTransactionMamiprimeList = page.getByText("Lihat Detail").first();
    }

    /**
     * Navigates to Riwayat Pembelian Mamiprime
     */
    public void navigatesToRiwayatPembelianMamiprime() {
        playwright.navigateTo(Mamikos.OWNER_URL + Mamikos.MAMIPRIME_HISTORY, GlobalConfig.LONG_TIMEOUT, LoadState.LOAD);
    }

    /**
     * Get Text doesnt have transaction mamiprime at tab dalam proses
     *
     * @return Belum Ada Transaksi
     */
    public boolean isNoTransactionDalamProsesTextDisplayed(){
        return noTransactionDalamProsesText.isVisible();
    }

    /**
     * Get Text doesnt have transaction desc mamiprime at tab dalam proses
     *
     * @return Transaksi yang masih dalam proses akan muncul di halaman ini.
     */
    public boolean isNoTransactionDalamProsesDescTextDisplayed(){
        return noTransactionDalamProsesDescText.isVisible();
    }

    /**
     * Get Text doesnt have transaction mamiprime at tab selesai
     *
     * @return Belum Ada Transaksi
     */
    public boolean isNoTransactionSelesaiTextDisplayed(){
        return noTransactionSelesaiText.isVisible();
    }

    /**
     * Get Text doesnt have transaction desc mamiprime at tab selesai
     *
     * @return Transaksi yang telah selesai akan muncul di halaman ini.
     */
    public boolean isNoTransactionSelesaiDescTextDisplayed(){
        return noTransactionSelesaiDescText.isVisible();
    }

    /**
     * Click on Tab Selesai at riwayat pembelian mamiprime
     *
     */
    public void clickOnMamiprimeSelesaiTab() {
        playwright.clickOn(mamiprimeSelesaiTab);
    }

    /**
     * Unpaid list of transaction mamiprime
     *
     * @return True if there is transaction
     */
    public boolean isUnpaidTransactionMamiprimeListDisplayed(){
        return unpaidTransactionMamiprimeList.isVisible();
    }

    /**
     * Click on latest unpaid transaction mamiprime
     *
     */
    public void clickOnLatestUnpaidTransactionMamiprime() {
        playwright.clickOn(unpaidTransactionMamiprimeList, GlobalConfig.LONG_TIMEOUT, WaitForSelectorState.ATTACHED);
    }
}
