package steps.pms.tenantCommunication;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.pms.tenantCommunication.TenantCommunicationPO;

public class TenantCommunicationSteps {
    Page page = ActiveContext.getActivePage();
    TenantCommunicationPO tenantCommunication = new TenantCommunicationPO(page);


    @And("user choose {string} and input {string} in the search field on main page")
    public void userChooseAndInputInTheSearchFieldOnMainPage(String mainPageFilter, String keyword) {
        tenantCommunication.selectMainPageFilter(mainPageFilter);
        tenantCommunication.inputSearchFieldMainPage(keyword);
    }

    @And("user click search button on main page filter")
    public void userClickSearchButtonOnMainPageFilter() {
        tenantCommunication.clickSearchButtonMainPageFilter();
    }

    @And("user clicks on the tenant name on the first row")
    public void user_clicks_on_the_tenant_name_on_the_first_row() {
        tenantCommunication.clickTenantNameOnTheFirstRow();
    }

    @Then("user verify search result on profile page bse contains {string}")
    public void user_verify_search_result_on_profile_page_bse_contains_Profile_Penyewa(String namaPenyewa) {
        Assert.assertEquals(tenantCommunication.getTextProfilPenyewa(), "Profil Penyewa");
        Assert.assertEquals(tenantCommunication.getRenterName(), namaPenyewa, "Nama Penyewa does not match" + namaPenyewa);
        Assert.assertEquals(tenantCommunication.getTextRiwayatPencarianKos(), "Riwayat Pencarian Kos");
    }

    @Then("user see pagination menu on Detail Tenant is displayed")
    public void user_see_pagination_menu_on_detail_tenant() {
        Assert.assertTrue(tenantCommunication.verifyPaginationMenuOnDetailTenant());
    }

    @And("user click pagination number {string}")
    public void user_click_pagination_number(String paginationNumber) {
        tenantCommunication.clickPaginationNumber(paginationNumber);
    }

    @Then("user will be in the second pagination")
    public void user_will_be_in_the_second_pagination() {
        Assert.assertTrue(tenantCommunication.verifySecondPagination());
    }

    @And("user choose {string} on filter tahapan and {string} on filter status")
    public void user_choose_on_filter_tahapan_and_on_filter_status(String filterTahapan,String filterStatus) throws InterruptedException {
        tenantCommunication.clickFilterPenyewa();
        tenantCommunication.selectFilterTahapan(filterTahapan);
        tenantCommunication.selectFilterStatus(filterStatus);
    }

    @And("user click on terapkan button")
    public void userClickOnTerapkanButton() {
        tenantCommunication.clickOnTerapkanButton();
    }

    @And("user click reset button in PMS Admin")
    public void user_click_reset_button_in_PMS_Admin() {
        tenantCommunication.clickOnReset();
    }

    @And("user has reset the filter")
    public void user_has_reset_the_filter() {
        Assert.assertTrue(tenantCommunication.isIconResetIsDisabled());
    }

    @Then("user verify nama property on main page filter is {string}")
    public void user_verify_nama_property_on_main_page_filter_is(String propertyName) {
        Assert.assertTrue(tenantCommunication.isPropertyNameOnMainPageFilter(propertyName));
    }

    @Then("user verify nama property on main page filter is not {string}")
    public void user_verify_nama_property_on_main_page_filter_is_not(String propertyName) {
        Assert.assertFalse(tenantCommunication.isPropertyNameOnMainPageFilter(propertyName));
    }

    @Then("user verify nama property on profile page filter is {string}")
    public void user_verify_nama_property_on_profile_page_filter_is(String propertyName) {
        Assert.assertTrue(tenantCommunication.isPropertyNameOnProfilePageFilter(propertyName));
    }

    @Then("user can see {string} on page")
    public void user_see_empty_data_on_page(String text){
        Assert.assertEquals(tenantCommunication.getEmptyPageTenatTrackerText(),text);
    }
}
