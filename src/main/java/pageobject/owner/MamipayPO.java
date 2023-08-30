package pageobject.owner;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import utilities.PlaywrightHelpers;

public class MamipayPO {
    private Page page;
    private PlaywrightHelpers playwright;

    Locator namaLengkap;
    Locator infoMamipay;
    Locator termAndConditionCheck;
    Locator kirimDataButton;
    Locator termAndCondition;
    Locator username;
    Locator bankNameLabel;

    public MamipayPO(Page page){
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);

        namaLengkap = page.locator("[placeholder='Masukkan nama lengkap']");
        infoMamipay = page.locator(".media-content");
        termAndConditionCheck = page.locator(".check");
        kirimDataButton = page.locator(".button");
        termAndCondition = page.locator("//a[.='Syarat dan Ketentuan']");
        username = page.locator(".c-mk-header__username");
        bankNameLabel = page.locator("//label[.='Nama Bank']");
    }

    /**
     * Verify title on onboarding of mamipay owner
     * @return title text
     *
     */
    public boolean getTitleOnboarding() {
        return playwright.isTextDisplayed("Manfaat Beriklan di Mamikos", 3000.0);
    }

    /**
     * Click button lanjutkan on onboarding mamipay owner
     *
     *
     */
    public void clickLanjutkanButton() {
        playwright.clickOnTextButton("Lanjutkan");
    }

    /**
     * Get Nama Lengkap on Nama Lengkap field
     * @return namaLengkap
     *
     */
    public String getNamaLengkap() {
        return playwright.getInputValue(namaLengkap);
    }

    /**
     * input text field
     * @param fieldName
     * @param inputText
     * e.g nama lengkap, nomor rekening, nama bank, nama pemilik rekening for fieldName
     *
     */
    public void inputTextField(String fieldName, String inputText) {
        String element = "[placeholder='Masukkan "+ fieldName +"']";
        playwright.forceFill(page.locator(element), inputText);
    }

    /**
     * get text info mamipay
     * @return info mamipay
     *
     */
    public String getInfoMamipay() {
        return playwright.getText(infoMamipay);
    }

    /**
     * verify term and condition disable
     * @return boolean true and false
     *
     */
    public boolean isTermAndConditionDisable() {
        return playwright.isButtonDisable(termAndConditionCheck);
    }

    /**
     * verify button kirim data disable
     * @return boolean true, false
     *
     */
    public boolean isKirimDataButtonDisable() {
        return playwright.isButtonDisable(kirimDataButton);
    }

    /**
     * Select bank name based on type of bank name on input dropdown
     * @param bankName
     *
     */
    public void selectBankName(String bankName) {
        playwright.clickOnText(bankName);
    }

    /**
     * click on term and condition link and open new tab
     * @return page term and condition
     *
     */
    public Page clickOnTermAndCondition() {
        page = page.waitForPopup(() -> {
            playwright.clickOn(termAndCondition);
        });
        ActiveContext.setActivePage(page);
        return ActiveContext.getActivePage();
    }

    /**
     * Get URL
     * @return url is equal
     */
    public String getURL() {
        return page.url();
    }

    /**
     * Get title pusat bantuan on new page
     * @return title pusat bantuan
     *
     */
    public boolean getTitlePusatBantuan() {
        Locator titlePusatBantuan = page.locator(".mh-article-page__title");
        return playwright.waitTillLocatorIsVisible(titlePusatBantuan, 2000.0);
    }

    /**
     * check on tnc
     *
     *
     */
    public void clickOnChecTnC() {
        playwright.clickOn(termAndConditionCheck);
    }

    /**
     * Get username on navbar
     * @return username
     *
     */
    public String getUsername() {
        return playwright.getText(username);
    }
}
