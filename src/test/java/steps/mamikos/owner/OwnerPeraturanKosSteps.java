package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobject.owner.OwnerDashboardPO;
import pageobject.owner.kelolatagihan.PengajuanSewaPO;
import utilities.PlaywrightHelpers;

import java.util.List;
import java.util.Map;

public class OwnerPeraturanKosSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    PengajuanSewaPO pengajuanBooking = new PengajuanSewaPO(page);
    OwnerDashboardPO ownerDashboard = new OwnerDashboardPO(page);

    private List<Map<String , String>> minCheckinData;

    @Then("owner redirect to Peraturan Masuk Kos page")
    public void ownerRedirectToPeraturanMasukKosPage(){
        pengajuanBooking.getPeraturanBookingText();
    }

    @Then("owner click on pengajuan sewa")
    public void ownerCLickOnPengajuanSewa(){
        pengajuanBooking = ownerDashboard.clickOnPengajuanSewa();
    }

    @And("owner select kost {string}")
    public void ownerSelectKos(String kosName){
        pengajuanBooking.selectKostName(kosName);
    }

    @And("owner click Simpan at Peraturan Masuk Kos page")
    public void ownerClickSimpanAtPeraturanMasukKospage(){
        pengajuanBooking.simpanPeraturanButton();
    }

    @Then("owner will see toast {string}")
    public void ownerWillSeeToastPeraturanMasukKos(String toast){
        pengajuanBooking.getToastText(toast);
    }

    @And("owner clicks on ubah waktu button")
    public void ownerClicksOnUbahWaktuButton(){
        pengajuanBooking.clickWaktuMulaiNgekosButton();
    }

    @And("owner choose minim checkin time with :")
    public void ownerChooseMinimCheckinTimeWithX(DataTable table){
        minCheckinData = table.asMaps(String.class, String.class);
        var waktu = minCheckinData.get(0).get("waktu");
        var tanggal = minCheckinData.get(0).get("tanggal");
        pengajuanBooking.editWaktuMulaiNgekos(waktu, tanggal);
    }

    @And("owner activated toogle checkin button")
    public void ownerActivatedToogleCheckinButton(){
        pengajuanBooking.clickToogleCheckin();
    }

    @And("owner click on kriteria calon penyewa button")
    public void ownerCLickOnKriteriaCalonPenyewaButton(){
        pengajuanBooking.clickKriteriaCalonPenyewaButton();
    }

    @And("owner click kriteria penyewa with {string}")
    public void ownerClickKriteriaPenyewaWith(String kriteria){
        pengajuanBooking.clickToogleKriteria(kriteria);
    }

    @Then("owner can see {string} will disable")
    public void ownerCanSeeXWillDisable(String kriteria) {
        pengajuanBooking.validateDisableButton(kriteria);
    }

    @And("owner uncheck toogle {string}")
    public void ownerUncheckToogle(String kriteria) {
        pengajuanBooking.unCheckToogle(kriteria);
    }

    @Then("owner can see {string} will enable")
    public void ownerCanSeeWillEnable(String kriteria){
        pengajuanBooking.validateEnableButton(kriteria);
    }

    @And("owner click kriteria kos khusus with {string}")
    public void ownerCLickKriteriaKosKhususWith(String text){
        pengajuanBooking.clickKosKhususButton(text);
    }

    @Then("owner can see {string} on ubah peraturan")
    public void ownerCanSeeOnUbahPeraturan(String text){
        pengajuanBooking.validateWordingOnUbahPeraturan(text);
    }
    @And("owner click on toggle pengajuan dan waktu masuk kos")
    public void ownerClickOnToggleCheckInKos() {
        pengajuanBooking.ownerClickOnToggleCheckInKos();
    }
    @And("owner click on toggle pengajuan dan waktu masuk kos if active")
    public void ownerClickOnToggleCheckInKosIfActive() {
        pengajuanBooking.ownerClickOnToggleCheckInKosIfActive();
    }
    @And("owner click on dropdown waktu masuk kos")
    public void ownerClickOnDropdownTotalDay() {
        pengajuanBooking.ownerClickOnDropdownTotalDay();
    }
    @And("owner click on simpan button on popup total day")
    public void ownerClickOnSimpanPopupTotalDay() {
        pengajuanBooking.ownerClickOnSimpanPopupTotalDay();
    }
    @And("owner click on dropdown jumlah jarak waktu terjauh")
    public void ownerClickOnDropdownLongDistance() {
        pengajuanBooking.ownerClickOnDropdownLongDistance();
    }
    @And("owner click on dropdown satuan waktu jarak waktu terjauh")
    public void ownerClickOnDropdownUnitTime() {
        pengajuanBooking.ownerClickOnDropdownUnitTime();
    }
    @And("owner click on simpan button on popup satuan waktu")
    public void ownerClickOnSimpanPopupUnitTime() {
        pengajuanBooking.ownerClickOnSimpanPopupUnitTime();
    }

    @And("owner click on tanggal {string}")
    public void clickOnTanggal(String tanggal){
        pengajuanBooking.clickOnTanggal(tanggal);
    }

    @And("owner click on toogle today")
    public void ownerClickOnToogleToday(){
        pengajuanBooking.clickOnToday();
    }
}

