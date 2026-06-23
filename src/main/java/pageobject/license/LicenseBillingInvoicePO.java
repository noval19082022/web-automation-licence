package pageobject.license;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.PlaywrightHelpers;

public class LicenseBillingInvoicePO {

    private Page page;
    private PlaywrightHelpers playwright;

    Locator orgContextDropdown;
    Locator orgContextSearch;
    Locator orgContextList;

    Locator subscriptionSelect;
    Locator dueDateField;
    Locator validUntilField;
    Locator taxPercentField;
    Locator recipientEmailField;
    Locator noteField;
    Locator terbitkanInvoiceButton;

    // Bayar / payment flow on the billing-invoices screen
    Locator invoiceDetailModal;
    Locator invoiceDetailModalCloseButton;
    Locator bayarRowButton;
    Locator paymentModal;
    Locator paymentMethodSelect;
    Locator paymentReferenceField;
    Locator paymentProofField;
    Locator savePaymentButton;

    public LicenseBillingInvoicePO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        // Page-level org-context selector — must be set first to populate Subscription options.
        orgContextDropdown = page.locator("#org-context-dropdown");
        orgContextSearch = page.locator("#org-context-search");
        orgContextList = page.locator("#org-context-list");

        // This PO is shared between two near-identical screens:
        //   /license/billing-invoices  (Due Date → #invoice-due-date,    button → "Terbitkan Invoice")
        //   /license/proposals         (Masa Berlaku → #invoice-valid-until, button → "Terbitkan Proposal")
        // Both pages use #invoice-subscription/-tax-percent/-recipient-email/-note and
        // the same #btn-issue-invoice element id.
        subscriptionSelect = page.locator("#invoice-subscription");
        dueDateField = page.locator("#invoice-due-date");
        validUntilField = page.locator("#invoice-valid-until");
        taxPercentField = page.locator("#invoice-tax-percent");
        recipientEmailField = page.locator("#invoice-recipient-email");
        noteField = page.locator("#invoice-note");
        terbitkanInvoiceButton = page.locator("#btn-issue-invoice");

