package pageobject.owner.mamiads;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import data.mamikos.Mamikos;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;

public class MamiAdsPO {
    private Page page;
    private PlaywrightHelpers playwright;
    private LocatorHelpers locatorHelpers;
    //--- Saldo Mamiads Onboarding ---//
    private Locator saldoMamiadsCard;
    //--- Mamiads Webview Page ---//
    private Locator cobaSekarangBtnOnWebview;
    //--- Mamiads Page ---//
    private Locator cobaSekarangBtnOnPopUp;
    private Locator beliSaldoBtn;
    //--- Beli Saldo Mamiads Page ----//
    private Locator pilihSaldoBtnForFisrtVoucher;
    private Locator bayarSekarangBtnOnDetailTagihan;

    //--- GP Onboarding Pop - Up ---//
    Locator gpOnboardingPopUpActiveCounter;
    Locator gpOnboardingPopUpActiveTextHead;
    Locator gpOnboardingPopUpActiveTextBody;
    Locator gpOnboardingPopUpActiveImage;
    Locator gpOnboardingPopUpNextButton;
    Locator gpOnboardingPopUpSwipperBullet;
    Locator gpOnboardingPopUpPreviousButton;
    //--- GP Onboarding Pop - Up ---//

    public MamiAdsPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.locatorHelpers = new LocatorHelpers(page);
        //--- Saldo Mamiads Onboarding ---//
        this.saldoMamiadsCard = page.locator(".mamiads-card");
        //--- Mamiads Webview Page ---//
        this.cobaSekarangBtnOnWebview = page.locator("#globalNavbar").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Coba Sekarang"));
        //--- Mamiads Page ---//
        this.cobaSekarangBtnOnPopUp = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Coba Sekarang"));
        this.beliSaldoBtn = page.getByText("Beli Saldo");
        //--- Beli Saldo Mamiads Page ---//
        this.pilihSaldoBtnForFisrtVoucher = page.locator(".bg-c-button").first();
        this.bayarSekarangBtnOnDetailTagihan = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Bayar Sekarang"));

        //--- GP Onboarding Pop - Up ---//
        gpOnboardingPopUpActiveCounter = page.locator(".swiper-slide-active .gp-swiper__slide-counter");
        gpOnboardingPopUpActiveTextHead = page.locator(".swiper-slide-active .gp-swiper__slide-text p:nth-child(1)");
        gpOnboardingPopUpActiveTextBody = page.locator(".swiper-slide-active .gp-swiper__slide-text p:nth-child(2)");
        gpOnboardingPopUpActiveImage = page.locator(".swiper-slide-active img");
        gpOnboardingPopUpNextButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next slide"));
        gpOnboardingPopUpSwipperBullet = page.locator(".swiper-pagination-bullet");
        gpOnboardingPopUpPreviousButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Previous slide"));
    }

    /**
     * Get gp onboarding pop up active counter
     * @return Integer data type
     */
    public int getGpOnboardingpopUpActiveCounter() {
        return Integer.parseInt(gpOnboardingPopUpActiveCounter.innerText());
    }

    /**
     * Get gp onboarding pop up text head
     * @return String data type
     */
    public String getGpOnboardingpopUpTextHead() {
        return playwright.getText(gpOnboardingPopUpActiveTextHead);
    }

    /**
     * Get gp onboarding pop up text body
     * @return String data type
     */
    public String getGpOnboardingpopUpTextBody() {
        return playwright.getText(gpOnboardingPopUpActiveTextBody);
    }

    /**
     * Get gp onboarding pop up image alt attribute value
     * @return String data type
     */
    public String getGpOnboardingpopUpImageAltAttributeValue() {
        return playwright.getAttributeValue(gpOnboardingPopUpActiveImage, "alt");
    }

    /**
     * Click on gp onboarding pop up next button
     */
    public void clickGpOnboardingpopUpNextButton() {
        playwright.clickOn(gpOnboardingPopUpNextButton);
    }

    /**
     * Get gp onboarding pop up swiper bullet count
     * @return Integer data type
     */
    public boolean isGpOnboardingpopUpPreviousButtonDisabled() {
        return playwright.getAttributeValue(gpOnboardingPopUpPreviousButton, "aria-disabled").equals("true");
    }

    /**
     * Get gp onboarding pop up swiper bullet count
     * @return Integer data type
     */
    public boolean isGpOnboardingpopUpNextButtonDisabled() {
        return playwright.getAttributeValue(gpOnboardingPopUpNextButton, "aria-disabled").equals("true");
    }

    /**
     * Click on gp onboarding pop up swiper bullet
     */
    public void clickGpOnboardingpopUpPreviousButton() {
        playwright.clickOn(gpOnboardingPopUpPreviousButton);
    }

    /**
     * owner buy mamiads saldo for the first voucher on list,
     * on jambu the price is Rp.6000,00
     */
    public void ownerBuyMamiAdsSaldoAndPickTheFirstVoucherList() {
        playwright.clickOn(saldoMamiadsCard);
        // this condition will handle if owner redirect to the https://jambu.kerupux.com/mamiads?redirectionSource=Owner%20Dashboard
        if (playwright.getActivePageURL().equals(Mamikos.URL + "/mamiads?redirectionSource=Owner%20Dashboard") ||
                playwright.waitTillLocatorIsVisible(cobaSekarangBtnOnWebview))
            playwright.clickOn(cobaSekarangBtnOnWebview);
        // this condition will handle for pop up that appear when owner visit https://owner-jambu.kerupux.com/mamiads
        if (playwright.waitTillLocatorIsVisible(cobaSekarangBtnOnPopUp)
                || !playwright.waitTillLocatorIsVisible(beliSaldoBtn))
            playwright.clickOn(cobaSekarangBtnOnPopUp);
        playwright.clickOn(beliSaldoBtn);
        playwright.clickOn(pilihSaldoBtnForFisrtVoucher);
        playwright.clickOn(bayarSekarangBtnOnDetailTagihan);
        page.reload();
    }
}

