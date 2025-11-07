package steps.mamikos.owner.kos;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.owner.kos.CreateKosPO;

public class CreateKosSteps {
    Page page = ActiveContext.getActivePage();
    private CreateKosPO createKos = new CreateKosPO(page);

    @When("owner clicks on Tambah Kos Baru button")
    public void ownerClickOnLeftletMarker() {
        createKos.clickOnTambahKosBaruButton();
    }

    @Then("owner should see CTA button Expose Singgahsini")
    public void ownerShouldSeeCTAButtonExposeSinggahsini() {
        String expectedText = "Mau Kos Anda diurus Mamikos? Cek disini";
        String actualText = createKos.getCtaButtonExposeSinggahsiniText();
        Assert.assertEquals(actualText, expectedText, "CTA button text does not match");
    }

    @When("owner click CTA button Expose Singgahsini")
    public void ownerClickCTAButtonExposeSinggahsini() {
        createKos.clickCtaButtonExposeSinggahsini();
    }

    @Then("owner should redirect to singgahsini.id from Kos")
    public void ownerShouldRedirectToSinggahsiniIdFromKos() {
        String expectedUrl = "https://www.singgahsini.id/?redirection_source=%27kos+saya+section+singgahsini%27";
        String actualUrl = createKos.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "URL does not match expected redirection URL");
    }

    @Then("owner should redirect to singgahsini.id from Info Untuk Anda")
    public void ownerShouldRedirectToSinggahsiniIdFromInfoUntukAnda() {
        String expectedUrl = "https://www.singgahsini.id/?redirection_source=info+untuk+anda+section";
        String actualUrl = page.url();
        Assert.assertEquals(actualUrl, expectedUrl, "URL does not match expected redirection URL");
    }

}
