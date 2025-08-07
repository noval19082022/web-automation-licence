package pageobject.common;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.JavaHelpers;
import utilities.PlaywrightHelpers;

import java.util.List;

public class KostLandingAreaPO {
    Page page;
    PlaywrightHelpers playwright;
    private Locator headingResultText;
    private Locator filterGender;
    private Locator filterHarga;
    private Locator filterInputMinimalPrice;
    private Locator filterInputMaximumPrice;
    private Locator filterPriceSimpanButton;
    private Locator kostRoomCard;
    private Locator nominatimMap;
    private Locator imgKosTidakDitemukan;
    private Locator headingNoKosInAreaText;
    private Locator subtitleNoKosInAreaText;
    private Locator nominatimEmptyList;
    private Locator lihatLebihBanyakButton;
    private Locator backToTopButton;
    private Locator areaText;
    private Locator cariBerdasarkanPetaButton;
    private Locator kosTidakDitemukanHeading;
    private Locator hapusSemuaFilterButton;
    private Locator sortButton;
    private Locator kosPrice;
    Locator dikelolaMamikosButton;
    Locator dikelolaMamikosToggle;
    Locator dikelolaMamikosLabel;
    private Locator sayaMengertiButton;

    //------ Recomendation Section------
    private Locator recommendationListTitle;
    private Locator mixGenderFilter;

    //----- EnaknyaNgekost LandingPage---
    private Locator fiturUnggulanBtn;
    private Locator mulaiCariKostBtn;
    private Locator openTheVideoThumbnail;
    private Locator playVideoBtn;
    private Locator videoIsOccur;
    private Locator videoIsPlayed;
    private Locator enaknyaNgekostBenefitsSection;
    private Locator loadMoreText;

