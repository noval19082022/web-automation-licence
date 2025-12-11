package pageobject.owner;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
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
    Locator autoBbkCard;
    Locator titleForm;
    Locator titleAutoBbkPopUp;
    Locator kirimData;
    Locator tittlePusatBantuan;

    public MamipayPO(Page page){
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);

        namaLengkap = page.locator("[placeholder='Masukkan nama lengkap Anda sesuai KTP']");
        infoMamipay = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Pastikan data benar agar uang"));
        termAndConditionCheck = page.locator("span").filter(new Locator.FilterOptions().setHasText("checkmark"));
        kirimDataButton = page.locator("//button[normalize-space()='Kirim Data']");
        termAndCondition = page.locator("//a[normalize-space()='Syarat dan Ketentuan']");
        username = page.locator(".c-mk-header__username");
        bankNameLabel = page.locator("//label[.='Nama Bank']");
        autoBbkCard = page.locator("//*[@class='auto-bbk-info-bar']");
        titleForm = page.locator(".title");
        titleAutoBbkPopUp = page.locator(".owner-intercept-booking-modal__body-title");
        kirimData = page.locator(".bg-c-button--primary");
        tittlePusatBantuan = page.locator("h1.bg-c-text.bg-c-text--heading-2.mh-article-page__title");
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
        String element = "[placeholder='"+ fieldName +"']";

        // switch the element
        if (fieldName.contains("Pilih nama bank") || fieldName.contains("nama bank")) {
            element = "[placeholder='Pilih nama bank']";
        } else if (fieldName.contains("nama pemilik rekening")) {
            element = "[placeholder='Pastikan sama dengan buku rekening bank']";
        }

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
        return playwright.isLocatorVisibleAfterLoad(tittlePusatBantuan, 3000.0);
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

    /**
     * Verify info untuk anda auto BBK dislayed
     * @return boolean true or false
     *
     */
    public boolean isInfoUntukAndaAutoBbkDisplayed() {
        return playwright.isLocatorVisibleAfterLoad(autoBbkCard, 3000.0);
    }

    /**
     * Verify title text on form Auto BBK
     * @return titleForm text
     *
     */
    public String getTitleForm() {
        return playwright.getText(titleForm);
    }

    /**
     * Get title on pop up Auto BBK pop up
     * @return titleAutoBbkPopUp
     *
     */
    public String getTitleAutoBbkPopUp() {
        return playwright.getText(titleAutoBbkPopUp);
    }

    /**
     * Verify the Kirim data button on form input BBK is disable
     *
     *
     */
    public void kirimDataDisable() {
        playwright.waitFor(kirimData);
        playwright.isButtonDisable(kirimData);
    }
}