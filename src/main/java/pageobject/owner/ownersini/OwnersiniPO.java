package pageobject.owner.ownersini;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import config.global.GlobalConfig;
import utilities.PlaywrightHelpers;

public class OwnersiniPO {
    private Page page;
    private PlaywrightHelpers playwright;

    //---Profil Top Right Corner P1---//
    private Locator skipFtueBtn;
    private Locator profilTopRightCornerP1;
    private Locator kembaliKeMamikosBtn;
    private Locator laporanKeuanganPage;

    //---Profil Top Right Corner P2---//
    private Locator profilTopRightCornerP2;
    private Locator dashboardSinggahsiniBtn;

    //---Left Side Menu---//
    private Locator profilPropertiChevron;
    private Locator profilMenu;

    //---Profil Menu Page---//
    private Locator profilPage;
    private Locator petaLokasi;
    private Locator facilitySection;
    private Locator kosRulesSection;
    private Locator biayaTambahanSection;
    private Locator informasiTambahanSection;
    private Locator propertyPhoto;
    private Locator lihatSemuaBtn;
    private Locator imageTitle;
    private Locator closePopUpImage;
    
    //---Tipe Kamar Menu Page---//
    private Locator tipeKamarMenu;
    private Locator roomListing;
    private Locator roomType;
    private Locator lihatSelengkapnyaBtn;
    private Locator lihatSemuaBtnInEveryRoomType;
    private Locator roomNumberInEveryRoomType;
    private Locator roomNumbers;
    private Locator roomPriceTitleInEveryRoomType;
    private Locator priceInEveryRoomType;
    private Locator roomAreaTitleInEveryRoomType;
    private Locator roomAreaValueInEveryRoomType;
    private Locator electricityInEveryRoomType;
    private Locator electricityValueInEveryRoomType;
    private Locator roomFacilityInEveryRoomType;
    private Locator roomFacilityValueInEveryRoomType;
    private Locator bathroomFacilityTitle;
    private Locator bathroomFacilityValueInEveryRoomType;
    private Locator tampilkanLebihSedikitBtn;
    private Locator propertyPhotoInEveryRoomType;

    public OwnersiniPO(Page page){
        this.page = page;
        playwright = new PlaywrightHelpers(page);

        //---Profil Top Right Corner P1---//
        skipFtueBtn = page.getByTestId("ss-ftue-button-0");
        profilTopRightCornerP1 = page.locator("#profile-trigger");
        kembaliKeMamikosBtn = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Kembali ke Mamikos"));
        laporanKeuanganPage = page.locator(".inner-container");

        //---Profil Top Right Corner P2---//
        profilTopRightCornerP2 = page.locator("//a[@class='c-mk-header__menu-item-link user-menu']");
        dashboardSinggahsiniBtn = page.getByText("Dashboard Singgahsini");

        //---Left Side Menu---//
        profilPropertiChevron = page.getByText("home-left-side-viewProfil Propertichevron-right").first();
        profilMenu = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Profil"));

        //---Profil Menu Page---//
        profilPage = page.locator("//p[@class='bg-c-text bg-c-text--body-2']");
        petaLokasi = page.locator("//a[@class='bg-c-link property-profile-card__property-link bg-c-link--high']");
        facilitySection = page.locator("(//*[@class='mb-4 bg-c-text bg-c-text--title-2'])[6]/following-sibling::*");
        kosRulesSection = page.locator(".property-profile-card__rules");
        biayaTambahanSection = page.locator("(//div[@class='bg-c-grid bg-c-grid--vtop bg-c-grid--left '])[5]//p");
        informasiTambahanSection = page.locator(".property-profile-card__info");
        propertyPhoto = page.locator("//div[@class='bg-c-grid__item bg-is-col-4']");
        lihatSemuaBtn = page.locator("(//button[contains(., 'Lihat Semua')])");
        imageTitle = page.locator("//h3[@class='bg-c-modal__body-title']");
        closePopUpImage = page.locator("[class='bg-c-modal__action-closable']");
        
        //---Tipe Kamar Menu Page---//
        tipeKamarMenu = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tipe Kamar"));
        roomListing = page.locator("//*[@class='property-room-card__room bg-c-card bg-c-card--lined bg-c-card--md bg-c-card--light']");
        lihatSelengkapnyaBtn = page.getByText("Lihat Selengkapnya chevron-down");
        roomNumbers = page.locator("//*[@class='bullet-list bullet-list__two-columns']");
        tampilkanLebihSedikitBtn = page.getByText("Tampilkan Lebih Sedikit chevron-up");
    }

