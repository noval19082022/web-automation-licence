package steps.mamikos.bangkrupux;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.admin.mamipay.bangkrupux.AdditionalKostPO;

public class kostAdditionalSteps {
    Page page = ActiveContext.getActivePage();
    AdditionalKostPO additionalKost = new AdditionalKostPO(page);

    @And("user access menu kost Additional")
    public void userAccessMenuKostAdditional() {
        additionalKost.clickAdditionalKostMenu();
    }

    @And("user search {string} in kost additional")
    public void userSearchInKostAdditional(String keyword) {
        additionalKost.searchKosAdditional(keyword);
    }

    @And("user click on atur ketersediaan button")
    public void userClickOnAturKetersediaanButton() {
        additionalKost.clickButtonAturKetersediaan();
    }

    @When("user click the edit button in room with status is occupied with room name {string}")
    public void userClickTheEditButtonInRoomWithStatusIsOccupiedWithRoomName(String name) {
        additionalKost.clickOnEditButton(name);
    }

    @And("user update room status to {string} and click the update button")
    public void userUpdateRoomStatusToAndClickTheUpdateButton(String updateRoom) {
        additionalKost.updateRoomStatusToEmpty(updateRoom);
    }

    @Then("user can see alert {string} on atur kamar page")
    public void userCanSeeAlertOnAturKamarPage(String text) {
        if (text.equalsIgnoreCase("Kamar dengan kontrak tidak bisa diubah.")) {
            Assert.assertEquals(additionalKost.getAlertText(text), "Kamar dengan kontrak tidak bisa diubah.");
        } else if (text.equalsIgnoreCase("Success! Kamar berhasil di-update")) {
            Assert.assertEquals(additionalKost.getSuccessAlertText(text), "Success!");
        }
    }

    @And("user update lantai name to {string}")
    public void userUpdateLantaiNameTo(String keyword) {
        additionalKost.updateFloorName(keyword);
    }

    @And("user search room id {string} and delete room")
    public void userSearchRoomIdAndDeleteRoom(String text) {
        additionalKost.clickOnDeteleButton(text);
    }

    @Then("user can see popup delete confirmation")
    public void userCanSeePopupDeleteConfirmation() {
        additionalKost.getPopupDeleteConfirmationText();
    }
}
