package steps.pms.homepage;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.pms.homepage.KontrakKerjaSamaPO;

import java.util.List;
import java.util.Map;

public class KontrakKerjaSamaSteps {
    Page page = ActiveContext.getActivePage();

    KontrakKerjaSamaPO contract = new KontrakKerjaSamaPO(page);

    private List<Map<String, String>> profilPemilik;
    private List<Map<String, String>> profilPemilikEdit;

    @When("admin see profil pemilik")
    public void admin_see_profil_pemilik() {
        contract.clickKontrakKerjaSamaTab();
    }
    @Then("profil pemilik section match with data")
    public void profil_pemilik_section_match_with_data(DataTable tables) {
        profilPemilik = tables.asMaps(String.class, String.class);
        String nama = profilPemilik.get(0).get("Nama");
        String noHP = profilPemilik.get(0).get("Nomor HP");
        String alamat = profilPemilik.get(0).get("Alamat");
        String provinsi = profilPemilik.get(0).get("Provinsi");
        String kota = profilPemilik.get(0).get("kota/Kabupaten");
        String kecamatan = profilPemilik.get(0).get("Kecamatan");
        String kelurahan = profilPemilik.get(0).get("Kelurahan");

        contract.assertNamaPemilik(nama);
        contract.assertNoHPPemilik(noHP);
        contract.assertAlamatPemilik(alamat);
        contract.assertProvinsiPemilik(provinsi);
        contract.assertKotaPemilik(kota);
        contract.assertKecamatanPemilik(kecamatan);
        contract.assertKelurahanPemilik(kelurahan);
    }
    @When("admin edit profil pemilik")
    public void admin_edit_profil_pemilik(DataTable tables) {
        profilPemilikEdit = tables.asMaps(String.class, String.class);
        String nama = profilPemilikEdit.get(0).get("Nama");
        String noHP = profilPemilikEdit.get(0).get("Nomor HP");
        String alamat = profilPemilikEdit.get(0).get("Alamat");
        String provinsi = profilPemilikEdit.get(0).get("Provinsi");
        String kota = profilPemilikEdit.get(0).get("kota/Kabupaten");
        String kecamatan = profilPemilikEdit.get(0).get("Kecamatan");
        String kelurahan = profilPemilikEdit.get(0).get("Kelurahan");

        contract.ubahProfilPemilik();
        contract.editNamaPemilik(nama);
        contract.editNoHPPemilik(noHP);
        contract.editAlamatPemilik(alamat);
        contract.editProvinsiPemilik(provinsi);
        contract.editKotaPemilik(kota);
        contract.editKecamatanPemilik(kecamatan);
        contract.editKelurahanPemilik(kelurahan);
        contract.submitEditProfilPemilik();
    }
}
