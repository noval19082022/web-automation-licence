package steps.pms;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.pms.RoomAllotmentPO;

import java.util.List;
import java.util.Map;

public class RoomAllotmentSteps {
    Page page = ActiveContext.getActivePage();
    RoomAllotmentPO roomAllotment = new RoomAllotmentPO(page);

    private Map<String, String> OOOData;
    private List<Map<String , String>> outOfOrderFlagData;

    @And("Admin create OOO on:")
    public void admin_create_ooo_on(DataTable table) {
        OOOData = table.asMap(String.class, String.class);
        var roomNumber = OOOData.get("room number");
        var type = OOOData.get("type");
        var note = OOOData.get("note");
        var startDate = OOOData.get("start date");
        var endDate = OOOData.get("end date");
        roomAllotment.setRoomOutOfOrder(roomNumber);
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

    @And("Admin delete OOO on:")
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

    @And("Admin search {string}")
    public void admin_search_on_room_allotment(String propertyName) {
        roomAllotment.searchPropertyName(propertyName);
    }

    @Then("Admin can see out of order on:")
    public void admin_can_see_out_of_order_on(DataTable table) {
        outOfOrderFlagData = table.asMaps(String.class, String.class);
        var roomNumber = outOfOrderFlagData.get(0).get("room number");
        var startDate = outOfOrderFlagData.get(0).get("start date");
        Assert.assertTrue(roomAllotment.isOutOfOrderOnRoomVisible(roomNumber,startDate));
    }

    @Then("Admin can not see out of order on:")
    public void admin_can_not_see_out_of_order_on(DataTable table) {
        outOfOrderFlagData = table.asMaps(String.class, String.class);
        var roomNumber = outOfOrderFlagData.get(0).get("room number");
        var startDate = outOfOrderFlagData.get(0).get("start date");
        Assert.assertFalse(roomAllotment.isOutOfOrderOnRoomVisible(roomNumber,startDate));
    }

    @Then("Admin can see that save button is disable")
    public void admin_can_see_that_save_button_is_disable() {
        Assert.assertFalse(roomAllotment.isSaveButtonEnable(), "save button on modal is enable");
    }
}
