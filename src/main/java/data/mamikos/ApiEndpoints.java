package data.mamikos;

import utilities.JavaHelpers;

public class ApiEndpoints {
    private static final String MAMI_API_ENDPOINTS_FILE = "src/main/resources/mamikos-endpoint.properties";

    public static final String BAKPAO = JavaHelpers.getPropertyValue(MAMI_API_ENDPOINTS_FILE, "bakpao");
    public static final String X_GIT_TIME = JavaHelpers.getPropertyValue(MAMI_API_ENDPOINTS_FILE, "xGitTime");
    public static final String V1_PREFIX = JavaHelpers.getPropertyValue(MAMI_API_ENDPOINTS_FILE, "v1prefix");
    public static final String V3_PREFIX = JavaHelpers.getPropertyValue(MAMI_API_ENDPOINTS_FILE, "v3prefix");
    public static final String GARUDA = JavaHelpers.getPropertyValue(MAMI_API_ENDPOINTS_FILE, "garuda");

    // ---- Tenant Block ---- //
    public static final String CREATE_DEVICE_ID = JavaHelpers.getPropertyValue(MAMI_API_ENDPOINTS_FILE, "createDeviceId");
    public static final String TENANT_PROFILE = JavaHelpers.getPropertyValue(MAMI_API_ENDPOINTS_FILE, "tenantProfile");
    public static final String TENANT_BOOKING_LIST = JavaHelpers.getPropertyValue(MAMI_API_ENDPOINTS_FILE, "tenantBookingList");
    public static final String TENANT_BATALKAN_BOOKING_REASON = JavaHelpers.getPropertyValue(MAMI_API_ENDPOINTS_FILE, "tenantBatalkanBookingReason");
    public static final String TENANT_BATALKAN_BOOKING = JavaHelpers.getPropertyValue(MAMI_API_ENDPOINTS_FILE, "tenantBatalkanBooking");
    public static final String TENANT_LOGIN = JavaHelpers.getPropertyValue(MAMI_API_ENDPOINTS_FILE, "tenantLogin");
    // ---- Tenant Block ---- //

    // ---- Owner Block ---- //
    public static final String OWNER_LOGIN = JavaHelpers.getPropertyValue(MAMI_API_ENDPOINTS_FILE, "ownerLogin");
    // ---- Owner Block ---- //
}
