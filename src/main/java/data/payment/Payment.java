package data.payment;

import utilities.JavaHelpers;

public class Payment {
    public static final String PAYMENT = "src/main/resources/payment.properties";
    public static final String MANDIRI_MIDTRANS= JavaHelpers.getPropertyValue(PAYMENT, "mandiriMidtrans");
}
