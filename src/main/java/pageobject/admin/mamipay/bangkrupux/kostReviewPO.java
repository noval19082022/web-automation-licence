package pageobject.admin.mamipay.bangkrupux;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.JavaHelpers;
import utilities.PlaywrightHelpers;

import java.text.ParseException;
import java.util.List;

public class kostReviewPO {
    Page page;
    PlaywrightHelpers playwright;
    private JavaHelpers java = new JavaHelpers();
    Locator kostReviewMenu;
    Locator createReviewButton;
    Locator anonymousDropdown;
    Locator reviewTypeDropdown;
    Locator OTADropdown;
    Locator tenantNameField;
    Locator tenantPhoneNumberField;
    Locator kostNameField;
    Locator kebersihanDropdown;
    Locator kenyamananDropdown;
    Locator fasilitasKamarDropdown;
    Locator keamananDropdown;
    Locator fasilitasUmumDropdown;
    Locator kesesuiaianHargaDropdown;
    Locator tulisReviewField;
    Locator saveReviewButton;
    Locator startDateInput;
    Locator endDateInput;
    Locator nextDateButton;
    Locator searchKostNameButton;
    Locator contentLists;
    Locator editButton;
    Locator nextPage;
    Locator liveButton;
    Locator rejectButton;
    Locator deleteReviewButton;
    Locator contractIdDropdown;
    Locator cancelReviewButton;
    Locator rejectReviewKosButton;
    Locator inputKosName;
    Locator searchButton;

