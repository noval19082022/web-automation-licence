package steps.license;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.license.LicenseDashboardPO;
import pageobject.license.LicenseMappingAkunPO;
import pageobject.license.LicenseMarketingPO;
import pageobject.license.LicenseOrganizationLevelPO;
import pageobject.license.LicenseOrganizationPO;
import pageobject.license.LicensePlanPO;
import pageobject.license.LicensePriceListPO;
import pageobject.license.LicenseSubscriptionPO;
import pageobject.license.LicenseSubscriptionModulePO;
import pageobject.license.LicenseSubscriberUserOrgPO;
import pageobject.license.LicenseSubscriberUserPO;
import pageobject.license.LoginLicensePO;
import utilities.JavaHelpers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LicenseLoginSteps {

    Page page = ActiveContext.getActivePage();
    LoginLicensePO loginLicense = new LoginLicensePO(page);
    LicenseDashboardPO licenseDashboard = new LicenseDashboardPO(page);
    LicenseOrganizationPO licenseOrganization = new LicenseOrganizationPO(page);
    LicenseOrganizationLevelPO licenseOrganizationLevel = new LicenseOrganizationLevelPO(page);
    LicenseSubscriberUserPO licenseSubscriberUser = new LicenseSubscriberUserPO(page);
    LicenseSubscriberUserOrgPO licenseSubscriberUserOrg = new LicenseSubscriberUserOrgPO(page);
    LicenseMarketingPO licenseMarketing = new LicenseMarketingPO(page);
    LicenseMappingAkunPO licenseMappingAkun = new LicenseMappingAkunPO(page);
    LicensePlanPO licensePlan = new LicensePlanPO(page);
    LicensePriceListPO licensePriceList = new LicensePriceListPO(page);
    LicenseSubscriptionPO licenseSubscription = new LicenseSubscriptionPO(page);
    LicenseSubscriptionModulePO licenseSubscriptionModule = new LicenseSubscriptionModulePO(page);

    private List<Map<String, String>> credentials;

    @Given("the user access URL is {string}")
    public void theUserAccessURLIs(String url) {
        loginLicense.navigateToLicenseLoginPage(url);
    }

    @When("the user logs in as admin:")
    public void theUserLogsInAsAdmin(DataTable table) {
        credentials = table.asMaps(String.class, String.class);
        String username = credentials.get(0).get("Username");
        String password = credentials.get(0).get("Password");
        loginLicense.fillUsername(username);
        loginLicense.fillPassword(password);
    }

    @And("the user clicks on login button")
    public void theUserClicksOnLoginButton() {
        loginLicense.clickSignIn();
    }

    @And("the user clicks on the Dashboard menu")
    public void theUserClicksOnTheDashboardMenu() {
        licenseDashboard.clickDashboardMenu();
    }

    @Then("the user successfully logs into the dashboard menu")
    public void theUserSuccessfullyLogsIntoTheDashboardMenu() {
        Assert.assertTrue(licenseDashboard.isDashboardDisplayed(), "Dashboard page is not displayed");
    }

    @And("the user clicks on the customer menu")
    public void theUserClicksOnTheCustomerMenu() {
        licenseDashboard.clickCustomersMenu();
    }

    @And("the user select menu organisation")
    public void theUserSelectMenuOrganisation() {
        licenseDashboard.clickOrganizationsMenu();
    }

    @And("the user clicks on add row menu")
    public void theUserClicksOnAddRowMenu() {
        licenseOrganization.clickAddRowTab();
    }

    @And("the user fill data:")
    public void theUserFillData(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> row = resolveTokens(data.get(0));

        if (page.url().contains("/license/organization-level")) {
            String levelName = row.get("Name");
            String level = row.get("Level");
            String description = row.get("Description");

            if (levelName != null && !levelName.equals("-")) licenseOrganizationLevel.fillName(levelName);
            if (level != null && !level.equals("-")) licenseOrganizationLevel.fillLevel(level);
            if (description != null && !description.equals("-")) licenseOrganizationLevel.fillDescription(description);
            return;
        }

        if (page.url().contains("/license/subscriber-users")) {
            String username = row.get("Username");
            String email = row.get("Email");
            String phoneNumber = row.get("Phone Number");
            String fullName = row.get("Full Name");

            if (username != null && !username.equals("-")) licenseSubscriberUser.fillUsername(username);
            if (email != null && !email.equals("-")) licenseSubscriberUser.fillEmail(email);
            if (phoneNumber != null && !phoneNumber.equals("-")) licenseSubscriberUser.fillPhone(phoneNumber);
            if (fullName != null && !fullName.equals("-")) licenseSubscriberUser.fillFullName(fullName);
            return;
        }

        if (page.url().contains("/license/plans")) {
            String code = row.get("Code");
            String name = row.get("Name");
            String description = row.get("Description");

            if (code != null && !code.equals("-")) licensePlan.fillCode(code);
            if (name != null && !name.equals("-")) licensePlan.fillName(name);
            if (description != null && !description.equals("-")) licensePlan.fillDescription(description);
            return;
        }

        if (page.url().contains("/license/subscription-modules")) {
            String subscription = row.get("Subscription");
            String module = row.get("Module");
            String priceItem = row.get("Price Item");
            String source = row.get("Source");
            // Note: "Price List" column from the scenario is informational only —
            // the form derives price list from the chosen Subscription (cascade).

            if (subscription != null && !subscription.isEmpty() && !subscription.equals("-")) licenseSubscriptionModule.selectSubscription(subscription);
            if (module != null && !module.isEmpty() && !module.equals("-")) licenseSubscriptionModule.selectModule(module);
            if (priceItem != null && !priceItem.isEmpty() && !priceItem.equals("-")) licenseSubscriptionModule.selectPriceItem(priceItem);
            if (source != null && !source.isEmpty() && !source.equals("-")) licenseSubscriptionModule.selectSource(source);
            return;
        }

        if (page.url().contains("/license/subscriptions")) {
            String organization = row.get("Organization");
            String plan = row.get("Plan");
            String priceList = row.get("Price List");
            String billingCycle = row.get("Billing Cycle");
            String status = row.get("Status");
            String startDate = row.get("Start Date");
            String endDate = row.get("End Date");

            if (organization != null && !organization.equals("-")) licenseSubscription.selectOrganization(organization);
            if (plan != null && !plan.equals("-")) licenseSubscription.selectPlan(plan);
            if (priceList != null && !priceList.equals("-")) licenseSubscription.selectPriceList(priceList);
            if (billingCycle != null && !billingCycle.equals("-")) licenseSubscription.selectBillingCycle(billingCycle);
            if (status != null && !status.equals("-")) licenseSubscription.selectStatus(status);
            if (startDate != null && !startDate.equals("-")) licenseSubscription.fillStartDate(startDate);
            if (endDate != null && !endDate.equals("-")) licenseSubscription.fillEndDate(endDate);
            return;
        }

        if (page.url().contains("/license/price-lists")) {
            // Branch: same page hosts two forms (header price-list + per-item).
            // Detect by data columns — "Charge Type" only exists on the item form.
            if (row.containsKey("Charge Type")) {
                String chargeType = row.get("Charge Type");
                String reference = row.get("Reference");
                String billingCycle = row.get("Billing Cycle");
                String amount = row.get("Amount");
                String initialAmount = row.get("Initial Amount");

                if (chargeType != null && !chargeType.isEmpty() && !chargeType.equals("-")) licensePriceList.selectItemChargeType(chargeType);
                if (reference != null && !reference.isEmpty() && !reference.equals("-")) licensePriceList.selectItemReference(reference);
                if (billingCycle != null && !billingCycle.isEmpty() && !billingCycle.equals("-")) licensePriceList.selectItemBillingCycle(billingCycle);
                if (amount != null && !amount.isEmpty() && !amount.equals("-")) licensePriceList.fillItemAmount(amount);
                if (initialAmount != null && !initialAmount.isEmpty() && !initialAmount.equals("-")) licensePriceList.fillItemInitialAmount(initialAmount);
                return;
            }

            String code = row.get("Code");
            String name = row.get("Name");
            String currency = row.get("Currency");
            String description = row.get("Description");

            if (code != null && !code.equals("-")) licensePriceList.fillCode(code);
            if (name != null && !name.equals("-")) licensePriceList.fillName(name);
            if (currency != null && !currency.equals("-")) licensePriceList.selectCurrency(currency);
            if (description != null && !description.equals("-")) licensePriceList.fillDescription(description);
            return;
        }

        if (page.url().contains("/license/marketing-account-mappings")) {
            String marketing = row.get("Marketing");
            String rootOrg = row.get("Root Organization Level 1");
            String effectiveFrom = row.get("Effective From");
            String effectiveTo = row.get("Effective To");
            String status = row.get("Status");
            String notes = row.get("Notes");

            if (marketing != null && !marketing.equals("-")) licenseMappingAkun.selectMarketing(marketing);
            if (rootOrg != null && !rootOrg.equals("-")) licenseMappingAkun.selectRootOrganization(rootOrg);
            if (effectiveFrom != null && !effectiveFrom.equals("-")) licenseMappingAkun.fillEffectiveFrom(effectiveFrom);
            if (effectiveTo != null && !effectiveTo.equals("-")) licenseMappingAkun.fillEffectiveTo(effectiveTo);
            if (status != null && !status.equals("-")) licenseMappingAkun.selectStatus(status);
            if (notes != null && !notes.equals("-")) licenseMappingAkun.fillNotes(notes);
            return;
        }

        if (page.url().contains("/license/marketing")) {
            String code = row.get("Code");
            String name = row.get("Name");
            String email = row.get("Email");
            String fullName = row.get("Full Name");
            String phone = row.get("Phone");
            String status = row.get("Status");
            String notes = row.get("Notes");

            if (code != null && !code.equals("-")) licenseMarketing.fillCode(code);
            if (name != null && !name.equals("-")) licenseMarketing.fillName(name);
            if (email != null && !email.equals("-")) licenseMarketing.fillEmail(email);
            if (fullName != null && !fullName.equals("-")) licenseMarketing.fillFullName(fullName);
            if (phone != null && !phone.equals("-")) licenseMarketing.fillPhone(phone);
            if (status != null && !status.equals("-")) licenseMarketing.selectStatus(status);
            if (notes != null && !notes.equals("-")) licenseMarketing.fillNotes(notes);
            return;
        }

        if (page.url().contains("/license/subscriber-user-org")) {
            String member = row.get("Member");
            String organization = row.get("Organization");
            String role = row.get("Role");
            String joinedAt = row.get("Joined At");

            if (member != null && !member.equals("-")) licenseSubscriberUserOrg.selectMember(member);
            if (organization != null && !organization.equals("-")) licenseSubscriberUserOrg.selectOrganization(organization);
            if (role != null && !role.equals("-")) licenseSubscriberUserOrg.selectRole(role);
            if (joinedAt != null && !joinedAt.equals("-")) licenseSubscriberUserOrg.fillJoinedAt(joinedAt);
            return;
        }

        String code = row.get("Code");
        String name = row.get("Name");
        String organizationLevel = row.get("Organization Level");
        String parentOrganization = row.get("Parent Organization");
        String businessName = row.get("Business Name");
        String country = row.get("Country");
        String phoneNumber = row.get("Phone Number");
        String email = row.get("Email");
        String postalCode = row.get("Postal Code");
        String npwp = row.get("NPWP");
        String address = row.get("Address");
        String taxInvoiceName = row.get("Tax Invoice Name");

        if (code != null && !code.equals("-")) licenseOrganization.fillCode(code);
        if (name != null && !name.equals("-")) licenseOrganization.fillName(name);
        if (organizationLevel != null && !organizationLevel.equals("-")) licenseOrganization.selectOrganizationLevel(organizationLevel);
        if (parentOrganization != null && !parentOrganization.equals("-")) licenseOrganization.selectParentOrganization(parentOrganization);
        if (businessName != null && !businessName.equals("-")) licenseOrganization.fillBusinessName(businessName);
        if (country != null && !country.equals("-")) licenseOrganization.selectCountry(country);
        if (phoneNumber != null && !phoneNumber.equals("-")) licenseOrganization.fillPhone(phoneNumber);
        if (email != null && !email.equals("-")) licenseOrganization.fillEmail(email);
        if (postalCode != null && !postalCode.equals("-")) licenseOrganization.fillPostalCode(postalCode);
        if (npwp != null && !npwp.equals("-")) licenseOrganization.fillNpwp(npwp);
        if (address != null && !address.equals("-")) licenseOrganization.fillAddress(address);
        if (taxInvoiceName != null && !taxInvoiceName.equals("-")) licenseOrganization.fillTaxInvoiceName(taxInvoiceName);
    }

    @And("the user click on save button")
    public void theUserClickOnSaveButton() {
        if (page.url().contains("/license/organization-level")) {
            licenseOrganizationLevel.clickSaveButton();
        } else if (page.url().contains("/license/subscriber-user-org")) {
            licenseSubscriberUserOrg.clickSaveButton();
        } else if (page.url().contains("/license/subscriber-users")) {
            licenseSubscriberUser.clickSaveButton();
        } else if (page.url().contains("/license/plans")) {
            licensePlan.clickSaveButton();
        } else if (page.url().contains("/license/subscription-modules")) {
            licenseSubscriptionModule.clickSaveButton();
        } else if (page.url().contains("/license/subscriptions")) {
            licenseSubscription.clickSaveButton();
        } else if (page.url().contains("/license/price-lists")) {
            if (licensePriceList.isItemFormActive()) {
                licensePriceList.clickSaveItemButton();
            } else {
                licensePriceList.clickSaveButton();
            }
        } else if (page.url().contains("/license/marketing-account-mappings")) {
            licenseMappingAkun.clickSaveButton();
        } else if (page.url().contains("/license/marketing")) {
            licenseMarketing.clickSaveButton();
        } else {
            licenseOrganization.clickSaveButton();
        }
    }

    @And("the user clicks on more button")
    public void theUserClicksOnMoreButton() {
        licenseOrganization.clickMoreButton();
    }

    @And("the user select {string} button")
    public void theUserSelectButton(String action) {
        if (page.url().contains("/license/subscriber-users") && "Delete".equalsIgnoreCase(action)) {
            licenseSubscriberUser.clickToolbarDeleteButton();
        } else {
            licenseOrganization.clickActionMenu(action);
        }
    }

    @And("the user clicks on {string} button on pop up confirmation")
    public void theUserClicksOnButtonOnPopUpConfirmation(String label) {
        licenseOrganization.clickConfirmationButton(label);
    }

    @And("the user select menu organisation levels")
    public void theUserSelectMenuOrganisationLevels() {
        licenseDashboard.clickOrganizationLevelsMenu();
    }

    @And("the user clicks on edit row menu")
    public void theUserClicksOnEditRowMenu() {
        licenseOrganizationLevel.clickEditRowMenu();
    }

    @And("the user select menu subscriber users")
    public void theUserSelectMenuSubscriberUsers() {
        licenseDashboard.clickSubscriberUsersMenu();
    }

    @And("the user clicks on view button")
    public void theUserClicksOnViewButton() {
        licenseSubscriberUser.clickViewButton();
    }

    @And("the user select menu subscriber users org")
    public void theUserSelectMenuSubscriberUsersOrg() {
        licenseDashboard.clickSubscriberUserOrgMenu();
    }

    @And("the user clicks on add member")
    public void theUserClicksOnAddMember() {
        licenseSubscriberUserOrg.clickAddMemberTab();
    }

    @And("the user select menu marketing")
    public void theUserSelectMenuMarketing() {
        licenseDashboard.clickMarketingMenu();
    }

    @And("the user select menu Mapping Akun")
    public void theUserSelectMenuMappingAkun() {
        licenseDashboard.clickMappingAkunMenu();
    }

    @And("the user clicks on the billing menu")
    public void theUserClicksOnTheBillingMenu() {
        licenseDashboard.clickBillingMenu();
    }

    @And("the user select menu plan")
    public void theUserSelectMenuPlan() {
        licenseDashboard.clickPlansMenu();
    }

    @And("the user select menu price list")
    public void theUserSelectMenuPriceList() {
        licenseDashboard.clickPriceListMenu();
    }

    @And("the user select menu Subscriptions")
    public void theUserSelectMenuSubscriptions() {
        licenseDashboard.clickSubscriptionsMenu();
    }

    @And("the user clicks on add Subscriptions menu")
    public void theUserClicksOnAddSubscriptionsMenu() {
        licenseSubscription.clickAddSubscriptionTab();
    }

    @And("the user select menu Subscription Modules")
    public void theUserSelectMenuSubscriptionModules() {
        licenseDashboard.clickSubscriptionModulesMenu();
    }

    @And("the user select price list code {string}")
    public void theUserSelectPriceListCode(String code) {
        licensePriceList.selectByCode(code);
    }

    @And("the user clicks on add items")
    public void theUserClicksOnAddItems() {
        licensePriceList.clickItemsTab();
    }

    @And("the user clicks on add item")
    public void theUserClicksOnAddItem() {
        licensePriceList.clickAddItemButton();
    }

    @And("the user clicks on add plan menu")
    public void theUserClicksOnAddPlanMenu() {
        licensePlan.clickAddPlanTab();
    }

    /**
     * Resolve dynamic tokens inside a data row so the same scenario can be re-run
     * without colliding on unique-constrained columns. One timestamp value is used
     * for the whole row so related fields (e.g. Code & Name) share the same suffix.
     *
     * Supported tokens:
     *   {{timestamp}} — current time as yyyyMMddHHmmss
     */
    private Map<String, String> resolveTokens(Map<String, String> row) {
        String ts = new JavaHelpers().getTimeStamp("yyyyMMddHHmmss");
        Map<String, String> resolved = new HashMap<>();
        for (Map.Entry<String, String> e : row.entrySet()) {
            String v = e.getValue();
            if (v != null) v = v.replace("{{timestamp}}", ts);
            resolved.put(e.getKey(), v);
        }
        return resolved;
    }
}
