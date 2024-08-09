package pageobject.admin.mamipay;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.SelectOption;
import utilities.PlaywrightHelpers;

import java.util.List;


public class GolplusContractPO {
    private Page page;
    PlaywrightHelpers playwright;
    Locator keywordSearch;
    Locator btnSearchContract;
    Locator btnResetContract;
    Locator phoneNumber;
    Locator gpPackageLocator;
    Locator statusGP;
    Locator searchOwnerName;
    Locator ownerResult;
    Locator periodePackageGP;
    Locator periodeSelect;
    Locator gpPackage;
    Locator statusSelect;
    Locator showOrder;
    Locator headerContractOrder;
    Locator phoneNumberOrder;
    Locator gpPackageOrder;
    Locator statusGpOrder;
    Locator invoiceGpStatus;
    Locator createNewContractButton;
    Locator phoneNumberOwner;
    Locator contractInvoiceButton;
    Locator confirmContractButton;


    public GolplusContractPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        keywordSearch = page.getByPlaceholder("Keyword");
        btnSearchContract = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Search"));
        btnResetContract = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Reset"));
        searchOwnerName =  page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Search by"));
        periodePackageGP = page.getByPlaceholder("Packages");
        gpPackage = page.locator("//tbody[1]/tr[1]/td[3] ");
        showOrder =  page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Show Orders"));
        headerContractOrder = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Contract's Orders"));
        createNewContractButton =  page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Create New Contract"));
        phoneNumberOwner = page.getByPlaceholder("Phone Number");
        contractInvoiceButton =   page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Create Contract and Invoice"));
        confirmContractButton =  page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Yes, Create contract and invoice!"));

    }

    /**
     * Search contract keyword
     * @param phoneNumber of phone number owner
     */
    public void searchContract(String phoneNumber) {
        playwright.fill(keywordSearch,phoneNumber);
    }

    /**
     * Click on button search contract GP
     */
    public void clickOnButtonSearchContract() {
        playwright.clickOn(btnSearchContract);
    }

    /**
     * Click on button reset contract GP
     */
    public void clickOnButtonResetContract() {
        playwright.clickOn(btnResetContract);
    }

    /**
     * get phone number from search result
     */
    public String getPhoneNumber(String phone) {
        phoneNumber = page.getByText(phone);
        return playwright.getText(phoneNumber);
    }

    /**
     * get goldplus package from search result
     */
    public String getGpPackage(String gpPackage) {
        gpPackageLocator = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(gpPackage)).first();
        return playwright.getText(gpPackageLocator);
    }

    /**
     * get status contract from search result
     */
    public String getStatusContractGP(String status) {
        statusGP = page.getByText(status, new Page.GetByTextOptions().setExact(true));
        return playwright.getText(statusGP);
    }

    /**
     * Select option owner name
     * @param ownerName String data type
     */
    public void selectDropdownOwnerName(String ownerName) {
     playwright.selectDropdownByValue(searchOwnerName,ownerName);
    }

    /**
     * get owner name from search result
     */
    public String getOwnerName(String owner) {
        ownerResult = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(owner));
        return playwright.getText(ownerResult);
    }

    /**
     * Search by periode golplus
     * @param periode of phone number owner
     */
    public void searchContractByPeriode(String periode) {
        playwright.fill(periodePackageGP,periode);
        periodeSelect = page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName(periode));
        playwright.clickOn(periodeSelect);

    }

    /**
     * get text gp package from result
     */
    public String getTextGP(String gp) {
        return playwright.getText(gpPackage);
    }

    /**
     * Search by status contract gp
     * @param status of phone number owner
     */
    public void searchContractByStatusContract(String status) {
        statusSelect = page.locator("//select[@name='status']");
        playwright.selectDropdownByValue(statusSelect,status);
    }

    /**
     * get text status contract from result
     * @param value input string that define value itself
     * @param status input string that define status value
     * @param counter integer input that define counter value
     * @return String
     */
    public String getStatusResult(String value, String status, Integer counter) {
        Locator element = page.locator("//span[text()='"+value+"']//parent::span[@class='label label-"+status+"']");
        List<Locator> elements = playwright.getLocators(element);
        return playwright.getText(elements.get(counter));
    }


    /**
     * Pass results as List Web Element
     * @param value input string that define value itself
     * @param status input string that define status value
     * @return Locator
     */
    public List<Locator> getResultsElement(String value, String status){
        Locator element = page.locator("//span[text()='"+value+"']//parent::span[@class='label label-"+status+"']");
        return playwright.getLocators(element);
    }


    /**
     * Click on show orders at gp contract
     */
    public void clickOnShowOrders() {
        playwright.clickOn(showOrder);
    }

    /**
     * user verify the alokasi ads title
     * @return header locator
     */
    public boolean getHeaderContractOrder() {
        return playwright.waitTillLocatorIsVisible(headerContractOrder);
    }

    /**
     * get owner phone number from contract order
     */
    public String getPhoneNumberFromOrder(String phone) {
        phoneNumberOrder =page.getByText(phone);
        return playwright.getText(phoneNumberOrder);
    }

    /**
     * get pembelian GP Package at contract order page
     */
    public String getGoldplusOrder(String gp) {
        gpPackageOrder = page.locator("//td[2]");
        return playwright.getText(gpPackageOrder);
    }

    /**
     * get status godlplus at contract order page
     */
    public String getStatusGoldplusOrder(String status) {
        statusGpOrder = page.locator(".invoice-status-label");
        return playwright.getText(statusGpOrder);
    }

    /**
     * get status godlplus
     */
    public String getStatusInvoiceGoldplusOrder(String invoiceStatus) {
        invoiceGpStatus = page.locator(".order-status-label");
        return playwright.getText(invoiceGpStatus);
    }

    /**
     * Click on create contract button
     */
    public void clickOnCreateContractButton() {
        playwright.clickOn(createNewContractButton);
    }

    /**
     * admin input phone number owner
     */
    public void inputPhoneNumberOwner(String phone) {
        playwright.fill(phoneNumberOwner,phone);
    }

    /**
     * Click on create contract and invoice
     */
    public void clickOnCreateContractInvoiceButton() {
        playwright.clickOn(contractInvoiceButton);
    }

    /**
     * get status godlplus
     */
    public String getWarningNotification(String warningNotification) {
        Locator element =  page.getByText(warningNotification);
        return playwright.getText(element);
    }

    /**
     * Select package Goldplis
     * @param packageGP of goldplus package
     */
    public void selectDropdownPackage(String packageGP) {
        Locator element =  page.locator("//select[@name='package']");
        playwright.selectDropdownByValue(element,packageGP);
    }


}

