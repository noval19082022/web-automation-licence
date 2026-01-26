package pageobject.owner.goldplus;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class PanduanGoldplusPO {
    private Page page;
    private PlaywrightHelpers playwright;

    Locator naikkanIklanAndaButton;
    Locator panduanGPswipper;
    Locator swipperNextButton;
    Locator swipperPreviousButton;
    Locator selectedSwiperText;
    Locator cobaSekarangButton;
    Locator memantauPerformaKos;
    Locator onboardingTitleText;
    Locator onboardingBodyText;
    Locator selectedOnboardingNumber;
    Locator selectedOnboardingImage;
    Locator guideCardTitles;
    Locator guideCardDescriptions;

    public PanduanGoldplusPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        naikkanIklanAndaButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Naikkan Iklan Anda"));
        panduanGPswipper = page.locator(".gp-swiper .gp-swiper__step");
        swipperNextButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next slide"));
        swipperPreviousButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Previous slide"));
        selectedSwiperText = page.locator(".gp-swiper .gp-swiper__step:not(.gp-swiper__step--dim) p");
        cobaSekarangButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Coba Sekarang"));
        memantauPerformaKos = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Memantau Performa Kos"));
        onboardingTitleText = page.locator(".swiper-slide-active h4");
        onboardingBodyText = page.locator(".swiper-slide-active .gp-swiper__slide-text p");
        selectedOnboardingNumber = page.locator(".swiper-slide-active .gp-swiper__slide-counter p");
        selectedOnboardingImage = page.locator(".swiper-slide-active img");
        guideCardTitles = page.locator("h4");
        guideCardDescriptions = page.locator("h4 + p");
    }

    /**
     * Click on naikkan iklan anda button
     */
    public void clickOnNaikkanIklanAndaButton(){
        playwright.clickOn(naikkanIklanAndaButton);
    }

    /**
     * Click on a guide card by title to navigate to its detail page
     * Uses dynamic locator based on guideTitle parameter (acceptable exception to class variable rule)
     * @param guideTitle The title of the guide card (e.g., "Naikkan Iklan Anda", "Memantau Performa Kos")
     */
    public void clickOnGuideCard(String guideTitle) {
        // Dynamic locator - acceptable because it depends on method parameter
        Locator guideCard = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(guideTitle));
        playwright.waitFor(guideCard);
        playwright.clickOn(guideCard);
        playwright.waitTillPageLoaded();
    }

    public String getGPswipperAttribute(int index, String attribute){
        return panduanGPswipper.nth(index).getAttribute(attribute);
    }

    /**
     * Click on next button on gp swipper to slide to right item
     */
    public void clickOnNextButton() {
        playwright.waitFor(swipperNextButton);
        playwright.clickOn(swipperNextButton);
    }

    /**
     * Get selected swiper title
     * @return String data type
     */
    public String getSelectedSwiperTitle() {
        return selectedSwiperText.first().innerText();
    }

    /**
     * Get selected swiper body text
     * @return String data type
     */
    public String getSelectedSwiperBodyText() {
        return selectedSwiperText.last().innerText();
    }

    /**
     * Check if next button is disabled
     * @return boolean data type
     */
    public boolean isNextButtonDisabled() {
        return swipperNextButton.getAttribute("disabled") != null;
    }

    /**
     * Check if previous button is disabled
     * @return booleand data type
     */
    public boolean isPreviousButtonDisabled() {
        return swipperPreviousButton.getAttribute("disabled") != null;
    }

    /**
     * Click on previous button on gp swipper to slide to left item
     */
    public void clickOnPreviousButton() {
        playwright.clickOn(swipperPreviousButton);
    }

    /**
     * Click on coba sekarang button
     */
    public void clickCobaSekarangButton() {
        playwright.waitTillPageLoaded();
        playwright.clickOn(cobaSekarangButton);
    }

    private boolean isCobaSekarangMamiadsVisible() {
        return playwright.isLocatorVisibleAfterLoad(cobaSekarangButton, 5000.0);
    }

    /**
     * Click on memantau performa kos button
     */
    public void clickOnMemantauPerformaKosButton() {
        playwright.clickOn(memantauPerformaKos);
    }

    /**
     * Get selected onboarding title
     * @return String data type
     */
    public String getSelectedOnboardingTitle() {
        return playwright.getText(onboardingTitleText);
    }

    /**
     * Get selected onboarding body text
     * @return String data type
     */
    public String getSelectedOnboardingBodyText() {
        return playwright.getText(onboardingBodyText);
    }

    /**
     * Get selected onboarding number
     * @return int data type
     */
    public int getSelectedOnboardingNumber() {
        playwright.waitFor(selectedOnboardingNumber);
        String onboardingText = playwright.getText(selectedOnboardingNumber);
        return onboardingText != null && !onboardingText.isEmpty() ? Integer.parseInt(onboardingText) : 0;
    }

    /**
     * Get selected onboarding image alt text
     * @return String data type
     */
    public String getSelectedOnboardingImageAltText() {
        return playwright.getAttributeValue(selectedOnboardingImage, "alt");
    }

    /**
     * Get guide card title text by matching title content
     * This method finds the specific guide card title on the GoldPlus Panduan page
     * Uses dynamic locator based on title parameter (acceptable exception to class variable rule)
     * @param title The expected title text (e.g., "Naikkan Iklan Anda")
     * @return String the actual title text from the page
     */
    public String getGuideCardTitle(String title) {
        // Dynamic locator - acceptable because it depends on method parameter
        Locator titleLocator = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setLevel(4).setName(title));
        playwright.waitFor(titleLocator);
        return playwright.getText(titleLocator);
    }

    /**
     * Get guide card description text by matching the title
     * This method finds the description paragraph that follows the specified title
     * Uses dynamic locator based on title parameter (acceptable exception to class variable rule)
     * @param title The title of the guide card to find the description for
     * @return String the description text from the page
     */
    public String getGuideCardDescription(String title) {
        // Dynamic locator - acceptable because it depends on method parameter
        Locator descriptionLocator = page.locator("h4:has-text('" + title + "') + p");
        playwright.waitFor(descriptionLocator);
        return playwright.getText(descriptionLocator);
    }
}
