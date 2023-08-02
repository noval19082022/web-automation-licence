package pageobject.admin.mamipay.flip;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

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
    private Locator riwayatTransactionMenu;
    private Locator domesticTransactionMenu;
    private Locator setForceTransaction;

    public FlipPO(Page page) {
        this.page = page;
        this.playwrightHelpers = new PlaywrightHelpers(page);
        //----- login flip -----
        this.idPlaceholder = page.getByPlaceholder("ID Flip for Business");
        this.emailPlaceholder = page.getByPlaceholder("Alamat email akun Anda");
        this.passwordPlaceholder = page.locator("input[name='password']");
        this.loginBtn = page.getByTestId("qa-button");
        //---- flip sandbox ----
        this.popUpTextTestMode = page.getByText("Anda sedang berada dalam Test Mode.", new Page.GetByTextOptions().setExact(true));
        this.riwayatTransactionMenu = page.getByTestId("qa-menu-bar").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Riwayat Transaksi"));
        this.domesticTransactionMenu = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Domestik"));
        this.setForceTransaction = page.getByTestId("qa-button").getByText("Force Success").first();
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
        idPlaceholder.click();
        page.keyboard().type(userName);
        emailPlaceholder.click();
        page.keyboard().type(email);
        passwordPlaceholder.click();
        page.keyboard().type(password);
        loginBtn.click();
        playwrightHelpers.hardWait(3000.0);
    }

    /**
     * verify on test mode https://business.flip.id/sandbox/overview
     *
     * @return boolean
     */
    public boolean verifyOnTestMode() {
        return popUpTextTestMode.isVisible();
    }

    /**
     * user navigate to domestic transaction
     */
    public void navigateToDomesticTransaction() {
        riwayatTransactionMenu.click();
        domesticTransactionMenu.click();
    }

    /**
     * set force transaction for refund
     */
    public void setForceTransaction() {
        setForceTransaction.click();
    }
}