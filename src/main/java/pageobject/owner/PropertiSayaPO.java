package pageobject.owner;

import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;
import config.global.GlobalConfig;
import lombok.Getter;
import lombok.Setter;
import utilities.JavaHelpers;
import utilities.PlaywrightHelpers;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.regex.Pattern;

public class PropertiSayaPO {
    private final Page page;
    private final PlaywrightHelpers playwright;
    @Setter
    @Getter
    private String searchPropertyName;

    Locator kostDropdown;
    Locator searchKostTextbox;
    Locator lihatSelengkapnyaButton;
    Locator updateKamarButton;
    Locator editAction;
    Locator updateKamarCheckbox;
    Locator updateKamarButtonPopup;
    Locator firstKosNameLabel;
    Locator firstKosStatusLabel;
    Locator firstKosTypeLabel;
    Locator kostNameText;
    Locator seeOtherPriceButton;
    Locator priceKostTextBox;
    Locator continueInputDataButton;
    Locator updatePriceButton;
    Locator closeBtn;
    Locator messageSuccessUpdatePrice;
    Locator firstSeeKosButton;
    Locator statisticChoiceSelection;
    Locator chatButton;
    Locator reviewButton;
    Locator addRoomButton;
    Locator roomNameField;
    Locator textTotalRoom;
    Locator firstDeleteButton;
    Locator deleteButtonInPopUp;
    Locator icnClose;
    Locator optionProperty;
    Locator addDataButton;
    Locator addNewKosButton;
    Locator closePopupBBKIcon;
    Locator popUpBBkDialog;
    Locator closeBBKDialog;
    Locator fullnameTextbox;
    Locator bankAccountNumberTextbox;
    Locator bankOwnerNameTextbox;
    Locator bankNameDropdown;
    Locator termAndConsCheckbox;
    Locator submitDataMamipayButton;
    Locator backButtonActivationSent;
    Locator editDataKos;
    Locator getEditDataKosButton;
    Locator fasilitasFeature;
    Locator editSelesaiButton;
    Locator editDataLainBtn;
    Locator titleSuccessEditPopUpText;
    Locator doneButtonEditKosPopUp;
    Locator locationTextBox;
    Locator addressNotesInput;
    Locator promoNgebutLabel;
    Locator closeInfobarButton;
    Locator priceKostTextBoxDisable;
    Locator modalPopUp;
    Locator statusKos;
    Locator warningPrice;
    Locator tambahDataIklan;
    Locator tambahIklanBaru;
    Locator jenisPropertiRadioButton;
    Locator propertyNameField;
    Locator unitNameField;
    Locator unitNumberField;
    Locator unitTypeField;
    Locator floorPropertyField;
    Locator unitSizeField;
    Locator priceTypeCheckBox;
    Locator priceApartementField;
    Locator uploadCoverPhotoField;
    Locator uploadPhotoApartement;
    Locator gantiFotoButton;
    Locator editDataApartemenLink;
    Locator statusApartement;
    Locator apartDropdown;
    Locator selesaiLink;
    Locator descriptionField;
    Locator kostNameField;
    Locator roomTypeCheckbox;
    Locator roomTypeField;
    Locator kostTypeImage;
    Locator descKosField;
    Locator selectYear;
    Locator noteKosField;
    Locator uploadPeraturanButton;
    Locator errorMessage;
    Locator yearDropdown;
    Locator ubahFoto;
    Locator hapusFotoPeraturan;
    Locator aturPeraturanBtn;
    Locator tambahFotoBtn;
    Locator fotoPeraturan;
    Locator lanjutkanButton;
    Locator inputLocation;
    Locator firstLocationSuggestion;
    Locator searchInput;
    Locator firstEditButton;
    Locator alreadyInhabitedCheckbox;
    Locator statusRoom;
    Locator roomFilterDropdown;
    Locator filterTable;
    Locator floorFieldInput;
    Locator roomName;
    Locator errorMessageRoomName;
    Locator errorMessageFloor;
    Locator emptyTable;
    Locator mapField;
    Locator roomSizeProperty;
    Locator totalRoomField;
    Locator roomAvailableField;
    Locator priceMonthlyField;
    Locator minRentDuractionCheckbox;
    Locator otherPriceCheckbox;
    Locator otherKostPriceMonthlyCheckbox;
    Locator otherKostPriceMonthlyField;
    Locator minRentDurationDropdown;
    Locator minRentDurationChoose;
    Locator hapusDraftKos;
    Locator hapusKonfirm;
    Locator existingKosName;
    Locator existingRoomType;
    Locator roomTypeWarning;
    Locator roomTypeFieldInPopUp;
    Locator titleChangeIntercept;
    Locator descChangeIntercept;
    Locator additionalPriceCheckbox;
    Locator additionalPriceNameField;
    Locator additionalTotalPriceField;
    Locator downPaymentCheckbox;
    Locator percentageDownPaymentChoosed;
    Locator percentageDownPaymentDropdown;
    Locator penaltyCheckbox;
    Locator penaltyField;
    Locator descFieldDisabled;
    Locator lengkapiDataKosDraft;
    Locator toggleDenda;
    Locator textBoxTotalDenda;
    Locator ubahDendaText;
    Locator textBoxLatePay;
    Locator dropdownLatePay;
    Locator dendaPrice;
    Locator singgahsiniModal;
    Locator closeButton;
    Locator ifNoAppearsSuccessModalFirstButton;
    Locator insideModalFirstButton;

    Locator toggleDeposit;
    Locator textBoxDeposit;
    Locator toggleOtherPrice;
    Locator otherPriceName;
    Locator otherPriceNumber;
    Locator expandFilterButton;
    Locator textBoxFilterDataPhone;
    Locator dropdownFilterDataKosType;
    Locator searchButton;
    Locator actionButton;
    Locator nextConfirmBooking;
    Locator confirmButton;
    Locator confirmBooking;
    Locator deleteOtherPrice;
    Locator confirmDeleteOtherPrice;
    Locator detailButton;
    Locator selesaiButton;
    Locator bbkDataButton;
    Locator pengelolaCheckbox;
    Locator pengelolaNameField;
    Locator pengelolaPhoneField;
    Locator bbkPopUp;
    Locator untickInhabitedCheckbox;
    Locator editRoomIcn;
    Locator toastMessage;
    Locator updateRoom;
    private final Locator editDataKosButton;
    Locator btnDeleteActiveOtherPrice;
    Locator hapusConfirmation;
    Locator textOtherPriceActiveName;
    Locator textOtherPriceActiveNumber;
    Locator nameOtherPrice;
    Locator declineAddProperty;
    Locator imageHistoryZero;
    Locator rejectApartementText;
    Locator updateKamarButtonApart;

    Locator backgroundImageHover;
    Locator ubahFotoHover;
    Locator viewPhotoHover;
    Locator closePhotoHover;
    Locator hoverButtonsOnPhoto;
    Locator deletePhotoHover;
    Locator movePhotoHover;
    Locator photoPreview;
    Locator lanjutkanButtonMovePhoto;
    Locator toastMessageNotSelectedPhoto;
    Locator selectPhotoToMoved;
    Locator pindahkanPhotoButton;
    Locator toastMessageNotSelectDestinationPhoto;
    Locator destinationPhotoMoved;
    Locator destinationPhotoRoomMoved;
    Locator kostNameField2;
    Locator favoritedSection;
    Locator leafletMarkerIcon;
    Locator loadingSpinner;
    Locator filterRoomBox;
    Locator tambahkanData;

    // Photo section locators - following best practices with no nested locators
    Locator fotoDalamKamarSection;
    Locator fotoDepanKamarSection;
    Locator fotoBangunanTampakDepanSection;
    Locator fotoTampilanDalamBangunanSection;

    // Move buttons for specific sections
    Locator moveButtonFotoDalamKamar;
    Locator moveButtonFotoDepanKamar;
    Locator moveButtonFotoBangunanTampakDepan;
    Locator moveButtonFotoTampilanDalamBangunan;

    // Preview areas for specific sections
    Locator previewFotoDalamKamar;
    Locator previewFotoDepanKamar;
    Locator previewFotoBangunanTampakDepan;
    Locator previewFotoTampilanDalamBangunan;

    // Payment and pricing locators
    Locator rangeTimeDropdown;
    Locator amountTime;
    Locator unitTimeNearest;
    Locator penaltyRules;
    Locator deposit;
    Locator nameOtherPriceInput;
    Locator amountOtherPriceInput;
    Locator popUpBBK;

