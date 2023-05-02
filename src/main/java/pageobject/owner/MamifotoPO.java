package pageobject.owner;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import pageobject.common.SearchPO;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;

import java.util.List;

public class MamifotoPO {
    private Page page;
    private PlaywrightHelpers playwright;
    private LocatorHelpers locatorHelpers;


    //Locator Mamifoto at owner dashboard
    Locator mamifotoMenuSidebar;
    Locator fiturPromosiSidebar;
    Locator homeOwnerSidebar;
    Locator titleTingkatkanKinerja;
    Locator subtitleTingkatkanKinerja;
    Locator sewaMamifoto;
    Locator mamifotoInfoUntukAnda;

    //Locator Mamifoto Landing Page
    Locator headerMamifoto;
    Locator lihatPaketButton;
    Locator packageFirstMamifotoNonGP;
    Locator popUpDoesntHaveProperty;
    Locator addedNewKostPopUpButton;
    Locator nantiSajaButton;

    public MamifotoPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.locatorHelpers = new LocatorHelpers(page);
        this.mamifotoMenuSidebar = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("MamiFoto").setExact(true));
        this.headerMamifoto = page.getByTestId("mamifoto-landing-header").getByText("MamiFoto", new Locator.GetByTextOptions().setExact(true));
        this.fiturPromosiSidebar = page.getByText("Fitur Promosi");
        this.homeOwnerSidebar = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Home"));
        this.titleTingkatkanKinerja = page.getByText("Tingkatkan Kinerja Kos");
        this.subtitleTingkatkanKinerja =  page.getByText("Lengkapi kos Anda dengan fitur berikut.");
        this.sewaMamifoto = page.locator("a").filter(new Locator.FilterOptions().setHasText("camera MamiFoto Sewa jasa foto kos profesional chevron-right"));
        this.mamifotoInfoUntukAnda = page.locator("a").filter(new Locator.FilterOptions().setHasText("Sewa jasa foto & video profesional dari Mami foto dan tingkatkan daya tarik kosa"));
        this.lihatPaketButton =   page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lihat Paket"));
        this.packageFirstMamifotoNonGP = page.getByTestId("select-mamifoto-package").first();
        this.popUpDoesntHaveProperty =  page.getByText("Anda Belum Memiliki Properti Tambahkan properti terlebih dahulu.");
        this.addedNewKostPopUpButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tambah Kos"));
        this.nantiSajaButton =  page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Nanti Saja"));

    }


    /**
     * Click on Fitur Promosi Sidebar menu
     */
    public void clickOnFiturPromosi() {
        fiturPromosiSidebar.click();
    }

    /**
     * Click on Home Owner Sidebar menu
     */
    public void clickOnHomeMenuOwner() {
        homeOwnerSidebar.click();
    }

    /**
     * Click on Mamifoto Sidebar menu
     */
    public void clickOnMamifotoSidebar() {
        mamifotoMenuSidebar.click();
    }


    /**
     * Check Mamifoto Header is appear
     *
     * @return boolean type, appear true otherwise false
     */
    public boolean mamifotoHeaderLandingPageisAppear() {
        return headerMamifoto.isVisible();
    }

    /**
     * Click on Mamifoto at section tingkatkan kinerja kos
     */
    public void clickOnSewaMamifoto() {
        sewaMamifoto.click();
    }

    /**
     * Get Title at section kinerja kost
     * @return string
     */
    public String getKinerjaTitle() throws InterruptedException {
        return playwright.getText(titleTingkatkanKinerja);
    }

    /**
     * Get subtitle at section kinerja kost
     * @return string
     */
    public String getKinerjaSubTitle() throws InterruptedException {
        return playwright.getText(subtitleTingkatkanKinerja);
    }

    /**
     * Get Text Mamifoto at section Info Untuk Anda
     * @return string
     */
    public String getMamifotoInfoUntukAndaText() throws InterruptedException {
        return playwright.getText(mamifotoInfoUntukAnda);
    }

    /**
     * Click on Mamifoto at section Info untuk Anda
     */
    public void clickOnMamifotoInfoUntukAnda() {
        mamifotoInfoUntukAnda.click();
    }

    /**
     * Click on button Lihat Paket
     */
    public void clickOnLihatPaket() {
        lihatPaketButton.click();
    }

    /**
     * Click on package mamifoto non GP first list
     */
    public void clickOnMamifotoPackageNonGPFirst() {
        packageFirstMamifotoNonGP.click();
    }

    /**
     * Get Pop Up doesnt have property
     * @return pop up is appear
     */
    public boolean getPopUpDoesntHaveProperty() {
        return popUpDoesntHaveProperty.isVisible();
    }

    /**
     * Get button Tambah Kos at pop up doesnt have property
     * @return button added new kost is appear
     */
    public boolean getAddedNewKostPopUpButton() {
        return addedNewKostPopUpButton.isVisible();
    }

    /**
     * Get button Nanti Saja at pop up doesnt have property
     * @return button Nanti Saja is appear
     */
    public boolean getNantiSajaButton() {
        return nantiSajaButton.isVisible();
    }

    /**
     * Click on nanti saja button
     */
    public void clickOnNantiSajaButton() {
      nantiSajaButton.click();
    }
}
