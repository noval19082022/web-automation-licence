package pageobject.tenant.profile;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class SinggahsiniPlusPO {
    private Page page;
    private PlaywrightHelpers playwright;

    // Locator
    private Locator singgahsiniPlusTierMessage;
    private Locator singgahsiniPlusSummaryCard;
    private Locator singgahsiniText;
    private Locator rewardPoinText;
    private Locator mamiPoinText;
    private Locator introductionTierText;
    private Locator newLabelText;
    private Locator labelActiveTier;
    private Locator allertPausedText;
    private Locator tierActiveText;
    private Locator starterLevelText;
    private Locator mamiPoinLink;
    private Locator mamipoinCardTierBarTitle;
    private Locator tierDescriptionText;
    private Locator mamipoinMenuText;
    private Locator modalWrapper;
    private Locator okeMengertiButton;
    private Locator tierActiveText1;
    private Locator tierActiveText2;
    private Locator singgahsiniCardKostSaya;
    private Locator singgahsiniPlusCardText;
    private Locator invoiceSSText1;
    private Locator invoiceSSText2;
    private Locator singgahsiniPassedTier;
    private Locator passedDescriptiontext;
    private Locator lihatPoinInfoText;
    private Locator riwayatPoinText;
    private Locator dapatkanPoinText;
    private Locator syaratDanKetentuanText;

    public SinggahsiniPlusPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);

        this.singgahsiniPlusTierMessage = page.getByTestId("singgahsiniPlusSummaryCard-tierMessage");
        this.singgahsiniPlusSummaryCard = page.getByTestId("singgahsiniPlusSummaryCard");
        this.singgahsiniText = page.getByTestId("singgahsiniPlusSummaryCard-ssPlusTitle");
        this.rewardPoinText = singgahsiniPlusSummaryCard.getByText("Reward & Poin");
        this.mamiPoinText = singgahsiniPlusSummaryCard.getByText("MamiPoin");
        this.introductionTierText = page.getByTestId("singgahsiniPlusMainDescription");
        this.starterLevelText = page.getByText("Singgahsini+ Level: Starter");
        this.mamiPoinLink = page.locator("a").filter(new Locator.FilterOptions().setHasText("MamiPoin"));
        this.mamipoinCardTierBarTitle = page.getByTestId("ssPlusMamipoinCardTierBarTitle");
        this.tierDescriptionText = page.getByText("Ngekos lama, levelnya naik,");
        this.modalWrapper = page.locator(".bg-c-modal__wrapper");
        this.okeMengertiButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Oke, Mengerti"));
        this.singgahsiniCardKostSaya = page.getByTestId("singgahsiniPlusCard");
        this.okeMengertiButton = page.locator("//button[@class=\"bg-c-button bg-c-button--secondary bg-c-button--lg bg-u-theme-singgahsini\"]");
        this.singgahsiniPassedTier = page.locator(" div:nth-child(1) > div.singgahsini-plus-main__tiers-stepper");
        this.lihatPoinInfoText = page.getByTestId("ssPlusMamipoinCardPointInfoLink");
        this.riwayatPoinText = page.getByTestId("ssPlusMamipoinHistoryLink");
        this.dapatkanPoinText = page.getByTestId("ssPlusMamipoinGuidelineLink");
        this.syaratDanKetentuanText = page.locator("#contentBox").getByText("Syarat dan Ketentuan");
    }

    /**
     * get new label "baru
     * return text
     */
    public String getNewlabelText(String text){
        newLabelText = page.locator("//*[@class=\"singgahsini-plus-summary-card__pill\"]/*[contains(text(),'"+text+"')]");
        return playwright.getText(newLabelText);
    }

    /**
     * tier message on profile is visible or not
     * @return text
     */
    public boolean isTierMessageVisible() {
        return playwright.waitTillLocatorIsVisible(singgahsiniPlusTierMessage);
    }

    public boolean getLabelActiveTierText(String text){
        labelActiveTier = page.locator("//*[@data-testid=\"singgahsiniPlusSummaryCard\"]//*[contains(text(),'"+text+"')]");
        return playwright.waitTillLocatorIsVisible(labelActiveTier);
    }

    /**
     * click on Singgahsini plus button
     */
    public void clickSinggahsiniPlusText() {
        playwright.clickOn(singgahsiniText);
    }

    /**
     * tier message description on singgahsini page is visible
     */
    public boolean isTierDescriptionVisible(){
        return playwright.waitTillLocatorIsVisible(introductionTierText);
    }

    /**
     * verify allert paused is visible
     * @param text
     * @return text
     */
    public boolean isAllertPausedVisible(String text){
        allertPausedText = page.locator("//*[@class=\"bg-c-text bg-c-text--body-4\"][contains(text(),'"+text+"')]");
        return playwright.waitTillLocatorIsVisible(allertPausedText);
    }

    /**
     * verify active tier on profile page is visible
     * checks all 3 tier text locators and returns true if any contains the expected text
     * @param text expected tier text to verify
     * @return true if any of the 3 locators is visible and contains the text
     */
    public boolean isTierActiveVisible(String text){
        tierActiveText = page.locator(".singgahsini-plus-main__tiers-item--active p").first();
        tierActiveText1 = page.locator(".singgahsini-plus-main__tiers-item--active p").nth(1);
        tierActiveText2 = page.locator(".singgahsini-plus-main__tiers-item--active p").last();

        // Check if any of the 3 locators is visible and contains the expected text
        boolean isFirstVisible = playwright.waitTillLocatorIsVisible(tierActiveText) &&
                                playwright.getText(tierActiveText).contains(text);
        boolean isSecondVisible = playwright.waitTillLocatorIsVisible(tierActiveText1) &&
                                 playwright.getText(tierActiveText1).contains(text);
        boolean isThirdVisible = playwright.waitTillLocatorIsVisible(tierActiveText2) &&
                                playwright.getText(tierActiveText2).contains(text);
        handleLevelUpPopup();
        return isFirstVisible || isSecondVisible || isThirdVisible;
    }

    /**
     * verify locked tiers are visible
     * checks up to 7 locked tier locators
     * @return true if all locked tiers are visible
     */
    public boolean isLockedTierVisible(){
        boolean allVisible = true;
        for (int i = 0; i < 7; i++) {
            Locator lockedTier = page.locator(".singgahsini-plus-main__tiers-item--locked").nth(i);
            if (!playwright.waitTillLocatorIsVisible(lockedTier)) {
                allVisible = false;
                break;
            }
        }
        return allVisible;
    }

    /**
     * click on reward poin menu
     */
    public void clickRewardPoin() {
        playwright.clickOn(rewardPoinText);
    }

    /**
     * Click on Mamipoin on Singgahsini page
     */
    public void clickMamiPoin() {
        playwright.clickOn(mamiPoinText);
    }

    /**
     * Validate singgahsini plis summary card
     * @return is true
     */
    public boolean isSinggahsiniPlusSummaryCardVisible() {
        return playwright.waitTillLocatorIsVisible(singgahsiniPlusSummaryCard);
    }

    /**
     * validate reward poin text is visible
     * @return reward poin
     */
    public boolean isRewardPoinTextVisible() {
        return playwright.waitTillLocatorIsVisible(rewardPoinText);
    }

    /**
     * validate mamipoin text is visible
     * @return mamipoin
     */
    public boolean isMamiPoinTextVisible() {
        return playwright.waitTillLocatorIsVisible(mamiPoinText);
    }

    /**
     * click on Singgahsini+ Level: Starter text
     */
    public void clickStarterLevelText() {
        playwright.clickOn(starterLevelText);
    }

    /**
     * click on MamiPoin link
     */
    public void clickMamiPoinLink() {
        // Handle level up popup if it appears
        handleLevelUpPopup();
        playwright.clickOn(mamiPoinLink);
    }

    /**
     * Handle level up popup that might appear
     */
    private void handleLevelUpPopup() {
        if (playwright.waitTillLocatorIsVisible(modalWrapper, 3000.0)) {
            if (playwright.waitTillLocatorIsVisible(okeMengertiButton, 2000.0)) {
                playwright.clickOn(okeMengertiButton);
                playwright.waitTillLocatorIsNotVisible(modalWrapper, 1000.0, 5);
            }
        }
    }

    /**
     * click on mamipoin card tier bar title
     */
    public void clickMamipoinCardTierBarTitle() {
        playwright.clickOn(mamipoinCardTierBarTitle);
    }

    /**
     * verify mamipoin card tier bar title is visible
     * @return is visible
     */
    public boolean isMamipoinCardTierBarTitleVisible() {
        return playwright.waitTillLocatorIsVisible(mamipoinCardTierBarTitle);
    }

    /**
     * verify tier description text is visible
     * @return is visible
     */
    public boolean isTierDescriptionTextVisible(String text) {
        tierDescriptionText = page.locator("//em[contains(text(),'"+text+"')]");
        return playwright.waitTillLocatorIsVisible(tierDescriptionText);
    }

    /**
     * verify poin menu on mamipoin page
     * @return text is visible
     */
    public boolean isMamipoinMenutextVisible(String text){
        mamipoinMenuText = page.locator("//p[contains(text(),'"+text+"')]");
        return playwright.waitTillLocatorIsVisible(mamipoinMenuText);
    }

    /**
     * verify text in singgahsini plus card is visible
     * @param text expected text to verify
     * @return true if text is visible in singgahsini plus card
     */
    public boolean isSinggahsiniPlusCardTextVisible(String text){
        singgahsiniPlusCardText = page.locator("//*[@data-testid='singgahsiniPlusCard']//*[contains(text(),'"+text+"')]");
        return playwright.waitTillLocatorIsVisible(singgahsiniPlusCardText);
    }

    /**
     * click on singgahsini card on kost saya page
     */
    public void clickSinggahsiniCardKostSaya(){
        playwright.clickOn(singgahsiniCardKostSaya);
    }


    /**
     * verify invoice singgahsini level is visible
     * checks both invoice text locators
     * @return true if both invoice level texts are visible
     */
    public boolean isInvoiceSSLevel(){
        invoiceSSText1 = page.locator(".invoice-singgahsini-plus-level p").first();
        invoiceSSText2 = page.locator(".invoice-singgahsini-plus-level p").last();

        boolean isFirstVisible = playwright.waitTillLocatorIsVisible(invoiceSSText1);
        boolean isSecondVisible = playwright.waitTillLocatorIsVisible(invoiceSSText2);
        playwright.hardWait(10000);
        return isFirstVisible && isSecondVisible;
    }

    /**
     * validated passed tier is visible
     * @return tier passed
     */
    public boolean isPassedTierVisible(){
        handleLevelUpPopup();
        return playwright.waitTillLocatorIsVisible(singgahsiniPassedTier, 10000.0);
    }

    /**
     * validated description passed tier is visble
     * @param text
     * @return text example :Level 1 sudah terlewati. Kumpulkan lebih banyak poin di level berikutnya!
     */
    public boolean passedDescriptionTextVisible(String text){
        passedDescriptiontext = page.locator("//p[contains(text(),'"+text+"')]");
        return playwright.waitTillLocatorIsVisible(passedDescriptiontext);
    }

    /**
     * click on MamiPoin card point info link
     */
    public void clickLihatPoinInfoText() {
        playwright.clickOn(lihatPoinInfoText);
    }

    /**
     * click on MamiPoin history link
     */
    public void clickRiwayatPoinText() {
        playwright.clickOn(riwayatPoinText);
    }

    /**
     * click on MamiPoin guideline link
     */
    public void clickDapatkanPointText() {
        playwright.clickOn(dapatkanPoinText);
    }

    /**
     * verify MamiPoin card point info link is visible
     * @return true if visible
     */
    public boolean isLihatPoinInfoTextVisible() {
        return playwright.waitTillLocatorIsVisible(lihatPoinInfoText);
    }

    /**
     * verify MamiPoin history link is visible
     * @return true if visible
     */
    public boolean isRiwayatPoinTextVisible() {
        return playwright.waitTillLocatorIsVisible(riwayatPoinText);
    }

    /**
     * verify MamiPoin guideline link is visible
     * @return true if visible
     */
    public boolean isDapatkanPointextVisible(String text) {
        return playwright.waitTillLocatorIsVisible(syaratDanKetentuanText);
    }

}