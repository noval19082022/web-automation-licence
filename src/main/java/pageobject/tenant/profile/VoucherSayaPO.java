package pageobject.tenant.profile;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class VoucherSayaPO {
    Page page;
    PlaywrightHelpers playwright;

    Locator voucherTitle;
    Locator checkVoucherCard;
    Locator checkVoucherPromoLainnya;
    Locator checkVoucherListImage;
    Locator checkVoucherListExpiredDate;
    Locator checkVoucherListKodeVoucherLabel;
    Locator checkVoucherListVoucherCode;
    Locator checkVoucherListSalinButton;
    Locator checkVoucherListTerpakaiLabel;
    Locator checkVoucherListDisabledKodeVoucherLabel;
    Locator checkVoucherListDisabledVoucherCode;
    Locator checkVoucherListKedaluwarsaLabel;
    Locator voucherListSalinButtonActive;
    Locator voucherListCopyToast;
    Locator voucherDetailSalinButtonActive;
    Locator voucherDetailImageBanner;
    Locator voucherDetailCampaignTitle;
    Locator voucherDetailExpiredDate;
    Locator voucherDetailSyaratDanKetentuanLabel;
    Locator voucherDetailSyaratDanKetentuanDescription;
    Locator voucherDetailKodeVoucherLabel;
    Locator voucherDetailVoucherCode;
    Locator voucherDetailTicketIcon;
    Locator voucherDetailSalinButtonDisabled;
    Locator voucherDetailTerpakaiLabel;
    Locator checkVoucherDetailDisabledVoucherCode;
    Locator checkVoucherDetailDisabledKodeVoucherLabel;
    Locator voucherDetailKedaluwarsaLabel;
    Locator checkVoucherListDisabledKodeVoucherKadaluwarsaLabel;
    Locator checkVoucherListDisabledVoucherKadaluwarsaCode;
    Locator tersediaEmptyState;
    Locator terpakaiEmptyState;
    Locator kedaluwarsaEmptyState;

    public VoucherSayaPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        voucherTitle = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Voucher Saya"));
        checkVoucherCard = page.locator(".voucher-card").first();
        checkVoucherPromoLainnya = page.getByText("Promo Lainnya");
        checkVoucherListImage = page.locator(".voucher-image").first();
        checkVoucherListExpiredDate = page.locator(".voucher-valid").first();
        checkVoucherListKodeVoucherLabel = page.locator(".voucher-code__text").first();
        checkVoucherListVoucherCode = page.locator(".voucher-code__code").first();
        checkVoucherListSalinButton = page.locator(".voucher-code__button").first();
        checkVoucherListTerpakaiLabel = page.locator("[alt='TerpakaiAuto2']").first();
        checkVoucherListDisabledKodeVoucherLabel = page.locator(".voucher-code__text.disable").first();
        checkVoucherListDisabledVoucherCode = page.locator(".voucher-code__code.disable").first();
        checkVoucherListKedaluwarsaLabel = page.locator("#expired a").first();
        voucherListSalinButtonActive = page.locator("//*[@class='button-text']").first();
        voucherListCopyToast = page.locator(".bg-c-toast__content");
        voucherDetailSalinButtonActive = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Salin Kode"));
        voucherDetailImageBanner = page.getByTestId("userVoucherDetail-bannerImg");
        voucherDetailCampaignTitle = page.locator(".voucher-detail-title__text");
        voucherDetailExpiredDate = page.getByText("Berlaku hingga 14 Mei 2034");
        voucherDetailSyaratDanKetentuanLabel = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Syarat dan Ketentuan"));
        voucherDetailSyaratDanKetentuanDescription = page.locator(".voucher-detail-term__text");
        voucherDetailKodeVoucherLabel = page.locator(".copy-code-text__label");
        voucherDetailVoucherCode = page.locator(".copy-code-text__code");
        voucherDetailTicketIcon = page.locator(".copy-code-text__icon");
        voucherDetailSalinButtonDisabled = page.locator(".bg-c-button");
        voucherDetailTerpakaiLabel = page.getByText("Terpakai", new Page.GetByTextOptions().setExact(true));
        checkVoucherDetailDisabledVoucherCode = page.locator(".copy-code-text__code.text-disable");
        checkVoucherDetailDisabledKodeVoucherLabel = page.locator("//p[@class='copy-code-text__label text-disable']");
        voucherDetailKedaluwarsaLabel = page.getByText("Kedaluwarsa");
        checkVoucherListDisabledKodeVoucherKadaluwarsaLabel = page.locator("#expired").getByText("Kode Voucher").first();
        checkVoucherListDisabledVoucherKadaluwarsaCode = page.getByText("VAFOROTHEREM1");
        tersediaEmptyState = page.getByText("Voucher yang dapat kamu gunakan akan tersedia di halaman ini");
        terpakaiEmptyState = page.getByText("Voucher yang telah kamu gunakan akan tampil di halaman ini");
        kedaluwarsaEmptyState = page.getByText("Voucher yang habis masa berlakunya akan tampil di halaman ini");
    }

    /**
     * Check header voucher
     * @return true if header present
     */
    public boolean isVoucherTitlePresent() {
        return voucherTitle.isVisible();
    }

    /**
     * Check tab on voucher
     * @return true if tab on voucher present
     */
    public boolean isTabPresent(String textTab) {
        return playwright.waitTillLocatorIsVisible(page.locator("//span[contains(.,'"+textTab+"')]").first());
    }

    /**
     * Check Voucher Card
     *
     * @return true if voucher card present
     */
    public boolean isVoucherCardVisible(){
        playwright.waitFor(checkVoucherCard, 5000.0);
        return checkVoucherCard.isVisible();
    }

    /**
     * Check Promo Lainnya text
     *
     * @return true if promo lainnya title present
     */
    public boolean isVoucherPromoLainnyaVisible() {
        return checkVoucherPromoLainnya.isVisible();
    }

    /**
     * Check Voucher Image in voucher List
     *
     */
    public boolean isVoucherListImageVisible() {
        return  checkVoucherListImage.isVisible();
    }

    /**
     * Check Voucher Expired Date in voucher list
     *
     */
    public boolean isVoucherListExpiredDateVisible() {
        return checkVoucherListExpiredDate.isVisible();
    }

    /**
     * Check Kode Voucher text in voucher list
     *
     */
    public boolean isVoucherListKodeVoucherLabelVisible() {
        return checkVoucherListKodeVoucherLabel.isVisible();
    }

    /**
     * Check voucher code in voucher list
     *
     */
    public boolean isVoucherListVoucherCodeVisible() {
        return checkVoucherListVoucherCode.isVisible();
    }

    /**
     * Check Salin button in voucher list
     *
     */
    public boolean isVoucherListSalinButtonVisible()  {
        return checkVoucherListSalinButton.isVisible();
    }

    /**
     * Click tab on voucher
     *
     */
    public void clickOnTabOnVoucher(String textTab) {
        playwright.clickOn(page.locator("//span[contains(.,'"+textTab+"')]").first());
    }

    /**
     * Check Terpakai label in voucher list
     *
     */
    public boolean isVoucherListTerpakaiLabelVisible() {
        return checkVoucherListTerpakaiLabel.isVisible();
    }

    /**
     * Check disabled Kode Voucher text in voucher list
     *
     */
    public boolean isVoucherListDisabledKodeVoucherLabelVisible() {
        return checkVoucherListDisabledKodeVoucherLabel.isVisible();
    }

    /**
     * Check disabled Voucher Code in voucher list
     *
     */
    public boolean isVoucherListDisabledVoucherCodeVisible() {
        return checkVoucherListDisabledVoucherCode.isVisible();
    }

    /**
     * Check Kedaluwarsa label in voucher list
     *
     */
    public boolean isVoucherListKedaluwarsaLabelVisible() {
        return checkVoucherListKedaluwarsaLabel.isVisible();
    }

    /**
     * Click Lihat button on Promo Lainnya
     *
     */
    public void clickPromoLainnyaButton() {
        playwright.clickOn(checkVoucherPromoLainnya);
    }

    /**
     * Click Salin button on voucher list
     *
     */
    public void clickVoucherListSalinButton() {
        playwright.clickOn(voucherListSalinButtonActive);
    }

    /**
     * Check if Voucher list toast appear after click Salin button in voucher list
     *
     */
    public boolean isVoucherListCopyToastVisible() {
        return voucherListCopyToast.isVisible();
    }

    /**
     * Click voucher on voucher list
     *
     */
    public void clickVoucherOnList() {
        playwright.clickOn(checkVoucherCard);
    }

    /**
     * Click Salin button on voucher detail
     *
     */
    public void clickVoucherDetailSalinButton() {
        playwright.clickOn(voucherDetailSalinButtonActive);
    }

    /**
     * Check if Image Banner element is present inside voucher detail
     *
     */
    public boolean isVoucherDetailImageBannerVisible() {
        playwright.waitFor(voucherDetailImageBanner);
        return voucherDetailImageBanner.isVisible();
    }

    /**
     * Check if Campaign Title element is present inside voucher detail
     *
     */
    public boolean isVoucherDetailCampaignTitleVisible() {
        return voucherDetailCampaignTitle.isVisible();
    }

    /**
     * Check if Expired Date element is present inside voucher detail
     *
     */
    public boolean isVoucherDetailExpiredDateVisible() {
        return voucherDetailExpiredDate.isVisible();
    }

    /**
     * Check if Syarat dan Ketentuan label element is present inside voucher detail
     *
     */
    public boolean isVoucherDetailSyaratDanKetentuanLabelVisible() {
        return voucherDetailSyaratDanKetentuanLabel.isVisible();
    }

    /**
     * Check if Syarat dan Ketentuan description/text element is present inside voucher detail
     *
     */
    public boolean isVoucherDetailSyaratDanKetentuanDescriptionVisible() {
        return voucherDetailSyaratDanKetentuanDescription.isVisible();
    }

    /**
     * Check if Kode Voucher label element is present inside voucher detail
     *
     */
    public boolean isVoucherDetailKodeVoucherLabelVisible() {
        return voucherDetailKodeVoucherLabel.isVisible();
    }

    /**
     * Check if Voucher Code element is present inside voucher detail
     *
     */
    public boolean isVoucherDetailVoucherCodeVisible() {
        return voucherDetailVoucherCode.isVisible();
    }

    /**
     * Check if Ticket Icon element is present inside voucher detail
     *
     */
    public boolean isVoucherDetailTicketIconVisible() {
        return voucherDetailTicketIcon.isVisible();
    }

    /**
     * Click on Voucher Card in terpakai tab
     *
     */
    public void clickTerpakaiVoucherCard() {
        playwright.clickOn(checkVoucherListTerpakaiLabel);
    }

    /**
     * Check if Salin button is disabled in voucher detail
     *
     */
    public boolean isVoucherDetailSalinButtonDisabledVisible() {
        return voucherDetailSalinButtonDisabled.isDisabled();
    }

    /**
     * Check if Terpakai Label element is present inside voucher detail
     *
     */
    public boolean isVoucherDetailTerpakaiLabelVisible() {
        return voucherDetailTerpakaiLabel.isVisible();
    }

    /**
     * Check disabled Voucher Code in voucher detail
     *
     */
    public boolean isVoucherDetailDisabledVoucherCodeVisible() {
        return checkVoucherDetailDisabledVoucherCode.isVisible();
    }

    /**
     * Check disabled Kode Voucher in voucher detail
     *
     */
    public boolean isVoucherDetailDisabledKodeVoucherLabelVisible() {
        return checkVoucherDetailDisabledKodeVoucherLabel.isVisible();
    }

    /**
     * Click on Voucher Card in kedaluwarsa tab
     *=
     */
    public void clickKedaluwarsaVoucherCard() {
        playwright.clickOn(checkVoucherListKedaluwarsaLabel);
    }

    /**
     * Check if Kedaluwarsa Label element is present inside voucher detail
     *
     */
    public boolean isVoucherDetailKedaluwarsaLabelVisible() {
        return voucherDetailKedaluwarsaLabel.isVisible();
    }

    /**
     * Check disabled Kode Voucher text in voucher list
     *
     */
    public boolean isVoucherListDisabledKodeVoucherKadaluwarsaLabelVisible() {
        return checkVoucherListDisabledKodeVoucherKadaluwarsaLabel.isVisible();
    }

    /**
     * Check disabled Voucher Code in voucher list
     *
     */
    public boolean isVoucherListDisabledVoucherCodeKadaluwarsaVisible() {
        return checkVoucherListDisabledVoucherKadaluwarsaCode.isVisible();
    }

    /**
     * Get Tersedia Empty state text
     *
     */
    public boolean isTersediaEmptyStateVisible() {
        playwright.pageScrollUntilElementIsVisible(tersediaEmptyState);
        return tersediaEmptyState.isVisible();
    }

    /**
     * Get Terpakai Empty state text
     *
     * @throws InterruptedException
     */
    public boolean isTerpakaiEmptyStateVisible() {
        playwright.pageScrollUntilElementIsVisible(terpakaiEmptyState);
        return terpakaiEmptyState.isVisible();
    }

    /**
     * Get Kedaluwarsa Empty state text
     *
     */
    public boolean isKedaluwarsaEmptyStateVisible() {
        playwright.pageScrollUntilElementIsVisible(kedaluwarsaEmptyState);
        return kedaluwarsaEmptyState.isVisible();
    }

}