    /**
     * Clicks Lewati on FTUE Ownersini
     */
    public void dismissFtueOwnersini(){
        playwright.clickOn(skipFtueBtn);
    }

    /**
     * Clicks on Profil on Top Right Corner on Pillar 1
     */
    public void clicksTopRightCornerProfilP1() {
        playwright.clickOn(profilTopRightCornerP1);
    }

    /**
     * Clicks on Kembali ke Mamikos on Profil
     */
    public void clicksKembaliKeMamikos() {
        playwright.clickOn(kembaliKeMamikosBtn);
    }

    /**
     * Clicks on Profil on Top Right Corner on Pillar 2
     */
    public void clicksTopRightCornerProfilP2(){
        playwright.waitTillLocatorIsVisible(profilTopRightCornerP2);
        playwright.clickOn(profilTopRightCornerP2);
    }

    /**
     * Clicks on Dashboard Singgahsini on Profil
     */
    public void clicksDashboardSinggahsini(){
        playwright.clickOn(dashboardSinggahsiniBtn);
        playwright.waitTillPageLoaded(GlobalConfig.DEFAULT_NAVIGATION_TIMEOUT);
        playwright.waitTillLocatorIsVisible(laporanKeuanganPage);
    }

    /**
     * Get String URL Owner Dashboard Pillar 2
     * @return String URL Owner Dashboard Pillar 2
     */
    public String getURLPillar2() {
        playwright.waitTillPageLoaded();
        return playwright.getPageUrl();
    }

    /**
     * Get String URL Owner Dashboard Pillar 1
     * @return String URL Owner Dashboard Pillar 1
     */
    public String getURLPillar1(){
        playwright.waitTillPageLoaded(GlobalConfig.DEFAULT_NAVIGATION_TIMEOUT);
        return playwright.getPageUrl();
    }

    /**
     * Clicks on Profil Property menu at Side bar menu
     */
    public void clicksProfilProperti() {
        playwright.clickOn(profilPropertiChevron);
    }

    /**
     * Clicks on Profil menu under Profil Property
     */
    public void clicksProfilMenu() {
        playwright.clickOn(profilMenu);
    }

    /**
     * Get String Nama Properti on Profil page
     * @return String Nama Properti on Profil page
     */
    public String getNamaProp() {
        return playwright.getText(profilPage.nth(1));
    }

    /**
     * Get String Alamat on Profil page
     * @return String Alamat on Profil page
     */
    public String getAlamat() {
        return playwright.getText(profilPage.nth(2));
    }

    /**
     * Get String Tipe Kamar on Profil page
     * @return String Tipe Kamar on Profil page
     */
    public String getTipeKamar() {
        return playwright.getText(profilPage.nth(3));
    }

    /**
     * Get String Tipe Kos on Profil page
     * @return String Tipe Kos on Profil page
     */
    public String getTipeKos() {
        return playwright.getText(profilPage.nth(4));
    }

    /**
     * Clicks on Lihat Peta Lokasi
     */
    public void clicksLocation() {
        playwright.clickOn(petaLokasi);
        playwright.bringPageToView(page);
    }

    /**
     * Check if Fasilitas Bersama is visible
     * check is Fasilitas Bersama visible
     * true means element Fasilitas Bersama is visible
     * false otherwise
     * @return Fasilitas Bersama
     */
    public boolean isFasBersamaVisible() {
        return playwright.isLocatorVisibleAfterLoad(facilitySection.nth(1), 10000.0);
    }

    /**
     * check is Fasilitas Parkir visible
     * true means element Fasilitas Parkir is visible
     * false otherwise
     * @return Fasilitas Parkir
     */
    public boolean isFasParkirVisible() {
        return playwright.waitTillLocatorIsVisible(facilitySection.nth(2));
    }

    /**
     * check is Fasilitas Dekat Kos visible
     * true means element Fasilitas Dekat is visible
     * false otherwise
     * @return Fasilitas Dekat
     */
    public boolean isFasDekatKosVisible() {
        return playwright.waitTillLocatorIsVisible(facilitySection.nth(3));
    }

