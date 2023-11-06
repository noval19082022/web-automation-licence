package steps.mamikos.ownersini;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.core.options.Constants;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.owner.ownersini.OwnersiniPO;
import utilities.JavaHelpers;

public class OwnersiniSteps {
    Page page = ActiveContext.getActivePage();
    OwnersiniPO ownersini = new OwnersiniPO(page);

    private String ownersiniPage ="src/test/resources/testdata/ownersini/ownersini.properties";
    private String ownerDashboardPillar2 = JavaHelpers.getPropertyValue(ownersiniPage, "owner_home_url");
    private String namaProperti = JavaHelpers.getPropertyValue(ownersiniPage, "nama_properti");
    private String alamatProperti = JavaHelpers.getPropertyValue(ownersiniPage, "alamat_properti");
    private String tipeKamar = JavaHelpers.getPropertyValue(ownersiniPage, "tipe_kamar");
    private String tipeKos = JavaHelpers.getPropertyValue(ownersiniPage, "tipe_kos");
    private String depositTitle = JavaHelpers.getPropertyValue(ownersiniPage, "deposit_title");
    private String depositPrice = JavaHelpers.getPropertyValue(ownersiniPage, "deposit_price");
    private String wifiTitle = JavaHelpers.getPropertyValue(ownersiniPage, "wifi_title");
    private String wifiPrice = JavaHelpers.getPropertyValue(ownersiniPage, "wifi_price");
    private String listrikTitle = JavaHelpers.getPropertyValue(ownersiniPage, "listrik_title");
    private String listrikPrice = JavaHelpers.getPropertyValue(ownersiniPage, "listrik_price");

    @When("owner clicks Kembali ke Mamikos on top right corner Profil")
    public void owner_clicks_Kembali_ke_Mamikos_on_top_right_corner_Profil(){
        ownersini.dismissFtueOwnersini();
        ownersini.clicksTopRightCornerProfil();
        ownersini.clicksKembaliKeMamikos();
    }

    @Then("owner redirect to Owner Dashboard Pillar 2")
    public void owner_redirect_to_Owner_Dashboard_Pillar_2(){
        Assert.assertEquals(ownersini.getURL(), ownerDashboardPillar2, "URL not equal with Owner Dashboard Pillar 2 URL");
    }

    @When("user clicks Profil menu")
    public void user_clicks_Profil_menu(){
        ownersini.dismissFtueOwnersini();
        ownersini.clicksProfilProperti();
        ownersini.clicksProfilMenu();
    }

    @Then("the {string} is displayed")
    public void the_is_displayed(String section){
        if (section.equalsIgnoreCase("Information Profil")){
            Assert.assertEquals(ownersini.getNamaProp(), namaProperti, "The Property is not same as "+namaProperti+"");
            Assert.assertEquals(ownersini.getAlamat(), alamatProperti, "The Address is not same as "+alamatProperti+"");
            Assert.assertEquals(ownersini.getTipeKamar(), tipeKamar, "The Room Type is not same as "+tipeKamar+"");
            Assert.assertEquals(ownersini.getTipeKos(), tipeKos, "The Kost Type is not same as "+tipeKos+"");
            ownersini.clicksLocation();
        } else if (section.equalsIgnoreCase("Facility Section")) {
            Assert.assertTrue(ownersini.isFasBersamaVisible(), "The Facility is not visible");
            Assert.assertTrue(ownersini.isFasParkirVisible(), "The Facility is not visible");
            Assert.assertTrue(ownersini.isFasDekatKosVisible(), "The Facility is not visible");
        } else if (section.equalsIgnoreCase("Kost Rules Section")) {
            Assert.assertTrue(ownersini.isKostRulesVisible(), "The Kost Rules is not visible");
        } else if (section.equalsIgnoreCase("Additional Fee Section")) {
            Assert.assertEquals(ownersini.getBiayaTmbhn1(), depositTitle, "The Deposit is not equal to "+depositTitle+"");
            Assert.assertEquals(ownersini.getBiayaTmbhnPrice1(), depositPrice, "The Deposit Price is not equal to "+depositPrice+"");
            Assert.assertEquals(ownersini.getBiayaTmbhn2(), wifiTitle, "The Wifi is not equal to "+wifiTitle+"");
            Assert.assertEquals(ownersini.getBiayaTmbhnPrice2(), wifiPrice, "The Wifi Price is not equal to "+wifiPrice+"");
            Assert.assertEquals(ownersini.getBiayaTmbhn3(), listrikTitle, "The Listrik is not equal to "+listrikTitle+"");
            Assert.assertEquals(ownersini.getBiayaTmbhnPrice3(), listrikPrice, "The Listrik Price is not equal to "+listrikPrice+"");
        } else if (section.equalsIgnoreCase("Additional Informasion Section")) {
            Assert.assertTrue(ownersini.isInfoTambahanVisible(), "The Additional Information is not visible");
        } else if (section.equalsIgnoreCase("Property Photo section")) {
//            int totalColoumn = ownersini.getTotalCol();
//            String[] judul = {"Peraturan Kost", "Foto 360", "Foto Bangunan", "Foto Tampak dari Jalan", "Foto Fasilitas Umum", "Foto Lainnya"};
//            for (int i=0; i<totalColoumn; i++){
//                if (ownersini.isLihatSemuaVisible(i)){
//                    navbar.clickLihatSemua(i);
//                    Assert.assertEquals(navbar.getImageTitle(), judul[i]);
//                    navbar.clickClose();
//                }
//            }
        }
    }
}
