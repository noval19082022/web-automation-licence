package pageobject.admin.mamipay.bangkrupux;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.JavaHelpers;
import utilities.PlaywrightHelpers;

public class AdminSanJuniperoPO {
    Page page;
    private PlaywrightHelpers playwrightHelpers;
    private Locator createNewParentBtn;
    private Locator slugPlaceHolder;
    private Locator kostTypePlaceHolder;
    private Locator biayaSewaPlaceHolder;
    private Locator titleTagPlaceHolder;
    private Locator titleHeaderPlaceHolder;
    private Locator subTitleHeaderPlaceHolder;
    private Locator facilityPlaceHolder;
    private Locator faqPlaceHolder;
    private Locator faqAnswerPlaceHolder;
    private Locator checkBoxActive;
    private Locator saveBtn;
    private Locator successMessageOnCreateSanJunipero;
    private Locator previewBtn;
    private Locator deactivateBtn;
    private Locator activateBtn;
    private Locator lastUpdateRow;


    public AdminSanJuniperoPO(Page page) {
        this.page = page;
        this.playwrightHelpers = new PlaywrightHelpers(page);
        this.createNewParentBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Add New Parent"));
        this.slugPlaceHolder = page.getByPlaceholder("For slug");
        this.kostTypePlaceHolder = page.locator("#typeKost_chosen");
        this.biayaSewaPlaceHolder = page.locator("#biayaSewa_chosen");
        this.titleTagPlaceHolder = page.getByPlaceholder("For title tag");
        this.titleHeaderPlaceHolder = page.getByPlaceholder("For title header");
        this.subTitleHeaderPlaceHolder = page.getByPlaceholder("For subtitle header");
        this.facilityPlaceHolder = page.locator("#facilityTag_chosen");
        this.faqPlaceHolder = page.locator("input[name='faq_question[]']");
        this.faqAnswerPlaceHolder = page.locator("textarea[name='faq_answer[]']");
        this.checkBoxActive = page.getByRole(AriaRole.INSERTION).nth(1);
        this.saveBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save"));
        this.successMessageOnCreateSanJunipero = page.getByText("Success! Record success to saved.");
        this.previewBtn = page.locator("//i[@class='fa fa-external-link']").first();
        this.deactivateBtn = page.locator("//a[@title='Deactivate']").first();
        this.activateBtn = page.locator("//a[@title='Activate']").first();
        this.lastUpdateRow = page.locator("(//tr/td)[5]");
    }

    /**
     * create new parent San Junipero
     */
    public void createNewParent() {
        playwrightHelpers.clickOn(createNewParentBtn);
    }

    /**
     * fill slug on create new san junipero
     *
     * @param slug
     */
    public void setSlugOnCreateSanJunipero(String slug) {
        playwrightHelpers.clickLocatorAndTypeKeyboard(slugPlaceHolder, slug);
    }

    /**
     * fill kost type on create san junipero
     *
     * @param kostType
     */
    public void setKostTypeOnCreateSanJunipero(String kostType) {
        playwrightHelpers.clickLocatorAndTypeKeyboard(kostTypePlaceHolder.getByRole(AriaRole.TEXTBOX), kostType);
        playwrightHelpers.clickOn(kostTypePlaceHolder.getByText(kostType));
    }

    /**
     * fill biaya sewa on create san junipero
     *
     * @param biayaSewa
     */
    public void setBiayaSewaOnCreateSanJunipero(String biayaSewa) {
        playwrightHelpers.clickLocatorAndTypeKeyboard(biayaSewaPlaceHolder.getByRole(AriaRole.TEXTBOX), biayaSewa);
        playwrightHelpers.clickOn(biayaSewaPlaceHolder.getByText(biayaSewa));
    }

    /**
     * fill title tag on create san junipero
     *
     * @param titleTag
     */
    public void setTitleTagOnCreateSanJunipero(String titleTag) {
        playwrightHelpers.clickLocatorAndTypeKeyboard(titleTagPlaceHolder, titleTag);
    }

