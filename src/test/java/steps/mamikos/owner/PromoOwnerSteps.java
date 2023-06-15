package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import pageobject.owner.PromoOwnerPO;
import steps.mamikos.common.NavigatesSteps;
import utilities.PlaywrightHelpers;

public class PromoOwnerSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    NavigatesSteps navigate = new NavigatesSteps();
    PromoOwnerPO promoOwner = new PromoOwnerPO(page);

    @And("owner atur promo owner")
    public void ownerAturPromoOwner() {
        promoOwner.clickOnSelengkapnya();
        playwright.clickOnTextButton("Atur Promo");
    }
}
