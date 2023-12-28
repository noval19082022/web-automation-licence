package pageobject.admin.mamipay.bangkrupux;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class AdminBangkerupuxEventPO {
    PlaywrightHelpers playwrightHelpers;
    private Locator editBtnList;
    private Locator selecOptionOrderEvent;
    private Locator updateBtn;

    public AdminBangkerupuxEventPO(Page page) {
        playwrightHelpers = new PlaywrightHelpers(page);
        this.editBtnList = page.locator("//i[@class='fa fa-pencil']");
        this.selecOptionOrderEvent = page.locator("select[name='ordering']");
        this.updateBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Update"));
    }

    /**
     * pick the event based on index(1-...)
     *
     * @param index
     */
    public void clickOnEditEvent(String index) {
        playwrightHelpers.clickOn(editBtnList.nth(Integer.valueOf(index) - 1));
    }

    /**
     * set order event on edit page
     *
     * @param order
     */
    public void setOrderEvent(String order) {
        playwrightHelpers.selectDropdownByValue(selecOptionOrderEvent, order);
    }

    /**
     * click on update btn
     */
    public void clickOnUpdateBtn() {
        playwrightHelpers.clickOn(updateBtn);
    }
}
