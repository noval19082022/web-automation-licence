package pageobject.owner.mamiads;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;

public class MamiAdsPO {
    private Page page;
    private PlaywrightHelpers playwright;
    private LocatorHelpers locatorHelpers;
    //--- Saldo Mamiads Onboarding ---//
    private Locator saldoMamiadsCard;
    //--- Mamiads Page ---//
    private Locator cobaSekarangBtnOnPopUp;
    private Locator beliSaldoBtn;
    private Locator titleEmptyFilterText;
    private Locator messageEmptyFilterText;
    private Locator paduanMamiadsBackButton;
    private Locator cobaSekarangButtonHeader;
    //--- Beli Saldo Mamiads Page ----//
    private Locator bayarSekarangBtnOnDetailTagihan;

    //--- GP Onboarding Pop - Up ---//
    Locator gpOnboardingPopUpActiveCounter;
    Locator gpOnboardingPopUpActiveTextHead;
    Locator gpOnboardingPopUpActiveTextBody;
    Locator gpOnboardingPopUpActiveImage;
    Locator gpOnboardingPopUpNextButton;
    Locator gpOnboardingPopUpSwipperBullet;
    Locator gpOnboardingPopUpPreviousButton;
    //--- GP Onboarding Pop - Up ---//

    public MamiAdsPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.locatorHelpers = new LocatorHelpers(page);
        //--- Saldo Mamiads Onboarding ---//
        this.saldoMamiadsCard = page.locator(".mamiads-card");
        //--- Mamiads Page ---//
        this.cobaSekarangBtnOnPopUp = playwright.locatorByRoleAndText(AriaRole.BUTTON, "Coba Sekarang");
        this.beliSaldoBtn = page.getByText("Beli Saldo");
        this.titleEmptyFilterText = page.locator(".bg-c-empty-state__title");
        this.messageEmptyFilterText = page.locator(".bg-c-empty-state__description");
        this.paduanMamiadsBackButton = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("back"));
        this.cobaSekarangButtonHeader = page.locator(".mami-ads-navbar__main-nav-button");
        //--- Beli Saldo Mamiads Page ---//
        this.bayarSekarangBtnOnDetailTagihan = playwright.locatorByRoleAndText(AriaRole.BUTTON, "Bayar Sekarang");

        //--- GP Onboarding Pop - Up ---//
        gpOnboardingPopUpActiveCounter = page.locator(".swiper-slide-active .gp-swiper__slide-counter");
        gpOnboardingPopUpActiveTextHead = page.locator(".swiper-slide-active .gp-swiper__slide-text p:nth-child(1)");
        gpOnboardingPopUpActiveTextBody = page.locator(".swiper-slide-active .gp-swiper__slide-text p:nth-child(2)");
        gpOnboardingPopUpActiveImage = page.locator(".swiper-slide-active img");
        gpOnboardingPopUpNextButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next slide"));
        gpOnboardingPopUpSwipperBullet = page.locator(".swiper-pagination-bullet");
        gpOnboardingPopUpPreviousButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Previous slide"));
    }

    /**
     * Get gp onboarding pop up active counter
     *
     * @return Integer data type
     */
    public int getGpOnboardingpopUpActiveCounter() {
        return Integer.parseInt(gpOnboardingPopUpActiveCounter.innerText());
    }

    /**
     * Get gp onboarding pop up text head
     * @return String data type
     */
    public String getGpOnboardingpopUpTextHead() {
        return playwright.getText(gpOnboardingPopUpActiveTextHead);
    }

    /**
     * Get gp onboarding pop up text body
     * @return String data type
     */
    public String getGpOnboardingpopUpTextBody() {
        return playwright.getText(gpOnboardingPopUpActiveTextBody);
    }

    /**
     * Get gp onboarding pop up image alt attribute value
     * @return String data type
     */
    public String getGpOnboardingpopUpImageAltAttributeValue() {
        return playwright.getAttributeValue(gpOnboardingPopUpActiveImage, "alt");
    }

    /**
     * Click on gp onboarding pop up next button
     */
    public void clickGpOnboardingpopUpNextButton() {
        playwright.clickOn(gpOnboardingPopUpNextButton);
    }

    /**
     * Get gp onboarding pop up swiper bullet count
     * @return Integer data type
     */
    public boolean isGpOnboardingpopUpPreviousButtonDisabled() {
        return playwright.getAttributeValue(gpOnboardingPopUpPreviousButton, "aria-disabled").equals("true");
    }

    /**
     * Get gp onboarding pop up swiper bullet count
     * @return Integer data type
     */
    public boolean isGpOnboardingpopUpNextButtonDisabled() {
        return playwright.getAttributeValue(gpOnboardingPopUpNextButton, "aria-disabled").equals("true");
    }

    /**
     * Click on gp onboarding pop up swiper bullet
     */
    public void clickGpOnboardingpopUpPreviousButton() {
        playwright.clickOn(gpOnboardingPopUpPreviousButton);
    }

    /**
     * owner buy mamiads saldo,
     * This method is only valid for owners who have purchased saldo at Mamiads.
     *
     * @param saldo String
     */
    public void purchaseOwnerSaldoFromMamiads(String saldo) {
        playwright.clickOn(saldoMamiadsCard);
        handlePopupMamiAds();
        clickOnBeliSaldoBtn();
        choosingSaldoToBuy(saldo);
        playwright.clickOn(bayarSekarangBtnOnDetailTagihan);
    }

    /**
     * Handle popup and button clicks when owner visits Mamiads page.
     * This method addresses the conditions when a popup appears on the page visited by the owner.
     * If the 'Coba Sekarang' button on the popup is visible or the 'Beli Saldo' button is not visible,
     * the method clicks on the 'Coba Sekarang' button.
     */
    public void handlePopupMamiAds() {
        // Check if the 'Coba Sekarang' button on the popup is visible
        // OR if the 'Beli Saldo' button is not visible
        if (playwright.waitTillLocatorIsVisible(cobaSekarangBtnOnPopUp)
                || !playwright.waitTillLocatorIsVisible(beliSaldoBtn)) {
            playwright.clickOn(cobaSekarangBtnOnPopUp);
        }
    }

    /**
     * this method will be clickOn beli saldo btn on the mamiads page 'https://owner-jambu.kerupux.com/mamiads'
     */
    public void clickOnBeliSaldoBtn() {
        playwright.clickOn(beliSaldoBtn);
    }

    /**
     * buy saldo on mamiads saldo page
     *
     * @param saldo you should use ex. 'Rp6.000'
     */
    public void choosingSaldoToBuy(String saldo) {
        playwright.clickOn(page.locator("//*[contains(text(),'" + saldo + "')]/following-sibling::button"));
    }

    /**
     * click on filter Semua Iklan on mamiads page
     */
    public void clickOnSemuaIklan() {
        playwright.clickOnText("Semua Iklan");
    }

    /**
     * click on filter Iklan Nonaktif on mamiads page
     */
    public void clickOnIklanNonaktif() {
        playwright.clickOnText("Iklan Nonaktif");
    }

    /**
     * Get title text
     * ex: Semua Iklan Anda Sudah Naik
     * @return String title
     */
    public String getTitleText(){
        playwright.waitFor(titleEmptyFilterText);
        return playwright.getText(titleEmptyFilterText);
    }

    /**
     * Get message empty filter text
     * ex: Iklan properti Anda akan naik ke posisi yang lebih tinggi pada hasil pencarian.
     * @return String title
     */
    public String getMessageText() {
        playwright.waitFor(messageEmptyFilterText);
        return playwright.getText(messageEmptyFilterText);
    }

    /**
     * Click on Panduan MamiAds Back Button
     *
     */
    public void clickOnPanduanMamiAdsBackButton() {
        playwright.clickOn(paduanMamiadsBackButton);
    }

    /**
     * Get coba sekarang button at header
     *
     */
    public boolean isCobaSekarangButtonHeaderisDisplayed() {
        return playwright.waitTillLocatorIsVisible(cobaSekarangButtonHeader,1000.0);
    }

    /**
     * Click On Text Question
     *
     * @return
     * @param
     */
    public void clickOnQuestionText(String questionText) throws InterruptedException {
        playwright.pageScrollUsingCoordinate(5,5);
        String questionTextLocator = "//p[contains(.,'" + questionText + "')]";
        playwright.waitTillLocatorIsVisible(page.locator(questionTextLocator),1000.0);
        playwright.clickOn(page.locator(questionTextLocator));

    }

    /**
     * Get Text Answer
     *
     * @return answerText
     * @param answerText
     */
    public String getAnswerText(String answerText) {
        String answerTextLocator = "//p[contains(.,'" + answerText + "')]";
        return playwright.getText(page.locator(answerTextLocator));
    }
}

