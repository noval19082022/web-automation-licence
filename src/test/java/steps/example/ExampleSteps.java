package steps.example;

import config.mamikos.Mamikos;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class ExampleSteps {
    private Map<String, String> dataTable;
    private List<Map<String, String>> dataTableList;

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
        System.out.println(dataTableList.get(0).get("email"+ Mamikos.ENV));
    }
}
