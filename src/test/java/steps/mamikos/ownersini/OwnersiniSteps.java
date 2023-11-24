package steps.mamikos.ownersini;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.owner.ownersini.OwnersiniPO;
import utilities.JavaHelpers;

public class OwnersiniSteps {
    Page page = ActiveContext.getActivePage();
    OwnersiniPO ownersini = new OwnersiniPO(page);

    private String ownersiniPage ="src/test/resources/testdata/ownersini/ownersini.properties";
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
    private String namaPropertiProd = JavaHelpers.getPropertyValue(ownersiniPage, "nama_properti_prod");
    private String alamatPropertiProd = JavaHelpers.getPropertyValue(ownersiniPage, "alamat_properti_prod");
    private String tipeKamarProd = JavaHelpers.getPropertyValue(ownersiniPage, "tipe_kamar_prod");
    private String depositPriceProd = JavaHelpers.getPropertyValue(ownersiniPage, "deposit_price_prod");
    private String wifiPriceProd = JavaHelpers.getPropertyValue(ownersiniPage, "wifi_price_prod");
    private String roomNumberTitle = JavaHelpers.getPropertyValue(ownersiniPage, "room_number_title");
    private String roomPriceTitle = JavaHelpers.getPropertyValue(ownersiniPage, "room_price_title");
    private String roomAreaTitle = JavaHelpers.getPropertyValue(ownersiniPage, "room_area_title");
    private String electricityTitle = JavaHelpers.getPropertyValue(ownersiniPage, "electricity_title");
    private String roomFacilityTitle = JavaHelpers.getPropertyValue(ownersiniPage, "room_facility_title");
    private String bathroomFacilityTitle = JavaHelpers.getPropertyValue(ownersiniPage, "bathroom_facility_title");

    @When("owner clicks Kembali ke Mamikos on top right corner Profil")
    public void owner_clicks_Kembali_ke_Mamikos_on_top_right_corner_Profil(){
        ownersini.dismissFtueOwnersini();
        ownersini.clicksTopRightCornerProfilP1();
        ownersini.clicksKembaliKeMamikos();
    }

    @Then("owner redirect to Owner Dashboard Pillar 2")
    public void owner_redirect_to_Owner_Dashboard_Pillar_2(){
        Assert.assertEquals(ownersini.getURLPillar2(), Mamikos.OWNER_URL+"/", "URL not equal with Owner Dashboard Pillar 2 URL");
    }

    @When("owner clicks Dashboard Singgahsini on top right corner Profil")
    public void owner_clicks_Dashboard_Singgahsini_on_top_right_corner_Profil(){
        ownersini.clicksTopRightCornerProfilP2();
        ownersini.clicksDashboardSinggahsini();
    }

    @Then("owner redirect to Owner Dashboard Pillar 1")
    public void owner_redirect_to_Owner_Dashboard_Pillar_1(){
        Assert.assertEquals(ownersini.getURLPillar1(), Mamikos.Ownersini_URL, "URL not equal with Owner Dashboard Pillar 1 URL");
    }

    @When("user clicks Profil menu")
    public void user_clicks_Profil_menu(){
        ownersini.clicksProfilProperti();
        ownersini.clicksProfilMenu();
    }

    @Then("the {string} is displayed")
    public void the_is_displayed(String section){
        if (section.equalsIgnoreCase("Information Profil")){
            if (Mamikos.ENV.equals("prod")){
                Assert.assertEquals(ownersini.getNamaProp(), namaPropertiProd, "The Property is not same as "+namaProperti+"");
                Assert.assertEquals(ownersini.getAlamat(), alamatPropertiProd, "The Address is not same as "+alamatProperti+"");
                Assert.assertEquals(ownersini.getTipeKamar(), tipeKamarProd, "The Room Type is not same as "+tipeKamar+"");
                Assert.assertEquals(ownersini.getTipeKos(), tipeKos, "The Kost Type is not same as "+tipeKos+"");
                ownersini.clicksLocation();
            } else {
                Assert.assertEquals(ownersini.getNamaProp(), namaProperti, "The Property is not same as "+namaProperti+"");
                Assert.assertEquals(ownersini.getAlamat(), alamatProperti, "The Address is not same as "+alamatProperti+"");
                Assert.assertEquals(ownersini.getTipeKamar(), tipeKamar, "The Room Type is not same as "+tipeKamar+"");
                Assert.assertEquals(ownersini.getTipeKos(), tipeKos, "The Kost Type is not same as "+tipeKos+"");
                ownersini.clicksLocation();
            }
        } else if (section.equalsIgnoreCase("Facility Section")) {
            Assert.assertTrue(ownersini.isFasBersamaVisible(), "The Facility is not visible");
            Assert.assertTrue(ownersini.isFasParkirVisible(), "The Facility is not visible");
            Assert.assertTrue(ownersini.isFasDekatKosVisible(), "The Facility is not visible");
        } else if (section.equalsIgnoreCase("Kost Rules Section")) {
            Assert.assertTrue(ownersini.isKostRulesVisible(), "The Kost Rules is not visible");
        } else if (section.equalsIgnoreCase("Additional Fee Section")) {
            if (Mamikos.ENV.equals("prod")){
                Assert.assertEquals(ownersini.getBiayaTmbhn1(), depositTitle, "The Deposit is not equal to "+depositTitle+"");
                Assert.assertEquals(ownersini.getBiayaTmbhnPrice1(), depositPriceProd, "The Deposit Price is not equal to "+depositPrice+"");
                Assert.assertEquals(ownersini.getBiayaTmbhn2(), wifiTitle, "The Wifi is not equal to "+wifiTitle+"");
                Assert.assertEquals(ownersini.getBiayaTmbhnPrice2(), wifiPriceProd, "The Wifi Price is not equal to "+wifiPrice+"");
            } else {
                Assert.assertEquals(ownersini.getBiayaTmbhn1(), depositTitle, "The Deposit is not equal to "+depositTitle+"");
                Assert.assertEquals(ownersini.getBiayaTmbhnPrice1(), depositPrice, "The Deposit Price is not equal to "+depositPrice+"");
                Assert.assertEquals(ownersini.getBiayaTmbhn2(), wifiTitle, "The Wifi is not equal to "+wifiTitle+"");
                Assert.assertEquals(ownersini.getBiayaTmbhnPrice2(), wifiPrice, "The Wifi Price is not equal to "+wifiPrice+"");
                Assert.assertEquals(ownersini.getBiayaTmbhn3(), listrikTitle, "The Listrik is not equal to "+listrikTitle+"");
                Assert.assertEquals(ownersini.getBiayaTmbhnPrice3(), listrikPrice, "The Listrik Price is not equal to "+listrikPrice+"");
            }
        } else if (section.equalsIgnoreCase("Additional Informasion Section")) {
            Assert.assertTrue(ownersini.isInfoTambahanVisible(), "The Additional Information is not visible");
        } else if (section.equalsIgnoreCase("Property Photo section")) {
            int totalColoumn = ownersini.getTotalCol();
            String[] judul = {"Peraturan Kost", "Foto 360", "Foto Bangunan", "Foto Tampak dari Jalan", "Foto Fasilitas Umum", "Foto Lainnya"};
            for (int i=0; i<totalColoumn; i++){
                if (ownersini.isLihatSemuaVisible(i)){
                    ownersini.clicksLihatSemua(i);
                    Assert.assertEquals(ownersini.getImageTitle(), judul[i]);
                    ownersini.clicksClosePopUpImage();
                }
            }
        }
    }

