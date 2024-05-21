package steps.mamikos.owner.mamiads;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.common.HomePO;
import pageobject.owner.AddTenantPO;
import utilities.PlaywrightHelpers;

public class AddTenantSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    AddTenantPO addTenantPO = new AddTenantPO(page);
    HomePO homePO = new HomePO(page);

    @And("user select kost {string} for tenant")
    public void userSelectKostForTenant(String kosName) {
        addTenantPO.selectKosToAddContract(kosName);
    }

    @Then("owner can sees full pop up restriction")
    public void ownerCanSeesFullPopUpRestriction() {
        Assert.assertTrue(addTenantPO.getFullRoomRestriction("Seluruh Kamar Kos Sudah Terisi"), "Title doesn't macth!");
        Assert.assertTrue(addTenantPO.getFullRoomRestriction("Saat ini sistem kami mencatat seluruh kamar Kos Anda sudah penuh. Anda bisa mengubahnya di sini."));
    }

    @When("owner clicks on {string} on full room pop up restriction")
    public void ownerClicksOnOnFullRoomPopUpRestriction(String buttonText) {
        addTenantPO.clickOnPopUpButton(buttonText);
    }

    @Then("owner redirected to update room page")
    public void ownerRedirectedToUpdateRoomPage() {
        Assert.assertTrue(homePO.getURL().contains("/edit"));
        page.goBack();
    }

    @And("owner can not sees full room pop up restriction")
    public void ownerCanNotSeesFullRoomPopUpRestriction() {
        Assert.assertFalse(addTenantPO.isFullRoomPopUp());
    }

    @And("owner input phone number with {string}")
    public void ownerInputPhoneNumberWith(String tenantPhone) {
        addTenantPO.inputTenantPhone(tenantPhone);
    }

    @And("owner choose first available room and clicks on add renter button")
    public void ownerChooseFirstAvailableRoomAndClicksOnAddRenterButton() {
        addTenantPO.selectFirstRoomNumber();
        addTenantPO.clickOnTerapkanRoomNumber("Terapkan");
    }

    @Then("owner can sees different gender restriction pop-up")
    public void ownerCanSeesDifferentGenderRestrictionPopUp() {
        Assert.assertTrue(addTenantPO.getDifferentGenderPopUpText("Jenis kelamin tidak sama!"));
        Assert.assertTrue(addTenantPO.getDifferentGenderPopUpText("Jenis kelamin penghuni kost harus sama dengan detail kost."));
    }

    @And("owner click button {string} on form informasi penyewa")
    public void ownerClickButtonOnFormInformasiPenyewa(String buttonText) {
        addTenantPO.submitAddTenantForm(buttonText);
    }

    @And("user click continue until start adding contract")
    public void userClickContinueUntilStartAddingContract() {
        int i;
        for (i = 1; i<4; i++){
            addTenantPO.clickOnOnboardingAddTenant("Lanjut");
        }
        addTenantPO.clickOnOnboardingAddTenant("Mulai");
        addTenantPO.selectHowToAddTenant("Saya yang menambah kontrak");
    }

    @When("owner clicks on change room's data on full room pop up restriction")
    public void ownerClicksOnChangeRoomSDataOnFullRoomPopUpRestriction() {
        addTenantPO.clickOnPopUpButton("Ubah Data Kamar");
    }

    @And("user choose owner added the contract")
    public void userChooseOwnerAddedTheContract() {
        addTenantPO.selectHowToAddTenant("Saya yang menambah kontrak");
        }
    }