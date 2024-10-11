package pageobject.admin.mamipay.bangkrupux;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class AgentAppPO {
    private Page page;
    PlaywrightHelpers playwright;

    //---Agent List Page---//
    private Locator agentAppMenu;
    private Locator agentsBtn;
    private Locator columnName;
    private Locator isActiveStatus;
    private Locator agentInTable;
    private Locator editBtn;
    private Locator agentNameText;
    private Locator nextPageButton;
    private Locator nextPageDisableButton;

    //---Edit Agent Page---//
    private Locator isActiveStatusInEdit;

    public AgentAppPO(Page page){
        this.page = page;
        playwright = new PlaywrightHelpers(page);

        //---Agent List Page---//
        agentAppMenu = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Agent App"));
        agentsBtn = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Agents").setExact(true));
        nextPageButton = page.locator("[rel='next']");
        nextPageDisableButton = page.locator(".page-item").last();
    }

    /**
     * Clicks Agent App menu
     */
    public void clicksAgentAppMenu() {
        playwright.clickOn(agentAppMenu);
        playwright.clickOn(agentsBtn);
    }

    /**
     * Get String Agent Column Table
     * @param columnAgent
     * @return String Agent Column Table
     */
    public String getAgentColumnTable(String columnAgent) {
        columnName = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(columnAgent).setExact(true));
        return playwright.getText(columnName);
    }

    /**
     * Check if Is Active Status in Table = Yes
     * True = Yes
     * False = No
     * @param isActive
     * @return Is Active Status
     */
    public boolean isActiveStatusInTableEqualYes(String agent, String isActive) {
        isActiveStatus = page.getByRole(AriaRole.ROW, new Page.GetByRoleOptions().setName(isActive).setName(agent)).locator("label");
        return playwright.isLocatorVisibleAfterLoad(isActiveStatus, 5000.0);
    }

    /**
     * Check if is Agent equal agent value
     * True = equal
     * False = not equal
     * @param agent
     * @return agent value
     */
    public boolean isAgentEqual(String agent) {
        agentInTable = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(agent));
        return playwright.isLocatorVisibleAfterLoad(agentInTable, 5000.0);
    }

    /**
     * Clicks Edit button
     * @param agent
     */
    public void clicksEdit(String agent) {
        editBtn = page.getByRole(AriaRole.ROW, new Page.GetByRoleOptions().setName(agent)).getByRole(AriaRole.LINK);
        playwright.clickOn(editBtn);
    }

    /**
     * Check if Is Active Status in Edit equal isActive value
     * True = not equal
     * False = equal
     * @param isActive
     * @return Is Active Status in Edit
     */
    public boolean isActiveStatusInEdit(String isActive) {
        isActiveStatusInEdit = page.locator("//select[@name='is_active']/option[@selected='true'][contains(., '" +isActive+ "')]");
        System.out.println(isActiveStatusInEdit.getAttribute(isActive));
        return playwright.isLocatorVisibleAfterLoad(isActiveStatusInEdit, 5000.0);
    }

    /**
     * Check is agent found in the list
     * @param agentName
     * @return boolean
     */
    public boolean isAgentFound(String agentName) {
        agentNameText = page.locator("(//tr)/td[4]").filter(new Locator.FilterOptions().setHasText(agentName));
        return playwright.isLocatorVisibleAfterLoad(agentNameText,5000.0);
    }

    /**
     * Click next page button in Agent list
     */
    public void clickNextPageAgent() {
        playwright.clickOn(nextPageButton);
    }

    /**
     * Check is pagination next button disable
     * @return boolean
     */
    public boolean isNextButtonDisabled() {
        boolean result = false;
        if (playwright.getAttributeValue(nextPageDisableButton,"class").contains("disabled")){
            result = true;
        }
        return result;
    }
}