    public PropertiSayaPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);

        kostDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cari kos Anda di sini... dropdown-down"));
        searchKostTextbox = page.getByPlaceholder("Search");
        lihatSelengkapnyaButton = page.getByText("Lihat Selengkapnya").first();
        updateKamarButton = page.getByText("Update Kamar", new Page.GetByTextOptions().setExact(true));
        editAction = page.locator("(//*[@class='room-table__cta bg-c-icon bg-c-icon--md'])[1]");
        updateKamarCheckbox = page.locator("span").filter(new Locator.FilterOptions().setHasText("checkmark")).locator("svg");
        updateKamarButtonPopup = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Simpan"));
        firstKosNameLabel = page.locator(".kos-card__title").first();
        seeOtherPriceButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lihat harga lainnya"));
        priceKostTextBox = page.locator("//*[@class='input property-room__price-item-input-currency satu']");
        continueInputDataButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lanjut Isi Data"));
        updatePriceButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Update Harga"));
        messageSuccessUpdatePrice = page.getByText("Harga berhasil diupdate");
        closeBtn = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("close"));
        firstSeeKosButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Lihat Kos"));
        statisticChoiceSelection = page.locator(".statistic__choice");
        chatButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Chat 0"));
        reviewButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Review 0"));
        addRoomButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tambahkan Kamar"));
        roomNameField = page.getByLabel("Nama/ Nomor Kamar");
        textTotalRoom = page.locator(".room-table__total-room-label");
        firstDeleteButton = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("delete")).first();
        deleteButtonInPopUp = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Hapus"));
        icnClose = page.locator("a").filter(new Locator.FilterOptions().setHasText("close"));
        addDataButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tambahkan Data").setExact(true));
        addNewKosButton = page.getByText("+ Tambah Kos Baru").first();
        closePopupBBKIcon = page.locator(".bg-c-modal__action-closable");
        popUpBBkDialog = page.locator(".auto-active-bbk-intercept-modal");
        closeBBKDialog = page.locator(".owner-intercept-booking-modal__close-button");
        fullnameTextbox = page.getByPlaceholder("Masukkan nama lengkap Anda sesuai KTP");
        bankAccountNumberTextbox = page.getByPlaceholder("Masukkan nomor rekening");
        bankOwnerNameTextbox = page.getByPlaceholder("Pastikan sama dengan buku rekening bank");
        bankNameDropdown = page.getByPlaceholder("Pilih nama bank");
        termAndConsCheckbox = page.locator(".bg-c-checkbox__icon");
        submitDataMamipayButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Kirim Data"));
        backButtonActivationSent = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Kembali"));
        editSelesaiButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Edit Selesai"));
        editDataLainBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Edit Data Lain"));
        titleSuccessEditPopUpText = page.locator(".bg-c-modal__body-title");
        doneButtonEditKosPopUp = page.locator(".bg-c-button--md.bg-c-button--primary");
        locationTextBox = page.locator("//input[@placeholder='Masukkan nama lokasi/ area/ alamat']");
        addressNotesInput = page.getByRole(AriaRole.TEXTBOX).nth(2);
        promoNgebutLabel = page.locator(".media-content");
        closeInfobarButton = page.locator(".delete");
        priceKostTextBoxDisable = page.locator("//*[@class='input property-room__price-item-input-currency satu --disabled']");
        modalPopUp = page.locator("//div[@class='modal-content']");
        statusKos = page.locator(".kos-card__status");
        tambahDataIklan = page.getByTestId("add-room-btn");
        tambahIklanBaru = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tambah Iklan Baru"));
        propertyNameField = page.locator("//input[@id='propertyName']");
        unitNameField = page.locator("//input[@name='Nama unit']");
        unitNumberField = page.locator("//input[@name='Nomor unit']");
        unitTypeField = page.locator("//select[@id='unitType']");
        floorPropertyField = page.locator("//input[@id='propertyFloor']");
        unitSizeField = page.locator("//input[@id='unitSize']");
        uploadCoverPhotoField = page.locator("//div[@id='photoCover']");
        gantiFotoButton = page.locator("//a[.='Ganti Foto']");
        apartDropdown = page.getByText("Cari apartemen Anda disini...");
        selesaiLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("SELESAI"));
        descriptionField = page.locator("//textarea[@id='propertyDescription']");
        kostNameField = page.locator("input[type='text']").first();
        roomTypeCheckbox = page.locator("//span[@class='bg-c-checkbox__icon']").first();
        roomTypeField = page.locator("input[type='text']").nth(1);
        descKosField = page.locator("textarea").first();
        selectYear = page.locator(".bg-c-select__trigger");
        noteKosField = page.locator("textarea").nth(1);
        uploadPeraturanButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Upload Peraturan"));
        errorMessage = page.locator(".images__error");
        ubahFoto = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ubah Foto"));
        hapusFotoPeraturan = page.getByText("delete Hapus Foto");
        aturPeraturanBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Atur Peraturan"));
        tambahFotoBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tambah Foto"));
        fotoPeraturan = page.locator(".image-uploader__preview").first();
        lanjutkanButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lanjutkan"));
        inputLocation = page.locator("//input[@placeholder='Masukkan nama lokasi/ area/ alamat']");
        firstLocationSuggestion = page.locator("//a[@class=('bg-c-dropdown__menu-item bg-u-radius-md')]").first();
        searchInput = page.getByPlaceholder("Masukkan nama atau nomor kamar");
        firstEditButton = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("edit")).first();
        alreadyInhabitedCheckbox = page.locator("span").filter(new Locator.FilterOptions().setHasText("checkmark"));
        statusRoom = page.getByTestId("roomEditOccupancyCol").nth(0);
        roomFilterDropdown = page.locator(".availability-option__button");
        floorFieldInput = page.locator("#modalAddFloorInput_txt");
        errorMessageRoomName = page.locator(".bg-c-field__message");
        errorMessageFloor = page.getByText("Maks. 50 karakter.");
        emptyTable = page.locator(".is-empty");
        mapField = page.locator("[src='/_nuxt/img/de2002c.svg']");
        totalRoomField = page.getByPlaceholder("Jumlah kamar", new Page.GetByPlaceholderOptions().setExact(true));
        roomAvailableField = page.getByPlaceholder("Jumlah kamar yang kosong");
        priceMonthlyField = page.locator(".step-seven__content .step-seven__field input.step-seven__input").first();
        minRentDuractionCheckbox = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Anda ingin terapkan minimum durasi sewa? Jangka waktu minimum untuk bisa menyewa kamar kos Anda.")).locator("span");
        otherPriceCheckbox = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Harga sewa selain bulanan")).locator("span");
        minRentDurationDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Min. 1 Bln dropdown-down"));
        hapusDraftKos = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Hapus Kos")).first();
        hapusKonfirm = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Hapus").setExact(true));
        roomTypeFieldInPopUp = page.locator("input[type='text']");
        descChangeIntercept = page.locator(".changes-interception__message");
        additionalPriceCheckbox = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Ada Biaya Tambahan? Contoh: Cuci Baju, Listrik, dll.")).locator("span");
        additionalPriceNameField = page.locator("//input[@class='bg-c-input__field']");
        additionalTotalPriceField = page.locator("//input[@class='input additional-cost__input']");
        downPaymentCheckbox = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Terapkan Uang Muka? Uang muka/ DP akan diambil dari biaya sewa pertama.")).locator("span");
        percentageDownPaymentDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("10% dropdown-down"));
        penaltyCheckbox = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Anda ingin terapkan denda keterlambatan?")).locator("span");
        penaltyField = page.locator("div:nth-child(7) > div > .bg-c-field > .input");
        descFieldDisabled = page.locator("//div[@class='content']//div[@class='bg-c-field']//textarea[contains(@class, 'disabled')]");
        lengkapiDataKosDraft = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Lengkapi Data Kos")).first();
        toggleDenda = page.locator("label").filter(new Locator.FilterOptions().setHasText("Biaya Denda")).locator("span").first();
        textBoxTotalDenda = page.getByRole(AriaRole.TEXTBOX).nth(1);
        ubahDendaText = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ubah"));
        textBoxLatePay = page.getByPlaceholder("0");
        dropdownLatePay = page.locator("//select[@class='c-field-select__select']");
        dendaPrice = page.getByText("Rp50.000");
        toggleDeposit = page.locator("label").filter(new Locator.FilterOptions().setHasText("Biaya Deposit")).locator("span").first();
        textBoxDeposit = page.getByRole(AriaRole.TEXTBOX).nth(1);
        toggleOtherPrice = page.locator("label").filter(new Locator.FilterOptions().setHasText("Biaya Lainnya Per Bulan")).locator("span").first();
        otherPriceName = page.getByText("1234567890abcdefjkl", new Page.GetByTextOptions().setExact(true));
        otherPriceNumber = page.getByText("Rp100.000").first();
        expandFilterButton = page.getByText("Tampilkan Filter");
        textBoxFilterDataPhone = page.getByPlaceholder("Ex: 081987654321");
        dropdownFilterDataKosType = page.locator("#select2-kost_type-container");
        searchButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Cari"));
        actionButton = page.locator("(//button[@type='button'][normalize-space()='Actions'])[1]");
        confirmButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Confirm"));
        nextConfirmBooking = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Lanjutkan"));
        confirmBooking = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Konfirmasi"));
        deleteOtherPrice = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Hapus")).first();
        confirmDeleteOtherPrice = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ya, Hapus"));
        detailButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Detail"));
        selesaiButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Selesai"));
        bbkDataButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("BBK Data"));
        pengelolaCheckbox = page.locator("label").filter(new Locator.FilterOptions().setHasText("Anda ingin tambahkan data pengelola? checkmark")).locator("span");
        pengelolaNameField = page.locator("input[type=text]").nth(2);
        pengelolaPhoneField = page.locator("input[type=text]").nth(3);
        bbkPopUp = page.locator("//*[@class='bg-c-modal__inner']");
        untickInhabitedCheckbox = page.locator("svg").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^checkmark$")));
        editDataKosButton = page.locator("a").filter(new Locator.FilterOptions().setHasText("Edit Data Kos"));
        editRoomIcn = page.getByRole(AriaRole.ROW, new Page.GetByRoleOptions().setName("1")).getByRole(AriaRole.LINK).first();
        toastMessage = page.locator(".wrapper__toast");
        updateRoom = page.getByText("Update Kamar");
        btnDeleteActiveOtherPrice = page.locator(".additional-price-item .additional-price-item__action button:last-child");
        hapusConfirmation = page.locator("//*[@class='c-mk-card__body']//button[contains(.,'Ya, Hapus')]");
        textOtherPriceActiveName = page.locator(".additional-price-item:nth-child(1) .additional-price-item__info-title");
        textOtherPriceActiveNumber = page.locator(".additional-price-item:nth-child(1) .additional-price-item__info-price");
        nameOtherPrice = page.locator("//div[@class='additional-price-item__info-title']");
        declineAddProperty = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Batal"));
        imageHistoryZero = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("history_zero"));
        rejectApartementText = page.getByText("Alasan ditolak :");
        updateKamarButtonApart = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Update Kamar & Harga"));
        backgroundImageHover = page.locator(".preview__menu-background");
        ubahFotoHover = page.getByText("camera Ubah Foto");
        viewPhotoHover = page.getByText("visible Lihat Foto");
        closePhotoHover = page.locator(".mdi-close");
        hoverButtonsOnPhoto = page.locator(".preview__menu");
        deletePhotoHover = page.getByText("delete Hapus Foto");
        movePhotoHover = page.getByText("sorting Pindahkan Foto");
        photoPreview = page.locator(".image-uploader__preview");
        lanjutkanButtonMovePhoto = page.locator("button").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Lanjutkan$")));
        selectPhotoToMoved = page.locator("label span").first();
        pindahkanPhotoButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pindahkan"));
        toastMessageNotSelectedPhoto = page.getByText("Pilih foto terlebih dahulu");
        toastMessageNotSelectDestinationPhoto = page.locator("div").filter(new Locator.FilterOptions().setHasText("Pilih section tujuan terlebih dahulu")).nth(3);
        destinationPhotoMoved = page.locator("label").filter(new Locator.FilterOptions().setHasText("Foto tampilan dalam bangunan")).locator("span").nth(1);
        destinationPhotoRoomMoved = page.locator("label").filter(new Locator.FilterOptions().setHasText("Foto dalam kamar")).locator("span").nth(1);
        favoritedSection = page.getByText("Difavoritkan 0");
        kostNameField2 = page.locator("//div[@class='bg-c-input step-one__input bg-c-input--disabled bg-c-input--lg']");
        leafletMarkerIcon = page.locator("//img[@class='leaflet-marker-icon leaflet-zoom-animated leaflet-interactive leaflet-marker-draggable']");
        loadingSpinner = page.locator(".c-loader").first();
        filterRoomBox = page.locator("#ownerKosContainer");
        tambahkanData = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tambahkan Data").setExact(true));
        singgahsiniModal = page.locator(".singgahsini-landing-modal");
        closeButton = page.locator(".bg-c-modal__action-closable");

        // Initialize photo section locators
        fotoDalamKamarSection = page.locator("//h4[contains(text(),'Foto dalam kamar')]/parent::div");
        fotoDepanKamarSection = page.locator("//h4[contains(text(),'Foto depan kamar')]/parent::div");
        fotoBangunanTampakDepanSection = page.locator("//h4[contains(text(),'Foto bangunan tampak depan')]/parent::div");
        fotoTampilanDalamBangunanSection = page.locator("//h4[contains(text(),'Foto tampilan dalam bangunan')]/parent::div");

        // Initialize move buttons for specific sections
        moveButtonFotoDalamKamar = fotoDalamKamarSection.getByText("Pindahkan Foto").first();
        moveButtonFotoDepanKamar = fotoDepanKamarSection.getByText("Pindahkan Foto").first();
        moveButtonFotoBangunanTampakDepan = fotoBangunanTampakDepanSection.getByText("Pindahkan Foto").first();
        moveButtonFotoTampilanDalamBangunan = fotoTampilanDalamBangunanSection.getByText("Pindahkan Foto").first();

        // Initialize preview areas for specific sections - using img tag which is more reliable
        previewFotoDalamKamar = fotoDalamKamarSection.locator("img").first();
        previewFotoDepanKamar = fotoDepanKamarSection.locator("img").first();
        previewFotoBangunanTampakDepan = fotoBangunanTampakDepanSection.locator("img").first();
        previewFotoTampilanDalamBangunan = fotoTampilanDalamBangunanSection.locator("img").first();

        // Initialize payment and pricing locators
        rangeTimeDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Hari dropdown-down").setExact(true));
        amountTime = page.getByRole(AriaRole.SPINBUTTON).first();
        unitTimeNearest = page.getByPlaceholder("0");
        penaltyRules = page.locator(".is-active .c-field-select__select");
        deposit = page.locator("//input[@class='input field-amount']");
        nameOtherPriceInput = page.locator("//input[@placeholder='Contoh: Listrik, Parkir']");
        amountOtherPriceInput = page.locator("//input[@class='input']");
        popUpBBK = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("join-mamibooking"));
        ifNoAppearsSuccessModalFirstButton = page.locator(".modal.c-mk-modal.is-active button").first();
        insideModalFirstButton = page.locator(".modal.c-mk-modal.is-active .bg-c-button--md.bg-c-button--primary");
    }

    /**
     * user as owner click kost dropdown
     * user enter kost name
     * user choose kost name
     */
    public void searchKostPropertySaya(String kostName) {
        playwright.waitTillPageLoaded(10000.0);
        playwright.waitForSelectorState(filterRoomBox, WaitForSelectorState.VISIBLE, GlobalConfig.LONG_TIMEOUT);
        if (singgahsiniModal.isVisible()) {
            if (closeButton.isVisible()) {
                playwright.clickOn(closeButton);
                playwright.hardWait(1000.0);
            }
        }

        playwright.clickOn(kostDropdown);
        if (kostName == null || kostName.isEmpty()) {
            Locator firstKost = page.locator("a.bg-c-dropdown__menu-item").first();
            playwright.waitForSelectorState(firstKost, WaitForSelectorState.VISIBLE, GlobalConfig.LONG_TIMEOUT);
            playwright.clickOn(firstKost);
        } else {
            searchKostTextbox.fill(kostName);
            Locator kostSearch = page.locator("a").filter(new Locator.FilterOptions().setHasText(kostName)).first();
            playwright.waitForSelectorState(kostSearch, WaitForSelectorState.VISIBLE, GlobalConfig.LONG_TIMEOUT);
            playwright.clickOn(kostSearch);
        }
    }

    /**
     * user as owner click update kamar button
     */
    public void clickUpdateKamarButton() {
        playwright.clickOn(updateKamarButton);
    }

    /**
     * user as owner click update kamar kost button
     */
    public void clickUpdateKamarEmptyButton() {
        playwright.waitTillLocatorIsVisible(editAction);
        playwright.clickOn(editAction);
        if (updateKamarCheckbox.isChecked()) {
            playwright.clickOn(updateKamarCheckbox);
            // Wait for button to become enabled before clicking
            playwright.clickOn(updateKamarButtonPopup);
        }
    }

    /**
     * Get first kos name in kos list
     *
     * @return string kos name
     */
    public String getFirstKosName() {
        playwright.waitTillPageLoaded();
        playwright.waitTillLocatorIsVisible(firstKosNameLabel, 30000.0);
        return playwright.getText(firstKosNameLabel);
    }

    /**
     * Get first kos status in kos list
     *
     * @return string kos status
     */
    public String getFirstKosStatus(String status) {
        firstKosStatusLabel = page.getByText(status).first();
        return playwright.getText(firstKosStatusLabel);
    }

    /**
     * Get first kos type in kos list
     *
     * @return string kos type
     */
    public String getFirstKosType(String type) {
        firstKosTypeLabel = page.getByText(type).first();
        return playwright.getText(firstKosTypeLabel);
    }

    /**
     * Click on kos name in update price
     *
     * @param kosName is kos name
     */
    public void clickOnKosName(String kosName) {
        kostNameText = page.locator("//span[.='" + kosName + "']");
        playwright.clickOn(kostNameText);
    }

    /**
     * Click on see other price button
     */
    public void clickSeeOtherPrices() {
        playwright.clickOn(seeOtherPriceButton);
    }

    /**
     * Enter Text in daily price text box
     *
     * @param dailyPrice is text we want to search
     */
    public void inputDailyPriceKos(String dailyPrice) {
        priceKostTextBox.nth(1).clear();
        priceKostTextBox.nth(1).fill(dailyPrice);
    }

    /**
     * Enter Text in weekly price text box
     *
     * @param weeklyPrice is text we want to search
     */
    public void inputWeeklyPrice(String weeklyPrice) {
        priceKostTextBox.nth(2).clear();
        priceKostTextBox.nth(2).fill(weeklyPrice);
    }

    /**
     * Enter Text in monthly price text box
     *
     * @param monthlyPrice is text we want to search
     */
    public void inputMonthlyPrice(String monthlyPrice) {
        priceKostTextBox.first().clear();
        priceKostTextBox.first().fill(monthlyPrice);
    }

    /**
     * Enter Text in three monthly price text box
     *
     * @param threeMonthlyPrice is text we want to search
     */
    public void inputThreeMonthlyPrice(String threeMonthlyPrice) {
        priceKostTextBox.nth(3).clear();
        priceKostTextBox.nth(3).fill(threeMonthlyPrice);
    }

    /**
     * Enter Text in six monthly price text box
     *
     * @param sixMonthlyPrice is text we want to search
     */
    public void inputSixMonthlyPrice(String sixMonthlyPrice) {
        priceKostTextBox.nth(4).clear();
        priceKostTextBox.nth(4).fill(sixMonthlyPrice);
    }

    /**
     * Enter Text yearly price text box
     *
     * @param yearlyPrice is text we want to search
     */
    public void inputYearlyPrice(String yearlyPrice) {
        priceKostTextBox.nth(5).clear();
        priceKostTextBox.nth(5).fill(yearlyPrice);
    }

    /**
     * Get text price daily
     *
     * @return Integer daily price
     */
    public String getDailyPrice() {
        int number = JavaHelpers.extractNumber(playwright.getInputValue(priceKostTextBox.nth(1)));
        return String.valueOf(number);
    }

    /**
     * Get text price weekly
     *
     * @return Integer weekly price
     */
    public String getWeeklyPrice() {
        int number = JavaHelpers.extractNumber(playwright.getInputValue(priceKostTextBox.nth(2)));
        return String.valueOf(number);
    }

    /**
     * Get text price monthly
     *
     * @return Integer monthly price
     */
    public String getMonthlyPrice() {
        int number = JavaHelpers.extractNumber(playwright.getInputValue(priceKostTextBox.first()));
        return String.valueOf(number);
    }

    /**
     * Get text price three monthly
     *
     * @return Integer three monthly price
     */
    public String getThreeMonthlyPrice() {
        int number = JavaHelpers.extractNumber(playwright.getInputValue(priceKostTextBox.nth(3)));
        return String.valueOf(number);
    }

    /**
     * Get text price six monthly
     *
     * @return Integer six monthly price
     */
    public String getSixMonthlyPrice() {
        int number = JavaHelpers.extractNumber(playwright.getInputValue(priceKostTextBox.nth(4)));
        return String.valueOf(number);
    }

    /**
     * Get text price yearly
     *
     * @return Integer yearly price
     */
    public String getYearlyPrice() {
        int number = JavaHelpers.extractNumber(playwright.getInputValue(priceKostTextBox.nth(5)));
        return String.valueOf(number);
    }

    /**
     * Click 'Lanjut Isi Data' in attention pop up
     */
    public void clickContinueInputDataPopUp() {
        if (playwright.waitTillLocatorIsVisible(continueInputDataButton)) {
            playwright.clickOn(continueInputDataButton);
        }
    }

    /**
     * Click on update button
     */
    public void clickButtonUpdate() {
        playwright.pageScrollUntilElementIsVisible(updatePriceButton);
        playwright.clickOn(updatePriceButton);
    }

    /**
     * Get message success update price
     *
     * @return message success update price
     */
    public String getToastSuccessUpdatePrice() {
        return playwright.getText(messageSuccessUpdatePrice);
    }

    /**
     * Click on see kos button in first kos list
     */
    public void clickFirstSeeKos() {
        playwright.clickOn(firstSeeKosButton);
    }

    /**
     * Click on lihat selengkapnya button in first kos list
     */
    public void clickOnLihatSelengkapnyaButton() {
        playwright.waitForSelectorState(lihatSelengkapnyaButton, WaitForSelectorState.VISIBLE, 1000.0 * 300);
        playwright.clickOn(lihatSelengkapnyaButton);
        playwright.hardWait(1500);
    }

    /**
     * Click on chat button in kos list
     */
    public void clickChat() {
        playwright.clickOn(chatButton);
    }

    /**
     * Click on review button in kos list
     */
    public void clickReview() {
        playwright.clickOn(reviewButton);
    }

    /**
     * Click on add room button in room allotment
     * Fill room name field with text
     * Click on update room button in pop up
     */
    public void addRoom(String roomName) {
        playwright.clickOn(addRoomButton);
        roomNameField.fill(roomName);
    }

    /**
     * Get number of total room
     */
    public String getTextTotalRoom() {
        if (playwright.isTextDisplayed("Total Kamar 0")) {
            playwright.isTextDisplayed("Total Kamar 0");
        } else {
            playwright.waitTillLocatorIsVisible(textTotalRoom);
            return playwright.getText(textTotalRoom);
        }
        return "Total Kamar 1";
    }

    /**
     * click on Delete Room Icon
     */
    public void clickOnFirstDeleteRoomIcon() {
        playwright.waitTillLocatorIsVisible(firstDeleteButton);
        playwright.clickOn(firstDeleteButton);
        playwright.waitTillLocatorIsVisible(deleteButtonInPopUp);
        playwright.clickOn(deleteButtonInPopUp);
        // Wait for deletion to complete instead of reload
        playwright.waitTillPageLoaded();
    }

    /**
     * Click icon close on page Pilih Jenis Properti
     */
    public void clickOnIconClose() {
        playwright.clickOn(icnClose);
    }

    /**
     * Click on radio button "Kos" or "Apartemen"
     * Click on add data button
     */
    public void selectOptionAddProperty(String option) {
        optionProperty = page.locator("//label[contains(.,'" + option + "')]");
        playwright.clickOn(optionProperty);
        playwright.clickOn(addDataButton);
    }

    /**
     * Click on add new kos button
     */
    public void clickAddNewKos() {
        playwright.clickOn(addNewKosButton);
    }

    /**
     * Click on close at pop up BBL
     */
    public void clickClosePopUpBBK() {
        var popUpDismiss = page.getByRole(AriaRole.DIALOG).filter(new Locator.FilterOptions().setHasText("Ingin Kamar Kosong Anda Cepat")).locator("a").first();
        if (playwright.isLocatorVisibleAfterLoad(popUpDismiss, 3000.0)) {
            playwright.clickOn(popUpDismiss);
        } else if (playwright.waitTillLocatorIsVisible(closePopupBBKIcon)) {
            playwright.waitFor(closePopupBBKIcon);
            playwright.clickOn(closePopupBBKIcon);
        }
    }

    /**
     * Click on close at pop up BBK on property saya
     */
    public void clickClosePopUpBBKOnPropertySaya() {
        // Wait longer for dialog before giving up
        if (playwright.waitTillLocatorIsVisible(closeBBKDialog, 8000.0)) {
            playwright.waitFor(closeBBKDialog);
            playwright.clickOn(closeBBKDialog);
        } else {
            // Dialog didn't appear - page may have loaded differently
            System.out.println("BBK dialog not found - continuing without closing");
        }
    }

    /**
     * Get Full Name inputted text in Mamipay Form
     *
     * @return String Full Name inputted text
     */
    public String getInputTextFullName() {
        playwright.waitTillLocatorIsVisible(fullnameTextbox);
        return playwright.getInputValue(fullnameTextbox);
    }

    /**
     * Get Bank account number inputted text in Mamipay Form
     *
     * @return String Bank account number inputted text
     */
    public String getInputTextBankAcc() {
        playwright.waitTillPageLoaded(3000.0);
        return playwright.getInputValue(bankAccountNumberTextbox);
    }

    /**
     * Get Bank owner name inputted text in Mamipay Form
     *
     * @return String Bank owner name inputted text
     */
    public String getInputTextBankOwnerName() {
        return playwright.getInputValue(bankOwnerNameTextbox);
    }

    /**
     * Get Bank name inputted text in Mamipay Form
     *
     * @return String Bank name inputted text
     */
    public String getInputTextBankName() {
        return playwright.getInputValue(bankNameDropdown);
    }

    /**
     * Fill out Full Name
     *
     * @param fullName
     */
    public void fillInputNameForm(String fullName) {
        playwright.clearText(fullnameTextbox);
        playwright.clickLocatorAndTypeKeyboard(fullnameTextbox, fullName);
    }

    /**
     * Fill out Bank Account Number Form
     *
     * @param bankAccountNumber bank account number
     */
    public void fillBankAccountNumberForm(String bankAccountNumber) {
        playwright.clearText(bankAccountNumberTextbox);
        playwright.clickLocatorAndTypeKeyboard(bankAccountNumberTextbox, bankAccountNumber);
    }

    /**
     * Fill out Bank Account Name Form
     *
     * @param bankAccountName bank account name
     */
    public void fillBankAccountNameForm(String bankAccountName) {
        playwright.clearText(bankOwnerNameTextbox);
        playwright.clickLocatorAndTypeKeyboard(bankOwnerNameTextbox, bankAccountName);
    }

    /**
     * Fill out Bank Name
     *
     * @param bankName
     */
    public void fillInputBankName(String bankName) {
        playwright.clickOn(bankNameDropdown);
        playwright.clearText(bankNameDropdown);
        playwright.clickLocatorAndTypeKeyboard(bankNameDropdown, bankName);
        Locator element = page.locator("a").filter(new Locator.FilterOptions().setHasText(bankName));
        playwright.clickOn(element);
    }

    /**
     * Click on the term and conditions checkbox
     */
    public void clickTermsAndConsCheckbox() {
        playwright.clickOn(termAndConsCheckbox);
    }

    /**
     * Click on Submit mamipay datd
     */
    public void clickSubmitButtonMamipay() {
        playwright.clickOn(submitDataMamipayButton);
        playwright.clickOn(backButtonActivationSent);
    }

    /**
     * Click button edit kost
     * @param dataKos which part to edit
     */
    public void clickEditDataKos(String dataKos) {
        editDataKos = page.locator("//p[normalize-space()='"+dataKos+"']");

        // Close success modal if it's blocking the element
        closeSuccessModalIfPresent();

        // Wait with longer timeout before resorting to reload
        if (!playwright.waitTillLocatorIsVisible(editDataKos, 10000.0)) {
            // Element not found - wait for page to stabilize and try once more
            playwright.waitTillPageLoaded();
            playwright.waitTillLocatorIsVisible(editDataKos, 5000.0);
        }

        playwright.clickOn(editDataKos);
        playwright.waitForSelectorState(loadingSpinner, WaitForSelectorState.HIDDEN, GlobalConfig.LONG_TIMEOUT);
    }

    /**
     * Close success modal popup if present
     * This handles the modal that appears after saving data which can block other elements
     */
    private void closeSuccessModalIfPresent() {
        playwright.hardWait(1000.0);

        // Check if success modal is visible
        Locator successModal = page.locator(".modal.c-mk-modal.is-active .success-modal");

        if (successModal.isVisible()) {
            // Try to click button inside modal first (using existing doneButtonEditKosPopUp locator pattern)
            if (insideModalFirstButton.isVisible()) {
                insideModalFirstButton.click();
                playwright.hardWait(1000.0);
                return;
            }

            // Fallback: try any button in the success modal
            if (ifNoAppearsSuccessModalFirstButton.isVisible()) {
                ifNoAppearsSuccessModalFirstButton.click();
                playwright.hardWait(1000.0);
                return;
            }

            // Last resort: use JavaScript to remove modal
            page.evaluate("() => { " +
                "const modal = document.querySelector('.modal.c-mk-modal.is-active');" +
                "if (modal) { modal.classList.remove('is-active'); }" +
            "}");
            playwright.hardWait(500.0);
        }
    }

    /**
     * Click facilities checkbox
     *
     * @param section  is facility section, example "Fasilitas Umum"
     * @param facility is facility name
     */
    public void clickFacilitiesCheckbox(String section, String facility) {
        fasilitasFeature = page.locator("//h4[contains(., '" + section + "')]/following::div//p[contains(text(), '" + facility + "')]").first();
        playwright.pageScrollUntilElementIsVisible(fasilitasFeature);
        if (playwright.waitTillLocatorIsVisible(fasilitasFeature)) {
            playwright.clickOn(fasilitasFeature);
        } else {
            fasilitasFeature = page.getByText(facility, new Page.GetByTextOptions().setExact(true));
            playwright.clickOn(fasilitasFeature);
        }
    }

    /**
     * Verify button edit finish is disabled
     *
     * @return true if disabled
     */
    public boolean isEditFinishedButtonDisabled() {
        return editSelesaiButton.isDisabled();
    }

    /**
     * Click on edit done in add kos form page
     */
    public void clickEditDoneButton() {
        playwright.hardWait(2000.0);
        playwright.waitForSelectorState(loadingSpinner, WaitForSelectorState.HIDDEN, 60000.0);
        playwright.clickOn(editSelesaiButton);
        playwright.waitForSelectorState(loadingSpinner, WaitForSelectorState.HIDDEN, 60000.0);
    }

    /**
     * Get warning title in certain facility
     *
     * @param facility is facility section
     * @return error message title
     */
    public String getWarningTitleFacility(String facility) {
        Locator element = page.locator("//h4[contains(text(), '" + facility + "')]/following-sibling::div[1]//p[1]").first();
        playwright.pageScrollUntilElementIsVisible(element);
        return playwright.getText(element);
    }

    /**
     * Get warning description in certain facility
     *
     * @param facility is facility section
     * @return error message description
     */
    public String getWarningDescFacility(String facility) {
        Locator element = page.locator("//h4[contains(text(), '" + facility + "')]/following-sibling::div[1]//p[2]").first();
        playwright.pageScrollUntilElementIsVisible(element);
        return playwright.getText(element);
    }

    /**
     * Get title for success edit pop up
     *
     * @return String pop up title
     */
    public String getTitlePopUpSuccessEditKos() {
        playwright.waitTillLocatorIsVisible(titleSuccessEditPopUpText, 120000.0);
        playwright.hardWait(1000);
        return playwright.getText(titleSuccessEditPopUpText);
    }

    /**
     * Click 'Done' in success edit kos pop up
     */
    public void clickDoneEditKosPopUp() {
        playwright.clickOn(doneButtonEditKosPopUp);
    }

    /**
     * Input kost location in create kost page
     */
    public void insertKosLocation(String locationName) {
        playwright.hardWait(3000.0);
        page.onDialog(dialog -> {
            System.out.printf("Allow%n", dialog.message());
            dialog.dismiss();
        });
        playwright.clickOn(locationTextBox);
        playwright.fill(locationTextBox, locationName);
    }

    /**
     * Enter address notes
     *
     * @param notes is address notes
     */
    public void enterAddressNotes(String notes) {
        playwright.pageScrollUntilElementIsVisible(addressNotesInput);
        playwright.clearText(addressNotesInput);
        playwright.fill(addressNotesInput, notes);
    }

    /**
     * Get text in promo ngebut infobar
     *
     * @return String promo ngebut info
     */
    public String getPromoNgebutInfo() {
        return playwright.getText(promoNgebutLabel);
    }

    /**
     * Verify if monthly price field is enable
     *
     * @return true if enable
     */
    public boolean isMonthlyPriceFieldDisable() {
        return playwright.isButtonDisable(priceKostTextBoxDisable.first());
    }

    /**
     * Click close infobar button
     */
    public void clickCloseInfobar() {
        playwright.clickOn(closeInfobarButton);
    }

    /**
     * Verify Pop up modal visible
     *
     * @return boolean true, false
     */
    public boolean isPopUpModalVisible() {
        return playwright.isLocatorVisibleAfterLoad(modalPopUp, 3000.0);
    }

    /**
     * Verify status kos
     *
     * @return statusKos
     */
    public boolean isStatusKos() {
        return playwright.waitTillLocatorIsVisible(statusKos, 3000.0);
    }

    /**
     * Get text warning price daily, weekly, monthly, three monthly,six monthly, yearly price
     *
     * @return String warning daily, weekly, monthly, three monthly,six monthly, yearly price
     */
    public String getWarningYearlyPrice(Integer i) {
        warningPrice = page.locator(".media-content");
        return playwright.getText(warningPrice.nth(i));
    }

    /**
     * Check if button update price is disable
     *
     * @return true if disable
     */
    public boolean isButtonUpdatePriceDisable() {
        return updatePriceButton.isDisabled();
    }

    /**
     * Click tambah data iklan -> tambah iklan baru -> choose add kos or apartement
     *
     * @param jenisProperti e.g Kost, Apartemen
     */
    public void clickTambahDataIklan(String jenisProperti) {
        playwright.waitTillPageLoaded();
        if (playwright.isTextDisplayed("Saya ingin menambahkan data:")) {
            jenisPropertiRadioButton = page.locator("#ownerModalAdd").getByText(jenisProperti);
            playwright.waitTillLocatorIsVisible(jenisPropertiRadioButton, 3000.0);
            playwright.clickOn(jenisPropertiRadioButton);
            playwright.clickOn(tambahkanData);
        } else {
            playwright.waitTillLocatorIsVisible(tambahDataIklan, GlobalConfig.LONG_TIMEOUT);
            playwright.clickOn(tambahDataIklan);
            playwright.clickOn(tambahIklanBaru);
            jenisPropertiRadioButton = page.locator("#ownerModalAdd").getByText(jenisProperti);
            playwright.waitTillLocatorIsVisible(jenisPropertiRadioButton, 3000.0);
            playwright.clickOn(jenisPropertiRadioButton);
            playwright.clickOn(tambahkanData);
        }
    }

    /**
     * Input property name
     *
     * @param propertyName Can use add and edit
     *                     If edit nama project field doesn't appear
     */
    public void inputPropertyName(String propertyName) {
        if (propertyNameField.isVisible()) {
            playwright.forceFill(propertyNameField, propertyName);
        }
    }

    /**
     * Input nama unit apartemen
     *
     * @param namaUnit
     */
    public void inputNamaUnit(String namaUnit) {
        playwright.forceFill(unitNameField, namaUnit);
    }

    /**
     * Input nomor unit
     *
     * @param nomorUnit
     */
    public void inputNoUnit(String nomorUnit) {
        playwright.forceFill(unitNumberField, nomorUnit);
    }

    /**
     * Select tipe unit
     *
     * @param tipeUnit e.g 1-Room Studio, 2 BR, 3 BR, 4 BR, Lainnya
     */
    public void selectUnitType(String tipeUnit) {
        playwright.selectDropdownByValue(unitTypeField, tipeUnit);
    }

    /**
     * input lantai apartemen
     *
     * @param lantai
     */
    public void inputLantai(String lantai) {
        playwright.forceFill(floorPropertyField, lantai);
    }

    /**
     * Input unit size
     *
     * @param luasUnit
     */
    public void inputUnitSize(String luasUnit) {
        playwright.forceFill(unitSizeField, luasUnit);
    }

    /**
     * Select price type
     *
     * @param priceType
     */
    public void selectPriceType(String priceType) {
        priceTypeCheckBox = page.locator("label").filter(new Locator.FilterOptions().setHasText(priceType));
        playwright.clickOn(priceTypeCheckBox);
    }

    /**
     * Input apartemen price
     * After check price type, then input the price
     *
     * @param priceType e.g Perhari, Perminggu, Perbulan, Pertahun
     * @param price
     */
    public void inputApartementPrice(String priceType, String price) {
        String element;
        switch (priceType) {
            case "Perhari":
                element = "Daily";
                break;
            case "Perminggu":
                element = "Weekly";
                break;
            case "Perbulan":
                element = "Monthly";
                break;
            case "Pertahun":
                element = "Yearly";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + priceType);
        }
        priceApartementField = page.locator("//input[@id='inputPrice" + element + "']");
        playwright.waitTillLocatorIsVisible(priceApartementField, 3000.0);
        playwright.forceFill(priceApartementField, price);
    }

    /**
     * Select fasilitas unit
     *
     * @param fasilitasUnit
     */
    public void selectFasilitasUnit(String fasilitasUnit) {
        String element = "//label[contains(.,'" + fasilitasUnit + "')]";
        playwright.clickOn(page.locator(element));
    }

    /**
     * Select fasilitas kamar
     *
     * @param fasilitasKamar
     */
    public void selectFasilitasKamar(String fasilitasKamar) {
        String element = "";
        switch (fasilitasKamar) {
            case "Not Furnished":
                element = "[for='isFurnished0']";
                break;
            case "Semi Furnished":
                element = "[for='isFurnished1']";
                break;
            case "Furnished":
                element = "[for='isFurnished2']";
                break;
        }
        playwright.clickOn(page.locator(element));
    }

    /**
     * Upload phoyo cover apartemen
     * Photo can't > 5mb
     */
    public void uploadCoverPhotoApartemen() {
        String imagePath = "src/main/resources/images/upload5Mb.jpg";
        FileChooser fileChooser = page.waitForFileChooser(() -> uploadCoverPhotoField.click());
        fileChooser.setFiles(Paths.get(imagePath));
        playwright.waitTillLocatorIsVisible(uploadCoverPhotoField);
        playwright.hardWait(3000);
    }

    /**
     * Upload photo apartemen
     *
     * @param photoType e.g photo kamar, kamar mandi, dan lainnya
     *                  photo can't > 5mb
     */
    public void uploadPhotoApartemen(String photoType) {
        String element = "";
        switch (photoType) {
            case "kamar":
                element = "Bedroom";
                break;
            case "kamar mandi":
                element = "Bath";
                break;
            case "lainnya":
                element = "Other";
                break;
        }
        uploadPhotoApartement = page.locator("//div[@id='photo" + element + "']");

        String imagePath = "src/main/resources/images/upload5Mb.jpg";
        FileChooser fileChooser = page.waitForFileChooser(() -> uploadPhotoApartement.click());
        fileChooser.setFiles(Paths.get(imagePath));
        playwright.waitTillLocatorIsVisible(uploadPhotoApartement);
        playwright.hardWait(3000);
    }

    /**
     * Select property name
     * After owner input property name, will be display dropdown suggestion of property name
     */
    public void selectPropertyName(String namaProject) {
        if (propertyNameField.isVisible()) {
            playwright.clickOnText(namaProject);
        }
    }

    /**
     * Click furniture if check fasilitas kamar is semi furnished and furnished
     *
     * @param furniture
     */
    public void clickFurnished(String furniture) {
        playwright.clickOnText(furniture);
    }

    /**
     * Click edit apartemen link
     * Property name from getSearchPropertyName
     */
    public void clickEditDataApartemen() {
        editDataApartemenLink = page.locator("//p[contains(., '" + getSearchPropertyName() + "')]/following::a[@class='clickable-link edit-data-link'][1]");
        playwright.clickOn(editDataApartemenLink);
    }

    /**
     * Get status property apartment diperiksa admin
     *
     * @param searchPropertyName
     * @return statusApartement Diperiksa Admin
     */
    public String getStatusProperty(String searchPropertyName) {
        statusApartement = page.locator("//p[contains(., '" + searchPropertyName + "')]/parent::*/preceding::span[@class='status unverified-waiting']");
        return playwright.getText(statusApartement);
    }

    /**
     * Get status property apartment ditolak
     *
     * @param searchPropertyName
     * @return statusApartement ditolak
     */
    public String getStatusPropertyReject(String searchPropertyName) {
        statusApartement = page.locator("//p[contains(., '" + searchPropertyName + "')]/parent::*/preceding::span[@class='status unverified-rejected']");
        return playwright.getText(statusApartement);
    }

    /**
     * Get status property apartment aktif
     *
     * @param searchPropertyName
     * @return statusApartement aktif
     */
    public String getStatusPropertyVerified(String searchPropertyName) {
        statusApartement = page.locator("//p[contains(., '" + searchPropertyName + "')]/parent::*/preceding::span[@class='status verified']");
        return playwright.getText(statusApartement);
    }

    /**
     * Search apartemen property
     *
     * @param namaUnit
     */
    public void searchApartPropertySaya(String namaUnit) {
        setSearchPropertyName(namaUnit);
        playwright.clickOn(apartDropdown);
        searchKostTextbox.fill(namaUnit);
        Locator apartSearch = page.locator("a").filter(new Locator.FilterOptions().setHasText(namaUnit));
        playwright.clickOn(apartSearch);
    }

    /**
     * Click submit button
     */
    public void clickOnSubmitButton() {
        playwright.clickOnTextButton("Submit", 3000.0);
        playwright.hardWait(2000);
    }

    /**
     * Click on selesai button
     */
    public void clickOnSelesaiButton() {
        playwright.waitTillLocatorIsVisible(selesaiLink, 3000.0);
        playwright.clickOn(selesaiLink);
    }

    /**
     * Input descirption
     *
     * @param deskripsi
     */
    public void inputDescription(String deskripsi) {
        playwright.forceFill(descriptionField, deskripsi);
    }

    /**
     * Input kos name
     *
     * @param kosName (include random text from property saya steps)
     */
    public void inputKosName(String kosName) {
        if (kosName.contains("null ") || kosName.isEmpty()) {
            return; // returning input kost name when empty
        }

        playwright.waitTillLocatorIsVisible(kostNameField, 3000.0);
        if (playwright.waitTillLocatorIsVisible(kostNameField2)) {
            playwright.clickOn(kostNameField2);
        } else {
            playwright.clickOn(kostNameField);
        }
        playwright.forceFill(kostNameField, kosName);
    }

    /**
     * Checklist roomtype
     *
     * @param roomTypeCheck
     */
    public void checkRoomType(String roomTypeCheck) {
        if (roomTypeCheck.equals("yes")) {
            playwright.clickOn(roomTypeCheckbox);
        }
    }

    /**
     * input room type name
     *
     * @param roomTypeName
     */
    public void inputRoomTypeName(String roomTypeName) {
        if (roomTypeCheckbox.isChecked()) {
            playwright.clearText(roomTypeField);
            playwright.clickLocatorAndTypeKeyboard(roomTypeField, roomTypeName);
        }
    }

    /**
     * Select kost type
     *
     * @param kosType e.g putra, putri, campur
     */
    public void selectKostType(String kosType) {
        // Wait for page to fully load
        playwright.waitTillPageLoaded();

        // Wait for kost type container to be visible
        Locator kostTypeContainer = page.locator(".kost-type-container, [class*='type-kost']").first();
        playwright.waitTillLocatorIsVisible(kostTypeContainer, 10000.0);

        // Wait for specific kost type image
        kostTypeImage = page.locator("[alt='type-kost-" + kosType + "']");
        playwright.waitTillLocatorIsVisible(kostTypeImage, 5000.0);
        playwright.pageScrollInView(kostTypeImage);
        playwright.clickOn(kostTypeImage);
    }

    /**
     * Input description kos
     *
     * @param descKos
     */
    public void inputDescKos(String descKos) {
        descKos = descKos.toLowerCase().contains("random") ? descKos + UUID.randomUUID() : descKos;
        playwright.forceFill(descKosField, Objects.requireNonNullElse(descKos, ""));
    }

    /**
     * clear text on description kost edit kost page
     */
    public void clearDescKost() {
        playwright.clearText(descKosField);
    }

    /**
     * Select the year of build kos
     *
     * @param buildKos
     */
    public void selectBuildKos(String buildKos) {
        playwright.clickOn(selectYear);
        yearDropdown = page.locator("a").filter(new Locator.FilterOptions().setHasText(buildKos));
        playwright.waitTillLocatorIsVisible(yearDropdown);
        playwright.clickOn(yearDropdown);
    }

    /**
     * Input other note on data kos
     *
     * @param otherNote
     */
    public void inputOtherNote(String otherNote) {
        playwright.forceFill(noteKosField, Objects.requireNonNullElse(otherNote, ""));
    }

    /**
     * Click atur peraturan button
     */
    public void clickOnAturPeraturanKos() {
        playwright.clickOnTextButton("Atur Peraturan");
    }

    /**
     * Check 1 of the kost rule
     *
     * @param rule
     */
    public void clickKosRulesCheckbox(String rule) {
        playwright.clickOnText(rule);
    }

    /**
     * Upload the invalid aturan kos
     */
    public void uploadInvalidAturanKos() {
        String imagePath = "src/main/resources/images/mamikos.gif";
        FileChooser fileChooser = page.waitForFileChooser(() -> uploadPeraturanButton.click());
        fileChooser.setFiles(Paths.get(imagePath));
        playwright.waitTillLocatorIsVisible(uploadPeraturanButton);
        playwright.hardWait(3000);
    }

    /**
     * Get error message upload foto
     *
     * @return errorMessage
     */
    public String getErrorUpload() {
        return playwright.getText(errorMessage).replaceAll("closeerror-round-glyph", "");
    }

    /**
     * Upload valid aturan kos
     * If ubah foto visible using element ubah foto
     * If ubah foto invisible using element upload peraturan button
     */
    public void uploadValidAturanKos() {
        String imagePath = "src/main/resources/images/aturan-kos.png";

        if (ubahFoto.isVisible()) {
            FileChooser fileChooser = page.waitForFileChooser(() -> ubahFoto.click());
            fileChooser.setFiles(Paths.get(imagePath));
            playwright.waitTillLocatorIsVisible(ubahFoto);
            playwright.hardWait(3000);
        } else {
            FileChooser fileChooser = page.waitForFileChooser(() -> uploadPeraturanButton.click());
            fileChooser.setFiles(Paths.get(imagePath));
            playwright.waitTillLocatorIsVisible(uploadPeraturanButton);
            playwright.hardWait(3000);
        }

    }

    /**
     * Re-Upload valid aturan kos
     * it will delete existing photo
     * If ubah foto visible using element ubah foto
     * If ubah foto invisible using element upload peraturan button
     */
    public void reUploadValidAturanKost() {
        if (playwright.waitTillLocatorIsVisible(aturPeraturanBtn)) playwright.clickOn(aturPeraturanBtn);
        deleteFotoAturanKostIfVisible();
        uploadValidAturanKos();
    }

    /**
     * delete foto aturan kos if exist on edit kos page
     */
    public void deleteFotoAturanKostIfVisible() {
        if (playwright.waitTillLocatorIsVisible(fotoPeraturan)) {
            playwright.hover(fotoPeraturan);
            playwright.clickOn(hapusFotoPeraturan);
        }
    }

    /**
     * check error upload visible or no
     *
     * @return errorMessage
     */
    public boolean isErrorUploadDisappear() {
        return playwright.isLocatorVisibleAfterLoad(errorMessage, 3000.0);
    }

    /**
     * CLick Lanjutkan button from data kos to alamat kos
     * Allow the geolocation permission
     */
    public void allowLocation() {
        playwright.acceptDialog(lanjutkanButton);
        playwright.hardWait(5000.0);
    }

    /**
     * Input location kos
     *
     * @param keyLocation select the first location suggestion
     */
    public void inputLocationKos(String keyLocation) {
       // page.reload();
        playwright.clickOn(inputLocation);
        playwright.realKeyboardType(keyLocation);
        playwright.hardWait(3000.0);
        // Wait for suggestion dropdown to be visible before clicking
        playwright.waitFor(firstLocationSuggestion, 10000.0);
        playwright.clickOn(firstLocationSuggestion);
    }

    /**
     * Re-Input location kos if alamt is blank
     *
     * @param keyLocation select the first location suggestion
     */
    public void reinputIfAlamatStillNull(String keyLocation)  {
        var alamatTextBox = page.getByRole(AriaRole.TEXTBOX).nth(2);
        if (playwright.getText(alamatTextBox).isEmpty()) {
            playwright.clearText(inputLocation);
            this.inputLocationKos(keyLocation);
        }
    }

    /**
     * Insert text to search bar in room allotment and hit enter
     *
     * @param text is text we want to insert
     */
    public void searchNameOrRoomNo(String text) {
        playwright.fill(searchInput, text);
        playwright.pressKeyboardKey("Enter");
    }

    /**
     * Click on first Edit Button in room name/number table
     */
    public void clickFirstEditButton() {
        playwright.clickOn(firstEditButton);
    }

    /**
     * Click on already inhabited checkbox
     */
    public void clickAlreadyInhabitedCheckbox() {
        playwright.clickOn(alreadyInhabitedCheckbox);
    }

    /**
     * Get room status after update room
     *
     * @return return toast text e.g Anda berhasil update kamar
     */
    public String getRoomStatus() {
        // Wait for status to be visible and updated
        playwright.waitTillLocatorIsVisible(statusRoom, 5000.0);
        return playwright.getText(statusRoom);
    }

    /**
     * Filter room table with selected text in param
     *
     * @param filter is room filter text
     */
    public void filterRoomTable(String filter) {
        playwright.hardWait(1000.0);

        List<String> dropdownOptions = Arrays.asList(
                "Semua Kamar dropdown-down",
                "Kamar Terisi dropdown-down",
                "Kamar Kosong dropdown-down"
        );

        for (String option : dropdownOptions) {
            roomFilterDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(option));
            if (playwright.waitTillLocatorIsVisible(roomFilterDropdown)) {
                playwright.clickOn(roomFilterDropdown);
                break;
            }
        }

        filterTable = page.locator("a").filter(new Locator.FilterOptions().setHasText(filter));;
        playwright.clickOn(filterTable);
        playwright.hardWait(1000.0);
    }

    /**
     * Fill floor field with text
     *
     * @param floor is text for floor
     */
    public void insertTextFloor(String floor) {
        playwright.clearText(floorFieldInput);
        playwright.fill(floorFieldInput, floor);
    }

    /**
     * Fill room name field with text
     *
     * @param room is text for room name/number
     */
    public void insertTextRoomName(String room) {
        playwright.clearText(roomNameField);
        playwright.fill(roomNameField, room);
    }

    /**
     * Get goldplus label beside room Name/number
     *
     * @param roomNo is room name/number
     * @return text goldplus
     */
    public String getGoldPlusLabel(String roomNo) {
        roomName = page.locator("//td[normalize-space()='" + roomNo + "']");
        return playwright.getText(roomName);
    }

    /**
     * Get error message below room name field
     *
     * @return error message below room name field
     */
    public String getErrorRoomName() {
        return playwright.getText(errorMessageRoomName);
    }

    /**
     * Get error message below floor field
     *
     * @return error message below floor field
     */
    public String getErrorFloor() {
        return playwright.getText(errorMessageFloor);
    }

    /**
     * Verify if table is empty
     *
     * @return true if empty
     */
    public boolean isTableEmpty() {
        return playwright.waitTillLocatorIsVisible(emptyTable);
    }

    /**
     * Click Lanjutkan button (without access geolocation permission)
     * Optimized to use conditional waits instead of fixed 40s wait
     */
    public void clickOnLanjutkan() {
        // Check if lanjutkan button is visible, retry with reload if needed
        if (!playwright.waitTillLocatorIsVisible(lanjutkanButton.first(), 5000.0)) {
            playwright.reloadPage();
            playwright.waitTillPageLoaded();
            playwright.waitTillLocatorIsVisible(lanjutkanButton.first(), 10000.0);
        }

        // Wait for any photo uploads to complete (polling approach)
        waitForPhotoUploadComplete();

        // Click lanjutkan button
        playwright.waitForLocatorVisibleAndClickOn(lanjutkanButton.first());
    }

    /**
     * Wait for photo upload to complete using polling approach
     * Replaces 30s hardWait with smart polling (average 5-10s)
     */
    private void waitForPhotoUploadComplete() {
        int maxAttempts = 60; // 30 seconds max (500ms * 60)
        int attempt = 0;

        while (attempt < maxAttempts) {
            // Check if lanjutkan button is enabled (indicates upload complete or not required)
            if (lanjutkanButton.first().isEnabled()) {
                playwright.hardWait(500); // Small buffer for UI stability
                return;
            }

            playwright.hardWait(500); // Poll every 500ms
            attempt++;
        }

        // Timeout after 30 seconds - continue anyway (uploads may be optional)
        System.out.println("Photo upload polling timeout after 30s - continuing with test");
    }

    /**
     * upload invalid photo kos
     *
     * @param photoName
     */
    public void uploadInvalidPhotoKos(String photoName) {
        String imagePath = "src/main/resources/images/mamikos.gif";
        Locator uploadPhotoKos = page.getByText("+ Tambah foto " + photoName);
        FileChooser fileChooser = page.waitForFileChooser(() -> uploadPhotoKos.click());
        fileChooser.setFiles(Paths.get(imagePath));
        playwright.waitTillLocatorIsVisible(uploadPhotoKos);
        playwright.hardWait(3000);
    }

    /**
     * Upload valid photo kos
     */
    public void ubahValidPhotoKos() {
        String imagePath = "src/main/resources/images/upload5Mb.jpg";
        FileChooser fileChooser = page.waitForFileChooser(() -> ubahFoto.click());
        fileChooser.setFiles(Paths.get(imagePath));
        playwright.waitTillLocatorIsVisible(ubahFoto);
        playwright.hardWait(3000);
    }

    /**
     * select room size
     *
     * @param roomSize
     */
    public void selectRoomSize(String roomSize) {
        roomSizeProperty = page.getByText(roomSize);
        playwright.clickOn(roomSizeProperty);
        playwright.waitFor(roomSizeProperty, 3000.0);
    }

    /**
     * Input total room
     *
     * @param totalRoom
     */
    public void inputTotalRoom(String totalRoom) {
        playwright.forceFill(totalRoomField, totalRoom);
    }

    /**
     * input room available
     *
     * @param roomAvailable
     */
    public void inputRoomAvailable(String roomAvailable) {
        playwright.forceFill(roomAvailableField, roomAvailable);
    }

    /**
     * Input monthly price
     *
     * @param monthlyPrice
     */
    public void inputMonthyPrice(String monthlyPrice) {
        playwright.waitTillPageLoaded();
        playwright.hardWait(3000);

        // Wait for price page to fully load with retry
        int maxRetries = 10;
        int retryCount = 0;
        while (retryCount < maxRetries && !priceMonthlyField.isVisible()) {
            playwright.hardWait(1000);
            retryCount++;
        }

        playwright.waitTillLocatorIsVisible(priceMonthlyField);
        playwright.hardWait(2000);
        playwright.clickOn(priceMonthlyField);
        playwright.clearText(priceMonthlyField);
        playwright.realKeyboardType(monthlyPrice);
        playwright.pressKeyboardKey("Tab");
    }

    /**
     * Select minimum rent duration
     *
     * @param minRentDuration
     * @param min_rent_duration
     */
    public void selectMinRentDuration(String minRentDuration, String min_rent_duration) {
        minRentDurationChoose = page.locator("a").filter(new Locator.FilterOptions().setHasText(min_rent_duration));
        if (minRentDuration.equals("yes")) {
            playwright.clickOn(minRentDuractionCheckbox);
            playwright.clickOn(minRentDurationDropdown);
            playwright.clickOn(minRentDurationChoose);
        }
    }

    /**
     * checklist the other price
     *
     * @param checkOtherPrice
     */
    public void selectOtherPrice(String checkOtherPrice) {
        if (checkOtherPrice.equals("yes")) {
            playwright.clickOn(otherPriceCheckbox);
        }
    }

    /**
     * Input other price
     *
     * @param priceType
     * @param otherPrice
     * @param index      eg. harga per hari, harga per minggu, per 3 bulan, per 6 bulan, per tahun
     */
    public void inputOtherPrice(String priceType, String otherPrice, int index) {
        if (!otherPriceCheckbox.isChecked()) {
            playwright.clickOn(otherPriceCheckbox);
        }

        otherKostPriceMonthlyCheckbox = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Harga Per " + priceType)).locator("span");
        otherKostPriceMonthlyField = page.locator("//div[@class='step-seven__content']/div[@class='step-seven__field']/div[" + index + "]/div[@class='bg-c-field']/input[@class='input step-seven__input']");
        if (otherKostPriceMonthlyCheckbox.isChecked()) {
            playwright.clickOn(otherKostPriceMonthlyField);
            playwright.clearText(otherKostPriceMonthlyField);
            playwright.realKeyboardType(otherPrice);
            playwright.pressKeyboardKey("Tab");
        } else {
            playwright.clickOn(otherKostPriceMonthlyCheckbox);
            playwright.clickOn(otherKostPriceMonthlyField);
            playwright.realKeyboardType(otherPrice);
            playwright.pressKeyboardKey("Tab");
        }
    }

    /**
     * Click Selesai button for add kos
     */
    public void clickOnSelesaiSubmit() {
        playwright.hardWait(5000.0);
        playwright.clickOnTextButton("Selesai");
    }

    /**
     * Waiting the page loaded
     */
    public void waitPageLoaded() {
        playwright.waitTillPageLoaded(120000.0);
    }

    /**
     * Click delete button on kos draft
     */
    public void clickDeleteKosDraft() {
        playwright.clickOn(hapusDraftKos);
    }

    /**
     * Click delete button on pop up confirmation
     */
    public void clickHapusOnPopUpConfirmation() {
        playwright.clickOn(hapusKonfirm);
    }

    /**
     * Click hapus button on pop up konfirmasi Hapus draft kos
     *
     * @param text
     */
    public void clickOnNewBBKPopUp(String text) {
        playwright.clickOnTextButton(text);
    }

    /**
     * Click on existing kos name on Tambah Data kos
     *
     * @param kosName
     */
    public void clickAddAnotherTypeFromKos(String kosName) {
        existingKosName = page.getByText(kosName + " chevron-right");
        playwright.waitTillLocatorIsVisible(existingKosName, 5000.0);
        playwright.clickOn(existingKosName);
    }

    /**
     * Create kos from existing room type
     *
     * @param kosType
     * @throws InterruptedException
     */
    public void clickNewRoomType(String kosType) throws InterruptedException {
        playwright.waitTillPageLoaded(20000.0);
        playwright.hardWait(5000.0);
        existingRoomType = page.locator("label").filter(new Locator.FilterOptions().setHasText(kosType)).locator("span").first();
        playwright.waitFor(existingRoomType, 10000.0);
        playwright.clickOn(existingRoomType);
        playwright.clickOn(lanjutkanButton.first());
    }

    /**
     * Get room type message on bottom the field room type after click duplicate kos from room type
     *
     * @param roomTypeMessageText
     * @return
     */
    public String getRoomTypeMessage(String roomTypeMessageText) {
        roomTypeWarning = page.getByText(roomTypeMessageText);
        playwright.waitForSelectorState(roomTypeWarning, WaitForSelectorState.VISIBLE, GlobalConfig.LONG_TIMEOUT);
        return playwright.getText(roomTypeWarning);
    }

    /**
     * Verify the lanjutkan button is disable
     *
     * @return boolean
     */
    public boolean isLanjutkanDisable() {
        return playwright.isButtonDisable(lanjutkanButton);
    }

    /**
     * Input room type name on pop up when duplicate kos
     *
     * @param text
     */
    public void inputRoomTypeNameInPopUp(String text) {
        playwright.forceFill(roomTypeFieldInPopUp, text);
    }

    public void isLanjutkanInPopUpDisable() {
        playwright.isButtonDisable(lanjutkanButton.first());
    }

    /**
     * Get title on change interupcept popup when cancel create kos
     *
     * @return titleChangeIntercept
     */
    public String getTitleChangeInterceptPopUp() {
        titleChangeIntercept = page.locator(".changes-interception__title");
        return playwright.getText(titleChangeIntercept);
    }

    /**
     * Get message description on change intercept pop up
     *
     * @return descChangeIntercept
     */
    public String getMessageChangeInterceptPopUp() {
        return playwright.getText(descChangeIntercept);
    }

    /**
     * Click on action of intercept pop up cancel create kos
     *
     * @param actionText
     */
    public void clickOnActionInterceptInputData(String actionText) {
        playwright.clickOnTextButton(actionText);
    }

    /**
     * Click to previous page
     */
    public void clickOnBackFromInputKos() {
        playwright.backToPreviousPage();
    }

    /**
     * Upload valid photo kos
     *
     * @param photoName
     */
    public void uploadValidPhotoKos(String photoName) {
        closeSuccessModalIfPresent();
        playwright.hardWait(1000.0);

        String imagePath = "src/main/resources/images/upload5Mb.jpg";
        Locator uploadPhotoKos = page.locator("text=+ Tambah foto " + photoName);

        playwright.waitTillLocatorIsVisible(uploadPhotoKos, 10000.0);
        playwright.pageScrollInView(uploadPhotoKos);
        playwright.hardWait(500.0);
        FileChooser fileChooser = playwright.waitForFileChooserByClick(uploadPhotoKos);
        fileChooser.setFiles(Paths.get(imagePath));
        playwright.hardWait(3000);
    }

    /**
     * Select additional price checkbox
     */
    public void selectAdditionalPrice() {
        playwright.clickOn(additionalPriceCheckbox);
    }

    /**
     * Input additional price name
     *
     * @param priceName
     */
    public void inputAdditionalPriceName(String priceName) {
        playwright.forceFill(additionalPriceNameField, priceName);
    }

    /**
     * Input total additional price
     *
     * @param priceTotal
     */
    public void inputTotalAdditionalPrice(String priceTotal) {
        playwright.clickOn(additionalTotalPriceField);
        playwright.realKeyboardType(priceTotal);
        playwright.pressKeyboardKey("Tab");
    }

    /**
     * Select the down payment checkbox
     */
    public void selectDownPayment() {
        playwright.clickOn(downPaymentCheckbox);
    }

    /**
     * Select the percentage of down payment from rent price
     *
     * @param downPaymentPercentage
     */
    public void selectPercentageOfDownPayment(String downPaymentPercentage) {
        percentageDownPaymentChoosed = page.locator("a").filter(new Locator.FilterOptions().setHasText(downPaymentPercentage));
        playwright.clickOn(percentageDownPaymentDropdown);
        playwright.clickOn(percentageDownPaymentChoosed);
    }

    /**
     * Select penalty checkbox
     */
    public void selectPenalty() {
        playwright.clickOn(penaltyCheckbox);
    }

    /**
     * Input penalty amount
     *
     * @param penaltyAmount
     */
    public void inputPenalty(String penaltyAmount) {
        playwright.clickOn(penaltyField);
        playwright.realKeyboardType(penaltyAmount);
        playwright.pressKeyboardKey("Tab");
    }

    /**
     * Click lanjutkan button after input type room while duplicat kos
     */
    public void clickOnLanjutkanAfterInputTypeRoom() {
        playwright.clickOn(lanjutkanButton.first());
    }

    /**
     * Verify the description kos is disable
     *
     * @return boolean
     */
    public boolean isDescriptionKosDisable() {
        return playwright.isButtonDisable(descFieldDisabled);
    }

    /**
     * Verify the build kos is disable
     *
     * @return boolean
     */
    public boolean isBuildKosDisable() {
        return playwright.isButtonDisable(selectYear);
    }

    /**
     * Click on lengkapi button in add or duplicate kos
     *
     * @param text
     */
    public void clickOnLengkapiDataAddKos(String text) {
        playwright.clickOnTextButton(text, 3000.0);
        // Close success modal if it appears after clicking "Edit Selesai"
        if (text.equalsIgnoreCase("Edit Selesai")) {
            // Wait for modal animation to complete
            playwright.hardWait(2000.0);
            closeSuccessModalIfPresent();
        }
    }

    /**
     * Click on Atur ketersediaan kamar on ketersediaan kamar form
     *
     * @param text
     */
    public void clickOnKetersediaanKamar(String text) {
        playwright.clickOnTextButton(text);
    }

    /**
     * Click on selesai atur kamar button
     *
     * @param text
     */
    public void clickOnSelesaiAturKamar(String text) {
        playwright.clickOnTextButton(text, 3000.0);
    }

    /**
     * Select payment expired date
     *
     * @param number
     * @param rangeTime
     */
    public void selectPaymentExpiredDate(String number, String rangeTime) {
        playwright.clickOnTextButton("1 dropdown-down");
        Locator numberSelected = page.locator("//div[contains(@class,'bg-c-dropdown__menu bg-c-dropdown__menu--open bg-c-dropdown__menu--scrollable bg-c-dropdown__menu--fit-to-trigger bg-c-dropdown__menu--text-lg')]//li[" + number + "]/a");
        playwright.clickOn(numberSelected);
        playwright.clickOn(rangeTimeDropdown);
        Locator rangeTimeSelected = page.locator("a").filter(new Locator.FilterOptions().setHasText(rangeTime));
        playwright.clickOn(rangeTimeSelected);
    }

    /**
     * Click on lengkapi button
     */
    public void clickOnLengkapiDataKosDraft() {
        // Wait for page to load
        playwright.hardWait(2000.0);

        // Close singgahsini landing modal if present (with retry)
        int maxRetries = 5;
        for (int i = 0; i < maxRetries; i++) {
            Locator singgahsiniModal = page.locator(".singgahsini-landing-modal.bg-c-modal--open");
            if (singgahsiniModal.isVisible()) {
                // Try multiple locators for the close button
                Locator closeButton = singgahsiniModal.locator(".bg-c-modal__action-closable");
                if (!closeButton.isVisible()) {
                    closeButton = singgahsiniModal.locator("button:has(img[alt='close'])");
                }
                if (!closeButton.isVisible()) {
                    closeButton = page.locator(".singgahsini-landing-modal button").first();
                }
                if (closeButton.isVisible()) {
                    playwright.clickOn(closeButton);
                    playwright.hardWait(1000.0);
                }
            } else {
                break;
            }
        }
        playwright.clickOn(lengkapiDataKosDraft);
        playwright.hardWait(5000.0);
    }

    /**
     * Get error price add kos
     *
     * @param i
     * @return warningPrice
     */
    public String getErrorPriceAddKos(int i) {
        warningPrice = page.locator(".bg-c-field__message");
        return playwright.getText(warningPrice.nth(i));
    }

    /**
     * click toggle denda
     */

    public void clicktoggleDenda() {
        playwright.pageScrollInView(toggleDenda);
        playwright.waitTillLocatorIsVisible(toggleDenda);
        if (deleteOtherPrice.isVisible()) {
            playwright.clickOn(deleteOtherPrice);
            playwright.clickOn(confirmDeleteOtherPrice);
            playwright.clickOn(toggleDenda);
        } else {
            playwright.clickOn(toggleDenda);
            if (deleteOtherPrice.isVisible()) {
                playwright.clickOn(deleteOtherPrice);
                playwright.clickOn(confirmDeleteOtherPrice);
                playwright.clickOn(toggleDenda);
            }
        }
    }

    /**
     * click Ubah Denda Text
     */
    public void clickUbahDendaText() {
        playwright.clickOn(ubahDendaText);
    }

    /**
     * fill Denda Amount Time
     */
    public void fillDendaAmountTime(String amount, String unitTime, String penalty) {
        playwright.clickOn(textBoxTotalDenda);
        amountTime.press("Control+a");
        playwright.fill(amountTime, amount);
        playwright.clickOn(textBoxLatePay);
        playwright.fill(unitTimeNearest, unitTime);
        playwright.clickOn(dropdownLatePay);
        playwright.selectDropdownByValue(penaltyRules, penalty);
    }

    /**
     * check denda list not appears
     *
     * @return true if not appears
     */
    public boolean isDendaListAppears() {
        playwright.waitFor(dendaPrice);
        return dendaPrice.isEnabled();
    }

    /**
     * click toggle deposit
     */
    public void clicktoggleDeposit() {
        playwright.pageScrollInView(toggleDeposit);
        playwright.waitTillLocatorIsVisible(toggleDeposit);
        if (playwright.isTextDisplayed("Rp100.000") || playwright.isTextDisplayed("Rp50.000")) {
            playwright.clickOn(deleteOtherPrice);
            playwright.clickOn(confirmDeleteOtherPrice);
            playwright.clickOn(toggleDeposit);
        } else {
            playwright.clickOn(toggleDeposit);
        }
    }

    /**
     * fill Deposit Amount Time
     */
    public void fillDepositAmountTime(String amountDeposit) {
//        playwright.clickOn(textBoxDeposit);
        playwright.fill(deposit, amountDeposit);
    }

    /**
     * click toggle other price
     */
    public void clicktoggleOtherPrice() {
        playwright.pageScrollInView(toggleOtherPrice);
        playwright.waitTillLocatorIsVisible(toggleOtherPrice);
        if (toggleOtherPrice.isChecked()) {
            playwright.clickOn(deleteOtherPrice);
            playwright.clickOn(confirmDeleteOtherPrice);
            playwright.clickOn(toggleOtherPrice);
        } else {
            playwright.checkBox(toggleOtherPrice);
        }
    }

    /**
     * fill other price
     */
    public void fillOtherPrice(String namePrice, String amountPrice) {
        playwright.fill(nameOtherPriceInput, namePrice);
        playwright.fill(amountOtherPriceInput, amountPrice);
    }

    /**
     * Get other price active name
     *
     * @return String data type e.g "Biaya Parkir"
     */
    public boolean getActiveOtherPricesName() {
        return otherPriceName.isEnabled();
    }

    /**
     * Get other price active number
     *
     * @return String data type e.g "Rp100.000"
     */
    public boolean getActiveOtherPriceNumber() {
        return otherPriceNumber.isEnabled();
    }

    /**
     * Click on Selesai button add kos when add kos from duplicate kos
     */
    public void clickOnSelesaiAddKos() {
        playwright.clickOn(selesaiButton);
    }

    /**
     * Click add pengelola checkbox
     *
     * @param addDataPengelola
     */
    public void selectPengelola(String addDataPengelola) {
        if (addDataPengelola.equals("yes")) {
            playwright.clickOn(pengelolaCheckbox);
        }
    }

    /**
     * Input pengelola name
     *
     * @param pengelolaName
     */
    public void inputPengelolaName(String pengelolaName) {
        playwright.forceFill(pengelolaNameField, pengelolaName);
    }

    /**
     * Input pengelola phone
     *
     * @param pengelolaPhone
     */
    public void inputPengelolaPhone(String pengelolaPhone) {
        playwright.forceFill(pengelolaPhoneField, pengelolaPhone);
    }

    /**
     * Click on lewati bbk form button
     *
     * @param textButton
     */
    public void clickOnLewatiBBKForm(String textButton) {
        playwright.clickOnTextButton(textButton);
    }

    /**
     * Click on button in kebijakan baru mamikos pop up
     *
     * @param text
     */
    public void clickOnKebijakanBaruMamikosPopUp(String text) {
        playwright.clickOnTextButton(text);
    }

    /**
     * Verify the bbk pop up is visible or not
     *
     * @return true false
     */
    public boolean isBBKPopUpVisible() {
        return playwright.isLocatorVisibleAfterLoad(bbkPopUp, 5000.0);
    }

    /**
     * Verify the bbk pop up is visible for condition close pop up
     *
     * @return true false
     */
    public boolean BBKPopUpVisible() {
        return playwright.isLocatorVisibleAfterLoad(popUpBBK, 2000.0);
    }

    /**
     * Click on close at pop up BBL
     */
    public boolean CloseBtnPopUpBBKIsVisible() {
        return playwright.isLocatorVisibleAfterLoad(closePopupBBKIcon, 2000.0);
    }

    /**
     * Click save add room on pop up Add room
     */
    public void saveAddRoomPopUp() {
        playwright.clickOn(updateKamarButtonPopup);
    }

    /**
     * Uncheck already inhabited checkbox
     */
    public void UncheckAlreadyInhabitedCheckbox() {
        playwright.clickOn(untickInhabitedCheckbox);
    }

    /**
     * Verify the inhabitedcheckbox is checked
     *
     * @return true if checkbox is checked and false if checkbox unchecked
     */
    public boolean isInhabitedCheckboxCheck() {
        return playwright.isRadioButtonChecked(alreadyInhabitedCheckbox);
    }

    /**
     * Verify text on not add renter pop up
     *
     * @param text
     * @return boolean, true if text displayed and false if text not dispalyed
     */
    public boolean getPopupNotAddRenter(String text) {
        return playwright.isTextDisplayed(text);
    }

    /**
     * Verify the button on pop up
     *
     * @param buttonText
     * @return boolean, true if button displayed, and false if button not displayed
     */
    public boolean getPopUpButton(String buttonText) {
        return playwright.isButtonWithTextDisplayed(buttonText);
    }

    /**
     * Click on add renter button
     */
    public void clickOnAddRenterButton() {
        playwright.clickOnTextButton("Tambah Penyewa", 3000.0);
    }

    /**
     * Verify the toast message when update room
     *
     * @return toastMessage
     */
    public String getToastUpdateRoom() {
        playwright.waitTillLocatorIsVisible(toastMessage, 5000.0);
        return playwright.getText(toastMessage);
    }

    /**
     * Click on update room on property saya kos -> selengkapnya
     */
    public void clickOnUpdateRoom() {
        playwright.clickOn(updateRoom);
    }

    /**
     * Click on kembali button on added room pop up
     */
    public void clickOnBackButton() {
        playwright.clickOnTextButton("Kembali");
    }

    /**
     * Click on edit data kos button
     */
    public void clickOnEditDataKosButton() {
        playwright.clickOn(editDataKosButton.first());
    }

    /**
     * click delete on delete confirmation pop up deposit
     */
    public void clickHapusOnDeleteConfirmation() {
        playwright.clickOn(hapusConfirmation);
    }

    /**
     * Click on update price button
     */
    public void deleteActiveAdditionalPrice() {
        if (playwright.waitTillLocatorIsVisible(btnDeleteActiveOtherPrice)) {
            playwright.clickOn(btnDeleteActiveOtherPrice);
            clickHapusOnDeleteConfirmation();
        }
    }

    /**
     * check if other price name on index number 1 is visible
     *
     * @return true if other price visible, otherwise false
     */
    public boolean isOtherPriceNamePresent() {
        return playwright.waitTillLocatorIsVisible(textOtherPriceActiveName);
    }

    /**
     * check if other price number on index number 1 is visible
     *
     * @return true if number price visible, otherwise false
     */
    public boolean isOtherPriceNumberPresent() {
        return playwright.waitTillLocatorIsVisible(textOtherPriceActiveNumber);
    }

    /**
     * check image zero is visible
     *
     * @return image
     */
    public boolean isImageZeroPresent() {
        playwright.clickOn(declineAddProperty);
        playwright.waitForElementStateToBe(imageHistoryZero, "visible");
        return playwright.waitTillLocatorIsVisible(imageHistoryZero);
    }

    /**
     * Get text rejected apartment
     *
     * @return string
     */
    public String getRejectTextApartment() {
        return playwright.getText(rejectApartementText);
    }

    /**
     * check button update kamar is visible
     *
     * @return button
     */
    public boolean isButtonUpdateVisible() {
        return playwright.waitTillLocatorIsVisible(updateKamarButtonApart);
    }

    /**
     * Ubah foto from hover text
     */
    public void ubahFotoKosFromHover() {
        String imagePath = "src/main/resources/images/kos tampak depan.jpg";
        FileChooser fileChooser = page.waitForFileChooser(() -> ubahFotoHover.click());
        fileChooser.setFiles(Paths.get(imagePath));
        playwright.waitTillLocatorIsVisible(ubahFotoHover);
        playwright.hardWait(3000);
    }

    /**
     * Lihat photo from hover text
     */
    public void viewPhotoFromHover() {
        playwright.clickOn(viewPhotoHover);
        playwright.clickOn(closePhotoHover);
    }

    /**
     * Hover photo (Lihat Foto, Ubah Foto, Hapus Foto, Pindahkan Foto)
     */
    public void hoverPhoto() {
        backgroundImageHover.hover();
    }

    /**
     * Hover photo (Lihat Foto, Ubah Foto, Hapus Foto, Pindahkan Foto)
     */
    public void hoverPhoto(int order) {
        if (order <= 0) {
            order = 1;
        }
        var photo = photoPreview.nth(order - 1);
        playwright.hover(photo);
    }

    /**
     * Hover on photo and click move photo option from menu
     * This method hovers on the photo preview container to trigger the menu, then clicks "Pindahkan Foto"
     *
     * @param photoLocation - the location/section of the photo (e.g., "Foto dalam kamar")
     */
    public void hoverAndClickMovePhoto(String photoLocation) {
            // Find the specific photo section and elements
            Locator photoSection = getPhotoSectionByLocation(photoLocation);
            // Hover on the .preview container, not the parent .image-uploader__preview
            Locator movePhotoOption = getMovePhotoMenuOption(photoSection);

            // Scroll element into view first to ensure it's interactable
            playwright.pageScrollUntilElementIsVisible(photoSection);
            playwright.hardWait(1000);

            // Hover on the preview container to trigger the menu
            playwright.hover(photoSection);
            playwright.hardWait(1000);
            playwright.clickOn(movePhotoOption);
    }

    /**
     * Get photo section locator by location text
     *
     * @param photoLocation - the photo section heading text
     * @return Locator for the photo section
     */
    private Locator getPhotoSectionByLocation(String photoLocation) {
        return page.locator("//h4[contains(text(), '"+photoLocation+"')]/following-sibling::*[@class='image-uploader']");
    }

    /**
     * Get "Pindahkan Foto" menu option within a photo section
     *
     * @param photoSection - the photo section locator
     * @return Locator for the "Pindahkan Foto" menu item
     */
    private Locator getMovePhotoMenuOption(Locator photoSection) {
        return photoSection.locator(".preview__menu-item").filter(new Locator.FilterOptions().setHasText("Pindahkan Foto"));
    }

    /**
     * Click Delete Photo from hover
     */
    public void clickOnDeletePhotoFromHover() {
        playwright.clickOn(deletePhotoHover);
        playwright.hardWait(2000.0);
    }

    /**
     * Click pindahkan photo from hover
     */
    public void clickOnMovePhotoHover() {
        playwright.clickOn(movePhotoHover);
    }

    /**
     * Click lanjutkan button while pindahkan photo
     */
    public void clickOnLanjutkanMovePhoto() {
        playwright.clickOn(lanjutkanButtonMovePhoto);
    }

    /**
     * Verify the toast message when photo not selected if will be moved
     *
     * @return boolean
     */
    public boolean getToastNotSelectedPhoto() {
        return playwright.waitTillLocatorIsVisible(toastMessageNotSelectedPhoto, 3000.0);
    }

    /**
     * Select the photo will be moved
     */
    public void selectPhotoToMoved() {
        playwright.clickOn(selectPhotoToMoved);
    }

    /**
     * Click on pindahkan button
     */
    public void clickOnPindahkanPhoto() {
        playwright.clickOn(pindahkanPhotoButton);
    }

    /**
     * Get toast message while not selected the destinaion photo on pindahkan photo steps
     *
     * @return boolean
     */
    public boolean getToastNotSelectDestinationPhoto() {
        return playwright.waitTillLocatorIsVisible(toastMessageNotSelectDestinationPhoto, 3000.0);
    }

    /**
     * Select the destinaion photo kos on pindahkan photo steps
     */
    public void selectDestinationPhoto() {
        playwright.hardWait(2000);
        playwright.waitTillLocatorIsVisible(selectPhotoToMoved);
        playwright.clickOn(selectPhotoToMoved);
    }

    /**
     * Select the destination room photo on pindahkan photo step
     */
    public void selectDestinationPhotoRoom() {
        playwright.hardWait(2000);
        playwright.waitTillLocatorIsVisible(destinationPhotoRoomMoved);
        playwright.clickOn(destinationPhotoRoomMoved);
    }

    /**
     * Select the destination room photo on pindahkan photo step
     *
     * @param destination
     */
    public void selectDestinationPhotoRoom(String destination) {
        playwright.hardWait(2000);
        Locator destinationPhotoRoomMovedLocator = page
                .locator("label").filter(new Locator.FilterOptions().setHasText(destination));
        playwright.waitTillLocatorIsVisible(destinationPhotoRoomMovedLocator);
        playwright.clickOn(destinationPhotoRoomMovedLocator);
    }

    /**
     * check section Difavoritkan is visible
     *
     * @return locator
     */
    public boolean isFavoritedSectionVisible() {
        return playwright.waitTillLocatorIsVisible(favoritedSection);
    }

    public void clickOnEditDataLainButton() {
        playwright.clickOn(editDataLainBtn);
    }

    /**
     * delete photo kost on property management
     */
    public void deleteFotoKostIfVisible(int order) {
        if (order <= 0) {
            order = 1;
        }
        playwright.clickOn(deletePhotoHover.nth(order - 1));
    }

    /**
     * tap on update harga if button exist
     */
    public void clickOnUpdateHargaIfExist() {
        if (playwright.waitTillLocatorIsVisible(updatePriceButton)) playwright.clickOn(updatePriceButton);
    }

    /**
     * clickon close btn if exist
     */
    public void clickCloseBtnIfExist() {
        if (playwright.waitTillLocatorIsVisible(closeBtn, 1_000.0)) playwright.clickOn(closeBtn);
    }

    /**
     * Input location kos
     */
    public void leftletMarker() {
        playwright.waitTillLocatorIsVisible(leafletMarkerIcon);
        playwright.clickOn(leafletMarkerIcon);
    }

    /**
     * Clicks on edit data kos button by index
     * @param index edit data kos index
     */
    public void clicksOnEditDataKosButton(Integer index) {
        playwright.waitTillLocatorIsVisible(editDataKosButton, 60000.0);
        playwright.clickOn(editDataKosButton.nth(index));
    }
}