    /**
     * check is Peraturan Kos visible
     * true means element Peraturan Kos is visible
     * false otherwise
     * @return Peraturan Kos
     */
    public boolean isKostRulesVisible() {
        return playwright.waitTillLocatorIsVisible(kosRulesSection);
    }

    /**
     * get String Biaya Tambahan ke satu on Profil page
     * @return String Biaya Tambahan
     */
    public String getBiayaTmbhn1() {
        return playwright.getText(biayaTambahanSection.first());
    }

    /**
     * get String Biaya Tambahan price ke satu on Profil page
     * @return String Biaya Tambahan price
     */
    public String getBiayaTmbhnPrice1() {
        return playwright.getText(biayaTambahanSection.nth(1));
    }

    /**
     * get String Biaya Tambahan ke dua on Profil page
     * @return String Biaya Tambahan
     */
    public String getBiayaTmbhn2() {
        return playwright.getText(biayaTambahanSection.nth(2));
    }

    /**
     * get String Biaya Tambahan price ke dua on Profil page
     * @return String Biaya Tambahan price
     */
    public String getBiayaTmbhnPrice2() {
        return playwright.getText(biayaTambahanSection.nth(3));
    }

    /**
     * get String Biaya Tambahan ke tiga on Profil page
     * @return String Biaya Tambahan price
     */
    public String getBiayaTmbhn3() {
        return playwright.getText(biayaTambahanSection.nth(4));
    }

    /**
     * get String Biaya Tambahan price ke tiga on Profil page
     * @return String Biaya Tambahan price
     */
    public String getBiayaTmbhnPrice3() {
        return playwright.getText(biayaTambahanSection.nth(5));
    }

    /**
     * check is Informasi Tambahan visible
     * true means element Informasi Tambahan is visible
     * false otherwise
     * @return Informasi Tambahan
     */
    public boolean isInfoTambahanVisible() {
        return playwright.isLocatorVisibleAfterLoad(informasiTambahanSection, 10000.0);
    }

    /**
     * Get total coloumn of property photo
     * @return total coloumn of property photo
     */
    public int getTotalCol() {
        return propertyPhoto.count();
    }

    /**
     * Check if Lihat Semua button on Property Photo is visible
     * @param i index ke - i
     * @return Lihat Semua button on Property Photo
     */
    public boolean isLihatSemuaVisible(int i) {
        return playwright.isLocatorVisibleAfterLoad(lihatSemuaBtn.nth(i), 10000.0);
    }

    /**
     * Check if Property Photo is visible
     * @param indexListing
     * @param indexBtn
     * @return Property Photo
     */
    public boolean isPropertyPhotoVisible(int indexListing, int indexBtn){
        propertyPhotoInEveryRoomType = page.locator("((//*[@class='property-room-card__room bg-c-card bg-c-card--lined bg-c-card--md bg-c-card--light'])[" +indexListing+ "]//button[contains(., 'Lihat Semua')])[" +indexBtn+ "]");
        return playwright.isLocatorVisibleAfterLoad(propertyPhotoInEveryRoomType, 10000.0);
    }

    /**
     * Click Lihat Semua button on Propery Photo
     * @param i index ke - i
     */
    public void clicksLihatSemua(int i) {
        playwright.clickOn(lihatSemuaBtn.nth(i));
    }

    /**
     * Get String Image Photo Title on Property Photo
     * @return Image Photo Title on Property Photo
     */
    public String getImageTitle() {
        return playwright.getText(imageTitle);
    }

    /**
     * Clicks Close button on Pop up Image at Property Photo
     */
    public void clicksClosePopUpImage() {
        playwright.clickOn(closePopUpImage);
    }

    /**
     * Clicks on Tipe Kamar menu under Profil Properti
     */
    public void clicksTipeKamarMenu() {
        playwright.clickOn(tipeKamarMenu);
    }

    /**
     * Get total Room Listing on Tipe Kamar page
     * @return total Room Listing
     */
    public int getTotalRoomListing() {
        return roomListing.count();
    }

