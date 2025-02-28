package pageobject.tenant.survei;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.PlaywrightHelpers;

public class customQuestionPO {
    private Page page;
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);

    Locator filterSurveiKos;
    Locator pengaturanSurveiKos;
    Locator tambahButton;
    Locator simpanPengaturan;
    Locator inputTextbox;
    Locator linkTextHapus;

    public customQuestionPO(Page page) {
        this.page = page;
        this.filterSurveiKos = page.locator("//span[@id='filter-survey-tenant']");
        this.pengaturanSurveiKos = page.locator("//div[@class='mc-channel-list__setting-card bg-c-card bg-c-card--lined bg-c-card--sm bg-c-card--light bg-c-card--clickable']");
        this.tambahButton = page.locator("//button[@class='bg-c-button bg-u-mt-md bg-c-button--secondary bg-c-button--sm']");
        this.simpanPengaturan = page.locator("//button[normalize-space()='Simpan Pengaturan']");
        this.inputTextbox = page.locator("//input[@placeholder='Masukkan di sini.']");
        this.linkTextHapus = page.getByText("Hapus");

    }

    /**
     * click on filter survei kos
     */
    public void userClickOnFilterSurveiKos() {
        playwright.clickOn(filterSurveiKos);
    }

    /**
     * click on pengaturan survei kos
     */
    public void userClickOnPengaturanSurveiKos() {
        playwright.clickOn(pengaturanSurveiKos);
    }

    /**
     * click on tambah button
     */
    public void userClickOnTambahButton() {
        if (linkTextHapus.count() >= 3) {
            linkTextHapus.nth(2).click();
            linkTextHapus.nth(1).click();
            linkTextHapus.nth(0).click();
        } else if (linkTextHapus.count() >= 2) {
            linkTextHapus.nth(1).click();
            linkTextHapus.nth(0).click();
        } else if (linkTextHapus.count() >= 1) {
            linkTextHapus.first().click();
        }
        playwright.clickOn(tambahButton);
    }

    /**
     * Fills questions
     *
     * @param text
     */
    public void userFillsQuestions(String text) {
        playwright.waitTillLocatorIsVisible(inputTextbox);
        playwright.fill(inputTextbox, text);
    }

    /**
     * click on simpan pengaturan
     */
    public void userClickOnSimpanPengaturan() {
        playwright.clickOn(simpanPengaturan);
    }

    /**
     * User see three questions
     */
    public boolean userSeeThreeQuestionsAppear(String value) {
        switch (value) {
            case "1":
                return page.getByText("Pertanyaan 1").isVisible();
            case "2":
                return page.getByText("Pertanyaan 1").isVisible() &&
                       page.getByText("Pertanyaan 2").isVisible();
            case "3":
                return page.getByText("Pertanyaan 1").isVisible() &&
                        page.getByText("Pertanyaan 2").isVisible() &&
                        page.getByText("Pertanyaan 3").isVisible();
        }
        return false;
    }

    /**
     * Click on tambah button > 1
     */
    public void userClickOnTambahButton3Times(Integer value) {
        int totalClick = value;
        clikTambahButton(tambahButton, totalClick);
    }
    private void clikTambahButton(Locator button, int totalClick) {
        for (int i = 0; i < totalClick; i++) {
            button.click();
        }
    }

    /**
     * click on linkText hapus no 1
     */
    public void userDeleteQuestions(String value) {
        if (linkTextHapus.count() >= 3) {
            linkTextHapus.nth(Integer.parseInt(value)).click();
        }
    }
}
