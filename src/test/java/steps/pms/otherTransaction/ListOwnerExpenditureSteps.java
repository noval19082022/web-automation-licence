package steps.pms.otherTransaction;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.pms.otherTransaction.listOwnerExpenditurePO;

import java.util.List;
public class ListOwnerExpenditureSteps {
    Page page = ActiveContext.getActivePage();
    listOwnerExpenditurePO list = new listOwnerExpenditurePO(page);

    @When("admin expand first owner expenditure list")
    public void admin_expand_first_owner_expenditure_list() {
        list.expandFirstList();
    }
    @Then("first owner expenditure detail should be visible")
    public void first_owner_expenditure_detail_should_be_visible() {
        list.assertFirstListDetailVisible();
    }
    @When("admin click lihat lampiran first owner expenditure list")
    public void admin_click_lihat_lampiran_first_owner_expenditure_list() {
        list.clickFirstLihatLampiran();
    }
    @Then("lampiran opened in new tab")
    public void lampiran_opened_in_new_tab() {
        list.assertNewTabOpen();
    }
    @When("admin open filter owner expenditure")
    public void admin_open_filter_owner_expenditure() {
        list.clickFilter();
    }
    @Then("status konfirmasi manager filter should contains option:")
    public void status_konfirmasi_manager_filter_should_contains_option(List<String> tables) {
        list.expandStatusKonfirmasiManagerFilter();
        for (int i=0; i<tables.size(); i++){
            list.assertStatusKonfirmasiManager(i,tables.get(i));
        }
    }
    @Then("status konfirmasi finance filter should contains option:")
    public void status_konfirmasi_finance_filter_should_contains_option(List<String> tables) {
        list.expandStatusKonfirmasiFinanceFilter();
        for (int i=0; i<tables.size(); i++) {
            list.assertStatusKonfirmasiFinance(i, tables.get(i));
        }
    }
    @Then("kategori biaya filter should contains option:")
    public void kategori_biaya_filter_should_contains_option(List<String> tables) {
        list.expandKategoriBiayaFilter();
        for (int i=0; i<tables.size(); i++) {
            list.assertKategoriBiaya(i, tables.get(i));
        }
    }
    @Then("tujuan transfer pengeluaran filter should contains option:")
    public void tujuan_transfer_pengeluaran_filter_should_contains_option(List<String> tables) {
        list.expandTujuanTransferFilter();
        for (String x : tables){
            list.searchAndAssertTujuanTransfer(x);
        }
    }

    @When("admin filter status konfirmasi manager {string}")
    public void admin_filter_status_konfirmasi_manager(String status) {
        list.clickFilter();
        list.selectStatusKonfirmasiManager(status);
        list.applyFilter();
    }
    @Then("system only display owner expenditure with status konfirmasi manager {string}")
    public void system_only_display_owner_expenditure_with_status_konfirmasi_manager(String status) {
        list.assertStatusKonfirmasiManagerData(status);
    }
    @When("admin filter status konfirmasi finance {string}")
    public void admin_filter_status_konfirmasi_finance(String status) {
        list.clickFilter();
        list.selectStatusKonfirmasiFinance(status);
        list.applyFilter();
    }
    @Then("system only display owner expenditure with status konfirmasi finance {string}")
    public void system_only_display_owner_expenditure_with_status_konfirmasi_finance(String status) {
        list.assertStatusKonfirmasiFinanceData(status);
    }
    @When("admin filter kategori biaya {string}")
    public void admin_filter_kategori_biaya(String kategori) {
        list.clickFilter();
        list.selectKategoriBiaya(kategori);
        list.applyFilter();
    }
    @Then("system only display owner expenditure contains biaya {string}")
    public void system_only_display_owner_expenditure_contains_biaya(String kategori) {
        list.assertDataContainsKategoriBiaya(kategori);
    }
    @When("admin filter tujuan transfer {string}")
    public void admin_filter_tujuan_transfer(String vendor) {
        list.clickFilter();
        list.selectTujuanTransfer(vendor);
        list.applyFilter();
    }
    @Then("system only display owner expenditure transfered to {string} {string} {string} {string}")
    public void system_only_display_owner_expenditure_transfered_to(String vendor,String accName, String accNumber, String bank) {
        list.assertVendorName(vendor,accName,accNumber,bank);
    }
    @When("admin choose some filter")
    public void admin_choose_some_filter() {
        list.clickFilter();
        list.selectStatusKonfirmasiManager("Menunggu Konfirmasi");
        list.selectStatusKonfirmasiFinance("Menunggu Konfirmasi");
        list.selectKategoriBiaya("Perbaikan Wifi");
    }
    @When("admin reset filter from pop up")
    public void admin_reset_filter_from_pop_up() {
        list.clickResetPopUp();
    }
    @Then("counter in filter disappear")
    public void counter_in_filter_disappear() {
        list.clickFilter();
        list.assertCounterStatusKonfirmasiManagerNotVisible();
        list.assertCounterStatusKonfirmasiFinanceNotVisible();
        list.assertCounterKategoriBiayaNotVisible();
        list.closeFilter();
    }
    @When("admin reset filter owner expenditure")
    public void admin_reset_filter_owner_expenditure() {
        list.clickResetButton();
    }
    @Then("counter in filter button {string}")
    public void counter_in_filter_button(String visibility) {
        if (visibility.equalsIgnoreCase("visible")){
            list.assertCounterFilterVisible();
        } else if (visibility.equalsIgnoreCase("hidden")) {
            list.assertCounterFilterHidden();
        }
    }
}
