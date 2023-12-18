package pageobject.pms.additionalFeeManagement;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class additionalFeePO {
    private Page page;
    PlaywrightHelpers playwright;

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

        namaBiaya = page.locator("tr td:nth-of-type(2)");
        tipePembayaran = page.locator("tr td:nth-of-type(3) div");
        satuanBiaya = page.locator("tr td:nth-of-type(4) span:nth-child(2)");
        waktuPenentuanHarga = page.locator("tr td:nth-of-type(5) div");
        penyewaBisaPilihMandiri = page.locator("tr td:nth-of-type(6) div");
        fasePenyewaPilihMandiri = page.locator("tr td:nth-of-type(6) span");
        actionButton = page.locator("tr td:nth-of-type(7)");
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

    public void assertPenyewaPilihMandiriColor(String css, String value) {
        playwright.assertHaveCss(penyewaBisaPilihMandiri.first(),css,value);
    }

    public void assertPenyewaPilihMandiriBgColor(String css, String value) {
        playwright.assertHaveCss(penyewaBisaPilihMandiri.first(),css,value);
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
     * Assert Waktu Penentuan Harga CSS
     * @param property css property
     * @param value value css property
     */
    public void assertWaktuPenentuanHargaCSS(String property, String value) {
        playwright.assertHaveCss(waktuPenentuanHarga.first(),property,value);
    }

    /**
     * Assert Penyewa Pilih Mandiri CSS
     * @param property css property
     * @param value value css property
     */
    public void assertPenyewaPilihMandiriCSS(String property, String value) {
        playwright.assertHaveCss(penyewaBisaPilihMandiri.first(),property,value);
    }
}
