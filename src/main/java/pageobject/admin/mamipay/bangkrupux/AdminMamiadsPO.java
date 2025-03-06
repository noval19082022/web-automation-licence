package pageobject.admin.mamipay.bangkrupux;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class AdminMamiadsPO {

    Page page;
    private PlaywrightHelpers playwrightHelpers;
    private Locator inputViewSaldoMamiadsPlaceHolder;
    private Locator inputUsedSaldoMamiadsPlaceHolder;
    private Locator inputAllocatedSaldoMamiadsPlaceHolder;
    private Locator updateBtn;

    public AdminMamiadsPO(Page page) {
        this.page = page;
        this.playwrightHelpers = new PlaywrightHelpers(page);
        this.inputViewSaldoMamiadsPlaceHolder = page.locator("input[name=\"view\"]");
        this.inputUsedSaldoMamiadsPlaceHolder = page.locator("input[name=\"used\"]");
        this.inputAllocatedSaldoMamiadsPlaceHolder = page.locator("input[name=\"allocated\"]");
        this.updateBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Update Saldo Mamiads"));
    }

    /**
     * setup on page https://jambu.kerupux.com/admin/request/kost/99454727
     *
     * @param viewPoint
     * @param usedPoint
     * @param allocatedPoint
     */
    public void inputPointValueOnKostListMamiadsSeting(String viewPoint, String usedPoint, String allocatedPoint) {
        playwrightHelpers.clearText(inputViewSaldoMamiadsPlaceHolder);
        viewPoint = viewPoint.isEmpty() ? "0" : viewPoint;
        playwrightHelpers.clickLocatorAndTypeKeyboard(inputViewSaldoMamiadsPlaceHolder, viewPoint);

        playwrightHelpers.clearText(inputUsedSaldoMamiadsPlaceHolder);
        usedPoint = usedPoint.isEmpty() ? "0" : usedPoint;
        playwrightHelpers.clickLocatorAndTypeKeyboard(inputUsedSaldoMamiadsPlaceHolder, usedPoint);

        playwrightHelpers.clearText(inputAllocatedSaldoMamiadsPlaceHolder);
        allocatedPoint = allocatedPoint.isEmpty() ? "0" : allocatedPoint;
        playwrightHelpers.clickLocatorAndTypeKeyboard(inputAllocatedSaldoMamiadsPlaceHolder, allocatedPoint);

    }

    /**
     * tap update btn
     * setup on page https://jambu.kerupux.com/admin/request/kost/99454727
     */
    public void tapOnUpdateBtnOnMamiadsSetting() {
        page.onceDialog(dialog -> {
            System.out.printf("Dialog message: %s%n", dialog.message());
            dialog.accept();
        });
        playwrightHelpers.clickOn(updateBtn);
    }
}
