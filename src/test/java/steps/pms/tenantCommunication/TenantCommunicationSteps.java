package steps.pms.tenantCommunication;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.pms.HomepagePO;
import pageobject.pms.tenantCommunication.TenantCommunicationPO;

import java.util.List;
import java.util.Map;

public class TenantCommunicationSteps {
    Page page = ActiveContext.getActivePage();
    TenantCommunicationPO tenantCommunication = new TenantCommunicationPO(page);
    HomepagePO homepage = new HomepagePO(page);


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
            Assert.assertTrue(tenantCommunication.isPropertyNameOnMainPageFilter(propertyName));
    }
    @Then("user verify nama property on profile page filter is {string}")
    public void user_verify_nama_property_on_profile_page_filter_is(String propertyName) {
        Assert.assertTrue(tenantCommunication.isPropertyNameOnProfilePageFilter(propertyName));
    }

    @Then("user can see {string} on page")
    public void user_see_empty_data_on_page(String text){
        Assert.assertEquals(tenantCommunication.getEmptyPageTenatTrackerText(),text);
    }

    @And("user click action Button on tenant communication page")
    public void userClickActionButtonOnTenantCommunicationPage() {
        tenantCommunication.clickActionButton();
    }

    @And("user set the initial state to {string}")
    public void userSetTheInitialStateTo(String state) {
        tenantCommunication.setStateActionTenantCommunication(state);
    }

    @Then("user verify search result on main page bse contains {string}")
    public void userVerifySearchResultOnMainPageBseContains(String stateText) {
        Assert.assertEquals(tenantCommunication.getStateActionTextButton(stateText), stateText);
    }

    @Then("user verify nama penyewa on main page filter is {string}")
    public void user_verify_nama_penyewa_on_main_page_filter_is(String tenantName) {
        Assert.assertEquals(tenantCommunication.getTenantNameOnMainPageFilter(tenantName), tenantName, "Tenant Name does not match" + tenantName);
    }

    @Then("user see display data row from 20 riwayat")
    public void user_see_display_data_row_from_20_riwayat() {
        Assert.assertTrue(tenantCommunication.verifyDisplayDataRow());
    }

    @Then("user see at Tenant Main Page Column contains")
    public void user_see_at_Tenant_Main_Page_Column_contains(DataTable dataTable) {
        List<Map<String, String>> table = dataTable.asMaps();
        int i=0;
        for (Map<String, String> content : table) {
            Assert.assertEquals(tenantCommunication.getColumnName(i),content.get("Head Table"),"Table Segment should contain " + content.get("Head Table"));
            i++;
        }
    }

    @And("user fill {string} in note field")
    public void user_fill_note_field(String keyword) {
        tenantCommunication.clickOnTambahCatatan();
        tenantCommunication.enterTextNote(keyword);
        tenantCommunication.clickSimpanNote();
    }

    @Then("user verify search result on main page bse contains Prioritaskan")
    public void user_verify_search_result_on_main_page_bse_contains_Prioritaskan() {
        Assert.assertEquals(tenantCommunication.getFilterResultNote(), "prioritaskan");
    }

    @And("user click note prioritaskan")
    public void user_click_Note_Prioritaskan() {
        tenantCommunication.clickPrioritaskan();
    }

    @And("user clear note field")
    public void user_clear_note_field() {
        tenantCommunication.clearNoteField();
        tenantCommunication.clickSimpanNote();
    }

    @Then("user verify search result on main page bse contains Tambah Catatan")
    public void user_verify_search_result_on_main_page_bse_contains_Tambah_Catatan() {
        Assert.assertTrue(tenantCommunication.isFieldNoteClear(), "note is appear");
    }

    @And("user filled {string} in note field tracker WA status")
    public void user_filled_note_field_tracker_wa_status(String keyword) {
        tenantCommunication.enterTextNoteStatusWA(keyword);
    }

    @And("user click Tambah in tracker status WA")
    public void user_click_Tambah_in_tracker_status_WA() {
        tenantCommunication.clickTambahStatusWA();
    }

    @Then("success add tracker pop-up appear and {string} Status is updated")
    public void success_add_tracker_pop_up_appear_and_whatsapp_status_is_updated(String WA) {
        Assert.assertEquals(tenantCommunication.getTextStatusWA(), WA, "status matched");
    }

    @And("user click track status chat WA")
    public void user_click_track_status_chat_wa() {
        tenantCommunication.clickTrackStatusWAButton();
    }

    @And("user search kost name with {string}")
    public void user_search_kost_name_with(String kostName) {
        tenantCommunication.searchKostName(kostName);
    }
}
