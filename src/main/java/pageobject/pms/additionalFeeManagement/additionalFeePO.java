package pageobject.pms.additionalFeeManagement;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class additionalFeePO {
    private Page page;
    PlaywrightHelpers playwright;

    private Locator idBiayaText;
    private Locator namaBiaya;
    private Locator tipePembayaran;
    private Locator satuanBiaya;
    private Locator waktuPenentuanHarga;
    private Locator penyewaBisaPilihMandiri;
    private Locator fasePenyewaPilihMandiri;
    private Locator actionButton;
    private Locator hapusButton;
    private Locator nextButton;
    private Locator lastPageButton;

    public additionalFeePO(Page page) {
        this.page = page;
        playwright = new PlaywrightHelpers(page);

        idBiayaText = page.locator("tr td:nth-of-type(1)");
        namaBiaya = page.locator("tr td:nth-of-type(2)");
        tipePembayaran = page.locator("tr td:nth-of-type(3) div");
        satuanBiaya = page.locator("tr td:nth-of-type(4) span:nth-child(2)");
        waktuPenentuanHarga = page.locator("tr td:nth-of-type(5) div");
        penyewaBisaPilihMandiri = page.locator("tr td:nth-of-type(6) div");
        fasePenyewaPilihMandiri = page.locator("tr td:nth-of-type(6) span");
        actionButton = page.getByTestId("table-action-trigger");
        hapusButton = page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Hapus"));
        nextButton = page.locator(".bg-c-button--icon-only-sm").last();
        lastPageButton = page.getByTestId("additionalFeePagination").getByRole(AriaRole.BUTTON).nth(5);
    }

    /**
     * Get nama biaya
     * @param i index
     * @return String
     */
    public String getNamaBiaya(int i) {
        return playwright.getText(namaBiaya.nth(i));
    }

    /**
     * Get tipe pembayaran biaya
     * @param i index
     * @return String
     */
    public String getTipePembayaranBiaya(int i) {
        return playwright.getText(tipePembayaran.nth(i));
    }

    /**
     * Get satuan biaya
     * @param i index
     * @return String
     */
    public String getSatuanBiaya(int i) {
        return playwright.getText(satuanBiaya.nth(i));
    }

    /**
     * Get waktu penentuan harga
     * @param i index
     * @return String
     */
    public String getWaktuPenentuanHarga(int i) {
        return playwright.getText(waktuPenentuanHarga.nth(i));
    }

    /**
     * Get penyewa bisa pilih mandiri
     * @param i index
     * @return String
     */
    public String getPenyewaBisaPilihMandiri(int i) {
        return playwright.getText(penyewaBisaPilihMandiri.nth(i));
    }

    /**
     * Get fase penyewa bisa pilih mandiri
     * @param i index
     * @return String
     */
    public String getFasePenyewaPilihMandiri(int i) {
        return playwright.getText(fasePenyewaPilihMandiri.nth(i));
    }

    /**
     * Delete additional fee
     * @param name biaya tambahan name
     */
    public void deleteAdditionalFee(String name) {
        for (int i=0;i< namaBiaya.count();i++){
            if (playwright.getText(namaBiaya.nth(i)).equalsIgnoreCase(name)){
                playwright.clickOn(actionButton.nth(i));
                playwright.waitFor(hapusButton);
                playwright.clickOn(hapusButton);
                playwright.clickOn(hapusButton);
            }
        }
    }

    /**
     * Check tambahan biaya in list
     * @param name biaya tambahan name
     * @return boolean
     */
    public boolean isBiayaTambahanExist(String name) {
        boolean result = false;
        int page = 1;
        int lastPage = Integer.parseInt(playwright.getText(lastPageButton));

        playwright.reloadPage();
        playwright.waitTillPageLoaded();

        do{
            //check in page n, if there is biaya tambahan {name}
            for (int i = 0; i < namaBiaya.count(); i++) {
                if (namaBiaya.nth(i).textContent().trim().equalsIgnoreCase(name)) {
                    result = true;
                    System.out.println("Found biaya tambahan in page "+page+" row "+(i+1));
                    break;
                }
            }
            if (result == false) {
                if (page<lastPage) {
                    playwright.clickOn(nextButton);
                }
            } else {
                break;
            }
            page++;
        }while (page<=lastPage);

        return result;
    }

    /**
     * Assert Tipe Pembayaran CSS
     * @param property css property
     * @param value value css property
     */
    public void assertTipePembayaranCSS(String property, String value) {
        playwright.assertHaveCss(tipePembayaran.first(),property,value);
    }

    /**
     * Assert Tipe Pembayaran color
     * @param type tipe pembayaran name
     * @param property css property
     * @param value css value
     */
    public void assertTipePembayaranCSS(String type,String property, String value) {
        playwright.assertHaveCss(tipePembayaran.filter(new Locator.FilterOptions().setHasText(type)).first(),property,value);
    }

    /**
     * Assert Waktu Penentuan Harga CSS
     * @param property css properties
     * @param value value css property
     */
    public void assertWaktuPenentuanHargaCSS(String property, String value) {
        playwright.assertHaveCss(waktuPenentuanHarga.first(),property,value);
    }

    /**
     * Assert waktu penentuan harga color
     * @param type waktu penentuan harga name
     * @param property css properties
     * @param value css value
     */
    public void assertWaktuPenentuanHargaCSS(String type,String property, String value) {
        playwright.assertHaveCss(waktuPenentuanHarga.filter(new Locator.FilterOptions().setHasText(type)).first(),property,value);
    }

    /**
     * Assert Penyewa Pilih Mandiri CSS
     * @param property css property
     * @param value value css property
     */
    public void assertPenyewaPilihMandiriCSS(String property, String value) {
        playwright.assertHaveCss(penyewaBisaPilihMandiri.first(),property,value);
    }

    /**
     * Assert penyewa pilih mandiri color
     * @param type penyewa pilih mandiri name
     * @param property css properties
     * @param value css value
     */
    public void assertPenyewaPilihMandiriCSS(String type,String property, String value) {
        playwright.assertHaveCss(penyewaBisaPilihMandiri.filter(new Locator.FilterOptions().setHasText(type)).first(),property,value);
    }

    /**
     * count master data list displayed
     * @return integer
     */
    public Integer countMasterDataList() {
        return playwright.countLocator(namaBiaya);
    }

    /**
     * Get ID
     * @return String
     */
    public String getPrefixID(int i) {
        return playwright.getText(idBiayaText.nth(i)).substring(0,2);
    }
}
