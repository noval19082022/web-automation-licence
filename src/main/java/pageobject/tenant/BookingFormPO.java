package pageobject.tenant;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

import java.nio.file.Paths;

public class BookingFormPO {
    Page page;
    PlaywrightHelpers playwright;
    Locator ajukanSewaButton;
    Locator bookingConfirmationCheckmark;
    Locator kirimPengajuanKePemilikButton;
    Locator lihatSelengkapnyaWaitingConfirmationTextLink;
    Locator batalkanPengajuanSewaButton;
    Locator cancelReasonButton;
    Locator confirmCancelButton;
    Locator successCancel;
    Locator bookingKamuDibatalkan;
    Locator okCancelButton;
    Locator rentDurationIncreaseButton;
    Locator ubahButton;
    Locator selectPayWithDP;
    Locator simpanButton;
    Locator closeBtn;
    Locator uploadDoc;
    Locator alertTextAfterClick;
    Locator tungguKonfirmasiPemilik;
    Locator tncBookingRegulerLink;
    Locator tncBookingSinggahsiniLink;
    Locator tncBookingContentText;
    Locator okPahamButton;
    Locator filterButton;
    Locator needConfirmation;
    Locator seeCompleteBtn;
    Locator cancelBookingBtn;
    Locator yesCancelBookingBtn;
    Locator pengajuanSewaText;
    Locator chatPemilikButton;
    Locator viewRecommendationKos;
    Locator roomLimitAlert;
    Locator roomLimitAlertText;
    Locator ubahProfileButton;
    Locator pekerjaanDropdown;
    Locator instansiDropdown;
    Locator simpanProfileButton;
    Locator pekerjaanBelumTerisiText;
    Locator instansiDropdownButton;
    Locator instansiSearchInput;
    Locator inputCatatanTambahanField;
    Locator summaryBookingFormText;
    Locator viewPengajuanStatusLink;
    Locator deskriptionDiriText;
    Locator simpanBtn;
    Locator tambahBarangButton;
    Locator ubahFasilitasButton;

