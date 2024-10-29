package steps.mamikos.owner.kos;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.When;
import pageobject.owner.kos.CreateKosPO;

import static org.testng.Assert.assertTrue;

public class CreateKosSteps {
    Page page = ActiveContext.getActivePage();
    private CreateKosPO createKos = new CreateKosPO(page);

    @When("owner clicks on Tambah Kos Baru button")
    public void ownerClickOnLeftletMarker() {
        createKos.clickOnTambahKosBaruButton();
    }
}
