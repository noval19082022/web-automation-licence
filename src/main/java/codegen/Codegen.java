package codegen;

import com.microsoft.playwright.*;

import static codegen.Example.page;

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
            goToKostDetail(page, "Kos Wild Rift DOTF Tegalrejo Yogyakarta");
            page.pause();
        }
    }

    public static void goToKostDetail(Page page, String kostName) {
        page.getByText("Masukan nama lokasi/area/alamat").click();
        page.getByPlaceholder("Coba Tebet Jakarta Selatan").fill("Kos Wild Rift DOTF Tegalrejo Yogyakarta");
        page.getByTestId("suggestionBox-roomList").getByTestId("results-list__item").click();
    }
}
