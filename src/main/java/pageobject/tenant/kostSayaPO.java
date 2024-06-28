package pageobject.tenant;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;

public class kostSayaPO {
    Page page;
    PlaywrightHelpers playwright;
    LocatorHelpers locator;
    String date;
    Locator inputCodeFromOwner;
    Locator sendButton;
    Locator verificationTittle;
    Locator tenantPhoneNum1Tittle;
    Locator tenantPhoneNum2Tittle;
    Locator alertVerifTittle;
    Locator otpWordingTittle;
    Locator kostSayaStillEmptyTittle;
    Locator sendOtpButton;
    Locator verificationViaSms;
    Locator yaBatalkanButton;
    Locator lihatInformasiKosButton;
    Locator informasiKostText;
    Locator kostNametext;
    Locator lihatSemuaFasilitasButton;
    Locator forumButton;
    Locator titleForumText;
    Locator checkBoxForum;
    Locator okeButtonForum;
    Locator upCommingText;
    Locator sudahDiBayarBtn;
    Locator invoiceSudahdiBayar;
    Locator itemCardBillingHasBeenPaid;


    public kostSayaPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.locator = new LocatorHelpers(page);
        this.inputCodeFromOwner = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Masukkan kode dari pemilik"));
        this.sendButton = page.locator("//button[normalize-space()='Kirim kode unik']");
        this.verificationTittle = page.getByText("Verifikasi nomor HP");
        this.tenantPhoneNum1Tittle = page.getByTestId("userKostGetOTP-desc").getByText("08*******714");
        this.tenantPhoneNum2Tittle = page.getByText("08*****303.");
        this.alertVerifTittle = page.getByText("Setelah verifikasi berhasil, kamu akan menggunakan nomor 08*******714 di profilm");
        this.otpWordingTittle = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Kirim OTP ke 08*******714"));
        this.sendOtpButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Kirim OTP ke 08*******714"));
        this.verificationViaSms = page.getByText("chat Kirim kode verifikasi via SMS ke 08*******714");
        this.yaBatalkanButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ya, batalkan"));
        this.kostSayaStillEmptyTittle = page.getByText("Kamu belum menyewa kos");
        this.lihatInformasiKosButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Lihat informasi kos"));
        this.informasiKostText = page.getByText("Informasi Kos");
        this.lihatSemuaFasilitasButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lihat semua fasilitas"));
        this.forumButton = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("Forum"));
        this.titleForumText = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Fitur ini sedang kami kembangkan"));
        this.checkBoxForum = page.locator("span").filter(new Locator.FilterOptions().setHasText("checkmark"));
        this.okeButtonForum = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Oke"));
        this.sudahDiBayarBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sudah Dibayar"));
        this.invoiceSudahdiBayar = page.getByText("Jatuh tempo 26 Desember Rp96.000.200");
        this.itemCardBillingHasBeenPaid = page.locator("//div[@class='claim-header']");
    }

    /**
     * User click on masukkan kode dari pemilik button
     */

    public void clickOnInputCodeButton() {
        inputCodeFromOwner.click();
    }

    /**
     * User input code and click send button
     */

    public void userInputCodeAndClickSendButton(String code) {
            page.focus("//input[@data-testid='uniqueCodeInput-input']");
            page.type("//input[@data-testid='uniqueCodeInput-input']", code);
            sendButton.click();
        }

    /**
     * this method will be information tittle verification displayed
     */
    public Boolean getTitleVerification(){
        return playwright.waitTillLocatorIsVisible(verificationTittle);
    }

    /**
     * this method will be information tittle phone Number 1 displayed
     */
    public Boolean getTenantPhoneNum1(){
        return playwright.waitTillLocatorIsVisible(tenantPhoneNum1Tittle);
    }
    /**
     * this method will be information tittle phone Number 1 displayed
     */
    public Boolean getTenantPhoneNum2(){
        return playwright.waitTillLocatorIsVisible(tenantPhoneNum2Tittle);
    }
    /**
     * this method will be information tittle alert verification displayed
     */
    public Boolean getAlertVerif(){
        return playwright.waitTillLocatorIsVisible(alertVerifTittle);
    }
    /**
     * this method will be information tittle otp wording displayed
     */
    public Boolean getOtpWording(){
        return playwright.waitTillLocatorIsVisible(otpWordingTittle);
    }
    /**
     * User click on send OTP button
     */

    public void clickOnSendOtpButton() {
        sendOtpButton.click();
    }

    /**
     * User click on send OTP via sms button
     */

    public void clickOnVerificationViaSms() {
        verificationViaSms.click();
    }
    /**
     * User click on back until first page
     */

    public void clickOnBackUntilFirstPage() {
        page.goBack();
        yaBatalkanButton.click();
        for(int i=0; i<3; i++){
            page.goBack();
        }
    }
    /**
     * this method will be information tittle Kamu belum menyewa kos displayed
     */
    public Boolean getTitleKosSayaStillEmpty(){
        page.reload();
        return playwright.waitTillLocatorIsVisible(kostSayaStillEmptyTittle);
    }

    //------------------ lihat informasi kost-------------//

    /**
     * click Lihat informasi kos button
     */
    public void clickLihatInformasiKosButton(){
        playwright.clickOn(lihatInformasiKosButton);
    }

    /**
     * this method will be information tittle Informasi kos displayed
     */
    public boolean getTitleInformasiKosText(){
        return playwright.waitTillLocatorIsVisible(informasiKostText);
    }

    /**
     * this method will be information title facility displayed
     */
    public boolean getFasilitas(String text){
      kostNametext = page.getByText(""+text+"");
      return playwright.waitTillLocatorIsVisible(kostNametext);
    }

    /**
     * click Lihat semua fasilitas button
     */
    public void clickLihatSemuaFasilitasButton() {
        playwright.pageScrollInView(lihatSemuaFasilitasButton);
        playwright.clickOn(lihatSemuaFasilitasButton);
    }

    /**
     * click on forum menu
     */
    public void clickForumMenuButton(){
        playwright.clickOn(forumButton);
    }

    /**
     * validated title popup is visible
     * @return
     */
    public boolean getTitleCommingSoonPopup(){
        playwright.waitTillLocatorIsVisible(titleForumText);
        return titleForumText.isVisible();
    }

    /**
     * click on checklist berlangganan
     */
    public void checklistBerlangganan(){
        playwright.clickOn(checkBoxForum);
    }

    /**
     * click on Oke button on popup comming soon
     */
    public void clickOkeButtonUpCoomingPopup(){
        playwright.clickOn(okeButtonForum);
    }

    /**
     * validated information upcommingsoon is visible
     * @param text
     * @return
     */
    public boolean getInformationUpComming(String text){
        upCommingText =page.getByText(""+text+"");
        return upCommingText.isVisible();
    }

    /**
     * click on sudah Bayar on kost saya
     */
    public void clickSudahDiBayar(){
        playwright.clickOn(sudahDiBayarBtn);
    }

    /**
     * check if payment is success
     *
     * @return String "sudah di bayar"
     */
    public String isPaymentSuccessText(String dibayar) {
        Locator statusInvoice = page.getByText(dibayar).nth(1);
        return playwright.getText(statusInvoice);
    }
    /**
     * click on item card sudah Bayar on kost saya
     */
    public void clickItemCardBillingHasBeenPaid(){
        playwright.clickOn(sudahDiBayarBtn);
        playwright.clickOn(itemCardBillingHasBeenPaid);
    }
}

