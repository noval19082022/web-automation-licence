package steps.mamikos.tenant.survei;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.tenant.survei.KostDetailSurveiPO;

import java.util.List;
import java.util.Map;

public class KostDetailSurveiStep {
    Page page = ActiveContext.getActivePage();
    KostDetailSurveiPO kostDetailSurvei = new KostDetailSurveiPO(page);

    private List<Map<String, String>> kosAndalan;

    @Then("{string} are displayed in the kos andalan")
    public void areDisplayedInTheKosAndalan(String name, DataTable tables) {
        kosAndalan = tables.asMaps();
        int limit = name.equalsIgnoreCase("Survei Kos Tersedia") ? 1 :
                name.equalsIgnoreCase("Booking Langsung") ? 2 :
                name.equalsIgnoreCase("Ketentuan Refund") ? 3 : 0;
        limit = Math.min(limit, kosAndalan.size());

        for (int i = 0; i < limit; i++) {
            String kosAndalanTable = kosAndalan.get(i).get(name);
            kostDetailSurvei.assertkosAndalanOnTable(kosAndalanTable);
        }
    }

    @Then("{string} are not displayed in the kos pilar non gp")
    public void areNotDisplayedInTheKosAndalan(String name, DataTable tables) {
        kosAndalan = tables.asMaps();
        if (!name.equalsIgnoreCase("Survei Kos Tersedia") && !name.equalsIgnoreCase("Booking Langsung")) {
            int limit = 2;
            limit = Math.min(limit, kosAndalan.size());

            for (int i = 0; i < limit; i++) {
                String kosAndalanTable = kosAndalan.get(i).get(name);
                kostDetailSurvei.assertkosAndalanOnTable(kosAndalanTable);
            }
        }
    }

    @Then ("user see label Baru should be displayed on the kost detail page")
    public void userSeeNewLabelIndetailkos(){
        Assert.assertTrue(kostDetailSurvei.userSeeNewLabelIndetailkos());
    }
}
