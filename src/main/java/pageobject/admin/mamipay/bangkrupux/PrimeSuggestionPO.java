package pageobject.admin.mamipay.bangkrupux;

import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
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


    public PrimeSuggestionPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);

        addKosButton = page.locator("//a[@class='btn btn-primary btn-sm']");
        inputKosName = page.locator("//input[@placeholder='Keyword']");
        searchButton = page.locator("//button[normalize-space()='Search']");
        selectButton = page.locator("//a[normalize-space()='Select']");
        previewButton = page.locator("//button[normalize-space()='Preview']");
        createButton = page.locator("//button[normalize-space()='Create']");
        editPrimeSuggestion = page.locator("//a[@class=\"btn btn-default btn-sm\"]/following::a[@class=\"btn btn-default btn-xs\"][2]");
        savePrimeSuggestion = page.locator("//button[normalize-space()='Save']");
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
}
