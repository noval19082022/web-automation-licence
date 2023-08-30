package pageobject.pms.homepage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class OverviewPO {
    private Page page;

    Locator profilProperty;
    Locator maps;
    Locator confirmSimpanButton;

    //Edit Profil Property
    Locator ubahProfilButton;
    Locator propertyName;
    Locator pekerjaanDropdown;
    Locator pekerjaan;
    Locator pekerjaanActive;
    Locator religionDropdown;
    Locator religion;
    Locator religionActive;
    Locator alamat;
    Locator petaLokasi;
    Locator simpanButton;
    //End Edit Profil Property

    //Penanggung jawab
    Locator penanggungJawabSection;
    Locator bseName;
    Locator bdName;
    Locator asName;
    Locator hospiName;
    Locator editButton;
    //End Penanggung jawab

    //Penanggung Jawab Edit
    Locator bseDropdown;
    Locator bdDropdown;
    Locator asDropdown;
    Locator hospiDropdown;
    Locator dropdownOptions;
    //End Penanggung Jawab Edit

    public OverviewPO(Page page){
        this.page = page;

        profilProperty = page.locator(".organism-property-profile .bg-c-text--body-2");
        maps = page.locator(".organism-property-profile .bg-c-text--body-2 a");

        ubahProfilButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ubah"));
        propertyName = page.getByPlaceholder("Masukkan nama properti");
        pekerjaanDropdown = page.locator(".search-checkbox__trigger").nth(0);
        religionDropdown = page.locator(".search-checkbox__trigger").nth(1);
        alamat = page.getByPlaceholder("Masukkan Alamat");
        petaLokasi = page.getByPlaceholder("Masukkan peta lokasi");
        simpanButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Simpan"));
        pekerjaanActive = page.locator("(//*[@data-testid='search-checkbox-dropdown'])[1]//*[@class='search-checkbox__checkbox bg-c-checkbox bg-c-checkbox--checked']");
        religionActive = page.locator("(//*[@data-testid='search-checkbox-dropdown'])[2]//*[@class='search-checkbox__checkbox bg-c-checkbox bg-c-checkbox--checked']");

        penanggungJawabSection = page.locator("#singgahsini-info");
        bseName = page.locator(".bg-c-list-item__description").nth(6);
        bdName = page.locator(".bg-c-list-item__description").nth(7);
        asName = page.locator(".bg-c-list-item__description").nth(8);
        hospiName = page.locator(".bg-c-list-item__description").nth(9);
        editButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Edit"));

        bseDropdown = page.locator(".bg-c-select__trigger").nth(0);
        bdDropdown = page.locator(".bg-c-select__trigger").nth(1);
        asDropdown = page.locator(".bg-c-select__trigger").nth(2);
        hospiDropdown = page.locator(".bg-c-select__trigger").nth(3);
        dropdownOptions = page.locator(".bg-c-dropdown__menu-item-content");
        confirmSimpanButton = page.getByRole(AriaRole.DIALOG).getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Simpan"));
    }

    /**
     * Assert Profil Property in Detail Property
     * @param id
     * @param nama
     * @param produk
     * @param tipe
     * @param pekerjaan
     * @param agama
     * @param alamat
     * @param map
     */
    public void assertProfilProperty(String id, String nama, String produk, String tipe, String pekerjaan, String agama, String alamat, String map) {
        assertThat(profilProperty.nth(0)).hasText(id);
        assertThat(profilProperty.nth(1)).hasText(nama);
        assertThat(profilProperty.nth(2)).hasText(produk);
        assertThat(profilProperty.nth(3)).hasText(tipe);
        assertThat(profilProperty.nth(4)).hasText(pekerjaan);
        assertThat(profilProperty.nth(5)).hasText(agama);
        assertThat(profilProperty.nth(6)).hasText(alamat);
        assertThat(maps).hasAttribute("href",map);
    }

    /**
     * Edit profil property
     * @param name
     * @param occupation
     * @param religion
     * @param address
     * @param location
     */
    public void editProfilProperty(String name, String occupation, String religion, String address, String location) {
        String[] work = occupation.split("\\s*,\\s*");
        String[] agama = religion.split("\\s*,\\s*");

        ubahProfilButton.click();
        propertyName.fill(name);

        //uncheck all active pekerjaan
        pekerjaanDropdown.click();
        while (pekerjaanActive.first().isVisible()){
            pekerjaanActive.first().click();
        }
        //check pekerjaan based data given
        for (String p: work) {
            pekerjaan = page.getByText(p);
            pekerjaan.click();
        }

        //uncheck all active religion
        religionDropdown.click();
        while (religionActive.first().isVisible()){
            religionActive.first().click();
        }
        //check agama based on data given
        for (String a: agama) {
            this.religion = page.getByText(a);
            this.religion.click();
        }
        religionDropdown.click();

        alamat.fill(address);
        petaLokasi.fill(location);
        simpanButton.click();
    }

    /**
     * scroll into view section penanggung jawab
     */
    public void viewSectionPenanggungJawab() {
        penanggungJawabSection.scrollIntoViewIfNeeded();
    }

    /**
     * Assert penanggung jawab in Detail property
     * @param bse
     * @param bd
     * @param as
     * @param hospi
     */
    public void assertPenanggungJawab(String bse, String bd, String as, String hospi) {
        assertThat(bseName).hasText(bse);
        assertThat(bdName).hasText(bd);
        assertThat(asName).hasText(as);
        assertThat(hospiName).hasText(hospi);
    }

    /**
     * Edit penanggung jawab
     * @param bse
     * @param bd
     * @param as
     * @param hospi
     */
    public void editPenanggungJawab(String bse, String bd, String as, String hospi) {
        editButton.click();
        //edit BSE
        bseDropdown.click();
        dropdownOptions.filter(new Locator.FilterOptions().setHasText(bse)).click();

        //edit BD
        bdDropdown.click();
        dropdownOptions.filter(new Locator.FilterOptions().setHasText(bd)).click();

        //edit AS
        asDropdown.click();
        dropdownOptions.filter(new Locator.FilterOptions().setHasText(as)).click();

        //edit Hospitality
        hospiDropdown.click();
        dropdownOptions.filter(new Locator.FilterOptions().setHasText(hospi)).click();

        simpanButton.click();
        confirmSimpanButton.click();
    }
}
