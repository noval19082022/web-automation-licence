package data.payment;

import utilities.JavaHelpers;

public class Payment {
    public static final String PAYMENT = "src/main/resources/payment.properties";
    public static final String MANDIRI_MIDTRANS= JavaHelpers.getPropertyValue(PAYMENT, "mandiriMidtrans");
    public static final String PERMATA_MIDTRANS= JavaHelpers.getPropertyValue(PAYMENT, "permataMidtrans");
    public static final String BNI_SIMULATOR= JavaHelpers.getPropertyValue(PAYMENT, "bniSimulator");
    public static final String BRI_SIMULATOR= JavaHelpers.getPropertyValue(PAYMENT, "briMidtrans");
}
