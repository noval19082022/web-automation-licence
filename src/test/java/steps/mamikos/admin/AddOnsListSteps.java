package steps.mamikos.admin;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pageobject.admin.mamipay.bangkrupux.AddOnsListPO;

public class AddOnsListSteps {
    Page page = ActiveContext.getActivePage();
    AddOnsListPO addOnsListPO = new AddOnsListPO(page);

    @And("admin bangkerupux create add ons on add ons list menu")
    public void createNewAddOn() {
        addOnsListPO.createNewAddOnsAction();
    }

    @And("admin bangkerupux input name {string}, description {string}, price {string}, notes {string} and create it")
    public void adminBangkerupuxInputNameDescriptionPriceNotesAndCreateIt(String name, String description, String price, String notes) {
        addOnsListPO.inputCreateField(name, description, price, notes);
        addOnsListPO.createAddOnsAfterInputField();
    }

    @When("admin bangkerupux cancel pop all mandatory required on create add ons")
    public void adminBangkerupuxCancelPopAllMandatoryRequiredOnCreateAddOns() {
        addOnsListPO.cancelPopUp();
    }

    @And("admin bangkerupux delete add ons that has name {string}")
    public void adminBangkerupuxDeleteAddOnsThatHasName(String addOnsName) {
        addOnsListPO.deleteAddOns(addOnsName);
    }
}
