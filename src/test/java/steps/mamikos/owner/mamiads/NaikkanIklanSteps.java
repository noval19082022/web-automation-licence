package steps.mamikos.owner.mamiads;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.owner.mamiads.MamiAdsPO;
import pageobject.owner.mamiads.NaikkanIklanPO;
import utilities.PlaywrightHelpers;

public class NaikkanIklanSteps {
    Page page = ActiveContext.getActivePage();
    MamiAdsPO mamiAdsPO = new MamiAdsPO(page);
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    NaikkanIklanPO naikkanIklanPO = new NaikkanIklanPO(page);

    @Then("user cek status toggle iklan {string} is {string}")
    public void user_cek_status_toggle_iklan_is(String adsName, String posisiIklan) throws InterruptedException {
        if (posisiIklan.equals("Naik")) {
            Assert.assertEquals(naikkanIklanPO.getPosisiIklan(posisiIklan), "Naik", "Posisi iklan doesn't available");
            Assert.assertEquals(naikkanIklanPO.getAdsName(adsName), adsName,"ads name doesnt match");
        } else if (posisiIklan.equals("tidak-naik")) {
            Assert.assertEquals(naikkanIklanPO.getPosisiIklan(posisiIklan), "Tidak Naik", "Posisi iklan available");
            Assert.assertEquals(naikkanIklanPO.getAdsName(adsName), adsName,"ads name doesnt match");
        }
    }

    @Then("user verify the toggle iklan {string} is {string}")
    public void user_verify_the_toggle_iklan_is(String adsName, String toggleStatus) throws InterruptedException {
        Assert.assertTrue(naikkanIklanPO.getToggleStatus(toggleStatus), "toggle doesn't match!");
        Assert.assertEquals(naikkanIklanPO.getAdsName(adsName), adsName,"ads name doesnt match");
    }

    @Then("user verify the wording iklan penuh {string} is {string}")
    public void user_verify_the_wording_iklan_penuh_is(String adsName, String adsDesc) throws InterruptedException {
        Assert.assertEquals(naikkanIklanPO.isFullOcuppancyActiveAds().replaceAll("\n", "").replaceAll("\\s+", " "), adsDesc, "Kamar Penuh doesn't match!");
        Assert.assertEquals(naikkanIklanPO.getAdsName(adsName), adsName,"ads name doesnt match");
    }

    @Then("user verify the alokasi title is {string}")
    public void user_verify_the_alokasi_title_is(String alokasiTitleText) {
        Assert.assertEquals(naikkanIklanPO.getAlokasiTitleText(alokasiTitleText), alokasiTitleText, "Alokasi title doesn't match!");
    }

    @Then("user verify the toggle is {string}")
    public void user_verify_the_toggle_is(String toggleAdsStatus) {
        Assert.assertTrue(naikkanIklanPO.getToggleAdsStatus(toggleAdsStatus), "toggle ads status doesn't match!");
    }

    @Then("user verify the wording ads is {string}")
    public void user_verify_the_wording_ads_is(String adsDescText) {
        switch (adsDescText){
            case "Kamar penuh":
                Assert.assertEquals(naikkanIklanPO.getAdsDescText(adsDescText), "Kamar penuh. Silakan nonaktifkan jika tidak ingin menaikkan posisi iklan ini.");
                break;
        }
    }

    @When("owner select filter active mamiads")
    public void owner_select_filter_active_mamiads() {
       naikkanIklanPO.clickOnFilterActive();
    }

    @Then("user verify the redirection to list mamiads balance")
    public void user_verify_the_redirection_to_list_mamiads_balance() throws InterruptedException {
        naikkanIklanPO.clickOnAllocationSection();
        String actualUrl= playwright.getPageUrl();
        Assert.assertEquals(actualUrl, "https://owner-jambu.kerupux.com/mamiads/balance?redirectionSource=properti%20saya", "Url doesn't match");
    }

    @Then("verify quick allocation section while never allocate")
    public void verify_quick_allocation_section_while_never_allocate() {
        Assert.assertEquals(naikkanIklanPO.getAlokasiTitleText("Aktifkan MamiAds"), "Aktifkan MamiAds", "Allocation title doesn't match!");
        Assert.assertTrue(naikkanIklanPO.getToggleAdsStatus("off"), "Status toggle doesn't match");
        Assert.assertEquals(naikkanIklanPO.getAdsDescText("Anggarkan saldo agar posisi iklan naik"), "Anggarkan saldo agar posisi iklan naik", "Allocation description doesn't match!");
    }

