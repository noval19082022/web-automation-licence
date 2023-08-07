package pageobject.admin.mamipay.bangkrupux;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class AddOnsListPO {
    Page page;
    PlaywrightHelpers playwrightHelpers;
    private Locator createAddOnsBtn;
    private Locator namePlaceHolder;
    private Locator descriptionPlaceHolder;
    private Locator pricePlaceHolder;
    private Locator notesPlaceHolder;
    private Locator createActionBtn;
    private Locator updateActionBtn;
    private Locator cancelActionBtn;
    private Locator yesBtnDialog;
    private Locator cancelPopUpBtn;
    private Locator acceptDeleteBtnOnPopUp;

    public AddOnsListPO(Page page) {
        this.page = page;
        this.playwrightHelpers = new PlaywrightHelpers(page);
        this.createAddOnsBtn = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Create Add On"));
        this.namePlaceHolder = page.locator("#name-add-on");
        this.descriptionPlaceHolder = page.locator("input[name='short_description']");
        this.pricePlaceHolder = page.getByRole(AriaRole.SPINBUTTON);
        this.notesPlaceHolder = page.getByPlaceholder("Input notes");
        this.createActionBtn = page.locator("a").filter(new Locator.FilterOptions().setHasText("Create Add On"));
        this.updateActionBtn = page.locator("a").filter(new Locator.FilterOptions().setHasText("Update Add On"));
        this.cancelActionBtn = page.locator("a").filter(new Locator.FilterOptions().setHasText("Cancel"));
        this.yesBtnDialog = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Yes"));
        this.cancelPopUpBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cancel"));
        this.acceptDeleteBtnOnPopUp = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("DELETE").setExact(true));
    }

    /**
     * create new add ons action
     */
    public void createNewAddOnsAction() {
        playwrightHelpers.clickOn(createAddOnsBtn);
    }

    /**
     * input field create or edit add ons
     *
     * @param name
     * @param description
     * @param price
     * @param notes
     */
    public void inputCreateOrEditField(String name, String description, String price, String notes) {
        playwrightHelpers.clearText(namePlaceHolder);
        playwrightHelpers.clickLocatorAndTypeKeyboard(namePlaceHolder, name);
        playwrightHelpers.clearText(descriptionPlaceHolder);
        playwrightHelpers.clickLocatorAndTypeKeyboard(descriptionPlaceHolder, description);
        playwrightHelpers.clearText(pricePlaceHolder);
        playwrightHelpers.clickLocatorAndTypeKeyboard(pricePlaceHolder, price);
        playwrightHelpers.clearText(notesPlaceHolder);
        playwrightHelpers.clickLocatorAndTypeKeyboard(notesPlaceHolder, notes);
    }

    /**
     * create add ons after input field
     */
    public void createAddOnsAfterInputField() {
        playwrightHelpers.clickOn(createActionBtn);
        if (yesBtnDialog.isVisible()) playwrightHelpers.clickOn(yesBtnDialog);
    }

    /**
     * cancel pop up "Please complete all mandatory fields"
     */
    public void cancelPopUp() {
        if (createAddOnsBtn.isVisible()) playwrightHelpers.clickOn(createActionBtn);
        if (updateActionBtn.isVisible()) playwrightHelpers.clickOn(updateActionBtn);
        playwrightHelpers.clickOn(cancelPopUpBtn);
    }

    /**
     * delete add ons that has name
     *
     * @param addOnsName
     */
    public void deleteAddOns(String addOnsName) {
        Locator addOns = page.getByRole(AriaRole.ROW, new Page.GetByRoleOptions().setName(addOnsName)).getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Delete")).first();
        playwrightHelpers.clickOn(addOns);
        playwrightHelpers.clickOn(acceptDeleteBtnOnPopUp);
    }

    /**
     * edit add ons that has name
     *
     * @param addOnsName
     */
    public void editAddOns(String addOnsName) {
        Locator addOns = page.getByRole(AriaRole.ROW, new Page.GetByRoleOptions().setName(addOnsName)).getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Edit")).first();
        playwrightHelpers.clickOn(addOns);
    }

    /**
     * update add ons after edit field
     */
    public void updateAddOnsAfterInputField() {
        playwrightHelpers.clickOn(updateActionBtn);
        if (yesBtnDialog.isVisible()) playwrightHelpers.clickOn(yesBtnDialog);
    }

    /**
     * admin click on cancel btn from create or edit page
     */
    public void cancelCreateOrEditAddOns() {
        playwrightHelpers.clickOn(cancelActionBtn);
    }
}
