package data.mamikos;

import lombok.Getter;
import lombok.Setter;
import utilities.JavaHelpers;

public class Mamikos {
    private static final String MAMIKOS = "src/main/resources/mamikos.properties";

    public static final String ENV = System.getProperty("env")!=null
        ?System.getProperty("env")
        :JavaHelpers.getPropertyValue(MAMIKOS, "env");
    public static final String URL = JavaHelpers.getPropertyValue(MAMIKOS, "mainUrl_" + ENV);
    public static final String OWNER_URL = JavaHelpers.getPropertyValue(MAMIKOS, "ownerUrl_" + ENV);
    public static final String OWNER_URL_STAG = JavaHelpers.getPropertyValue(MAMIKOS, "ownerUrl_stag");
    public static final String GENERALPASSWORD = JavaHelpers.getPropertyValue(MAMIKOS, "generalPassword");
    public static final String ADMINEMAIL = JavaHelpers.getPropertyValue(MAMIKOS, "adminEmail");
    public static final String ADMINMAMIPAY = JavaHelpers.getPropertyValue(MAMIKOS, "backoffice_" + ENV);
    public static final String KOST_SAYA_BILLING = JavaHelpers.getPropertyValue(MAMIKOS, "kostSayaBilling");
    public static final String TENANT_EDIT_PROFILE = JavaHelpers.getPropertyValue(MAMIKOS,"tenantEditProfile");
    public static final String OWNER_EDIT_KOST = JavaHelpers.getPropertyValue(MAMIKOS, "ownerEditKos");
    public static final String TENANT_RIWAYAT_BOOKING = JavaHelpers.getPropertyValue(MAMIKOS, "tenantRiwayatBooking");
    public static final String KELOLA_TAGIHAN = JavaHelpers.getPropertyValue(MAMIKOS, "ownerKelolaTagihan");
    public static final String FAVORITE_PAGE = JavaHelpers.getPropertyValue(MAMIKOS, "favoritePage");
    public static final String KOST_MURAH_DIJOGJA = JavaHelpers.getPropertyValue(MAMIKOS,"kostMurahDiJogja");
    public static final String KOST = JavaHelpers.getPropertyValue(MAMIKOS, "kost");
    public static final String BOOKING = JavaHelpers.getPropertyValue(MAMIKOS, "booking");
    public static final String PROMO_KOST = JavaHelpers.getPropertyValue(MAMIKOS,"promoKost");
    public static final String HISTORY= JavaHelpers.getPropertyValue(MAMIKOS, "history");
    public static final String NOLOGIN= JavaHelpers.getPropertyValue(MAMIKOS, "nologin");
    public static final String UGM_KOST_LIST= JavaHelpers.getPropertyValue(MAMIKOS, "ugmKostList");
    public static final String PROMO_NGEBUT = JavaHelpers.getPropertyValue(MAMIKOS, "promoNgebut");
    public static final String PROMO_NGEBUT_AREA = JavaHelpers.getPropertyValue(MAMIKOS, "promoNgebutArea");
    public static final String KOST_PROMO_NGEBUT_TOP = JavaHelpers.getPropertyValue(MAMIKOS, "promoNgebutAreaTop");
    public static final String KOST_PROMO_NGEBUT_BOTTOM = JavaHelpers.getPropertyValue(MAMIKOS, "promoNgebutAreaBottom");
    public static final String ADMINBANGKRUPUX = JavaHelpers.getPropertyValue(MAMIKOS, "bangkrupux_" + ENV);
    public static final String APARTMENT = JavaHelpers.getPropertyValue(MAMIKOS, "apartment");
    public static final String PMS_URL = JavaHelpers.getPropertyValue(MAMIKOS, "PMSUrl_" + ENV);
    public static final String CHECKPROPERTY_URL = JavaHelpers.getPropertyValue(MAMIKOS, "checkPropertyUrl_" + ENV);
    public static final String Ownersini_URL = JavaHelpers.getPropertyValue(MAMIKOS, "ownersiniUrl_" + ENV);
    public static final String Singgahsini_URL = JavaHelpers.getPropertyValue(MAMIKOS, "singgahsiniUrl_" + ENV);
    public static final String LoginPemilik_URL = JavaHelpers.getPropertyValue(MAMIKOS, "logiPemilikUrl_" + ENV);
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
    public static final String TOP_UP_MAMIADS = JavaHelpers.getPropertyValue(MAMIKOS, "mamiadsBalance");
    public static final String MAMIADS_HISTORY = JavaHelpers.getPropertyValue(MAMIKOS, "mamiadsHistory");
    public static final String MAMIADS_GUIDE = JavaHelpers.getPropertyValue(MAMIKOS,"mamiadsGuide");
    public static final String MAMIADS_GUIDE_GP = JavaHelpers.getPropertyValue(MAMIKOS,"mamiadsGuideGP");
    public static final String GOLDPLUS_CONTRACT = JavaHelpers.getPropertyValue(MAMIKOS, "goldplusContract");
    public static final String KONTRAK_KERJA_SAMA = JavaHelpers.getPropertyValue(MAMIKOS, "kontrakKerjaSama");
    public static final String PROMO_MAMIKOS = JavaHelpers.getPropertyValue(MAMIKOS, "promoMamikosURL_prod");
    public static final String MAMIPAY_OWNER_LIST = JavaHelpers.getPropertyValue(MAMIKOS, "mamipayOwnerList");
    public static final String GOLDPLUS_PACKAGE = JavaHelpers.getPropertyValue(MAMIKOS, "goldplusPackage");
    public static final String GOLDPLUS_SUBMISSION_2 = JavaHelpers.getPropertyValue(MAMIKOS, "goldplusPackage2");
    public static final String GOLDPLUS_SUBMISSION_1 = JavaHelpers.getPropertyValue(MAMIKOS, "goldplusPackage1");
    public static final String MAMITOUR = JavaHelpers.getPropertyValue(MAMIKOS, "mamitour");
    public static final String HELP_MAMITOUR = JavaHelpers.getPropertyValue(MAMIKOS, "helpMamitour");
    public static final String FINANCIAL_REPORT = JavaHelpers.getPropertyValue(MAMIKOS, "financialReport");
    public static final String MAMITOUR_ORDER = JavaHelpers.getPropertyValue(MAMIKOS, "mamitourOrder");
    public static final String GOLDPLUS_PACKAGE2 = JavaHelpers.getPropertyValue(MAMIKOS, "goldplus2Package");
    public static final String FORMULIR_DATA_PENYEWA = JavaHelpers.getPropertyValue(MAMIKOS, "formulirDataPenyewa");
    public static final String STATISTIC_PPRS = JavaHelpers.getPropertyValue(MAMIKOS, "statisticPPRS") ;
    public static final String ADD_CONTRACT_TENANT = JavaHelpers.getPropertyValue(MAMIKOS, "addContractTenant");
    public static final String HOMEPAGE_LCT = JavaHelpers.getPropertyValue(MAMIKOS, "lctUrl_"+ENV);
    public static final String RULE_ENTER_KOS = JavaHelpers.getPropertyValue(MAMIKOS, "rulesEnterKos");
    public static final String MAMIPRIME_PENDAFTARAN = JavaHelpers.getPropertyValue(MAMIKOS, "mamiprimePendaftaran");
    public static final String MAMIPRIME = JavaHelpers.getPropertyValue(MAMIKOS, "mamiprime");
    public static final String MAMIPRIME_HISTORY = JavaHelpers.getPropertyValue(MAMIKOS, "historyMamiprime");
    public static final String LOGIN_USER = JavaHelpers.getPropertyValue(MAMIKOS, "loginUSer");
    public static final String MAMIPRIME_TESTING_TOOLS = JavaHelpers.getPropertyValue(MAMIKOS, "mamiprimeTestingTools");
    public static final String ADMIN_PRIME_SUGGESTION = JavaHelpers.getPropertyValue(MAMIKOS, "mamiprimeSuggestion");
    public static final String OWNER_KOS_ROOMS_PRICE = JavaHelpers.getPropertyValue(MAMIKOS, "ownerKosRoomsPrice");
    public static final String OWNER_REDIRECT = JavaHelpers.getPropertyValue(MAMIKOS, "redirectOwner_" + ENV);
    public static final String OWNER_PAGE_KOS = JavaHelpers.getPropertyValue(MAMIKOS, "ownerPageKos");
    public static final String PARTNER_PORTAL_URL = JavaHelpers.getPropertyValue(MAMIKOS, "partnerPortalUrl");


    @Setter @Getter
    private static String propertyKosName;

    @Setter @Getter
    private static String rejectReason;

    @Setter @Getter
    private static String rejectReasonTitle;

    @Setter @Getter
    private static String phoneOwner;

    @Setter @Getter
    private static String gpPackageChoosed;

    @Setter @Getter
    private static String gpPeriodeChoosed;

}