    /**
     * Get String Room Type on Tipe Kamar page
     * @param i index ke - i
     * @return String Room Type
     */
    public String getRoomType(int i) {
        roomType = page.locator("(//p[@class='mb-16 bg-c-text bg-c-text--title-3'])[" +i+ "]");
        playwright.pageScrollInView(roomType);
        System.out.println(roomType);
        return playwright.getText(roomType);
    }

    /**
     * Clicks on Lihat Selengkapnya on Tipe Kamar page
     * @param i index ke - i
     */
    public void clicksLihatSelengkapnya(int i) {
        playwright.clickOn(lihatSelengkapnyaBtn.nth(i));
    }

    /**
     * Clicks on Lihat Semua in Room Type at Tipe Kamar page
     * @param indexListing
     * @param indexBtn
     */
    public void clicksLihatSemuaInRoomType(int indexListing, int indexBtn) {
        lihatSemuaBtnInEveryRoomType = page.locator("((//*[@class='property-room-card__room bg-c-card bg-c-card--lined bg-c-card--md bg-c-card--light'])[" +indexListing+ "]//button[contains(., 'Lihat Semua')])[" +indexBtn+ "]");
        playwright.pageScrollInView(lihatSemuaBtnInEveryRoomType);
        playwright.clickOn(lihatSemuaBtnInEveryRoomType);
    }

    /**
     * Get String Room Number title in Room Type
     * @param indexRoomNumber
     * @return String Room Number title
     */
    public String getRoomNumberTitle(int indexRoomNumber) {
        roomNumberInEveryRoomType = page.locator("(//p[contains(., 'Nomor Kamar')])["+indexRoomNumber+"]");
        playwright.pageScrollInView(roomNumberInEveryRoomType);
        return playwright.getText(roomNumberInEveryRoomType);
    }

    /**
     * Check if Room Number is visible on Tipe Kamar page
     * @param indexRoomNumber
     * @return Room Number
     */
    public boolean isRoomNumberVisible(int indexRoomNumber) {
        playwright.pageScrollInView(roomNumbers.nth(indexRoomNumber));
        return playwright.isLocatorVisibleAfterLoad(roomNumbers.nth(indexRoomNumber), 10000.0);
    }

    /**
     * Get String Room Price Title on Tipe Kamar page
     * @param indexHargaSewa
     * @return String Room Price Title
     */
    public String getRoomPriceTitle(int indexHargaSewa) {
        roomPriceTitleInEveryRoomType = page.locator("(//p[contains(., 'Harga Sewa Kamar')])["+indexHargaSewa+"]");
        playwright.pageScrollInView(roomPriceTitleInEveryRoomType);
        return playwright.getText(roomPriceTitleInEveryRoomType);
    }

    /**
     * Get String Price on Tipe Kamar page
     * @param indexListing
     * @param indexPrice
     * @return String Price
     */
    public String getPrice(int indexListing, int indexPrice) {
        priceInEveryRoomType = page.locator("((//*[@class='property-room-card__room bg-c-card bg-c-card--lined bg-c-card--md bg-c-card--light'])["+indexListing+"]//div[@class='item-list bg-c-grid__item bg-is-col-3'])["+indexPrice+"]");
        return playwright.getText(priceInEveryRoomType);
    }

    /**
     * Get String Room Area title on Tipe Kamar page
     * @param indexRoomArea
     * @return String Room Area title
     */
    public String getRoomAreaTitle(int indexRoomArea) {
        roomAreaTitleInEveryRoomType = page.locator("(//p[contains(., 'Luas Kamar')])["+indexRoomArea+"]");
        playwright.pageScrollInView(roomAreaTitleInEveryRoomType);
        return playwright.getText(roomAreaTitleInEveryRoomType);
    }

    /**
     * Check if Room Area Value is visible
     * @param indexListing
     * @return Room Area Value
     */
    public boolean isRoomAreaValue(int indexListing) {
        roomAreaValueInEveryRoomType = page.locator("(//*[@class='property-room-card__room bg-c-card bg-c-card--lined bg-c-card--md bg-c-card--light']//p[contains(., 'Luas Kamar')])[" +indexListing+ "]/following-sibling::*[1]");
        playwright.pageScrollInView(roomAreaValueInEveryRoomType);
        return playwright.isLocatorVisibleAfterLoad(roomAreaValueInEveryRoomType, 10000.0);
    }

