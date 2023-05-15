package pageobject.owner;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;

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


    //Locator Mamifoto at Select Package
    Locator packageFirstMamifotoNonGP;
    Locator popUpDoesntHaveProperty;
    Locator addedNewKostPopUpButton;
    Locator nantiSajaButton;
    Locator headerPilihPaket;
    Locator backPilihPaketIcon;


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
        this.mamifotoInfoUntukAnda = page.locator("a").filter(new Locator.FilterOptions().setHasText("Sewa jasa foto & video profesional dari MamiFoto dan tingkatkan daya tarik kosan"));
        this.lihatPaketButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lihat Paket"));
        this.packageFirstMamifotoNonGP = page.getByTestId("select-mamifoto-package").first();
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

    }


    /**
     * Click on Fitur Promosi Sidebar menu
     */
    public void clickOnFiturPromosi() {
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
        return headerMamifoto.isVisible();
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
    public String getKinerjaTitle() throws InterruptedException {
        return playwright.getText(titleTingkatkanKinerja);
    }

    /**
     * Get subtitle at section kinerja kost
     *
     * @return string
     */
    public String getKinerjaSubTitle() throws InterruptedException {
        return playwright.getText(subtitleTingkatkanKinerja);
    }

    /**
     * Get Text Mamifoto at section Info Untuk Anda
     *
     * @return string
     */
    public String getMamifotoInfoUntukAndaText() throws InterruptedException {
        return playwright.getText(mamifotoInfoUntukAnda);
    }

    /**
     * Click on Mamifoto at section Info untuk Anda
     */
    public void clickOnMamifotoInfoUntukAnda() {
        mamifotoInfoUntukAnda.click();
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
    public void clickOnMamifotoPackageNonGPFirst() {
        packageFirstMamifotoNonGP.click();
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
    public String getMamifotoInfoUntukAndaNonPropertyText() throws InterruptedException {
        return playwright.getText(mamiFotoInfoUntukAndaNonProperty);
    }

    /**
     * Click on Mamifoto at section Info untuk Anda for non property
     */
    public void clickOnMamifotoInfoUntukAndaNonProperty() {
        mamiFotoInfoUntukAndaNonProperty.click();
    }

}
