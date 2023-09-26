package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import pageobject.owner.UpdatePricePO;


public class UpdatePriceSteps {
    Page page = ActiveContext.getActivePage();
    UpdatePricePO updatePrice = new UpdatePricePO (page);


}
