package pageobject.owner.goldplus;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

import java.util.List;

public class GoldPlusStatisticPO {
    private Page page;
    private PlaywrightHelpers playwright;
    Locator goldplusStatisticHeaderText;
    Locator gpStatisticPackageList;
    Locator activePackageListHeaderText;
    Locator activePackageListKostTitleText;
    Locator activePackageListKostAddressText;
    Locator activePackageListLihatDetailText;
    Locator activePackageListLihatDetailImageAltText;
    Locator activePackageList;
    Locator activePackageKostImage;

    public GoldPlusStatisticPO(Page page) {
        this.page = page;
        playwright = new PlaywrightHelpers(page);
        goldplusStatisticHeaderText = page.locator(".goldplus-header.goldplus-statistic__header");
        gpStatisticPackageList = page.locator("div.goldplus-statistic-room-list-filters__item");
        activePackageListHeaderText = page.locator("div.goldplus-room-card .goldplus-room-card__header");
        activePackageListKostTitleText = page.locator("div.goldplus-room-card .goldplus-room-card__room-title");
        activePackageListKostAddressText = page.locator("div.goldplus-room-card .goldplus-room-card__room-address");
        activePackageListLihatDetailText = page.locator("div.goldplus-room-card .goldplus-room-card__footer-link a");
        activePackageListLihatDetailImageAltText = page.locator("div.goldplus-room-card .goldplus-room-card__footer-link img");
        activePackageList = page.locator(".c-mk-card.goldplus-room-card");
        activePackageKostImage = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("Foto Kos"));
    }

    /**
     * Get goldplus statistic header text
     * @return String data type
     */
    public String getGoldplusStatisticHeaderText(){
        return playwright.getText(goldplusStatisticHeaderText);
    }

    /**
     * Get goldplus available package locator list
     * @return List<Locator> data type
     */
    public List<Locator> getGoldPlusAvailablePackageLocators() {
        return playwright.getLocators(gpStatisticPackageList);
    }

    /**
     * Get goldplus available package text
     * @param index input index of package
     * @return String data type
     */
    public String getGoldPlusAvailablePackageText(int index) {
        return playwright.getText(getGoldPlusAvailablePackageLocators().get(index - 1));
    }

    /**
     * Get goldplus active package list header text
     * @param index input index of package
     * @return String data type
     */
    public String getActivePackageListHeaderText(int index) {
        return playwright.getText(playwright.getLocators(activePackageListHeaderText).get(index));
    }

    /**
     * Get goldplus aktif package kost title text
     * @param index input index of package
     * @return String data type
     */
    public String getActivePackageListKostTitleText(int index) {
        return playwright.getText(playwright.getLocators(activePackageListKostTitleText).get(index));
    }

    /**
     * Get goldplus aktif package kost address text
     * @param index
     * @return
     */
    public String getActivePackageListKostAddressText(int index) {
        return playwright.getText(playwright.getLocators(activePackageListKostAddressText).get(index));
    }

    /**
     * Get goldplus aktif package lihat detail text
     * @param index
     * @return
     */
    public String getActivePackageListDetailText(int index) {
        return playwright.getText(playwright.getLocators(activePackageListLihatDetailText).get(index));
    }

    /**
     * Get goldplus aktif package lihat detail image alt text
     * @param index
     * @return
     */
    public String getActivePackageListImageAltText(int index) {
        return playwright.getAttributeValue(playwright.getLocators(activePackageListLihatDetailImageAltText).get(index), "alt");
    }

    /**
     * Get goldplus aktif package list locator
     * @return
     */
    public List<Locator> getActivePackageList() {
        return playwright.getLocators(activePackageList);
    }

    /**
     * Get goldplus aktif package image alt attribute from img html tag
     * @param index
     * @return
     */
    public String getActivePackageListKostImageAltText(int index) {
        return playwright.getAttributeValue(playwright.getLocators(activePackageKostImage).get(index), "alt");
    }
}
