package pageobject.owner.mamiprime;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.PlaywrightHelpers;

public class MamiprimeRiwayatPembelianPO {
    private Page page;
    private PlaywrightHelpers playwright;
    Locator doesntHaveTransactionText;
    Locator doesntHaveTransactionDescText;

    public MamiprimeRiwayatPembelianPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.doesntHaveTransactionText = page.getByTestId("prime-history-on-progress").getByText("Belum Ada Transaksi");
        this.doesntHaveTransactionDescText = page.getByTestId("prime-history-on-progress").getByText("Transaksi yang masih dalam proses akan muncul di halaman ini.");
    }

    /**
     * Get Text doesnt have transaction mamiprime at tab dalam proses
     *
     * @return Belum Ada Transaksi
     */
    public boolean getDoesntHaveTransactionText(){
        return doesntHaveTransactionText.isVisible();
    }

    /**
     * Get Text doesnt have transaction desc mamiprime at tab dalam proses
     *
     * @return Transaksi yang masih dalam proses akan muncul di halaman ini.
     */
    public boolean getDoesntHaveTransactionDescText(){
        return doesntHaveTransactionDescText.isVisible();
    }

}
