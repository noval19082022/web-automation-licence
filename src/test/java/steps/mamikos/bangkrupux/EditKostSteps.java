package steps.mamikos.bangkrupux;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.admin.mamipay.bangkrupux.EditKostPO;

import java.util.List;

public class EditKostSteps {
    Page page = ActiveContext.getActivePage();
    EditKostPO editKost = new EditKostPO(page);

    /**
     * Step to add facility in specific category
     * @param category The facility category (e.g., "Fasilitas Umum", "Fasilitas Kamar")
     * @param dataTable DataTable containing list of facilities to add
     */
    @When("admin add facility in {string}")
    public void admin_add_facility_in(String category, DataTable dataTable) {
        List<String> facilities = dataTable.asList();
        for (String facility : facilities) {
            editKost.addFacility(category, facility);
        }
    }

    /**
     * Step to remove facility in specific category
     * @param category The facility category
     * @param dataTable DataTable containing list of facilities to remove
     */
    @When("admin remove facility in {string}")
    public void admin_remove_facility_in(String category, DataTable dataTable) {
        List<String> facilities = dataTable.asList();
        for (String facility : facilities) {
            editKost.removeFacility(category, facility);
        }
    }

    /**
     * Step to save edit kost changes
     */
    @When("admin save edit kost")
    public void admin_save_edit_kost() {
        editKost.clickSave();
    }

    /**
     * Step to verify success toast message is displayed
     */
    @Then("admin should see success toast message")
    public void admin_should_see_success_toast_message() {
        Assert.assertTrue(editKost.isSuccessToastVisible(), "Success toast message should be visible");
    }

    /**
     * Step to verify specific success toast message text
     * @param expectedMessage The expected success message text
     */
    @Then("admin should see success toast message {string}")
    public void admin_should_see_success_toast_message_with_text(String expectedMessage) {
        Assert.assertTrue(editKost.isSuccessToastVisible(), "Success toast message should be visible");
        Assert.assertEquals(editKost.getSuccessToastMessage(), expectedMessage,
            "Success message should match expected text");
    }
}
