package pageobject.admin.mamipay.bangkrupux;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.PlaywrightHelpers;
import java.util.Map;
import java.util.HashMap;

public class LogFacilityPO {
    private Page page;
    PlaywrightHelpers playwright;
    private static final Map<String, Integer> ROW_INDEX_MAP = new HashMap<>();

    static {
        ROW_INDEX_MAP.put("Fasilitas Umum", 0);
        ROW_INDEX_MAP.put("Fasilitas Kamar", 1);
        ROW_INDEX_MAP.put("Fasilitas Parkir", 2);
        ROW_INDEX_MAP.put("Fasilitas Kamar Mandi", 3);
    }

    public LogFacilityPO(Page page){
        this.page = page;
        playwright = new PlaywrightHelpers(page);
    }

    private String getColumnData(String row, int columnNumber) {
        Integer rowIndex = ROW_INDEX_MAP.get(row);
        if (rowIndex == null) {
            throw new IllegalArgumentException("Invalid row: " + row);
        }
        Locator columnLocator = page.locator("tr td:nth-of-type(" + columnNumber + ")").nth(rowIndex);
        return playwright.getText(columnLocator);
    }

    /**
     * get Old Data
     * @param row
     * @return String
     */
    public String getOldData(String row) {
        return getColumnData(row, 4);
    }

    /**
     * get New Data
     * @param row
     * @return
     */
    public String getNewData(String row) {
        return getColumnData(row, 5);
    }

    /**
     * get Update By
     * @param row
     * @return
     */
    public String updateBy(String row) {
        return getColumnData(row, 6);
    }
}
