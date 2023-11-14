package pageobject.admin.mamipay.bangkrupux;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import utilities.PlaywrightHelpers;

import java.util.List;

public class tenantSurveyPO {
    Page page;
    PlaywrightHelpers playwright;
    Locator tenantSurveyMenu;
    Locator tenantNameField;
    Locator searchSurveyButton;
    Locator tenantPhoneField;
    Locator propertyNameField;
    Locator surveyDateField;
    Locator editSurveyButton;
    Locator tenantSurveyName;
    Locator nextPage;
    Locator surveyStatus;
    Locator saveSurveyButton;
    Locator alert;
    Locator nextDateButton;
    Locator surveyDateInput;
    Locator surveyTimeSelection;
    Locator tenantPropertyField;
    Locator tenantStatusField;
    Locator tenantSurveyField;
    Locator tenantName;
    Locator tenantStatus;
    Locator phoneNumber;
    Locator kostName;
    Locator surveyDate;

    public tenantSurveyPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        tenantSurveyMenu = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Tenant Survey"));
        tenantNameField = page.locator("#inputTenantName");
        tenantPhoneField = page.locator("#inputTenantPhone");
        tenantPropertyField = page.locator("#inputPropertyName");
        tenantStatusField = page.locator("#inputStatus");
        tenantSurveyField = page.locator("#inputSurveyDate");
        propertyNameField = page.locator("#inputPropertyName");
        surveyDateField = page.locator("#inputSurveyDate");
        searchSurveyButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Search"));
        editSurveyButton = page.locator("//a[@title='Edit']");
        tenantSurveyName = page.locator("//tr//td[1]");
        nextPage = page.locator("//a[@rel='next']");
        surveyStatus = page.locator("select[name=\"status\"]");
        saveSurveyButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save Changes"));
        alert = page.locator("//div[@class='alert alert-success alert-dismissable']");
        nextDateButton = page.locator("a[data-handler='next']");
        surveyDateInput = page.locator("[name='survey_date']");
        surveyTimeSelection = page.locator("//select[@name='survey_time']");
        tenantName = page.locator("tbody > tr:nth-of-type(1) > td:nth-of-type(1)");
        tenantStatus = page.locator("tbody > tr:nth-of-type(1) > td:nth-of-type(6)");
        phoneNumber = page.locator("tbody > tr:nth-of-type(1) > td:nth-of-type(2)");
        kostName = page.locator("tbody > tr:nth-of-type(1) > td:nth-of-type(3)");
        surveyDate = page.locator("tbody > tr:nth-of-type(1) > td:nth-of-type(4)");

    }


    /**
     * click menu Tenant Survey
     */

    public void clickTenantSurveyMenu() {
        playwright.clickOn(tenantSurveyMenu);
    }

    /**
     * Fill tenant name input filter with desired data
     *
     * @param tenantName input string that will match input value
     */
    public void fillOnTenantNameFilter(String tenantName) {
        playwright.forceFill(tenantNameField, tenantName);
    }

    /**
     * Fill tenant Status input filter with desired data
     *
     * @param tenantStatus input string that will match input value
     */
    public void fillOnTenantStatusFilter(String tenantStatus) {
        tenantStatusField.selectOption(tenantStatus);
    }

    /**
     * Fill tenant phone input filter with desired data
     *
     * @param tenantPhone input string that will match input value
     */
    public void fillOnTenantPhoneFilter(String tenantPhone) {
        playwright.forceFill(tenantPhoneField, tenantPhone);
    }

    /**
     * Input on Survey Date Filter
     * @param date input string that will match date value with desired data
     * @throws InterruptedException
     */
    public void fillOnSurveyDateFilter(String date) throws InterruptedException {
        playwright.forceFill(surveyDateField, date);
    }

    /**
     * Verify Search Button in the Tenant Survey Page is displayed
     * @return boolean
     */
    public Boolean isSearchButtonDisplayed() throws InterruptedException {
        return searchSurveyButton.isVisible();
    }


    /**
     * Fill tenant phone input filter with desired data
     *
     * @param tenantProperty input string that will match input value
     */
    public void fillOnTenantKostNameFilter(String tenantProperty) {
        playwright.forceFill(tenantPropertyField, tenantProperty);
    }


    /**
     * Click on Search Filter Button
     *
     * @throws InterruptedException
     */
    public void clickOnSearchFilterButton() throws InterruptedException {
        playwright.clickOn(searchSurveyButton);
    }


    /**
     * Click on Edit Button
     *
     * @throws InterruptedException
     */
    public void clickOnEditButton(String tenant) throws InterruptedException {
        List<Locator> editSurvey = playwright.getLocators(editSurveyButton);
        List<Locator> tenantSurvey = playwright.getLocators(tenantSurveyName);
        for (int i = 0; i < editSurvey.size(); i++) {
            if (playwright.getText(tenantSurvey.get(i)).equalsIgnoreCase(tenant)) {
                playwright.clickOn(editSurvey.get(i));
                return;
            } else if (i == editSurvey.size() - 1) {
                playwright.clickOn(nextPage);
                i = 0;
            }
        }
    }

    /**
     * Change Survey Status
     *
     * @param status
     */
    public void changeSurveyStatus(String status) throws InterruptedException {
        surveyStatus.selectOption(status);
        playwright.clickOn(saveSurveyButton);
    }

    /**
     * Is Success Alert Appear?
     *
     * @return true or false
     */
    public boolean isAlertAppear() throws InterruptedException {
        return alert.isVisible();
    }

    /**
     * Get Success Alert Text
     *
     * @return string
     */
    public String getAlertText() {
        return playwright.getText(alert);
    }

    /**
     * Change Survey Date
     *
     * @param date
     * @throws InterruptedException
     */
    public void changeSurveyDate(String date) throws InterruptedException {
        playwright.clickOn(surveyDateInput);
        if (date.equalsIgnoreCase("30") || date.equalsIgnoreCase("31"))
            playwright.clickOn(nextDateButton);
        playwright.clickOn(page.locator("//a[text()='" + date + "']"));
        playwright.clickOn(saveSurveyButton);
    }

    /**
     * Change Survey Time
     *
     * @param time
     * @throws InterruptedException
     */
    public void changeSurveyTime(String time) throws InterruptedException {
        surveyTimeSelection.selectOption(time);
        playwright.clickOn(saveSurveyButton);
    }


    /**
     * Get Tenant Name Table Result
     *
     * @return String data type list of additional price section
     */
    public List<String> getTenantNameTableResult() {
        List<String> textTenantSurvey = null;
        page.waitForLoadState(LoadState.LOAD);
        if (playwright.waitTillLocatorIsVisible(tenantName)) {
            playwright.waitFor(tenantName, 10000.0);
            textTenantSurvey = tenantName.allInnerTexts();
        }
        return textTenantSurvey;
    }

    /**
     * Get Tenant Status Table Result
     *
     * @return String data type list of additional price section
     */
    public List<String> getTenantStatusTableResult() {
        List<String> textTenantSurvey = null;
        page.waitForLoadState(LoadState.LOAD);
        if (playwright.waitTillLocatorIsVisible(tenantStatus)) {
            playwright.waitFor(tenantStatus, 10000.0);
            textTenantSurvey = tenantStatus.allInnerTexts();
        }
        return textTenantSurvey;
    }

    /**
     * Get Tenant Status Table Result
     *
     * @return String data type list of additional price section
     */
    public List<String> getTenantPhoneNumberTableResult() {
        List<String> textTenantSurvey = null;
        page.waitForLoadState(LoadState.LOAD);
        if (playwright.waitTillLocatorIsVisible(phoneNumber)) {
            playwright.waitFor(phoneNumber, 10000.0);
            textTenantSurvey = phoneNumber.allInnerTexts();
        }
        return textTenantSurvey;
    }

    /**
     * Get Tenant Kost Name Table Result
     *
     * @return String data type list of additional price section
     */
    public List<String> getTenantKostNameTableResult() {
        List<String> textTenantSurvey = null;
        page.waitForLoadState(LoadState.LOAD);
        if (playwright.waitTillLocatorIsVisible(kostName)) {
            playwright.waitFor(kostName, 10000.0);
            textTenantSurvey = kostName.allInnerTexts();
        }
        return textTenantSurvey;
    }

    /**
     * Get Tenant Survey Date Table Result
     *
     * @return String data type list of additional price section
     */
    public List<String> getTenantSurveyDateTableResult() {
        List<String> textTenantSurvey = null;
        page.waitForLoadState(LoadState.LOAD);
        if (playwright.waitTillLocatorIsVisible(surveyDate)) {
            playwright.waitFor(surveyDate, 10000.0);
            textTenantSurvey = surveyDate.allInnerTexts();
        }
        return textTenantSurvey;
    }

}
