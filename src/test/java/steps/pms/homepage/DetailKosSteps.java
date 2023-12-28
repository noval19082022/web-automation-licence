package steps.pms.homepage;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.pms.homepage.DetailKosPO;

import java.util.List;

public class DetailKosSteps {
    Page page = ActiveContext.getActivePage();
    DetailKosPO detailKos = new DetailKosPO(page);
    @When("admin go to detail kos tab")
    public void admin_go_to_detail_kos_tab() {
        detailKos.clickDetailKosTab();
    }
    @When("admin ubah data property")
    public void admin_ubah_data_property() {
        detailKos.clickUbahDataProperty();
    }
    @When("admin add lokasi strategis")
    public void admin_add_lokasi_strategis(List<String> lokasiStrategis) {
        for (int i=0;i< lokasiStrategis.size();i++) {
            detailKos.setLokasiStrategis(i,lokasiStrategis.get(i));
            detailKos.tambahLokasiStrategis();
        }
        detailKos.submitDataProperty();
    }
    @When("admin back to detail kos {string}")
    public void admin_back_to_detail_kos(String propID) {
        detailKos.redirectToDetailKos(propID);
    }
    @Then("lokasi strategis should be list in detail kos")
    public void lokasi_strategis_should_be_list_in_detail_kos(List<String> lokasiStrategis) {
        detailKos.expandLokasiStrategis();
        for (int i=0;i< lokasiStrategis.size();i++) {
            Assert.assertEquals(detailKos.getLokasiStrategis(i),lokasiStrategis.get(i));
        }
    }
    @When("add {int} lokasi strategis")
    public void add_lokasi_strategis(int total) {
        detailKos.tambahLokasiStrategis(total);
    }
    @Then("tambah lokasi strategis button should be disabled")
    public void tambah_lokasi_strategis_button_should_be_disabled() {
        Assert.assertTrue(detailKos.isTambahLokasiStrategisButtonDisable());
    }
    @When("admin edit {string} lokasi strategis {string}")
    public void admin_edit_lokasi_strategis(String index, String lokasi) {
        int i = Integer.parseInt(index)-1;
        String lokasi256 = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has sur";

        if (lokasi.equalsIgnoreCase(">255 char")){
            detailKos.setLokasiStrategis(i,lokasi256);
        } else {
            detailKos.setLokasiStrategis(i,lokasi);
            detailKos.submitDataProperty();
        }
    }
    @When("admin delete lokasi strategis {string}")
    public void admin_delete_lokasi_strategis(String index) {
        int i = Integer.parseInt(index)-1;
        detailKos.deleteLokasiStrategis(i);
        detailKos.submitDataProperty();
    }
    @Then("delete button should be disabled")
    public void delete_button_should_be_disabled() {
        Assert.assertTrue(detailKos.isDeleteButtonDisable());
    }
    @When("admin clear lokasi strategis {string}")
    public void admin_clear_lokasi_strategis(String index) {
        int i = Integer.parseInt(index)-1;
        detailKos.clearTextLokasiStrategis(i);
        detailKos.submitDataProperty();
    }
    @Then("lokasi strategis should be empty")
    public void lokasi_strategis_should_be_empty() {
        detailKos.expandLokasiStrategis();
        Assert.assertEquals(detailKos.getEmptyLokasiStrategis(),"-");
    }
    @Then("error message max character lokasi strategis appear")
    public void error_message_max_character_lokasi_strategis_appear_in_row() {
        Assert.assertEquals(detailKos.getErrorMessageLokasiStrategis(),"Panjang karakter maksimal adalah 255 karakter.");
    }
}
