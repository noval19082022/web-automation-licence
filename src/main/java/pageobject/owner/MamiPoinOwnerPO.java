package pageobject.owner;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;
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
        System.out.println(JavaHelpers.extractNumber(playwright.getText(mamipoinWidgetText)));
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

}
