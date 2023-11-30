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

    public PanduanGoldplusPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        naikkanIklanAndaButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Naikkan Iklan Anda"));
        panduanGPswipper = page.locator(".gp-swiper .gp-swiper__step");
        swipperNextButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("chevron-right"));
        swipperPreviousButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("chevron-left"));
        selectedSwiperText = page.locator(".gp-swiper .gp-swiper__step:not(.gp-swiper__step--dim) p");
        cobaSekarangButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Coba Sekarang"));
        memantauPerformaKos = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Memantau Performa Kos"));
        onboardingTitleText = page.locator(".swiper-slide-active h4");
        onboardingBodyText = page.locator(".swiper-slide-active .gp-swiper__slide-text p");
        selectedOnboardingNumber = page.locator(".swiper-slide-active .gp-swiper__slide-counter p");
        selectedOnboardingImage = page.locator(".swiper-slide-active img");
    }

    /**
     * Click on naikkan iklan anda button
     */
    public void clickOnNaikkanIklanAndaButton(){
        playwright.clickOn(naikkanIklanAndaButton);
    }

    public String getGPswipperAttribute(int index, String attribute){
        return panduanGPswipper.nth(index).getAttribute(attribute);
    }

    /**
     * Click on next button on gp swipper to slide to right item
     */
    public void clickOnNextButton() {
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
        cobaSekarangButton.waitFor();
        playwright.clickOn(cobaSekarangButton);
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
        return Integer.parseInt(playwright.getText(selectedOnboardingNumber));
    }

    /**
     * Get selected onboarding image alt text
     * @return String data type
     */
    public String getSelectedOnboardingImageAltText() {
        return playwright.getAttributeValue(selectedOnboardingImage, "alt");
    }
}
