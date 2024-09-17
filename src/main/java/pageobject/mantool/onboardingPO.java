package pageobject.mantool;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import config.playwright.context.ActiveContext;
import utilities.PlaywrightHelpers;

public class onboardingPO {
    private Page page;
    private PlaywrightHelpers playwright;

    private Locator agentNameText;
    private Locator breadcrumbTitle;
    private Locator onboardingSection;
    private Locator progressTitleText;
    private Locator stepTitle;
    private Locator stepDescription;
    private Locator stepButton;
    private Locator stepCheckbox;
    private Locator stepProgressText;
    private Locator checkboxChecked;
    private Locator mitraAgenBreadcrumb;
    private Locator mamikosBreadcrumb;
    private Locator stepHeaderTitle;
    private Locator profileAvatar;
    private Locator keluarButton;
    private Locator suratKeteranganLink;

    public onboardingPO(Page page){
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);

        agentNameText = page.locator("p.bg-c-text--heading-2");
        breadcrumbTitle = page.locator(".bg-c-breadcrumb__item-link--active");
        onboardingSection = page.locator(".bg-is-col-4 p");
        progressTitleText = page.locator(".bg-c-text--title-5").first();
        stepTitle = page.locator("p.onboarding-steps__step-title");
        stepButton = page.locator(".onboarding-steps__step-button");
        stepDescription = page.locator(".onboarding-steps__step-item p.bg-c-text--body-2");
        stepProgressText = page.locator(".onboarding-steps__indicator div");
        checkboxChecked = page.locator(".bg-c-checkbox--checked");
        mitraAgenBreadcrumb = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Mitra Agen"));
        mamikosBreadcrumb = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Mamikos"));
        stepHeaderTitle = page.locator(".onboarding-steps__indicator p");
        profileAvatar = page.getByAltText("Avatar");
        keluarButton = page.getByText("Keluar");
        suratKeteranganLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Surat Keterangan"));
    }

    /**
     * Get Agen Name in Selamat #Agen Name#
     * @return String
     */
    public String getAgentName() {
        String name = playwright.getText(agentNameText).substring(8);
        return name;
    }

    /**
     * Get Active Breadcrumb Title
     * @return String
     */
    public String getBreadcrumbTitle() {
        return playwright.getText(breadcrumbTitle);
    }

    /**
     * Get Onboarding Title
     * @return String
     */
    public String getOnboardingTitle() {
        return playwright.getText(onboardingSection.first());
    }

    /**
     * Get Onboarding Description
     * @param i
     * @return String
     */
    public String getOnboardingDescription(int i) {
        return playwright.getText(onboardingSection.nth(i));
    }

    /**
     * Click Surat Keterangan link
     */
    public void clickSuratKeterangan() {
        playwright.waitTillPageLoaded();
        playwright.clickOn(suratKeteranganLink);
    }

    /**
     * Get progress title
     * @return string
     */
    public String getProgressTitle() {
        return playwright.getText(progressTitleText);
    }

    /**
     * Get steps title
     * @param step step number
     * @return String
     */
    public String getStepTitle(Integer step) {
        return playwright.getText(stepTitle.nth(step-1));
    }

    /**
     * Get button Name
     * @param step step number
     * @return String
     */
    public String getButtonName(Integer step) {
        return playwright.getText(stepButton.nth(step-1));
    }

    /**
     * Get Step Description
     * @param i
     * @return String
     */
    public String getStepDescription(int i) {
        return playwright.getText(stepDescription.nth(i));
    }

    /**
     * Check step checkbox
     * @param step
     */
    public void checkStep(Integer step) {
        stepCheckbox = page.locator("span").filter(new Locator.FilterOptions().setHasText("checkmark")).nth(step-1);
        playwright.clickOn(stepCheckbox);
    }

    /**
     * Get step progress agen text
     * @return String
     */
    public String getStepProgress() {
        return playwright.getText(stepProgressText);
    }

    /**
     * Verify checkbox checked is exist
     * @param step
     * @return boolean
     */
    public boolean isStepChecked(Integer step) {
        return playwright.isLocatorVisibleAfterLoad(checkboxChecked.nth((step-1)),5000.0);
    }

    /**
     * Click step button
     * @param button
     */
    public void clickStepButton(String button) {
        playwright.clickOn(stepButton.filter(new Locator.FilterOptions().setHasText(button)));
    }

    /**
     * click breadcrumb Mitra Agen
     */
    public void clickBreadcrumbMitraAgen() {
        playwright.clickOn(mitraAgenBreadcrumb);
    }

    /**
     * click breadcrumb Mamikos
     */
    public void clickBreadcrumbMamikos() {
        playwright.clickOn(mamikosBreadcrumb);
    }

    /**
     * Get onboarding header
     * @return String
     */
    public String getStepHeader() {
        return playwright.getText(stepHeaderTitle);
    }

    /**
     * Logout Agen
     */
    public void logoutAgen() {
        playwright.clickOn(profileAvatar);
        playwright.clickOn(keluarButton);
    }
}
