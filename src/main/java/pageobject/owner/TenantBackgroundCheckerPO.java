package pageobject.owner;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class TenantBackgroundCheckerPO {

    private Page page;
    private PlaywrightHelpers playwright;
    Locator lihatProfilTextButton;
    Locator coachmark;
    Locator titleCoahmark;
    Locator descCochmark;

    public TenantBackgroundCheckerPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        lihatProfilTextButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lihat Profil"));
        coachmark = page.locator("//div[@class='shepherd-content']");
        titleCoahmark = page.locator("//h3[@class='shepherd-title']");
        descCochmark = page.locator("//div[@class='shepherd-text']");

    }
    public boolean isLihatProfilDisplayed() {
       return playwright.waitTillLocatorIsVisible(lihatProfilTextButton);
    }

    public boolean isCoachmarkDisplayed() {
        return playwright.waitTillLocatorIsVisible(coachmark);
    }

    public String getTitleCoachmark(){
        return playwright.getText(titleCoahmark);
    }

    public String getDesCoachmark(){
        return playwright.getText(descCochmark);
    }
}
