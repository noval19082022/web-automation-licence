package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import pageobject.owner.PropertySayaPO;
import utilities.PlaywrightHelpers;

public class PropertySayaSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    PropertySayaPO propertySaya = new PropertySayaPO (page);


    @And("owner search kost {string} on property saya page")
    public void ownerSearchKostOnPropertySayaPage(String kostName) {
        propertySaya.searchKostPropertySaya(kostName);
    }

    @And("owner click update kamar kost")
    public void ownerClickUpdateKamarKost() {
        propertySaya.clickUpdateKamarButton();
    }

    @And("owner set status kamar is kosong")
    public void ownerSetStatusKamarIsKosong() {
        propertySaya.clickUpdateKamarEmptyButton();
    }
}