    public KostLandingAreaPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        headingResultText = page.getByRole(AriaRole.HEADING).first();
        filterGender = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Semua Tipe Kos"));
        filterHarga = page.getByTestId("filter-price").getByText("Harga");
        filterInputMinimalPrice = page.getByRole(AriaRole.TEXTBOX).first();
        filterInputMaximumPrice = page.getByRole(AriaRole.TEXTBOX).nth(1);
        filterPriceSimpanButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Simpan"));
        kostRoomCard = page.getByTestId("kostRoomCard");
        nominatimMap = page.getByText("map Cari berdasarkan Peta Leaflet | © OpenStreetMap, Mamikos");
        imgKosTidakDitemukan = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("kos tidak ditemukan"));
        headingNoKosInAreaText = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Belum Ada Kos di Area Ini"));
        subtitleNoKosInAreaText = page.getByText("Cari di Area lain untuk meningkatkan hasil pencarian kos.");
        nominatimEmptyList = page.locator("div.nominatim-list__empty");
        lihatLebihBanyakButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lihat lebih banyak lagi"));
        backToTopButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("back-top"));
        areaText = page.locator("span.rc-info__location");
        cariBerdasarkanPetaButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cari berdasarkan Peta"));
        kosTidakDitemukanHeading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Kos Tidak Ditemukan"));
        hapusSemuaFilterButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Hapus semua filter"));
        sortButton = page.getByTestId("filter-kost-sorting");
        kosPrice = page.locator("span.rc-price__text");
        dikelolaMamikosButton = page.getByTestId("singgahsini-filter_btn");
        dikelolaMamikosToggle = page.locator("div").getByTestId("singgahsini-filter_tgl");
        dikelolaMamikosLabel = page.getByTestId("roomCardCover-brandIcon").first();
        this.recommendationListTitle = page.locator("//*[@id='app']/div/h1");
        this.mixGenderFilter = page.getByText("Campur").first();
        this.sayaMengertiButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Saya mengerti"));
        this.fiturUnggulanBtn = page.getByText("Fitur Unggulan");
        this.mulaiCariKostBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Mulai cari kos").setExact(true));
        this.openTheVideoThumbnail = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("video-glyph"));
        this.playVideoBtn = page.locator("#youtube-video-container");
        this.videoIsOccur = page.frameLocator("iframe[title=\"Rahasia \\#EnaknyaNgekos untuk semua\\!\"]").locator("video");
        this.videoIsPlayed = page.frameLocator("iframe[title=\"Rahasia \\#EnaknyaNgekos untuk semua\\!\"]").locator(".ytp-timed-markers-container");
        this.enaknyaNgekostBenefitsSection = page.locator("#enaknyangekosBenefits");
        loadMoreText = page.locator("//a[@class=\"list__content-load-link\"]");
    }

    /**
     * Check visibility of result heading text
     *
     * @return boolean
     */
    public String getResultHeadingText() {
        playwright.waitFor(headingResultText, 30000.0);
        playwright.hardWait(2000);
        return playwright.getText(headingResultText);
    }

    /**
     * Filter kost by price/harga
     *
     * @param minimal minimal price
     * @param maximal maximal price
     */
    public void filterByHarga(int minimal, int maximal) {
        playwright.clickOn(filterHarga);
        filterInputMinimalPrice.fill(String.valueOf(minimal));
        filterInputMaximumPrice.fill(String.valueOf(maximal));
        playwright.clickOn(filterPriceSimpanButton);
    }

    /**
     * Get all kost list locators
     *
     * @return List<Locator>
     */
    public List<Locator> getKostListLocator() {
        playwright.waitFor(kostRoomCard.first(), 30000.0);
        playwright.getLocators(kostRoomCard.first());
        playwright.waitFor(kostRoomCard.last(), 30000.0);
        playwright.getLocators(kostRoomCard.last());
        playwright.hardWait(2000);
        return kostRoomCard.all();
    }

    /**
     * Check visibility of nominatim map
     *
     * @return boolean
     */
    public boolean isNominatimMapVisible() {
        return playwright.waitTillLocatorIsVisible(nominatimMap);
    }

    /**
     * Check visibility of image banner kos tidak ditemukan
     *
     * @return boolean
     */
    public boolean isImageKosTidakDitemukanVisible() {
        playwright.waitFor(imgKosTidakDitemukan, 30000.0);
        return playwright.waitTillLocatorIsVisible(imgKosTidakDitemukan);
    }

    /**
     * Check visibility of wording "Belum Ada Kos di Area Ini".
     *
     * @return boolean
     */
    public boolean isNoKostInAreaHeadingTextVisible() {
        return playwright.waitTillLocatorIsVisible(headingNoKosInAreaText);
    }

    /**
     * Check visibility of wording "Cari di Area lain untuk meningkatkan hasil pencarian kos".
     *
     * @return boolean
     */
    public boolean isNoKostInAreaSubtitleTextVisible() {
        return playwright.waitTillLocatorIsVisible(subtitleNoKosInAreaText);
    }

    /**
     * Get text content of nominatim empty list
     *
     * @return List<String>
     */
    public List<String> getAllContentNominatimEmptyList() {
        nominatimEmptyList.textContent();
        return nominatimEmptyList.allTextContents();
    }

    /**
     * Check visibility of lihat lebih banyak lagi button visibility
     *
     * @return boolean
     */
    public boolean isLihatLebihBanyakButtonVisible() {
        page.setViewportSize(1280, 720);
        return playwright.waitTillLocatorIsVisible(lihatLebihBanyakButton);
    }

    /**
     * Check visibility of back to top button
     *
     * @return boolean
     */
    public boolean isBackToTopButtonVisible() {
        return playwright.waitTillLocatorIsVisible(backToTopButton);
    }

    /**
     * click on lihat lebih banyak button
     */
    public void clickOnLihatLebihBanyakButton() {
        if (!playwright.waitTillLocatorIsVisible(lihatLebihBanyakButton)) {
            playwright.pageScrollUntilElementIsVisible(lihatLebihBanyakButton);
        }
        playwright.clickOn(lihatLebihBanyakButton);
    }

    /**
     * Check availability of back to top button
     *
     * @return boolean
     */
    public boolean isBackToTopButtonEnabled() {
        return backToTopButton.isEnabled();
    }

    /**
     * Click on back to top button
     */
    public void clickOnBackToTopButton() {
        playwright.clickOn(backToTopButton);
    }

    /**
     * Get kos area text based on it index
     *
     * @param index desired index int data type
     * @return String
     */
    public String getKosAreaText(int index) {
        List<Locator> listArea = areaText.all();
        return playwright.getText(listArea.get(index));
    }

    /**
     * Get kos area size
     *
     * @return int data type
     */
    public int getKosAreaSize() {
        playwright.waitFor(areaText.first(), 30000.0);
        return areaText.all().size();
    }

    /**
     * Click on cari berdasarkan peta
     */
    public void clickOnCariBerdasarkanPeta() {
        playwright.clickOn(cariBerdasarkanPetaButton);
    }

    /**
     * Click on filter
     *
     * @param filter one of the available filter Dikelola Mamikos etc
     */
    public void clickOnFilter(String filter) {
        var filterButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(filter)).first();
        playwright.clickOn(filterButton);
        if (filter.toLowerCase().equals("dikelola mamikos")) {
            page.locator("div.singgahsini-filter__content").locator("input[type='checkbox']").click();
        }
    }

    /**
     * Check visibility kos tidak ditemukan heading
     *
     * @return boolean
     */
    public boolean isKosTidakDitemukanHeadingVisible() {
        playwright.waitFor(kosTidakDitemukanHeading, 30000.0);
        return playwright.waitTillLocatorIsVisible(kosTidakDitemukanHeading);
    }

    /**
     * Check visibility hapus semua filter button
     *
     * @return boolean
     */
    public boolean hapusSemuaFilterButtonVisible() {
        playwright.waitFor(hapusSemuaFilterButton, 30000.0);
        return playwright.waitTillLocatorIsVisible(hapusSemuaFilterButton);
    }

    /**
     * Set price sorting from cheaper to expensive or vise versa, or recommended kos
     *
     * @param sorting "Harga Termahal" or "Harga Termurah" or "Rekomendasi"
     */
    public void setPriceSortingFrom(String sorting) {
        Locator sortingFromButton = page.getByText(sorting);
        playwright.clickOn(sortButton);
        playwright.clickOn(sortingFromButton);
    }

    /**
     * Get kos price by index list
     *
     * @param index index of list
     * @return
     */
    public int getKostPrice(int index) {
        playwright.waitFor(kosPrice.last(), 30000.0);
        List<Locator> kosPriceList = kosPrice.all();
        return JavaHelpers.extractNumber(playwright.getText(kosPriceList.get(index)));
    }

    /**
     * Get kos price list size
     *
     * @return int data type
     */
    public int getKosPriceListSize() {
        playwright.waitFor(kosPrice.last(), 30000.0);
        return kosPrice.all().size();
    }

    /**
     * Click on filter Mamirooms button
     *
     * @throws InterruptedException
     */

    public void activateFilterDikelolaMamikos() throws InterruptedException {
        playwright.clickOn(dikelolaMamikosButton);
    }

    /**
     * Check if Singgahsini/Apik label is present
     *
     * @return displayed true, otherwise false
     */
    public boolean isDikelolaMamikosDisplayed() throws InterruptedException {
        return playwright.isLocatorVisibleAfterLoad(dikelolaMamikosButton, 2000.0);
    }


    /**
     * Get arround recommendation kos list Desc Text
     *
     * @return recomendation title in listing
     */
    public String getRecommendationKosList() {
        playwright.waitTillLocatorIsVisible(recommendationListTitle, 5000.0);
        playwright.pageScrollInView(recommendationListTitle);
        System.out.println(playwright.getText(recommendationListTitle));
        return playwright.getText(recommendationListTitle);
    }

    /**
     * Check Mix gender is displayed
     *
     * @return status true / false
     */
    public boolean isMixGenderDisplay() {
        return playwright.waitTillLocatorIsVisible(mixGenderFilter, 5000.0);
    }

    /**
     * click on saya mengerti button
     */
    public void clickOnSayaMengertiButton() {
        playwright.clickOn(sayaMengertiButton);
    }

    /**
     * open video on EnaknyaNgekost landingpage
     */
    public void openVideoThumbnail() {
        playwright.clickOn(openTheVideoThumbnail);
    }

    /**
     * play video button on EnaknyaNgekost landingpage
     */
    public void playVideoOnEnaknyaNgekosPage() {
        playwright.clickOn(playVideoBtn);
        playwright.waitTillPageLoaded();
        playwright.assertVisible(videoIsOccur);
        playwright.assertVisible(videoIsPlayed);
    }

    /**
     * scrool into Kenapa #EnaknyaNgekos? section on https://jambu.kerupux.com/enaknyangekos
     */
    public void scroolIntoSectionKenapaEnaknyaNgekos() {
        playwright.pageScrollInView(enaknyaNgekostBenefitsSection);
    }

    /**
     * check if Mulai Cari Kost Btn on the header is displayed
     * @return
     */
    public void mulaiCariKostBtnIsDisplayed() {
        playwright.assertVisible(mulaiCariKostBtn);
    }

    /**
     * open gender filter
     */
    public void clickOnGenderFilter() {
        playwright.clickOn(filterGender);
    }

    /**
     * click on fitur unggulan on the header on enaknya ngekos page
     */
    public void clickOnFiturUnggulan() {
        playwright.clickOn(fiturUnggulanBtn);
    }

    /**
     * click on product dan layanan on the header on enaknya ngekos page
     */
    public void clickOnProductDanLayanan() {
        playwright.clickOnText("Produk dan Layanan ");
    }

    /**
     * click on mulai cari kost on enaknya ngekos page
     */
    public void cickOnMulaiCariKosBtn() {
        playwright.clickOn(mulaiCariKostBtn);
    }

    /**
     * Set Harga termahal sorting
     */
    public void setSortingFromGreaterToLower(){
        playwright.clickOnText("Paling direkomendasikan");
        playwright.clickOnText("Harga tertinggi");
    }

    /**
     * Set Harga termurah sorting
     */
    public void setSortingFromLowerToGreater(){
        playwright.clickOnText("Paling direkomendasikan");
        playwright.clickOnText("Harga terendah");
    }

    public String getTotalSearchAreatext(String text){
        playwright.waitTillPageLoaded();
        Locator totalSearchAreatext = page.locator("//h2[contains(., '"+text+"')]");
        return playwright.getText(totalSearchAreatext);
    }

    public void clickLoadMore(){
        playwright.pageScrollInView(loadMoreText);
        playwright.clickOn(loadMoreText);
    }
}
