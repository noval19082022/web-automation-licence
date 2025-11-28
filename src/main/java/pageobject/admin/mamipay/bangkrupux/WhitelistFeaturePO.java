package pageobject.admin.mamipay.bangkrupux;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class WhitelistFeaturePO {
    private Page page;
    private PlaywrightHelpers playwright;
    Locator buttonAdd;
    Locator selectFeature;
    Locator inputOwnerId;
    Locator ownerIdInput;
    Locator searchBtn;
    Locator deleteBtn;
    Locator editBtn;
    Locator saveBtn;
    Locator logoutBtn;
    Locator alternativeSubmitBtn;
    Locator inputSubmitBtn;
    Locator anySubmitBtn;
    Locator profileDropdownBtn;
    Locator alternativeLogoutBtn;
    Locator navLogoutBtn;
    Locator anyLogoutBtn;

    public WhitelistFeaturePO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        buttonAdd = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Add"));
        selectFeature = page.locator("//select[@name='name']");
        inputOwnerId = page.getByPlaceholder("user_id");
        ownerIdInput = page.getByPlaceholder("Owner Id");
        searchBtn = page.locator("#buttonSearch");
        deleteBtn = page.getByTitle("delete");
        editBtn = page.locator("//a[normalize-space()='Edit']");
        saveBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit"));
        logoutBtn = page.locator("//a[contains(text(), 'Logout')]");
        alternativeSubmitBtn = page.locator("//button[contains(text(), 'Submit')]");
        inputSubmitBtn = page.locator("input[type='submit'][value='Submit']");
        anySubmitBtn = page.locator("input[type='submit'], button[type='submit']");
        profileDropdownBtn = page.locator(".dropdown-toggle");
        alternativeLogoutBtn = page.locator("//a[text()='Logout']");
        navLogoutBtn = page.locator("nav a[href*='logout'], header a[href*='logout']");
        anyLogoutBtn = page.locator("a[href*='logout']");
    }

    /**
     * Choose feature whitelist
     */
    public void chooseFeatureWhitelist(String feature) {
        playwright.selectDropdownByValue(selectFeature, feature);
    }

    /**
     * Get currently selected feature value
     * @return String current selected feature value
     */
    public String getCurrentSelectedFeature() {
        playwright.waitFor(selectFeature, 3000.0);
        // Get selected option value using locator
        Locator selectedOption = selectFeature.locator("option:checked");
        if (playwright.waitTillLocatorIsVisible(selectedOption, 2000.0)) {
            return selectedOption.getAttribute("value");
        } else {
            // Alternative approach - get selected option via evaluate
            String selectedValue = (String) selectFeature.evaluate("element => element.value");
            return selectedValue != null ? selectedValue : "";
        }
    }

    /**
     * Choose feature whitelist only if not already selected
     * @param feature the feature to select
     */
    public void chooseFeatureWhitelistIfNotSelected(String feature) {
        String currentValue = getCurrentSelectedFeature();
        if (!feature.equals(currentValue)) {
            System.out.println("Current feature: " + currentValue + ", selecting: " + feature);
            playwright.selectDropdownByValue(selectFeature, feature);
        } else {
            System.out.println("Feature " + feature + " is already selected, skipping selection");
        }
    }

    /**
     * input user id (owner id)
     */
    public void inputOwnerId(String ownerId) {
        playwright.fill(inputOwnerId, ownerId);
    }

    /**
     * click on button add whitelist feature
     */
    public void addButtonWhitelist() {
        playwright.clickOn(buttonAdd);
    }

    /**
     * Get Text of alert from whitelist feature
     *
     * @return Text of Messsage Allert
     */
    public String getTitleMessageAllertWhitelist(String message) {
        Locator messageAllert = page.getByText(message);
        return playwright.getText(messageAllert);
    }

    /**
     * search owner by user_d
     *
     * @param userId
     */
    public void searchByUserId(String userId) {
        playwright.fill(ownerIdInput, userId);
        playwright.clickOn(searchBtn);
    }

    /**
     * clickOn delete Btn
     *
     * @param index
     */
    public void clickOnDeleteBtn(String index) {
        var order = Integer.parseInt(index);
        // Ensure the position is at least 1
        var position = Math.max(order, 1);

        // Adjust for 0-based indexing in Playwright
        var deleteButton = deleteBtn.nth(position - 1);

        // Click and accept the dialog
        if (playwright.waitTillLocatorIsVisible(deleteButton)) {
            playwright.acceptDialog(deleteButton);
        } else {
            playwright.reloadPage();
        }
    }

    /**
     * Click on edit button for first owner in search results
     */
    public void clickOnEditButton() {
        // Wait for search results to load
        playwright.hardWait(2000.0);
        
        // Try multiple locator strategies for edit button
        if (playwright.waitTillLocatorIsVisible(editBtn.first(), 3000.0)) {
            playwright.clickOn(editBtn.first());
        }
    }

    /**
     * Click on submit button to save whitelist changes
     */
    public void clickOnSaveButton() {
        // Try multiple locator strategies for submit button
        if (playwright.waitTillLocatorIsVisible(saveBtn, 3000.0)) {
            playwright.clickOn(saveBtn);
        } else {
            // Alternative locators for submit button
            if (playwright.waitTillLocatorIsVisible(alternativeSubmitBtn, 3000.0)) {
                playwright.clickOn(alternativeSubmitBtn);
            } else {
                // Try input submit button with Submit value
                if (playwright.waitTillLocatorIsVisible(inputSubmitBtn, 3000.0)) {
                    playwright.clickOn(inputSubmitBtn);
                } else {
                    // Last resort - any submit button
                    playwright.waitFor(anySubmitBtn.first(), 5000.0);
                    playwright.clickOn(anySubmitBtn.first());
                }
            }
        }
    }

    /**
     * Click on logout button to logout from Bangkrupux admin
     */
    public void clickOnLogoutButton() {
        // Strategy 1: Dropdown-toggle approach (most reliable for Bangkrupux admin)
        if (playwright.waitTillLocatorIsVisible(profileDropdownBtn, 3000.0)) {
            playwright.clickOn(profileDropdownBtn);
            playwright.hardWait(1000.0); // Wait for dropdown to appear
            playwright.clickOnText("Sign Out ");
        } else {
            // Strategy 2: Direct logout link with text contains
            if (playwright.waitTillLocatorIsVisible(logoutBtn, 3000.0)) {
                playwright.clickOn(logoutBtn);
            } else {
                // Strategy 3: Alternative logout link with exact text
                if (playwright.waitTillLocatorIsVisible(alternativeLogoutBtn, 3000.0)) {
                    playwright.clickOn(alternativeLogoutBtn);
                } else {
                    // Strategy 4: Navigation or header area logout
                    if (playwright.waitTillLocatorIsVisible(navLogoutBtn.first(), 3000.0)) {
                        playwright.clickOn(navLogoutBtn.first());
                    } else {
                        // Strategy 5: Last resort - any link containing logout
                        playwright.waitFor(anyLogoutBtn.first(), 5000.0);
                        playwright.clickOn(anyLogoutBtn.first());
                    }
                }
            }
        }
        // Wait for logout to complete (login page appears)
        playwright.waitTillPageLoaded();
    }
}