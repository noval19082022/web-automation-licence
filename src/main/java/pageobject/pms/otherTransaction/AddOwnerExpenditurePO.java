package pageobject.pms.otherTransaction;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

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
    Locator noInvoiceField;
    Locator tujuanTransferDropdown;
    Locator searchTujuanTransferField;
    Locator vendorName;
    Locator addOwnerExpenditureButton;
    Locator titlePopUpAddOwnerExpenditure;
    Locator bodyPopUpAddOwnerExpenditure;
    Locator buttonTambahPopUpAddOwnerExpenditure;
    Locator buttonBatalPopUpAddOwnerExpenditure;
    Locator confirmationPopUp;
    Locator toastMessage;
    Locator propertynameSuggestionBox;
    Locator kotaText;
    Locator sisaKontrakText;
    Locator kategoriPengeluaranList;
    Locator deleteAttachment;
    Locator attachmentFileName;
    Locator attachmentErrorMessage;
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
        noInvoiceField = page.getByTestId("cost-invoice-number");
        tujuanTransferDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih tujuan transfer pengeluaran"));
        searchTujuanTransferField =   page.getByPlaceholder("Cari tujuan transfer");
        addOwnerExpenditureButton = page.getByTestId("add-expenditure");
        titlePopUpAddOwnerExpenditure = page.locator("h3.bg-c-modal__body-title");
        bodyPopUpAddOwnerExpenditure = page.locator("p.bg-c-modal__body-description");
        buttonBatalPopUpAddOwnerExpenditure = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Batal"));
        buttonTambahPopUpAddOwnerExpenditure = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tambah").setExact(true));
        confirmationPopUp = page.getByRole(AriaRole.DIALOG).filter(new Locator.FilterOptions().setHasText("Yakin ingin tambahkan data ini? Data yang ditambahkan akan dilanjutkan ke tahap ")).locator("div").first();
        toastMessage = page.locator(".bg-c-toast__content");
        propertynameSuggestionBox = page.locator(".bg-c-searchbar>div").nth(1);
        kotaText = page.locator(".bg-c-field__description").nth(1);
        sisaKontrakText = page.locator(".bg-c-field__description").nth(2);
        kategoriPengeluaranList = page.locator("//*[@data-testid='expense-category-0']//a");
        deleteAttachment = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("delete"));
        attachmentFileName = page.locator("p.bg-c-text--title-5").nth(1);
        attachmentErrorMessage = page.locator(".bg-c-field__message").first();
    }

    /**
     * click Tambah Data
     */
    public void clickTambahData() {
        tambahDataButton.click();
    }

    /**
     * choose cash out type
     * @param type
     */
    public void chooseCashOutType(String type) {
        tipeCashOut = page.locator("a").filter(new Locator.FilterOptions().setHasText(type));
        tipePengajuanCashOutDropdown.click();
        tipeCashOut.click();
    }

    /**
     * search and select property suggestion
     * @param name
     */
    public void selectProperty(String name) {
        propertyNameInputText.click();
        propertyNameInputText.fill(name);
        propertyNameSuggestion.first().waitFor();
        propertyNameSuggestion.first().click();
    }

    /**
     * choose category pengeluaran
     * @param category
     * @param no pengeluaran n
     */
    public void setKategoriPengeluaran(String category, String no) {
        page.mouse().wheel(0,500);
        kategoriPengeluaran = page.locator("a").filter(new Locator.FilterOptions().setHasText(category));
        kategoriPengeluaranDropdown.click();
        kategoriPengeluaran.nth(Integer.parseInt(no)-1).click();

    }

    /**
     * Fill nama pengeluaran field
     * @param name
     * @param no pengeluaran n
     */
    public void setNamaPengeluaran(String name, String no) {
        namaPengeluaran = page.getByTestId("expense-name-"+(Integer.parseInt(no)-1)+"");
        namaPengeluaran.fill(name);
    }

    /**
     * fill kuantitas
     * @param quantity
     * @param no pengeluaran n
     */
    public void setKuantitas(String quantity, String no) {
        kuantitas = page.getByTestId("expense-qty-"+(Integer.parseInt(no)-1)+"");
        kuantitas.scrollIntoViewIfNeeded();
        kuantitas.fill(quantity);
    }

    /**
     * fill nominal pengeluaran
     * @param amount
     * @param no pengeluaran n
     */
    public void setNominalPengeluaran(String amount, String no) {
        nominalPengeluaran = page.getByTestId("input-currency-masking").nth(Integer.parseInt(no)-1);
        nominalPengeluaran.focus();
        nominalPengeluaran.fill(amount);
    }

    /**
     * choose status persediaan
     * @param status (Non Stock. Stock)
     * @param no pengeluaran n
     */
    public void setStatusPersediaan(String status, String no) {
        statusPersediaan = page.locator("//*[@data-testid='expense-stock-status-"+(Integer.parseInt(no)-1)+"']/child::*//div[normalize-space()='"+status+"']");
        statusPersediaanDropdown.click();
        statusPersediaan.click();
    }

    /**
     * choose jenis produk
     * @param product (LSSS, LSAP, SSSP, LMH, PC)
     * @param no pengeluaran n
     */
    public void setJenisProduk(String product, String no) {
        jenisProduk = page.locator("a").filter(new Locator.FilterOptions().setHasText(product));
        jenisProdukDropdown.scrollIntoViewIfNeeded();
        jenisProdukDropdown.click();
        jenisProduk.nth(Integer.parseInt(no)-1).click();
    }

    /**
     * Add pengeluaran
     */
    public void addMorePengeluaran() {
        tambahPengeluaranButton.click();
    }

    /**
     * upload lampiran
     * @param fileType
     */
    public void uploadAttachment(String fileType) {
        switch (fileType){
            case "jpg":
                uploadButton.setInputFiles(Paths.get("src/main/resources/images/ownerExpenditure/ABY06593.jpg"));
                break;
            case "jpeg":
                uploadButton.setInputFiles(Paths.get("src/main/resources/images/ownerExpenditure/ABY05305.jpeg"));
                break;
            case "png":
                uploadButton.setInputFiles(Paths.get("src/main/resources/images/ownerExpenditure/BG_Anniv Mamikos ke7.png"));
                break;
            case "pdf":
                uploadButton.setInputFiles(Paths.get("src/main/resources/file/pdf example.pdf"));
                break;
            case "jpg 8MB":
                uploadButton.setInputFiles(Paths.get("src/main/resources/images/ownerExpenditure/jpg8MB.jpg"));
                break;
            case "pdf 8MB":
                uploadButton.setInputFiles(Paths.get("src/main/resources/file/pdf8MB.pdf"));
                break;
            case "svg":
                uploadButton.setInputFiles(Paths.get("src/main/resources/images/ownerExpenditure/toothwithcrown.svg"));
                break;
            default:
                System.out.println("File Type not Supported yet");
        }
    }

    /**
     * fill no invoice
     * @param invoice invoice number
     */
    public void setNoInvoiceBiaya(String invoice) {
        noInvoiceField.fill(invoice);
    }

    /**
     * choose tujuan transfer
     * @param vendor
     */
    public void setTujuanTransfer(String vendor) {
        vendorName = page.locator("a").filter(new Locator.FilterOptions().setHasText(vendor));

        tujuanTransferDropdown.click();
        searchTujuanTransferField.click();
        searchTujuanTransferField.fill(vendor);
        vendorName.click();
    }

    /**
     * tambah data owner expenditure, but only click on Tambah Data button
     */
    public void submitAddOwnerExpenditure() {
        addOwnerExpenditureButton.scrollIntoViewIfNeeded();
        addOwnerExpenditureButton.click();
    }

    /**
     * Assert confirmation pop up add owner expenditure content
     */
    public void assertConfirmationPopUpAddOwnerExpenditure() {
        assertThat(titlePopUpAddOwnerExpenditure).hasText("Yakin ingin tambahkan data ini?");
        assertThat(bodyPopUpAddOwnerExpenditure).hasText("Data yang ditambahkan akan dilanjutkan ke tahap konfirmasi.");
        assertThat(buttonBatalPopUpAddOwnerExpenditure).isEnabled();
        assertThat(buttonTambahPopUpAddOwnerExpenditure).isEnabled();
    }

    /**
     * close pop up add owner expenditure
     */
    public void cancelAddOwnerExpenditure() {
        buttonBatalPopUpAddOwnerExpenditure.click();
    }

    /**
     * confirm add owner expenditure
     */
    public void confirmAddOwnerExpenditure() {
        buttonTambahPopUpAddOwnerExpenditure.click();
    }

    /**
     * assert confirmation pop up add owner expenditure not visible
     */
    public void assertConfirmationPopUpAddOwnerExpenditureClosed() {
        assertThat(confirmationPopUp).isHidden();
    }

    /**
     * assert message in toast message
     * @param message
     */
    public void assertToastMessage(String message) {
        assertThat(toastMessage).hasText(message);
    }

    /**
     * Only Search property in tambah owner expenditure
     * @param name
     */
    public void searchProperty(String name) {
        propertyNameInputText.click();
        propertyNameInputText.fill(name);
    }

    /**
     * Assert property suggestion are correct
     * @param property expected property name
     */
    public void assertPropertySuggestion(String property) {
        propertyNameSuggestion.first().waitFor();
        assertThat(propertyNameSuggestion.first()).hasText(property);
    }

    /**
     * Assert property name suggestion not appear
     */
    public void assertPropertySuggestionNotAppear() {
        assertThat(propertynameSuggestionBox).not().isVisible();
    }

    /**
     * Assert Kota
     * @param text expected kota
     */
    public void assertKota(String text) {
        assertThat(kotaText).hasText(text);
    }

    /**
     * Assert Sisa Kontrak Kerja Sama
     * @param text expected sisa kontrak kerja sama
     */
    public void assertSisaKontrak(String text) {
        assertThat(sisaKontrakText).hasText(text);
    }

    /**
     * Assert Kota is not "-"
     */
    public void assertKotaNotEmpty() {
        assertThat(kotaText).not().hasText("-");
    }

    /**
     * Assert Sisa Kontrak Kerja Sama is not "-"
     */
    public void assertSisaKontrakNotEmpty() {
        assertThat(sisaKontrakText).not().hasText("-");
    }

    /**
     * Edit serached property
     * @param property property name
     */
    public void editSearchProperty(String property) {
        propertyNameInputText.click();
        propertyNameInputText.clear();
        propertyNameInputText.fill(property);
        propertyNameSuggestion.first().waitFor();
        propertyNameSuggestion.first().click();
    }

    /**
     * Expand kategori pengeluaran
     */
    public void expandKategoriPengeluaran() {
        kategoriPengeluaranDropdown.waitFor();
        kategoriPengeluaranDropdown.scrollIntoViewIfNeeded();
        kategoriPengeluaranDropdown.click();
    }

    /**
     * Assert Kategori Pengeluaran options
     * @param i index
     * @param pengeluaran kategori pengeluaran name
     */
    public void assertKategoriPengeluaranList(int i,String pengeluaran) {
        kategoriPengeluaranList.nth(i).scrollIntoViewIfNeeded();
        assertThat(kategoriPengeluaranList.nth(i)).hasText(pengeluaran);
    }

    /**
     * Assert tambah pengeluaran button disable
     */
    public void assertTambahPengeluaranButtonDisable() {
        assertThat(tambahPengeluaranButton).isDisabled();
    }

    /**
     * Assert tambah pengeluaran button enable
     */
    public void assertTambahPengeluaranButtonEnable() {
        assertThat(tambahPengeluaranButton).isEnabled();
    }

    /**
     * Assert Nama Pengeluaran value
     * @param expected expected nama pengeluaran
     */
    public void assertNamaPengeluaran(String expected) {
        assertThat(namaPengeluaran).hasValue(expected);
    }

    /**
     * Assert Kuantitas Value
     * @param qty kuantitas value
     */
    public void assertKuantitasValue(String qty) {
        if (qty.equalsIgnoreCase("empty")){
            assertThat(kuantitas).hasValue("");
        } else {
            assertThat(kuantitas).hasValue(qty);
        }
    }

    /**
     * delete attachment upload
     */
    public void deleteAttachment() {
        deleteAttachment.waitFor();
        deleteAttachment.click();
    }

    /**
     * Assert file name that succesfully upload
     * @param filename
     */
    public void assertFileName(String filename) {
        attachmentFileName.scrollIntoViewIfNeeded();
        assertThat(attachmentFileName).hasText(filename);
    }

    /**
     * Assert trash icon to delete attachment is visible
     */
    public void assertTrashIconVisible() {
        assertThat(deleteAttachment).isVisible();
    }

    /**
     * Assert error message when upload invalid attachment visible and have correct message
     */
    public void assertAttachmentErrorMessage() {
        assertThat(attachmentErrorMessage).isVisible();
        assertThat(attachmentErrorMessage).hasText("File harus berupa .pdf/.jpg/.jpeg/.png dengan ukuran maksimal 8 MB.");
    }
}
