package steps.pms;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.pms.RoomAllotmentPO;

import java.util.List;
import java.util.Map;

public class RoomAllotmentSteps {
    Page page = ActiveContext.getActivePage();
    RoomAllotmentPO roomAllotment = new RoomAllotmentPO(page);

    private Map<String, String> OooData;
    private Map<String, String> OooPopupData;
    private List<Map<String , String>> outOfOrderFlagData;

    @And("admin fill OOO data with:")
    public void admin_create_ooo_on(DataTable table) {
        OooData = table.asMap(String.class, String.class);
        var type = OooData.get("type");
        var note = OooData.get("note");
        var startDate = OooData.get("start date");
        var endDate = OooData.get("end date");
        roomAllotment.setOutOfOrderType(type);
        if (note != null) {
            roomAllotment.fillNoteOutOfOrder(note);
        }
        roomAllotment.setOutOfOrderStartDate(startDate);
        roomAllotment.setOutOfOrderEndDate(endDate);
        if (roomAllotment.isSaveButtonEnable()) {
            roomAllotment.clickSaveBtn();
        }
    }

    @And("admin edit OOO on:")
    public void admin_edit_ooo_on(DataTable table) {
        outOfOrderFlagData = table.asMaps(String.class, String.class);
        var roomNumber = outOfOrderFlagData.get(0).get("room number");
        var startDate = outOfOrderFlagData.get(0).get("start date");
        if (roomAllotment.isOutOfOrderOnRoomVisible(roomNumber, startDate)) {
            roomAllotment.clickOutOfOrderFlag(roomNumber, startDate);
            roomAllotment.clickActionOnModal();
            roomAllotment.editOutOfOrder();
        }
    }

    @And("admin delete OOO on:")
    public void admin_delete_ooo_on(DataTable table) {
        outOfOrderFlagData = table.asMaps(String.class, String.class);
        var roomNumber = outOfOrderFlagData.get(0).get("room number");
        var startDate = outOfOrderFlagData.get(0).get("start date");
        if (roomAllotment.isOutOfOrderOnRoomVisible(roomNumber, startDate)) {
            roomAllotment.clickOutOfOrderFlag(roomNumber,startDate);
            roomAllotment.clickActionOnModal();
            roomAllotment.deleteOutOfOrder();
            roomAllotment.confirmDeleteOutOfOrder();
        }
    }

    @And("admin edit start date to {string}")
    public void adminEditStarDateToX(String date) {
        roomAllotment.setOutOfOrderStartDate(date);
    }

    @Then("admin can see date {int} is disable")
    public void admincanSeeDateXIsDisable(int date) {
        roomAllotment.isSpesificEndDateDisable(date);
    }

    @And("admin search {string}")
    public void admin_search_on_room_allotment(String propertyName) {
        roomAllotment.searchPropertyName(propertyName);
    }

    @Then("admin can see out of order on:")
    public void admin_can_see_out_of_order_on(DataTable table) {
        outOfOrderFlagData = table.asMaps(String.class, String.class);
        var roomNumber = outOfOrderFlagData.get(0).get("room number");
        var startDate = outOfOrderFlagData.get(0).get("start date");
        Assert.assertTrue(roomAllotment.isOutOfOrderOnRoomVisible(roomNumber,startDate));
    }

    @Then("admin can not see out of order on:")
    public void admin_can_not_see_out_of_order_on(DataTable table) {
        outOfOrderFlagData = table.asMaps(String.class, String.class);
        var roomNumber = outOfOrderFlagData.get(0).get("room number");
        var startDate = outOfOrderFlagData.get(0).get("start date");
        Assert.assertFalse(roomAllotment.isOutOfOrderOnRoomVisible(roomNumber,startDate));
    }

    @Then("admin can see that save button is disable")
    public void admin_can_see_that_save_button_is_disable() {
        Assert.assertFalse(roomAllotment.isSaveButtonEnable(), "save button on modal is enable");
    }

    @When("admin set out of order on room {string}")
    public void admin_set_out_of_order_on_room_x(String room) {
        roomAllotment.setRoomOutOfOrder(room);
    }
    
    @Then("admin can see popup with:")
    public void adminCanSeePopupWith(DataTable table) {
        OooPopupData = table.asMap(String.class, String.class);
        var title = OooPopupData.get("title");
        var subtitle = OooPopupData.get("subtitle");
        Assert.assertEquals(roomAllotment.getTitlePopup(), title);
        Assert.assertEquals(roomAllotment.getSubtitlePopup(), subtitle);
    }

    @And("admin click on dropdown type")
    public void adminClickOnDropdownType(){
        roomAllotment.clickOnDropdowrnType();
    }

    @Then("admin validate this {string} on out of order type")
    public void adminValidateThisOnOutOfOrderType(String type){
        Assert.assertEquals(roomAllotment.getOutOfOrderType(type), type, "oo type not same");
    }
}
