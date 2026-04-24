package pageobject.license;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
import utilities.PlaywrightHelpers;

public class LicenseSubscriberUserOrgPO {

    private Page page;
    private PlaywrightHelpers playwright;

    Locator addMemberTab;
    Locator memberTrigger;
    Locator memberSearch;
    Locator memberList;
    Locator organizationTrigger;
    Locator organizationSearch;
    Locator organizationList;
    Locator roleSelect;
    Locator joinedAtField;
    Locator saveButton;

    public LicenseSubscriberUserOrgPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        addMemberTab = page.locator("#data-add-edit-tab");
        memberTrigger = page.locator("#membership-subscriber-user-dropdown");
        memberSearch = page.locator("#membership-subscriber-user-search");
        memberList = page.locator("#membership-subscriber-user-list");
        organizationTrigger = page.locator("#membership-organization-dropdown");
        organizationSearch = page.locator("#membership-organization-search");
        organizationList = page.locator("#membership-organization-list");
        roleSelect = page.locator("#membership-role");
        joinedAtField = page.locator("#membership-joined-at");
        saveButton = page.locator("#membership-save");
    }

    /**
     * Click on the Add/Edit tab (labeled "Add Member" when in add mode) to open the form.
     */
    public void clickAddMemberTab() {
        playwright.waitTillLocatorIsVisible(addMemberTab, 30000.0);
        playwright.clickOn(addMemberTab);
    }

    /**
     * Select a member via the searchable subscriber-user dropdown:
     * open trigger, type search term, click matching option.
     * @param member search term / visible option label (e.g. username)
     */
    public void selectMember(String member) {
        playwright.waitTillLocatorIsVisible(memberTrigger, 30000.0);
        playwright.clickOn(memberTrigger);
        playwright.waitTillLocatorIsVisible(memberSearch, 10000.0);
        playwright.fill(memberSearch, member);
        Locator option = memberList.locator(".dropdown-item")
                .filter(new Locator.FilterOptions().setHasText(member))
                .first();
        playwright.waitTillLocatorIsVisible(option, 15000.0);
        playwright.clickOn(option);
    }

    /**
     * Select an organization via the searchable organization dropdown.
     * @param organization search term / visible option label (e.g. org name)
     */
    public void selectOrganization(String organization) {
        playwright.waitTillLocatorIsVisible(organizationTrigger, 30000.0);
        playwright.clickOn(organizationTrigger);
        playwright.waitTillLocatorIsVisible(organizationSearch, 10000.0);
        playwright.fill(organizationSearch, organization);
        Locator option = organizationList.locator(".dropdown-item")
                .filter(new Locator.FilterOptions().setHasText(organization))
                .first();
        playwright.waitTillLocatorIsVisible(option, 15000.0);
        playwright.clickOn(option);
    }

    /**
     * Select a role by visible label (e.g. "Admin" → value "ADMIN").
     * @param role visible option label
     */
    public void selectRole(String role) {
        roleSelect.selectOption(new SelectOption().setLabel(role));
    }

    /**
     * Fill the Joined At datetime-local input. Accepts either "YYYY-MM-DD HH:MM" (space)
     * or "YYYY-MM-DDTHH:MM" — a space is auto-converted to the required "T" separator.
     * @param joinedAt datetime string
     */
    public void fillJoinedAt(String joinedAt) {
        String normalized = joinedAt == null ? "" : joinedAt.trim().replaceFirst("\\s+", "T");
        playwright.fill(joinedAtField, normalized);
    }

    /**
     * Click Save button and wait for the create/update API call to complete so the
     * success toast is guaranteed to be triggered before the next step asserts it.
     */
    public void clickSaveButton() {
        try {
            page.waitForResponse(
                    response -> response.url().contains("/license/subscriber-user-org")
                            && (response.request().method().equalsIgnoreCase("POST")
                                    || response.request().method().equalsIgnoreCase("PUT")),
                    new Page.WaitForResponseOptions().setTimeout(20000),
                    () -> playwright.clickOn(saveButton)
            );
        } catch (com.microsoft.playwright.TimeoutError ignored) {
            // No save request was fired (client-side validation blocked submit);
            // the subsequent toast assertion will surface the failure with a clearer signal.
        }
    }
}
