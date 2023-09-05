package pageobject.pms.homepage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class OverviewPO {
    private Page page;
    private PlaywrightHelpers playwright;

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
    Locator bseNameEdit;
    Locator bdNameEdit;
    Locator asNameEdit;
    Locator hospiNameEdit;
    //End Penanggung Jawab Edit

    public OverviewPO(Page page){
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);

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

        playwright.clickOn(ubahProfilButton);
        playwright.fill(propertyName,name);

        //uncheck all active pekerjaan
        playwright.clickOn(pekerjaanDropdown);
        while (pekerjaanActive.first().isVisible()){
            playwright.clickOn(pekerjaanActive.first());
        }
        //check pekerjaan based data given
        for (String p: work) {
            pekerjaan = page.getByText(p);
            playwright.clickOn(pekerjaan);
        }

        //uncheck all active religion
        playwright.clickOn(religionDropdown);
        while (religionActive.first().isVisible()){
            playwright.clickOn(religionActive.first());
        }
        //check agama based on data given
        for (String a: agama) {
            this.religion = page.getByText(a);
            playwright.clickOn(this.religion);
        }
        playwright.clickOn(religionDropdown);

        playwright.fill(alamat,address);
        playwright.fill(petaLokasi,location);
        playwright.clickOn(simpanButton);
    }

    /**
     * scroll into view section penanggung jawab
     */
    public void viewSectionPenanggungJawab() {
        playwright.pageScrollUntilElementIsVisible(penanggungJawabSection);
    }

    /**
     * Edit penanggung jawab
     * @param bse
     * @param bd
     * @param as
     * @param hospi
     */
    public void editPenanggungJawab(String bse, String bd, String as, String hospi) {
        playwright.clickOn(editButton);
        //edit BSE
        playwright.clickOn(bseDropdown);
        bseNameEdit = dropdownOptions.filter(new Locator.FilterOptions().setHasText(bse));
        playwright.clickOn(bseNameEdit);

        //edit BD
        playwright.clickOn(bdDropdown);
        bdNameEdit = dropdownOptions.filter(new Locator.FilterOptions().setHasText(bd));
        playwright.clickOn(bdNameEdit);

        //edit AS
        playwright.clickOn(asDropdown);
        asNameEdit = dropdownOptions.filter(new Locator.FilterOptions().setHasText(as));
        playwright.clickOn(asNameEdit);

        //edit Hospitality
        playwright.clickOn(hospiDropdown);
        hospiNameEdit = dropdownOptions.filter(new Locator.FilterOptions().setHasText(hospi));
        playwright.clickOn(hospiNameEdit);

        playwright.clickOn(simpanButton);
        playwright.clickOn(confirmSimpanButton);
    }

    /**
     * Get ID Property in Profil Property
     * @return id property
     */
    public String getIdProperty() {
        return playwright.getText(profilProperty.nth(0));
    }

    /**
     * Get Nama Property in Profil Property
     * @return nama property
     */
    public String getNamaProperty() {
        return playwright.getText(profilProperty.nth(1));
    }

    /**
     * Get Produk in Profil Property
     * @return produk
     */
    public String getProduk() {
        return playwright.getText(profilProperty.nth(2));
    }

    /**
     * Get Tipe in Profil Property
     * @return Tipe
     */
    public String getTipe() {
        return playwright.getText(profilProperty.nth(3));
    }

    /**
     * Get Pekerjaan in Profil Property
     * @return pekerjaan
     */
    public String getPekerjaan() {
        return playwright.getText(profilProperty.nth(4));
    }

    /**
     * Get Agama in profil property
     * @return agama
     */
    public String getAgama() {
        return playwright.getText(profilProperty.nth(5));
    }

    /**
     * Get Alamat in Profil Property
     * @return alamat
     */
    public String getAlamat() {
        return playwright.getText(profilProperty.nth(6));
    }

    /**
     * Get href in Lihat Lokasi Profil Property
     * @return google map link (href)
     */
    public String getMap() {
        return playwright.getAttributeValue(maps,"href");
    }

    /**
     * Get BSE name in Penanggung Jawab Section
     * @return BSE name
     */
    public String getBseName() {
        return playwright.getText(bseName);
    }

    /**
     * Get BD name in Penanggung Jawab Section
     * @return BD name
     */
    public String getBdName() {
        return playwright.getText(bdName);
    }

    /**
     * Get AS name in Penanggung Jawab Section
     * @return AS name
     */
    public String getAsName() {
        return playwright.getText(asName);
    }

    /**
     * Get Hospitality Name in Penanggung Jawab Section
     * @return Hospitality Name
     */
    public String getHospiName() {
        return playwright.getText(hospiName);
    }
}
