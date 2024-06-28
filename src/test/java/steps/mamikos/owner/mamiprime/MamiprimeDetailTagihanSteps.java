package steps.mamikos.owner.mamiprime;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.owner.mamiprime.MamiprimeDetailTagihanPO;

public class MamiprimeDetailTagihanSteps {
    Page page = ActiveContext.getActivePage();
    MamiprimeDetailTagihanPO mamiprimeDetailTagihanPO = new MamiprimeDetailTagihanPO(page);

    @Then("owner can see property name in detail tagihan mamiprime")
    public void owner_can_see_property_name_in_detail_tagihan() {
        Assert.assertEquals(mamiprimeDetailTagihanPO.getPropertyNameDetailTagihanMamiprime(),"Kost AT lagi Gedang Sari Gunung Kidul");
    }

}
