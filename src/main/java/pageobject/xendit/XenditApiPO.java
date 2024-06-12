package pageobject.xendit;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.RequestOptions;
import data.mamikos.ApiEndpoints;
import lombok.extern.slf4j.Slf4j;
import pageobject.tenant.InvoicePO;
import utilities.ApiPlaywrightHelpers;
import utilities.PlaywrightHelpers;

import java.util.HashMap;
import java.util.Map;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@Slf4j
public class XenditApiPO extends InvoicePO {
    private ApiPlaywrightHelpers apiPwHelpers;
    private PlaywrightHelpers playwrightHelpers;

    public XenditApiPO(Page page) {
        super(page);
        this.apiPwHelpers = new ApiPlaywrightHelpers(page);
        this.playwrightHelpers = new PlaywrightHelpers(page);
    }

    /**
     * Processes a payment via Alfamart using Xendit API.
     * This method builds the request body with payment details, sends it to the Xendit API,
     * and verifies successful payment on the Invoice Page.
     *
     * @param paymentCode The unique payment code for this transaction.
     * @param amount      The transfer amount for the payment.
     */
    public void processPaymentAlfaViaPostman(String paymentCode, String amount) {
        Map<String, Object> requestBody = buildRequestBody("ALFAMART", paymentCode, amount);
        sendPaymentRequest(requestBody);
        verifyPaymentSuccess();
    }

    /**
     * Processes a payment via Indomaret using Xendit API.
     * This method builds the request body with payment details, sends it to the Xendit API,
     * and verifies successful payment on the Invoice Page.
     *
     * @param paymentCode The unique payment code for this transaction.
     * @param amount      The transfer amount for the payment.
     */
    public void  processPaymentIndomaretViaPostman(String paymentCode, String amount) {
        Map<String, Object> requestBody = buildRequestBody("INDOMARET", paymentCode, amount);
        sendPaymentRequest(requestBody);
        verifyPaymentSuccess();
    }

    // private method part
    // follow this order https://google.github.io/styleguide/javaguide.html#s4.8.7-modifiers
    // for readability and maintainable

    /**
     * Builds a request body for sending payment details to Xendit API.
     * This method creates a map with the following key-value pairs:
     * - "retail_outlet_name": The provided retail name
     * - "payment_code": The provided payment code
     * - "transfer_amount": The provided transfer amount
     *
     * @param retailOutletName The retail outlet name.
     * @param paymentCode      The unique payment code for this transaction.
     * @param amount           The transfer amount for the payment.
     * @return A map containing the request body data.
     */
    private Map<String, Object> buildRequestBody(String retailOutletName, String paymentCode, String amount) {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("retail_outlet_name", retailOutletName);
        requestBody.put("payment_code", paymentCode);
        requestBody.put("transfer_amount", amount);
        return requestBody;
    }

    /**
     * Sends a POST request to Xendit API with the provided request body.
     * This method sets the base URL, endpoint path, headers (Content-Type, Accept, Authorization),
     * and data (request body) for the POST request. It then sends the request and verifies a successful response (200 OK).
     * Logs the API response for debugging purposes.
     *
     * @param requestBody The map containing the request body data.
     */
    private void sendPaymentRequest(Map<String, Object> requestBody) {
        var response = apiPwHelpers.setBaseUrl(ApiEndpoints.XENDIT_BASED_API)
                .post(ApiEndpoints.XENDIT_SANDBOX_PATH_URL, // HTTP METHOD
                        RequestOptions.create()
                                .setHeader("Content-Type", "application/json")
                                .setHeader("Accept", "application/json")
                                .setHeader("Authorization",
                                        ApiEndpoints.XENDIT_TOKEN)
                                .setData(requestBody));
        log.info("api response to xendit is {}", response.status()); // Logging
        assertThat(response).isOK();
    }

    /**
     * Verifies successful payment on the Invoice Page by checking for a specific locator element.
     * This method uses Playwright helpers to reload the page if a specific locator element (pembayaranBerhasil)
     * is not visible within 6 attempts. This suggests a potential payment failure.
     */
    private void verifyPaymentSuccess() {
        playwrightHelpers.reloadPageIfElementNotVisible(6, pembayaranBerhasilText);
    }
}
