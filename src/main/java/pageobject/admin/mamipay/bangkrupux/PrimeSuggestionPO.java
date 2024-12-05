package pageobject.admin.mamipay.bangkrupux;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import config.global.GlobalConfig;
import utilities.PlaywrightHelpers;

import java.nio.file.Paths;

public class PrimeSuggestionPO {
    private Page page;
    private PlaywrightHelpers playwright;

    Locator addKosButton;
    Locator inputKosName;
    Locator searchButton;
    Locator selectButton;
    Locator previewButton;
    Locator createButton;
    Locator editPrimeSuggestion;
    Locator savePrimeSuggestion;
    Locator showKeywordButton;
    Locator addKeywordButton;
    Locator addButton;
    Locator areaName;
    Locator searchBtn;
    Locator deleteButton;
    Locator dropdownAllStatus;


    public PrimeSuggestionPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);

        addKosButton = page.locator("//a[@class='btn btn-primary btn-sm']");
        inputKosName = page.locator("//input[@placeholder='Keyword']");
        searchButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Search"));
        selectButton = page.locator("//a[normalize-space()='Select']");
        previewButton = page.locator("//button[normalize-space()='Preview']");
        createButton = page.locator("//button[normalize-space()='Create']");
        editPrimeSuggestion = page.locator("//a[@class=\"btn btn-default btn-sm\"]/following::a[@class=\"btn btn-default btn-xs\"][2]");
        savePrimeSuggestion = page.locator("//button[normalize-space()='Save']");
        showKeywordButton = page.getByRole(AriaRole.ROW, new Page.GetByRoleOptions().setName("Kos XDR Rajeg Tangerang Rajeg Tangerang")).getByRole(AriaRole.LINK).first();
        addKeywordButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Add Keyword"));
        addButton = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("tangerang  Add")).getByRole(AriaRole.BUTTON);
        areaName = page.getByPlaceholder("Search Keyword");
        searchBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Search"));
        deleteButton = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("tangerang ")).getByRole(AriaRole.BUTTON);
        dropdownAllStatus = page.getByRole(AriaRole.COMBOBOX);
    }

    /**
     * input kost name
     */
    public void inputKosName(String text){
        playwright.clickLocatorAndTypeKeyboard(inputKosName, text);
    }

    /**
     * click on Add Kost button
     */
    public void clickOnAddKosButton(){
        playwright.clickOn(addKosButton);
    }

    /**
     * click on search button
     */
    public void clickOnSearchButton(){
        playwright.clickOn(searchButton);
    }

    /**
     * click on select button
     */
    public void clickOnSelectButton(){
        playwright.clickOn(selectButton);
    }

    /**
     * upload file csv
     */
    public void clickOnInputFileCsv(){
        Locator fileInput = page.locator("//input[@name='keyword_csv']");
        fileInput.setInputFiles(Paths.get("src/main/resources/file/samplePrimeSuggestion.csv"));
    }

    /**
     * choose status prime suggestion
     */
    public void chooseStatusPrime(String text){
        Locator statusPrime = page.locator("//label[normalize-space()='"+text+"']");
        playwright.clickOn(statusPrime);
    }

    /**
     * click on preview button
     */
    public void clickOnPreviewButton(){
        playwright.clickOn(previewButton);
    }

    /**
     * click on create button
     */
    public void clickOnCreateButton(){
        playwright.clickOn(createButton);
    }

    /**
     * click on edit button
     */
    public void clickOnEditPrimeSuggestion(){
        playwright.clickOn(editPrimeSuggestion);
    }

    /**
     * click on save button
     */
    public void clickOnSavePrimeSuggestion(){
        playwright.clickOn(savePrimeSuggestion);
    }

    /**
     * click on show keyword button
     */
    public void adminClickOnShowKeywordButton(){
        playwright.clickOn(showKeywordButton);
    }

    /**
     * click on add keyword button
     */
    public void adminClickOnAddKeywordButton(){
        playwright.clickOn(addKeywordButton);
    }

    /**
     * click on add keyword button
     */
    public void adminClickOnAddButton(){
        playwright.clickOn(addButton);
    }

    /**
     * Search area on search bar
     * @param area
     */
    public void searchArea(String area) {
        playwright.fill(areaName, area);
        playwright.clickOn(searchBtn);
    }

    /**
     * click on delete button
     */
    public void adminClickOnDelete(){
        playwright.clickOn(deleteButton);
    }

    /**
     * click on dropdown
     */
    public void adminClickOnDropdownAllStatus(){
        playwright.clickOn(dropdownAllStatus);
    }

    /**
     * select filter
     */
    public void adminClickOnfilter(String text){
        page.getByRole(AriaRole.COMBOBOX).selectOption(text);
    }

    /**
     * get status mamiprime
     */
    public boolean adminSeeListStatusMamiprime(String text){
        Locator getResultStatus = page.locator("(//label[@class='label status-inactive'][normalize-space()='"+text+"'])[1]");
        return playwright.waitTillLocatorIsVisible(getResultStatus, 3000.0);
    }
}
