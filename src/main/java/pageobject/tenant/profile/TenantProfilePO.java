package pageobject.tenant.profile;

import com.microsoft.playwright.Page;
import pageobject.common.ProfilePO;

public class TenantProfilePO extends ProfilePO {
    Page page;
    public TenantProfilePO(Page page) {
        this.page = page;
    }
}
