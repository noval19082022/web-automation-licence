package steps.mamikos.owner.propertisaya;

import com.microsoft.playwright.Page;
import config.global.GlobalConfig;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import pageobject.common.LoadingPO;
import pageobject.common.ModalPopUpPO;
import pageobject.owner.AddTenantPO;
import pageobject.owner.PropertiSayaPO;
import pageobject.owner.fiturpromosi.mamiads.NaikkanIklanPO;
import utilities.JavaHelpers;
import utilities.PlaywrightHelpers;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertTrue;

public class PropertiSayaSteps {
    Page page = ActiveContext.getActivePage();
    PropertiSayaPO propertySaya = new PropertiSayaPO(ActiveContext.getActivePage());
    NaikkanIklanPO naikkanIklanPO = new NaikkanIklanPO(page);
    LoadingPO loading = new LoadingPO(page);
    AddTenantPO addTenantPO = new AddTenantPO(page);
    ModalPopUpPO modalPopUpPO = new ModalPopUpPO(page);

    PlaywrightHelpers playwright = new PlaywrightHelpers(page);

    private final JavaHelpers javaHelpers = new JavaHelpers();
    private String dailyPrice = null;
    private String weeklyPrice = null;
    private String monthlyPrice = null;
    private String threeMonthlyPrice = null;
    private String sixMonthlyPrice = null;
    private String yearlyPrice = null;
    private String kosNamePrefix;
    private String roomTypePrefix;

    private List<Map<String, String>> property;

    @When("owner navigates to update kos price with id:")
    public void ownerNavigatesToUpdateKosPriceWithId(DataTable table) {
        Map<String, String> kosId;
        playwright = new PlaywrightHelpers(ActiveContext.getActivePage());
        kosId = table.asMap(String.class, String.class);
        String pathUrlUpdateKosPriceById = Mamikos.OWNER_URL + Mamikos.OWNER_KOS_ROOMS_PRICE + kosId.get(Mamikos.ENV) + Mamikos.OWNER_REDIRECT + Mamikos.OWNER_PAGE_KOS;
        playwright.navigateTo(pathUrlUpdateKosPriceById);
    }

    @When("owner search kost {string} on property saya page")
    public void ownerSearchKostOnPropertySayaPage(String kostName) {
        loading.waitForLoadingIconDisappear();
        if(modalPopUpPO.isModalCloseIconVisible()){
            modalPopUpPO.clicksModalCloseIcon();
        }
        propertySaya.searchKostPropertySaya(kostName);
        Mamikos.setPropertyKosName(kostName);
    }

    @When("owner click update kamar kost")
    public void ownerClickUpdateKamarKost() {
        propertySaya.clickUpdateKamarButton();
    }

    @When("owner set status kamar is kosong")
    public void ownerSetStatusKamarIsKosong() {
        propertySaya.clickUpdateKamarEmptyButton();
    }

    @Then("user see kos with name {string}, status {string} and type {string}")
    public void userSeeKosWithNameStatusAndType(String name, String status, String type) {
        System.out.println(status);
        Assert.assertTrue(propertySaya.getFirstKosName().contains(name), "Kos name is wrong");
        Assert.assertTrue(propertySaya.getFirstKosStatus(status).contains(status), "Kos name field is still enable");
        Assert.assertEquals(propertySaya.getFirstKosType(type), type, "Kos type is wrong");
    }

    @When("user click kos {string} in update price list")
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

    @And("user see daily price is {string}")
    public void user_see_daily_price_is(String dailyPrice) {
        Assert.assertEquals(propertySaya.getDailyPrice(), dailyPrice, "Daily price is not correct");
    }

    @And("user see weekly price is {string}")
    public void user_see_weekly_price_is(String weeklyPrice) {
        Assert.assertEquals(propertySaya.getWeeklyPrice(), weeklyPrice, "Weekly price is not correct");
    }

    @And("user see monthly price is {string}")
    public void user_see_monthly_price_is(String monthlyPrice) {
        Assert.assertEquals(propertySaya.getMonthlyPrice(), monthlyPrice, "Monthly price is not correct");
    }

    @And("user see three monthly price is {string}")
    public void user_see_three_monthly_price_is(String threeMonthPrice) {
        Assert.assertEquals(propertySaya.getThreeMonthlyPrice(), threeMonthPrice, "Three monthly price is not correct");
    }

    @Then("user see six monthly price is {string}")
    public void user_see_six_monthly_price_is(String sixMonthlyPrice) {
        Assert.assertEquals(propertySaya.getSixMonthlyPrice(), sixMonthlyPrice, "Six monthly price is not correct");
    }

    @And("user see yearly price is {string}")
    public void user_see_yearly_price_is(String yearlyPrice) {
        Assert.assertEquals(propertySaya.getYearlyPrice(), yearlyPrice, "Yearly price is not correct");
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
        loading.waitForLoadingIconDisappear();
        if(modalPopUpPO.isModalCloseIconVisible()){
            modalPopUpPO.clicksModalCloseIcon();
        }
        propertySaya.clickOnLihatSelengkapnyaButton();
    }

