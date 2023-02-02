package utilities;

import data.mamikos.Mamikos;
import org.apache.commons.lang3.StringUtils;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class JavaHelpers {

    // --- Date and Time -- \\

    /**
     * get local date or time by it pattern
     *
     * @param pattern desired pattern e.g "dd-MM-yyyy HH:mm:ss"
     *                visit following url for pattern detail https://www.w3schools.com/java/java_date.asp
     * @return String data type
     */
    public static String getCurrentDateOrTime(String pattern) {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return localDateTime.format(dateTimeFormatter);
    }

    /**
     * Increase date from current date
     * @param pattern desired pattern e.g "dd-MM-yyyy HH:mm:ss"
     * @param plusDays increase day by integer provided
     * @param plusMonth increase month by integer provided
     * @param plusYears increase year by integer provided
     * @return String data type of costum date
     */
    public static String getCostumDateOrTime(String pattern, int plusDays, int plusMonth, int plusYears) {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime costumeDate = localDateTime.plusDays(plusDays).plusMonths(plusMonth).plusYears(plusYears);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return costumeDate.format(dateTimeFormatter);
    }
    // --- Date and Time -- \\

    // --- Get Part --- \\
    public static int getScreenHeight() {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        return (int) size.getHeight();
    }

    public static int getScreenWidth() {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        return (int) size.getWidth();
    }
    // --- Get Part --- \\

    //-- File Prop Reader -- \\
    /**
     * set properties file to be readable
     * @param filePropertiesPath path to properties file
     * @return Properties data type
     * @throws IOException
     */
    public static Properties setPropertiesFile(String filePropertiesPath) throws IOException {
        Properties p = new Properties();
        InputStream inputStream = new FileInputStream(filePropertiesPath);
        p.load(inputStream);
        return p;
    }

    /**
     * Access properties and return as Properties
     * @param propertyfile desired properties file
     * @return
     */
    public static Properties accessPropertiesFile(String propertyfile) {
        Properties prop = new Properties();
        // try retrieve data from file
        try {
            prop.load(new FileInputStream(propertyfile));
        }
        // catch exception in case properties file does not exist
        catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    /**
     * Get property file value
     * @param propertyFile property file location path
     * @param propertyName property name
     * @return String data type
     */
    public static String getPropertyValue(String propertyFile, String propertyName) {
        Properties prop = accessPropertiesFile(propertyFile);
        String variable = prop.getProperty(propertyName);
        if (variable != null) {
            return variable;
        } else {
            propertyName = StringUtils.removeEnd(propertyName, "_" + Mamikos.ENV);
            return prop.getProperty(propertyName);
        }
    }
    //-- File Prop Reader -- \\

    //-- Number--\\

    /**
     * extract number from string given
     *
     * @param word is the String that we want to extract
     *             Example : "Rp. 13.000 / bulan" > 13000
     */
    public static int extractNumber(String word) {
        String str = word.replaceAll("[A-Z a-z . / : , ' ; ( ) -]", "").trim();
        return Integer.parseInt(str);
    }
}