package pageobject.owner.mamiprime;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class UpdateContentPO {

    private Page page;
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);

    // Invoice List Page
    private Locator tanyaJawabOnTable;

    public UpdateContentPO(Page page) {
        this.page = page;

    }

        /**
         * Assert Tanya Jawab on table
         * @param name
         */
        public String assertTanyaJawabOnTable(String name){
            tanyaJawabOnTable = page.locator("//p[normalize-space()='"+name+"']");
            playwright.pageScrollInView(tanyaJawabOnTable);
            return playwright.getText(tanyaJawabOnTable);
        }
    }

