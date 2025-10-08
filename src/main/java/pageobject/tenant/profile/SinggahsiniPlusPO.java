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

    public SinggahsiniPlusPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);

        this.singgahsiniPlusTierMessage = page.getByTestId("singgahsiniPlusSummaryCard-tierMessage");
        this.singgahsiniPlusSummaryCard = page.getByTestId("singgahsiniPlusSummaryCard");
        this.singgahsiniText = page.getByTestId("singgahsiniPlusSummaryCard-ssPlusTitle");
        this.rewardPoinText = singgahsiniPlusSummaryCard.getByText("Reward & Poin");
        this.mamiPoinText = singgahsiniPlusSummaryCard.getByText("MamiPoin");
        this.introductionTierText = page.getByTestId("singgahsiniPlusMainDescription");
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
     * @param text
     * @return text
     */
    public boolean isTierActiveVisible(String text){
        tierActiveText = page.locator("//*[@data-testid='singgahsiniPlusCard']//*[contains(text(),'"+text+"')]");
        return playwright.waitTillLocatorIsVisible(tierActiveText);
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
}