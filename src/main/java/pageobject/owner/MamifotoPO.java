package pageobject.owner;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;

import java.util.List;

public class MamifotoPO {
    private Page page;
    private PlaywrightHelpers playwright;
    private LocatorHelpers locatorHelpers;


    //Locator Mamifoto at owner dashboard
    Locator mamifotoMenuSidebar;
    Locator fiturPromosiSidebar;
    Locator homeOwnerSidebar;
    Locator titleTingkatkanKinerja;
    Locator subtitleTingkatkanKinerja;
    Locator sewaMamifoto;
    Locator mamifotoInfoUntukAnda;
    Locator mamiFotoInfoUntukAndaNonProperty;

    //Locator Mamifoto Landing Page
    Locator headerMamifoto;
    Locator lihatPaketButton;
    Locator bacaPanduan;
    Locator headerBacaPanduan;
    Locator closePopUpBacaPanduanIcon;
    Locator faqFirstList;
    Locator headerFAQ;
    Locator contentFAQfirstList;
    Locator riwayatPaketButton;
    Locator panduanAreaClick;
    Locator detailTitle;


    //Locator Mamifoto at Select Package
    Locator packageFirstMamifoto;
    Locator popUpDoesntHaveProperty;
    Locator addedNewKostPopUpButton;
    Locator nantiSajaButton;
    Locator headerPilihPaket;
    Locator backPilihPaketIcon;
    Locator headerDiscountGP;


    //Locator Mamifoto at history transaction
    Locator headerRiwayatPembelian;
    Locator tabSelesaiMamifoto;
    Locator succsesPaymentTextMamifoto;
    Locator seeDetailTransactionMamifoto;
    Locator seeDetailTransactionProphoto;
    Locator succsesPaymentTextProphoto;
    Locator tabDalamProsesMamifoto;
    Locator doesntHaveTransactionText;
    Locator doesntHaveTransactionDescText;
    Locator seeDetailTransactionExpired;
    Locator expiredPaymentMamifotoText;
    Locator lihatTagihanTableMamifoto;


    //Locator Mamifoto at Status Pembelian Page
    Locator headerStatusPembelian;
    Locator titleAlreadyPaid;
    Locator subTitleAlreadyPaid;
    Locator backIconPembelianMamifoto;
    Locator buttonHubungiKami;


    //Locator Invoice Expired Mamifoto
    Locator titleInvoiceExpired;
    Locator buttonBackInvoiceExpired;

    //Locator CS Web Mamikos
    Locator titleCSMamikos;

    //Locator Detail Tagihan Mamifoto
    Locator textDiscountGP;
    Locator priceDiscountGP;
    Locator buttonBayarSekarang;

    //Locator invoice mamifoto
    Locator headerInvoiceMamifoto;
    Locator textDiskonGPInvoiceMamifoto;
    Locator invoiceUnpaid;






