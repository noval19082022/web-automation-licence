package pageobject.admin.mamipay.bangkrupux;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.PlaywrightHelpers;

public class LogFacilityPO {
    private Page page;
    PlaywrightHelpers playwright;

    public LogFacilityPO(Page page){
        this.page = page;
        playwright = new PlaywrightHelpers(page);
    }

    /**
     * Find the table row that contains the facility category name
     * Returns the first (most recent) matching row
     * @param facilityCategory The facility category name (e.g., "Fasilitas Umum")
     * @return Locator for the row containing the category
     */
    private Locator findRowByCategory(String facilityCategory) {
        // Find the first row that contains the facility category text (most recent log entry)
        return page.locator("tr").filter(new Locator.FilterOptions().setHasText(facilityCategory)).first();
    }

    /**
     * Get column data from a specific row by facility category
     * @param facilityCategory The facility category name
     * @param columnNumber The column number (1-based index)
     * @return String value of the column
     */
    private String getColumnData(String facilityCategory, int columnNumber) {
        Locator row = findRowByCategory(facilityCategory);
        Locator columnLocator = row.locator("td:nth-of-type(" + columnNumber + ")");
        return playwright.getText(columnLocator);
    }

    /**
     * Get Old Data from the facility log
     * @param facilityCategory The facility category name (e.g., "Fasilitas Umum")
     * @return String value of the Old Data column
     */
    public String getOldData(String facilityCategory) {
        return getColumnData(facilityCategory, 4);
    }

    /**
     * Get New Data from the facility log
     * @param facilityCategory The facility category name (e.g., "Fasilitas Umum")
     * @return String value of the New Data column
     */
    public String getNewData(String facilityCategory) {
        return getColumnData(facilityCategory, 5);
    }

    /**
     * Get Updated By information from the facility log
     * @param facilityCategory The facility category name (e.g., "Fasilitas Umum")
     * @return String value of the Updated By column
     */
    public String updateBy(String facilityCategory) {
        return getColumnData(facilityCategory, 6);
    }
}
