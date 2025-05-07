package steps.mamikos.owner.mamiads;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.owner.fiturpromosi.mamiads.DetailTagihanPO;
import pageobject.owner.fiturpromosi.mamiads.MamiAdsPO;


public class DetailTagihanSteps {

    Page page = ActiveContext.getActivePage();
    MamiAdsPO mamiAdsPO = new MamiAdsPO(page);
    DetailTagihanPO detailTagihanPO = new DetailTagihanPO(page);

    @And("owner ubah saldo to {string}")
    public void owner_ubah_saldo_to(String saldo){
        detailTagihanPO.clickOnUbahSaldo();
        mamiAdsPO.choosingSaldoToBuy(saldo);
    }

    @Then("validate detail tagihan saldo mamiads {string}")
    public void validate_detail_tagihan_saldo_mamiads(String saldo){
        Assert.assertEquals(detailTagihanPO.getPilihanAndaText(),"Saldo "+saldo);
        Assert.assertEquals(detailTagihanPO.getRincianPembayaranProdukText(),"Saldo "+saldo);
        Assert.assertEquals(detailTagihanPO.getRincianPembayaranNominalText(),"Rp "+saldo);
        Assert.assertEquals(detailTagihanPO.getTotalPembayaranText(),"Rp "+saldo);
    }

    @And("owner click bayar sekarang in detail tagihan for saldo mamiads")
    public void owner_click_bayar_sekarang_in_detail_tagihan_for_saldo_mamiads(){
        detailTagihanPO.clicksOnBayarSekarangButton();
    }
}
