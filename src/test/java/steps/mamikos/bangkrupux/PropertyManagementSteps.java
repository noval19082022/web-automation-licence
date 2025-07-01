package steps.mamikos.bangkrupux;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import pageobject.admin.mamipay.bangkrupux.PropertyManagementPO;
import pageobject.common.LoadingPO;
import pageobject.owner.PropertiSayaPO;

public class PropertyManagementSteps {
    Page page = ActiveContext.getActivePage();
    PropertyManagementPO propertyManagementPO = new PropertyManagementPO(page);
    PropertiSayaPO propertySaya = new PropertiSayaPO(ActiveContext.getActivePage());
    LoadingPO loading = new LoadingPO(ActiveContext.getActivePage());

    @And("admin bangkrupux navigate to property management menu")
    public void adminVisitRefundPageOnMamipay() {
        propertyManagementPO.openUpPropertyManagementMenu();
        propertyManagementPO.clickOnPropertyMenu();
    }

    @And("admin bangkerupux search property name {string} on property management menu")
    public void adminBangkerupuxSearchPropertyNameOnPropertyManagementMenu(String propertyName) {
        propertyManagementPO.searchPropertyName(propertyName);
    }

    @And("owner Deactive ads quick alocation if active {string}")
    public void ownerDeactiveAdsQuickAlocationIfActive(String propertyName) {
        loading.waitForLoadingIconDisappear();
        propertySaya.searchKostPropertySaya(propertyName);
        propertyManagementPO.deactivateQuickAllocationIfActive();
    }
}
