package pageobject.owner.kelolatagihan;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

import java.util.List;

public class TenantBillManagementPO {
    Page page;
    PlaywrightHelpers playwright;
    Locator filterKos;
    Locator filterMonth;
    Locator invoiceList;
    Locator sudahByrTab;
    Locator successTransferLabel;
    Locator kostDropdown;
    Locator searchKostTextbox;
    Locator lihatSelengkapnyaButton;
    Locator roomNumberText;
    Locator updateRoomNumberButton;
    Locator saveButton;
    Locator kostDropdownInPenyewaMenu;
    Locator selectKost;
    Locator kontrakSewaButton;
    Locator tolakButton;
    Locator ubahKontrakPenyewaButton;


    public TenantBillManagementPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        filterKos = page.locator("div.bm-filter__kost");
        filterMonth = page.locator("input[type=\"text\"]").first();
        invoiceList = page.getByTestId("invoice-status-label").last();
        sudahByrTab = page.getByText("Sudah bayar");
        successTransferLabel = page.getByTestId("invoice-status-label");
        kostDropdown = page.locator("(//*[@class='bg-c-select__trigger-text'])[1]");
        searchKostTextbox = page.getByPlaceholder("Cari nama kos");
        lihatSelengkapnyaButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Selengkapnya"));
        roomNumberText = page.locator("//*[@class='tenant-header__room-info']/p");
        updateRoomNumberButton = page.getByText("Ubah nomor kamar chevron-right");
        saveButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Simpan"));
        kostDropdownInPenyewaMenu = page.locator("(//div[@class='bg-c-select__trigger bg-c-select__trigger--lg'])[1]");
        selectKost = page.locator("a").filter(new Locator.FilterOptions().setHasText("kost bali for contract section Tobelo Utara Halmahera Utara"));
        kontrakSewaButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Kontrak sewa"));
        tolakButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tolak"));
        ubahKontrakPenyewaButton = page.getByTestId("btn-edit-contract");
    }

    /**
     * Select kos filter by kos name
     * @param kostName Kos Name
     */
    public void selectKosBillPageFilter(String kostName) {
        Locator kosNameFilter = page.getByText(kostName);
        playwright.waitFor(filterKos, 30000.0);
        List<String> filterKostInnerTexts = filterKos.allInnerTexts();
        if (!filterKostInnerTexts.get(0).contains(kostName)) {
            playwright.clickOn(filterKos);
            playwright.clickOn(kosNameFilter);
        }
    }

    /**
     * Select month filter by month name
     * @param month String type month name
     */
    public void selectMonthFilter(String month) {
        Locator monthName = page.getByTestId("billingManagementFilterDate-wrapper").getByText(month);
        playwright.waitFor(filterMonth, 30000.0);
        if (!filterMonth.allInnerTexts().get(0).contains(month)) {
            playwright.clickOn(filterMonth);
            playwright.clickOn(monthName);
        }
    }

    /**
     * Click on invoice list and navigate to billing details
     * Only work if there is only one item in the list
     * @return BillDetailsPO class
     */
    public BillDetailsPO clickOnInvoiceList() {
        playwright.clickOn(invoiceList.last());
        return new BillDetailsPO(page);
    }

    /**
     * Click on invoice list based jatuh tempo text
     * @param setName Set with jatuh tempo test example: Belum bayar - Jatuh tempo sekarang
     * @return BillDetailsPO class
     */
    public BillDetailsPO clickOnInvoiceList(String setName) {
        Locator invoiceList = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(setName)).getByTestId("invoice-status-label").last();
        playwright.clickOn(invoiceList);
        return new BillDetailsPO(page);
    }

    /**
     * Click on invoice list based on tenant name and jatuh tempo text
     * @param setTenant Tenant name
     * @param setJatuhTempo Set with jatuh tempo test example: Belum bayar - Jatuh tempo sekarang
     * @return BillDetailsPO class
     */
    public BillDetailsPO clickOnInvoiceList(String setTenant, String setJatuhTempo) {
        Locator invoiceList = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(setTenant).setName(setJatuhTempo)).getByTestId("invoice-status-label").last();
        playwright.clickOn(invoiceList);
        return new BillDetailsPO(page);
    }

    /**
     * Reload page if filter kos is not visible
     */
    public void reloadOnEmptyKelolaTagihanPage() {
        if(!filterKos.isVisible()) {
            page.reload();
        }
    }

    /**
     * clicks on Sudah bayar tab
     */
    public void clicksOnSudahBayarTab() {
        playwright.clickOn(sudahByrTab);
    }

    /**
     * Get Label success transfer
     * @return String data type of label success
     */
    public String getLabelSuccessTransfer() {
        return playwright.getText(successTransferLabel);
    }

    /**
     * user as owner click kost dropdown
     * user enter kost name
     * user choose kost name
     */
    public void searchKostPenyewa(String kostName){
        playwright.hardWait(3000.0);
        playwright.clickOn(kostDropdown);
        searchKostTextbox.fill(kostName);
        Locator kostSearch = page.locator("a").filter(new Locator.FilterOptions().setHasText(kostName));
        playwright.clickOn(kostSearch);
    }

    /**
     * clicks on lihat selengkapnya
     */
    public void clicksOnLihatSelengkapnya() {
        playwright.clickOn(lihatSelengkapnyaButton);
    }

    /**
     * get room number on penyewa page
     * @return room number
     */
    public String getRoomNumberText(){
        return playwright.getText(roomNumberText);
    }

    /**
     * click update room number button
     *
     */
    public void clickOnUbahRoomNumberBtn() {
        playwright.clickOn(updateRoomNumberButton);
    }

    /**
     * click Ubah room number
     * and change into the old number (change into first condition)
     * @param roomNumber
     */
    public void chooseRoomNumber(String roomNumber) {
        Locator element = page.locator(" div.room-list-select.room-allotment__options > div:nth-child("+roomNumber+") > div");
        playwright.clickOn(element);
        playwright.clickOn(saveButton);
    }

    /**
     * to check is update room number button appear or not
     * @return boolean
     */
    public boolean isUpdateRoomNumberVisible() {
        return updateRoomNumberButton.isVisible();
    }

    /**
     * user as owner click kost dropdown
     * user enter kost name
     * user choose kost name
     */
    public void searchKostInPenyewaMenu(String kostName) {
        playwright.waitTillLocatorIsVisible(kostDropdownInPenyewaMenu);
        kostDropdownInPenyewaMenu.click();
        searchKostTextbox.fill(kostName);
        selectKost.click();
        lihatSelengkapnyaButton.click();
    }

    /**
     * user as owner click kontrak sewa
     */
    public void clickOnKontrakSewaButton() {
        kontrakSewaButton.click();
    }

    /**
     * user as owner click tolak berhenti sewa
     */
    public void clickOnTolakButton() {
        tolakButton.click();
    }

    /**
     * user as owner click ubah kontrak penyewa
     */
    public void clickOnUbahKontrakPenyewaButton() {
        ubahKontrakPenyewaButton.click();
    }

    /**
     * this method will be information activities tagihan in my kos displayed
     */
    public String isPriceDisplayed(String price){
        Locator totalAmount = page.locator("//p[.='"+price+"']");
        return playwright.getText(totalAmount);
    }
}