        // Bayar / payment flow.
        // After Terbitkan Invoice fires, an #invoiceDetailModal auto-opens and intercepts
        // pointer events on the table row's "Bayar" button — must dismiss before clicking.
        invoiceDetailModal = page.locator("#invoiceDetailModal");
        invoiceDetailModalCloseButton = invoiceDetailModal.locator("button[aria-label='Close'], button:has-text('Tutup')").first();
        bayarRowButton = page.locator("button[data-action='payment']").first();
        paymentModal = page.locator("#invoicePaymentModal");
        paymentMethodSelect = page.locator("#payment-method");
        paymentReferenceField = page.locator("#payment-reference");
        paymentProofField = page.locator("#payment-proof");
        savePaymentButton = page.locator("#btn-save-payment");
    }

    /**
     * Set the page-level organization context required for Subscription options to populate.
     * Opens #org-context-dropdown, types into search, clicks the matching .dropdown-item.
     * @param organization partial label, e.g. "PT.Super Smart TBK"
     */
    public void selectOrganizationContext(String organization) {
        playwright.waitTillLocatorIsVisible(orgContextDropdown, 30000.0);
        playwright.clickOn(orgContextDropdown);
        playwright.waitTillLocatorIsVisible(orgContextSearch, 10000.0);
        playwright.fill(orgContextSearch, organization);
        Locator option = orgContextList.locator(".dropdown-item")
                .filter(new Locator.FilterOptions().setHasText(organization))
                .first();
        playwright.waitTillLocatorIsVisible(option, 15000.0);
        playwright.clickOn(option);
        page.waitForLoadState();
    }

    /**
     * Case-sensitive partial label match — used because Subscription options are
     * decorated like "PT.Super Smart TBK - No Plan (MONTHLY, ...)" so the scenario
     * can reference just the org name.
     */
    private void selectByPartialLabel(Locator select, String partial) {
        Object value = select.evaluate(
                "(el, partial) => { const o = Array.from(el.options).find(o => o.textContent && o.textContent.includes(partial)); return o ? o.value : null; }",
                partial
        );
        if (value == null) {
            throw new RuntimeException("No option found containing '" + partial + "'");
        }
        select.selectOption(value.toString());
    }

    /**
     * Select Subscription by partial label.
     */
    public void selectSubscription(String subscription) {
        playwright.waitTillLocatorIsVisible(subscriptionSelect, 30000.0);
        // Wait for org-scoped options to load past the placeholder.
        page.waitForFunction("() => document.querySelector('#invoice-subscription').options.length > 1");
        selectByPartialLabel(subscriptionSelect, subscription);
    }

    /**
     * Fill Due Date input. Normalises non-padded "YYYY-M-D" to "YYYY-MM-DD" so
     * scenario data like "2026-05-9" is accepted by the HTML date input.
     */
    public void fillDueDate(String date) {
        playwright.fill(dueDateField, normalizeDate(date));
    }

    /**
     * Fill "Masa Berlaku Proposal (s/d)" input on the proposal screen.
     * Same date-normalisation behaviour as fillDueDate.
     */
    public void fillValidUntil(String date) {
        playwright.fill(validUntilField, normalizeDate(date));
    }

    private String normalizeDate(String raw) {
        if (raw == null) return null;
        String[] parts = raw.trim().split("-");
        if (parts.length != 3) return raw;
        String y = parts[0];
        String m = parts[1].length() == 1 ? "0" + parts[1] : parts[1];
        String d = parts[2].length() == 1 ? "0" + parts[2] : parts[2];
        return y + "-" + m + "-" + d;
    }

    /**
     * Fill Tax % input.
     */
    public void fillTaxPercent(String percent) {
        playwright.fill(taxPercentField, percent);
    }

    /**
     * Fill Recipient Email input.
     */
    public void fillRecipientEmail(String email) {
        playwright.fill(recipientEmailField, email);
    }

    /**
     * Fill Catatan (Note) input.
     */
    public void fillNote(String note) {
        playwright.fill(noteField, note);
    }

    /**
     * Click the "Terbitkan Invoice" button and wait for the create API call to fire.
     */
    public void clickTerbitkanInvoice() {
        try {
            page.waitForResponse(
                    response -> response.url().contains("/license/billing-invoices")
                            && (response.request().method().equalsIgnoreCase("POST")
                                    || response.request().method().equalsIgnoreCase("PUT")),
                    new Page.WaitForResponseOptions().setTimeout(20000),
                    () -> playwright.clickOn(terbitkanInvoiceButton)
            );
        } catch (com.microsoft.playwright.TimeoutError ignored) {
            // Save did not fire (validation blocked submit) — assertion later will surface failure.
        }
    }

    /**
     * Click the "Terbitkan Proposal" button (same DOM id as Terbitkan Invoice,
     * but on the /license/proposals screen) and wait for the create API call.
     */
    public void clickTerbitkanProposal() {
        try {
            page.waitForResponse(
                    response -> response.url().contains("/license/proposals")
                            && (response.request().method().equalsIgnoreCase("POST")
                                    || response.request().method().equalsIgnoreCase("PUT")),
                    new Page.WaitForResponseOptions().setTimeout(20000),
                    () -> playwright.clickOn(terbitkanInvoiceButton)
            );
        } catch (com.microsoft.playwright.TimeoutError ignored) {
            // Save did not fire (validation blocked submit) — assertion later will surface failure.
        }
    }

    /**
     * Dismiss the auto-opened invoice detail modal if it is currently shown.
     * Terbitkan Invoice automatically opens this modal which intercepts pointer
     * events on the table row's "Bayar" button.
     */
    private void dismissInvoiceDetailModalIfOpen() {
        try {
            if (invoiceDetailModal.isVisible()) {
                if (invoiceDetailModalCloseButton.isVisible()) {
                    playwright.clickOn(invoiceDetailModalCloseButton);
                } else {
                    page.keyboard().press("Escape");
                }
                page.waitForTimeout(500);
            }
        } catch (Throwable ignored) {
            // Modal may not exist on first run — safe to ignore.
        }
    }

    /**
     * Click the row-level "Lihat Bayar" button (data-action="payment") which opens
     * the #invoicePaymentModal. The auto-opened invoice detail modal is dismissed
     * first if present.
     */
    public void clickBayarButton() {
        dismissInvoiceDetailModalIfOpen();
        playwright.waitTillLocatorIsVisible(bayarRowButton, 30000.0);
        playwright.clickOn(bayarRowButton);
        playwright.waitTillLocatorIsVisible(paymentModal, 15000.0);
    }

    /**
     * Select payment Method by visible label (BANK_TRANSFER / VA / CASH / OTHER) — exact match.
     */
    public void selectPaymentMethod(String label) {
        playwright.waitTillLocatorIsVisible(paymentMethodSelect, 30000.0);
        paymentMethodSelect.selectOption(new com.microsoft.playwright.options.SelectOption().setLabel(label));
    }

    /**
     * Fill Payment Reference input.
     */
    public void fillPaymentReference(String reference) {
        playwright.fill(paymentReferenceField, reference);
    }

    /**
     * Fill Bukti Transfer input. Note: this is a TEXT input (document number / link),
     * not a file upload — placeholder is "No dokumen / link bukti".
     */
    public void fillBuktiTransfer(String proof) {
        playwright.fill(paymentProofField, proof);
    }

    /**
     * Click "Simpan Pembayaran" and wait for the payment API call.
     */
    public void clickSavePaymentButton() {
        try {
            page.waitForResponse(
                    response -> response.url().contains("/license/billing-invoices")
                            && (response.request().method().equalsIgnoreCase("POST")
                                    || response.request().method().equalsIgnoreCase("PUT")),
                    new Page.WaitForResponseOptions().setTimeout(20000),
                    () -> playwright.clickOn(savePaymentButton)
            );
        } catch (com.microsoft.playwright.TimeoutError ignored) {
            // Save did not fire (validation blocked submit).
        }
    }

    /**
     * @return true if the payment modal is currently visible — used by the
     * generic "save" step to route to the payment save instead of the issue button.
     */
    public boolean isPaymentModalActive() {
        try {
            return paymentModal.isVisible() && savePaymentButton.isVisible();
        } catch (Throwable ignored) {
            return false;
        }
    }
}
