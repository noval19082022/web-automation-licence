package utilities;

import data.mamikos.Mamikos;
import org.apache.commons.lang3.StringUtils;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
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

    /**
     * Get month name in English
     * @return String data type of month name.
     */
    public static String getMonthName() {
        Calendar calendar = Calendar.getInstance();
        return new DateFormatSymbols().getMonths()[calendar.get(Calendar.MONTH)];
    }

    /**
     * Get month name with locale
     * @param locale Locale type
     * @return String data type of month name.
     */
    public static String getMonthName(Locale locale){
        Calendar calendar = Calendar.getInstance();
        return new DateFormatSymbols(locale).getMonths()[calendar.get(Calendar.MONTH)];
    }

    /**
     * Get month name with locale
     * @param locale Locale type
     * @param change Increment or decrement from current month.
     * @return String data type of month name.
     */
    public static String getMonthName(Locale locale, int change) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, change);
        return new DateFormatSymbols(locale).getMonths()[calendar.get(Calendar.MONTH)];
    }

    /**
     * Get month length of days
     * @return current month length of days, will be 30, 31, 28 or 29 for Feb
     */
    public static int getMonthLength() {
        YearMonth currentYearMonth = YearMonth.now();
        return currentYearMonth.lengthOfMonth();
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

    /**
     * Update time string to required timezone time string
     *
     * @param String        actualTimeFormat Time Format for time input
     * @param String        time
     * @param String        expectedTimeFormat Time Format we want our result to be
     * @param localLanguage local language target e.g "id"
     * @param int           increamentMonth number by what we need to increment month to
     * @param int           icrementDate number by what we need to increment date to
     * @param int           increamentHour Amount of time we need to increment hour to
     * @param int           increamentMinute Amount of time we need to increment minutes to
     * @param int           increamentSeconds Amount of time we need to increment seconds
     *                      to
     * @return String converted time
     * @throws ParseException Example for date format are :
     *                        <p>
     *                        "yyyy MMM dd" for "2013 Nov 28"
     *                        <p>
     *                        "yyyyMMdd_HHmmss" for "20130131000000"
     *                        <p>
     *                        "yyyy MMM dd HH:mm:ss" for "2013 Jan 31 00:00:00"
     *                        <p>
     *                        "dd MMM yyyy" for "28 Nov 2017"
     *                        <p>
     *                        <p>
     *                        <p>
     *                        Example for time format:
     *                        <p>
     *                        "HH:mm:ss" for "16:00:00"(24 hr format)
     *                        <p>
     *                        "hh:mm:ss" for "4:00:00"(12 hr format)
     */
    public String updateTimeLocal(String actualTimeFormat,
                                  String time,
                                  String expectedTimeFormat,
                                  String localLanguage,
                                  int increamentMonth,
                                  int increamentDate,
                                  int increamentHour,
                                  int increamentMinute,
                                  int increamentSeconds
    ) throws ParseException {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        DateFormat resultDateFormat = new SimpleDateFormat(expectedTimeFormat, new Locale(localLanguage));
        Date date = new SimpleDateFormat(actualTimeFormat).parse(time + " " + year); // we're parsing current year
        // incase year not passed
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, increamentMonth);
        calendar.add(Calendar.DATE, increamentDate);
        calendar.add(Calendar.HOUR, increamentHour);
        calendar.add(Calendar.MINUTE, increamentMinute);
        calendar.add(Calendar.SECOND, increamentSeconds);
        return resultDateFormat.format(calendar.getTime());
    }

    /**
     * Get current time-stamp in given format
     *
     * @param String format e.g. "yyyy MMM dd", 'yyyyMMdd_HHmmss' etc.
     * @return String timestamp
     */
    public String getTimeStamp(String format) {
        /*
         * Example format are :
         *
         * "yyyy MMM dd" for "2013 Nov 28"
         *
         * "yyyyMMdd_HHmmss" for "20130131000000"
         *
         * "yyyy MMM dd HH:mm:ss" for "2013 Jan 31 00:00:00"
         *
         * "dd MMM yyyy" for "28 Nov 2017"
         */
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        return dateFormat.format(date);
    }

}