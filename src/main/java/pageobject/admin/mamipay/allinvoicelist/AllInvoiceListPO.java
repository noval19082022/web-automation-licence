package pageobject.admin.mamipay.allinvoicelist;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AllInvoiceListPO {
    private Page page;
    PlaywrightHelpers playwright;

    private Locator allInvoiceMenu;
    private Locator orderTypeList;
    private Locator orderTypeDropdown;
    private Locator cariInvoiceButton;
    private Locator nextButton;
    private Locator searchByDropdown;
    private Locator searchValueInput;
    private Locator rowData;
    private Locator invoiceStatusLabel;
    private Locator changeStatusButton;
    private Locator statusInvoiceDropdown;
    private Locator transactionDate;
    private Locator submitChangeStatusButton;
    private Locator firstShortlink;
    private Locator viewLogButton;
    private Locator dataInvoice;
    private Locator revisionHistoryChangeBy;
    private Locator revisionHistoryChangerRole;
    private Locator revisionHistoryWhatChanged;
    private Locator revisionHistoryOldValue;
    private Locator revisionHistoryNewValue;
    private Locator paymentHistory;

    public AllInvoiceListPO(Page page){
        this.page = page;
        playwright = new PlaywrightHelpers(page);

        rowData = page.locator("tbody tr");
        allInvoiceMenu = page.getByRole(AriaRole.LINK).filter(new Locator.FilterOptions().setHasText("All Invoice List"));
        orderTypeList = page.locator("tr td:nth-of-type(5)");
        orderTypeDropdown = page.locator("[name='order_type']");
        cariInvoiceButton = page.locator("input[value='Cari Invoice']");
        searchByDropdown = page.locator("[name='search_by']");
        searchValueInput = page.locator("[name='search_value']");
        nextButton = page.locator("a[rel='next']");
        invoiceStatusLabel = page.locator("tr td:nth-of-type(9) span");
        changeStatusButton = page.locator("a.btn-flat").filter(new Locator.FilterOptions().setHasText("Change Status"));
        viewLogButton = page.locator("a.btn-flat").filter(new Locator.FilterOptions().setHasText("View Log"));
        statusInvoiceDropdown = page.locator("[name='status']");
        transactionDate = page.locator("[name='paid_at']");
        submitChangeStatusButton = page.locator("[value='Submit Change']");
        firstShortlink = page.locator("td:first-child a");
        dataInvoice = page.locator("(//table)[1]//td");
        paymentHistory = page.locator("(//table)[3]//td");
    }

    /**
     * Open menu All Invoice List
     */
    public void openAllInvoiceListMenu() {
        playwright.clickOn(allInvoiceMenu);
    }

    /**
     * Check if list all invoice contains invoice manual
     * @return boolean
     */
    public boolean isListContainsInvoiceManual() {
        boolean result = false;
        //check every page until found invoice manual
        while (nextButton.isEnabled()){
            //check in page n, if there is invoice manual
            for (int i=0;i<orderTypeList.count();i++) {
                if (orderTypeList.nth(i).textContent().trim().equalsIgnoreCase("Biaya Sewa") || orderTypeList.nth(i).textContent().trim().equalsIgnoreCase("Biaya Tambahan")){
                    result = true;
                    break;
                }
            }
            if (result == false){
                playwright.clickOn(nextButton);
            } else {
                break;
            }
        }
        return result;
    }

    /**
     * Select and filter by order type
     * @param type
     */
    public void filterOrderType(String type) {
        playwright.selectDropdownByValue(orderTypeDropdown,type);
        playwright.clickOn(cariInvoiceButton);
        playwright.waitTillDomContentLoaded(10000.0);
    }

    /**
     * check is all invoice are invoice manual
     * @return boolean
     */
    public boolean isAllListInvoiceManual() {
        boolean result = true;
        for (int i=0;i<orderTypeList.count();i++){
            if (!(orderTypeList.nth(i).textContent().trim().equalsIgnoreCase("Biaya Sewa") || orderTypeList.nth(i).textContent().trim().equalsIgnoreCase("Biaya Tambahan"))){
                result = false;
                System.out.println("please check invoice row "+(i+1));
                break;
            }
        }
        return result;
    }

    /**
     * Search invoice
     * @param searchBy
     * @param searchValue
     */
    public void searchInvoice(String searchBy, String searchValue) {
        playwright.selectDropdownByValue(searchByDropdown,searchBy);
        playwright.fill(searchValueInput,searchValue);
        playwright.clickOn(cariInvoiceButton);
    }

    /**
     * get Invoice Status in list all invoice
     * @param index
     * @return
     */
    public String getInvoiceStatus(int index) {
        playwright.pageScrollInView(invoiceStatusLabel);
        return playwright.getText(invoiceStatusLabel.nth(index));
    }

    /**
     * count row in list all invoice
     * @return
     */
    public int countRowData() {
        return rowData.count();
    }

    /**
     * change status invoice
     * @param status
     * @param date
     */
    public void changeStatusInvoice(String status, String date) {
        playwright.clickOn(changeStatusButton.first());
        playwright.selectDropdownByValue(statusInvoiceDropdown,status);
        if (date.equalsIgnoreCase("today")){
            LocalDateTime today = LocalDateTime.now();
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String d = today.format(format);
            playwright.fill(transactionDate,d);
        } else {
            playwright.fill(transactionDate,date);
        }
        playwright.clickOn(submitChangeStatusButton);
    }

    /**
     * click on shortlink to open tenant invoice
     */
    public void openTenantInvoice() {
        playwright.clickOn(firstShortlink);
    }

    /**
     *View log invoice
     */
    public void viewLog() {
        playwright.clickOn(viewLogButton);
    }

    /**
     * Get invoice number of Data Invoice in invoice log
     * @return String
     */
    public String getDataInvoiceNumber() {
        return playwright.getText(dataInvoice.nth(0));
    }

    /**
     * Get status of Data Invoice in invoice log
     * @return String
     */
    public String getDataStatus() {
        return playwright.getText(dataInvoice.nth(2));
    }

    /**
     * Get Order Type of Data Invoice in invoice log
     * @return String
     */
    public String getDataOrderType() {
        return playwright.getText(dataInvoice.nth(3));
    }

    /**
     * Get Amount of Data Invoice in invoice log
     * @return String
     */
    public String getDataAmount() {
        return playwright.getText(dataInvoice.nth(5));
    }

    /**
     * Get Paid Amount of Data Invoice in invoice log
     * @return String
     */
    public String getDataPaidAmount() {
        return playwright.getText(dataInvoice.nth(6));
    }

    /**
     * Get Change By of Data Revision History in invoice log
     * @param i row data
     * @return String
     */
    public String getRevisionChangeBy(int i) {
        revisionHistoryChangeBy = page.locator("(((//table)[2]//tr)["+(i+1)+"]//td)[1]");
        return playwright.getText(revisionHistoryChangeBy);
    }

    /**
     * Get Changer Role of Data Revision History in invoice log
     * @param i row data
     * @return String
     */
    public String getRevisionChangerRole(int i) {
        revisionHistoryChangerRole = page.locator("(((//table)[2]//tr)["+(i+1)+"]//td)[2]");
        return playwright.getText(revisionHistoryChangerRole);
    }

    /**
     * Get What Changed of Data Revision History in invoice log
     * @param i row data
     * @return String
     */
    public String getRevisionWhatChanged(int i) {
        revisionHistoryWhatChanged = page.locator("(((//table)[2]//tr)["+(i+1)+"]//td)[3]");
        return playwright.getText(revisionHistoryWhatChanged);
    }

    /**
     * Get Old Value of Data Revision History in invoice log
     * @param i row data
     * @return String
     */
    public String getRevisionOldValue(int i) {
        revisionHistoryOldValue = page.locator("(((//table)[2]//tr)["+(i+1)+"]//td)[4]");
        return playwright.getText(revisionHistoryOldValue);
    }

    /**
     * Get New Value of Data Revision History in invoice log
     * @param i row data
     * @return String
     */
    public String getRevisionNewValue(int i) {
        revisionHistoryNewValue = page.locator("(((//table)[2]//tr)["+(i+1)+"]//td)[5]");
        return playwright.getText(revisionHistoryNewValue);
    }

    /**
     * Get Payment Method of Data Payment History in invoice log
     * @return String
     */
    public String getHistoryPaymentMethod() {
        return playwright.getText(paymentHistory.nth(0));
    }

    /**
     * Get Amount of Data Payment History in invoice log
     * @return String
     */
    public String getHistoryAmount() {
        return playwright.getText(paymentHistory.nth(1));
    }

    /**
     * Get Status of Data Payment History in invoice log
     * @return String
     */
    public String getHistoryStatus() {
        return playwright.getText(paymentHistory.nth(5));
    }

    /**
     * Get Paid Amount of Data Payment History in invoice log
     * @return String
     */
    public String getHistoryPaidAmount() {
        return playwright.getText(paymentHistory.nth(6));
    }
}
