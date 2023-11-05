package pageobject.xendit;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.RequestOptions;
import data.mamikos.ApiEndpoints;
import pageobject.tenant.InvoicePO;
import utilities.ApiPlaywrightHelpers;
import utilities.PlaywrightHelpers;

import java.util.HashMap;
import java.util.Map;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class XenditApiPO extends InvoicePO {
    private ApiPlaywrightHelpers apiPwHelpers;
    private PlaywrightHelpers playwrightHelpers;

    public XenditApiPO(Page page) {
        super(page);
        this.apiPwHelpers = new ApiPlaywrightHelpers(page);
        this.playwrightHelpers = new PlaywrightHelpers(page);
    }

    public void BayarAlfaViaPostman(String paymentCode, String amount) {
        Map<Object, Object> requestBody = new HashMap<>();
        requestBody.put("retail_outlet_name", "ALFAMART");
        requestBody.put("payment_code", paymentCode);
        requestBody.put("transfer_amount", amount);

        var response = apiPwHelpers.setBaseUrl(ApiEndpoints.XENDIT_BASED_API)
                .post(ApiEndpoints.XENDIT_SANDBOX_PATH_URL,
                        RequestOptions.create()
                                .setHeader("Content-Type", "application/json")
                                .setHeader("Accept", "application/json")
                                .setHeader("Authorization",
                                        ApiEndpoints.XENDIT_TOKEN)
                                .setData(requestBody));
        assertThat(response).isOK();

        var maxReload = 0;
        do {
            playwrightHelpers.reloadPage();
            maxReload++;
            if (maxReload == 5) {
                break;
            }
        } while (!playwrightHelpers.waitTillLocatorIsVisible(pembayaranBerhasilText));
    }
}
