package pageobject.pms.homepage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import utilities.PlaywrightHelpers;

import java.util.regex.Pattern;

public class DetailKosPO {
    private Page page;
    PlaywrightHelpers playwright;

    private Locator detailKosTab;
    private Locator ubahDataPropertyButton;
    private Locator lokasiStrategisField;
    private Locator tambahLokasiStrategisButton;
    private Locator simpanButton;
    private Locator confirmSimpanButton;
    private Locator confirmDeleteButton;
    private Locator lokasiStrategisExpandButton;
    private Locator lokasiStrategisList;
    private Locator deleteLokasiStrategisButton;
    private Locator emptyLokasiStrategisText;
    private Locator errorMessageLokasiStrategis;

    public DetailKosPO(Page page){
        this.page = page;
        playwright = new PlaywrightHelpers(page);

        detailKosTab = page.locator("a[href='#detailKos']");
        ubahDataPropertyButton = page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Ubah").setExact(true)).first();
        lokasiStrategisField = page.getByPlaceholder("Lokasi Strategis");
        tambahLokasiStrategisButton = page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("+ Tambah Lokasi Strategis").setExact(true));
        simpanButton = page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Simpan").setExact(true));
        confirmSimpanButton = page.locator("button").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Simpan$")));
        confirmDeleteButton = page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Hapus").setExact(true));
        lokasiStrategisExpandButton = page.getByText("Lokasi Strategis");
        deleteLokasiStrategisButton = page.locator(".bg-c-button--icon-only-md");
        emptyLokasiStrategisText = page.locator("details[open='open'] div").last();
        errorMessageLokasiStrategis = page.locator(".bg-c-field__message");
    }

    /**
     * Click Detail Kos Tab
     */
    public void clickDetailKosTab() {
        playwright.clickOn(detailKosTab);
    }

    /**
     * Click Ubah Data Property
     */
    public void clickUbahDataProperty() {
        playwright.clickOn(ubahDataPropertyButton);
    }

    /**
     * Fill Lokasi Strategis
     * @param i index
     * @param lokasi lokasi strategis
     */
    public void setLokasiStrategis(int i, String lokasi) {
        playwright.pageScrollUntilElementIsVisible(lokasiStrategisField.nth(i));
        playwright.fill(lokasiStrategisField.nth(i),lokasi);
    }

    /**
     * Click Tambah Lokasi Strategis
     */
    public void tambahLokasiStrategis() {
        playwright.clickOn(tambahLokasiStrategisButton);
    }

    /**
     * tambah lokasi strategis until reach total
     * @param total number of total lokasi strategis
     */
    public void tambahLokasiStrategis(int total){
        while (lokasiStrategisField.count() < total){
            playwright.clickOn(tambahLokasiStrategisButton);
        }
    }

    /**
     * Click Simpan in Ubah Property
     */
    public void submitDataProperty() {
        playwright.waitFor(simpanButton,3000.0);
        playwright.clickOn(simpanButton);
        playwright.clickOn(confirmSimpanButton);
    }

    /**
     * redirect to detail kos property
     * @param propID property ID
     */
    public void redirectToDetailKos(String propID) {
        playwright.navigateTo("https://sini-jambu.kerupux.com/property-detail/"+propID+"/kos",5000.0, LoadState.LOAD);
    }

    /**
     * expand Lokasi Strategis
     */
    public void expandLokasiStrategis() {
        playwright.pageScrollUntilElementIsVisible(lokasiStrategisExpandButton);
        playwright.clickOn(lokasiStrategisExpandButton);
    }

    /**
     * get Lokasi strategis text
     * @param i index
     * @return String
     */
    public String getLokasiStrategis(int i) {
        lokasiStrategisList = page.locator("details[open='open'] p").nth(i);
        return playwright.getText(lokasiStrategisList);
    }

    /**
     * Assert tambah lokasi strategis button disable
     * @return boolean
     */
    public boolean isTambahLokasiStrategisButtonDisable() {
        return playwright.isButtonDisable(tambahLokasiStrategisButton);
    }

    /**
     * delete lokasi strategis
     * @param i index
     */
    public void deleteLokasiStrategis(int i) {
        playwright.clickOn(deleteLokasiStrategisButton.nth(i));
        playwright.clickOn(confirmDeleteButton);
    }

    /**
     * check is button disable
     * @return boolean
     */
    public boolean isDeleteButtonDisable() {
        return playwright.isButtonDisable(deleteLokasiStrategisButton);
    }

    /**
     * clear lokasi strategis field
     * @param i index
     */
    public void clearTextLokasiStrategis(int i) {
        playwright.clearText(lokasiStrategisField.nth(i));
    }

    /**
     * Get Empty Lokasi Strategis Text
     * @return String
     */
    public String getEmptyLokasiStrategis() {
        return playwright.getText(emptyLokasiStrategisText);
    }

    /**
     * get Error message
     * @return String
     */
    public String getErrorMessageLokasiStrategis() {
        playwright.pageScrollInView(errorMessageLokasiStrategis);
        return playwright.getText(errorMessageLokasiStrategis);
    }
}
