package pageobject.owner.fiturpromosi;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class BroadcastChatPO {
    private Page page;
    private PlaywrightHelpers playwright;
    Locator warningBroadcastText;
    Locator searchKostInputBC;
    Locator listSelectBroadcastKost;
    Locator firstBroadcastChatOption;
    Locator backButtonBC;
    Locator brodcastMessageField;
    Locator closeSearchBroadcastSearchIcon;
    Locator kostListBroadcastChat;
    Locator messageBroadcastText;
    Locator ubahTemplateBroadcastText;
    Locator broadcastMessageInput;
    Locator errorInputBroadcastText;
    Locator counterCharText;
    Locator previewBroadcastMessageText;
    Locator tooltipBroadcast;
    Locator tooltipClose;
    Locator broadcastChatIcon;
    Locator cancelGoldPlusButton;
    Locator backGoldplusbutton;
    Locator lihatPenerimaSection;
    private Locator andaBelumMemilikiKosActiveText;
    private Locator tambahKosButton;
    private Locator broadcastChatPackageContent;
    private Locator lihatDetailButton;
    private Locator ajukanGantiPaketButton;
    private Locator beliPaketButton;
    private Locator gpHeader;
    private Locator lihatRincianButton;
    private Locator bacaSelengkapnyaButton;
    private Locator tambahBroadcastChatButton;
    private Locator buatBroadcastChatButton;
    private Locator pilihKosButton;
    private Locator toastContentText;
    private Locator bantuanDanTipsButton;
    private Locator displayingSearchResultKosNameText;
    private Locator emptyKosHeaderText;
    private Locator emptyKosBodyText;
    private Locator masukkanPesanButton;
    private Locator pilihPesanButton;
    private Locator tidakJadiButtonPopUp;
    private Locator keluarButton;
    private Locator lihatInvoiceButton;
    private Locator ftueBroadcast;
    private Locator closeBtn;
    private Locator ubahHyperlink;

    public BroadcastChatPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        warningBroadcastText =page.locator(".bg-c-modal__body-title");
        searchKostInputBC = page.getByTestId("broadcastChat-searchBarKosList");
        listSelectBroadcastKost = page.locator(".disabled-card");
        firstBroadcastChatOption = page.locator(".broadcast-chat-message-card__message");
        backButtonBC = page.getByRole(AriaRole.IMG).filter(new Locator.FilterOptions().setHasText("back"));
        brodcastMessageField = page.locator(".bg-c-textarea__field");
        closeSearchBroadcastSearchIcon = page.getByRole(AriaRole.BUTTON).nth(3);
        kostListBroadcastChat = page.getByTestId("broadcastChat-listKos");
        messageBroadcastText = page.locator("//div[@class='broadcast-chat-detail__select-message__inner']//p");
        ubahTemplateBroadcastText = page.getByText("Ubah").nth(1);
        broadcastMessageInput = page.locator(".bg-c-textarea__field");
        errorInputBroadcastText = page.locator(".bg-c-field__message");
        counterCharText = page.locator(".bg-c-textarea__counter");
        previewBroadcastMessageText = page.locator("b:nth-of-type(2)");
        tooltipBroadcast = page.locator(".mc-channel-list__broadcast-tooltip-content");
        tooltipClose = page.locator(".bg-c-button--tertiary-naked-inversed");
        broadcastChatIcon = page.getByRole(AriaRole.BUTTON).filter(new Locator.FilterOptions().setHasText("broadcast-message"));
        cancelGoldPlusButton = page.locator("//a[@class='back-icon']");
        backGoldplusbutton = page.locator("//span[@class='goldplus-header__back-button']");
        lihatPenerimaSection = page.getByTestId("broadcastChat-sectionRecepientMessage");
        tambahKosButton = playwright.getButtonBySetName("Tambah Kos");
        andaBelumMemilikiKosActiveText = page.getByText("Anda belum memiliki kos aktif");
        broadcastChatPackageContent = page.getByTestId("broadcastChatDesktop");
        lihatDetailButton = playwright.getButtonBySetName("Lihat Detail");
        ajukanGantiPaketButton = playwright.getButtonBySetName("Ajukan Ganti Paket");
        beliPaketButton = playwright.getButtonBySetName("Beli Paket");
        gpHeader = page.locator("div.broadcast-chat-content__alert").getByRole(AriaRole.PARAGRAPH).first();
        lihatRincianButton = playwright.getButtonByText("Lihat Rincian");
        bacaSelengkapnyaButton = page.getByTestId("broadcastChatDesktop").locator("a");
        tambahBroadcastChatButton = playwright.getButtonBySetName("Tambah Broadcast Chat");
        buatBroadcastChatButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Buat Broadcast Chat"));
        toastContentText = page.locator(".bg-c-toast__content");
        bantuanDanTipsButton = playwright.getButtonBySetName("Bantuan & Tips");
        displayingSearchResultKosNameText = page.getByTestId("broadcastChat-listKos").getByRole(AriaRole.PARAGRAPH).first();
        pilihKosButton = playwright.getButtonByText("Pilih Kos");
        emptyKosHeaderText = page.locator(".select-kos__not-found").getByRole(AriaRole.PARAGRAPH).first();
        emptyKosBodyText = page.locator(".select-kos__not-found").getByRole(AriaRole.PARAGRAPH).last();
        masukkanPesanButton = page.getByText("Masukan Pesan");
        pilihPesanButton = playwright.getButtonBySetName("Pilih Pesan");
        tidakJadiButtonPopUp = playwright.getButtonBySetName("Tidak Jadi");
        keluarButton = playwright.getButtonBySetName("Keluar");
        lihatInvoiceButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lihat Invoice"));
        ftueBroadcast = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Fitur baru GoldPlus: Broadcast Chat"));
        closeBtn = page.getByTestId("close-button");
        ubahHyperlink = page.getByText("ubah").first();
    }

    /**
     * Get warning broadcast
     *
     * @return Text of broadcast
     */
    public String getWarningBroadcastText() {
        playwright.waitTillLocatorIsVisible(warningBroadcastText,30000.0);
        return playwright.getText(warningBroadcastText);
    }

    /**
     * Wait till element Input Search Kost BC visible
     * Insert text to search kost BroadcastChat
     */
    public void searchKostBC(String text) {
        playwright.forceFill(searchKostInputBC, text);
    }

    /**
     * verify kost card is disable
     *
     */
    public boolean isKostCardDisabled() {
        return playwright.getAttributeValue(kostListBroadcastChat, "class").contains("disabled-card");
    }

    /**
     * click on icon close at search bar broadcast chat
     */
    public void clickOnCloseSearchBroadcastSearchIcon() {
        playwright.clickOn(closeSearchBroadcastSearchIcon);
        playwright.reloadPage();
        playwright.hardWait(1500.0);
    }

    /**
     * verify kost list at broadcast chat is show
     */
    public boolean isKosListDisplayed() {
        return playwright.waitTillLocatorIsVisible(playwright.getLocators(kostListBroadcastChat).get(0));
    }

    /**
     * click on button masukan pesan broadcast chat
     */
    public void selectMessageOptionBC(int messageOption) {
        playwright.clickOn(playwright.getLocators(firstBroadcastChatOption).get(messageOption-1));
    }

    /**
     * Get message BC after selected
     * @return error message after selected
     */
    public String getMessageBCselected() {
        return playwright.getText(messageBroadcastText).replaceAll("\\s", "");
    }

    /**
     * click on button ubah template message button
     */
    public void clickUbahTemplateBroadcastText() {
        playwright.clickOn(ubahTemplateBroadcastText);
    }

    /**
     * Wait till element Input Search Kost BC visible
     * Insert text to search kost BroadcastChat
     */
    public void inputBroadcastMessage(String text) {
        broadcastMessageInput.fill(text);
        playwright.clickOn(broadcastMessageInput);
        page.keyboard().press("Enter");
    }

    /**
     * verify textfield broadcast chat message is not displayed
     */
    public boolean isTextFieldBCMessageDisplayed() {
        return brodcastMessageField.isVisible();
    }

    /**
     * Get counter char text at input Broadcast message
     * @return counter wrong
     */
    public String getCountText() {
        return playwright.getText(counterCharText);
    }

    /**
     * Get error Input Template Broadcast Chat Template Message
     * @return error Input Template Broadcast Chat Template Message
     */
    public String getErrorInputBroadcastText() {
        playwright.waitTillLocatorIsVisible(errorInputBroadcastText);
        return playwright.getText(errorInputBroadcastText);
    }

    /**
     * Get Preview Message Broadcast Chat
     * @return Preview Message Broadcast Chat
     */
    public String getPreviewMessageBC() {
        return playwright.getText(previewBroadcastMessageText);
    }
    /**
     * click on back Button BC
     */
    public void clickOnBackButtonBC() {
        playwright.delayAndClickOn(backButtonBC, 3_000.0);
    }

    /**
     * click on icon broadcast chat at owner chat page
     */
    public void clickOnBroadcastChatIcon() {
        playwright.clickOn(broadcastChatIcon);
        playwright.hardWait(5000);
    }

    /**
     * Verify tooltip broadcast chat is present
     *
     * @return tooltip broadcast chat is present
     */
    public boolean isTooltipBroadcastDisplayed() {
        return playwright.waitTillLocatorIsVisible(tooltipBroadcast, 2000.0);
    }

    /**
     * click on close button tooltip
     */
    public void clickOnCloseTooltip() {
        playwright.clickOn(tooltipClose);
    }

    /**
     * click on gp cancel button and then back to kelola page
     */
    public void clickOnCancelGPbutton() {
        playwright.clickOn(cancelGoldPlusButton);
        playwright.waitTillLocatorIsVisible(backGoldplusbutton, 5000.0);
        playwright.clickOn(backGoldplusbutton);
    }

    /**
     * Verify tooltip broadcast chat is present
     *
     * @return tooltip broadcast chat is present
     */
    public boolean isLihatPenerimaPageDisplayed() {
        return playwright.waitTillLocatorIsVisible(lihatPenerimaSection, 2000.0);
    }

    /**
     * Click on tambah penerima button
     */
    public void clickOnTambahKosButton() {
        playwright.delayAndClickOn(tambahKosButton, 1500.0);
    }

    /**
     * Verify anda belum memiliki kos aktif text displayed
     * @return boolean visible true, otherwise false
     */
    public boolean isAndaBelumMemilikiKosAktifTextDisplayed() {
        return playwright.waitTillLocatorIsVisible(andaBelumMemilikiKosActiveText);
    }

    /**
     * Verify the visibility of tambahkan kos button
     * @return boolean visible true, otherwise false
     */
    public boolean isTambahKosButtonVisible() {
        return playwright.waitTillLocatorIsVisible(tambahKosButton);
    }

    /**
     * Verify the visibility of broadcast chat package content
     * @return boolean visible true, otherwise false
     */
    public boolean isBroadcastChatPackageContentVisible() {
        playwright.waitFor(broadcastChatPackageContent);
        return playwright.waitTillLocatorIsVisible(broadcastChatPackageContent);
    }

    /**
     * Verify the visibility of lihat detail button
     * @return boolean visible true, otherwise false
     */
    public boolean isLihatDetailButtonVisible() {
        playwright.waitFor(lihatDetailButton);
        return playwright.waitTillLocatorIsVisible(lihatDetailButton);
    }

    /**
     * Verify the visibility of ajukan ganti paket button
     * @return boolean visible true, otherwise false
     */
    public boolean isAjukanGantiPaketVisible() {
        playwright.waitFor(ajukanGantiPaketButton);
        return playwright.waitTillLocatorIsVisible(ajukanGantiPaketButton);
    }

    /**
     * Verify the visibility of beli paket button
     * @return boolean visible true, otherwise false
     */
    public boolean isBeliPaketButtonVisible() {
        return playwright.waitTillLocatorIsVisible(beliPaketButton);
    }

    /**
     * Get GP header text
     * @return String data type
     */
    public String getGpPackageHeader() {
        return playwright.getText(gpHeader);
    }

    /**
     * Click on lihat rincian button
     */
    public void clickOnLihatRincianButton() {
        playwright.waitFor(lihatRincianButton);
        playwright.clickOn(lihatRincianButton);
    }

    /**
     * Click on lihat selengkapnya button
     */
    public void clicksOnLihatSelengkapnyaButton() {
        playwright.waitFor(bacaSelengkapnyaButton);
        playwright.clickOn(bacaSelengkapnyaButton);
    }

    /**
     * Click on tambah broadcast chat button
     */
    public void clickOnTambahBroadcastChatButton() {
        if (!playwright.getActivePageURL().contains("kos")) {
            playwright.clickIfElementVisibleAfterLoad(tambahBroadcastChatButton, 5_000.0);
            playwright.clickIfElementVisible(buatBroadcastChatButton);
        }
    }

    /**
     * Click on tambah broadcast result kos name
     * @param kosName kost name
     */
    public void clickOnTambahBroadcastChatKostNameResult(String kosName) {
        Locator kosNameResult = page.getByTestId("broadcastChat-listKos").getByText(kosName);
        playwright.clickOn(kosNameResult);
    }

    /**
     * Click on pilih kos button
     */
    public void clicksOnPilihKosButton() {
        playwright.clickOn(pilihKosButton);
    }

    /**
     * Get toast text
     * @return String data type
     */
    public String getToastText() {
        return playwright.getText(toastContentText);
    }

    /**
     * Click on bantuan dan tips button
     */
    public Page clicksOnBantuanTipsButton() {
        return playwright.movePageByClickLocator(page, bantuanDanTipsButton);
    }

    /**
     * Get displaying search result kos name text
     * @return String data type
     */
    public String getDisplayingSearchResultKosNameText() {
        return playwright.getText(displayingSearchResultKosNameText);
    }

    /**
     * Get empty kos header text
     * @return String data type
     */
    public String getEmptyKosHeaderText() {
        return playwright.getText(emptyKosHeaderText);
    }

    /**
     * Get empty kos body text
     * @return String data type
     */
    public String getEmptyKosBodyText() {
        return playwright.getText(emptyKosBodyText);
    }

    /**
     * Click on masukkan pesan button
     */
    public void clicksOnMasukkanPesanButton() {
        playwright.clickOn(masukkanPesanButton);
    }

    /**
     * Click on pilih pesan button
     */
    public void clicksOnPilihPesanButton() {
        playwright.clickOn(pilihPesanButton);
    }

    /**
     * Click on tidak jadi button
     */
    public void clicksOnPilihTidakJadiButton() {
        playwright.clickOn(tidakJadiButtonPopUp);
    }

    /**
     * Click on keluar button
     */
    public void clicksOnKeluarButton() {
        playwright.clickOn(keluarButton);
    }

    /**
     * Get button detail text
     * @return String data type
     */
    public String getButtonDetailText() {
        return playwright.getText(lihatDetailButton);
    }

    /**
     * Get button submission text
     * @return String data type
     */
    public String getButtonSubmissionText() {
        playwright.waitFor(ajukanGantiPaketButton);
        return playwright.getText(ajukanGantiPaketButton);
    }

    /**
     * Click on lihat invoice button
     */
    public void clickOnLihatInvoiceButton() {
        playwright.clickOn(lihatInvoiceButton);
    }

    /**
     * dismiss FTUE broadcast
     */
    public void dismisFtuebroadcastIfExist() {
        playwright.clickIfElementVisibleAfterLoad(ftueBroadcast, closeBtn, 2_000.0);
    }

    /**
     * click on ubah in detail kost broadcast page
     */
    public void clickOnUbahKostBroadcast() {
        playwright.clickOn(ubahHyperlink);
    }
}
