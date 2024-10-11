package steps.mamikos.bangkrupux;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import pageobject.admin.mamipay.bangkrupux.AdminGoldplusPO;

public class AdminGoldplusSteps {
    Page page = ActiveContext.getActivePage();
    AdminGoldplusPO adminGoldplusPO = new AdminGoldplusPO(page);


}
