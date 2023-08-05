package steps.mamikos.bangkrupux;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import pageobject.admin.mamipay.bangkrupux.PropertyManagementPO;

public class PropertyManagementSteps {
    Page page = ActiveContext.getActivePage();
    PropertyManagementPO propertyManagementPO = new PropertyManagementPO(page);

    @And("admin bangkrupux navigate to property management menu")
    public void adminVisitRefundPageOnMamipay() {
        propertyManagementPO.openUpPropertyManagementMenu();
        propertyManagementPO.clickOnPropertyMenu();
    }

    @And("admin bangkerupux search property name {string} on property management menu")
    public void adminBangkerupuxSearchPropertyNameOnPropertyManagementMenu(String propertyName) {
        propertyManagementPO.searchPropertyName(propertyName);
    }
}
