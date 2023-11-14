package steps.mamikos.tenant;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.tenant.profile.ubahPasswordPO;
import utilities.PlaywrightHelpers;

public class ubahPasswordStep {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    ubahPasswordPO ubahPasswordPO = new ubahPasswordPO(page);

    @And("user clicks on pengaturan button")
    public void userClicksOnPengaturanButton() {
        ubahPasswordPO.clickPengaturanButton();
    }

    @And("user fills password lama {string}")
    public void userFillsPasswordLama(String password) {
        ubahPasswordPO.userFillsPasswordLama(password);
    }

    @And("user fills password baru {string}")
    public void userFillsPasswordBaru(String password) {
        ubahPasswordPO.userFillsPasswordBaru(password);
    }

    @Then("user see successfully changed password {string}")
    public void userSeeSuccessfullyChangedPassword(String berhasilubahpassword) throws InterruptedException {
        Assert.assertEquals(ubahPasswordPO.passwordBerhasilDiubahMessage(), berhasilubahpassword, "Error message is not equal too " + berhasilubahpassword);
    }
}
