package steps.mamikos.bangkrupux;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.admin.mamipay.bangkrupux.OwnerChatExperimentPO;

public class OwnerChatExperimentSteps {
    Page page = ActiveContext.getActivePage();
    OwnerChatExperimentPO ownerChatExperiment = new OwnerChatExperimentPO(page);


    @When("user access menu owner chat experiment")
    public void userAccessMenuOwnerChatExperiment() {
        ownerChatExperiment.clickOwnerChatExperimentMenu();
    }

    @And("user clicks on button add owner")
    public void userClicksOnButtonAddOwner() {
        ownerChatExperiment.clickOnAddOwnerButton();
    }

    @And("user add new owner id {string}")
    public void userInputUserId(String ownerId) {
        ownerChatExperiment.inputOwnerId(ownerId);
        ownerChatExperiment.clickOnAddButton();
    }

    @And("user search user id {string}")
    public void userSearchUserId(String ownerId) {
        ownerChatExperiment.searchOwnerId(ownerId);
        ownerChatExperiment.clickOnSearchutton();
    }

    @Then("verify user id {string} was added")
    public void verifyUserIdWasAdded(String userId) {
        Assert.assertTrue(ownerChatExperiment.isUserIdPresent(userId), "user id not found");
    }

    @When("user delete user id")
    public void userDeleteUserId() {
        ownerChatExperiment.clickOnDeleteButton();
    }

    @Then("verify user id {string} was deleted")
    public void verifyUserIdWasDeleted(String userId) {
        Assert.assertFalse(ownerChatExperiment.isUserIdPresent(userId), "user id found");
    }

    @Then("user can click close button on popup")
    public void userCanClickCloseButtonOnPopup() {
        ownerChatExperiment.clickOnCloseButton();
    }

    @When("user clicks on button Bulk Add")
    public void userClicksOnButtonBulkAdd() {
        ownerChatExperiment.clickOnBulkAddButton();
    }

    @And("user upload file owner csv")
    public void userUploadFileOwnerCsv() {
        ownerChatExperiment.uploadBulkAddCSVFile();
        ownerChatExperiment.clickOnAddButton();
    }
}
