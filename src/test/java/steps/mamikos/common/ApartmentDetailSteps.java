package steps.mamikos.common;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import pageobject.common.apartment.ApartmentDetailPO;

public class ApartmentDetailSteps {
    Page page = ActiveContext.getActivePage();
    ApartmentDetailPO apartment = new ApartmentDetailPO (page);

    @And("user click on hubungi pengelola button")
    public void userClickOnHubungiPengelolaButton() {
        apartment.clickContactApt();
    }
}
