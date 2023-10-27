package steps.pms;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.common.LoadingPO;
import pageobject.pms.HomepagePO;

import java.util.List;
import java.util.Map;

public class HomepageSteps {
    Page page = ActiveContext.getActivePage();
    HomepagePO homepage = new HomepagePO(page);

    LoadingPO loading = new LoadingPO(page);

    private List<Map<String, String>> informasiPembayaran;
    private List<Map<String, String>> gender;

    private List<Map<String, String>> otherFee;

    @And("admin go to room allotment page {string}")
    public void admin_go_to_room_allotment_page(String name) {
        homepage.searchProperty(name);
        homepage.clickActionButton();
        homepage.clickRoomAllotment();
    }

    @When("admin go to detail property {string}")
    public void admin_go_to_detail_property(String name) {
        homepage.searchProperty(name);
        homepage.clickActionButton();
        homepage.clickSeeDetail();
    }

    @And("admin create contract tenant new booking")
    public void admin_create_contract_tenant_new_booking() {
        homepage.clickOnTambahPenyewa();
        homepage.clickOnBooking();
        homepage.clickOnDropdownTipeBooking();
        homepage.clickOnNewBooking();
        homepage.clickOnSelanjutnyaButton();
    }

    @And("admin selected type room")
    public void admin_selected_type_room() {
        homepage.clickOnTypeRoom();
    }

    @And("admin fill phone number tenant {string}")
    public void admin_fill_number_handphone_tenant(String number) {
        homepage.fillNumberHandphoneTenant(number);
    }

    @And("admin fill nama tenant {string}")
    public void admin_fill_nama_tenant(String name) {
        homepage.fillNameTenant(name);
    }

    @Then("admin see informasi penyewa")
    public void admin_see_informasi_penyewa() {
        Assert.assertTrue(homepage.isInformasiPenyewaDisplayed(), "Informasi penyewa is not displayed");
    }

    @And("admin fill informasi pembayaran:")
    public void admin_fill_informasi_pembayaran(DataTable tables) {
        informasiPembayaran = tables.asMaps(String.class, String.class);
        String hitunganSewaKos = informasiPembayaran.get(0).get("Hitungan Sewa");
        String tanggalCheckIn = informasiPembayaran.get(0).get("Tanggal Check-in");
        String durasiSewa = informasiPembayaran.get(0).get("Durasi Sewa");
        String metodePembayaran = informasiPembayaran.get(0).get("Metode Pembayaran");
        homepage.fillHitunganSewa(hitunganSewaKos);
        homepage.fillTanggalCheckInKos(tanggalCheckIn);
        homepage.fillDurasiSewa(durasiSewa);
        homepage.fillNomorKamar();
        homepage.fillMetodePembayaran(metodePembayaran);
    }

    @And("admin add other cost:")
    public void admin_add_other_cost(DataTable tables) {
        otherFee = tables.asMaps(String.class, String.class);
            String nameFee0 = otherFee.get(0).get("Nama Biaya");
            String nameFee1 = otherFee.get(1).get("Nama Biaya");
            String amountFee0 = otherFee.get(0).get("Harga");
            String amountFee1 = otherFee.get(1).get("Harga");
            homepage.fillOtherFeeName(nameFee0, nameFee1);
            homepage.fillOtherFeeAmount(amountFee0, amountFee1);
        }

    @And("admin see has fee Informasi Biaya Lain:")
    public void admin_see_has_other_fee(DataTable tables) {
        otherFee = tables.asMaps(String.class, String.class);
        String nameFee0 = otherFee.get(0).get("Nama Biaya");
        String nameFee1 = otherFee.get(1).get("Nama Biaya");
        String amountFee0 = otherFee.get(0).get("Harga");
        String amountFee1 = otherFee.get(1).get("Harga");
        Assert.assertTrue(homepage.isInformasiBiayaLainDisplayed(nameFee0, nameFee1, amountFee0, amountFee1), "is displayed");
    }

        @Then("admin click on save button")
    public void admin_click_on_save_button() {
            homepage.clickOnSaveButton();
        }

    //--------------------dbet pms--------//
    @And("admin create contract tenant dbet")
    public void admin_create_contract_tenant_dbet() {
        loading.waitForLoadingIconDisappear();
        homepage.clickOnTambahPenyewa();
        homepage.clickDbetButton();
    }

    @Then("admin can see {string} on phone number")
    public void admin_can_see_error_message_on_phone_number(String text) {
        Assert.assertEquals(homepage.getPhoneNumberErrorMessage(),text, "not display error message");
    }

    @Then("admin can see {string} on tenant name")
    public void admin_can_see_x_on_tenant_name(String text) {
        Assert.assertEquals(homepage.getTenantNameErrorMessage(), text, "not display error message");
    }

    @And("admin fill email tenant {string}")
    public void admin_fill_email_tenant(String email) {
        homepage.fillEmailTenant(email);
    }

    @Then("admin can see {string} on email")
    public void admin_can_see_x_on_email(String text) {
        Assert.assertEquals(homepage.getEmailErrorMessage(), text, "not display error message");
    }

}

