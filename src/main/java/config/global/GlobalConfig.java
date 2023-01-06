package config.global;

import utilities.JavaHelpers;

public class GlobalConfig {
    private static final String PROPERTYFILE="src/main/resources/global-config.properties";
    public static final String ENV = JavaHelpers.getPropertyValue(PROPERTYFILE, "env");
    public static final String BROWSER_NAME = JavaHelpers.getPropertyValue(PROPERTYFILE, "browserName");
    public static final boolean HEADLESS = Boolean.parseBoolean(JavaHelpers.getPropertyValue(PROPERTYFILE, "headless"));
    public static final boolean DEV_TOOLS = Boolean.parseBoolean(JavaHelpers.getPropertyValue(PROPERTYFILE, "devTools"));
    public static final double SLOW_MO = Double.parseDouble(JavaHelpers.getPropertyValue(PROPERTYFILE, "slowMo"));
    public static final boolean SET_ACCEPT_DOWNLOAD = Boolean.parseBoolean(JavaHelpers.getPropertyValue(PROPERTYFILE, "setAcceptDownload"));
    public static final boolean SET_VIDEO_RECORD = Boolean.parseBoolean(JavaHelpers.getPropertyValue(PROPERTYFILE, "setVideoRecord"));
}
