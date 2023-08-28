package pageobject.admin.mamipay.flip;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

import java.util.regex.Pattern;

public class FlipPO {
    private Page page;
    private PlaywrightHelpers playwrightHelpers;
    private final String flipSanbox = "https://business.flip.id/sandbox/overview";

    //----- login flip locator ----
    private Locator idPlaceholder;
    private Locator emailPlaceholder;
    private Locator passwordPlaceholder;
    private Locator loginBtn;

    //----- flip sandbox -----
    private Locator popUpTextTestMode;
    private Locator moneyTransferredMenu;
    private Locator nextBtnPopUpMoneyTransferred;
    private Locator okPahamBtnPopUpMoneyTransferred;
    private Locator riwayatTransactionMenu;
    private Locator setForceTransaction;
    private Locator setFailedTransaction;

    public FlipPO(Page page) {
        this.page = page;
        this.playwrightHelpers = new PlaywrightHelpers(page);
        //----- login flip -----
        this.idPlaceholder = page.getByPlaceholder("ID Flip for Business");
        this.emailPlaceholder = page.getByPlaceholder("Alamat email akun Anda");
        this.passwordPlaceholder = page.locator("input[name='password']");
        this.loginBtn = page.getByTestId("qa-button");
        //---- flip sandbox ----
        this.popUpTextTestMode = page.locator("div").filter(new Locator.FilterOptions().setHasText("Anda sedang dalam TEST Mode. Untuk kembali dan bertransaksi di LIVE Mode")).nth(3);
        this.moneyTransferredMenu = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Money Transfer"));
        this.nextBtnPopUpMoneyTransferred = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Selanjutnya"));
        this.okPahamBtnPopUpMoneyTransferred = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("OK, Paham"));
        this.riwayatTransactionMenu = page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Buat TransaksiRiwayat Transaksi$"))).getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Riwayat Transaksi"));
        this.setForceTransaction = page.getByTestId("qa-button").getByText("Force Success").first();
        this.setFailedTransaction = page.getByTestId("qa-button").getByText("Force Failed").first();
    }

    /**
     * visit bigflip sandbox and login into sandbox
     *
     * @param userName
     * @param email
     * @param password
     */
    public void visitFlipSandboxAndLogin(String userName, String email, String password) {
        playwrightHelpers.navigateTo(flipSanbox, 30000.0);
        playwrightHelpers.clickLocatorAndTypeKeyboard(idPlaceholder, userName);
        playwrightHelpers.clickLocatorAndTypeKeyboard(emailPlaceholder, email);
        playwrightHelpers.clickLocatorAndTypeKeyboard(passwordPlaceholder, password);
        playwrightHelpers.clickOn(loginBtn);
        playwrightHelpers.hardWait(3000.0);
    }

    /**
     * verify on test mode https://business.flip.id/sandbox/overview
     *
     * @return boolean
     */
    public boolean verifyOnTestMode() {
        return playwrightHelpers.waitTillLocatorIsVisible(popUpTextTestMode);
    }

    /**
     * user navigate to riwayat transaction
     */
    public void navigateToRiwayatTransaction() {
        playwrightHelpers.clickOn(moneyTransferredMenu);
        dismissPopUpMoneyTransferredMenu();
        playwrightHelpers.clickOn(riwayatTransactionMenu);
    }

    /**
     * set force transaction for refund
     */
    public void setForceTransaction() {
        playwrightHelpers.clickOn(setForceTransaction);
    }

    /**
     * set failed transaction for refund
     */
    public void setFailedTransaction() {
        playwrightHelpers.clickOn(setFailedTransaction);
    }

    /**
     * Action to dismiss pop up on Money Transferred Menu
     */
    private void dismissPopUpMoneyTransferredMenu() {
        playwrightHelpers.waitTillLocatorIsVisible(nextBtnPopUpMoneyTransferred);
        do {
            playwrightHelpers.clickOn(nextBtnPopUpMoneyTransferred);
        } while (playwrightHelpers.waitTillLocatorIsVisible(nextBtnPopUpMoneyTransferred));

        if (playwrightHelpers.waitTillLocatorIsVisible(okPahamBtnPopUpMoneyTransferred)) {
            playwrightHelpers.clickOn(okPahamBtnPopUpMoneyTransferred);
        }
    }
}