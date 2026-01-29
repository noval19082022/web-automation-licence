package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.owner.PaidRecomendationSystemPO;



    public class PaidRecomendationSystemSteps {
        Page page = ActiveContext.getActivePage();
        PaidRecomendationSystemPO pprs = new PaidRecomendationSystemPO(page);

        @Then("owner can see section Laporan Statistik when doesnt have property active")
        public void owner_can_see_section_laporan_statistik_when_doesnt_have_property_active() {
            Assert.assertTrue(pprs.isStatisticSectionVisible(),"statistic is not show");
        }

        @Then("owner can see title {string} at section statistic")
        public void owner_can_see_title_at_section_statistic(String text) {
           Assert.assertEquals(pprs.getTitleStatisticDoesntHavePropertyActive(),text,"title doesnt match");
           Assert.assertTrue(pprs.isImagePropertyNotActiveShow(),"image not show");
        }

        @Then("owner can see desc {string} at section statistic")
        public void owner_can_see_desc_at_section_statistic(String text) {
            Assert.assertTrue(pprs.getDescDoesntHavePropertyActive().contains(text),"description doesnt match");
        }

        @When("owner navigates to statistic page")
        public void owner_navigates_to_statistic_page() {
           pprs.navigatesToStatisticPage();
        }

        @Then("owner can see Laporan Statistik page when doesnt have property active")
        public void owner_can_see_laporan_statistik_page_when_doesnt_have_property_active() {
            Assert.assertTrue(pprs.isStatisticPageVisible(),"statistic page is not show");
        }


        @Then("owner can see title for apartement  {string} at section statistic")
        public void owner_can_see_title_for_apartement_at_section_statistic(String text) {
            Assert.assertEquals(pprs.getTitleStatisticApartement(),text,"title doesnt match");
        }

        @Then("owner can see desc for apartment {string} at section statistic")
        public void owner_can_see_desc_for_apartment_at_section_statistic(String text) {
            Assert.assertTrue(pprs.getTitleStatisticDescApartement().contains(text),"description doesnt match");
        }

        @And("owner swipe next on pprs statistik")
        public void ownerSwipeLeftOnPprsStatistik() {
            pprs.tapNextPprsSlideIfExist();
        }

        @And("owner swipe previous on pprs statistik")
        public void ownerSwipePreviousOnPprsStatistik() {
            pprs.tapPreviousPprsSlideIfExist();
        }
    }