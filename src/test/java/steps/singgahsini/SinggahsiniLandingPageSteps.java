package steps.singgahsini;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.singgahsini.SinggahsiniLandingPagePO;
import utilities.PlaywrightHelpers;

import java.util.List;
import java.util.Map;

public class SinggahsiniLandingPageSteps {
    Page page = ActiveContext.getActivePage();
    SinggahsiniLandingPagePO singgahsini = new SinggahsiniLandingPagePO(page);
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);

    private List<Map<String, String>> keuntungan;
    private List<Map<String, String>> testimoni;
    private List<Map<String, String>> faqQuestion;

    @When("user click header menu {string}")
    public void user_click_header_menu(String menu) {
        singgahsini.clickNavbarMenu(menu);
    }
    @When("user scroll to section {string}")
    public void user_scroll_to_section(String section) {
        singgahsini.scrollToSection(section);
    }
    @Then("page auto scroll to section {string}")
    public void page_auto_scroll_to_section(String section) {
        switch (section){
            case "Tentang Kami":
                Assert.assertTrue(singgahsini.isTentangKamiVisible());
                break;
            case "Keuntungan":
                Assert.assertTrue(singgahsini.isKeuntunganVisible());
                break;
            case "Tanya Jawab":
                Assert.assertTrue(singgahsini.isTanyaJawabVisible());
                break;
            default:
                System.out.println("Invalid section");
        }
    }
    @Then("tentang kami section title is {string}")
    public void tentang_kami_section_title_is(String title) {
        Assert.assertEquals(singgahsini.getTentangKamiTitle(),title);
    }
    @Then("tentang kami section subtitle is {string}")
    public void tentang_kami_section_subtitle_is(String subtitle) {
        Assert.assertEquals(singgahsini.getTentangKamiSubtitle(),subtitle);
    }
    @Then("keuntungan section title is {string}")
    public void keuntungan_section_title_is(String title) {
        Assert.assertEquals(singgahsini.getKeuntunganTitle(),title);
    }
    @Then("keuntungan section contains {int} items")
    public void keuntungan_section_contains_items(Integer total, DataTable tables) {
        keuntungan = tables.asMaps(String.class, String.class);

        //Assert total keuntungan
        Assert.assertEquals(singgahsini.countKeuntunganItems(),total);

        //Assert title and subtitle each keuntungan
        for (int i=0;i<singgahsini.countKeuntunganItems();i++){
            String title = keuntungan.get(i).get("Title");
            String subtitle = keuntungan.get(i).get("Subtitle");

            Assert.assertEquals(singgahsini.getKeuntunganItemTitle(i),title);
            Assert.assertEquals(singgahsini.getKeuntunganItemDescription(i),subtitle);
        }
    }

    @Then("testimonial section title is {string}")
    public void testimonial_section_title_is(String title) {
        Assert.assertEquals(singgahsini.getTestimonialTitle(),title);
    }
    @Then("testimonial section contains {int} testimoni")
    public void testimonial_section_contains_testimoni(Integer total, DataTable tables) {
        testimoni = tables.asMaps(String.class, String.class);

        //Assert total testimoni
        Assert.assertEquals(singgahsini.countTestimonial(),total);

        //Assert each testimoni
        for (int i = 0; i < singgahsini.countTestimonial(); i++) {
            String testi = testimoni.get(i).get("testimoni");
            String owner = testimoni.get(i).get("owner name");
            String kos = testimoni.get(i).get("kost name");

            Assert.assertEquals(singgahsini.getActiveTestimoni(),testi);
            Assert.assertEquals(singgahsini.getActiveOwnerTestimoni(),owner);
            Assert.assertEquals(singgahsini.getActiveKostTestimoni(),kos);

            singgahsini.clickNextTestimoni();
        }
    }
    @Then("tanya jawab section title is {string}")
    public void tanya_jawab_section_title_is(String title) {
        singgahsini.getTanyaJawabTitle();
        Assert.assertEquals(singgahsini.getTanyaJawabTitle(),title);
    }
    @Then("tanya jawab section contains {int} question")
    public void tanya_jawab_section_contains_question(Integer total, List<String> faq) {
        //Assert total faq
        Assert.assertEquals(singgahsini.countFaq(),total);

        //Assert each faq
        for (int i = 0; i < singgahsini.countFaq(); i++) {
            Assert.assertEquals(singgahsini.getFaqQuestion(i),faq.get(i));
        }
    }
    @Then("{string} FAQ answer are")
    public void faq_answer_are(String index, List<String> answer) {
        switch (index){
            case "first":
                singgahsini.expandFaq(0);
                Assert.assertEquals(singgahsini.getFaqAnswer(0),answer.get(0));
                Assert.assertEquals(singgahsini.getFaqAnswer(1),answer.get(1));
                singgahsini.expandFaq(0);
                break;
            case "second":
                singgahsini.expandFaq(1);
                Assert.assertEquals(singgahsini.getFaqAnswer(2),answer.get(0));
                Assert.assertEquals(singgahsini.getFaqAnswer(3),answer.get(1));
                singgahsini.expandFaq(1);
                break;
            case "third":
                singgahsini.expandFaq(2);
                Assert.assertEquals(singgahsini.getFaqAnswerList(0),answer.get(0));
                Assert.assertEquals(singgahsini.getFaqAnswerList(1),answer.get(1));
                Assert.assertEquals(singgahsini.getFaqAnswerList(2),answer.get(2));
                Assert.assertEquals(singgahsini.getFaqAnswerList(3),answer.get(3));
                singgahsini.expandFaq(2);
                break;
            case "fourth":
                singgahsini.expandFaq(3);
                Assert.assertEquals(singgahsini.getFaqAnswer(4),answer.get(0));
                singgahsini.expandFaq(3);
                break;
            default:
                System.out.println("Index out of bounds");
        }
    }
    @When("user click footer menu {string}")
    public void user_click_footer_menu(String menu) {
        singgahsini.clickFooterMenu(menu);
    }
    @When("user click social media link {string}")
    public void user_click_social_media_link(String link) {
        if (link.equalsIgnoreCase("Tiktok")){
            singgahsini.clickFooterMenu("tiktok");
        } else if (link.equalsIgnoreCase("Instagram")) {
            singgahsini.clickFooterMenu("ig");
        } else if (link.equalsIgnoreCase("Youtube")) {
            singgahsini.clickFooterMenu("Singgahsini by Mamikos");
        }else {
            System.out.println("Invalid social media");
        }
    }
    @Then("new tab open redirect to {string}")
    public void new_tab_open_redirect_to(String link) {
        String URL = "";
        switch (link.toLowerCase()) {
            case "tiktok":
                URL = "https://www.tiktok.com/@singgahsini_idn";
                break;
            case "instagram":
                playwright.waitTillPageLoaded();
                URL = "https://www.instagram.com/singgahsini_idn/";
                break;
            case "youtube":
                URL = "https://www.youtube.com/@singgahsini";
                break;
            case "antifraud":
                URL = "https://help.mamikos.com/post/bagaimana-agar-transaksi-saya-aman-di-mamikos";
                break;
            case "property page":
                URL = "https://sini-jambu.kerupux.com/property-detail/10872/overview";
                break;
            case "mamiprime":
                URL = "post/di-mana-saja-tempat-penayangan-kos-di-mamiprime";
                break;
            default:
                throw new IllegalArgumentException("URL Target Is Not Accepted For This Test");
        }

        if (link.equalsIgnoreCase("mamiprime")) {
            Assert.assertTrue(singgahsini.getNewTabURL().contains(URL));
        } else {
            Assert.assertEquals(singgahsini.getNewTabURL(),URL);
        }
    }
}