    public BookingFormPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.ajukanSewaButton = playwright.getButtonBySetName("Ajukan Sewa", true);
        this.bookingConfirmationCheckmark = page.getByTestId("booking-confirmationModal").locator("span").filter(new Locator.FilterOptions().setHasText("checkmark"));
        this.kirimPengajuanKePemilikButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Kirim pengajuan ke pemilik"));
        this.lihatSelengkapnyaWaitingConfirmationTextLink = page.locator("//*[@class='--waiting']/parent::*/following-sibling::button");
        this.batalkanPengajuanSewaButton = page.getByTestId("detailBookingCardCancel_btn");
        this.confirmCancelButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ya, Batalkan"));
        this.successCancel = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Booking Anda berhasil dibatalkan"));
        bookingKamuDibatalkan = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Booking Kamu Dibatalkan"));
        this.okCancelButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ok").setExact(true));
        this.cancelReasonButton = page.locator("label").filter(new Locator.FilterOptions().setHasText("Berubah pikiran/ada rencana lain")).locator("span");
        this.rentDurationIncreaseButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("add-plus").setExact(true));
        this.ubahButton = page.locator(".booking-payment-option .booking-form-section__action .bg-c-text");
        this.selectPayWithDP = page.locator("[for='bookingFormRadio-paymentSelect-0'] > .bg-c-radio__icon");
        this.simpanButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Simpan"));
        this.closeBtn = page.getByRole(AriaRole.BUTTON).filter(new Locator.FilterOptions().setHasText("close"));
        this.uploadDoc = page.locator("div").getByTestId("bookingDocumentUploader").first().locator("//input[@type='file']");
        this.alertTextAfterClick = page.getByText("Masukkan nama pekerjaan untuk memproses pengajuan sewa.");
        tungguKonfirmasiPemilik = page.getByText("Tunggu Konfirmasi");
        this.tncBookingRegulerLink = page.locator("a.bg-c-link--medium:nth-child(1)");
        this.tncBookingSinggahsiniLink = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Syarat dan Ketentuan Tinggal di Singgahsini, Apik, & Kos Pilihan"));
        this.tncBookingContentText = page.getByTestId("bookingTncModal-title");
        this.okPahamButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Oke Paham"));
        this.filterButton = page.locator(".filter-item-mobile:first-child span");
        this.needConfirmation = page.locator("li:nth-child(2) button");
        this.seeCompleteBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lihat selengkapnyachevron-down"));
        this.cancelBookingBtn = page.getByTestId("detailBookingCardCancel_btn");
        this.yesCancelBookingBtn = page.locator("//*[@id='bookingModalCancel' and @style]//*[contains(text(), 'Ya, Batalkan')]");
        this.pengajuanSewaText = page.locator("//*[@id='bookingContainer']");
        this.chatPemilikButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("chat Chat Pemilik")).first();
        this.viewRecommendationKos = page.locator("//button[normalize-space()='Lihat Rekomendasi Kos']");
        roomLimitAlert = page.getByTestId("bookingRequestForm-roomScarcityPrompt");
        roomLimitAlertText = page.locator("div[data-testid='bookingRequestForm-roomScarcityPrompt'] p");
        this.ubahProfileButton = page.locator(".booking-form-section__head").filter(new Locator.FilterOptions().setHasText("Informasi penyewa")).getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Ubah"));
        this.pekerjaanDropdown = page.getByTestId("inputProfession-jobOptions");
        this.instansiDropdown = page.getByTestId("inputProfession-workplaceOption");
        this.simpanProfileButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Simpan").setExact(true));
        this.pekerjaanBelumTerisiText = page.getByText("Pekerjaan belum terisi");
        this.instansiDropdownButton = page.getByRole(AriaRole.BUTTON).filter(new Locator.FilterOptions().setHasText("Contoh: Institut Teknologi Bandung"));
        this.instansiSearchInput = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search"));
        this.inputCatatanTambahanField = page.locator("//*[@id='bookingFormTenantNote-textArea']");
        this.summaryBookingFormText = page.getByTestId("booking-request-form__summary").getByText("Total pembayaran pertama belum termasuk biaya yang mungkin pemilik akan terapkan");
        this.viewPengajuanStatusLink = page.locator("//*[@class=\"booking-success__cta\"]/button");
        this.deskriptionDiriText = page.locator("//*[@class=\"booking-item --tenant-description\"]/div").last();
        this.simpanBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Simpan"));
        this.tambahBarangButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("add-plus Pilih tambahan barang/fasilitas"));
        this.ubahFasilitasButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("edit Ubah tambahan barang/fasilitas"));
    }

    /**
     * Click on ajukan sewa button on booking form
     */
    public void clickOnAjukanSewaButton() {
        playwright.clickOn(ajukanSewaButton);
    }

    /**
     * Click on booking confirmation checkmark
     */
    public void clickOnBookingConfirmationCheckmark() {
        playwright.waitTillLocatorIsVisible(bookingConfirmationCheckmark, 30000.0);
        playwright.clickOn(bookingConfirmationCheckmark);
    }

    /**
     * Handle occupation/instansi validation and click booking confirmation checkmark
     * If validation alert appears, fills in required fields (Mahasiswa + Universitas Diponegoro),
     * then clicks Ajukan Sewa again before proceeding to click the confirmation checkmark
     */
    public void clickOnBookingConfirmationCheckmarkWithValidation() {
        if (isOccupationAlertVisible()) {
            clickUbahProfileButton();
            selectPekerjaan("Mahasiswa"); //hardcoded for data preparation only
            selectInstansi("Universitas Diponegoro"); //hardcoded for data preparation only
            clickSimpanProfileButton();
            clickOnAjukanSewaButton();
        }
        clickOnBookingConfirmationCheckmark();
    }

    /**
     * click on kirim pengajuan ke pemilik button
     *
     * @return SuccessBookingPO class;
     */
    public SuccessBookingPO clickOnKirimPengajuanKePemilik() {
        kirimPengajuanKePemilikButton.click();
        return new SuccessBookingPO(page);
    }

    /**
     * add jumlah penyewa
     *
     * @param penyewa
     */
    public void addJumlahPenyewa(int penyewa) {
        for (int i = 0; i < penyewa; i++) {
            page.getByTestId("bookingFormTotalRenter-stepper").getByRole(AriaRole.BUTTON).nth(1).click();
        }
    }

    /**
     * @param checkMark example checkmark Membawa anak
     */
    public void checkMark(String checkMark) {
        page.locator("label").filter(new Locator.FilterOptions().setHasText("checkmark " + checkMark)).locator("span").click();
    }

    /**
     * Upload berkas KTP, Foto diri KTP, KK, buku nikah
     */
    public void uploadBerkasBooking() {
        PlaywrightHelpers playwright = new PlaywrightHelpers(page);
        do {
            String projectpath = System.getProperty("user.dir");

            if (closeBtn.first().isVisible()) {
                closeBtn.first().click();
            }

            if (uploadDoc != null) {
                uploadDoc.setInputFiles(Paths.get(projectpath + "/src/main/resources/images/upload.jpg"));
                playwright.hardWait(5_000);
            }

            if (page.getByText("Pada saat masuk kos, mohon siapkan kartu identitas asli untuk verifikasi").isVisible()) {
                break;
            }

        } while (page.getByText("Kamu belum upload dokumen wajib yang dibutuhkan pemilik kos.").isVisible());
    }

    /**
     * Check visibility of booking kamu dibatalkan button
     * @return visible true otherwise false
     */
    public boolean isBookingKamuDibatalkanVisible() {
        return bookingKamuDibatalkan.isVisible();
    }

    /**
     * click on Lihat Selengkapnya
     * click on Batalkan Booking
     * click on cancel reason button
     * click on Ya Batalkan button
     */
    public void cancelBooking() {
        var bookingNeedConfirmation = 0;
        if(tungguKonfirmasiPemilik.first().isVisible()){
            bookingNeedConfirmation = playwright.getLocators(tungguKonfirmasiPemilik).size();
            for (int i = 0; i < bookingNeedConfirmation; i++) {
                playwright.clickOn(lihatSelengkapnyaWaitingConfirmationTextLink.first());
                playwright.clickOn(batalkanPengajuanSewaButton.first());
                playwright.clickOn(cancelReasonButton);
                playwright.clickOn(confirmCancelButton);
                if (waitUntilSuccessCancelHeadingVisible()) {
                    closeCancelPopUp();
                } else if (isBookingKamuDibatalkanVisible()){
                    playwright.clickOn(closeBtn);
                    page.reload();
                }
            }
        }
    }

    /**
     * click on Lihat Selengkapnya
     * click on Batalkan Booking
     * click on cancel reason button
     * click on Ya Batalkan button
     */
    public void cancelBookingForCheckRecommendation() {
        var bookingNeedConfirmation = 0;
        if(tungguKonfirmasiPemilik.first().isVisible()) {
            bookingNeedConfirmation = playwright.getLocators(tungguKonfirmasiPemilik).size();
            for (int i = 0; i < bookingNeedConfirmation; i++) {
                playwright.clickOn(lihatSelengkapnyaWaitingConfirmationTextLink.first());
                playwright.clickOn(batalkanPengajuanSewaButton.first());
                playwright.clickOn(cancelReasonButton);
                playwright.clickOn(confirmCancelButton);
                playwright.waitTillLocatorIsVisible(viewRecommendationKos);
                if (playwright.waitTillLocatorIsVisible(viewRecommendationKos)) {
                    playwright.clickOn(viewRecommendationKos);
                } else {
                    playwright.clickOnTextButton("Ok");
                }
            }
        }
    }

    /**
     * cancel booking with select reason
     */
    public void cancelBookingWithReason(String reason) {
            filterButton.click();
            needConfirmation.waitFor();
            needConfirmation.click();
            playwright.hardWait(2000);
            if (seeCompleteBtn.isVisible()) {
                seeCompleteBtn.click();
                cancelBookingBtn.click();
                String selector = "//*[@class='radio success']/label[contains(.,'" + reason + "')]";
                ElementHandle element = page.querySelector(selector);
                element.click();
                yesCancelBookingBtn.click();
        }
    }

    /**
     * Wait until terminated is process is finished
     *
     * @return
     */
    public boolean waitUntilSuccessCancelHeadingVisible() {
        return successCancel.isVisible();
    }

    /**
     * Get success cancel booking pop-up text
     *
     * @return String data type
     */
    public String getSuccessCancelText() {
        return successCancel.textContent();
    }

    /**
     * Close booking pop-up
     */
    public void closeCancelPopUp() {
        if (okCancelButton.isVisible()) {
            okCancelButton.click();
        }
    }

    /**
     * Increase Rent Duration
     *
     * @throws InterruptedException
     */
    public void increaseRateDuration() {
        if (rentDurationIncreaseButton.isVisible()) {
            rentDurationIncreaseButton.click();
        }
    }

    /**
     * Click on ubah button on booking form
     */
    public void clickUbahButton() {
        ubahButton.click();
    }

    /**
     * Click on DP button on booking form
     */
    public void selectPayWithDP() {
        selectPayWithDP.click();
    }

    /**
     * Click on Simpan button on booking form
     */
    public void clickSimpanButton() {
        simpanButton.click();
    }

    /**
     * get error alert on jobs after click
     * @return String Masukkan pekerjaan untuk memproses pengajuan sewa.
     */
    public String getAlertJobsTextAfterClick() {
        return alertTextAfterClick.textContent().trim();
    }

    /**
     * Check if occupation/instansi needs to be filled by checking if "Pekerjaan belum terisi" text is visible
     * @return true if pekerjaan is not filled (shows "Pekerjaan belum terisi"), false otherwise
     */
    public boolean isOccupationAlertVisible() {
        return playwright.isLocatorVisibleAfterLoad(pekerjaanBelumTerisiText, 2000.0);
    }

    /**
     * Click on Ubah button in Informasi penyewa section to edit profile
     */
    public void clickUbahProfileButton() {
        playwright.clickOn(ubahProfileButton);
    }

    /**
     * Select pekerjaan using radio button
     * @param pekerjaan occupation name (e.g., "Mahasiswa", "Karyawan", "Lainnya")
     */
    public void selectPekerjaan(String pekerjaan) {
        Locator pekerjaanRadio = page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName(pekerjaan));
        playwright.clickOn(pekerjaanRadio);
    }

    /**
     * Select university/instansi from combobox dropdown
     * @param instansi university or institution name (e.g., "Universitas Diponegoro")
     */
    public void selectInstansi(String instansi) {
        // Click the dropdown button to open university list
        playwright.clickOn(instansiDropdownButton);

        // Fill the search input to filter universities
        playwright.fill(instansiSearchInput, instansi);

        // Wait a moment for the filtered results to appear
        playwright.hardWait(500);

        // Click the university from the filtered list
        // Use locator("a") to target the visible clickable element, not the hidden <option>
        Locator universityOption = page.locator("a").filter(new Locator.FilterOptions().setHasText(instansi)).first();
        playwright.clickOn(universityOption);
    }

    /**
     * Click Simpan button after editing profile in booking form
     */
    public void clickSimpanProfileButton() {
        playwright.clickOn(simpanBtn);
    }

    /**
     * get TnC booking reguler text
     * @return String
     */
    public String getTnCBookingTextReguler() {
        return playwright.getText(tncBookingRegulerLink);
    }

    /**
     * get TnC booking singgahsini text
     * @return String
     */
    public String getTnCBookingTextSinggahsini() {
        return playwright.getText(tncBookingSinggahsiniLink);
    }

    /**
     * click on TnC booking reguler
     * on ajukan sewa pup up booking form
     */
    public void clickOnTnCBookingReguler() {
        tncBookingRegulerLink.waitFor();
        tncBookingRegulerLink.click();
    }

    /**
     * click on TnC booking singgahsini
     * on ajukan sewa pup up booking form
     */
    public void clickTnCBookingSinggahsini() {
        tncBookingSinggahsiniLink.click();
    }

    /**
     * get header booking content text
     * @return String
     */
    public String getTnCBookingContentText() {
        return playwright.getText(tncBookingContentText);
    }

    /**
     * click "Ok Paham" Button on TnC booking
     */
    public void clickOkPahamButton() {
        okPahamButton.click();
    }

    /**
     * Check the visibility of booking form
     * @return String
     */
    public boolean getPengajuanSewatext() {
        return pengajuanSewaText.isVisible();
    }

    /**
     * Check visibility catatan tambahan section
     * @param text
     * @return Catatan Tambahan
     */
    public Boolean getCatatanTambahan(String text){
        Locator catatanTambahanText = page.getByText(""+text+"");
        return catatanTambahanText.isVisible();
    }

    /**
     * input Catatan tambahan with text
     * @param text
     */
    public void inputCatatanTambahan(String text){
       playwright.pageScrollUsingCoordinate(10000, 1500);
        playwright.clearText(inputCatatanTambahanField);
        playwright.fill(inputCatatanTambahanField, text);
    }

    /**
     * Check visibility allert summary booking
     * @return Text
     */
    public Boolean getSummaryBookingForm(){
        playwright.pageScrollInView(summaryBookingFormText);
        return summaryBookingFormText.isVisible();
    }

    /**
     * click addfee button
     */
    public void clickTambahBarangButton(){
        playwright.hardWait(100);
        if (tambahBarangButton.isVisible()){
            playwright.clickOn(tambahBarangButton);
        }
        else {
            playwright.pageScrollInView(tambahBarangButton);
            playwright.clickOn(tambahBarangButton);
        }
    }

    /**
     * click on ubah fasilitas button
     */
    public void clickUbahFasilitas(){
        playwright.clickOn(ubahFasilitasButton);
    }

    /**
     * click on Addfee List on Biaya tambahan popup
     * @param text example : Parkir Motor
     */
    public void clickAddfeeList(String text){
        playwright.hardWait(100);
        Locator addFeeList = page.locator("//div[@class=\"bg-c-modal__body\"]//p[contains(text(), '"+text+"')]");
        playwright.clickOn(addFeeList);
    }

    /**
     * Click on Lihat pengajuan sewa and chat button on first booking
     */
    public void clickChatPemilikButton(){
        if (viewPengajuanStatusLink.isVisible()){
            playwright.clickOn(viewPengajuanStatusLink);
        }
        else {
            playwright.pageScrollInView(viewPengajuanStatusLink);
            playwright.clickOn(viewPengajuanStatusLink);
        }
        playwright.clickOn(chatPemilikButton);
    }

    /**
     * Get deskripsi diri on riwayat booking
     * @return text
     */
    public String getDeskriptionDiri(){
       return playwright.getText(deskriptionDiriText);
    }

    /**
     * Check visibility room limit alert
     * @return true or false
     */
    public boolean isRoomLimitAlertDisplayed() {
        return playwright.isLocatorVisibleAfterLoad(roomLimitAlert,5000.0);
    }

    /**
     * Get room limit alert text
     * replace "Sisa [1-5] kamar" to "Sisa n kamar"
     * @return String
     */
    public String getRoomLimitAlertText(){
        String originalText = playwright.getText(roomLimitAlertText);
        String text = originalText.replaceAll("(Sisa )\\d+( kamar)", "$1n$2");
        return text;
    }
}
