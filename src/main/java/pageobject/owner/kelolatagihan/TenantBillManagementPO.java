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
    Locator kontrakSewaButton;
    Locator tolakButton;
    Locator ubahKontrakPenyewaButton;
    Locator tenantHeaderTxt;
    Locator headerContractStatus;
    Locator tenantPhoto;
    Locator detailTenantName;
    Locator detailTenantGender;
    Locator detailTenantStatus;
    Locator detailTenantJob;
    Locator disclaimerCheckinTenant;
    Locator detailStartContract;
    Locator detailEndContract;
    Locator detailTotalBill;
    Locator detailRentDuration;
    Locator detailNearestBill;
    Locator hentikanSewaButton;
    Locator ubahKontrakPenyewaBtn;
    Locator contractNumber1;
    Locator contractList;
    Locator contractPageEmpty;
    Locator contractName;
    Locator clickSelengkapnyaContract;
    Locator arrowNextMonthFilterButton;
    Locator krmUlangKodeBtn;
    Locator krmKodeUnikPage;
    Locator ubahNmrHpBtn;
    Locator phoneNumberField;
    Locator gunakanBtn;
    Locator  dontHaveKosWarning;

    //Locator for download biodata penyewa
    Locator filterDropdown;
    Locator downloadBiodataPenyewaButton;
    Locator checkbox;
    Locator informationAboutUpcomingFeature;
    Locator kostDropdownInBillingManagement;
    Locator lihatStatusTagihanBtn;
    Locator billingManagementModalCloseIcon;

    Locator disbursementLink;

    public TenantBillManagementPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        filterKos = page.locator("div.bm-filter__kost");
        filterMonth = page.locator("//div[@class='vdp-datepicker bg-c-input bg-c-input--has-right-icon bg-c-input--lg']").first();
        invoiceList = page.getByTestId("invoice-status-label").last();
        sudahByrTab = page.getByText("Sudah bayar");
        successTransferLabel = page.getByTestId("invoice-status-label");
        kostDropdown = page.locator("(//*[@class='bg-c-select__trigger-text'])[1]");
        searchKostTextbox = page.getByPlaceholder("Cari nama kos");
        lihatSelengkapnyaButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Selengkapnya")).first();
        roomNumberText = page.locator("//*[@class='tenant-header__room-info']/p");
        updateRoomNumberButton = page.getByText("Ubah nomor kamar chevron-right");
        saveButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Simpan"));
        kostDropdownInPenyewaMenu = page.locator("(//div[@class='bg-c-select__trigger bg-c-select__trigger--lg'])[1]");
        kontrakSewaButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Kontrak sewa"));
        tolakButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tolak"));
        ubahKontrakPenyewaButton = page.getByTestId("btn-edit-contract");
        headerContractStatus = page.getByTestId("statusContractLabel-active");
        tenantPhoto = page.locator("//div[@class='bg-c-avatar bg-c-avatar--xl']");
        disclaimerCheckinTenant = page.locator("//div[contains(@class,'tenant-header__alert')]");
        contractNumber1 = page.locator("(//div[@class='tenant-list__card'])[1]");
        contractList = page.locator("//div[@class='tenant-card-item__info']");
        disclaimerCheckinTenant = page.locator("//div[contains(@class,'tenant-header__alert')]");
        filterDropdown = page.locator("//div[@class='bg-c-select']//div[@class='bg-c-dropdown']");
        downloadBiodataPenyewaButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Download biodata penyewa"));
        checkbox = page.locator("//div[@class=\"modal-download__download-alert bg-c-checkbox\"]//span[@class=\"bg-c-checkbox__icon\"]");
        informationAboutUpcomingFeature = page.locator("//div[@class='modal-download__download-alert bg-c-alert bg-c-alert--info']//div[@class='bg-c-alert__content']");
        kostDropdownInBillingManagement = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("Icon arrow down"));
        billingManagementModalCloseIcon = page.locator(".bm-filter-kost-modal__header .close-icon");
        arrowNextMonthFilterButton = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("arrow-right"));
        lihatStatusTagihanBtn = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Lihat Status Tagihan"));
        krmUlangKodeBtn = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Kirim ulang kode"));
        krmKodeUnikPage = page.getByText("Kirim kode unik ke penyewa");
        ubahNmrHpBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ubah nomor HP"));
        phoneNumberField = page.getByPlaceholder("Masukkan nomor HP");
        gunakanBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Gunakan"));
        dontHaveKosWarning = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Belum Ada Penyewa Kos"));
        disbursementLink = page.locator("//a[contains(.,'Kapan uang masuk ke rekening saya?')]");
    }

    /**
     * Select kos filter by kos name
     * @param kostName Kos Name
     */
    public void selectKosBillPageFilter(String kostName) {
        Locator kosNameFilter = page.getByText(kostName);
        playwright.waitFor(filterKos, 30000.0);
        List<String> filterKostInnerTexts = playwright.getListInnerTextFromListLocator(filterKos);
        if (!filterKostInnerTexts.get(0).contains(kostName)) {
            playwright.waitFor(filterKos, 30000.0);
            playwright.clickOn(filterKos);
            playwright.clickOn(kosNameFilter);
        }
    }

    /**
     * Click on filter month
     */
    public void clickOnFilterMonth() {
        playwright.clickOn(filterMonth);
    }

    /**
     * Click on month name on filter month
     * @param month String type month name
     */
    public void clickOnMonthNameOnFilterMonth(String month) {
        Locator monthName = page.getByTestId("billingManagementFilterDate-wrapper").getByText(month);
        playwright.clickOn(monthName);
    }

    /**
     * Select month filter by month name
     * @param month String type month name
     */
    public void selectMonthFilter(String month) {
        Locator monthName = page.getByText(month, new Page.GetByTextOptions().setExact(true));
        playwright.waitFor(filterMonth, 30000.0);
        playwright.waitTillPageLoaded();
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
        Locator selectKost = page.locator("a").filter(new Locator.FilterOptions().setHasText(kostName));
        playwright.clickOn(selectKost);
    }

    /**
     * user as owner click lihat selengkapnya button
     */
    public void clickOnLihatSelengkapnyaButton() {
        playwright.clickOn(lihatSelengkapnyaButton);
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

    /**
     * get Tenant Name on header penyewa page
     * @return Tenant Name
     */
    public String getTenantHeaderName(String name) {
        tenantHeaderTxt = page.getByTestId("tenant-header").getByText(name);
        return playwright.getText(tenantHeaderTxt);
    }

    /**
     * get Phone Number on header penyewa page
     * @return Phone Number
     */
    public String getHeaderPhoneNumber(String phoneNumber) {
        tenantHeaderTxt = page.getByTestId("tenant-header").getByText(phoneNumber);
        return playwright.getText(tenantHeaderTxt);
    }

    /**
     * get Contract Status on header penyewa page
     * @return Contact Status
     */
    public String getHeaderContractStatus() {
        return playwright.getText(headerContractStatus);
    }

    /**
     * assert tenant photo is visible
     * @return true or false
     */
    public boolean isTenantPhotoVisible() {
        return tenantPhoto.isVisible();
    }

    /**
     * get Tenant Name on detail penyewa page
     * @return Tenant Name
     */
    public String getDetailTenantName(String name) {
        detailTenantName =  page.getByTestId("tab-biodata").getByText(name);
        return playwright.getText(detailTenantName);
    }

    /**
     * get Tenant Gender on detail penyewa page
     * @return Tenant Gender
     */
    public String getDetailTenantGender(String gender) {
        detailTenantGender = page.getByText(gender);
        return playwright.getText(detailTenantGender);
    }

    /**
     * get Tenant status on detail penyewa page
     * @return Tenant status
     */
    public String getDetailTenantStatus(String status) {
        detailTenantStatus = page.getByText(status);
        return playwright.getText(detailTenantStatus);
    }

    /**
     * get Tenant job on detail penyewa page
     * @return Tenant job
     */
    public String getDetailTenantJob(String job) {
        detailTenantJob = page.getByText(job, new Page.GetByTextOptions().setExact(true));
        return playwright.getText(detailTenantJob);
    }

    /**
     * assert disclaimer text is not display
     */
    public boolean isDisclaimerTextVisible() {
        return disclaimerCheckinTenant.isVisible();
    }

    /**
     * get Start Contract on detail rent contract
     * @return Start Contract
     */
    public String getDetailStartContract(String start) {
        detailStartContract = page.getByText(start);
        return playwright.getText(detailStartContract);
    }

    /**
     * get End Contract on detail rent contract
     * @return End Contract
     */
    public String getDetailEndContract(String end) {
        detailEndContract = page.getByText(end);
        return playwright.getText(detailEndContract);
    }

    /**
     * get Total Bill on detail rent contract
     * @return Total Bill
     */
    public String getDetailTotalBill() {
        detailTotalBill = page.locator("//div[contains(text(),'Total yang ditagih')]/../following-sibling::div");
        return playwright.getText(detailTotalBill);
    }

    /**
     * get Rent Duration on detail rent contract
     * @return Rent Duration
     */
    public String getDetailRentDuration(String duration) {
        detailRentDuration = page.getByText(duration);
        return playwright.getText(detailRentDuration);
    }

    /**
     * get Nearest Bill on detail rent contract
     * @return Nearest Bill
     */
    public String getDetailNearestBill(String nearestBill) {
        detailNearestBill = page.getByText(nearestBill);
        return playwright.getText(detailNearestBill);
    }

    /**
     * Verify system display terminate contract link
     */
    public void displayTerminateContract() {
        hentikanSewaButton = page.getByTestId("btn-terminate-contract");
        hentikanSewaButton.isVisible();
    }

    /**
     * assert ubah kontrak sewa button is display
     */
    public void ubahKontrakPenyewaIsVisible() {
        ubahKontrakPenyewaBtn = page.getByTestId("btn-edit-contract");
        ubahKontrakPenyewaBtn.isVisible();
    }

    /**
     * Get number of booking list
     * @throws InterruptedException
     * @return number of elements
     */
    public int getNumberListOfContract() {
        playwright.hardWait(2);
        int numberOfElements = 0;
        if (contractNumber1.isVisible()){
            numberOfElements = playwright.getLocators(contractList).size();
        } else {
            contractPageEmpty.isVisible();
        }
        return numberOfElements;
    }

    /**
     * Get one data booking status
     * @param index is number for specific data want to get
     * @return booking status
     */
    public String getContractName(int index) {
//        contractName = page.getByText(index);
        contractName = page.locator("(//div[@class='tenant-card-item__content']/p)[" + index + "]");
        return playwright.getText(contractName);
    }

    /**
     * Click selengkapnya button based on contract name (tenant's contract)
     * @throws InterruptedException
     */
    public void clickSelengkapnyaContract(int index) throws InterruptedException {
        clickSelengkapnyaContract = page.locator("(//b[contains(., 'Selengkapnya')])[" + index + "]");
        playwright.forceClickOn(clickSelengkapnyaContract);
    }

    /**
     * get disclaimer tenant hasn't
     * checkin text
     */
    public String getDisclaimerText() {
        return playwright.getText(disclaimerCheckinTenant);
    }
    /**
     * click filter dropdown
     */
    public void clickOnFilterDropdown() {
        playwright.clickOn(filterDropdown);
    }

    /**
     * select filter status booking
     */
    public TenantBillManagementPO fillFilterStatusBooking(String filter) {
        Locator filterStatusBooking = page.locator("a").filter(new Locator.FilterOptions().setHasText(filter));
        playwright.clickOn(filterStatusBooking);
        return new TenantBillManagementPO(page);
    }

    /**
     * click download biodata penyewa button
     */
    public void clickDownloadBiodataPenyewa() {
        playwright.clickOn(downloadBiodataPenyewaButton);
    }

    /**
     * click checkbox
     */
    public void tickCheckbox() {
        playwright.clickOn(checkbox);
    }

    /**
     * check upcoming feature
     */
    public boolean isUpcomingFeatureDisplayed() {
        playwright.waitFor(informationAboutUpcomingFeature);
        return playwright.isTextDisplayed("Kami akan memberitahu Anda saat fitur ini sudah tersedia.");
    }

    /**
     * Click arrow next month filter button
     */
    public void clickArrowNextMonthFilterButton() {
        playwright.clickOn(arrowNextMonthFilterButton);
    }
    /**
     * check upcoming feature
     */
    public String userWillSeeMessageTerminatedContract() {
        return playwright.getText(page.getByTestId("contractTerminateConfirmation").getByRole(AriaRole.PARAGRAPH));
    }

    /**
     * check help center page
     */
    public boolean userCanSeeHelpCenterPage() {
        return playwright.isTextDisplayed("Pusat Bantuan");
    }

    /**
     * user as owner click kost dropdown
     * user enter kost name
     * user choose kost name
     */
    public void searchKostInBillingManagement(String kostName) {
        playwright.waitTillPageLoaded();
        playwright.clickOn(kostDropdownInBillingManagement);
        playwright.hardWait(500.0);
        Locator selectKost = page.locator("//label[contains(.,'"+kostName+"')]");
        playwright.clickOn(selectKost);
        // If property was already selected, clicking it won't close the modal
        // Force close modal by clicking close icon to handle both cases
        playwright.hardWait(1000.0);
        if (playwright.waitTillLocatorIsVisible(billingManagementModalCloseIcon, 2000.0)) {
            playwright.clickOn(billingManagementModalCloseIcon);
        }
        playwright.waitTillPageLoaded();
    }

    /**
     * user click on disbursement link
     */
    public void userClickOnDIsbursementLink() {
        playwright.waitTillLocatorIsVisible(disbursementLink, 10000.0);
        playwright.clickOn(disbursementLink);
    }
    /**
     * Get text financial report
     *
     * @return string data type "title and content"
     */
    public String getTextFinancialReport(String titleText, String contentText) {
        Locator getTextTitle = page.locator("//p[contains(text(),'"+ titleText + "')]");
        Locator getTextContent = page.locator("//p[contains(text(),'"+ contentText + "')]");
        return playwright.getText(getTextTitle) + playwright.getText(getTextContent);
    }

    /**
     * click Lihat status tagihan on detail penyewa
     */
    public void clickLihatStatusTagihan(){
        playwright.clickOn(lihatStatusTagihanBtn);
    }

    /**
     * verify status tagihan text
     * @param text
     * @return text
     */
    public String getTextStatusTagihan(String text){
        Locator getStatusTagihan = page.getByText(" "+ text +" ");
        return playwright.getText(getStatusTagihan);
    }

    /**
     * click Kirim ulang kode hyperlink
     */
    public void clickKirimUlangKode() {
        playwright.waitTillLocatorIsVisible(krmUlangKodeBtn);
        playwright.clickOn(krmUlangKodeBtn);
        playwright.hardWait(2000);
    }

    /**
     * see Kirim kode unik ke penyewa page
     * @return true or false
     */
    public boolean isKrmKodeUnikPageDisplayed(){
        return playwright.waitTillLocatorIsVisible(krmKodeUnikPage);
    }


    /**
     * click Ubah nomor HP hyperlink
     */
    public void clickUbahNmrHp() {
        playwright.clickOn(ubahNmrHpBtn);
    }

    /**
     * click phone number field
     * and change into the new number
     */
    public void clickPhoneNmbField(String ubhPhoneNumber) {
        playwright.fill(phoneNumberField, ubhPhoneNumber);
        playwright.clickOn(gunakanBtn);
    }

    /**
     * get wording of warning tenant who don't have kos saya at Semua filter
     * @return wording of warning at Semua filter
     */
    public boolean isWarningAtSemuaFltrDisplayed(){
        playwright.waitFor(dontHaveKosWarning);
        return playwright.waitTillLocatorIsVisible(dontHaveKosWarning);
    }
}
