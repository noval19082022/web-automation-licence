package steps.pms.homepage;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.pms.homepage.OverviewPO;

import java.util.List;
import java.util.Map;

public class OverviewSteps {
    Page page = ActiveContext.getActivePage();
    OverviewPO overview = new OverviewPO(page);

    private List<Map<String, String>> profil;
    private List<Map<String, String>> profilEdit;
    private List<Map<String, String>> penanggungJawab;

    @Then("profil property should match")
    public void profil_property_should_match(DataTable tables) {
        profil = tables.asMaps(String.class, String.class);
        String id = profil.get(0).get("ID");
        String nama = profil.get(0).get("Nama Property");
        String produk = profil.get(0).get("Jenis Produk");
        String tipe = profil.get(0).get("Tipe");
        String pekerjaan = profil.get(0).get("Syarat Pekerjaan Penyewa");
        String agama = profil.get(0).get("Syarat Agama Penyewa");
        String alamat = profil.get(0).get("Alamat");
        String map = profil.get(0).get("Peta Lokasi");

        overview.assertProfilProperty(id,nama,produk,tipe,pekerjaan,agama,alamat,map);
    }

    @When("admin edit profil property")
    public void admin_edit_profil_property(DataTable tables) {
        profilEdit = tables.asMaps(String.class, String.class);
        String name = profilEdit.get(0).get("Nama Properti");
        String occupation = profilEdit.get(0).get("Syarat Pekerjaan Penyewa");
        String religion = profilEdit.get(0).get("Syarat Agama Penyewa");
        String address = profilEdit.get(0).get("Alamat");
        String location = profilEdit.get(0).get("Peta Lokasi");

        overview.editProfilProperty(name,occupation,religion,address,location);
    }

    @When("admin see penanggung jawab section")
    public void admin_see_penanggung_jawab_section() {
        overview.viewSectionPenanggungJawab();
    }
    @Then("penanggung jawab should be match")
    public void penanggung_jawab_should_be_match(DataTable tables) {
        penanggungJawab = tables.asMaps(String.class, String.class);
        String bse = penanggungJawab.get(0).get("BSE");
        String bd = penanggungJawab.get(0).get("BD");
        String as = penanggungJawab.get(0).get("AS");
        String hospi = penanggungJawab.get(0).get("Hospitality");

        overview.assertPenanggungJawab(bse,bd,as,hospi);
    }
    @When("admin edit penanggung jawab")
    public void admin_edit_penanggung_jawab(DataTable tables) {
        penanggungJawab = tables.asMaps(String.class, String.class);
        String bse = penanggungJawab.get(0).get("BSE");
        String bd = penanggungJawab.get(0).get("BD");
        String as = penanggungJawab.get(0).get("AS");
        String hospi = penanggungJawab.get(0).get("Hospitality");

        overview.editPenanggungJawab(bse,bd,as,hospi);
    }
}
