package steps.mamikos.owner.goldplus;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.owner.goldplus.GoldPlusStatisticPO;

public class GoldplusStatisticSteps {
    Page page = ActiveContext.getActivePage();
    GoldPlusStatisticPO gpStatistic = new GoldPlusStatisticPO(page);

    @When("owner can see gp statistic header text as {string}")
    public void ownerCanSeeGpStatisticHeaderTextAs(String headerText) {
        Assert.assertEquals(gpStatistic.getGoldplusStatisticHeaderText(), headerText);
    }

    @Then("owner can see gp statistic filter text number {int} is {string}")
    public void ownerCanSeeGpStatisticFilterTextNumberNumberIs(Integer packageNumber, String packageText) {
        Assert.assertEquals(gpStatistic.getGoldPlusAvailablePackageText(packageNumber), packageText);
    }

    @Then("owner can see gp statistic list active package and it contents elements")
    public void ownerCanSeeGpStatisticListActivePackageAndItContentsElements() {
        var activePackageListNumber = gpStatistic.getActivePackageList().size();
        for(int i = 0; i < activePackageListNumber; i++) {
            Assert.assertNotNull(gpStatistic.getActivePackageListHeaderText(i), "GP Text Header is not displayed");
            Assert.assertNotNull(gpStatistic.getActivePackageListKostTitleText(i), "GP Kost Title is not displayed");
            Assert.assertNotNull(gpStatistic.getActivePackageListKostAddressText(i), "GP Kost Address is not displayed");
            Assert.assertEquals(gpStatistic.getActivePackageListKostImageAltText(i), "Foto Kos", "GP Image Alt is not displayed");
            Assert.assertEquals(gpStatistic.getActivePackageListDetailText(i), "Lihat detail statistik", "GP Lihat Detail is not displayed");
            Assert.assertEquals(gpStatistic.getActivePackageListImageAltText(i), "chevron right icon", "GP Image Alt is not displayed");
        }
    }
}
