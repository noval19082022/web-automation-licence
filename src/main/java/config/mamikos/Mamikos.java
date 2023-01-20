package config.mamikos;

import utilities.JavaHelpers;

public class Mamikos {
    private static final String MAMIKOS = "src/main/resources/mamikos.properties";
    public static final String ENV = JavaHelpers.getPropertyValue(MAMIKOS, "env");
    public static final String URL = JavaHelpers.getPropertyValue(MAMIKOS, "mainUrl_"+ ENV);
    public static final String GENERALPASSWORD = JavaHelpers.getPropertyValue(MAMIKOS, "generalPassword");
    public static final String ADMINEMAIL = JavaHelpers.getPropertyValue(MAMIKOS, "adminEmail");
    public static final String ADMINMAMIPAY = JavaHelpers.getPropertyValue(MAMIKOS, "backoffice_"+ENV);
}
