package testdata;

public class InvoiceTestData {
    private static String invoiceNumber;

    public static void setInvoiceNumber(String invoiceNumber) {
        InvoiceTestData.invoiceNumber = invoiceNumber;
    }

    public static String getInvoiceNumber() {
        return InvoiceTestData.invoiceNumber;
    }
}
