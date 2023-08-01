package steps.pms;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pageobject.pms.HomepagePO;

public class HomepageSteps {
    Page page = ActiveContext.getActivePage();
    HomepagePO homepage = new HomepagePO(page);

    @And("Admin go to room allotment page")
    public void admin_go_to_room_allotment_page() {
        homepage.clickActionButton();
        homepage.clickRoomAllotment();
    }

    @When("admin go to detail property {string}")
    public void admin_go_to_detail_property(String name) {
        homepage.searchProperty(name);
        homepage.clickActionButton();
        homepage.clickSeeDetail();
    }
}
