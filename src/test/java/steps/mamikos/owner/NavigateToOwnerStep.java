package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import pageobject.owner.OwnerNavigateToPO;

public class NavigateToOwnerStep {
    Page page = ActiveContext.getActivePage();
    OwnerNavigateToPO ownerNavigate = new OwnerNavigateToPO(page);
    @And("user navigate to mamiads history page")
    public void userNavigateToMamiadsHistoryPage() {
        ownerNavigate.navigateToMamiadsHistory();
    }

    @And("user navigate to mamiads page")
    public void userNavigateToMamiadsPage() {
        ownerNavigate.navigateToMamiads();
    }
}
