package steps.pms.homepage.additionalFeePMSKK;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.pms.homepage.additionalFeePMSKK.AdditionalFeePMSKKPO;
import pageobject.pms.homepage.additionalFeePMSKK.DeleteAdditionalFeePMSKKPO;

public class DeleteAdditionalFeePMSKKSteps {
    Page page = ActiveContext.getActivePage();
    DeleteAdditionalFeePMSKKPO deleteAdditionalFeePMSKK = new DeleteAdditionalFeePMSKKPO(page);
    AdditionalFeePMSKKPO additionalFeePMSKK = new AdditionalFeePMSKKPO(page);

    @When("admin delete additional fee in General Level")
    public void admin_delete_additional_fee_in_General_Level(){
        int totalRow = additionalFeePMSKK.getTotalRow();

        for (int i=0; i<totalRow; i++){
            if (additionalFeePMSKK.isKebabBtnVisible()){
                deleteAdditionalFeePMSKK.clicksKebabBtn();
                deleteAdditionalFeePMSKK.clicksHapusBtn();
                deleteAdditionalFeePMSKK.clicksHapusBtnInPopUp();
                deleteAdditionalFeePMSKK.reloadKontrakKerjaSamaPage();
            } else {
                break;
            }
        }
    }

    @Then("additional fee is deleted from Biaya Tambahan table")
    public void additional_fee_is_deleted_from_Biaya_Tambahan_table(){
        Assert.assertFalse(deleteAdditionalFeePMSKK.isAdditionalFeeVisible(), "Additional Fee still visible!");
    }
}