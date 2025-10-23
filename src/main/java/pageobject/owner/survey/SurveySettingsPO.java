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

    public SurveySettingsPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);

        surveyFilterButton = page.getByText("Survei").first();
        surveySettingsPageTitle = page.locator("(//p[@class='bg-u-ml-sm bg-c-text bg-c-text--heading-6'])[1]");
        surveyTodaySection = page.locator("//div[contains(.,'Survei Hari Ini')]");
        newLabel = page.locator("//span[contains(@class,'label') and contains(.,'New')]");
        sameDaySurveyToggleInactive = page.locator("//div[@class='bg-c-switch bg-c-switch--off']");
        sameDaySurveyToggleActive = page.locator("//div[@class='bg-c-switch bg-c-switch--on']");
        onboardingSurveyPopupDisplayed = page.locator("//div[@class='bg-c-modal__body bg-c-modal__body--has-top-line']").first();
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
     * Check if same-day survey toggle is inactive
     * @return true if toggle is inactive (off)
     */
    public boolean isSameDaySurveyToggleInactive() {
        playwright.waitTillLocatorIsVisible(sameDaySurveyToggleInactive);
        String checkedAttribute = sameDaySurveyToggleInactive.getAttribute("checked");
        return checkedAttribute == null || checkedAttribute.equals("false");
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
        playwright.waitTillLocatorIsVisible(onboardingSurveyPopupDisplayed, 2000.0);
        return true;
    }
}

