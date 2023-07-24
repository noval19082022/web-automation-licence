package steps.pms.homepage;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import pageobject.pms.homepage.KontrakKerjaSamaPO;

public class KontrakKerjaSamaSteps {
    Page page = ActiveContext.getActivePage();

    KontrakKerjaSamaPO contract = new KontrakKerjaSamaPO(page);


}
