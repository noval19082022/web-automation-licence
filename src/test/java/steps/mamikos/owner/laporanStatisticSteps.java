package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.owner.laporanStatistikPO;

import java.util.Map;


public class laporanStatisticSteps {
    Page page = ActiveContext.getActivePage();
    laporanStatistikPO laporanStatistik = new laporanStatistikPO(page);


    @And("auto select kost listing that are in the top order")
    public void auto_selected_that_active_listing(DataTable tables) {
        laporanStatistik.autoSelectedListingTopOrder();
        for (Map<String, String> row : tables.asMaps(String.class, String.class)) {
            String type = row.get("KosName");
            Assert.assertEquals(laporanStatistik.autoSelectedListing(type), "Kost SkinCare Tobelo TIPE A Tobelo Utara Halmahera Utara");
        }
    }

    @Then("owner can see display empty state {string}")
    public void owner_see_empty_state(String text) {
        Assert.assertEquals(laporanStatistik.ownerSeeEmptyState(text), "Properti Belum Memiliki Performa");
    }

    @And("owner click on filter {string} at statistic report")
    public void owner_click_on_filter(String filter){
        laporanStatistik.ownerClickOnFilter(filter);
    }
    @And("owner click on tooltip at performa section")
    public void owner_click_on_tooltip(){
        laporanStatistik.ownerClickOnTooltip();
    }
    @And("owner can see total sewa")
    public void owner_can_see_total_sewa(){
        Assert.assertTrue(laporanStatistik.getDataTotalSewa());
    }
    @And("owner can see total chat")
    public void owner_can_see_total_chat(){
        Assert.assertTrue(laporanStatistik.getDataTotalChat());
    }
    @And("owner can see total click")
    public void owner_can_see_total_click(){
        Assert.assertTrue(laporanStatistik.getDataTotalClick());
    }
    @And("owner can see periode Performa")
    public void owner_can_see_periode(){
        Assert.assertTrue(laporanStatistik.getDataperiode());
    }

    @Then("owner cannot see growth graphic")
    public void owner_cannot_see_growth_graphic(){
        Assert.assertFalse(laporanStatistik.ownerSeeGraphic());
    }
    @Then("owner can see growth graphic")
    public void owner_can_see_growth_graphic(){
        Assert.assertTrue(laporanStatistik.ownerSeeGraphic());
    }
}