    public kostReviewPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        kostReviewMenu = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Kost Review"));
        createReviewButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Create Review"));
        anonymousDropdown = page.locator("#inputAnonymous");
        reviewTypeDropdown = page.locator("#selectReviewType");
        OTADropdown = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Select Review Type"));
        tenantNameField = page.getByPlaceholder("Tenant Name");
        tenantPhoneNumberField = page.getByPlaceholder("Tenant Phone Number");
        kostNameField = page.getByPlaceholder("Kost Name");
        kebersihanDropdown = page.locator("select[name=\"clean\"]");
        kenyamananDropdown = page.locator("select[name=\"happy\"]");
        fasilitasKamarDropdown = page.locator("select[name=\"room_facilities\"]");
        keamananDropdown = page.locator("select[name=\"safe\"]");
        fasilitasUmumDropdown = page.locator("select[name=\"public_facilities\"]");
        kesesuiaianHargaDropdown = page.locator("select[name=\"pricing\"]");
        tulisReviewField = page.getByPlaceholder("Tulis review kos disini");
        saveReviewButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save"));
        startDateInput = page.getByPlaceholder("Start Date");
        endDateInput = page.getByPlaceholder("End Date");
        nextDateButton = page.locator("a[data-handler='next']");
        searchKostNameButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(""));
        contentLists = page.locator("//tr//td[5]");
        editButton = page.locator("//a[@class='btn btn-xs btn-default']");
        nextPage = page.locator("//a[@rel='next']");
        liveButton = page.locator("//a[@class='btn btn-xs btn-success']");
        rejectButton = page.locator("//a[@onclick=\"return preventDoubleEvent(this);\"][@class=\"btn btn-xs btn-danger\"]");
        deleteReviewButton = page.locator("//a[@onclick=\"return confirm('Yakin mau hapus saya?')\"]");
        contractIdDropdown = page.getByPlaceholder("Contract ID");
        cancelReviewButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cancel"));
        rejectReviewKosButton = page.locator("(//a[@class='btn btn-xs btn-danger'])[1]");
        inputKosName = page.getByPlaceholder("Nama kos");
        searchButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Search"));
    }

    /**
     * Go to mamikos kost review
     *
     * @return kostReviewPO class
     */
    public kostReviewPO goToKostReviewMenu() {
        playwright.clickOn(kostReviewMenu);
        return new kostReviewPO(page);
    }

    /**
     * admin click on create review button
     *
     */
    public void clickOnCreateReviewButton() {
        playwright.clickOn(createReviewButton);
    }

    /**
     * admin click on cancel review button
     *
     */
    public void clickOnCancelReviewButton() {
        playwright.clickOn(cancelReviewButton);
    }

    /**
     * Fill anonymous status dropdown
     *
     * @param anonymous input string that will match input value
     */
    public void fillOnAnonymous(String anonymous) {
        playwright.selectDropdownByValue(anonymousDropdown, anonymous);
    }

    /**
     * Fill review type dropdown
     *
     * @param reviewType input string that will match input value
     */
    public void fillOnReviewType(String reviewType) {
        playwright.selectDropdownByValue(reviewTypeDropdown, reviewType);
    }

    /**
     * Fill review type dropdown
     *
     * @param contractId input string that will match input value
     */
    public void fillOnContractId(String contractId) {
        playwright.forceFill(contractIdDropdown, contractId);
        playwright.clickOn(searchKostNameButton);
    }

    /**
     * Fill ota rate dropdown
     *
     * @param ota input string that will match input value
     */
    public void fillOnOTA (String ota) {
       playwright.selectDropdownByValue(OTADropdown, ota);
    }


    /**
     * Fill clean rate dropdown
     *
     * @param clean input string that will match input value
     */
    public void fillOnKebersihan(String clean) {
        playwright.selectDropdownByValue(kebersihanDropdown, clean);
    }

    /**
     * Fill kenyamanan rate dropdown
     *
     * @param happy input string that will match input value
     */
    public void fillOnKenyamanan(String happy) {
        playwright.selectDropdownByValue(kenyamananDropdown, happy);
    }

    /**
     * Fill Room Facilities rate dropdown
     *
     * @param roomFacilities input string that will match input value
     */
    public void fillOnFasilitasKamar(String roomFacilities) {
        playwright.selectDropdownByValue(fasilitasKamarDropdown, roomFacilities);
    }

    /**
     * Fill security rate dropdown
     *
     * @param security input string that will match input value
     */
    public void fillOnKeamanan(String security) {
        playwright.selectDropdownByValue(keamananDropdown, security);
    }

    /**
     * Fill public facilities rate dropdown
     *
     * @param publicFacilities input string that will match input value
     */
    public void fillOnFasilitasUmum(String publicFacilities) {
        playwright.selectDropdownByValue(fasilitasUmumDropdown, publicFacilities);
    }

    /**
     * Fill price rate dropdown
     *
     * @param price input string that will match input value
     */
    public void fillOnKesesuaianHarga(String price) {
        playwright.selectDropdownByValue(kesesuiaianHargaDropdown, price);
    }

    /**
     * Fill tenant name
     *
     * @param tenantName input string that will match input value
     */
    public void fillOnTenantNameField(String tenantName) {
        playwright.forceFill(tenantNameField, tenantName);
    }

    /**
     * Fill tenant phone number
     *
     * @param tenantNumber input string that will match input value
     */
    public void fillOnTenantNumberField(String tenantNumber) {
        playwright.forceFill(tenantPhoneNumberField, tenantNumber);
    }

    /**
     * Fill kost name
     *
     * @param kostName input string that will match input value
     */
    public void fillOnKostNameField(String kostName) {
        playwright.forceFill(kostNameField, kostName);
        playwright.clickOn(searchKostNameButton);
        playwright.hardWait(1000);
    }

    /**
     * Fill review Field
     *
     * @param reviewField input string that will match input value
     */
    public void fillOnReviewField(String reviewField) {
        playwright.forceFill(tulisReviewField, reviewField);
    }


    /**
     * admin click on save review button
     *
     */
    public void clickOnSaveReviewButton() {
        playwright.clickOn(saveReviewButton);
    }

    /**
     * Fill start date directly to start date input form
     * @param startDate String type target date
     */
    public void fillStartDate(String startDate){
        playwright.clickOn(startDateInput);
        playwright.clickOn(page.locator("//a[text()='"+startDate+"']"));
    }

    /**
     * Fill end date directly to start date input form
     * @param endDate String type target date
     */
    public void fillEndDate(String endDate) {
        playwright.clickOn(endDateInput);
        playwright.clickOn(page.locator("//a[text()='"+endDate+"']"))  ;
    }

    /**
     * admin click on reject review kost button
     *
     */
    public void clickOnRejectReviewKos() {
        if (rejectReviewKosButton.isVisible()) {
            playwright.clickOn(rejectReviewKosButton);
            playwright.acceptDialog(rejectReviewKosButton);
        } else {
            playwright.clickOn(searchButton);
        }
    }

    /**
     * admin input kos name in kos review page
     *
     */
    public void inputKostName(String kosName) {
        inputKosName.fill(kosName);
        playwright.clickOn(searchButton);
    }

    /**
     * Input kost review  start date based on current date, tommorrow, or desired date number
     * @param startDate input with tomorrow, today, or dateNumber
     * @throws ParseException
     * @throws InterruptedException
     */
    public void chooseFormStartDate(String startDate) throws ParseException, InterruptedException {
        String day;
        if (startDate.equalsIgnoreCase("today")) {
            day = java.updateTime("yyyy MMM dd", java.getTimeStamp("yyy MMM dd"), "d", 0, 0, 0, 0);
        }
        else if (startDate.equalsIgnoreCase("tomorrow")) {
            day = java.updateTime("yyyy MMM dd", java.getTimeStamp("yyy MMM dd"), "d", 1, 0, 0, 0);
        }
        else {
            day = startDate;
        }
        String dateElement = "//a[text()='"+day+"']";
        String date = java.getTimeStamp("YYYY/MM");

        playwright.clickOn(startDateInput);
        page.click("xpath=" + dateElement);
        if (endDateInput.isVisible()){
            playwright.clickOn(endDateInput);
        }
    }

    /**
     * Input kost review start date based on current date, tommorrow, or desired date number
     * @param endDate input with tomorrow, today, or dateNumber
     * @throws ParseException
     * @throws InterruptedException
     */
    public void chooseFormEndtDate(String endDate) throws ParseException, InterruptedException {
        String day;
        if (endDate.equalsIgnoreCase("today")) {
            day = java.updateTime("yyyy MMM dd", java.getTimeStamp("yyy MMM dd"), "d", 0, 0, 0, 0);
        }
        else if (endDate.equalsIgnoreCase("tomorrow")) {
            day = java.updateTime("yyyy MMM dd", java.getTimeStamp("yyy MMM dd"), "d", 1, 0, 0, 0);
        }
        else {
            day = endDate;
        }
        String dateElement = "//a[text()='"+day+"']";
        String date = java.getTimeStamp("YYYY/MM");

        playwright.clickOn(endDateInput);
        page.click("xpath=" + dateElement);
        }

    /**
     * Click on Edit Kost Review Button
     * @throws InterruptedException
     */
    public void clickOnEditButton(String content) throws InterruptedException {
        playwright.hardWait(3000.0);
        
        List<Locator> edit = playwright.getLocators(editButton);
        List<Locator> contentList = playwright.getLocators(contentLists);
        
        for (int i = 0; i < contentList.size(); i++) {
            if (playwright.getText(contentList.get(i)).equalsIgnoreCase(content)) {
                playwright.clickOn(edit.get(i));
                return;
            } else if (i == contentList.size() - 1 && nextPage.count() > 0 && nextPage.isVisible()) {
                playwright.clickOn(nextPage);
                playwright.hardWait(2000.0);
                clickOnEditButton(content);
                return;
            }
        }
    }

    /**
     * Click on Live Button
     * @throws InterruptedException
     */
    public void clickOnLiveButton(String content) throws InterruptedException {
        playwright.hardWait(3000.0);
        
        List<Locator> live = playwright.getLocators(liveButton);
        List<Locator> contentList = playwright.getLocators(contentLists);
        
        for (int i = 0; i < contentList.size(); i++) {
            if (playwright.getText(contentList.get(i)).equalsIgnoreCase(content)) {
                playwright.clickOn(live.get(i));
                return;
            } else if (i == contentList.size() - 1 && nextPage.count() > 0 && nextPage.isVisible()) {
                playwright.clickOn(nextPage);
                playwright.hardWait(2000.0);
                clickOnLiveButton(content);
                return;
            }
        }
    }

    /**
     * Click on Reject Button
     * @throws InterruptedException
     */
    public void clickOnRejectButton(String content) throws InterruptedException {
        playwright.hardWait(3000.0);
        
        List<Locator> reject = playwright.getLocators(rejectButton);
        List<Locator> contentList = playwright.getLocators(contentLists);
        
        for (int i = 0; i < contentList.size(); i++) {
            if (playwright.getText(contentList.get(i)).equalsIgnoreCase(content)) {
                playwright.clickOn(reject.get(i));
                return;
            } else if (i == contentList.size() - 1 && nextPage.count() > 0 && nextPage.isVisible()) {
                playwright.clickOn(nextPage);
                playwright.hardWait(2000.0);
                clickOnRejectButton(content);
                return;
            }
        }
    }

    /**
     * Click on Delete Review Button
     * @throws InterruptedException
     */
    public void clickOnDeleteReviewButton(String content) throws InterruptedException {
        playwright.hardWait(3000.0);
        
        List<Locator> delete = playwright.getLocators(deleteReviewButton);
        List<Locator> contentList = playwright.getLocators(contentLists);
        
        for (int i = 0; i < contentList.size(); i++) {
            if (playwright.getText(contentList.get(i)).equalsIgnoreCase(content)) {
                playwright.acceptDialog(delete.get(i));
                return;
            } else if (i == contentList.size() - 1 && nextPage.count() > 0 && nextPage.isVisible()) {
                playwright.clickOn(nextPage);
                playwright.hardWait(2000.0);
                clickOnDeleteReviewButton(content);
                return;
            }
        }
    }

}
