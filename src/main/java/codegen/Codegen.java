package codegen;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class Codegen {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            BrowserType chromium = playwright.chromium();
            // Make sure to run headed.
            Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));
            // Setup context however you like.
            BrowserContext context = browser.newContext(/* pass any options */);
            context.route("**/*", route -> route.resume());
            // Pause the page, and start recording manually.
            Page page = context.newPage();
            page.navigate("https://jambu.kerupux.com");
//            loginAdminMamipay(page);
            //goToKostDetail(page, "Kos Wild Rift DOTF Tegalrejo Yogyakarta");
            //loginOwner(page);
//            loginPMS(page);
            page.pause();
        }
    }

    public static void goToKostDetail(Page page, String kostName) {
        page.getByText("Masukan nama lokasi/area/alamat").click();
        page.getByPlaceholder("Coba Tebet Jakarta Selatan").fill("Kos Wild Rift DOTF Tegalrejo Yogyakarta");
        page.getByTestId("suggestionBox-roomList").getByTestId("results-list__item").click();
    }

    public static void loginOwner(Page page) {
        page.getByTestId("entryButton").click();
        page.getByTestId("pemilikKosButton").click();
        page.getByTestId("phoneNumberTextbox").click();
        page.getByTestId("phoneNumberTextbox").fill("089504402424");
        page.getByTestId("passwordTextbox").click();
        page.getByTestId("passwordTextbox").fill("qwerty123");
        page.getByTestId("loginButton").click();
    }

    public static void loginAdminMamipay(Page page) {
        page.navigate("https://pay-jambu.kerupux.com/pin2blkang");
        page.getByPlaceholder("Email Address").click();
        page.getByPlaceholder("Email Address").fill("automationpman03@mamikos.com");
        page.getByPlaceholder("Email Address").press("Tab");
        page.getByPlaceholder("Password").fill("qwerty123");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
    }

    public static void loginPMS(Page page){
        page.navigate("https://sini-jambu.kerupux.com/login");
        page.getByPlaceholder("Email").fill("pman@mamiteam.com");
        page.getByPlaceholder("Password").fill("pmanM4m1t34m");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
    }
}
