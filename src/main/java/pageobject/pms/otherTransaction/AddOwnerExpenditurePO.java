package pageobject.pms.otherTransaction;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;

public class AddOwnerExpenditurePO {

    private Page page;

    Locator tambahDataButton;
    Locator tipePengajuanCashOutDropdown;
    Locator tipeCashOut;
    Locator propertyNameInputText;
    Locator propertyNameSuggestion;
    Locator kategoriPengeluaranDropdown;
    Locator kategoriPengeluaran;
    Locator namaPengeluaran;
    Locator kuantitas;
    Locator nominalPengeluaran;
    Locator statusPersediaanDropdown;
    Locator statusPersediaan;
    Locator jenisProdukDropdown;
    Locator jenisProduk;
    Locator tambahPengeluaranButton;
    Locator uploadButton;
    public AddOwnerExpenditurePO(Page page) {
        this.page = page;

        tambahDataButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tambah Data"));
        tipePengajuanCashOutDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih tipe pengajuan cash-out"));
        propertyNameInputText = page.getByPlaceholder("Pilih properti");
        propertyNameSuggestion = page.locator("a[role='button']");
        kategoriPengeluaranDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih kategori pengeluaran"));
        statusPersediaanDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih status persediaan"));
        jenisProdukDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih jenis produk"));
        tambahPengeluaranButton = page.getByTestId("add-expense");
        uploadButton = page.locator("input[type='file']");
    }

    public void clickTambahData() {
        tambahDataButton.click();
    }

    public void chooseCashOutType(String type) {
        tipeCashOut = page.locator("a").filter(new Locator.FilterOptions().setHasText(type));
        tipePengajuanCashOutDropdown.click();
        tipeCashOut.click();
    }

    public void selectProperty(String name) {
        propertyNameInputText.click();
        propertyNameInputText.fill(name);
        propertyNameSuggestion.waitFor();
        propertyNameSuggestion.first().click();
    }

    public void setKategoriPengeluaran(String category, String no) {
        kategoriPengeluaran = page.locator("a").filter(new Locator.FilterOptions().setHasText(category));
        kategoriPengeluaranDropdown.click();
        kategoriPengeluaran.nth(Integer.parseInt(no)-1).click();

    }

    public void setNamaPengeluaran(String name, String no) {
        namaPengeluaran = page.getByTestId("expense-name-"+(Integer.parseInt(no)-1)+"");
        namaPengeluaran.fill(name);
    }

    public void setKuantitas(String quantity, String no) {
        kuantitas = page.getByTestId("expense-qty-"+(Integer.parseInt(no)-1)+"");
        kuantitas.fill(quantity);
    }

    public void setNominalPengeluaran(String amount, String no) {
        nominalPengeluaran = page.getByTestId("input-currency-masking").nth(Integer.parseInt(no)-1);
        nominalPengeluaran.focus();
        nominalPengeluaran.fill(amount);
    }

    public void setStatusPersediaan(String status, String no) {
        statusPersediaan = page.locator("//*[@data-testid='expense-stock-status-"+(Integer.parseInt(no)-1)+"']/child::*//div[normalize-space()='"+status+"']");
        statusPersediaanDropdown.click();
        statusPersediaan.click();
    }

    public void setJenisProduk(String product, String no) {
        jenisProduk = page.locator("a").filter(new Locator.FilterOptions().setHasText(product));
        jenisProdukDropdown.scrollIntoViewIfNeeded();
        jenisProdukDropdown.click();
        jenisProduk.nth(Integer.parseInt(no)-1).click();
    }

    public void addMorePengeluaran() {
        tambahPengeluaranButton.click();
    }


    public void uploadAttachment(String fileType) {
        switch (fileType){
            case "jpg":
                uploadButton.setInputFiles(Paths.get("src/main/resources/file/pdf example.pdf"));
                break;
            default:
                System.out.println("File Type not Supported yet");
        }
    }
}
