package steps.mamikos.bangkrupux;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import pageobject.admin.mamipay.bangkrupux.AdminMamiadsPO;

public class AdminMamiadsSteps {
    Page page = ActiveContext.getActivePage();
    AdminMamiadsPO adminMamiadsPO = new AdminMamiadsPO(page);

    @And("admin bangkrupux adjust mamiads with intial value {string} usage {string} and alocated {string}")
    public void adminBangkrupuxAdjustMamiadsWithIntialValueUsageAndAlocated(String viewPoint, String usedPoint, String allocatedPoint) {
        adminMamiadsPO.inputPointValueOnKostListMamiadsSeting(viewPoint, usedPoint, allocatedPoint);
        adminMamiadsPO.tapOnUpdateBtnOnMamiadsSetting();
    }
}
