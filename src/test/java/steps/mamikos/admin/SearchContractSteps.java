package steps.mamikos.admin;

import com.microsoft.playwright.Page;
import config.mamikos.Mamikos;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import pageobject.admin.AdminMamipayDashboardPO;
import pageobject.admin.SearchContractPO;

import java.util.List;
import java.util.Map;

public class SearchContractSteps {
    List<Map<String, String>> searchData;
    private Page page = ActiveContext.getActivePage();
    private SearchContractPO searchContract = new SearchContractPO(page);
    private AdminMamipayDashboardPO admin = new AdminMamipayDashboardPO(page);

    @When("admin search contract by tenant phone number:")
    public void adminSearchContractByTenantPhoneNumber(DataTable table) {
        searchData = table.asMaps(String.class, String.class);
        var phoneNumber = searchData.get(0).get("phone " + Mamikos.ENV);
        admin.clickOnSearchContract();
        searchContract.selectSearchBy("renter_phone_number");
        searchContract.fillSearchByValue(phoneNumber);
        searchContract.clickOnSearchButton();
    }
}
