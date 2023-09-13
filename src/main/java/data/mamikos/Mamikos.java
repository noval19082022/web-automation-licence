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
    public static final String PROMO_NGEBUT = JavaHelpers.getPropertyValue(MAMIKOS, "promoNgebut");
    public static final String PROMO_NGEBUT_AREA = JavaHelpers.getPropertyValue(MAMIKOS, "promoNgebutArea");
    public static final String KOST_PROMO_NGEBUT_TOP = JavaHelpers.getPropertyValue(MAMIKOS, "promoNgebutAreaTop");
    public static final String KOST_PROMO_NGEBUT_BOTTOM = JavaHelpers.getPropertyValue(MAMIKOS, "promoNgebutAreaBottom");
    public static final String ADMINBANGKRUPUX = JavaHelpers.getPropertyValue(MAMIKOS, "bangkrupux_" + ENV);
    public static final String APARTMENT = JavaHelpers.getPropertyValue(MAMIKOS, "apartment");
    public static final String PMS_URL = JavaHelpers.getPropertyValue(MAMIKOS, "PMSUrl_" + ENV);
    public static final String OWNERPAGE_KOS = JavaHelpers.getPropertyValue(MAMIKOS, "ownerKos");
    public static final String LOGIN_MAMIPAY = JavaHelpers.getPropertyValue(MAMIKOS, "loginMamipay");
    public static final String GOLDPLUS_TESTING_TOOLS = JavaHelpers.getPropertyValue(MAMIKOS, "goldplusTestingTools");
    public static final String VOUCHER_SAYA = JavaHelpers.getPropertyValue(MAMIKOS, "voucherSaya");
    public static final String SEARCH_INVOICE = JavaHelpers.getPropertyValue(MAMIKOS, "searchInvoice");
    public static final String TENANT_RIWAYAT_KOST = JavaHelpers.getPropertyValue(MAMIKOS, "tenantRiwayatKost");
    public static final String PENGAJUAN_BOOKING = JavaHelpers.getPropertyValue(MAMIKOS, "pengajuanBooking");
    public static final String ADMIN_GOLDPLUS_PACKAGE = JavaHelpers.getPropertyValue(MAMIKOS,"adminGoldplusPackage");
    public static final String PROPHOTO = JavaHelpers.getPropertyValue(MAMIKOS,"oldProPhoto");
    public static final String MAMIFOTO = JavaHelpers.getPropertyValue(MAMIKOS,"mamifoto");
    public static final String KOST_SAYA = JavaHelpers.getPropertyValue(MAMIKOS, "kostSaya");
    public static final String KONTRAK_KOST_SAYA = JavaHelpers.getPropertyValue(MAMIKOS, "kontrakKostSaya");
    public static final String MAMIPOIN_GUIDELINE = JavaHelpers.getPropertyValue(MAMIKOS, "mamipoinGuideline");
    public static final String HELP_PAGE = JavaHelpers.getPropertyValue(MAMIKOS, "helpPage");
    public static final String PENYEWA = JavaHelpers.getPropertyValue(MAMIKOS, "penyewa");
    public static final String MAMIPOIN_EXPIRED = JavaHelpers.getPropertyValue(MAMIKOS, "mamipoinExpired");
    public static final String MAMIPOIN_HISTORY = JavaHelpers.getPropertyValue(MAMIKOS, "mamipoinHistory");
    public static final String MAMIKOS_VOUCHER = JavaHelpers.getPropertyValue(MAMIKOS, "mamikosVoucher");
    public static final String OWNERPAGE_APARTEMEN = JavaHelpers.getPropertyValue(MAMIKOS, "mamikosApartemen");
    public static final String BROADCAST_CHAT = JavaHelpers.getPropertyValue(MAMIKOS, "broadcastChat");
    public static final String AKUN = JavaHelpers.getPropertyValue(MAMIKOS, "ownerSetting") ;
    public static final String PROPERTY_SAYA_APARTEMENT = JavaHelpers.getPropertyValue(MAMIKOS, "propertyApartement");
    public static final String MAMIADS = JavaHelpers.getPropertyValue(MAMIKOS, "mamiads") ;
    public static final String MAMIADS_FROM_OWNER_DASHBOARD = JavaHelpers.getPropertyValue(MAMIKOS, "mamiadsFromOwnerDashboard") ;
    public static final String CEK_PROPERTY_SEKITAR = JavaHelpers.getPropertyValue(MAMIKOS, "cekPropertySekitar") ;
}