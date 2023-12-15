package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import pageobject.owner.OwnerDashboardPO;
import pageobject.owner.kelolatagihan.PengajuanSewaPO;
import utilities.PlaywrightHelpers;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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

}
