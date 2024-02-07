package steps.example;

//import config.mamikos.Mamikos;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.Cookie;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testdata.CookiesTestData;
import utilities.PlaywrightBrowserContextHelpers;
import utilities.PlaywrightHelpers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExampleSteps {
    private Map<String, String> dataTable;
    private List<Map<String, String>> dataTableList;
    private PlaywrightBrowserContextHelpers contextHelpers = new PlaywrightBrowserContextHelpers(ActiveContext.getActiveBrowserContext());
    private Page page = ActiveContext.getActivePage();
    private PlaywrightHelpers pw = new PlaywrightHelpers(page);

    @Given("print out data table bellow:")
    public void printOutDataTableBellow(DataTable table) {
        dataTable = table.asMap(String.class, String.class);
        System.out.println(dataTable.get("phone number staging"));
        System.out.println(dataTable.get("phone number production"));
        System.out.println(dataTable.get("password"));
    }

    @When("print out data table list bellow:")
    public void printOutDataTableListBellow(DataTable table) {
        dataTableList = table.asMaps(String.class, String.class);
        System.out.println(dataTableList.get(0));
        System.out.println(dataTableList.get(0).get("emailprod"));
//        System.out.println(dataTableList.get(0).get("email"+ Mamikos.ENV));
    }

    @Then("user collected browser cookies session")
    public void userCollectedBrowserCookiesSession() {
        CookiesTestData.setCookies(contextHelpers.getCookies());
        System.out.println("Cookies list are :" + CookiesTestData.getCookies());
        for (int i = 0; i < CookiesTestData.getCookies().size(); i++) {
            System.out.println("Cookie index number: " + (i));
            System.out.println("Name : " + CookiesTestData.getCookies().get(i).name);
            System.out.println("Value : " + CookiesTestData.getCookies().get(i).value);
            System.out.println("Domain : " + CookiesTestData.getCookies().get(i).domain);
            System.out.println("Path : " + CookiesTestData.getCookies().get(i).path);
            System.out.println("Expires : " + CookiesTestData.getCookies().get(i).expires);
            System.out.println("HttpOnly : " + CookiesTestData.getCookies().get(i).httpOnly);
            System.out.println("Secure : " + CookiesTestData.getCookies().get(i).secure);
            System.out.println("SameSite : " + CookiesTestData.getCookies().get(i).sameSite);
            System.out.println();
        }
        List<Cookie> loadSavedCookies = new ArrayList<Cookie>();
        for (int i = 0; i < CookiesTestData.getCookies().size(); i++) {
            Cookie cookie = new Cookie(CookiesTestData.getCookies().get(i).name, CookiesTestData.getCookies().get(i).value);
            cookie.setDomain(CookiesTestData.getCookies().get(i).domain);
            cookie.setPath(CookiesTestData.getCookies().get(i).path);
            cookie.setExpires(CookiesTestData.getCookies().get(i).expires);
            cookie.setHttpOnly(CookiesTestData.getCookies().get(i).httpOnly);
            cookie.setSecure(CookiesTestData.getCookies().get(i).secure);
            cookie.setSameSite(CookiesTestData.getCookies().get(i).sameSite);
            loadSavedCookies.add(cookie);
        }

        for (int i = 0; i < loadSavedCookies.size(); i++) {
            System.out.println("Saved Cookies index number: " + (i));
            System.out.println("Name : " + loadSavedCookies.get(i).name);
            System.out.println("Value : " + loadSavedCookies.get(i).value);
            System.out.println("Domain : " + loadSavedCookies.get(i).domain);
            System.out.println("Path : " + loadSavedCookies.get(i).path);
            System.out.println("Expires : " + loadSavedCookies.get(i).expires);
            System.out.println("HttpOnly : " + loadSavedCookies.get(i).httpOnly);
            System.out.println("Secure : " + loadSavedCookies.get(i).secure);
            System.out.println("SameSite : " + loadSavedCookies.get(i).sameSite);
            System.out.println();
        }
    }

    @When("user use cookies to login")
    public void userUseCookiesToLogin() throws InterruptedException {
        contextHelpers.addCookies(CookiesTestData.getCookies());
        pw.reloadPage();
        Thread.sleep(30000);
    }
}
