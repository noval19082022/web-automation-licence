package data.mamikos;

import utilities.JavaHelpers;

public class ApiEndpoints {
    private static final String MAMI_API_ENDPOINTS_FILE = "src/main/resources/mamikos-endpoint.properties";
    public static final String X_GIT_TIME = JavaHelpers.getPropertyValue(MAMI_API_ENDPOINTS_FILE, "xGitTime");
    public static final String V3_PREFIX = JavaHelpers.getPropertyValue(MAMI_API_ENDPOINTS_FILE, "v3prefix");

    // ---- Tenant Block ---- //
    public static final String TENANT_PROFILE = JavaHelpers.getPropertyValue(MAMI_API_ENDPOINTS_FILE, "tenantProfile");
    // ---- Tenant Block ---- //
}
