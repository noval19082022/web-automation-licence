package pageobject.pms;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class ContractManagementPO {
    private Page page;
    private PlaywrightHelpers playwright;
    
    // Contract Management
    Locator contractAllotmentLabel;
    Locator contractDetailButton;
    Locator ubahButton;
    Locator penyewaSection;
    Locator tenantNamelabel;
    Locator notFoundtext;
    Locator updatedText;
    Locator lampiranText;
    Locator previouseButton;
    Locator riwayatDataPenyewaButton;
    
    // Tenant Information Form
    Locator inputNameField;
    Locator cameraButton;
    Locator simpanButton;
    Locator confirmYaUbahButton;
    
    // Validation Messages
    Locator nameValidationError;
    
    // Filter Elements
    Locator filterDropdown;
    Locator filterOption;
    Locator searchButton;

    public ContractManagementPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);

        contractDetailButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lihat detail kontrak chevron-"));
        penyewaSection = page.locator("//p[contains(text(),'Penyewa')]");
        lampiranText = page.locator("//*[@data-testid=\"bg-image\"]");
        previouseButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("chevron-left"));
    }

    /**
     * Check if Penyewa section will visible or not
     * @return penyewa text
     */
    public boolean penyewaSectionIsVisible(){
        return playwright.waitTillLocatorIsVisible(penyewaSection);
    }

    /**
     * Click on contract allotment label
     */
    public void clickContractAllotmentLabel(String tenantName) {
        tenantNamelabel = page.locator("//*[@data-testid=\"contractAllotmentLabel\"]//p[contains(text(),'"+tenantName+"')]");
        playwright.clickOn(tenantNamelabel);
    }

    /**
     * Click on view contract detail button
     */
    public void clickViewContractDetail() {
        playwright.clickOn(contractDetailButton);
    }

    /**
     * Click on edit (Ubah) button
     */
    public void clickEditButton(String text) {
        ubahButton = page.locator("//span[contains(text(),'"+text+"')]");
        playwright.clickOn(ubahButton);
    }

    /**
     * click previous button
     * @return
     */
    public void clickPreviousButton(){
        playwright.clickOn(previouseButton);
    }

    public boolean isUbahButtonDisable(){
        ubahButton = page.locator("//span[contains(text(),'Ubah')]");
        return ubahButton.isDisabled();
    }

    /**
     * get text not found
     * @param text
     * @return text
     */
    public String getNotFoundText(String text){
        notFoundtext = page.locator("//p[contains(text(),'"+text+"')]");
        return playwright.getText(notFoundtext);
    }

    /**
     * get Update text
     * @param text
     * @return text
     */
    public String getUpdatedText(String text){
        updatedText = page.locator("//tbody[@class=\"bg-c-table__body\"]//p[contains(text(),'"+text+"')]").first();
        return playwright.getText(updatedText);
    }

    /**
     * Click on Lampiran Image on Riwayat page
     */
    public void clickLampiran(){
        playwright.clickOn(lampiranText);
    }

    /**
     * Check if lampiran opened in new tab
     * @return true if new tab is opened with lampiran content
     */
    public boolean isLampiranOpenedInNewTab() {
        try {
            // Wait for new tab to open and switch context
            playwright.hardWait(2000); // Wait for tab to load

            // Check if we have more than one page/tab open
            int tabCount = page.context().pages().size();
            if (tabCount > 1) {
                // Get the latest tab (newly opened)
                Page newTab = page.context().pages().get(tabCount - 1);

                // Check if the new tab contains image or attachment related content
                String currentUrl = newTab.url();

                // Validate that new tab contains attachment/image content
                return currentUrl.contains("blob:") ||
                        currentUrl.contains("attachment") ||
                        currentUrl.contains("image") ||
                        currentUrl.contains("file") ||
                        newTab.locator("img").count() > 0;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Click Riwayat Perubhaan Data Penyewa Button
     * @param text
     */
    public void clickRiwayatPerubahanDataPenyewaButton(String text) {
        riwayatDataPenyewaButton = page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName(text));
        playwright.clickOn(riwayatDataPenyewaButton);
    }
}