package steps.mamikos.owner.mamiprime;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.owner.mamiprime.MamiprimeDetailTagihanPO;

public class MamiprimeDetailTagihanSteps {
    Page page = ActiveContext.getActivePage();
    MamiprimeDetailTagihanPO mamiprimeDetailTagihanPO = new MamiprimeDetailTagihanPO(page);

    @Then("owner can see property name in detail tagihan mamiprime")
    public void owner_can_see_property_name_in_detail_tagihan() {
        Assert.assertEquals(mamiprimeDetailTagihanPO.getPropertyNameDetailTagihanMamiprime(),"Kost AT lagi Gedang Sari Gunung Kidul");
    }

    @When("owner click bayar sekarang at detail tagihan mamiprime")
    public void owner_click_bayar_sekarang_at_detail_tagihan_mamiprime() {
        mamiprimeDetailTagihanPO.clicksOnBayarSekarangButton();
    }

}
