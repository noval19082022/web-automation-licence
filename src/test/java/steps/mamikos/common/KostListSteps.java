package steps.mamikos.common;

import config.playwright.context.ActiveContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.common.KostListCommonPO;
import utilities.PlaywrightHelpers;

public class KostListSteps {
    KostListCommonPO kostList = new KostListCommonPO(ActiveContext.getActivePage());

    @When("user want to see more kost list")
    public void userWantToSeeMoreKostList() {
        kostList.clickOnLihatLebihBanyakBtn();
    }

    @Then("user verify all room card element is not null")
    public void userVerifyAllRoomCardElementIsNotNull() {
        Assert.assertTrue(kostList.roomCardLocationIsVisible(), "room card location is null");
        Assert.assertTrue(kostList.roomCardFacilityIsVisible(), "room card facility is null");
        Assert.assertTrue(kostList.roomCardDetailFacilityIsVisible(), "room card detail facility is null");
        Assert.assertTrue(kostList.roomCardRatingIsVisible(), "room card ratting is null");
    }

    @Then("user dismiss probut pop up on kost list")
    public void userDismissProbutPopUpOnKostList() {
        var playwright = new PlaywrightHelpers(ActiveContext.getActivePage());
        playwright.pageScrollToDown(2000);
        playwright.hardWait(7_000.0);
        kostList.dismissProbutPopUpOnKostList();
    }

}
