package pageobject.owner.mamiprime;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import data.mamikos.Mamikos;
import utilities.PlaywrightHelpers;

public class MamiprimePendaftaranPO {

    private Page page;
    private PlaywrightHelpers playwright;
    Locator nonGPInformationText;
    Locator labelPropertyFull;
    Locator propertyNamePrime;
    Locator imageFullforPrime;
    Locator informationFullforPrime;
    Locator descInformationPrime;

    public MamiprimePendaftaranPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.nonGPInformationText = page.locator(".bg-c-alert__content-description");
        this.labelPropertyFull = page.locator("//div[@class='bg-c-label bg-c-label--rainbow bg-c-label--rainbow-grey']");
        this.propertyNamePrime = page.locator(".prime-property-list__list-item-name");
        this.imageFullforPrime =  page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("Room already full"));
        this.informationFullforPrime = page.locator("//h4[@class='bg-c-empty-state__title']");
        this.descInformationPrime = page.locator(".bg-c-empty-state__description");



    }

    /**
     * Navigates to Pendaftaran Mamiprime page
     */
    public void navigatesToPendaftaranMamiprime() {
        playwright.navigateTo(Mamikos.OWNER_URL + Mamikos.MAMIPRIME_PENDAFTARAN, 30000.0, LoadState.LOAD);
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
}