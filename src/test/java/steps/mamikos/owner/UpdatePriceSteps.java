package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.owner.PropertySayaPO;
import pageobject.owner.UpdatePricePO;


public class UpdatePriceSteps {
    Page page = ActiveContext.getActivePage();
    UpdatePricePO updatePrice = new UpdatePricePO (page);


}
