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

    @When("admin go to tenant communication menu")
    public void admin_go_to_tenant_communication_menu() {
        menu.clickTenantCommunicationMenu();
    }

    @When("admin go to survey tracker menu")
    public void admin_go_to_survey_tracker_menu() {
        menu.clickSurveyTrackerMenu();
    }
}