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
import pageobject.license.LicenseOrganizationLevelPO;
import pageobject.license.LicenseOrganizationPO;
import pageobject.license.LicenseSubscriberUserPO;
import pageobject.license.LoginLicensePO;

import java.util.List;
import java.util.Map;

public class LicenseLoginSteps {

    Page page = ActiveContext.getActivePage();
    LoginLicensePO loginLicense = new LoginLicensePO(page);
    LicenseDashboardPO licenseDashboard = new LicenseDashboardPO(page);
    LicenseOrganizationPO licenseOrganization = new LicenseOrganizationPO(page);
    LicenseOrganizationLevelPO licenseOrganizationLevel = new LicenseOrganizationLevelPO(page);
    LicenseSubscriberUserPO licenseSubscriberUser = new LicenseSubscriberUserPO(page);

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
        Map<String, String> row = data.get(0);

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
        } else if (page.url().contains("/license/subscriber-users")) {
            licenseSubscriberUser.clickSaveButton();
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
}
