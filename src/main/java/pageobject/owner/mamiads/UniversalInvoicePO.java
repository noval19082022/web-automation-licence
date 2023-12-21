package pageobject.owner.mamiads;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import config.playwright.context.ActiveContext;
import utilities.PlaywrightHelpers;

public class UniversalInvoicePO {
    private Page page;
    private PlaywrightHelpers playwright;
    private Locator masukkanText;
    private Locator masukkanVoucherText;
    private Locator voucherInput;
    private Locator pakaiVoucherButton;
    private Locator selesaiButton;

    public UniversalInvoicePO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);

        this.masukkanText = page.getByTestId("masukkan_link");
        this.masukkanVoucherText = page.locator("#wrapper-scroll").getByTestId("masukkan_link");
        this.voucherInput = page.getByTestId("codeVoucher_txt");
        this.pakaiVoucherButton = page.getByTestId("pakaiVoucher_btn");
        this.selesaiButton =  page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Selesai"));
    }

    /**
     * Click Masukkan on universal invoice page to input voucher
     */
    public void clickOnMasukkanText() {
        playwright.clickOn(masukkanText);
    }

    /**
     * Click on Masukkan in pop up Voucher Anda
     */
    public void clickOnMasukkanTextInVoucherAnda() {
        playwright.clickOn(masukkanVoucherText);
    }

    /**
     * input kode voucher
     *
     * @param voucher
     */
    public void inputKodeVoucher(String voucher){
        playwright.fill(voucherInput,voucher);

    }

    /**
     * Click pakai voucher button
     */
    public void clickOnPakaiVoucherButton(){
        playwright.clickOn(pakaiVoucherButton);
    }

    /**
     * Click selesai button
     * redefine variable page because when click selesai button will be open new tab
     * @return active page
     *
     */
    public Page clickOnSelesaiButton(){
        page = page.waitForPopup(() -> {
            playwright.clickOn(selesaiButton);
        });
        ActiveContext.setActivePage(page);
        return ActiveContext.getActivePage();
    }

}
