package pageobject.admin.mamipay.contract;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import utilities.JavaHelpers;
import utilities.PlaywrightHelpers;

import java.util.List;

public class SearchContractPO {
    private Page page;
    private PlaywrightHelpers playwright;
    Locator searchContract;
    Locator searchBy;
    Locator searchInput;
    Locator searchButton;
    Locator batalkanContractButton;
    Locator berhentikanContractButton;
    Locator inputTerminateDate;
    Locator berhentikanContractPopUpButton;
    Locator akhiriContractLink;
    Locator selectTerminateDate;
    Locator successTerminateText;
    private Locator editDepositBtn;
    private Locator inputTextDetailKerusakan;
    private Locator seeLogBtn;
    private Locator akhiriContractButton;
    private Locator akhiriContractHead;

    public SearchContractPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        searchContract = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Search Contract"));
        searchBy = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Search by"));
        searchButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search"));
        searchInput = page.getByPlaceholder("Search");
        batalkanContractButton = page.locator("//*[.='Batalkan Kontrak']");
        berhentikanContractButton = page.locator(".tools-contract__btn-danger");
        inputTerminateDate = page.getByPlaceholder("Masukkan tanggal checkout");
        berhentikanContractPopUpButton = page.getByRole(AriaRole.DIALOG, new Page.GetByRoleOptions().setName("Akhiri Kontrak Sewa")).getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Akhiri Kontrak"));
        selectTerminateDate = page.locator(".skin-green > div:nth-of-type(2) > .xdsoft_timepicker .xdsoft_current");
        akhiriContractLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Akhiri Kontrak"));
        akhiriContractButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Akhiri Kontrak"));
        successTerminateText = page.getByText("Kontrak berhasil diakhiri.");
        akhiriContractHead = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Akhiri Kontrak Sewa"));
        editDepositBtn = page.locator("a").getByText("Edit Deposit").first();
        inputTextDetailKerusakan = page.getByRole(AriaRole.DIALOG, new Page.GetByRoleOptions().setName("Edit Deposit for Confirm to Finance")).locator("textarea[name='remark']");
        seeLogBtn = page.locator("a").getByText("See log").first();
    }

    /**
     * Select dropdown search kost level
     *
     * @param kostLevel option value String type
     */
    public void selectKosLevel(String kostLevel) {
        page.locator(".select2-search").click();
        page.keyboard().type(kostLevel);
        page.keyboard().press("Enter");
    }

    /**
     * Select dropdown search contract periode
     *
     * @param periode
     */
    public void selectPeriodSearchContract(String periode) {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Contract Date Period ")).click();
        page.locator("li").getByText(periode).click();
    }

    /**
     * Click on edit deposit button
     */
    public void clickOnEditDepositButton() {
        editDepositBtn.click();
    }

    /**
     * input text detail kerusakan
     *
     * @param text
     */
    public void inputDetailKerusakan(String text) {
        inputTextDetailKerusakan.click();
        page.keyboard().type(text);
    }

    /**
     * Click on see log button
     */
    public void clickOnSeeLogButton() {
        seeLogBtn.click();
    }

    /**
     * check if data is not null
     *
     * @return boolean
     */
    public boolean checkDataIsNotNull() {
        return !page.locator("tbody").first().locator("tr").first().isVisible();
    }

    /**
     * check if search contract header is visible
     *
     * @return boolean
     */
    public boolean isSearchContractHeaderVisible() {
        return page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Search Contract")).isVisible();
    }

    /**
     * Select dropdown search by it value
     *
     * @param optionValue option value String type
     */
    public void selectSearchBy(String optionValue) {
        searchBy.selectOption(optionValue);
    }

    /**
     * Fill search input value
     *
     * @param search String type e.g (Phone Number Tenant or Phone Number Owner)
     */
    public void fillSearchByValue(String search) {
        searchInput.fill(search);
    }

    /**
     * Click on search button
     */
    public void clickOnSearchButton() {
        searchButton.click();
    }


    /**
     * check if akhiri kontak button on terminate kontrak pop up is disable
     *
     * @return boolean
     */
    public Boolean isTerminatedContractButtonDissable() {
        if (page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Akhiri Kontrak")).isVisible()) {
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Akhiri Kontrak")).click();
        }
        return page.locator("div").locator("input").getByText("Akhiri Kontrak").isDisabled();
    }

    /**
     * Set accept dialog and click on revoke/batalkan contract button
     */
    public void clickOnCancelContractButton() {
        if (playwright.waitTillLocatorIsVisible(batalkanContractButton, 5000.00)) {
            playwright.acceptDialog(batalkanContractButton);
            page.waitForSelector(".callout.callout-success");
        }
    }

    /**
     * Set accept dialog and click on terminate contract button
     */
    public void clickOnTerminateContractButton() {
        if (playwright.waitTillLocatorIsVisible(berhentikanContractButton, 5000.00)) {
            playwright.acceptDialog(berhentikanContractButton);

            if (inputTerminateDate.isVisible()) {
                inputTerminateDate.click();
                selectTerminateDate.click();
                berhentikanContractPopUpButton.click();
            }
            page.waitForSelector(".callout.callout-success");
        }
    }


    /**
     * Wait until terminated is process is finished
     *
     * @return
     */
    public boolean waitUntilSuccessTerminateVisible() {
        return successTerminateText.isVisible();
    }

    /**
     * Get success terminate heading text
     *
     * @return String data type
     */
    public String getSuccessTerminateHeadingText() {
        return playwright.getText(successTerminateText);
    }

    /**
     * Click on akhiri contract button, and accept akhiri kontrak dialog.
     * Or input date if date picker appear.
     */
    public void clickOnAkhiriContractButton() {
        page.waitForLoadState(LoadState.LOAD);
        if (akhiriContractLink.isVisible()) {
            playwright.acceptDialog(akhiriContractLink);
        } else if (akhiriContractButton.isVisible()) {
            playwright.clickOn(akhiriContractButton);
            inputTerminateDate.fill(JavaHelpers.getCurrentDateOrTime("dd-MM-yyyy HH:mm:ss"));
            playwright.forceClickOn(akhiriContractHead);
            List<Locator> akhiriContractButtonList = akhiriContractButton.all();
            for (Locator akhiriButton : akhiriContractButtonList) {
                if (akhiriButton.isVisible() && akhiriButton.isEnabled()) {
                    playwright.clickOn(akhiriButton);
                }
            }
            page.waitForLoadState(LoadState.LOAD);
        }
    }

    /**
     * Click on batalkan kontrak on admin pay if kontrak is exist
     */
    public void batalkanContractIfExist() {
        if (page.getByText("Batalkan Kontrak").first().isVisible()) {
            page.onDialog(dialog -> dialog.accept());
            page.getByText("Batalkan Kontrak").first().click();
        }
    }
}
