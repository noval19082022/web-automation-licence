package steps.mamikos.admin;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import pageobject.admin.mamipay.bangkrupux.AdminFeeDiscountPO;

public class AdminFeeDiscountSteps {
    Page page = ActiveContext.getActivePage();
    AdminFeeDiscountPO adminFeeDiscountPO = new AdminFeeDiscountPO(page);

    @And("admin bangkrupux navigate to discount admin fee discount menu")
    public void adminFeeDiscountMenu() {
        adminFeeDiscountPO.clickOnAdminFeeMenu();
    }

    @And("admin bangkrupux want to edit discount admin fee")
    public void adminBangkrupuxWantToEditDiscountAdminFee() {
        adminFeeDiscountPO.clickOnEditFirstAdminFeeList();
    }

    @And("admin bangkrupux input amount {string} for discount admin fee")
    public void adminBangkrupuxInputAmountForDiscountAdminFee(String amount) {
        adminFeeDiscountPO.inputAmountOnEditPage(amount);
    }

    @And("admin bangkrupux save after input field on edit discount admin fee")
    public void adminBangkrupuxSaveAfterInputFieldOnEditDiscountAdminFee() {
        adminFeeDiscountPO.saveAction();
    }

    @And("admin bangkerupux want to delete admin fee discount")
    public void adminBangkerupuxWantToDeleteAdminFeeDiscount() {
        adminFeeDiscountPO.deleteLastAdminFeeOnlist();
    }

    @And("admin bangkerupux create admin fee discount with name discount {string} amount {string}")
    public void adminBangkerupuxCreateAdminFeeDiscountWithNameDiscountAmount(String name, String amount) {
        adminFeeDiscountPO.createNewAdminFeeDiscountBtn();
        adminFeeDiscountPO.fillOnAdminFeeName(name);
        adminFeeDiscountPO.selectKostLevelOnCreate();
        adminFeeDiscountPO.fillOnAdminFeeAmount(amount);
        adminFeeDiscountPO.saveAction();
    }

    @And("admin bangkerupux want to delete admin fee discount that has name {string}")
    public void adminBangkerupuxWantToDeleteAdminFeeDiscountThatHasName(String adminFeeName) {
        adminFeeDiscountPO.deleteAdminFeeName(adminFeeName);
    }
}
