package pageobject.singgahsini;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import config.playwright.context.ActiveContext;
import utilities.PlaywrightHelpers;

public class SinggahsiniLandingPagePO {
    private Page page;
    PlaywrightHelpers playwright;

    private Locator menuButton;
    private Locator testimonySection;
    private Locator tentangKamiSection;
    private Locator keuntunganSection;
    private Locator tanyaJawabSection;
    private Locator tentangKamiTitle;
    private Locator tentangKamiSubtitle;
    private Locator keuntunganTitle;
    private Locator keuntunganItemsSection;
    private Locator keuntunganItemTitle;
    private Locator keuntunganItemDescription;
    private Locator testimonialTitle;
    private Locator testimonialPageBullet;
    private Locator testimoniText;
    private Locator testimoniOwnerName;
    private Locator testimoniKostName;
    private Locator nextTestimoniButton;
    private Locator tanyaJawabTitle;
    private Locator tanyaJawabQuestionText;
    private Locator tanyaJawabAnswerParagraphText;
    private Locator tanyaJawabAnswerListText;
    private Locator footerMenuButton;


    public SinggahsiniLandingPagePO(Page page){
        this.page = page;
        playwright = new PlaywrightHelpers(page);

        testimonySection = page.locator("#landingSinggahsiniTestimony");
        tentangKamiSection = page.locator("#landingSinggahsiniShortIntro");
        keuntunganSection = page.locator("#landingSinggahsiniBenefit");
        tanyaJawabSection = page.locator("#landingSinggahsiniFaq");
        tentangKamiTitle = page.locator("p.ss-title");
        tentangKamiSubtitle = page.locator("p.ss-copy");
        keuntunganTitle = page.locator("p.landing-benefit__title ");
        keuntunganItemsSection = page.locator("div.landing-benefit__item");
        keuntunganItemTitle = page.locator(".landing-benefit__item-wrapper .bg-c-text--heading-3");
        keuntunganItemDescription = page.locator("p.landing-benefit__item-subtitle");
        testimonialTitle = page.locator("#landingSinggahsiniTestimony p.section__title");
        testimonialPageBullet = page.locator("#landingSinggahsiniTestimony .swiper-pagination-bullet");
        testimoniText = page.locator("#landingSinggahsiniTestimony .swiper-slide-active p").nth(0);
        testimoniOwnerName = page.locator("#landingSinggahsiniTestimony .swiper-slide-active p").nth(1);
        testimoniKostName = page.locator("#landingSinggahsiniTestimony .swiper-slide-active p").nth(2);
        nextTestimoniButton = page.locator("div.swiper__testimony-next");
        tanyaJawabTitle = page.locator("#landingSinggahsiniFaq .bg-c-text--heading-1");
        tanyaJawabQuestionText = page.locator("div.section__qna-question");
        tanyaJawabAnswerParagraphText = page.locator(".bg-c-accordion__content p.section__qna-answer");
        tanyaJawabAnswerListText = page.locator(".bg-c-accordion__content .section__qna-answer li");
    }

    /**
     * Click Navbar Menu
     * @param menu
     */
    public void clickNavbarMenu(String menu) {
        menuButton = page.getByTestId("singgahsiniNavbarContainer").getByText(menu);

        playwright.clickOn(menuButton);
    }

    /**
     * Scroll to section
     * @param section
     */
    public void scrollToSection(String section) {
        Locator part = null;

        switch (section){
            case "Testimonial":
                part = testimonySection;
                break;

            default:
                System.out.println("invalid section");
        }
        playwright.pageScrollInView(part);
    }

    /**
     * Check is tentang kami visible or not ?
     * @return boolean
     */
    public boolean isTentangKamiVisible() {
        return playwright.isLocatorVisibleAfterLoad(tentangKamiSection,5000.0);
    }

    /**
     * Check is keuntungan section visible or not ?
     * @return boolean
     */
    public boolean isKeuntunganVisible() {
        return playwright.isLocatorVisibleAfterLoad(keuntunganSection,5000.0);
    }


    /**
     * Check is tanya jawab section visible or not
     * @return boolean
     */
    public boolean isTanyaJawabVisible() {
        return playwright.isLocatorVisibleAfterLoad(tanyaJawabSection,5000.0);
    }