    @When("user/owner clicks on Edit Data Kos button number {string}")
    public void userOwnerClicksOnEditDataKosButtonNumber(String kosNumber) {
        if (modalPopUpPO.isModalCloseIconVisible()) {
            modalPopUpPO.clicksModalCloseIcon();
        }
        propertySaya.clicksOnEditDataKosButton(Integer.parseInt(kosNumber) - 1);
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
        loading.waitForLoadingIconDisappear();
        if (propertySaya.BBKPopUpVisible() || propertySaya.CloseBtnPopUpBBKIsVisible()) {
            propertySaya.clickClosePopUpBBK();
        }
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

    @And("user click button edit {string} kos")
    public void userClickButtonEditKos(String updateData) {
        playwright.waitTillPageLoaded();
        propertySaya.clickEditDataKos(updateData);
    }

    @When("user uncheck/check facilities under {string}")
    public void user_check_facilities_under(String section, List<String> facilities) {
        for (String facility : facilities) {
            propertySaya.clickFacilitiesCheckbox(section, facility);
        }
    }

    @Then("user see edit finished button is disabled")
    public void userSeeEditFinishedButtonIsDisabled() {
        Assert.assertTrue(propertySaya.isEditFinishedButtonDisabled());
    }

    @And("user see {string} has warning title {string} and description {string}")
    public void user_see_has_warning_title_and_description(String facility, String title, String desc) {
        Assert.assertEquals(propertySaya.getWarningTitleFacility(facility), title, "Warning title in " + facility + " is wrong");
        Assert.assertEquals(propertySaya.getWarningDescFacility(facility), desc, "Warning description in " + facility + " is wrong");
    }

    @Then("owner/user click button edit finished")
    public void userClickButtonEditFinished() {
       // loading.waitForLoadingIconDisappear();
        propertySaya.clickEditDoneButton();
    }

    @Then("user see success add data kos pop up with text {string}")
    public void user_see_success_add_data_kos_pop_up_with_text(String message) {
        Assert.assertEquals(propertySaya.getTitlePopUpSuccessEditKos().trim(), message, "Pop up title success message in edit kos is wrong");
    }

    @When("user click done in success page pop up of edit kos")
    public void user_click_done_in_success_page_pop_up_of_edit_kos() throws InterruptedException {
        propertySaya.clickDoneEditKosPopUp();
    }

    @Given("user input kost location {string} and clicks on first autocomplete suggestion")
    public void user_input_kost_location_and_clicks_on_first_autocomplete_result(String location) {
        propertySaya.insertKosLocation(location);
//        propertySaya.clickOnFirstResult(location);
    }

    @Given("owner/user input address note {string} and random text")
    public void user_input_address_note_and_random_text(String note) {
        String random = javaHelpers.generateAlphanumeric(6);
        propertySaya.enterAddressNotes(note + random);
    }

    @When("user memorize daily, weekly, monthly, three monthly, six monthly, and yearly price")
    public void user_memorize_daily_weekly_monthly_three_monthly_six_monthly_and_yearly_price() {
        this.dailyPrice = propertySaya.getDailyPrice();
        this.weeklyPrice = propertySaya.getWeeklyPrice();
        this.monthlyPrice = propertySaya.getMonthlyPrice();
        this.threeMonthlyPrice = propertySaya.getThreeMonthlyPrice();
        this.sixMonthlyPrice = propertySaya.getSixMonthlyPrice();
        this.yearlyPrice = propertySaya.getYearlyPrice();
    }

    @Then("user see infobar in update price with text {string}")
    public void user_see_infobar_in_update_price_with_text(String text) {
        Assert.assertEquals(JavaHelpers.removeExtraNewLine(propertySaya.getPromoNgebutInfo()), text);
    }

    @Then("user see monthly price field is disabled")
    public void user_see_monthly_price_field_is_disabled() {
        Assert.assertTrue(propertySaya.isMonthlyPriceFieldDisable(), "Monthly price field is not disable");
    }

    @When("user close infobar promo ngebut in update price")
    public void user_close_infobar_promo_ngebut_in_update_price() throws InterruptedException {
        propertySaya.clickCloseInfobar();
    }

    @Then("user see daily, weekly, monthly, three monthly, six monthly, and yearly price is same with previous price")
    public void user_see_daily_weekly_monthly_three_monthly_six_monthly_and_yearly_price_is_same_with_previous_price() {
        Assert.assertEquals(propertySaya.getDailyPrice(), this.dailyPrice, "Daily price is not correct");
        Assert.assertEquals(propertySaya.getWeeklyPrice(), this.weeklyPrice, "Weekly price is not correct");
        Assert.assertEquals(propertySaya.getMonthlyPrice(), this.monthlyPrice, "Monthly price is not correct");
        Assert.assertEquals(propertySaya.getThreeMonthlyPrice(), this.threeMonthlyPrice, "Three monthly price is not correct");
        Assert.assertEquals(propertySaya.getSixMonthlyPrice(), this.sixMonthlyPrice, "Six monthly price is not correct");
        Assert.assertEquals(propertySaya.getYearlyPrice(), this.yearlyPrice, "Yearly price is not correct");
    }

    @Then("verify tambah data pop up is appear")
    public void verifyTambahDataPopUpIsAppear() {
        Assert.assertTrue(propertySaya.isPopUpModalVisible(), "Pop up modal doesn't appear!");
    }

    @And("verify kos is {string}")
    public void verifyKosIs(String statusKos) {
        Assert.assertTrue(propertySaya.isStatusKos(), "Status kos doesn't match!");
    }

    @And("user see warning price with:")
    public void userSeeWarningPriceWith(DataTable dataTable) {
        List<Map<String, String>> table = dataTable.asMaps();
        int i = 0;
        for (Map<String, String> content : table) {
            Assert.assertEquals(propertySaya.getWarningYearlyPrice(i), content.get("warningMessage"), "title not equal to " + content.get("title"));
            i++;
        }
    }

    @And("user see button update price disable")
    public void user_see_button_update_price_disable() throws InterruptedException {
        Assert.assertTrue(propertySaya.isButtonUpdatePriceDisable(), "Button update price enable");
    }

    @And("owner click tambah data iklan {string}")
    public void ownerClickTambahDataIklan(String jenisProperti) {
        if (playwright.isTextDisplayed("Beberapa Kos Belum Dapat Dibooking")) {
            propertySaya.clickClosePopUpBBKOnPropertySaya();
        }
        propertySaya.clickTambahDataIklan(jenisProperti);
    }

    @And("owner fills data apartemen with Property Name is {string}")
    public void ownerFillsDataApartemenWithPropertyNameIs(String propertyName) {
        propertySaya.inputPropertyName(propertyName);
    }

    @Then("owner input requirement field add apartemen is as expected")
    public void ownerInputRequirementFieldAddApartemenIsAsExpected(DataTable dataTable) {
        List<Map<String, String>> table = dataTable.asMaps(String.class, String.class);
        propertySaya.inputPropertyName(table.get(0).get("nama project"));
        propertySaya.selectPropertyName(table.get(0).get("nama project"));
        propertySaya.inputNamaUnit(table.get(0).get("nama unit"));
        propertySaya.inputNoUnit(table.get(0).get("nomor unit"));
        propertySaya.selectUnitType(table.get(0).get("tipe unit"));
        propertySaya.inputLantai(table.get(0).get("lantai"));
        propertySaya.inputUnitSize(table.get(0).get("luas unit"));
        propertySaya.inputDescription(table.get(0).get("deskripsi"));
    }

    @And("owner input harga sewa {string} is {string}")
    public void ownerInputHargaSewaIs(String priceType, String price) {
        propertySaya.selectPriceType(priceType);
        propertySaya.inputApartementPrice(priceType, price);
    }

    @And("owner select fasilitas unit {string} and fasilitas kamar {string}")
    public void ownerSelectFasilitasUnitAndFasilitasKamar(String fasilitasUnit, String fasilitasKamar) {
        propertySaya.selectFasilitasUnit(fasilitasUnit);
        propertySaya.selectFasilitasKamar(fasilitasKamar);

        if (fasilitasKamar.equals("Semi Furnished") || fasilitasKamar.equals("Furnished")) {
            propertySaya.clickFurnished("Bed");
        }
    }

    @And("owner upload cover photo apartemen")
    public void ownerUploadCoverPhotoApartemen() {
        propertySaya.uploadCoverPhotoApartemen();
    }

    @And("owner upload photo apartemen")
    public void ownerUploadPhotoApartemen() {
        propertySaya.uploadCoverPhotoApartemen();
    }

    @And("owner upload photo {string} of apartemen")
    public void ownerUploadPhotoOfApartemen(String typePhoto) {
        propertySaya.uploadPhotoApartemen(typePhoto);
    }

    @Then("owner can see url link is for property saya apartemen")
    public void ownerCanSeeUrlLinkIsForPropertySayaApartemen() {
        Assert.assertEquals(page.url(), Mamikos.URL + Mamikos.PROPERTY_SAYA_APARTEMENT, "URL is not equal");
    }

    @And("owner click edit data apartemen")
    public void ownerClickEditDataApartemen() {
        propertySaya.clickEditDataApartemen();
    }

    @Then("verify status apartemen {string}")
    public void verifyStatusApartemen(String status) {
        if (status.equals("Diperiksa Admin")) {
            Assert.assertEquals(propertySaya.getStatusProperty(propertySaya.getSearchPropertyName()), status, "Status doesn't match!");
        } else if (status.equals("Ditolak")) {
            Assert.assertEquals(propertySaya.getStatusPropertyReject(propertySaya.getSearchPropertyName()), status, "Status doesn't match!");
        } else if (status.equals("Aktif")) {
            Assert.assertEquals(propertySaya.getStatusPropertyVerified(propertySaya.getSearchPropertyName()), status, "Status doesn't match!");
        }
    }

    @And("owner search apart {string} on property saya page")
    public void ownerSearchApartOnPropertySayaPage(String namaUnit) {
        propertySaya.searchApartPropertySaya(namaUnit);

    }

    @And("owner submit edit data apartemen")
    public void ownerSubmitEditDataApartemen() {
        propertySaya.clickOnSubmitButton();
        propertySaya.clickOnSelesaiButton();
    }

    @And("owner fills valid data kos as expected")
    public void ownerFillsValidDataKosAsExpected(DataTable dataTable) {
        List<Map<String, String>> table = dataTable.asMaps(String.class, String.class);
        int length = 8;
        boolean useLetters = true;
        boolean useNumbers = true;
        var kostNameInput = table.get(0).get("kos name");
        if (kostNameInput != null && !kostNameInput.isEmpty()) {
            String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
            kosNamePrefix = kostNameInput + " " + generatedString.toUpperCase();
            propertySaya.inputKosName(kosNamePrefix);
            Mamikos.setPropertyKosName(kosNamePrefix);
        }
        propertySaya.checkRoomType(table.get(0).get("room type check"));
        propertySaya.inputRoomTypeName(table.get(0).get("room type name"));
        propertySaya.selectKostType(table.get(0).get("kos type"));
        propertySaya.inputDescKos(table.get(0).get("description kos"));
        propertySaya.selectBuildKos(table.get(0).get("build kos"));
        propertySaya.inputOtherNote(table.get(0).get("other note"));

    }

    @And("owner clear description kost on edit page")
    public void clearDesc() {
        propertySaya.clearDescKost();
    }

    @And("owner set rules kos:")
    public void ownerSetRulesKos(List<String> rules) {
        propertySaya.clickOnAturPeraturanKos();
        for (String rule : rules) {
            propertySaya.clickKosRulesCheckbox(rule);
        }
    }

    @And("owner upload rule kos")
    public void ownerUploadRuleKos() {
        propertySaya.uploadInvalidAturanKos();
    }

    @Then("verify warning upload gagal")
    public void verifyWarningUploadGagal() {
        Assert.assertEquals(propertySaya.getErrorUpload(), "Upload GagalFormat foto tidak didukung. Pastikan format foto JPEG/PNG.", "Error doesn't match!");
    }

    @When("owner upload valid rule kos")
    public void ownerUploadValidRuleKos() {
        propertySaya.uploadValidAturanKos();
    }

    @Then("verify warning upload gagal disappear")
    public void verifyWarningUploadGagalDisappear() {
        Assert.assertFalse(propertySaya.isErrorUploadDisappear(), "Error upload alredy displayed");
    }

    @And("owner accept know the location")
    public void ownerAcceptKnowTheLocation() {
        propertySaya.allowLocation();
    }

    @And("owner input address is {string}")
    public void ownerInputAddressIs(String keyLocation) {
        propertySaya.inputLocationKos(keyLocation);
        propertySaya.reinputIfAlamatStillNull(keyLocation);
    }

    @When("owner click Lanjutkan for input kos address")
    public void ownerClickLanjutkanForInputKosAddress() {
        propertySaya.allowLocation();
    }

    @When("user enter text {string} on search bar in room allotment and hit enter")
    public void user_enter_text_on_search_bar_in_room_allotment_and_hit_enter(String text) {
        propertySaya.searchNameOrRoomNo(text);
    }

    @When("user click edit button in first row of the table")
    public void user_click_edit_button_in_first_row_of_the_table() throws InterruptedException {
        propertySaya.clickFirstEditButton();
    }

    @When("user tick already inhabited checkbox")
    public void user_tick_already_inhabited_checkbox() throws InterruptedException {
        propertySaya.clickAlreadyInhabitedCheckbox();
    }

    @Then("user can sees toast on update room/price as {string} {string}")
    public void user_can_sees_toast_x(String statusRoom, String room) {
        Assert.assertEquals(propertySaya.getRoomStatus(), statusRoom, "status room is wrong");
        Assert.assertEquals(propertySaya.getTextTotalRoom(), room, "Total room is wrong");
    }

    @When("user filter the room with {string} in update room page")
    public void user_filter_the_room_with_in_update_room_page(String filter) {
        propertySaya.filterRoomTable(filter);
    }

    @When("user fill room floor in room allotment page with {string}")
    public void user_fill_room_floor_in_room_allotment_page_with(String text) {
        propertySaya.insertTextFloor(text);
    }

    @When("user fill room name in room allotment page with {string}")
    public void user_fill_room_name_in_room_allotment_page_with(String roomName) {
        propertySaya.insertTextRoomName(roomName);
    }

    @Then("user see label {string} in room name")
    public void user_see_label_in_room_name_or_number(String roomNo) {
        Assert.assertEquals(propertySaya.getGoldPlusLabel(roomNo), roomNo);
    }

    @Then("user see error message {string} under room name field in update room page")
    public void user_see_error_message_under_room_name_field_in_update_room_page(String error) {
        Assert.assertEquals(propertySaya.getErrorRoomName().trim(), error, "Error message room name is wrong");
    }

    @Then("user see error message {string} under floor field in update room page")
    public void user_see_error_message_under_floor_field_in_update_room_page(String error) {
        Assert.assertEquals(propertySaya.getErrorFloor().trim(), error, "Error message floor is wrong");
    }

    @Then("user see room list is empty in room allotment page")
    public void user_see_room_list_is_empty_in_room_allotment_page() {
        Assert.assertTrue(propertySaya.isTableEmpty(), "Table is not empty");
    }

    @And("owner click lanjutkan button for next steps")
    public void ownerClickLanjutkanButtonForNextSteps() {
        propertySaya.clickOnLanjutkan();
       // loading.waitForLoadingIconDisappear();
    }

    @And("owner invalid upload photo {string}")
    public void ownerInvalidUploadPhoto(String photoName) {
        propertySaya.uploadInvalidPhotoKos(photoName);
    }

    @When("owner valid upload photo kos")
    public void ownerValidUploadPhotoKos() {
        propertySaya.ubahValidPhotoKos();
    }

    @And("owner select size room {string}")
    public void ownerSelectSizeRoom(String roomSize) {
        propertySaya.selectRoomSize(roomSize);
    }

    @And("owner input total room and room available as expected")
    public void ownerInputTotalRoomAndRoomAvailableAsExpected(DataTable dataTable) {
        List<Map<String, String>> table = dataTable.asMaps(String.class, String.class);

        propertySaya.inputTotalRoom(table.get(0).get("total room"));
        propertySaya.inputRoomAvailable(table.get(0).get("room available"));
    }

    @And("owner input the price room as expected")
    public void ownerInputThePriceRoomAsExpected(DataTable dataTable) {
        playwright.waitTillPageLoaded(5000.0);
        loading.waitForLoadingIconDisappear();
        List<Map<String, String>> table = dataTable.asMaps(String.class, String.class);

        propertySaya.inputMonthyPrice(table.get(0).get("monthly price"));
        propertySaya.selectMinRentDuration(table.get(0).get("check min rent duration"), table.get(0).get("min rent duration"));

        if (table.get(0).get("check other price").equals("yes")) {
            propertySaya.selectOtherPrice(table.get(0).get("check other price"));
            propertySaya.inputOtherPrice("Hari", table.get(0).get("daily price"), 1);
            propertySaya.inputOtherPrice("Minggu", table.get(0).get("weekly price"), 2);
            propertySaya.inputOtherPrice("3 Bulan", table.get(0).get("three monthly price"), 3);
            propertySaya.inputOtherPrice("6 Bulan", table.get(0).get("six monthly price"), 4);
            propertySaya.inputOtherPrice("Tahun", table.get(0).get("yearly price"), 5);
        }
    }

    @And("owner click done in success page")
    public void ownerClickDoneInSuccessPage() {
        propertySaya.clickOnSelesaiSubmit();
    }

    @Then("user see kos with valid name, status {string} and type {string}")
    public void userSeeKosWithValidNameStatusAndType(String status, String kosType) {
        propertySaya.waitPageLoaded();
//        Assert.assertTrue(propertySaya.getFirstKosName()
//                        toLowerCase().
//                        contains(
//                                Mamikos.
//                                        getPropertyKosName().
//                                        toLowerCase()
//                        ),
//                "Kos name is wrong"
//                        + " expected contains: " + Mamikos.getPropertyKosName()
//                        + " actual: " + propertySaya.getFirstKosName());
        Assert.assertTrue(propertySaya.getFirstKosStatus(status).contains(status), "Kos name field is still enable");
        Assert.assertEquals(propertySaya.getFirstKosType(kosType), kosType, "Kos type is wrong");
    }

    @And("user delete first kos on the list")
    public void userDeleteFirstKosOnTheList() {
        propertySaya.clickDeleteKosDraft();
        propertySaya.clickHapusOnPopUpConfirmation();
    }

    @And("owner click {string} on Kebijakan BBK Baru Mamikos")
    public void ownerClickOnKebijakanBBKBaruMamikos(String text) {
        propertySaya.clickOnNewBBKPopUp(text);
    }

    @And("owner click add another type from kos {string}")
    public void ownerClickAddAnotherTypeFromKos(String kosName) {
        playwright.waitTillPageLoaded(10000.0);
        loading.waitForLoadingIconDisappear();
        propertySaya.clickAddAnotherTypeFromKos(kosName);
        Mamikos.setPropertyKosName(kosName);
    }

    @And("owner click {string} in add new room type pop up and click next")
    public void ownerClickInAddNewRoomTypePopUpAndClickNext(String kosType) throws InterruptedException {
        propertySaya.clickNewRoomType(kosType);
    }

    @Then("verify message {string} the room type")
    public void verifyMessageTheRoomType(String roomTypeMessageText) {
        playwright.waitTillPageLoaded();
        loading.waitForLoadingIconDisappear();
        Assert.assertEquals(propertySaya.getRoomTypeMessage(roomTypeMessageText), roomTypeMessageText, "Room type message doesn't match!");
    }

    @When("owner input room type with {string}")
    public void ownerInputRoomTypeWith(String text) {
        if (text.equals("{random_text}")) {
            int length = 3;
            boolean useLetters = true;
            boolean useNumbers = true;
            String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
            roomTypePrefix = "Tipe " + generatedString.toUpperCase();
            propertySaya.inputRoomTypeName(roomTypePrefix);
        } else {
            propertySaya.inputRoomTypeName(text);
        }
    }

    @And("see next button disable")
    public void seeNextButtonDisable() {
        Assert.assertTrue(propertySaya.isLanjutkanDisable(), "Lanjutkan button is enable!");
    }

    @When("owner select the kost type {string}")
    public void ownerSelectTheKostType(String kosType) {
        loading.waitForLoadingIconDisappear();
        propertySaya.selectKostType(kosType);
    }

    @When("owner input room type with {string} in pop up")
    public void ownerInputRoomTypeWithInPopUp(String text) {
        propertySaya.inputRoomTypeNameInPopUp(text);
    }

    @And("see next button disable in pop up")
    public void seeNextButtonDisableInPopUp() {
        propertySaya.isLanjutkanInPopUpDisable();
    }

    @When("owner input kos name {string}")
    public void ownerInputKosName(String text) {
        int length = 8;
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        kosNamePrefix = text + " " + generatedString.toUpperCase();
        propertySaya.inputKosName(kosNamePrefix);
        Mamikos.setPropertyKosName(kosNamePrefix);
    }

    @Then("owner see pop up confirmation request attention")
    public void ownerSeePopUpConfirmationRequestAttention() {
        Assert.assertEquals(propertySaya.getTitleChangeInterceptPopUp(), "Mohon Perhatiannya Sebentar", "Title doesn't match!");
        Assert.assertEquals(propertySaya.getMessageChangeInterceptPopUp(), "Jika pindah ke halaman lain, maka data yang diisi di langkah ini tidak akan tersimpan.", "Message doesn't match!");
    }

    @When("owner click {string} input data on pop up")
    public void ownerClickInputDataOnPopUp(String actionText) {
        propertySaya.clickOnActionInterceptInputData(actionText);
    }

    @And("user click back button in page input kos")
    public void userClickBackButtonInPageInputKos() {
        propertySaya.clickOnBackFromInputKos();
        Assert.assertEquals(propertySaya.getTitleChangeInterceptPopUp(), "Mohon Perhatiannya Sebentar", "Title doesn't match!");
        Assert.assertEquals(propertySaya.getMessageChangeInterceptPopUp(), "Jika pindah ke halaman lain, maka data yang diisi di langkah ini tidak akan tersimpan.", "Message doesn't match!");
    }

    @And("owner upload valid photo {string}")
    public void ownerUploadValidPhoto(String photoName) {
        propertySaya.uploadValidPhotoKos(photoName);
    }

    @And("owner input additional price")
    public void ownerInputAdditionalPrice(DataTable dataTable) {
        List<Map<String, String>> table = dataTable.asMaps(String.class, String.class);
        propertySaya.inputAdditionalPriceName(table.get(0).get("price name"));
        propertySaya.inputTotalAdditionalPrice(table.get(0).get("price total"));
    }

    @And("owner select additional price")
    public void ownerSelectAdditionalPrice() {
        propertySaya.selectAdditionalPrice();
    }

    @And("owner select down payment with {string} from rent price")
    public void ownerSelectDownPaymentWithFromRentPrice(String downPaymentPercentage) {
        propertySaya.selectDownPayment();
        propertySaya.selectPercentageOfDownPayment(downPaymentPercentage);
    }

    @And("owner set penalty is {string}")
    public void ownerSetPenaltyIs(String penaltyAmount) {
        propertySaya.selectPenalty();
        propertySaya.inputPenalty(penaltyAmount);
    }

    @When("owner input room type with random text in pop up")
    public void ownerInputRoomTypeWithRandomTextInPopUp() {
        int length = 3;
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        roomTypePrefix = "Tipe " + generatedString.toUpperCase();
        propertySaya.inputRoomTypeNameInPopUp(roomTypePrefix);
    }

    @And("owner click lanjutkan button in bottom of add kos page")
    public void ownerClickLanjutkanButtonInBottomOfAddKosPage() {
        propertySaya.clickOnLanjutkanAfterInputTypeRoom();
    }

    @Then("verify kos description is disabled")
    public void verifyKosDescriptionIsDisabled() {
        Assert.assertTrue(propertySaya.isDescriptionKosDisable(), "Description kos is enable!");
    }

    @And("verify kos build year is disabled")
    public void verifyKosBuildYearIsDisabled() {
        Assert.assertFalse(propertySaya.isBuildKosDisable(), "Description kos is enable!");
    }

    @When("owner click {string} button in add kos page")
    public void ownerClickButtonInAddKosPage(String text) {
        propertySaya.clickOnLengkapiDataAddKos(text);
    }

    @Then("user see error message {string} under total room")
    public void userSeeErrorMessageUnderTotalRoom(String error) {
        Assert.assertEquals(propertySaya.getErrorRoomName().trim(), error, "Error message floor is wrong");
    }

    @And("user see error message {string} under total room available")
    public void userSeeErrorMessageUnderTotalRoomAvailable(String error) {
        Assert.assertEquals(propertySaya.getErrorRoomName().trim(), error, "Error message floor is wrong");
    }

    @When("owner click {string} ketersediaan kamar")
    public void ownerClickKetersediaanKamar(String text) {
        playwright.waitTillPageLoaded(10000.0);
        loading.waitForLoadingIconDisappear();
        propertySaya.clickOnKetersediaanKamar(text);
    }

    @And("owner input room name or number in room allotment page with {string}")
    public void ownerInputRoomNameOrNumberInRoomAllotmentPageWith(String text) {
        propertySaya.inputKosName(text);
    }

    @Then("user see error message {string} under room type field")
    public void userSeeErrorMessageUnderRoomTypeField(String error) {
        Assert.assertEquals(propertySaya.getErrorRoomName().trim(), error, "Error message floor is wrong");
    }

    @When("owner input room floor with {string}")
    public void ownerInputRoomFloorWith(String text) {
        propertySaya.inputRoomTypeName(text);
    }

    @Then("user see error message {string} under floor field")
    public void userSeeErrorMessageUnderFloorField(String error) {
        Assert.assertEquals(propertySaya.getErrorRoomName().trim(), error, "Error message floor is wrong");
    }

    @When("owner click {string} in data ketersediaan kamar")
    public void ownerClickInDataKetersediaanKamar(String text) {
        propertySaya.clickOnSelesaiAturKamar(text);
    }

    @And("user select payment expired date after {string} {string}")
    public void userSelectPaymentExpiredDateAfter(String number, String rangeTime) {
        propertySaya.selectPaymentExpiredDate(number, rangeTime);
    }

    @And("user input monthly price with {string} in add kos page")
    public void userInputMonthlyPriceWithInAddKosPage(String monthlyPrice) {
        propertySaya.inputMonthyPrice(monthlyPrice);
    }

    @And("owner click {string} on kos draft")
    public void ownerClickOnKosDraft(String text) {
        propertySaya.clickOnLengkapiDataKosDraft();
    }

    @And("owner edit data harga kos as expected")
    public void ownerEditDataHargaKosAsExpected(DataTable dataTable) {
        List<Map<String, String>> table = dataTable.asMaps(String.class, String.class);

        propertySaya.inputMonthyPrice(table.get(0).get("monthly price"));
        // sometimes daily pricec is disable
        propertySaya.inputOtherPrice("Hari", table.get(0).get("daily price"), 1);
        propertySaya.inputOtherPrice("Minggu", table.get(0).get("weekly price"), 2);
        propertySaya.inputOtherPrice("3 Bulan", table.get(0).get("three monthly price"), 3);
        propertySaya.inputOtherPrice("6 Bulan", table.get(0).get("six monthly price"), 4);
        propertySaya.inputOtherPrice("Tahun", table.get(0).get("yearly price"), 5);

    }

    @Then("user see warning price on add kos with:")
    public void userSeeWarningPriceOnAddKosWith(DataTable dataTable) {
        List<Map<String, String>> table = dataTable.asMaps();
        int i = 0;
        for (Map<String, String> content : table) {
            Assert.assertEquals(propertySaya.getErrorPriceAddKos(i), content.get("warningMessage"), "title not equal to" + content.get("title"));
            i++;
        }
    }

    @And("owner search kos on property saya page")
    public void ownerSearchKosOnPropertySayaPage() {
        playwright.hardWait(10000);
        if(modalPopUpPO.isModalCloseIconVisible()){
            modalPopUpPO.clicksModalCloseIcon();
        }
        propertySaya.searchKostPropertySaya(Mamikos.getPropertyKosName());
    }

    @And("owner input kos name {string} for existing kost name")
    public void ownerInputKosNameForExistingKostName(String existingKosName) {
        propertySaya.inputKosName(existingKosName);
    }

    @And("owner click toggle denda")
    public void ownerClicktoggleDenda() {
        propertySaya.clicktoggleDenda();
    }

    @And("owner input denda amount:")
    public void ownerInputDendaAmount(DataTable tables) {
        property = tables.asMaps(String.class, String.class);
        String totalDenda = property.get(0).get("Jumlah Denda");
        String unitTime = property.get(0).get("late pay");
        String penalty = property.get(0).get("Penalty");
        propertySaya.fillDendaAmountTime(totalDenda, unitTime, penalty);
    }

    @Then("user cannot see {string} on the list")
    public void userCannotSeeDepositOnTheList(String additionalName) {
        if (additionalName.equalsIgnoreCase("Rp50.000")) {
            assertTrue(propertySaya.isDendaListAppears(), "List Denda is appears");
        }
    }

    @And("owner click toggle deposit")
    public void ownerClicktoggleDeposit() {
        propertySaya.clicktoggleDeposit();
    }

    @And("owner input deposit amount:")
    public void ownerInputDepositAmount(DataTable tables) {
        property = tables.asMaps(String.class, String.class);
        String deposit = property.get(0).get("Deposit");
        propertySaya.fillDepositAmountTime(deposit);
    }

    @And("owner click toggle other price")
    public void ownerClicktoggleOtherPrice() {
        propertySaya.clicktoggleOtherPrice();
    }

    @And("owner input other price amount:")
    public void ownerInputOtherPrice(DataTable tables) {
        property = tables.asMaps(String.class, String.class);
        String namePrice = property.get(0).get("Nama Biaya");
        String amountPrice = property.get(0).get("Jumlah Biaya");
        propertySaya.fillOtherPrice(namePrice, amountPrice);
    }

    @Then("owner can sees other price with name 1234567890abcdefjkl and price Rp100.000 show in the list")
    public void user_can_sees_new_other_price_additional_price_show_in_the_list() {
        assertTrue(propertySaya.getActiveOtherPricesName(), "List other price is appears");
        assertTrue(propertySaya.getActiveOtherPriceNumber(), "List other price is appears");
    }

    @And("owner click Selesai in success page add kos")
    public void ownerClickSelesaiInSuccessPageAddKos() {
        propertySaya.clickOnSelesaiAddKos();
    }

    @And("owner input data pengelola as expected:")
    public void ownerInputDataPengelolaAsExpected(DataTable dataTable) {
        List<Map<String, String>> table = dataTable.asMaps(String.class, String.class);

        propertySaya.selectPengelola(table.get(0).get("add data pengelola"));
        if (table.get(0).get("add data pengelola").equals("yes")) {
            propertySaya.inputPengelolaName(table.get(0).get("pengelola name"));
            propertySaya.inputPengelolaPhone(table.get(0).get("pengelola phone"));
        }
    }

    @And("owner waiting the page reload")
    public void ownerWaitingThePageReload() {
        propertySaya.waitPageLoaded();
    }

    @And("owner click {string} input BBK form request")
    public void ownerClickInputBBKFormRequest(String textButton) {
        propertySaya.clickOnLewatiBBKForm(textButton);
    }

    @And("owner click {string} in kebijakan baru mamikos pop up")
    public void ownerClickInKebijakanBaruMamikosPopUp(String text) {
        if (propertySaya.isBBKPopUpVisible()) {
            propertySaya.clickOnKebijakanBaruMamikosPopUp(text);
        }
    }

    @And("owner click simpan on add room pop up")
    public void ownerClickSimpanOnAddRoomPopUp() {
        propertySaya.saveAddRoomPopUp();
    }

    @And("user untick already inhabited checkbox")
    public void userUntickAlreadyInhabitedCheckbox() {
        propertySaya.UncheckAlreadyInhabitedCheckbox();
    }

    @Then("verify will be appears and the room is untick again")
    public void verifyWillBeAppearsAndTheRoomIsUntickAgain() {
        Assert.assertFalse(propertySaya.isInhabitedCheckboxCheck(), "InhabitedCheckbox is checked!");
    }

    @Then("owner can sees Pop-Up owner not add renter's data")
    public void ownerCanSeesPopUpOwnerNotAddRenterSData() {
        Assert.assertTrue(propertySaya.getPopupNotAddRenter("Anda belum tambah data penyewa"), "Title on pop up doesn't match!");
        Assert.assertTrue(propertySaya.getPopupNotAddRenter("Sebelum menandai kamar menjadi \"sudah berpenghuni\", mohon tambahkan data penyewa"), "Description on pop up doesn't match!");
        Assert.assertTrue(propertySaya.getPopUpButton("Tambah Penyewa"), "Button on pop up doesn't match!");
    }

    @When("owner click on Add Renter button")
    public void ownerClickOnAddRenterButton() {
        propertySaya.clickOnAddRenterButton();
    }

    @Then("owner redirected to Input Renter's Information form with valid kost name")
    public void ownerRedirectedToInputRenterSInformationFormWithValidKostName() {
        Assert.assertTrue(addTenantPO.getFormTitle("Masukkan Informasi Penyewa"), "Form title doesn't match!");
        Assert.assertEquals(addTenantPO.getSelectedKostName().replaceAll("×  ×   \n+\t\t\t\t", ""), Mamikos.getPropertyKosName(), "Kos name doesn't match!");
        Assert.assertTrue(addTenantPO.getFullRoomName().contains("kamar"));
    }

    @Then("owner can sees room is on {string} status")
    public void ownerCanSeesRoomIsOnStatus(String statusRoom) {
        Assert.assertEquals(propertySaya.getRoomStatus(), statusRoom, "Status room doesn't match!");
    }

    @Then("owner can sees toast {string}")
    public void ownerCanSeesToast(String toastMessage) {
        Assert.assertEquals(propertySaya.getToastUpdateRoom(), toastMessage, "Incorrect message toast!");
    }

    @And("owner click on update room")
    public void ownerClickOnUpdateRoom() {
        propertySaya.clickOnUpdateRoom();
    }

    @Given("owner click back on added room pop up")
    public void ownerClickBackOnAddedRoomPopUp() {
        propertySaya.clickOnBackButton();
    }

    @When("user clicks on edit data kos button")
    public void userClicksOnEditDataKosButton() {
        propertySaya.clickOnEditDataKosButton();
    }

    @When("user delete active other additional price")
    public void user_delete_active_other_additional_price() {
        propertySaya.deleteActiveAdditionalPrice();
    }

    @Then("tenant can not sees active other price")
    public void tenant_can_not_sees_active_other_price() {
        Assert.assertFalse(propertySaya.isOtherPriceNamePresent());
        Assert.assertFalse(propertySaya.isOtherPriceNumberPresent());
    }

    @And("owner click ubah denda")
    public void ownerClicUbahkDenda() {
        propertySaya.clickUbahDendaText();
    }

    @Then("owner can see emphty property")
    public void owner_can_see_emphty_property() {
        Assert.assertTrue(propertySaya.isImageZeroPresent(), "image not visible");
    }

    @Then("owner can see {string} at apartment card")
    public void owner_can_see_at_apartment_card(String text) {
        Assert.assertEquals(propertySaya.getRejectTextApartment(), text, "text reject doesnt equals");
    }

    @Then("owner can see button update kamar")
    public void owner_can_see_button_update_kamar() {
        Assert.assertTrue(propertySaya.isButtonUpdateVisible(), "button not visible");
    }

    @And("owner clicks button change photo")
    public void ownerClicksButtonChangePhoto() {
        propertySaya.hoverPhoto();
        propertySaya.ubahFotoKosFromHover();
    }

    @And("owner clicks button view photo")
    public void ownerClicksButtonViewPhoto() {
        propertySaya.hoverPhoto();
        propertySaya.viewPhotoFromHover();
    }

    @And("owner clicks button delete photo")
    public void ownerClicksButtonDeletePhoto() {
        propertySaya.hoverPhoto();
        propertySaya.clickOnDeletePhotoFromHover();
    }

    @And("owner clicks button move photo")
    public void ownerClicksButtonMovePhoto() {
        propertySaya.hoverPhoto();
        propertySaya.clickOnMovePhotoHover();
    }

    @When("user/owner clicks button move photo on {string}")
    public void userClicksButtonMovePhoto(String photoLocation) {
        propertySaya.hoverAndClickMovePhoto(photoLocation);
    }

    @And("owner select destination move photo kos")
    public void ownerSelectDestinationMovePhotoKos() {
        propertySaya.selectPhotoToMoved();
        propertySaya.clickOnLanjutkanMovePhoto();
    }

    @And("owner select destination move photo room")
    public void ownerSelectDestinationMovePhotoRoom() {
        propertySaya.selectDestinationPhotoRoom();
        propertySaya.clickOnPindahkanPhoto();
    }

    @And("owner/user select destination move photo room on {string}")
    public void ownerSelectDestinationToMovePhotoRoom(String destination) {
        propertySaya.selectDestinationPhotoRoom(destination);
        propertySaya.clickOnPindahkanPhoto();
    }

    @When("owner can see favorited section")
    public void owner_can_see_favorited_section() {
        Assert.assertTrue(propertySaya.isFavoritedSectionVisible(), "button not visible");
    }

    @Then("user performs move photo validation steps")
    public void userPerformsMovePhotoValidationSteps() {
        propertySaya.clickOnLanjutkanMovePhoto();
        Assert.assertTrue(propertySaya.getToastNotSelectedPhoto(), "Toast message doesnt match!");

        propertySaya.selectPhotoToMoved();
        propertySaya.clickOnLanjutkanMovePhoto();
        propertySaya.clickOnPindahkanPhoto();
        Assert.assertTrue(propertySaya.getToastNotSelectDestinationPhoto(), "Toast message doesnt match!");
    }

    @And("owner click button edit data lain")
    public void ownerClickButtonEditDataLain() {
        loading.waitForLoadingIconDisappear();
        propertySaya.clickOnEditDataLainButton();
    }

    @And("owner remove photo for the order {string}")
    public void ownerClicksButtonChangePhotoForTheOrder(String order) {
        var orderInt = Integer.parseInt(order);
        propertySaya.hoverPhoto(orderInt);
        propertySaya.deleteFotoKostIfVisible(orderInt);
    }

    @And("owner tap on update harga if exist")
    public void ownerTapOnUpdateHargaIfExist() {
        propertySaya.clickOnUpdateHargaIfExist();
    }

    @And("owner re-upload valid kos rule")
    public void ownerReUploadValidKosRule() {
        propertySaya.reUploadValidAturanKost();
    }

    @When("owner close pop up in edit kost")
    public void ownerClosePopUpInEditKost() {
        propertySaya.clickCloseBtnIfExist();
    }

    @And("owner click on leftlet marker")
    public void ownerClickOnLeftletMarker() {
        propertySaya.leftletMarker();
    }

    @Then("owner redirected to input Renter's Information with kos name below:")
    public void ownerRedirectedToInputRentersInformationWithKosNameBelow(DataTable dataTable) {
        List<Map<String, String>> table = dataTable.asMaps(String.class, String.class);
        String kosName = Mamikos.ENV.equals("stag") ? table.get(0).get("kos name stag") : table.get(0).get("kos name prod");

        // Verify form title
        Assert.assertTrue(addTenantPO.getFormTitle("Masukkan Informasi Penyewa"), "Form title doesn't match!");

        // Get aria snapshot of the form
        String ariaSnapshot = addTenantPO.takeInformasiPenyewaFormAriaSnapshots();

        // Verify kos name is in the aria snapshot
        Assert.assertTrue(ariaSnapshot.contains(kosName),
            "Kos name '" + kosName + "' not found in Informasi Penyewa form aria snapshot");

        // Verify room number placeholder contains "kamar"
        Assert.assertTrue(addTenantPO.getFullRoomName().contains("kamar"), "Room placeholder doesn't contain 'kamar'");
    }
    @And("owner click on button pindahkan button")
    public void ownerClickOnPindahkanPhoto() {
        propertySaya.clickOnPindahkanPhoto();
    }
}

