package pageobject.owner;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.JavaHelpers;
import utilities.PlaywrightHelpers;

public class MamiPoinOwnerPO {
    private Page page;
    private PlaywrightHelpers playwright;
    Locator mamipointLandingPageOnboardingTooltipText;
    Locator nextButton;
    Locator rewardHistoryOnBoarding;
    Locator pointHistoryOnBoarding;
    Locator termAndConditionOnBoarding;
    Locator redeemPointOnBoarding;
    Locator finishButton;
    Locator lihatStatusButton;
    Locator berhasilStatusText;
    Locator mamipoinWidgetText;
    Locator mamipoinOwnerText;
    Locator mamipoinToggle;
    Locator discountMamipoinText;
    Locator titleMamipoinOwnerLandingPage;
    Locator tukarPoinButton;
    Locator riwayatHadiahButton;
    Locator riwayatPoinButton;
    Locator syaratDanKetentuanButton;
    Locator poinAndaOnboarding;
    Locator hadiahBisaDitukarOnboarding;
    Locator bantuanOnboarding;
    Locator selesaiButton;
    Locator titleTukarPoinPage;
    Locator logoTukarPoinPage;
    Locator bantuanButton;

    public MamiPoinOwnerPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        mamipointLandingPageOnboardingTooltipText = page.getByText("Ini adalah jumlah poin Anda saat ini yang dapat Anda tukarkan dengan berbagai ha");
        nextButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Selanjutnya"));
        rewardHistoryOnBoarding = page.getByText("Cek seluruh hadiah yang telah Anda tukarkan dengan poin Anda di sini.");
        pointHistoryOnBoarding = page.getByText("Semua poin yang didapat dan aktivitas yang telah dilakukan tercatat di sini.");
        termAndConditionOnBoarding = page.getByText("Pelajari cara-cara untuk mendapatkan poin di bagian ini.");
        redeemPointOnBoarding = page.getByText("Anda dapat menukar poin Anda dengan hadiah di bagian ini.");
        finishButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Oke"));
        lihatStatusButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lihat Status"));
        berhasilStatusText = page.locator("//span[.='Berhasil']");
        mamipoinWidgetText = page.locator(".fadeInDown");
        mamipoinOwnerText = page.locator(".info-count");
        mamipoinToggle =  page.getByRole(AriaRole.CHECKBOX);
        discountMamipoinText = page.locator(".discount-text");
        titleMamipoinOwnerLandingPage = page.locator("//div[@class='c-navigation__title'][contains(.,'MamiPoin')]");
        tukarPoinButton = page.locator("//div[@class='c-mk-card exchange-card__card']");
        riwayatHadiahButton = page.locator("//*[@href='javascript:void(0)'][contains(.,'Riwayat Hadiah')]");
        riwayatPoinButton = page.locator("//*[@href='javascript:void(0)'][contains(.,'Riwayat Poin')]");
        syaratDanKetentuanButton = page.locator("//*[@href='javascript:void(0)'][contains(.,'Syarat dan Ketentuan')]");
        poinAndaOnboarding = page.locator("//p[@class='message'][contains(text(),'Pastikan poin Anda cukup untuk')]");
        hadiahBisaDitukarOnboarding = page.locator("//p[@class='message'][contains(text(),'Anda dapat menukar poin Anda')]");
        bantuanOnboarding = page.locator("//p[@class='message'][contains(text(),'Tekan tombol Bantuan untuk')]");
        selesaiButton = page.locator("//button[@type='button'][contains(.,'Selesai')]");
        titleTukarPoinPage = page.locator("//strong[@class='link-text'][contains(.,'Menu MamiPoin')]");
        logoTukarPoinPage = page.locator("//img[@class='mamipoin-image']");
        bantuanButton = page.locator("//button[@type='button'][@class='button faq-button is-rounded --desktop']");

    }

    /**
     * Get MamiPoin Landing Page Onboarding Text
     *
     * @return text of mamipoin landing page onboarding
     */
    public String getMamiPoinLandingPageOnboardingText(){
        return playwright.getText(mamipointLandingPageOnboardingTooltipText);
    }

    /**
     * Click on Next Button on MamiPoin landing Page Onboarding
     *
     */
    public void clickOnNextButton() {
        playwright.clickOn(nextButton);
    }

    /**
     * Get MamiPoin Reward History Onboarding Text
     *
     * @return text of mamipoin landing page onboarding
     */
    public String getRewardHistoryOnboardingText(){
        return playwright.getText(rewardHistoryOnBoarding);
    }

    /**
     * Get MamiPoin Point History Onboarding Text
     *
     * @return text of mamipoin landing page onboarding
     */
    public String getPointHistoryOnboardingText(){
        return playwright.getText(pointHistoryOnBoarding);
    }

    /**
     * Get MamiPoin Term and Condition Onboarding Text
     *
     * @return text of mamipoin landing page onboarding
     */
    public String getTermAndConditionOnboardingText(){
        return playwright.getText(termAndConditionOnBoarding);
    }

    /**
     * Get MamiPoin Redeem Point Onboarding Text
     *
     * @return text of mamipoin landing page onboarding
     */
    public String getRedeemPointOnboardingText(){
        return playwright.getText(redeemPointOnBoarding);
    }

    /**
     * Click on Finish Button on MamiPoin landing Page Onboarding
     *
     */
    public void clickOnFinishButton() {
        playwright.clickOn(finishButton);
    }

    /**
     * Click button lihat status on riwayat hadiah
     *
     */
    public void clickOnLihatStatusRiwayatHadiah() {
        playwright.clickOn(lihatStatusButton);
    }

    /**
     * Verify Berhasil Detail Status
     * @return string data type
     */
    public String getDetailStatusText(){
        return playwright.getText(berhasilStatusText);
    }

    /**
     * Get value mamipoin from widget mamipoin owner
     *
     * @return integer mamipoin owner
     */
    public int getMamipoinWidgetText(){
        return JavaHelpers.extractNumber(playwright.getText(mamipoinWidgetText));
    }

    /**
     * Get value from mamipoin owner
     *
     * @return integer mamipoin owner
     */
    public int getMamipoinOwnerText(){
        return JavaHelpers.extractNumber(playwright.getText(mamipoinOwnerText));
    }

    /**
     * Click toggle mamipoin
     *
     */
    public void clickOnMamiPoinToggle() {
        playwright.hardWait(3000);
        playwright.pageScrollUntilElementIsVisible(mamipoinToggle);
        playwright.clickOn(mamipoinToggle);
    }

    /**
     * Get text total potongan mamipoin
     * @return int total potongan mamipoin
     */
    public int getTotalDiscountMamipoinText() {
        return JavaHelpers.extractNumber(playwright.getText(discountMamipoinText));
    }

    /**
     * Verify title in the mamipoin owner landing page is displayed
     * @return boolean
     */
    public Boolean isTitleInTheMamipoinOwnerLandingPageDisplayed() {
        return playwright.waitTillLocatorIsVisible(titleMamipoinOwnerLandingPage);
    }

    /**
     * Verify tukar poin button is displayed
     * @return boolean
     */
    public Boolean isTukarPoinButtonDisplayed() {
        return playwright.waitTillLocatorIsVisible(tukarPoinButton);
    }

    /**
     * Verify riwayat hadiah button is displayed
     * @return boolean
     */
    public Boolean isRiwayatHadiahButtonDisplayed() {
        return playwright.waitTillLocatorIsVisible(riwayatHadiahButton);
    }

    /**
     * Verify riwayat poin button is displayed
     * @return boolean
     */
    public Boolean isRiwayatPoinButtonDisplayed() {
        return playwright.waitTillLocatorIsVisible(riwayatPoinButton);
    }

    /**
     * Verify riwayat poin button is displayed
     * @return boolean
     */
    public Boolean isSyaratDanKetentuanButtonDisplayed() {
        return playwright.waitTillLocatorIsVisible(syaratDanKetentuanButton);
    }

    /**
     * Click on tukar poin button

     */
    public void clickOnTukarPoinButton() {
        playwright.clickOn(tukarPoinButton);
    }

    /**
     * Get Poin Anda Onboarding Text
     *
     * @return text of poin anda onboarding
     */
    public String getPoinAndaOnboardingText(){
        return playwright.getText(poinAndaOnboarding);
    }

    /**
     * Get Hadiah Bisa Ditukar Onboarding Text
     *
     * @return text of hadiah bisa ditukar onboarding
     */
    public String getHadiahBisaDitukarOnboardingText(){
        return playwright.getText(hadiahBisaDitukarOnboarding);
    }

    /**
     * Get Bantuan Onboarding Text
     *
     * @return text of bantuan onboarding
     */
    public String getBantuanOnboardingText(){
        return playwright.getText(bantuanOnboarding);
    }

    /**
     * Click on Selesai Button on Tukar Poin Page Onboarding
     *
     */
    public void clickOnSelesaiButton()  {
        playwright.clickOn(selesaiButton);
    }

    /**
     * Verify title in the tukar poin page is displayed
     * @return boolean
     */
    public Boolean isTitleInTheTukarPoinPageDisplayed() {
        return playwright.waitTillLocatorIsVisible(titleTukarPoinPage);
    }

    /**
     * Verify logo in the tukar poin page is displayed
     * @return boolean
     */
    public Boolean isLogoInTheTukarPoinPageDisplayed() {
        return playwright.waitTillLocatorIsVisible(logoTukarPoinPage);
    }

    /**
     * Verify the amount of Mamipoin Anda
     * @return amount of poin
     * @param poin
     */
    public String verifyAmountOfMamipoinAnda(String poin) {
        return playwright.getText(page.locator("//strong[@class='info-total'][contains(text(),'"+ poin +"')]"));
    }

    /**
     * Verify bantuan button is displayed
     * @return boolean
     */
    public Boolean isBantuanButtonDisplayed() {
        return playwright.waitTillLocatorIsVisible(bantuanButton);
    }
}
