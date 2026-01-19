package steps.mamikos.owner.mamiads;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.common.HomePO;
import pageobject.owner.fiturpromosi.mamiads.MamiAdsPO;
import pageobject.owner.fiturpromosi.mamiads.NaikkanIklanPO;
import utilities.PlaywrightHelpers;

import java.util.List;
import java.util.Map;

public class NaikkanIklanSteps {
    Page page = ActiveContext.getActivePage();
    MamiAdsPO mamiAdsPO = new MamiAdsPO(page);
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    NaikkanIklanPO naikkanIklanPO = new NaikkanIklanPO(page);
    HomePO home = new HomePO(page);

    @Then("user cek status toggle iklan {string} is {string}")
    public void user_cek_status_toggle_iklan_is(String adsName, String posisiIklan) {
        playwright.waitTillPageLoaded(10000.0);
        if (posisiIklan.equals("naik")) {
            Assert.assertEquals(naikkanIklanPO.getPosisiIklan(adsName, posisiIklan), "Naik", "Posisi iklan doesn't available");
        } else if (posisiIklan.equals("tidak-naik")) {
            Assert.assertEquals(naikkanIklanPO.getPosisiIklan(adsName, posisiIklan), "Tidak Naik", "Posisi iklan available");
        }
    }

    @Then("user verify the toggle iklan {string} is {string}")
    public void user_verify_the_toggle_iklan_is(String adsName, String toggleStatus) {
        playwright.waitTillPageLoaded(3000.0);
        Assert.assertTrue(naikkanIklanPO.getToggleStatus(adsName, toggleStatus), "toggle doesn't match!");
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
        switch (adsDescText) {
            case "Kamar penuh":
                Assert.assertEquals(naikkanIklanPO.getAdsDescText(adsDescText), "Kamar penuh. Silakan nonaktifkan jika tidak ingin menaikkan posisi iklan ini.");
                break;
            case "Kamar sudah penuh":
                Assert.assertEquals(naikkanIklanPO.getAdsDescText(adsDescText), "Kamar Sudah Penuh. Update kamar kosong jika ingin memakai MamiAds kembali..");
                break;
        }
    }

    @Then("user verify the redirection to list mamiads balance")
    public void user_verify_the_redirection_to_list_mamiads_balance() throws InterruptedException {
        naikkanIklanPO.clickOnAllocationSection();
        String actualUrl = playwright.getPageUrl();
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
        Assert.assertEquals(naikkanIklanPO.getTextSwitchTogglePopUp("off"), "Anggaran MamiAds untuk " + Mamikos.getPropertyKosName() + " akan diaktifkan.", "Title pop up doesn't match!");
        naikkanIklanPO.clickOnKeMamiAdsButton();
        // Wait for navigation to complete instead of fixed wait
        playwright.waitTillPageLoaded();
        String actualUrl = playwright.getPageUrl();
        Assert.assertEquals(actualUrl, "https://owner-jambu.kerupux.com/mamiads", "Url doesn't match");
    }

    @Then("verify quick allocation section while ads last allocation {string}")
    public void verifyQuickAllocationSectionWhileAdsLastAllocation(String tipeAllocation) {
        String adsDescText = "Tipe anggaran: Rp10.000 per-hari";
        String adsDescTextMax = "Tipe anggaran: Saldo Maksimal";

        Assert.assertEquals(naikkanIklanPO.getAlokasiTitleText("Aktifkan MamiAds"), "Aktifkan MamiAds", "Allocation title doesn't match!");
        Assert.assertTrue(naikkanIklanPO.getToggleAdsStatus("off"), "Status toggle doesn't match");

        switch (tipeAllocation) {
            case "daily":
                Assert.assertEquals(naikkanIklanPO.getAdsDescText(adsDescText), adsDescText, "Allocation description doesn't match!");
                break;
            case "maksimal":
                Assert.assertEquals(naikkanIklanPO.getAdsDescText(adsDescTextMax), adsDescTextMax, "Allocation description doesn't match!");
                break;
        }
    }

    @When("user cancel quick allocate the ads ever allocate")
    public void user_cancel_quick_allocate_the_ads_ever_allocate() throws InterruptedException {
        naikkanIklanPO.clickToggleTheAdsOnPropertySaya();
        Assert.assertEquals(naikkanIklanPO.getTextSwitchTogglePopUp("off"), "Apakah Anda ingin mengganti metode anggaran untuk iklan ini?", "Title pop up doesn't match!");
        naikkanIklanPO.clickOnKeMamiAdsButton();
    }

    @Then("verify redirect to mamiads dashboard")
    public void verify_redirect_to_mamiads_dashboard() {
        // Wait for navigation to complete instead of fixed wait
        playwright.waitTillPageLoaded();
        home = new HomePO(ActiveContext.getActivePage());
        String actualUrl = home.getURL();
        Assert.assertTrue(actualUrl.contains("owner"));
        Assert.assertTrue(actualUrl.contains("mamiads"));
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

        switch (tipeAllocation) {
            case "daily":
                Assert.assertEquals(naikkanIklanPO.getAdsDescText(adsDescText), adsDescText, "Allocation description doesn't match!");
                break;
            case "maksimal":
                Assert.assertEquals(naikkanIklanPO.getAdsDescText(adsDescTextMax), adsDescTextMax, "Allocation description doesn't match!");
                break;
        }
    }

