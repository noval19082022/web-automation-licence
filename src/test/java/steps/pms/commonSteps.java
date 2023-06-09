package steps.pms;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.When;
import pageobject.pms.sidebarMenuPO;

public class commonSteps {
    Page page = ActiveContext.getActivePage();

    sidebarMenuPO menu = new sidebarMenuPO(page);

    @When("admin go to other transation menu")
    public void admin_go_to_other_transation_menu() {
        menu.clickOtherTransactionMenu();
    }

    @When("owner click back button")
    public void ownerClickBackButton() {
        page.goBack();
    }
}
