package steps.mamikos.common;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.common.apartment.ApartmentDetailPO;

public class ApartmentDetailSteps {
    Page page = ActiveContext.getActivePage();
    ApartmentDetailPO apartment = new ApartmentDetailPO (page);

    @And("user click on hubungi pengelola button")
    public void userClickOnHubungiPengelolaButton() {
        Page activePage = ActiveContext.getActivePage();
        ApartmentDetailPO activeApartment = new ApartmentDetailPO(activePage);
        activeApartment.clickContactApt();
    }

    @And("user click on lihat nomor telepon button")
    public void userClickOnLihatNomorTeleponButton() {
        apartment.clicklihatNomorTeleponApt();
    }

    @When("user click on favorite btn on the apartment detail")
    public void userClickOnFavoriteBtnOnTheApartmentDetail() {
        apartment.clickOnFavoriteBtn();
    }

    @When("user click on unfavorite btn on the apartment detail")
    public void userClickOnUnFavoriteBtnOnTheApartmentDetail() {
        apartment.clickOnUnFavoriteBtn();
    }

    @Then("user get success message {string}")
    public void userGetSuccessMessage(String msg) {
        Assert.assertEquals(msg, apartment.getSuccessMessage());
    }

    @And("open first apartment details")
    public void openFirstApartmentDetails() {
        apartment.clickOnApartmentDetail();
    }
}
