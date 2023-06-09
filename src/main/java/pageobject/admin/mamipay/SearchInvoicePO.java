package pageobject.admin.mamipay;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import utilities.PlaywrightHelpers;

import java.util.List;

public class SearchInvoicePO {
    private Page page;
    private PlaywrightHelpers playwright;

    //Search Invoice Menu form left bar
    Locator autoExtendSelection;
    Locator btnCariInvoice;
    Locator seeLogButton;
    Locator valueFieldTable;
    Locator labelFieldTable;
    Locator contentTable;
    Locator tableHeadData;
    Locator pushNotifTableData;
    Locator whatsAppTableData;

    public SearchInvoicePO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);

        //Search Invoice Menu form left bar
        autoExtendSelection = page.locator("[name='from_auto_extend']");
        btnCariInvoice = page.locator("input[value='Cari Invoice']");

    }

    /**
     * Select on Auto Extend Selection
     * @param item input string that will define item value
     */
    public void selectOnAutoExtendSelection(String item){
        playwright.selectDropdownByValue(autoExtendSelection,item);
    }

    /**
     * Click on Search Invoice Button on Admin Search Invoice Page
     *
     */
    public void clickOnSearchInvoiceButton() {
        playwright.clickOn(btnCariInvoice);
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
     * Is Search Invoice Results True Auto Extend Value
     * @param value
     * @param status
     * @param counter
     * @return Locator
     */
    public Boolean isSearchInvoiceResultsHaveAutoExtendCorrectValue(String value, String status, Integer counter){
        Locator element = page.locator("//span[text()='"+value+"']//parent::span[@class='label label-"+status+"']");
        List<Locator> elements = playwright.getLocators(element);
        return playwright.waitTillLocatorIsVisible(elements.get(counter));
    }

    /**
     * Get Auto Extend Value of Search Invoice Results
     * @param value input string that define value itself
     * @param status input string that define status value
     * @param counter integer input that define counter value
     * @return String
     */
    public String getAutoExtendValueOfSearchInvoiceResults(String value, String status, Integer counter){
        Locator element = page.locator("//span[text()='"+value+"']//parent::span[@class='label label-"+status+"']");
        List<Locator> elements = playwright.getLocators(element);
        return playwright.getText(elements.get(counter));
    }

    /**
     * Click on See Log Button
     * @param link input string that define link value
     *
     */
    public void clickOnSeeLogButton(String link) {
        seeLogButton = page.locator("//a[@href='" + Mamikos.ADMINMAMIPAY + "/backoffice/log/invoice"+link+"']");
        playwright.clickOn(seeLogButton);
    }

    /**
     * Get Billing Reminder Type Table Text
     * @param value input string that define text value
     * @return string
     */
    public String getBiliingReminderTypeTableValue(String value){
        Page page = ActiveContext.getActivePage();
        valueFieldTable = page.locator("//td[contains(text(), '"+value+"')]");
        valueFieldTable.scrollIntoViewIfNeeded();
        return playwright.getText(valueFieldTable);
    }

    /**
     * Get Reminder Type Table Text
     * @param labelField input string that define text value
     * @return string
     */
    public String getReminderTypeTableText(String labelField){
        Page page = ActiveContext.getActivePage();
        labelFieldTable = page.locator("//th[contains(text(), '"+labelField+"')]");
        return playwright.getText(labelFieldTable);
    }

    /**
     * Get Table Content Template
     * @param content input string that will search element text
     * @return string
     */
    public String getTableContentTemplate(String content){
        Page page = ActiveContext.getActivePage();
        contentTable = page.locator("//*[text() = '"+content+"']").first();
        return playwright.getText(contentTable);
    }

    /**
     * @return String head data table
     */
    public String getTableHeadData(Integer index){
        tableHeadData = page.locator("//div[7]/table/thead/tr/th");
        List<Locator> elements = playwright.getLocators(tableHeadData);
        return playwright.getText(elements.get(index));
    }

    /**
     * @return String notif data table
     */
    public String getPushNotifTableData(Integer index){
        pushNotifTableData = page.locator("//tr[5]//parent::td");
        List<Locator> elements = playwright.getLocators(pushNotifTableData);
        return playwright.getText(elements.get(index));
    }

    /**
     * @return String whatsapp table data
     */
    public String getWhatsAppTableData(Integer index){
        whatsAppTableData = page.locator("//tr[2]/child::td");
        List<Locator> elements = playwright.getLocators(whatsAppTableData);
        return playwright.getText(elements.get(index)).replace("\n","");
    }

}
