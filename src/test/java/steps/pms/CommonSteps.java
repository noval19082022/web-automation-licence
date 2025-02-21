package steps.pms;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.When;
import pageobject.pms.sidebarMenuPO;

public class CommonSteps {
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

    @When("admin go to role management menu")
    public void admin_go_to_role_management_menu() {
        menu.clickRoleManagementMenu();
    }

    @When("admin go to additional fee management menu")
    public void admin_go_to_additional_fee_management_menu() {
        menu.clickAdditionalFeeManagementMenu();
    }

    @When("admin go to Disbursement menu")
    public void admin_go_to_Disbursement_menu(){
        menu.clickDisbursementMenu();
    }
}