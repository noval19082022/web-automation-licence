package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.common.LoadingPO;
import pageobject.owner.OwnerDashboardPO;
import pageobject.owner.kelolatagihan.BillDetailsPO;
import pageobject.owner.kelolatagihan.TenantBillManagementPO;
import utilities.JavaHelpers;
import utilities.PlaywrightHelpers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class OwnerManageBillSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    OwnerDashboardPO ownerDashboard = new OwnerDashboardPO(page);
    TenantBillManagementPO billManage = new TenantBillManagementPO(page);
    BillDetailsPO billdetail = new BillDetailsPO(page);
    LoadingPO loading = new LoadingPO(page);

    private List<Map<String, String>> property;

    @When("owner go to bill page of kost {string} on month of {string}")
    public void ownerGoToBillPageOfKostOnMonthOf(String kostName, String month) {
        var selectedMonthFilter = "";
        var currentMonth = JavaHelpers.getMonthName(new Locale("id", "ID"), 0);
        if (month.equalsIgnoreCase("next")) {
            selectedMonthFilter = JavaHelpers.getMonthName(new Locale("id", "ID"), 1);
        } else if(month.equalsIgnoreCase("current")) {
            selectedMonthFilter = JavaHelpers.getMonthName(new Locale("id", "ID"), 0);
        }
        loading.waitForLoadingIconDisappear();
        ownerDashboard.clickOnManagementKost();
        billManage = ownerDashboard.clickOnKelolaKos();
        billManage.reloadOnEmptyKelolaTagihanPage();
        loading.waitForLoadingIconDisappear();
        billManage.selectKosBillPageFilter(kostName);
        LocalDate currentDate = LocalDate.now();
        LocalDate nextMonthDate = currentDate.plus(1, ChronoUnit.MONTHS);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM", java.util.Locale.ENGLISH);
        String nextMonthString = nextMonthDate.format(formatter);
        if (month.equalsIgnoreCase("next") && month.equalsIgnoreCase(nextMonthString)) {
            billManage.clickOnFilterMonth();
            billManage.clickArrowNextMonthFilterButton();
            billManage.clickOnMonthNameOnFilterMonth(selectedMonthFilter);
        } else {
            billManage.selectMonthFilter(selectedMonthFilter);
        }
    }

    @When("owner go to detail tagihan")
    public void ownerGoToDetailTagihan() {
        billdetail = billManage.clickOnInvoiceList();
    }

    @When("owner go to detail tagihan with jatuh tempo is {string}")
    public void ownerGoToDetailTagihanWithJatuhTempoIs(String jatuhTempo) {
        billdetail = billManage.clickOnInvoiceList(jatuhTempo);
    }

    @Then("owner can see additional price {string} with price {string}")
    public void ownerCanSeeAdditionalPriceWithPrice(String additionalPriceTitle, String additionalPriceValue) {
        Assert.assertEquals(billdetail.getAdditionalPriceValueText(additionalPriceTitle), additionalPriceValue);
    }

    @And("owner go to detail tagihan with tenant name is {string} and jatuh tempo is {string}")
    public void ownerGoToDetailTagihanWithTenantNameIsAndJatuhTempoIs(String tenantName, String jatuhTempoDate) {
        billdetail = billManage.clickOnInvoiceList(tenantName, jatuhTempoDate);
    }

    @And("owner go to detail tagihan with tenant name is {string} and jatuh tempo is current month length")
    public void ownerGoToDetailTagihanWithTenantNameIsAndCurrenMonthLengthJatuhTempo(String tenantName) {
        int monthLength = JavaHelpers.getMonthLength();
        String jatuhTempo = "Belum bayar - Tenggat "+monthLength+" hari lagi";
        billdetail = billManage.clickOnInvoiceList(tenantName, jatuhTempo);
    }

    @And("user clicks Sudah bayar tab")
    public void userClicksSudahBayarTab() {
        billManage.clicksOnSudahBayarTab();
    }

    @Then("user will see Status Tagihan and money disbursed to owner’s bank {string}")
    public void userWillSeeStatusTagihanAndMoneyDisbursedToOwnerSBank(String labelSuccess) {
        Assert.assertEquals(billManage.getLabelSuccessTransfer(), labelSuccess);
    }

    @Then("user can see Penyewa list")
    public void userCanSeePenyewaList() {
        
    }

    @Then("user can see room number with {string}")
    public void userCanSeeRoomNumberWith(String roomNumber) {
        Assert.assertEquals(billManage.getRoomNumberText(),roomNumber, "doesn't not match for room number");
    }

    @And("user change room number with {string}")
    public void userChangeRoomNumberWith(String roomNumber) {
        billManage.clickOnUbahRoomNumberBtn();
        billManage.chooseRoomNumber(roomNumber);
    }

    @And("owner go to Penyewa page of kost {string}")
    public void ownerGoToPenyewaPageOfKost(String kostName) {
        ownerDashboard.clickOnManagementKost();
        billManage = ownerDashboard.clickOnPenyewaKos();
        billManage.searchKostPenyewa(kostName);
    }

    @Then("user can not see update room number button")
    public void userCannotSeeUpdateRoomNumber() {
        Assert.assertFalse(billManage.isUpdateRoomNumberVisible());
    }

    @And("user search kost in penyewa menu {string}")
    public void userSearchKostInPenyewaMenu(String kostName) {
        billManage.searchKostInPenyewaMenu(kostName);
    }

    @And("user click on lihat selengkapnya button")
    public void userClickOnLihatSelengkapnyaButton() {
        billManage.clickOnLihatSelengkapnyaButton();
    }

    @And("user click on kontrak sewa button")
    public void userClickOnKontrakSewaButton() {
        billManage.clickOnKontrakSewaButton();
    }

    @And("user click on tolak button")
    public void userClickOnTolakButton() {
        billManage.clickOnTolakButton();
    }

    @And("user click on Ubah kontrak penyewa button")
    public void userClickOnUbahKontrakPenyewaButton() {
        billManage.clickOnUbahKontrakPenyewaButton();
    }
    @And("user check prices penyewa owner are same to contract at kos saya {string}")
    public void userCheckPricePenyewaOnOwner(String price) {
        Assert.assertEquals(billManage.isPriceDisplayed(price), "Rp1.100.000 / bulan");
    }

    @Then("user can see {string} as tenant name, {string} as phone number, {string} status, and photo")
    public void user_can_see_tenant_name_phone_number_status_and_photo(String name, String phoneNumber, String status) {
        Assert.assertEquals(billManage.getTenantHeaderName(name),name);
        Assert.assertEquals(billManage.getHeaderPhoneNumber(phoneNumber),phoneNumber);
        Assert.assertEquals(billManage.getHeaderContractStatus(),status);
        billManage.isTenantPhotoVisible();
    }

    @When("user can see detail tenant \\({string}, {string}, {string}, {string})")
    public void user_can_see_detail_tenant(String name, String gender, String status, String job) {
        Assert.assertEquals(billManage.getDetailTenantName(name), name);
        Assert.assertEquals(billManage.getDetailTenantGender(gender),gender);
        Assert.assertEquals(billManage.getDetailTenantStatus(status),status);
        Assert.assertEquals(billManage.getDetailTenantJob(job),job);
    }

    @Then("user cannot see checkin tenant disclaimer alert")
    public void user_cannot_see_disclaimer() {
        Assert.assertFalse(billManage.isDisclaimerTextVisible());
    }

    @Then("user can see detail contract \\({string}, {string}, {string}, {string}, {string})")
    public void user_can_see_detail_contract(String start, String end, String total, String duration, String nearestBill) {
        Assert.assertEquals(billManage.getDetailStartContract(start),start);
        Assert.assertEquals(billManage.getDetailEndContract(end),end);
        Assert.assertTrue(billManage.getDetailTotalBill().contains(total));
        Assert.assertEquals(billManage.getDetailRentDuration(duration),duration);
        Assert.assertEquals(billManage.getDetailNearestBill(nearestBill),nearestBill);
    }

    @When("system display change contract rent button")
    public void system_display_change_contract_rent() {
        billManage.ubahKontrakPenyewaIsVisible();
    }

    @Then("system display terminate contract link")
    public void system_display_terminate_contract_link() {
        billManage.displayTerminateContract();
    }

    @And("user search kost {string}")
    public void user_search_kost(String searchKost) throws InterruptedException{
        billManage.searchKostPenyewa(searchKost);
    }

    @And("user click Selengkapnya button on {string} contract")
    public void user_click_selengkapnya_button_on_contract(String contract) {
        playwright.hardWait(2);
        billManage.clickSelengkapnyaByContractName(contract);
    }

    @Then("user can see disclaimer {string}")
    public void user_can_see_disclaimer(String disclaimer) {
        Assert.assertTrue(billManage.getDisclaimerText().contains(disclaimer));
    }
    @And("user click on dropdown Filter box and select filter:")
    public void userClickOnDropdownFilterBoxAndSelectFilter(DataTable tables) {
        billManage.clickOnFilterDropdown();
        property = tables.asMaps(String.class, String.class);
        String filter = property.get(0).get("Filter");
        billManage = billManage.fillFilterStatusBooking(filter);
    }

    @And("user click download biodata penyewa button")
    public void userClickDownloadBiodataPenyewaButton() {
        billManage.clickDownloadBiodataPenyewa();
    }
    @And("user tick on checkbox pop up")
    public void userTickCheckbox() {
        billManage.tickCheckbox();
    }
    @And("user will see information about upcoming feature")
    public void userWillSeeInformationAboutUpcomingFeature() {
        Assert.assertTrue(billManage.isUpcomingFeatureDisplayed());
    }

    @Then("user will see message request terminated contract")
    public void userWillSeeMessage() {
        Assert.assertTrue(billManage.userWillSeeMessageTerminatedContract().contains("menghentikan sewa kos"), "Terminate text is not displayed");
    }

    @Then("user can see help center page")
    public void userWillSeeMessageForOwner() {
        Assert.assertTrue(billManage.userCanSeeHelpCenterPage());
    }
    @And("owner search kost in billing management {string}")
    public void ownerSearchKostInPenyewaMenu(String kostName) {
        billManage.searchKostInBillingManagement(kostName);
    }
    @Then("user see Kapan uang masuk ke rekening saya? and clicks on disbursement link")
    public void userClickOnDIsbursementLink() {
        billManage.userClickOnDIsbursementLink();
    }
    @Then("user can see {string} and {string}")
    public void user_can_sees_other_price_with_name_and_price_on_konfirmasi(String titleText, String contentText) {
        Assert.assertEquals(billManage.getTextFinancialReport(titleText, contentText), "Buka Laporan Keuangan di AplikasiUntuk saat ini, fitur Laporan Keuangan hanya dapat digunakan di\n" +
                "      aplikasi Mamikos di Android dan iOS.");
    }

    @And("owner clicks on lihat status tagihan")
    public void ownerCLicksOnLihatStatusTagihan(){
        billManage.clickLihatStatusTagihan();
    }

    @Then("owner can see status tagihan {string}")
    public void ownerCanSeeStatusTagihan(String text){
        billManage.getTextStatusTagihan(text);
    }

    @And("user click Kirim ulang kode hyperlink")
    public void userClickKirimUlangKodeHyperlink() {
        billManage.clickKirimUlangKode();
    }

    @Then("user will redirect to Kirim kode unik ke penyewa page")
    public void user_will_redirect_to_kirim_kode_unik_ke_penyewa_page(){
        Assert.assertTrue(billManage.isKrmKodeUnikPageDisplayed(), "You are not Kirim kode unik page");
    }

    @And("user will see phone number of owner {string} or {string}")
    public void user_will_see_phone_number_of_owner(String oldNumber, String newNumber) {
        Assert.assertFalse(billManage.equals(oldNumber) || billManage.equals(newNumber), "Nomor telepon yang ditampilkan tidak sesuai");
    }

    @When("user click Ubah nomor HP hyperlink")
    public void user_click_ubah_nomor_hp_hyperlink() {
        billManage.clickUbahNmrHp();
    }

    @And("user change owner's phone number into {string} and click Gunakan")
    public void user_change_owners_phone_number_into_and_click_gunakan(String ubhPhoneNumber) {
        billManage.clickPhoneNmbField(ubhPhoneNumber);
    }

    @Then("user will see wording of warning tenant who don't have kos saya at Semua filter")
    public void user_will_see_wording_of_warning_tenant_who_dont_have_kos_saya_at_semua_filter(){
        Assert.assertTrue(billManage.isWarningAtSemuaFltrDisplayed(), "The wording is not match");
    }
}