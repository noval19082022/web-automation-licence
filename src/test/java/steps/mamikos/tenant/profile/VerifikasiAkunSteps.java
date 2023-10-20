package steps.mamikos.tenant.profile;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import pageobject.tenant.profile.VerifikasiAkunPO;
import utilities.PlaywrightHelpers;

public class VerifikasiAkunSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);

    VerifikasiAkunPO verifikasiakun = new VerifikasiAkunPO(page);

    @And("user open verifikasi akun menu")
    public void userOpenVerifikasiAkunMenu() {
        verifikasiakun.clickOnVerifikasiAkunMenu();
    }

    @And("user change email to {string}")
    public void userChangeEmailTo(String email) throws InterruptedException {
        verifikasiakun.changeEmail(email);
    }

    @And("user confirm change email")
    public void userConfirmChangeEmail() throws InterruptedException {
        verifikasiakun.confirmEmailFromMailHog();
    }
}
