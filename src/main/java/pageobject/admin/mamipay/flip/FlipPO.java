package pageobject.admin.mamipay.flip;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class FlipPO {
    private Page page;
    private PlaywrightHelpers playwrightHelpers;
    private final String flipSanbox = "https://business.flip.id/sandbox/overview";

    public FlipPO(Page page) {
        this.page = page;
        this.playwrightHelpers = new PlaywrightHelpers(page);
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
        page.getByPlaceholder("ID Flip for Business").click();
        page.keyboard().type(userName);
        page.getByPlaceholder("Alamat email akun Anda").click();
        page.keyboard().type(email);
        page.locator("input[name='password']").click();
        page.keyboard().type(password);
        page.getByTestId("qa-button").click();
        playwrightHelpers.hardWait(3000.0);
    }

    /**
     * verify on test mode https://business.flip.id/sandbox/overview
     *
     * @return boolean
     */
    public boolean verifyOnTestMode() {
        return page.getByText("Anda sedang berada dalam Test Mode.", new Page.GetByTextOptions().setExact(true)).isVisible();
    }

    /**
     * user navigate to domestic transaction
     */
    public void navigateToDomesticTransaction() {
        page.getByTestId("qa-menu-bar").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Riwayat Transaksi")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Domestik")).click();
    }

    /**
     * set force transaction for refund
     */
    public void setForceTransaction() {
        page.getByTestId("qa-button").getByText("Force Success").first().click();
    }

    /**
     * get text first list account on transferred invoice list
     * @return
     */
    public String transferredUserName() {
        return page.locator("//tbody/tr[1]/td[8]").textContent().trim();
    }
}