    public MamifotoPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.locatorHelpers = new LocatorHelpers(page);
        this.mamifotoMenuSidebar = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("MamiFoto").setExact(true));
        this.headerMamifoto = page.getByTestId("mamifoto-landing-header").getByText("MamiFoto", new Locator.GetByTextOptions().setExact(true));
        this.fiturPromosiSidebar = page.getByText("Fitur Promosi");
        this.homeOwnerSidebar = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Home"));
        this.titleTingkatkanKinerja = page.getByText("Tingkatkan Kinerja Kos");
        this.subtitleTingkatkanKinerja = page.getByText("Lengkapi kos Anda dengan fitur berikut.");
        this.sewaMamifoto = page.locator("a").filter(new Locator.FilterOptions().setHasText("camera MamiFoto Sewa jasa foto kos profesional chevron-right"));
        this.mamifotoInfoUntukAnda = page.locator("a").filter(new Locator.FilterOptions().setHasText("Sewa jasa foto & video profesional dari Mami foto dan tingkatkan daya tarik kosan Anda!"));
        this.lihatPaketButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lihat Paket"));
        this.packageFirstMamifoto = page.getByTestId("select-mamifoto-package").first();
        this.popUpDoesntHaveProperty = page.getByText("Anda Belum Memiliki Properti Tambahkan properti terlebih dahulu.");
        this.addedNewKostPopUpButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tambah Kos"));
        this.nantiSajaButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Nanti Saja"));
        this.headerPilihPaket = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Pilih Paket"));
        this.backPilihPaketIcon = page.getByTestId("back-button");
        this.bacaPanduan = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Baca Panduan"));
        this.headerBacaPanduan = page.getByText("Panduan persiapan foto/video");
        this.closePopUpBacaPanduanIcon = page.getByTestId("mamifoto-landing-guides-modal").getByRole(AriaRole.BUTTON);
        this.headerFAQ = page.getByText("Tanya Jawab");
        this.faqFirstList = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Jenis foto apa saja yang akan saya dapat?"));
        this.contentFAQfirstList = page.getByText("Tergantung dari jenis paket yang dipilih, Anda bisa mendapatkan foto landscape f");
        this.mamiFotoInfoUntukAndaNonProperty = page.locator("a").filter(new Locator.FilterOptions().setHasText("Sewa jasa foto & video profesional dari Mami foto dan tingkatkan daya tarik kosa"));
        this.riwayatPaketButton =  page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Riwayat Paket"));
        this.headerRiwayatPembelian = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Riwayat Pembelian"));
        this.tabSelesaiMamifoto = page.locator("//a[contains(.,'Selesai')]");
        this.succsesPaymentTextMamifoto = page.getByText("MamiFoto A Non GP Pembayaran Berhasil");
        this.seeDetailTransactionMamifoto =  page.getByRole(AriaRole.BUTTON).nth(1);
        this.headerStatusPembelian = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Status Pembelian"));
        this.titleAlreadyPaid =  page.getByText("Pembayaran Telah Lunas");
        this.subTitleAlreadyPaid = page.getByText("Dalam 3 hari kerja, Anda akan dihubungi untuk membuat janji dengan fotografer. J");
        this.backIconPembelianMamifoto = page.getByTestId("back-button");
        this.seeDetailTransactionProphoto = page.getByRole(AriaRole.BUTTON).nth(0);
        this.succsesPaymentTextProphoto = page.getByText("Pro Photo Pembayaran Berhasil");
        this.tabDalamProsesMamifoto = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Dalam Proses"));
        this.doesntHaveTransactionText = page.getByText("Belum Ada Transaksi");
        this.doesntHaveTransactionDescText = page.getByText("Transaksi yang masih dalam proses akan muncul di halaman ini.");
        this.expiredPaymentMamifotoText =  page.getByText("MamiFoto A GP Kadaluwarsa").first();
        this.seeDetailTransactionExpired = page.getByText("Lihat Detail Transaksi").first();
        this.titleInvoiceExpired = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Invoice Kedaluwarsa"));
        this.buttonBackInvoiceExpired = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Kembali"));
        this.buttonHubungiKami =  page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Hubungi Kami"));
        this.titleCSMamikos =  page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Mamikos CS"));
        this.headerDiscountGP = page.getByText("Diskon member GoldPlus");
        this.textDiscountGP =  page.getByText("Diskon member GoldPlus Hanya berlaku untuk member GoldPlus");
        this.priceDiscountGP = page.locator(".mamifoto-payment-detail__discount");
        this.buttonBayarSekarang =  page.getByTestId("mamifoto-button-pay");
        this.headerInvoiceMamifoto = page.locator("//div[@id='invoiceNameWrapperMamifoto']");
        this.textDiskonGPInvoiceMamifoto =  page.getByText("Diskon member GoldPlus");
        this.lihatTagihanTableMamifoto= page.locator("//div[.='MamiFoto A Non GP Menunggu Pembayaran']");
        this.panduanAreaClick = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Panduan area & fasilitas"));
        this.invoiceUnpaid = page.locator("//div[@id='mamifoto-history-on-progress']//button").first();
    }


    /**
     * Click on Fitur Promosi Sidebar menu
     */
    public void clickOnFiturPromosi() {
        playwright.waitTillPageLoaded();
        fiturPromosiSidebar.click();
    }

    /**
     * Click on Home Owner Sidebar menu
     */
    public void clickOnHomeMenuOwner() {
        homeOwnerSidebar.click();
    }

    /**
     * Click on Mamifoto Sidebar menu
     */
    public void clickOnMamifotoSidebar() {
        mamifotoMenuSidebar.click();
    }


    /**
     * Check Mamifoto Header is appear
     *
     * @return boolean type, appear true otherwise false
     */
    public boolean mamifotoHeaderLandingPageisAppear() {
        return playwright.isLocatorVisibleAfterLoad(headerMamifoto,2000.0);
    }

    /**
     * Click on Mamifoto at section tingkatkan kinerja kos
     */
    public void clickOnSewaMamifoto() {
        sewaMamifoto.click();
    }

    /**
     * Get Title at section kinerja kost
     *
     * @return string
     */
    public String getKinerjaTitle() {
        return playwright.getText(titleTingkatkanKinerja);
    }

    /**
     * Get subtitle at section kinerja kost
     *
     * @return string
     */
    public String getKinerjaSubTitle()  {
        return playwright.getText(subtitleTingkatkanKinerja);
    }

    /**
     * Get Text Mamifoto at section Info Untuk Anda
     *
     * @return string
     */
    public String getMamifotoInfoUntukAndaText()  {
        return playwright.getText(mamifotoInfoUntukAnda);
    }

    /**
     * Click on Mamifoto at section Info untuk Anda
     */
    public void clickOnMamifotoInfoUntukAnda() {
        playwright.clickOn(mamifotoInfoUntukAnda);
    }

    /**
     * Click on button Lihat Paket
     */
    public void clickOnLihatPaket() {
        lihatPaketButton.click();
    }

    /**
     * Click on package mamifoto non GP first list
     */
    public void clickOnMamifotoPackageFirst() {
        packageFirstMamifoto.click();
    }

    /**
     * Get Pop Up doesnt have property
     *
     * @return pop up is appear
     */
    public boolean getPopUpDoesntHaveProperty() {
        return popUpDoesntHaveProperty.isVisible();
    }

    /**
     * Get button Tambah Kos at pop up doesnt have property
     *
     * @return button added new kost is appear
     */
    public boolean getAddedNewKostPopUpButton() {
        return addedNewKostPopUpButton.isVisible();
    }

    /**
     * Get button Nanti Saja at pop up doesnt have property
     *
     * @return button Nanti Saja is appear
     */
    public boolean getNantiSajaButton() {
        return nantiSajaButton.isVisible();
    }

    /**
     * Click on nanti saja button
     */
    public void clickOnNantiSajaButton() {
        nantiSajaButton.click();
    }

    /**
     * Check Lihat Paket Mamifoto Header is appear
     *
     * @return boolean type, appear true otherwise false
     */
    public boolean mamifotoHeaderSelectPackageisAppear() {
        return headerPilihPaket.isVisible();
    }

    /**
     * Click on back icon at select package
     */
    public void clickOnBackSelectPackage() {
        backPilihPaketIcon.click();
    }


    /**
     * Click on Baca Panduan Mamifoto
     */
    public void clickOnBacaPanduan() {
        bacaPanduan.scrollIntoViewIfNeeded();
        bacaPanduan.click();
    }

    /**
     * Check Baca Panduan header is appear
     *
     * @return boolean type, appear true otherwise false
     */
    public boolean mamifotoHeaderBacaPanduanisAppear() {
        return headerBacaPanduan.isVisible();
    }

    /**
     * Click on icon close pop up Baca Panduan
     */
    public void clickOnCloseBacaPanduan() {
        closePopUpBacaPanduanIcon.click();
    }


    /**
     * Click on first list FAQ
     */
    public void clickOnFirstListFAQ() {
        headerFAQ.scrollIntoViewIfNeeded();
        faqFirstList.click();
    }

    /**
     * Check content text FAQ is appear
     *
     * @return boolean type, appear true otherwise false
     */
    public boolean contentFirstFAQisAppear() {
        return contentFAQfirstList.isVisible();
    }

    /**
     * Get Text Mamifoto at section Info Untuk Anda for non property
     *
     * @return string
     */
    public String getMamifotoInfoUntukAndaNonPropertyText()  {
        return playwright.getText(mamiFotoInfoUntukAndaNonProperty);
    }

    /**
     * Click on Mamifoto at section Info untuk Anda for non property
     */
    public void clickOnMamifotoInfoUntukAndaNonProperty() {
        mamiFotoInfoUntukAndaNonProperty.click();
    }


    /**
     * Click on button Riwayat Paket
     */
    public void clickOnRiwayatPaketMamifoto() {
        riwayatPaketButton.click();
    }

    /**
     * Check Mamifoto History Transaction Header is appear
     *
     * @return boolean type, appear true otherwise false
     */
    public boolean mamifotoHeaderHistoryisAppear() {
        playwright.waitTillDomContentLoaded(5000.0);
        return headerRiwayatPembelian.isVisible();
    }

    /**
     * Click on tab selesai at riwayat page mamifoto
     */
    public void clickOnTabSelesaiMamifoto() {
        tabSelesaiMamifoto.click();
    }

    /**
     * Get Text status transaction succsess
     *
     * @return string
     */
    public String getSuccsessTransactioMamifotoText()  {
        return playwright.getText(succsesPaymentTextMamifoto);
    }

    /**
     * Click on Lihat detail transaksi at riwayat page mamifoto
     */
    public void clickOnSeeDetailTransactionMamifoto() {
        Locator element = page.locator("//div[@id='mamifoto-history-done']//button");
        List<Locator> elements = playwright.getLocators(element);
        elements.get(1).click();
    }

    /**
     * Check Mamifoto Status Pembelian Header is appear
     *
     * @return boolean type, appear true otherwise false
     */
    public boolean mamifotoHeaderStatusPembelianisAppear() {
        return headerStatusPembelian.isVisible();
    }

    /**
     * Get Text Title Status Pembelian Page
     *
     * @return string
     */
    public String getStatusPembelianTitleText() {
        return playwright.getText(titleAlreadyPaid);
    }

    /**
     * Get Text Sub Title Status Pembelian Page
     *
     * @return string
     */
    public String getStatusPembelianSubTitleText()  {
        return playwright.getText(subTitleAlreadyPaid);
    }

    /**
     * Get URL
     * @return url is equal
     */
    public String getURL() {
        return page.url();
    }


    /**
     * Click on Hubungi Kami button and check redirection
     */
    public void clickOnContactUsMamifoto() {

        page.waitForPopup(() -> {
            buttonHubungiKami.click();
        });

        titleCSMamikos.isVisible();
    }

    /**
     * Click on Lihat detail transaksi at riwayat page prophoto
     */
    public void clickOnSeeDetailTransactionProphoto() {
        this.seeDetailTransactionProphoto = page.locator("//div[@id='mamifoto-history-done']//button");
        List<Locator> elements = playwright.getLocators(seeDetailTransactionProphoto);
        elements.get(1).click();
    }

    /**
     * Click on icon back at pembayaran berhasil page
     */
    public void clicOnIconBackSuccsessPaymentMamifoto() {
        backIconPembelianMamifoto.click();
    }

    /**
     * Get Text status transaction succsess old prophoto
     *
     * @return string
     */
    public String getSuccsessTransactioProphotoText(){
        return playwright.getText(succsesPaymentTextProphoto);
    }

    /**
     * Get Text doesnt have transaction mamifoto at tab dalam proses
     *
     * @return string
     */
    public String getDoesntHaveTransactionText(){
        return playwright.getText(doesntHaveTransactionText);
    }

    /**
     * Get Text doesnt have transaction desc mamifoto at tab dalam proses
     *
     * @return string
     */
    public String getDoesntHaveTransactionDescText(){
        return playwright.getText(doesntHaveTransactionDescText);
    }

    /**
     * Click on tab dalam proses mamifoto
     */
    public void clicOnTabDalamProsesMamifoto() {
        tabDalamProsesMamifoto.click();
    }

    /**
     * Click on lihat detail transaksi expired
     */
    public void clicOnDetailTransactionExpired() {
        seeDetailTransactionExpired.click();
    }

    /**
     * Get Text Transaction expired mamifoto
     *
     * @return string
     */
    public String getTextTransactionMamifotoExpired() {
        return playwright.getText(expiredPaymentMamifotoText);
    }

    /**
     * Get Text Transaction expired mamifoto
     *
     * @return string
     */
    public String getTextInvoiceExpiredTitle() {
        return playwright.getText(titleInvoiceExpired);
    }

    /**
     * Click on button back at invoice kadaluarsa page
     */
    public void clickOnButtonBackInvoiceExpired() {
        buttonBackInvoiceExpired.click();
    }

    /**
     * Get Text Header Discount Member GP
     *
     * @return string
     */
    public String getTextHeaderDiscountMemberGP() {
        return playwright.getText(headerDiscountGP);
    }

    /**
     * Get Text discount member Gp at detail tagihan page
     *
     * @return string
     */
    public String getTextDiscountMemberGPDetailTagihan() {
        return playwright.getText(textDiscountGP);
    }

    /**
     * Get Text discount amount Gp at detail tagihan page
     *
     * @return string
     */
    public String getTextDiscountAmountGPDetailTagihan() {
        return playwright.getText(priceDiscountGP);
    }

    /**
     * Click on button bayar sekarang
     */
    public void clickOnButtonBayarSekarangMamifoto() {
        playwright.clickOn(buttonBayarSekarang);
    }

    /**
     * Check Mamifoto Invoice Header is appear
     *
     * @return boolean type, appear true otherwise false
     */
    public boolean mamifotoHeaderInvoiceisAppear() {
        playwright.waitTillLocatorIsVisible(headerInvoiceMamifoto,3000.0);
        return headerInvoiceMamifoto.isVisible();
    }

    /**
     * Get Text discount Gp at invoice page
     *
     * @return string
     */
    public String getTextDiscountGPInvoiceMamifoto() {
        return playwright.getText(textDiskonGPInvoiceMamifoto);
    }

    /**
     * Check Diskon Mamifoto Header is appear
     *
     * @return boolean type, appear true otherwise false
     */
    public boolean mamifotoHeaderDiscountGP() {
        return headerDiscountGP.isVisible();
    }

    /**
     * Check discount member Gp at detail tagihan page
     *
     *  @return boolean type, appear true otherwise false
     */
    public boolean discountMemberGPDetailTagihan() {
        return textDiscountGP.isVisible();
    }

    /**
     * check discount amount Gp at detail tagihan page
     *
     * @return boolean type, appear true otherwise false
     */
    public boolean discountAmountGPDetailTagihan() {
        return priceDiscountGP.isVisible();
    }

    /**
     * check discount Gp at invoice page
     *
     * @return string
     */
    public boolean discountGPInvoiceMamifoto() {
        playwright.waitTillLocatorIsVisible(textDiskonGPInvoiceMamifoto,3000.0);
        return textDiskonGPInvoiceMamifoto.isVisible();
    }

    /**
     * Get unpaid invoice Mamifoto
     * @return int, count of unpaid invoice Mamifoto
     *
     */
    public int getCountMamifotoInvoiceUnpaid() {
        return playwright.getLocators(lihatTagihanTableMamifoto).size();
    }

    /**
     * Click on Lihat detail transaksi at first riwayat page
     */
    public void clickOnSeeFirstDetailTransaction() {
        invoiceUnpaid.click();
        playwright.waitTillPageLoaded();
    }

    /**
     * Check unpaid Invoice Mamifoto
     * return true or false
     */
    public boolean checkUnpaidInvoiceMamifoto(){
        return playwright.waitTillLocatorIsVisible(invoiceUnpaid);
    }
    /**
     * Click on button bayar sekarang
     */
    public void clickOnPanduanArea() {
        playwright.clickOn(panduanAreaClick);
    }

    /**
     * Check title and detail title On Panduan Persiapan Foto or Video
     * @return boolean type, appear true otherwise false
     */
    public boolean titleOnPanduanAndAreaAppear(String titleAndDetailText) {
        detailTitle = page.getByText(titleAndDetailText);
        playwright.waitTillLocatorIsVisible(detailTitle);
        return playwright.waitTillLocatorIsVisible(detailTitle);
    }

}