    /**
     * fill title header on create san junipero
     *
     * @param titleHeader
     */
    public void setTitleHeaderOnCreateSanJunipero(String titleHeader) {
        playwrightHelpers.clickLocatorAndTypeKeyboard(titleHeaderPlaceHolder, titleHeader);
    }

    /**
     * fill subtitle header on create san junipero
     *
     * @param subTitleHeader
     */
    public void setSubTitleOnCreateSanJunipero(String subTitleHeader) {
        playwrightHelpers.clickLocatorAndTypeKeyboard(subTitleHeaderPlaceHolder, subTitleHeader);
    }

    /**
     * fill facility on create san junipero
     *
     * @param facility
     */
    public void setFacilityOnCreateSanJunipero(String facility) {
        playwrightHelpers.clickLocatorAndTypeKeyboard(facilityPlaceHolder.getByRole(AriaRole.TEXTBOX), facility);
        playwrightHelpers.clickOn(facilityPlaceHolder.getByText(facility));
    }

    /**
     * fill FAQ on create san junipero
     *
     * @param faq
     */
    public void setFaqOnCreateSanJunipero(String faq) {
        playwrightHelpers.waitTillLocatorIsVisible(faqPlaceHolder.first(), 30000.0);
        playwrightHelpers.clickLocatorAndTypeKeyboard(faqPlaceHolder.first(), faq);
        playwrightHelpers.hardWait(2000); // Wait after FAQ question to ensure answer field becomes available
    }

    /**
     * fill FAQ answer on create san junipero
     *
     * @param faqAnswer
     */
    public void setFaqAnswerOnCreateSanJunipero(String faqAnswer) {
        try {
            // Try primary selector (textarea)
            if (playwrightHelpers.waitTillLocatorIsVisible(faqAnswerPlaceHolder.first(), 10000.0)) {
                playwrightHelpers.hardWait(2000);
                playwrightHelpers.fill(faqAnswerPlaceHolder.first(), faqAnswer);
                return;
            }
        } catch (Exception e) {
            // Continue to fallback
        }
        
        // Try fallback selectors
        Locator[] fallbackSelectors = {
            page.locator("input[name='faq_answer[]']").first(),
            page.getByLabel("FAQ Answer").first(),
            page.getByLabel("Answer").first(),
            page.getByPlaceholder("answer").first()
        };
        
        for (Locator selector : fallbackSelectors) {
            try {
                if (playwrightHelpers.waitTillLocatorIsVisible(selector, 5000.0)) {
                    playwrightHelpers.fill(selector, faqAnswer);
                    return;
                }
            } catch (Exception e) {
                continue;
            }
        }
        
        // If still not found, throw meaningful error
        throw new RuntimeException("FAQ answer field not found with any selector. Available fields might need 'Add FAQ' button clicked first.");
    }

    /**
     * checkmar active on create san junipero
     */
    public void cekActiveOnCreateSanJunipero() {
        playwrightHelpers.waitTillLocatorIsVisible(checkBoxActive, 10000.0);
        playwrightHelpers.clickOn(checkBoxActive);
    }

    /**
     * clickOn save Btn on create san junipero
     */
    public void saveOnCreateSanJunipero() {
        playwrightHelpers.clickOn(saveBtn);
    }

    /**
     * Get Success Message On Create San Junipero
     *
     * @return
     */
    public String getSuccessMessageOnCreateSanJunipero() {
        return JavaHelpers.
                removeCharAndWhiteSpaceFromString(
                        playwrightHelpers.getText(successMessageOnCreateSanJunipero),
                        "×");
    }

    /**
     * click on preview action san junipero
     */
    public void clickOnPreviewAction() {
        playwrightHelpers.clickOn(previewBtn);
    }

    /**
     * click on deactivate action san junipero
     */
    public void clickOnDeactiveAction() {
        playwrightHelpers.clickOn(deactivateBtn);
    }

    /**
     * get current updated time
     * @return
     */
    public String getCurrentTimeUpdate() {
        playwrightHelpers.waitTillPageLoaded();
        return playwrightHelpers.getText(lastUpdateRow);
    }

    /**
     * click on activate action san junipero
     */
    public void clickOnActiveAction() {
        playwrightHelpers.clickOn(activateBtn);
    }
}
