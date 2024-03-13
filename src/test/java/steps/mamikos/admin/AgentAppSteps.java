package steps.mamikos.admin;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.admin.mamipay.bangkrupux.AgentAppPO;

import java.util.List;

public class AgentAppSteps {
    Page page = ActiveContext.getActivePage();

    AgentAppPO agentApp = new AgentAppPO(page);

    @When("admin goes to Agent App menu")
    public void admin_goes_to_Agent_App_menu(){
        agentApp.clicksAgentAppMenu();
    }

    @Then("agent column is contains")
    public void agent_column_is_contains(List<String> table){
        for (String columnAgent: table){
            Assert.assertEquals(agentApp.getAgentColumnTable(columnAgent), columnAgent, "Column Name in Agent Table does not match!");
            System.out.println(agentApp.getAgentColumnTable(columnAgent));
        }
    }

    @When("admin checks is active {string} status in Edit page for {string} agent")
    public void admin_checks_is_active_status_in_Edit_page(String isActive, String agent){
        //check agent in list, if not found then go to next page
        while(!agentApp.isAgentFound(agent)){
            if (!agentApp.isNextButtonDisabled()){
                agentApp.clickNextPageAgent();
            } else {
                //if on the last page mean next button disable, but the agent still not found. show agent not found
                System.out.println("Agent "+ agent + " Not Found");
                break;
            }
        }
        if (isActive.equalsIgnoreCase("Yes") && agent.equalsIgnoreCase("Automation PMAN Yes")){
            Assert.assertTrue(agentApp.isActiveStatusInTableEqualYes(isActive), "Is Active Status in Table is not Yes!");
            System.out.println(agentApp.isActiveStatusInTableEqualYes(isActive));
            Assert.assertTrue(agentApp.isAgentEqual(agent), "Agent in Table does not Equal!");
            System.out.println(agentApp.isAgentEqual(agent));

            agentApp.clicksEdit(agent);
        } else if (isActive.equalsIgnoreCase("No") && agent.equalsIgnoreCase("Automation PMAN No")) {
            Assert.assertTrue(agentApp.isActiveStatusInTableEqualYes(isActive), "Is Active Status in Table is not No!");
            System.out.println(agentApp.isActiveStatusInTableEqualYes(isActive));
            Assert.assertTrue(agentApp.isAgentEqual(agent), "Agent in Table does not Equal!");
            System.out.println(agentApp.isAgentEqual(agent));

            agentApp.clicksEdit(agent);
        } else {
            System.out.println("Invalid Is Active Status and Invalid Agent");
        }
    }

    @Then("is active status in Edit page is {string}")
    public void is_active_status_in_Edit_page_is(String isActive){
        if (isActive.equalsIgnoreCase("Yes")){
            Assert.assertFalse(agentApp.isActiveStatusInEdit(isActive), "Is Active Status in Edit is not Yes!");
            System.out.println(agentApp.isActiveStatusInEdit(isActive));
        } else if (isActive.equalsIgnoreCase("No")) {
            Assert.assertFalse(agentApp.isActiveStatusInEdit(isActive), "Is Active Status in Edit is not No!");
            System.out.println(agentApp.isActiveStatusInEdit(isActive));
        } else {
            System.out.println("Invalid Is Active Status");
        }
    }
}