    /**
     * Get Tentang Kami title
     * @return String
     */
    public String getTentangKamiTitle() {
        return playwright.getText(tentangKamiTitle);
    }

    /**
     * Get Tentang Kami subtitle
     * @return String
     */
    public String getTentangKamiSubtitle() {
        return playwright.getNormalizeText(tentangKamiSubtitle);
    }

    /**
     * Count keuntungan items
     * @return Integer
     */
    public Integer countKeuntunganItems() {
        return keuntunganItemsSection.count();
    }

    /**
     * Get Keuntungan Title
     * @return String
     */
    public String getKeuntunganTitle() {
        return playwright.getText(keuntunganTitle);
    }

    /**
     * Get Keuntungan Items Title ke-i
     * @param i index
     * @return String
     */
    public String getKeuntunganItemTitle(int i) {
        return playwright.getText(keuntunganItemTitle.nth(i));
    }

    /**
     * Get Keuntungan Description ke-i
     * @param i index
     * @return String
     */
    public String getKeuntunganItemDescription(int i) {
        return playwright.getText(keuntunganItemDescription.nth(i));
    }

    /**
     * Get testimonial Title
     * @return String
     */
    public String getTestimonialTitle() {
        return playwright.getText(testimonialTitle);
    }

    /**
     * Count testimonial page
     * @return Integer
     */
    public Integer countTestimonial() {
        return testimonialPageBullet.count();
    }

    /**
     * Get showed testimoni
     * @return String
     */
    public String getActiveTestimoni() {
        return playwright.getText(testimoniText).replaceAll("","");
    }

    /**
     * Get showed testimoni owner name
     * @return
     */
    public String getActiveOwnerTestimoni() {
        return playwright.getText(testimoniOwnerName);
    }

    /**
     * Get showed testimoni kost name
     * @return
     */
    public String getActiveKostTestimoni() {
        return playwright.getText(testimoniKostName);
    }

    /**
     * Click Next button in Testimoni section
     */
    public void clickNextTestimoni() {
        playwright.clickOn(nextTestimoniButton);
    }

    /**
     * Get Title in Tanya Jawab Section
     * @return String
     */
    public String getTanyaJawabTitle() {
        return playwright.getText(tanyaJawabTitle);
    }

    /**
     * Count FAQ
     * @return Integer
     */
    public Integer countFaq() {
        return tanyaJawabQuestionText.count();
    }

    /**
     * Get FAQ Question index ke-i
     * @param i index
     * @return String
     */
    public String getFaqQuestion(int i) {
        return playwright.getText(tanyaJawabQuestionText.nth(i));
    }

    /**
     * Get FAQ Answer using paragraph index ke-i
     * @param i index
     * @return String
     */
    public String getFaqAnswer(int i) {
        return playwright.getText(tanyaJawabAnswerParagraphText.nth(i));
    }

    /**
     * Get FAQ Answer List index ke-i
     * @param i index
     * @return String
     */
    public String getFaqAnswerList(int i) {
        return playwright.getText(tanyaJawabAnswerListText.nth(i));
    }

    /**
     * Expand FAQ Accordion
     * @param i index
     */
    public void expandFaq(int i) {
        playwright.clickOn(tanyaJawabQuestionText.nth(i));
    }

    /**
     * Click Footer Menu
     * @param menu
     */
    public void clickFooterMenu(String menu) {
        if (menu.equalsIgnoreCase("tiktok")){
            footerMenuButton = page.getByText("@singgahsini_idn").first();
        } else if (menu.equalsIgnoreCase("ig")) {
            footerMenuButton = page.getByText("@singgahsini_idn").nth(1);
        }else {
            footerMenuButton = page.getByTestId("footerTopSection").getByText(menu);
        }

        playwright.clickOn(footerMenuButton);
    }

    /**
     * Get URL in new tab
     * @return String
     */
    public String getNewTabURL() {
        playwright.hardWait(5000.0);
        String url = page.context().pages().get(1).url();
        page.context().pages().get(1).close();

        return url;
    }
}
