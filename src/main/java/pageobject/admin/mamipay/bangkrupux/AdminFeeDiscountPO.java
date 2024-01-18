package pageobject.admin.mamipay.bangkrupux;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class AdminFeeDiscountPO {
    Page page;
    PlaywrightHelpers playwrightHelpers;
    private Locator adminFeeMenu;
    private Locator editBtnFirstAdminOnList;
    private Locator createAdminFeeBtnOnList;
    private Locator inputAmountPlaceHolderOnEditPage;
    private Locator inputNamePlaceHolderOnCreate;
    private Locator inputAmountPlaceHolderOnCreate;
    private Locator selectKostLevelBox;
    private Locator saveBtn;
    private Locator deleteBtn;

    public AdminFeeDiscountPO(Page page) {
        this.page = page;
        this.playwrightHelpers = new PlaywrightHelpers(page);
        this.adminFeeMenu = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Invoice Admin Fee Discount"));
        this.editBtnFirstAdminOnList = page.getByRole(AriaRole.LINK).getByText("Edit").first();
        this.createAdminFeeBtnOnList = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add Discount Settings"));
        this.inputAmountPlaceHolderOnEditPage = page.getByRole(AriaRole.SPINBUTTON);
        this.inputNamePlaceHolderOnCreate = page.getByRole(AriaRole.TEXTBOX);
        this.selectKostLevelBox = page.getByRole(AriaRole.COMBOBOX);
        this.inputAmountPlaceHolderOnCreate = page.getByRole(AriaRole.SPINBUTTON);
        this.saveBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save"));
        this.deleteBtn = page.getByRole(AriaRole.ROW).getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Delete")).last();
    }

    /**
     * click on admin fee menu discount
     */
    public void clickOnAdminFeeMenu() {
        playwrightHelpers.clickOn(adminFeeMenu);
    }

    /**
     * click on edit btn for the first admin fee list
     */
    public void clickOnEditFirstAdminFeeList() {
        playwrightHelpers.clickOn(editBtnFirstAdminOnList);
    }

    /**
     * input amount on edit page admin fee
     *
     * @param amount
     */
    public void inputAmountOnEditPage(String amount) {
        playwrightHelpers.clearText(inputAmountPlaceHolderOnEditPage);
        playwrightHelpers.clickLocatorAndTypeKeyboard(inputAmountPlaceHolderOnEditPage, amount);
    }

    /**
     * save action
     */
    public void saveAction() {
        playwrightHelpers.clickOn(saveBtn);
    }

    /**
     * admin delete last admin fee on list
     */
    public void deleteLastAdminFeeOnlist() {
        playwrightHelpers.acceptDialog(deleteBtn);
    }

    /**
     * fill admin fee name when creat new admin fee discount
     * @param name
     */
    public void fillOnAdminFeeName(String name) {
        playwrightHelpers.clickLocatorAndTypeKeyboard(inputNamePlaceHolderOnCreate, name);
    }

    /**
     * selectKostLevel
     */
    public void selectKostLevelOnCreate() {
        playwrightHelpers.selectDropdownByValue(selectKostLevelBox, "6");
    }

    /**
     * fill admin fee name
     * @param amount
     */
    public void fillOnAdminFeeAmount(String amount) {
        playwrightHelpers.clickLocatorAndTypeKeyboard(inputAmountPlaceHolderOnCreate, amount);
    }

    /**
     * create new admin fee discount from list
     */
    public void createNewAdminFeeDiscountBtn() {
        playwrightHelpers.clickOn(createAdminFeeBtnOnList);
    }

    /**
     * delete admin fee that has name
     * @param adminFeeName
     */
    public void deleteAdminFeeName(String adminFeeName) {
        Locator adminFee = page.getByRole(AriaRole.ROW, new Page.GetByRoleOptions().setName(adminFeeName)).getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Delete"));
        playwrightHelpers.acceptDialog(adminFee);
    }
}
