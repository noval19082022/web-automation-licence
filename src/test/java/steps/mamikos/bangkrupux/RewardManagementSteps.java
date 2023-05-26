package steps.mamikos.bangkrupux;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.admin.mamipay.bangkrupux.BlacklistUserPO;
import pageobject.admin.mamipay.bangkrupux.RewardManagementPO;
import pageobject.common.HomePO;

public class RewardManagementSteps {
    Page page = ActiveContext.getActivePage();
    RewardManagementPO rewardManagement = new RewardManagementPO(page);
    HomePO home = new HomePO(page);

    @When("user access to Reward List menu")
    public void userAccessToRewardListMenu() {
        rewardManagement.clickOnRewardListMenu();
    }

    @And("system display Reward List Management page")
    public void system_Display_Reward_List_Management_Page(){
        for (int i = 0; i < 10; i++){
            Assert.assertTrue(rewardManagement.fieldOnTableIsDisplayed(i));
        }
        Assert.assertTrue(rewardManagement.rewardListHeaderIsDisplayed());
        Assert.assertTrue(rewardManagement.filterButtonIsDisplayed());
        Assert.assertTrue(rewardManagement.addRewardButtonIsDisplayed());
    }

    @And("user filter reward name {string}")
    public void user_Filter_Reward_Name(String rewardName) {
        rewardManagement.setRewardTypeNameOnFilter(rewardName);
    }

    @And("user click button filter reward")
    public void user_Click_Button_Filter_Reward() {
        rewardManagement.clickOnFilterRewardList();
    }

    @And("user click button update reward")
    public void user_Click_Button_Update_Reward() {
        rewardManagement.clickOnUpdateRewardList();
    }

    @And("user click checkbox Active")
    public void user_Click_Checkbox() {
        rewardManagement.setStatusRewardList();
    }

    @And("user click button update reward on page detail reward")
    public void user_Click_Button_Update_Reward_On_Page_Detail_Reward(){
        rewardManagement.clickOnUpdateReward();
    }

    @Then("system display success add reward type")
    public void system_Display_Success_Add_Reward_Type() {
        Assert.assertTrue(rewardManagement.successAddRewardTypeIsDisplayed(), "succes add reward label is not present");
    }

    @Given("user click Add Reward button")
    public void user_click_add_reward_button() {
        rewardManagement.clickOnAddRewardButton();
    }

    @And("user fill required field with correct value")
    public void user_fill_required_field_with_correct_value() {
        rewardManagement.inputRewardField();
    }

    @And("user submit Reward")
    public void user_submit_reward() {
        rewardManagement.clickOnSubmmitReward();
    }
}
