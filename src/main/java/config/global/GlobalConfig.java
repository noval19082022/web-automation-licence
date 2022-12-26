package config.global;

import utilities.JavaHelpers;

public class GlobalConfig {
    private static final String PROPERTYFILE="src/main/resources/global-config.properties";
    public static final String ENV = JavaHelpers.getPropertyValue(PROPERTYFILE, "env");
    public static final String BROWSER_NAME = JavaHelpers.getPropertyValue(PROPERTYFILE, "browserName");
    public static final boolean HEADLESS = JavaHelpers.getPropertyValue(PROPERTYFILE, "headless").equalsIgnoreCase("true");
    public static final boolean DEV_TOOLS = JavaHelpers.getPropertyValue(PROPERTYFILE, "devTools").equalsIgnoreCase("true");
    public static final double SLOW_MO = Double.parseDouble(JavaHelpers.getPropertyValue(PROPERTYFILE, "slowMo"));
    public static final boolean SET_ACCEPT_DOWNLOAD = JavaHelpers.getPropertyValue(PROPERTYFILE, "setAcceptDownload").equalsIgnoreCase("true");
}
