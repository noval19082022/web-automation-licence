package steps.pms;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.pms.ContractManagementPO;
import utilities.PlaywrightHelpers;

public class ContractManagementSteps {
    Page page = ActiveContext.getActivePage();
    ContractManagementPO contractManagement = new ContractManagementPO(page);
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);

    @And("admin clicks on contract {string}")
    public void adminClicksOnContract(String tenantName) {
        contractManagement.clickContractAllotmentLabel(tenantName);
    }

    @And("admin clicks on view contract detail button")
    public void adminClicksOnViewContractDetailButton() {
        contractManagement.clickViewContractDetail();
    }

    @Then("admin can see Ubah button on penyewa section")
    public void adminCanSeeUbahButtonOnPenyewaSection(){
    Assert.assertTrue(contractManagement.penyewaSectionIsVisible(), "not appears penyewa section");
    }

    @And("admin clicks {string} button on penyewa section")
    public void adminClicksUbahButtonOnPenyewaSection(String text) {
        contractManagement.clickEditButton(text);
    }

    @And("admin can see {string} on riwayat page")
    public void adminCanSeeOnRiwayatPage(String text){
        contractManagement.getNotFoundText(text);
    }

    @Then("admin can see updated text with {string}")
    public void adminCanSeeUpdatedTextWith(String text){
        contractManagement.getUpdatedText(text);
    }

    @And("admin click on lampiran")
    public void adminClickOnLampiran(){
        contractManagement.clickLampiran();
    }

    @Then("lampiran image opened in new tab")
    public void lampiranImageOpenedInNewTab() {
        Assert.assertTrue(contractManagement.isLampiranOpenedInNewTab(), "Lampiran should be opened in new tab");
    }

}