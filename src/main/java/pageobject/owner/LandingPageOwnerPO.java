package pageobject.owner;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class LandingPageOwnerPO {
    private Page page;
    private PlaywrightHelpers playwright;
    Locator entryPointLPOwner;
    Locator titleEntryPointLPOwner;
    Locator entryPointLPOwnerbutton;
    Locator titleOnLandingPageOwner;
    Locator infoLandingPageOwner;
    Locator imageHeaderLandingPageOwner;
    Locator daftarkanKosbutton;
    Locator USPsection;
    Locator mblmSection;

    public LandingPageOwnerPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        entryPointLPOwner = page.locator("//*[@class='landing-owner-entry-point__content']");
        titleEntryPointLPOwner = page.getByText("Daftarkan Kos Anda di Mamikos");
        entryPointLPOwnerbutton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pelajari Lebih Lanjut"));
        imageHeaderLandingPageOwner = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Mamikos Logo"));
        daftarkanKosbutton = page.locator("//*[@class='bg-c-button header-section__cta bg-c-button--primary bg-c-button--lg']");
        USPsection = page.locator(".benefit-section-desktop");
        mblmSection = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Maju Bersama Layanan Mamikos"));
    }

    /**
     * user scroll into entry point LP Owner
     */
    public void scrollIntoEntryPointLPOwner() {
        playwright.pageScrollUntilElementIsVisible(entryPointLPOwner);
    }

    /**
     * Get text on Title entry point LP Owner
     *
     * @return text title
     */
    public String getTitleEntryPointLPOwner(){
        return playwright.getText(titleEntryPointLPOwner);
    }

    /**
     * Get text on Title entry point button LP Owner
     *
     * @return text title
     */
    public String getTextButtonEntryPointLPOwner() {
        return playwright.getText(entryPointLPOwnerbutton);
    }

    /**
     * assert entry point LP Owner is not display
     */
    public boolean isEntryPointLPOwnerVisible() {
        return entryPointLPOwnerbutton.isVisible();
    }

    /**
     * Get text on Title Landing Page Owner
     *
     * @return text title
     */
    public String getTitleLandingPageOwner(String titleText){
        titleOnLandingPageOwner = page.getByText(titleText);
        return titleOnLandingPageOwner.innerText();
    }

    /**
     * Get text on Information Landing Page Owner
     *
     * @return text title
     */
    public String getTextInfoLandingPageOwner(String infoText){
        infoLandingPageOwner = page.getByText(infoText);
        return infoLandingPageOwner.innerText();
    }

    /**
     * assert image header LP Owner is display
     */
    public boolean isImageHeaderLPOwnerVisible() {
        return imageHeaderLandingPageOwner.isVisible();
    }

    /**
     * Get text daftarkan kos button
     *
     * @return text button
     */
    public String getTextDaftarkanKosButton(String buttonText){
        return playwright.getText(daftarkanKosbutton);
    }

    /**
     * Click on daftarkan kos button
     *
     * @return
     */
    public void clickOnDaftarkanKosButton() {
        playwright.clickOn(daftarkanKosbutton);
    }

    /**
     * user scroll into USP Section
     */
    public void scrollIntoUSPSection() {
        playwright.waitTillPageLoaded();
        playwright.pageScrollUntilElementIsVisible(USPsection);
    }

    /**
     * user scroll into MBLM Section
     */
    public void scrollIntoMBLMSection() {
        playwright.waitTillPageLoaded();
        playwright.pageScrollUntilElementIsVisible(mblmSection);
    }

    /**
     * Click on daftarkan kos button
     *
     * @return
     */
    public void clickOnTextLPOwner(String text) {
        playwright.clickOnText(text);
    }

    /**
     * Click on Landing Page button
     *
     * @return
     */
    public void clickOnButtonLPOwner(String text){
        Locator buttonONLPOwner = page.getByText(text);
        playwright.pageScrollUntilElementIsVisible(buttonONLPOwner);
        playwright.clickOnText(text);
    }
}