    @When("user nonactive the allocation of ads")
    public void user_nonactive_the_allocation_of_ads() throws InterruptedException {
        naikkanIklanPO.clickToggleTheAdsOnPropertySaya();
        Assert.assertEquals(naikkanIklanPO.getTextTitlePopUp(), "Yakin ingin menonaktifkan MamiAds untuk iklan ini?", "Title pop up doesn't match!");
        naikkanIklanPO.clickOnNonaktifkanAds();
    }

    @And("user can see filter iklan saya is {string}")
    public void user_can_see_filter_iklan_saya_is(String filterText) {
        Assert.assertTrue(naikkanIklanPO.getTeksFilter().contains(filterText), "Filter doesn't match!");
    }

    @And("owner choose filter iklan saya to {string}")
    public void ownerChooseFilterIklanSayaTo(String filter) {
        naikkanIklanPO.clickOnFilterActive(filter);
    }

    @And("user verify the wording iklan {string} is {string}")
    public void userVerifyTheWordingIklanIs(String adsName, String adsStatusDesc) {
        var actualMsg = naikkanIklanPO.getAdsStatusDesc(adsName);
        Assert.assertTrue(actualMsg.contains(adsStatusDesc), String.format("Ads status description doesn't match! with actual %s", actualMsg));
    }

    @And("user verify the wording anggaran of iklan {string} is {string}")
    public void user_verify_the_wording_anggaran_of_iklan_is(String adsName, String anggaranDesc) throws InterruptedException {
        playwright.waitTillPageLoaded(5000.0);
        Assert.assertEquals(naikkanIklanPO.getTextAnggaranDesc(adsName), anggaranDesc, "Anggaran description doesn't match!");
    }

    @And("user verify the wording anggaran of iklan {string} contains {string}")
    public void user_verify_the_wording_anggaran_of_iklan_contains(String adsName, String anggaranDesc) {
        var anggaranReal = naikkanIklanPO.getTextAnggaranDesc(adsName);
        Assert.assertTrue(anggaranReal.contains(anggaranDesc), String.format("Anggaran description doesn't match! real is %s", anggaranReal));
    }

    @When("user click {string} toggle the {string}")
    public void user_click_toggle_the(String toggleStatus, String adsName) {
        naikkanIklanPO.clickToggleTheAds(toggleStatus, adsName);
    }

    @Then("user verify the pop up switch {string} toggle iklan {string} is displayed")
    public void user_verify_the_pop_up_switch_toggle_iklan_is_displayed(String action, String adsName) {
        int balanceMa = naikkanIklanPO.getSaldoMaText();
        if (action.equals("on") && balanceMa >= 5000) {
            Assert.assertEquals(naikkanIklanPO.getTextSwitchTogglePopUp(action), "Jika Anda menonaktifkannya, posisi iklan " + adsName + " tidak dinaikkan di hasil pencarian.");
        } else if (action.equals("off") && balanceMa >= 5000) {
            Assert.assertEquals(naikkanIklanPO.getTextSwitchTogglePopUp(action), "Anggaran MamiAds untuk " + adsName + " akan diaktifkan");
        } else {
            Assert.assertEquals(naikkanIklanPO.getTitleBeliSaldoPopUp(), "Anda belum bisa menaikkan iklan.");
        }
    }

    @When("user click {string} button on pop up switch toggle iklan")
    public void userClickButtonOnPopUpSwitchToggleIklan(String actionButton) {
        naikkanIklanPO.clickActionButtonInPopUp(actionButton);
    }

    @Then("user verify the wording iklan kamar penuh {string} is {string}")
    public void user_verify_the_wording_iklan_kamar_penuh_is(String adsName, String adsDesc) {
        Assert.assertEquals(mamiAdsPO.isFullOcuppancyActiveAds(adsName), adsDesc, "Kamar Penuh doesn't match!");
    }

    @And("ads list rooms as expected")
    public void ads_list_rooms_as_expected(DataTable dataTable) {
        List<Map<String, String>> table = dataTable.asMaps();
        int i = 0;
        int j = 0;
        int k = 0;
        for (Map<String, String> content : table) {
            Assert.assertEquals(naikkanIklanPO.listAds("adsName", i), content.get("adsName"));
            Assert.assertEquals(naikkanIklanPO.listAds("posisiIklan", i), content.get("posisiIklan"));

            String currentToggle = content.get("currentToggle");
            if (currentToggle != null && !currentToggle.equals("-")) {
                Assert.assertTrue(naikkanIklanPO.listAdsToggle(currentToggle, j), currentToggle);
            }

            String availRoom = content.get("availRoom");
            if (availRoom != null && !availRoom.equals("-")) {
                Assert.assertEquals(naikkanIklanPO.listAds("availRoom", j), availRoom);
                j++;
            }

            String currentStatusDesc = content.get("currentStatusDesc");
            if (currentStatusDesc != null && !currentStatusDesc.equals("-")) {
                Assert.assertEquals(naikkanIklanPO.listAds("currentStatusDesc", k), currentStatusDesc);
                k++;
            }

            i++;
        }
    }

    @Then("verify the saldo mamiads with condition lessThan {int}")
    public void verify_the_saldo_mamiads_with_condition_lessThan(int minimalSaldo) {
        int saldoMa = naikkanIklanPO.getSaldoMaText();
        Assert.assertTrue(saldoMa < minimalSaldo, "Saldo MamiAds greatherThan Saldo Maksimal");
    }
}