    @When("user clicks Tipe Kamar menu")
    public void user_clicks_Tipe_Kamar_menu(){
        ownersini.clicksTipeKamarMenu();
    }

    @Then("the Room Type and Room Total section in Room Type is displayed")
    public void the_Room_Type_and_Room_Total_section_in_Room_Type_is_displayed(){
        int totalRoomListing = ownersini.getTotalRoomListing();
        String[] roomType = {"Tipe A  campur", "Tipe C  campur", "Tipe D  campur"};
        for (int i=0; i<totalRoomListing; i++){
            Assert.assertEquals(ownersini.getRoomType(i+1), roomType[i], "The Room Type is not match");
            ownersini.clicksLihatSelengkapnya(i);

            //check Foto Kamar
            String[] title = {"Foto Cover", "Foto Kamar", "Foto Kamar Mandi"};
            for (int j=0; j<4; j++){
                if (ownersini.isPropertyPhotoVisible(1+i, j)){
                    ownersini.clicksLihatSemuaInRoomType(1+i, j);
                    Assert.assertEquals(ownersini.getImageTitle(), title[j-1]);
                    ownersini.clicksClosePopUpImage();
                }
            }

            //check Nomor Kamar
            Assert.assertEquals(ownersini.getRoomNumberTitle(1+i), roomNumberTitle, "The Room Number Title is not match");
            Assert.assertTrue(ownersini.isRoomNumberVisible(i), "The Room Number is not visible");

            //check Harga Sewa Kamar
            Assert.assertEquals(ownersini.getRoomPriceTitle(1+i), roomPriceTitle, "The Room Price Title is not match");
            String[] price = {"price-tagRp0 / Hari", "price-tagRp600.000 / Bulan", "price-tagRp2.500.000 / 3 Bulan", "price-tagRp3.600.000 / 6 Bulan", "price-tagRp7.200.000 / 12 Bulan"};
            for (int k=0; k<5; k++){
                Assert.assertEquals(ownersini.getPrice(1+i,1+k), price[k]);
            }

            //check Luas Kamar
            Assert.assertEquals(ownersini.getRoomAreaTitle(1+i), roomAreaTitle, "The Room Area Title is not match");
            Assert.assertTrue(ownersini.isRoomAreaValue(1+i), "The Room Area is not visible");

            //check Listrik
            Assert.assertEquals(ownersini.getElectricityTitle(1+i), electricityTitle, "The Electricity Title is not match");
            Assert.assertTrue(ownersini.isElectricityValue(1+i), "The Electricity is not visible");

            //check Fasilitas Kamar
            Assert.assertEquals(ownersini.getRoomFacilityTitle(1+i), roomFacilityTitle, "The Room Facilities Title is not match");
            Assert.assertTrue(ownersini.isRoomFacilityValue(1+i), "The Room Facilities is not visible");

            //check Fasilitas Kamar Mandi
            Assert.assertEquals(ownersini.getBathroomFacilityTitle(1+i), bathroomFacilityTitle, "The Bathroom Facilities Title is not match");
            Assert.assertTrue(ownersini.isBathroomFacilityValue(1+i), "The Bathroom Facilities is not visible");

            ownersini.clicksTampilkanLebihSedikit();
        }
    }

    @When("owner clicks on top right corner Profil Pillar 2")
    public void owner_clicks_on_top_right_corner_Profil_Pillar_2(){
        ownersini.clicksTopRightCornerProfilP2();
    }

    @Then("Dashboard Singgahsini button is not displayed")
    public void Dashboard_Singgahsini_button_is_not_displayed(){
        Assert.assertFalse(ownersini.isDashboardSinggahsiniBtnVisible(), "Dashboard Singgahsini button is displayed on Pillar 2.");
    }
    @When("owner logout from ownersini dashboard")
    public void owner_logout_from_ownersini_dashboard() {
        ownersini.logoutP1();
    }
}
