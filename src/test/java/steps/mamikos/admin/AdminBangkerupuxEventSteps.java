package steps.mamikos.admin;

import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import pageobject.admin.mamipay.bangkrupux.AdminBangkerupuxEventPO;

public class AdminBangkerupuxEventSteps {
    AdminBangkerupuxEventPO adminBangkerupuxEventPO = new AdminBangkerupuxEventPO(ActiveContext.getActivePage());

    @And("admin bangkerupux set event banner {string} to order {string}")
    public void adminBangkerupuxSetEventBannerToOrder(String list, String order) {
        adminBangkerupuxEventPO.clickOnEditEvent(list);
        adminBangkerupuxEventPO.setOrderEvent(order);
    }

    @And("admin bangkerupux updated the event banner")
    public void adminBangkerupuxUpdatedTheEventBanner() {
        adminBangkerupuxEventPO.clickOnUpdateBtn();
    }
}
