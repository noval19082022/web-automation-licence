package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.owner.PropertySayaPO;
import utilities.PlaywrightHelpers;

public class PropertySayaSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    PropertySayaPO propertySaya = new PropertySayaPO (page);


    @And("owner search kost {string} on property saya page")
    public void ownerSearchKostOnPropertySayaPage(String kostName) {
        propertySaya.searchKostPropertySaya(kostName);
    }

    @And("owner click update kamar kost")
    public void ownerClickUpdateKamarKost() {
        propertySaya.clickUpdateKamarButton();
    }

    @And("owner set status kamar is kosong")
    public void ownerSetStatusKamarIsKosong() {
        propertySaya.clickUpdateKamarEmptyButton();
    }

    @Then("user see kos with name {string}, status {string} and type {string}")
    public void userSeeKosWithNameStatusAndType(String name, String status, String type) {
        Assert.assertTrue(propertySaya.getFirstKosName().contains(name), "Kos name is wrong");
        Assert.assertTrue(propertySaya.getFirstKosStatus(status).contains(status), "Kos name field is still enable");
        Assert.assertEquals(propertySaya.getFirstKosType(type), type, "Kos type is wrong");
    }

    @And("user click kos {string} in update price list")
    public void userClickKosInUpdatePriceList(String kosName) {
        propertySaya.clickOnKosName(kosName);
    }

    @When("user click see other prices")
    public void user_click_see_other_prices() {
        propertySaya.clickSeeOtherPrices();
    }

    @When("user input daily price with {string}")
    public void user_input_daily_price_with(String dailyPrice) {
        propertySaya.inputDailyPriceKos(dailyPrice);
    }

    @When("user input weekly price with {string}")
    public void user_input_weekly_price_with(String weeklyPrice) {
        propertySaya.inputWeeklyPrice(weeklyPrice);
    }

    @When("user input monthly price with {string}")
    public void user_input_monthly_price_with(String monthlyPrice) {
        propertySaya.inputMonthlyPrice(monthlyPrice);
    }

    @When("user input three monthly price with {string}")
    public void user_input_three_monthly_price_with(String threeMonthlyPrice) {
        propertySaya.inputThreeMonthlyPrice(threeMonthlyPrice);
    }

    @When("user input six monthly price with {string}")
    public void user_input_six_monthly_price_with(String sixMonthlyPrice) {
        propertySaya.inputSixMonthlyPrice(sixMonthlyPrice);
    }

    @When("user input yearly price with {string}")
    public void user_input_yearly_price_with(String yearlyPrice) {
        propertySaya.inputYearlyPrice(yearlyPrice);
    }

    @And("user click back button in page")
    public void click_back_button_in_page() {
        page.goBack();
    }

    @When("user click continue input data on pop up")
    public void user_click_continue_input_data_on_pop_up() {
        propertySaya.clickContinueInputDataPopUp();
    }

    @And("user clicks update price button")
    public void userClicksUpdatePriceButton() {
        propertySaya.clickButtonUpdate();
    }

    @Then("user see pop up success update price {string}")
    public void userSeePopUpSuccessUpdatePrice(String messageSuccess) {
        Assert.assertEquals(propertySaya.getToastSuccessUpdatePrice(), messageSuccess, "Pop up success update price is wrong");
    }

    @When("user click see kos button")
    public void user_click_see_kos_button() {
        propertySaya.clickFirstSeeKos();
    }

    @When("user click Lihat Selengkapnya button for edit")
    public void user_click_Lihat_Selengkapnya_button_for_edit() {
        propertySaya.clickOnLihatSelengkapnyaButton();
    }

    @When("user click Chat in kos list")
    public void user_click_Chat_in_kos_list() {
        propertySaya.clickChat();
    }

    @When("user click review in kost list")
    public void user_click_review_in_kost_list() {
        propertySaya.clickReview();
    }

    @And("owner add room with name or room number {string}")
    public void ownerAddRoomWithNameOrRoomNumber(String roomNumber) {
        propertySaya.addRoom(roomNumber);
    }

    @Then("user see total room is {string} in update room page")
    public void user_see_total_room_is_in_update_room_page(String room) {
        Assert.assertEquals(propertySaya.getTextTotalRoom(), room, "Total room is wrong");
    }

    @When("user delete room name or number in room allotment")
    public void user_delete_room_name_or_number_in_room_allotment() {
        propertySaya.clickOnFirstDeleteRoomIcon();
    }

    @When("user click icon close on page pilih jenis properti")
    public void user_click_icon_close_on_page_pilih_jenis_properti() {
        propertySaya.clickOnIconClose();
    }

    @And("user selects {string} option and click on Add Data button")
    public void userSelectsOptionAndClickOnAddDataButton(String option) {
        propertySaya.selectOptionAddProperty(option);
    }

    @Given("user click add new kos button")
    public void user_click_add_new_kos_button() {
        propertySaya.clickAddNewKos();
    }

    @And("owner close pop up BBK at kos list page")
    public void ownerClosePopUpBBKAtKosListPage() {
        propertySaya.clickClosePopUpBBK();
    }

    @Then("user see activate mamipay form with Full Name {string}")
    public void user_see_activate_mamipay_form_with_Full_Name(String fullName) {
        Assert.assertEquals(propertySaya.getInputTextFullName().trim(), fullName, "Full Name in mamipay form is wrong");
    }

    @When("user see activate mamipay form with Bank Account Number {string}")
    public void user_see_activate_mamipay_form_with_Bank_Account_Number(String accountNo) throws InterruptedException {
        Assert.assertEquals(propertySaya.getInputTextBankAcc().trim(), accountNo, "Bank account number in mamipay form is wrong");
    }

    @When("user see active mamipay form with Bank Owner Name {string}")
    public void user_see_active_mamipay_form_with_Bank_Owner_Name(String bankOwnerName) {
        Assert.assertEquals(propertySaya.getInputTextBankOwnerName().trim(), bankOwnerName, "Bank owner name in mamipay form is wrong");
    }

    @When("user see active mamipay form with Bank Name {string}")
    public void user_see_active_mamipay_form_with_Bank_Name(String bankName) {
        Assert.assertEquals(propertySaya.getInputTextBankName().trim(), bankName, "Bank name in mamipay form is wrong");
    }

    @Then("user input field name with {string} at form activate mamipay")
    public void user_input_field_name_with_at_form_activate_mamipay(String fullName) {
        propertySaya.fillInputNameForm(fullName);
    }

    @And("user fill out activate mamipay form with Bank Account Number {string}")
    public void user_fill_out_activate_mamipay_form_with_bank_account_number(String bankAccountNumber) {
        propertySaya.fillBankAccountNumberForm(bankAccountNumber);
    }

    @Then("user fill out active mamipay form with  Bank Owner Name {string}")
    public void user_fill_out_active_mamipay_form_with_Bank_Owner_Name(String bankAccountName) {
        propertySaya.fillBankAccountNameForm(bankAccountName);
    }

    @Then("user select bank account with {string}")
    public void user_select_bank_account_with(String bankName) {
        propertySaya.fillInputBankName(bankName);
    }

    @When("user clicks on Terms And Conditions checkbox in Mamipay form")
    public void user_clicks_on_Terms_And_Conditions_checkbox_in_Mamipay_form() {
        propertySaya.clickTermsAndConsCheckbox();
    }

    @When("user click submit data button to activate mamipay")
    public void user_click_submit_data_button_to_activate_mamipay() {
        propertySaya.clickSubmitButtonMamipay();
    }


}
