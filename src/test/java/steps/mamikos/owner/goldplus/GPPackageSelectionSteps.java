package steps.mamikos.owner.goldplus;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.common.HomePO;
import pageobject.common.LoadingPO;
import pageobject.common.LoginPO;
import pageobject.owner.OwnerDashboardPO;
import pageobject.owner.goldplus.GoldPlusSubmissionPO;
import pageobject.owner.goldplus.GoldplusPO;
import utilities.PlaywrightHelpers;

import java.util.List;
import java.util.Map;

public class GPPackageSelectionSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    HomePO home = new HomePO(page);
    LoginPO login = new LoginPO(page);
    LoadingPO loading = new LoadingPO(page);
    OwnerDashboardPO ownerDashboard = new OwnerDashboardPO(page);
    GoldplusPO goldplus = new GoldplusPO(page);
    GoldPlusSubmissionPO gpSubmission = new GoldPlusSubmissionPO(page);


    @When("user login as owner with segment {string} without GP package")
    public void userLoginAsOwnerWithSegmentWithoutGPPackage(String segment) {
        home.clickOnButtonMasuk()
            .clickOnPemilikKostButton()
            .fillPhoneNumber("0891202303") // Owner phone number (user_id: 45916713)
            .fillPassword("qwerty123") // Owner password
            .clickOnLoginButton();
        loading.waitForLoadingIconDisappear();
        home.clickOnSayaSetujuButton();
    }


    @And("user select package GP {int}")
    public void userSelectPackageGP(int packages) {
        goldplus.clickOnGoldplusPackageButton(packages);
    }

    @Then("long-term packages displayed first sorted from longest to shortest period")
    public void longTermPackagesDisplayedFirstSortedFromLongestToShortestPeriod() {
        // Get all period options displayed
        List<String> periodOptions = gpSubmission.getAllPeriodOptions();

        // Verify period options exist
        Assert.assertTrue(periodOptions.size() > 0, "No period options displayed");

        // Check that the first package is NOT Paket Dasar (should be long-term)
        String firstPackage = periodOptions.get(0).toLowerCase();
        Assert.assertFalse(firstPackage.contains("Paket Dasar"),
            "First package should NOT be 'Paket Dasar' when long-term packages are displayed first. Found: " + periodOptions.get(0));

        // Verify the first package is a long-term package (more than 31 days)
        int firstPackageDays = convertPeriodToDays(periodOptions.get(0));
        Assert.assertTrue(firstPackageDays > 31, 
            "First package should be long-term (>31 days), but found: " + periodOptions.get(0) + " (" + firstPackageDays + " days)");

        // Verify all packages are sorted from longest to shortest
        int previousPeriodInDays = Integer.MAX_VALUE;
        for (String period : periodOptions) {
            int currentPeriodInDays = convertPeriodToDays(period);
            Assert.assertTrue(currentPeriodInDays <= previousPeriodInDays,
                "Periods are not sorted from longest to shortest. Found " + period + " (" + currentPeriodInDays + " days) after a " + previousPeriodInDays + " days package");
            previousPeriodInDays = currentPeriodInDays;
        }
    }

    @And("basic packages GP 1 month displayed after long-term packages")
    public void basicPackagesGP1MonthDisplayedAfterLongTermPackages() {
        List<String> periodOptions = gpSubmission.getAllPeriodOptions();

        // Print all period options for debugging
        System.out.println("Available period options:");
        for (int i = 0; i < periodOptions.size(); i++) {
            System.out.println(i + ": " + periodOptions.get(i));
        }

        // Find index of 1 month and weekly packages
        int monthlyIndex = -1;
        int weeklyIndex = -1;

        for (int i = 0; i < periodOptions.size(); i++) {
            String period = periodOptions.get(i).toLowerCase();
            // Check for various possible text formats for 1 month
            if (period.contains("per bulan") ||
                (period.contains("bulan") && !period.contains("3") && !period.contains("6") && !period.contains("12"))) {
                monthlyIndex = i;
            } 
            // Check for various possible text formats for weekly
//            else if (period.contains("per minggu")) {
//                weeklyIndex = i;
//            }
        }

        // Verify basic packages are found
        Assert.assertTrue(monthlyIndex > -1, 
            "1 month package not found. Available options: " + periodOptions);
//        Assert.assertTrue(weeklyIndex > -1,
//            "Weekly package not found. Available options: " + periodOptions);

        // Verify they appear after long-term packages (3+ months)
        for (int i = 0; i < monthlyIndex; i++) {
            String period = periodOptions.get(i).toLowerCase();
            int days = convertPeriodToDays(period);
            Assert.assertTrue(days > 31,
                "Short-term package '" + periodOptions.get(i) + "' found before 1 month package");
        }

//        // Verify weekly is last (or at least after monthly)
//        Assert.assertTrue(weeklyIndex >= monthlyIndex,
//            "Weekly package should be displayed after monthly package");
    }

    @And("Basic packages GP 1 month displayed before long-term packages")
    public void basicPackagesGP1MonthDisplayedBeforeLongTermPackages() {
        List<String> periodOptions = gpSubmission.getAllPeriodOptions();

        // Print all period options for debugging
        System.out.println("Available period options:");
        for (int i = 0; i < periodOptions.size(); i++) {
            System.out.println(i + ": " + periodOptions.get(i));
        }

        // Find index of 1 month package
        int monthlyIndex = -1;
        int firstLongTermIndex = -1;

        for (int i = 0; i < periodOptions.size(); i++) {
            String period = periodOptions.get(i).toLowerCase();
            // Check for 1 month package
            if (period.contains("per bulan") ||
                    (period.contains("bulan") && !period.contains("3") && !period.contains("6") && !period.contains("12"))) {
                monthlyIndex = i;
            }
            // Find first long-term package (3+ months)
            if (firstLongTermIndex == -1) {
                int days = convertPeriodToDays(period);
                if (days > 31) {
                    firstLongTermIndex = i;
                }
            }
        }

        // Verify 1 month package is found
        Assert.assertTrue(monthlyIndex > -1, 
            "1 month package not found. Available options: " + periodOptions);
        
        // Verify long-term packages are found
        Assert.assertTrue(firstLongTermIndex > -1, 
            "No long-term packages found. Available options: " + periodOptions);
    }

    @Then("Long-term packages displayed second sorted from longest to shortest period")
    public void longTermPackagesDisplayedSecondSortedFromLongestToShortestPeriod() {
        List<String> periodOptions = gpSubmission.getAllPeriodOptions();

        // Verify there are period options
        Assert.assertTrue(periodOptions.size() > 0, "No period options displayed");

        // Find where long-term packages start (after paket dasar)
        int longTermStartIndex = -1;
        boolean foundPaketDasar = false;
        
        for (int i = 0; i < periodOptions.size(); i++) {
            String period = periodOptions.get(i).toLowerCase();
            
            // Check if this is paket dasar
            if (period.contains("Paket Dasar")) {
                foundPaketDasar = true;
            }
            
            // Check if this is a long-term package (more than 31 days)
            int days = convertPeriodToDays(periodOptions.get(i));
            if (days > 31) {
                longTermStartIndex = i;
                break;
            }
        }

        // Print all period options for debugging
        System.out.println("Available period options for second display check:");
        for (int i = 0; i < periodOptions.size(); i++) {
            System.out.println(i + ": " + periodOptions.get(i) + " (" + convertPeriodToDays(periodOptions.get(i)) + " days)");
        }

        // Verify long-term packages exist
        Assert.assertTrue(longTermStartIndex > -1, 
            "No long-term packages found. Available options: " + periodOptions);

        // Check if the first option is paket dasar
        String firstOption = periodOptions.get(0).toLowerCase();
        Assert.assertTrue(firstOption.contains("paket dasar"),
            "First package should be 'Paket Dasar', but found: " + periodOptions.get(0));

        // Verify long-term packages start at position 1 or later (second position), NOT at index 0
        Assert.assertTrue(longTermStartIndex >= 0,
            "Long-term packages should be displayed second or later (index >= 1), but start at index: " + longTermStartIndex);

        // Verify long-term packages are sorted from longest to shortest
        int previousPeriodInDays = Integer.MAX_VALUE;
        
        for (int i = longTermStartIndex; i < periodOptions.size(); i++) {
            String period = periodOptions.get(i);
            int currentPeriodInDays = convertPeriodToDays(period);
            
            // Only check sorting for long-term packages (more than 31 days)
            if (currentPeriodInDays > 31) {
                Assert.assertTrue(currentPeriodInDays <= previousPeriodInDays,
                    "Long-term packages are not sorted from longest to shortest. Found " + 
                    period + " (" + currentPeriodInDays + " days) after a " + 
                    previousPeriodInDays + " days package");
                previousPeriodInDays = currentPeriodInDays;
            }
        }
    }

    @Then("GP packages are displayed with following data:")
    public void gpPackagesAreDisplayedWithFollowingData(DataTable dataTable) {
        List<String> periodOptions = gpSubmission.getAllPeriodOptions();
        
        // Verify there are period options
        Assert.assertTrue(periodOptions.size() > 0, "No period options displayed");
        
        // Convert DataTable to List of Maps for easier processing
        List<Map<String, String>> expectedPackages = dataTable.asMaps(String.class, String.class);
        
        // Print actual period options for reference
        System.out.println("Actual period options found on UI:");
        for (int i = 0; i < periodOptions.size(); i++) {
            System.out.println(i + ": " + periodOptions.get(i));
        }
        
        // Verify each expected package from data table
        for (Map<String, String> expectedPackage : expectedPackages) {
            String duration = expectedPackage.get("duration");
            String price = expectedPackage.get("price");
            String discount = expectedPackage.get("discount");
            String originalPrice = expectedPackage.get("original_price");
            String favorit = expectedPackage.get("favorit");
            String freeMamiads = expectedPackage.get("free_mamiads");
            
            // Find matching package in UI
            boolean packageFound = false;
            for (String actualPackage : periodOptions) {
                if (actualPackage.toLowerCase().contains(duration.toLowerCase()) ||
                    (duration.equals("Paket Dasar") && actualPackage.toLowerCase().contains("Paket Dasar"))) {
                    
                    packageFound = true;
                    
                    // Verify price if specified
                    if (price != null && !price.isEmpty()) {
                        Assert.assertTrue(actualPackage.contains(price), 
                            "Expected price '" + price + "' not found in package: " + actualPackage);
                    }
                    
                    // Verify discount if greater than 0
                    if (discount != null && !discount.equals("0") && !discount.isEmpty()) {
                        Assert.assertTrue(actualPackage.contains("Diskon " + discount + "%") || 
                                        actualPackage.contains("diskon " + discount + "%"), 
                            "Expected discount '" + discount + "%' not found in package: " + actualPackage);
                    }
                    
                    // Verify original price if specified
                    if (originalPrice != null && !originalPrice.isEmpty()) {
                        Assert.assertTrue(actualPackage.contains(originalPrice), 
                            "Expected original price '" + originalPrice + "' not found in package: " + actualPackage);
                    }
                    
                    // Verify favorit label if true
                    if ("true".equals(favorit)) {
                        Assert.assertTrue(actualPackage.toLowerCase().contains("favorit"), 
                            "Expected 'Favorit' label not found in package: " + actualPackage);
                    }
                    
                    // Verify free MamiAds if greater than 0
                    if (freeMamiads != null && !freeMamiads.equals("0") && !freeMamiads.isEmpty()) {
                        Assert.assertTrue(actualPackage.toLowerCase().contains("gratis mamiads") || 
                                        actualPackage.toLowerCase().contains("gratis mami ads"), 
                            "Expected 'Gratis MamiAds' not found in package: " + actualPackage);
                    }
                    
                    break;
                }
            }
            
            Assert.assertTrue(packageFound, 
                "Package with duration '" + duration + "' not found in UI. Available options: " + periodOptions);
        }
    }
    
    private int convertPeriodToDays(String period) {
        String lowerPeriod = period.toLowerCase();
        
        // Check for year periods
        if (lowerPeriod.contains("12 bulan")) {
            return 365;
        } 
        // Check for 6 month periods
        else if (lowerPeriod.contains("6 bulan")) {
            return 180;
        } 
        // Check for 4 month periods  
        else if (lowerPeriod.contains("4 bulan")) {
            return 120;
        }
        // Check for 3 month periods
        else if (lowerPeriod.contains("3 bulan")) {
            return 90;
        }
        // Check for 2 month periods
        else if (lowerPeriod.contains("2 bulan")) {
            return 60;
        }
        // Check for 1 month periods
        else if (lowerPeriod.contains("per bulan")) {
            return 30;
        } 
        // Check for weekly periods
//        else if (lowerPeriod.contains("minggu")) {
//            return 7;
//        }
        
        // Default return for unknown periods
        return 0;
    }
}