    /**
     * Get String Electricity Title on Tipe Kamar page
     * @param indexElectricity
     * @return String Electricity Title
     */
    public String getElectricityTitle(int indexElectricity) {
        electricityInEveryRoomType = page.locator("(//section/p[contains(., 'Listrik')])["+indexElectricity+"]");
        playwright.pageScrollInView(electricityInEveryRoomType);
        return playwright.getText(electricityInEveryRoomType);
    }

    /**
     * Check if Electricity Value is visible on Tipe Kamar page
     * @param indexListing
     * @return Electricity Value
     */
    public boolean isElectricityValue(int indexListing) {
        electricityValueInEveryRoomType = page.locator("(//*[@class='property-room-card__room bg-c-card bg-c-card--lined bg-c-card--md bg-c-card--light']//p[contains(., 'Luas Kamar')])[" +indexListing+ "]/following-sibling::*[3]");
        playwright.pageScrollInView(electricityValueInEveryRoomType);
        return playwright.isLocatorVisibleAfterLoad(electricityValueInEveryRoomType, 10000.0);
    }

    /**
     * Get String Room Facility Title on Tipe Kamar page
     * @param indexListing
     * @return String Room Facility Title
     */
    public String getRoomFacilityTitle(int indexListing) {
        roomFacilityInEveryRoomType = page.locator("((//*[@class='property-room-card__room bg-c-card bg-c-card--lined bg-c-card--md bg-c-card--light'])["+indexListing+"]//p[contains(., 'Fasilitas')])[1]");
        playwright.pageScrollInView(roomFacilityInEveryRoomType);
        return playwright.getText(roomFacilityInEveryRoomType);
    }

    /**
     * Check if Room Facility Value is visible on Tipe Kamar page
     * @param indexListing
     * @return Room Facility Value
     */
    public boolean isRoomFacilityValue(int indexListing) {
        roomFacilityValueInEveryRoomType = page.locator("(//*[@class='property-room-card__room bg-c-card bg-c-card--lined bg-c-card--md bg-c-card--light']//p[contains(., 'Luas Kamar')])[" +indexListing+ "]/following-sibling::*[5]");
        playwright.pageScrollInView(roomFacilityValueInEveryRoomType);
        return playwright.isLocatorVisibleAfterLoad(roomFacilityValueInEveryRoomType, 10000.0);
    }

    /**
     * Get String Bathroom Facility Title on Tipe Kamar page
     * @param indexListing
     * @return String Bathroom Facility Title
     */
    public String getBathroomFacilityTitle(int indexListing) {
        bathroomFacilityTitle = page.locator("((//*[@class='property-room-card__room bg-c-card bg-c-card--lined bg-c-card--md bg-c-card--light'])["+indexListing+"]//p[contains(., 'Fasilitas')])[2]");
        playwright.pageScrollInView(bathroomFacilityTitle);
        return playwright.getText(bathroomFacilityTitle);
    }

    /**
     * Check if Bathroom Facility Value is visible on Tipe Kamar page
     * @param indexListing
     * @return Bathroom Facility Value
     */
    public boolean isBathroomFacilityValue(int indexListing) {
        bathroomFacilityValueInEveryRoomType = page.locator("(//*[@class='property-room-card__room bg-c-card bg-c-card--lined bg-c-card--md bg-c-card--light']//p[contains(., 'Luas Kamar')])[" +indexListing+ "]/following-sibling::*[7]");
        playwright.pageScrollInView(bathroomFacilityValueInEveryRoomType);
        return playwright.isLocatorVisibleAfterLoad(bathroomFacilityValueInEveryRoomType, 10000.0);
    }

    /**
     * Clicks on Tampilkan Lebih Sedikit on Tipe Kamar page
     */
    public void clicksTampilkanLebihSedikit() {
        playwright.clickOn(tampilkanLebihSedikitBtn);
    }

    /**
     * Check if Dashboard Singgahsini button is visible
     * True = visible
     * False = invisible
     * @return Dashboard Singgahsini button
     */
    public boolean isDashboardSinggahsiniBtnVisible(){
        return playwright.isLocatorVisibleAfterLoad(dashboardSinggahsiniBtn, 10000.0);
    }
}