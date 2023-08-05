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
    private Locator inputAmountPlaceHolderOnEditPage;
    private Locator saveBtnOnEditPage;

    public AdminFeeDiscountPO(Page page) {
        this.page = page;
        this.playwrightHelpers = new PlaywrightHelpers(page);
        this.adminFeeMenu = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Invoice Admin Fee Discount"));
        this.editBtnFirstAdminOnList = page.getByRole(AriaRole.LINK).getByText("Edit").first();
        this.inputAmountPlaceHolderOnEditPage = page.getByRole(AriaRole.SPINBUTTON);
        this.saveBtnOnEditPage = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save"));
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
     * save action for edit admin fee page
     */
    public void saveEditAdminFee() {
        playwrightHelpers.clickOn(saveBtnOnEditPage);
    }
}
