package pageobject.owner.mamiprime;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;
import config.global.GlobalConfig;
import data.mamikos.Mamikos;
import utilities.PlaywrightHelpers;

public class MamiprimePendaftaranPO {

    private Page page;
    private PlaywrightHelpers playwright;
    Locator nonGPInformationText;
    Locator lanjutkanBtn;
    Locator labelPropertyFull;
    Locator propertyNamePrime;
    Locator imageFullforPrime;
    Locator informationFullforPrime;
    Locator descInformationPrime;
    Locator listAllPeriode;
    Locator ubahTagihanPrime;
    Locator ubahTagihanPrimeHeader;
    Locator registerPrimeHeader;
    Locator btnLanjutBayar;


    public MamiprimePendaftaranPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.nonGPInformationText = page.locator(".bg-c-alert__content-description");
        this.lanjutkanBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lanjutkan"));
        this.labelPropertyFull = page.locator("//div[@class='bg-c-label bg-c-label--rainbow bg-c-label--rainbow-grey']");
        this.propertyNamePrime = page.locator(".prime-property-list__list-item-name");
        this.imageFullforPrime =  page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("Room already full"));
        this.informationFullforPrime = page.locator("//h4[@class='bg-c-empty-state__title']");
        this.descInformationPrime = page.locator(".bg-c-empty-state__description");
        this.listAllPeriode = page.locator(".prime-period__grid");
        this.ubahTagihanPrime = page.locator(".prime-payment-detail__change-package");
        this.ubahTagihanPrimeHeader = page.locator(".bg-c-text--heading-4");
        this.registerPrimeHeader = page.locator(".prime-package__title");
        this.btnLanjutBayar = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lanjut Bayar"));

    }

    /**
     * Navigates to Pendaftaran Mamiprime page
     */
    public void navigatesToPendaftaranMamiprime() {
        playwright.navigateTo(Mamikos.OWNER_URL + Mamikos.MAMIPRIME_PENDAFTARAN, GlobalConfig.LONG_TIMEOUT, LoadState.LOAD);
    }

    /**
     * Get Text Non GP Information about Mamiprime
     *
     * @return string
     */
    public String getNonGPInformationText()  {
        return playwright.getText(nonGPInformationText).replaceAll("\\s", "");
    }

    /**
     * Get Text property name from list property
     *
     * @return string
     */
    public String getPropertyNamePrime()  {
        playwright.waitFor(propertyNamePrime);
        return playwright.getText(propertyNamePrime);
    }

    /**
     * Get Text at label property prime
     *
     * @return string
     */
    public String getLabelTextFull()  {
        playwright.waitFor(labelPropertyFull);
        return playwright.getText(labelPropertyFull);
    }

    /**
     * Get Text at label property prime
     *
     * @return string
     */
    public boolean checkImageFullisShow(){
        playwright.waitFor(imageFullforPrime);
        return playwright.waitTillLocatorIsVisible(imageFullforPrime);
    }

    /**
     * Get Text information Kos Ini Sedang Penuh or Kuota Daerah Kos Penuh
     *
     * @return string
     */
    public String getInformationTextPrimeFull()  {
        playwright.waitFor(informationFullforPrime);
        return playwright.getText(informationFullforPrime);
    }

    /**
     * Get Text information Kos Ini Sedang Penuh
     *
     * @return string
     */
    public String getDescInformationTextPrimeFull()  {
        playwright.waitFor(descInformationPrime);
        return playwright.getText(descInformationPrime);
    }

    /**
     * Verified label kuota or kamar penuh is appear
     *
     * @return true or false
     */
    public boolean isLabelFullPrimeisAppear()  {
        playwright.waitFor(propertyNamePrime);
       return playwright.waitTillLocatorIsVisible(labelPropertyFull);
    }

    /**
     * Verified list periode is show
     *
     * @return true or false
     */
    public boolean isListPeriodeAppear()  {
        playwright.waitForSelectorState(listAllPeriode, WaitForSelectorState.VISIBLE, GlobalConfig.LONG_TIMEOUT);
        return playwright.waitTillLocatorIsVisible(listAllPeriode);
    }

    /**
     * Click on button lanjut bayar prime
     */
    public void clickOnlanjutBayarPrime() {
        playwright.clickOn(btnLanjutBayar);
    }

    /**
     * Verified button lanjut bayar on periode mamiprime is disable or enable
     *
     * @return true or false
     */
    public boolean isLanjutBayarButtonDisable()  {
        playwright.waitFor(btnLanjutBayar);
        return playwright.isButtonDisable(btnLanjutBayar);
    }

    /**
     * Verify package prime at detail tagihan page
     * @param packagePrime
     * return package prime
     */
    public String getPackagePrimeDetailTagihan(String packagePrime) {
        Locator packagePrimeResult = page.getByText(packagePrime).first();
        return playwright.getText(packagePrimeResult);
    }

    /**
     * Verified detail tagihan page is show
     *
     * @return true or false
     */
    public boolean isDetailTagihanAppear()  {
        playwright.waitFor(ubahTagihanPrimeHeader);
        return playwright.waitTillLocatorIsVisible(ubahTagihanPrimeHeader);
    }

    /**
     * Click on ubah at detail tagihan page
     */
    public void clickOnUbahTagihanPrime() {
        playwright.clickOn(ubahTagihanPrime);
    }

    /**
     * Verified pendaftaran prime page is appear
     *
     * @return true or false
     */
    public boolean isPendaftaranPrimeAppear()  {
        playwright.waitFor(registerPrimeHeader);
        return playwright.waitTillLocatorIsVisible(registerPrimeHeader);
    }

    public void selectOptionMamiprime(String mamiprimeOption) {
        playwright.clickOn(
                page.getByTestId("package-placement-result")
                        .locator("div")
                        .filter(new Locator.FilterOptions()
                                .setHasText(mamiprimeOption))
                        .nth(3)
        );
        playwright.clickOn(lanjutkanBtn);
    }
}