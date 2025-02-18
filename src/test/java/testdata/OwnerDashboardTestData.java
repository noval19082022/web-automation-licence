package testdata;

import utilities.JavaHelpers;

public class OwnerDashboardTestData {
    private static final String OWNERDASHBOARD = "src/test/resources/testdata/ownerdashboard/ownerdashboard.properties";
    public static final String MAMIFOTO_INFOUNTUKANDA = JavaHelpers.getPropertyValue(OWNERDASHBOARD, "mamifotoInfoUntukAnda");
}
