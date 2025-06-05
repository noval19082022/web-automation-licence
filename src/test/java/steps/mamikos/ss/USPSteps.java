package steps.mamikos.ss;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.common.HomePO;
import pageobject.common.KostDetailsPO;
import utilities.PlaywrightHelpers;

public class USPSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwrightHelpers;
    KostDetailsPO kostDetail = new KostDetailsPO(page);

    @Then("tenant can see {string} USP")
    public void tenant_can_see_usp(String usp) {
        //Assert USP header
        if (usp.equalsIgnoreCase("Singgahsini")) {
            Assert.assertEquals(kostDetail.getUSPHeader(),"Keunggulan Singgahsini");
        } else if (usp.equalsIgnoreCase("APIK")) {
            Assert.assertEquals(kostDetail.getUSPHeader(),"Keunggulan APIK");
        } else {
            System.out.println("Invalid USP");
        }
        //Assert USP content
        Assert.assertEquals(kostDetail.getUSPTitle(0), "Dikelola Mamikos: Dijamin Akurat");
        Assert.assertEquals(kostDetail.getUSPDescription(0), "Fasilitas tidak sesuai dengan iklan yang kamu lihat, kami garansi refund.");
        Assert.assertEquals(kostDetail.getUSPTitle(1), "Asuransi Khusus Penyewa");
        Assert.assertEquals(kostDetail.getUSPDescription(1), "Perlindungan atas kompensasi kehilangan barang & fasiilitas pada unit kamar. Disediakan oleh Penyedia Jasa Asuransi yang terdaftar OJK. S&K berlaku.");
        Assert.assertEquals(kostDetail.getUSPTitle(2), "Penanganan Profesional");
        Assert.assertEquals(kostDetail.getUSPDescription(2), "Tim Mamikos selalu siap membantumu. Mulai dari survei kos, pengajuan sewa, hingga selama kamu ngekos.");
    }

    @Then("tenant can see new refund wording")
    public void tenant_can_see_new_refund_wording() {
        Assert.assertEquals(kostDetail.getRefundTitle(),"Ketentuan Refund");
        Assert.assertEquals(kostDetail.getRefundDescription(), "Kos bisa refund sesuai dengan ketentuan dan kebijakan refund yang berlaku di Mamikos.");
    }
}
