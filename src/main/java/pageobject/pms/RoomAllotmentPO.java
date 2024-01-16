package pageobject.pms;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class RoomAllotmentPO {
    private Page page;
    private PlaywrightHelpers playwright;

    Locator createOutOfOrderStatusBtn;
    Locator outOfOrderFlag;
    // ----------- Create/edit Out of order modal -----------
    Locator outOfOrderTypeDropdown;
    Locator outOfOrderType;
    Locator noteOutOfOrderInputText;
    Locator startDate;
    Locator endDate;
    Locator todayDate;
    Locator yesterday;
    Locator tomorrow;
    Locator saveBtn;
    // ----------- Out of order details modal -----------
    Locator actionOnModal;
    Locator editOutOfOrder;
    Locator deleteOutOfOrder;
    Locator confirmDelete;
    // ----------- Search on room allotment page -----------
    Locator searchDropdownPropertyName;
    Locator searchInputPropertyName;
    Locator firstSugestionPropertyName;
    // ----------- Out of order can not mark modal -----------
    Locator titlePopupCanNotMark;
    Locator subtitlePopupCanNotMark;

    public RoomAllotmentPO(Page page){
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        createOutOfOrderStatusBtn = page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("Buat status Out of Order"));
        outOfOrderTypeDropdown = page.getByTestId("outOfOrderCategory_ddl").first();
        noteOutOfOrderInputText = page.locator("#outOfOrderNote_txt");
        startDate = page.locator("#outOfOrderDate-datePickerStart");
        endDate = page.locator("#outOfOrderDate-datePickerEnd");
        todayDate = page.locator("//span[contains(@class,'today')]");
        yesterday = page.locator("//span[contains(@class,'today')]/../preceding-sibling::div[1]");
        tomorrow = page.locator("//span[contains(@class,'today')]/../following-sibling::div[1]");
        actionOnModal = page.locator("svg", new Page.LocatorOptions().setHasText("more-vertical"));
        editOutOfOrder = page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("Edit"));
        deleteOutOfOrder = page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("Delete"));
        confirmDelete = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lanjut hapus"));
        saveBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Simpan"));
        searchDropdownPropertyName = page.locator("//div[@class=\"bg-c-select__trigger bg-c-select__trigger--md\"]");
        searchInputPropertyName = page.getByPlaceholder("Search");
        titlePopupCanNotMark = page.locator(".bg-c-modal__body-title");
        subtitlePopupCanNotMark = page.locator(".bg-c-modal__body-description");
    }

    /**
     * Click on room number and click "buat status out of order"
     * @param number refer to room name (ex: 1 or A10)
     */
    public void setRoomOutOfOrder(String number) {
        playwright.waitTillPageLoaded();
        Locator roomNumber = page.locator("//span[@class='cv-sidebar__room-number' and text()=' "+ number +" ']");
        playwright.clickOn(roomNumber);
        playwright.clickOn(createOutOfOrderStatusBtn);
    }

    /**
     * Click and choose out of order type
     * @param type refers to type of out of order (ex: Renovasi)
     */
    public void setOutOfOrderType(String type) {
        outOfOrderType = page.locator("a").filter(new Locator.FilterOptions().setHasText(type));
        outOfOrderTypeDropdown.click();
        outOfOrderType.click();
    }

    /**
     * Click start date on date picker
     * @param day refers to today, yesterday, tomorrow or even date
     */
    public void setOutOfOrderStartDate(String day) {
        startDate.click();
        if (day.equalsIgnoreCase("today")) {
            todayDate.first().click();
        } else if (day.equalsIgnoreCase("yesterday")) {
            yesterday.first().click();
        } else if (day.equalsIgnoreCase("tomorrow")) {
            tomorrow.first().click();
        } else {
            Locator date = page.locator("//*[not(contains(@class,'muted')) and contains(@class,'cell day') and normalize-space(text()) = '" + day + "']").first();
            date.click();
        }
    }

    /**
     * Click end date on date picker
     * @param day refers to today, yesterday, tomorrow or even date
     */
    public void setOutOfOrderEndDate(String day) {
        endDate.click();
        if (day.equalsIgnoreCase("today")) {
            todayDate.last().click();
        } else if (day.equalsIgnoreCase("yesterday")) {
            yesterday.last().click();
        } else if (day.equalsIgnoreCase("tomorrow")) {
            tomorrow.last().click();
        } else {
            Locator date = page.locator("//*[not(contains(@class,'muted')) and contains(@class,'cell day') and normalize-space(text()) = '" + day + "']").last();
            date.click();
        }
    }

    /**
     * Click on ooo flag in calendar view
     * @param room refers to room number (must be integer)
     * @param startDate refers to the start date of ooo
     */
    public void clickOutOfOrderFlag(String room, String startDate) {
        playwright.waitFor(outOfOrderFlag);
        int r = Integer.parseInt(room)+1;
        outOfOrderFlag = page.locator(".cv-daily__group-by-tipe-wrapper > div:nth-child(" + r + ") > div:nth-child(" + startDate + ")");
        playwright.clickOn(outOfOrderFlag);
    }

    /**
     * Click on action button in ooo modal
     */
    public void clickActionOnModal() {
        playwright.clickOn(actionOnModal);
    }

    /**
     * Click on edit in ooo modal
     */
    public void editOutOfOrder() {
        playwright.clickOn(editOutOfOrder);
    }

    /**
     * Click on delete in ooo modal
     */
    public void deleteOutOfOrder() {
        playwright.clickOn(deleteOutOfOrder);
    }

    /**
     * Click on Lanjut hapus in confirmation modal
     */
    public void confirmDeleteOutOfOrder() {
        playwright.clickOn(confirmDelete);
        playwright.hardWait(3000);
    }

    /**
     * Click on save button when creating ooo
     */
    public void clickSaveBtn() {
        playwright.clickOn(saveBtn);
        playwright.hardWait(3000);
    }

    /**
     * Search and click the first property
     * name on suggestion list in room allotment
     * @param kostName refers to property name
     */
    public void searchPropertyName(String kostName) {
        firstSugestionPropertyName = page.locator("//div[@class='bg-c-dropdown__menu-item-content']").getByText(kostName);
        searchDropdownPropertyName.click();
        searchInputPropertyName.fill(kostName);
        firstSugestionPropertyName.click();
    }

    /**
     * Check is the ooo in the room is visible on
     * the spesific date
     * @param room refers to room number (must be int)
     * @param startDate refers to the start date of ooo
     * @return boolean
     */
    public boolean isOutOfOrderOnRoomVisible(String room, String startDate) {
        playwright.waitTillPageLoaded();
        int r = Integer.parseInt(room)+1;
        outOfOrderFlag = page.locator(".cv-daily__day-allotment:nth-of-type(" + r + ") > " +
                                              ".cv-daily__day--occupied:nth-of-type(" + startDate + ") > .tenant-label");
        return playwright.isLocatorVisibleAfterLoad(outOfOrderFlag,2000.0);
    }

    /**
     * Click and fill note for out of order
     * @param note refers to text that wanna fill to
     */
    public void fillNoteOutOfOrder(String note) {
        noteOutOfOrderInputText.fill(note);
    }

    /**
     * Check is the save button on out of order is or not
     * @return boolean, true if enable
     */
    public boolean isSaveButtonEnable() {
        return saveBtn.isEnabled();
    }

    /**
     * check is the date on date picker disable or not
     * @param day refers to date
     */
    public void isSpesificEndDateDisable(int day) {
        playwright.clickOn(endDate);
        Locator date = page.locator("//*[not(contains(@class,'muted')) and contains(@class,'cell day') and normalize-space(text()) = '" + day + "']").last();
        playwright.isButtonDisable(date);
    }

    /**
     * get title text of title popup when can not mark ooo
     * @return String text
     */
    public String getTitlePopup() {
        return playwright.getText(titlePopupCanNotMark);
    }

    /**
     * get subtitle text of title popup when can not mark ooo
     * @return String text
     */
    public String getSubtitlePopup() {
        return playwright.getText(subtitlePopupCanNotMark);
    }
}
