package pageobject.pms.otherTransaction;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class listOwnerExpenditurePO {
    private Page page;

    Locator expandButton;
    Locator detailSection;
    Locator lihatLampiranLink;

    public listOwnerExpenditurePO(Page page){
        this.page = page;

        expandButton = page.getByTestId("expand-toggle");
        detailSection = page.locator("tr.sub-item.is-open");
        lihatLampiranLink = page.locator("td>a");
    }

    /**
     * expand first data in owner expenditure list
     */
    public void expandFirstList() {
        expandButton.first().click();
    }

    /**
     * assert first data detail section is expand in owner expenditure list
     */
    public void assertFirstListDetailVisible() {
        assertThat(detailSection.first()).isVisible();
    }

    /**
     * click lihat lampiran at first data in owner expenditure list
     * @return list owner expenditure page
     */
    public listOwnerExpenditurePO clickFirstLihatLampiran() {
        page = page.waitForPopup(() -> {
            lihatLampiranLink.first().click();
        });
        return new listOwnerExpenditurePO(page);
    }

    /**
     * assert lampiran image is open in new tab
     */
    public void assertNewTabOpen() {
        assertThat(page).hasTitle("books-kFqUBptWHhXu.jpeg (800×566)");
    }
}
