package steps.pms;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.When;
import pageobject.pms.DisbursementPO;

public class DisbursementSteps {
    Page page = ActiveContext.getActivePage();
    DisbursementPO disbursement = new DisbursementPO(page);
    Page page1;

    @When("admin go to detail transfer {string}")
    public void admin_go_to_detail_transfer(String property){
        disbursement.searchProperty(property);
        disbursement.clicksLihatDetail();
    }

    @When("admin open new tab on Riwayat Transfer Pendapatan")
    public void admin_open_new_tab_on_Riwayat_Transfer_Pendapatan(){
        page1 = disbursement.clicksRiwayatTransferPendapatan();

//        page1 = manualInvoice.clickInvoiceNumber();
    }

    @When("admin clicks Refresh Halaman ini")
    public void admin_clicks_Refresh_Halaman_ini(){
        disbursement.clicksRefreshHalamanIniBtn();
    }
}
