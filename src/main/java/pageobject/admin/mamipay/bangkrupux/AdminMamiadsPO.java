package pageobject.admin.mamipay.bangkrupux;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class AdminMamiadsPO {

    private PlaywrightHelpers playwrightHelpers;
    private Locator inputViewSaldoMamiadsPlaceHolder;
    private Locator inputUsedSaldoMamiadsPlaceHolder;
    private Locator inputAllocatedSaldoMamiadsPlaceHolder;
    private Locator updateBtn;

    public AdminMamiadsPO(Page page) {
        this.playwrightHelpers = new PlaywrightHelpers(page);
        this.inputViewSaldoMamiadsPlaceHolder = page.locator("input[name=\"view\"]");
        this.inputUsedSaldoMamiadsPlaceHolder = page.locator("input[name=\"used\"]");
        this.inputAllocatedSaldoMamiadsPlaceHolder = page.locator("input[name=\"allocated\"]");
        this.updateBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Update"));
    }

    /**
     * setup on page https://jambu.kerupux.com/admin/request/kost/99454727
     *
     * @param viewPoint
     */
    public void inputViewPointValueOnKostListMamiadsSeting(String viewPoint) {
        playwrightHelpers.clearText(inputViewSaldoMamiadsPlaceHolder);
        viewPoint = viewPoint.isEmpty() ? "0" : viewPoint;
        playwrightHelpers.clickLocatorAndTypeKeyboard(inputViewSaldoMamiadsPlaceHolder, viewPoint);
    }

    /**
     * setup on page https://jambu.kerupux.com/admin/request/kost/99454727
     *
     * @param usedPoint
     */
    public void inputUsedPointValueOnKostListMamiadsSeting(String usedPoint) {
        playwrightHelpers.clearText(inputUsedSaldoMamiadsPlaceHolder);
        usedPoint = usedPoint.isEmpty() ? "0" : usedPoint;
        playwrightHelpers.clickLocatorAndTypeKeyboard(inputUsedSaldoMamiadsPlaceHolder, usedPoint);
    }

    /**
     * setup on page https://jambu.kerupux.com/admin/request/kost/99454727
     *
     * @param allocatedPoint
     */
    public void inputAllocatedPointValueOnKostListMamiadsSeting(String allocatedPoint) {
        playwrightHelpers.clearText(inputAllocatedSaldoMamiadsPlaceHolder);
        allocatedPoint = allocatedPoint.isEmpty() ? "0" : allocatedPoint;
        playwrightHelpers.clickLocatorAndTypeKeyboard(inputAllocatedSaldoMamiadsPlaceHolder, allocatedPoint);
    }

    /**
     * tap update btn
     * setup on page https://jambu.kerupux.com/admin/request/kost/99454727
     */
    public void tapOnUpdateBtnOnMamiadsSetting() {
        playwrightHelpers.clickOn(updateBtn);
    }
}
