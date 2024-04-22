package steps.mamikos.admin;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.admin.mamipay.bangkrupux.KostListPO;
import utilities.JavaHelpers;
import utilities.PlaywrightHelpers;

public class KostListSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    KostListPO kostList = new KostListPO(page);

    private static final String MAMIKOS = "src/main/resources/mamikos.properties";
    public static final String ENV = JavaHelpers.getPropertyValue(MAMIKOS, "env");

    //---test data---//
    private String kostLevel = "src/test/resources/testdata/bangkerupuxAdmin/kostLevel.properties";
    private String kostPMANList = "src/test/resources/testdata/bangkerupuxAdmin/kostList.properties";
    private String regularLevel = JavaHelpers.getPropertyValue(kostLevel, "kosLevelRegular_" + ENV);
    private String kostPMAN = JavaHelpers.getPropertyValue(kostPMANList, "kostPMAN");
    private String roomListStaging = JavaHelpers.getPropertyValue(kostPMANList, "roomListStaging");
    private String roomListProd = JavaHelpers.getPropertyValue(kostPMANList, "roomListProd");

    @Then("system displaying content of page kost list")
    public void system_displaying_content_of_page_kost_list(){
        Assert.assertTrue(kostList.isUploadCSVButtonAppears(), "Upload CSV button is not appears");
        Assert.assertTrue(kostList.isKostNameSearchAppears(), "Kost Name is not appears");
        Assert.assertTrue(kostList.isOwnerNameSearchAppears(), "Owner Name is not appears");
        Assert.assertTrue(kostList.isOwnerPhoneNumberSearchAppears(), "Owner Phone Number is not appears");
        Assert.assertTrue(kostList.isAllLevelDropdownAppears(), "All Level Dropdown is not appears");
        Assert.assertTrue(kostList.isSearchButtonAppears(), "Search button is not appears");

        String[] column = {"ID" , "Kost Name", "Owner Name", "Owner Phone Number", "Level", "Flag", "Last Update", "Actions"};

        for (int i=0; i<column.length; i++){
            Assert.assertEquals(kostList.getColumnName(i+1), column[i], "Column name not match");
            System.out.println(kostList.getColumnName(i+1));
        }
    }

    @When("admin clicks on page number {string} of kost list")
    public void admin_clicks_on_page_number_of_kost_list(String pageNumber){
        kostList.clicksOnPageNumber(pageNumber);
    }

    @Then("system display kost list page number {string} is active")
    public void system_display_kost_list_page_number_is_active(String pageNumber){
        Assert.assertTrue(kostList.pageNumberButtonIsActive(pageNumber).contains("active"), "Button is not active");
    }

    @When("admin search kost by name")
    public void admin_search_kost_by_name(){
        if (Mamikos.ENV.equalsIgnoreCase("prod")){
            kostList.searchKostName(roomListProd);
        } else {
            kostList.searchKostName(roomListStaging);
        }
    }

    @When("admin change level to {string} on Edit Kost Level")
    public void admin_change_level_to_on_Edit_Kost_Level(String level){
        kostList.clicksEditKostLevel();

        if (level.equalsIgnoreCase("Reguler")){
            kostList.selectKostLevel(regularLevel);
            kostList.clicksSave();
        } else {
            kostList.selectKostLevel(level);
            kostList.clicksSave();
        }
    }

    @When("the Level is displaying {string}")
    public void the_Level_is_displaying(String level){
        kostList.searchKostName(kostPMAN);

        if (level.equalsIgnoreCase("Reguler")){
            Assert.assertEquals(kostList.getLevelName(), regularLevel, "The Level Name is not Equal");
        } else {
            Assert.assertEquals(kostList.getLevelName(), level,"The Level Name is not Equal");
        }
    }

    @When("admin change charge by to {string} on Edit Kost Level")
    public void admin_change_charge_by_to_on_Edit_Kost_Level(String chargeBy){
        kostList.selectChargeBy(chargeBy);
        kostList.clicksSave();
    }

    @Then("charge by {string} is selected")
    public void charge_by_is_selected(String chargeBy){
        kostList.searchKostName(kostPMAN);
        kostList.clicksEditKostLevel();
        Assert.assertEquals(kostList.getChargeBy(), chargeBy, "The value is not same");
        System.out.println(kostList.getChargeBy());
    }

    @When("admin clicks on Edit Kost Level")
    public void admin_clicks_on_Edit_Kost_Level(){
        kostList.clicksEditKostLevel();
    }
    @Then("show result kost {string}")
    public void show_result_kost(String name) {
        int row = kostList.countRow();

        for (int i = 0; i < row; i++) {
            Assert.assertTrue(kostList.getKostName(i).contains(name));
        }
    }
    @When("admin search kost by owner name {string}")
    public void admin_search_kost_by_owner_name(String name) {
        kostList.searchOwnerName(name);
    }
    @When("admin search kost by owner phone number {string}")
    public void admin_search_kost_by_owner_phone_number(String phone) {
        kostList.searchPhoneNumber(phone);
    }
    @Then("show all kost belongs to owner {string}")
    public void show_all_kost_belongs_to_owner(String name) {
        int row = kostList.countRow();

        for (int i = 0; i < row; i++) {
            Assert.assertEquals(kostList.getOwnerName(i),name);
        }
    }
    @Then("show all kost belongs to owner phone number {string}")
    public void show_all_kost_belongs_to_owner_phone_number(String phone) {
        int row = kostList.countRow();

        for (int i = 0; i < row; i++) {
            Assert.assertEquals(kostList.getOwnerPhoneNumber(i), phone);
        }
    }
}
