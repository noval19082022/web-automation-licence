package data.mamikos;

import utilities.JavaHelpers;

public class Mamikos {
    private static final String MAMIKOS = "src/main/resources/mamikos.properties";
    public static final String ENV = JavaHelpers.getPropertyValue(MAMIKOS, "env");
    public static final String URL = JavaHelpers.getPropertyValue(MAMIKOS, "mainUrl_" + ENV);
    public static final String OWNER_URL = JavaHelpers.getPropertyValue(MAMIKOS, "ownerUrl_" + ENV);
    public static final String GENERALPASSWORD = JavaHelpers.getPropertyValue(MAMIKOS, "generalPassword");
    public static final String ADMINEMAIL = JavaHelpers.getPropertyValue(MAMIKOS, "adminEmail");
    public static final String ADMINMAMIPAY = JavaHelpers.getPropertyValue(MAMIKOS, "backoffice_" + ENV);
    public static final String KOST_SAYA_BILLING = JavaHelpers.getPropertyValue(MAMIKOS, "kostSayaBilling");
    public static final String TENANT_EDIT_PROFILE = JavaHelpers.getPropertyValue(MAMIKOS,"tenantEditProfile");
    public static final String TENANT_RIWAYAT_BOOKING = JavaHelpers.getPropertyValue(MAMIKOS, "tenantRiwayatBooking");
    public static final String KELOLA_TAGIHAN = JavaHelpers.getPropertyValue(MAMIKOS, "ownerKelolaTagihan");
    public static final String FAVORITE_PAGE = JavaHelpers.getPropertyValue(MAMIKOS, "favoritePage");
    public static final String KOST_MURAH_DIJOGJA = JavaHelpers.getPropertyValue(MAMIKOS,"kostMurahDiJogja");
    public static final String KOST = JavaHelpers.getPropertyValue(MAMIKOS, "kost");
    public static final String BOOKING = JavaHelpers.getPropertyValue(MAMIKOS, "booking");
    public static final String PROMO_KOST = JavaHelpers.getPropertyValue(MAMIKOS,"promoKost");
    public static final String HISTORY= JavaHelpers.getPropertyValue(MAMIKOS, "history");
    public static final String UGM_KOST_LIST= JavaHelpers.getPropertyValue(MAMIKOS, "ugmKostList");


}
