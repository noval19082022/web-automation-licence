package steps.mamikos.owner.mamiprime;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import pageobject.owner.mamiprime.UpdateContentPO;

import java.util.List;
import java.util.Map;

public class UpdateContentSTEP {
    Page page = ActiveContext.getActivePage();
    UpdateContentPO updateContent = new UpdateContentPO(page);

    private List<Map<String, String>> tanyaJawab;


    @Then("{string} are displayed in the biaya tambahan table")
    public void are_displayed_in_the_biaya_tambahan_table(String name, DataTable tables) {
        String tanyaJawabTable = "";
        Integer row = 0;
        tanyaJawab = tables.asMaps();
        if (name.equalsIgnoreCase("Tanya Jawab")) {
            for (int i = 0; i < 9; i++) {
                tanyaJawabTable = tanyaJawab.get(i).get("Tanya Jawab");
                updateContent.assertTanyaJawabOnTable(tanyaJawabTable);
            }
        }
    }
}
