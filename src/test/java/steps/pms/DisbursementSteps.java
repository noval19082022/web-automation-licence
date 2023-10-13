package steps.pms;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.pms.DisbursementPO;

import java.util.List;
import java.util.Map;

public class DisbursementSteps {
    Page page = ActiveContext.getActivePage();
    DisbursementPO disbursement = new DisbursementPO(page);
    Page page1;

    private List<Map<String, String>> modelKerjaSama;

    @When("admin go to detail transfer {string}")
    public void admin_go_to_detail_transfer(String property){
        disbursement.searchProperty(property);
        disbursement.clicksLihatDetail();
    }

    @When("admin clicks Refresh Halaman ini")
    public void admin_clicks_Refresh_Halaman_ini(){
        disbursement.clicksRefreshHalamanIniBtn();
    }

    @Then("Model Kerja Sama and Add On are displayed in Informasi Transfer Pendapatan Properti according Detail Kerja Sama data")
    public void Model_Kerja_Sama_and_Add_On_are_displayed_in_Informasi_Transfer_Pendapatan_Properti_according_Detail_kerja_Sama_data(DataTable tables){
        modelKerjaSama = tables.asMaps(String.class, String.class);

        String modelKerjaSamaBooking = modelKerjaSama.get(0).get("Model Kerja Sama Booking");
        String modelKerjaSamaDBET = modelKerjaSama.get(0).get("Model Kerja Sama DBET");
        String addOnJP = modelKerjaSama.get(0).get("Add On JP");
        String addOnADP = modelKerjaSama.get(0).get("Add On ADP");

        disbursement.clicksRefreshHalamanIniBtn();

        Assert.assertEquals(disbursement.getModelKerjaSamaBooking(), modelKerjaSamaBooking);
        Assert.assertEquals(disbursement.getModelKerjaSamaDBET(), modelKerjaSamaDBET);
        Assert.assertEquals(disbursement.getAddOnJP(), addOnJP);
        Assert.assertEquals(disbursement.getAddOnADP(), addOnADP);
    }
}
