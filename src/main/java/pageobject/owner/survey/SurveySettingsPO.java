package pageobject.owner.survey;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.PlaywrightHelpers;

public class SurveySettingsPO {
    private Page page;
    private PlaywrightHelpers playwright;

    Locator surveyFilterButton;
    Locator surveySettingsPageTitle;
    Locator surveyTodaySection;
    Locator newLabel;
    Locator sameDaySurveyToggleInactive;
    Locator sameDaySurveyToggleActive;
    Locator onboardingSurveyPopupDisplayed;
    Locator closePopUpButton;
    Locator pengaturanSurveiKos;

    public SurveySettingsPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);

        surveyFilterButton = page.getByText("Survei").first();
        surveySettingsPageTitle = page.locator("(//p[@class='bg-u-ml-sm bg-c-text bg-c-text--heading-6'])[1]");
        surveyTodaySection = page.locator("//div[contains(.,'Survei Hari Ini')]");
        newLabel = page.locator("//span[contains(@class,'label') and contains(.,'New')]");
        sameDaySurveyToggleInactive = page.locator("//div[contains(@class,'bg-c-switch--off')]");
        sameDaySurveyToggleActive = page.locator("(//div[@class='bg-c-switch bg-c-switch--on'])").first();
        onboardingSurveyPopupDisplayed = page.locator("//div[contains(@class,'bg-c-modal__body')]").first();
        closePopUpButton = page.locator(".bg-c-modal__action-closable");
        pengaturanSurveiKos = page.locator("//div[@class='mc-channel-list__setting-card bg-c-card bg-c-card--lined bg-c-card--sm bg-c-card--light bg-c-card--clickable']");
    }

    /**
     * Click on survey filter button
     */
    public void clickSurveyFilter() {
        playwright.waitTillLocatorIsVisible(surveyFilterButton);
        playwright.clickOn(surveyFilterButton);
    }

    /**
     * Check if survey settings page is displayed
     * @return true if page is displayed
     */
    public boolean isSurveySettingsPageDisplayed() {
        return playwright.waitTillLocatorIsVisible(surveySettingsPageTitle, 1000.0);
    }


    /**
     * If toggle is ON, click to disable it first, then verify OFF state
     * @return true if toggle is inactive (off)
     */
    public boolean ensureSameDaySurveyToggleOff() {
        if (playwright.waitTillLocatorIsVisible(sameDaySurveyToggleActive, 3000.0)) {
            playwright.clickOn(sameDaySurveyToggleActive);
            playwright.hardWait(2000);
        }
        return playwright.waitTillLocatorIsVisible(sameDaySurveyToggleInactive, 5000.0);
    }

    /**
     * Check if same-day survey toggle is inactive
     * @return true if toggle is active (on)
     */
    public boolean isSameDaySurveyToggleActive() {
        playwright.waitTillLocatorIsVisible(sameDaySurveyToggleActive);
        String checkedAttribute = sameDaySurveyToggleActive.getAttribute("checked");
        return checkedAttribute == null || checkedAttribute.equals("false");
    }


    /**
     * Click on same day survey toggle
     */
    public void clickSameDaySurveyToggle() {
        if (playwright.waitTillLocatorIsVisible(closePopUpButton, 2000.0)) {
            playwright.clickOn(closePopUpButton);
            playwright.hardWait(1000);
        }
        if (playwright.waitTillLocatorIsVisible(sameDaySurveyToggleInactive, 2000.0)) {
            playwright.clickOn(sameDaySurveyToggleInactive);
        } else {
            playwright.clickOn(sameDaySurveyToggleActive);
        }
    }

    /**
     * Check if copy text is displayed
     * @param text text to verify
     * @return true if text is displayed
     */
    public boolean isCopyTextDisplayed(String text) {
        Locator copyText = page.getByText(text);
        return playwright.waitTillLocatorIsVisible(copyText, 3000.0);
    }

    /**
     * Click on a link
     * @param linkText text of the link to click
     */
    public void clickLink(String linkText) {
        Locator link = page.getByText(linkText);
        playwright.waitTillLocatorIsVisible(link, 3000.0);
        playwright.clickOn(link);
    }

    /**
     * Check if onboarding survey popup is displayed
     * @return true if popup is displayed
     */
    public boolean isOnboardingSurveyPopupDisplayed() {
        return playwright.waitTillLocatorIsVisible(onboardingSurveyPopupDisplayed, 5000.0);
    }

    /**
     * Ensure same-day survey toggle is ON. If OFF, click to activate it.
     * @return true if toggle is active (on) after operation
     */
    public boolean ensureSameDaySurveyToggleOn() {
        if (playwright.waitTillLocatorIsVisible(sameDaySurveyToggleActive, 3000.0)) {
            return true;
        }
        if (playwright.waitTillLocatorIsVisible(sameDaySurveyToggleInactive, 3000.0)) {
            playwright.clickOn(sameDaySurveyToggleInactive);
            playwright.hardWait(2000);
        }
        if (playwright.waitTillLocatorIsVisible(closePopUpButton, 2000.0)) {
            playwright.clickOn(closePopUpButton);
            playwright.hardWait(1000);
        }
        return playwright.waitTillLocatorIsVisible(sameDaySurveyToggleActive, 5000.0);
    }

    /**
     * Exit from survey settings page by navigating back
     */
    public void exitSurveySettingsPage() {
        playwright.backToPreviousPage();
        playwright.hardWait(2000);
    }

    /**
     * Navigate back to survey settings page by clicking pengaturan survei kos
     */
    public void clickPengaturanSurveiKos() {
        playwright.waitTillLocatorIsVisible(pengaturanSurveiKos);
        playwright.clickOn(pengaturanSurveiKos);
    }
}