    @When("user cancel quick allocate the ads never allocate")
    public void user_cancel_quick_allocate_the_ads_never_allocate() throws InterruptedException {
       naikkanIklanPO.clickToggleTheAdsOnPropertySaya();
        Assert.assertEquals(naikkanIklanPO.getTextSwitchTogglePopUp("off"), "Anggaran MamiAds untuk "+ naikkanIklanPO.getNameKos() +" akan diaktifkan.", "Title pop up doesn't match!");
        naikkanIklanPO.clickOnKeMamiAdsButton();
        playwright.hardWait(3000);
        String actualUrl= playwright.getPageUrl();
        Assert.assertEquals(actualUrl, "https://owner-jambu.kerupux.com/mamiads", "Url doesn't match");
    }

    @Then("verify quick allocation section while ads last allocation {string}")
    public void verifyQuickAllocationSectionWhileAdsLastAllocation(String tipeAllocation) throws InterruptedException {
        String adsDescText = "Tipe anggaran: Rp10.000 per-hari";
        String adsDescTextMax = "Tipe anggaran: Saldo Maksimal";

        Assert.assertEquals(naikkanIklanPO.getAlokasiTitleText("Aktifkan MamiAds"), "Aktifkan MamiAds", "Allocation title doesn't match!");
        Assert.assertTrue(naikkanIklanPO.getToggleAdsStatus("off"), "Status toggle doesn't match");

        switch(tipeAllocation){
            case "daily":
                Assert.assertEquals(naikkanIklanPO.getAdsDescText(adsDescText), adsDescText, "Allocation description doesn't match!"); break;
            case "maksimal":
                Assert.assertEquals(naikkanIklanPO.getAdsDescText(adsDescTextMax), adsDescTextMax, "Allocation description doesn't match!"); break;
        }
    }

    @When("user cancel quick allocate the ads ever allocate")
    public void user_cancel_quick_allocate_the_ads_ever_allocate() throws InterruptedException {
        naikkanIklanPO.clickToggleTheAdsOnPropertySaya();
        Assert.assertEquals(naikkanIklanPO.getTextSwitchTogglePopUp("off"), "Apakah Anda ingin mengganti metode anggaran untuk iklan ini?", "Title pop up doesn't match!");
        naikkanIklanPO.clickOnKeMamiAdsButton();
    }

    @Then("verify redirect to mamiads dashboard")
    public void verify_redirect_to_mamiads_dashboard() throws InterruptedException {
        playwright.hardWait(3000);
        String actualUrl= playwright.getPageUrl();
        Assert.assertEquals(actualUrl, "https://owner-jambu.kerupux.com/mamiads", "Url doesn't match");
    }

    @When("user reactive the allocation of ads")
    public void userReactiveTheAllocationOfAds() throws InterruptedException {
        naikkanIklanPO.clickToggleTheAdsOnPropertySaya();
        Assert.assertEquals(naikkanIklanPO.getTextSwitchTogglePopUp("off"), "Apakah Anda ingin mengganti metode anggaran untuk iklan ini?", "Title pop up doesn't match!");
      naikkanIklanPO.clickOnNantiSaja();
    }

    @Then("verify the ads Aktif MamiAds with {string} allocation")
    public void verify_the_ads_aktif_mamiAds_with_allocation(String tipeAllocation) {
        String adsDescText = "Hari ini Rp0 sudah dipakai dari batas pemakaian saldo Rp10.000";
        String adsDescTextMax = "Hari ini terpakai Rp0";

        Assert.assertEquals(naikkanIklanPO.getAlokasiTitleText("MamiAds Aktif"), "MamiAds Aktif", "Allocation title doesn't match!");
        Assert.assertTrue(naikkanIklanPO.getToggleAdsStatus("on"), "Status toggle doesn't match");

        switch(tipeAllocation){
            case "daily":
                Assert.assertEquals(naikkanIklanPO.getAdsDescText(adsDescText), adsDescText, "Allocation description doesn't match!"); break;
            case "maksimal":
                Assert.assertEquals(naikkanIklanPO.getAdsDescText(adsDescTextMax), adsDescTextMax, "Allocation description doesn't match!"); break;
        }
    }

    @When("user nonactive the allocation of ads")
    public void user_nonactive_the_allocation_of_ads() throws InterruptedException {
        naikkanIklanPO.clickToggleTheAdsOnPropertySaya();
        Assert.assertEquals(naikkanIklanPO.getTextTitlePopUp(), "Yakin ingin menonaktifkan MamiAds untuk iklan ini?", "Title pop up doesn't match!");
        naikkanIklanPO.clickOnNonaktifkanAds();
    }
}
