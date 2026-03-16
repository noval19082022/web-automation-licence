package utilities;

import com.microsoft.playwright.options.Cookie;
import data.mamikos.Mamikos;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaHelpers {
    private static final String[] SYLLABLES = {"al", "be", "co", "da", "el", "fa", "go", "ha", "in", "jo"};

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
     *
     * @param pattern   desired pattern e.g "dd-MM-yyyy HH:mm:ss"
     * @param plusDays  increase day by integer provided
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
     *
     * @return String data type of month name.
     */
    public static String getMonthName() {
        Calendar calendar = Calendar.getInstance();
        return new DateFormatSymbols().getMonths()[calendar.get(Calendar.MONTH)];
    }

    /**
     * Get the current time in server and round it to the nearest 30-minute interval.
     * The rounding follows this rule:
     * - Minutes < 15 → Round down to "HH:00"
     * - Minutes between 15-44 → Round to "HH:30"
     * - Minutes ≥ 45 → Round up to the next hour "HH:00"
     *
     * @return String representation of the rounded time in "HH:mm" format.
     */
    public static String getCurrentTimeServerForSurvey() {
        // Get current time in Server Time
        LocalTime now = LocalTime.now();

        // Round to the nearest 30-minute interval
        int minutes = now.getMinute();
        int roundedMinutes = (minutes < 15) ? 0 : (minutes < 45) ? 30 : 0;
        LocalTime roundedTime = now.withMinute(roundedMinutes).withSecond(0);
        if (minutes >= 45) {
            roundedTime = roundedTime.plusHours(1); // Move to the next hour if minutes >= 45
        }

        // Format the time as HH:mm
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return roundedTime.format(formatter);
    }

    /**
     * Get the current time in GMT+7 and round it to the nearest 30-minute interval.
     * The rounding follows this rule:
     * - Minutes < 15 → Round down to "HH:00"
     * - Minutes between 15-44 → Round to "HH:30"
     * - Minutes ≥ 45 → Round up to the next hour "HH:00"
     *
     * @return String representation of the rounded time in "HH:mm" format.
     */
    public static String getCurrentTimeGMT7ForSurvey() {
        // Get current time in GMT+7
        LocalTime now = LocalTime.now(ZoneId.of("Asia/Bangkok"));

        // Round to the nearest 30-minute interval
        int minutes = now.getMinute();
        int roundedMinutes = (minutes < 15) ? 0 : (minutes < 45) ? 30 : 0;
        LocalTime roundedTime = now.withMinute(roundedMinutes).withSecond(0);
        if (minutes >= 45) {
            roundedTime = roundedTime.plusHours(1); // Move to the next hour if minutes >= 45
        }

        // Format the time as HH:mm
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return roundedTime.format(formatter);
    }


    /**
     * Get the current time in GMT+7 and modify it by adding or subtracting minutes.
     *
     * @param minutesOffset The number of minutes to add (positive) or subtract (negative).
     * @return String representation of the modified time in "HH:mm" format.
     */
    public static String getModifiedTimeGMT7(int minutesOffset) {
        // Get current time in GMT+7
        LocalTime now = LocalTime.now(ZoneId.of("Asia/Bangkok"));

        // Modify time by adding/subtracting minutes
        LocalTime modifiedTime = now.plusMinutes(minutesOffset);

        // Format the time as "HH:mm"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return modifiedTime.format(formatter);
    }

    /**
     * Compare two time strings in "HH:mm" format.
     *
     * @param time1 First time string (e.g., "08:00").
     * @param time2 Second time string (e.g., "07:30").
     * @return 1 if time1 > time2, -1 if time1 < time2, 0 if they are equal.
     */
    public static int compareTimes(String time1, String time2) {
        // Define time formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        // Parse time strings into LocalTime objects
        LocalTime t1 = LocalTime.parse(time1, formatter);
        LocalTime t2 = LocalTime.parse(time2, formatter);

        // Compare times
        return t1.compareTo(t2);
    }

    /**
     * Check if time1 is greater than time2 (time1 > time2).
     *
     * @param time1 First time string in "HH:mm" format (e.g., "08:00").
     * @param time2 Second time string in "HH:mm" format (e.g., "07:30").
     * @return true if time1 is after time2, false otherwise.
     */
    public static boolean isTimeGreater(String time1, String time2) {
        // Define time formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        // Parse time strings into LocalTime objects
        LocalTime t1 = LocalTime.parse(time1, formatter);
        LocalTime t2 = LocalTime.parse(time2, formatter);

        // Compare times and return boolean result
        return t1.isAfter(t2);
    }

    /**
     * generate random name
     *
     * @param length
     * @return
     */
    public static String generateRandomName(int length) {
        Random random = new Random();
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < length; i++) {
            name.append(SYLLABLES[random.nextInt(SYLLABLES.length)]);
        }
        return name.substring(0, 1).toUpperCase() + name.substring(1); // Capitalize first letter
    }

    /**
     * Generates a random phone number string that always starts with "08".
     *
     * @param length the total length of the phone number (must be greater than 2)
     * @return a numeric string of the specified length, prefixed with "08"
     *
     * @example
     * String phone = RandomPhoneNumber(12); // e.g. "081234567890"
     */
    public static String RandomPhoneNumber(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        // Always start with "08"
        sb.append("08");

        // Generate remaining (length - 2) random digits
        for (int i = 0; i < length - 2; i++) {
            sb.append(random.nextInt(10)); // Appends a digit 0-9
        }

        return sb.toString();
    }

    /**
     * Get month name with locale
     *
     * @param locale Locale type
     * @return String data type of month name.
     */
    public static String getMonthName(Locale locale) {
        Calendar calendar = Calendar.getInstance();
        return new DateFormatSymbols(locale).getMonths()[calendar.get(Calendar.MONTH)];
    }

    /**
     * Get month name with locale
     *
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
     *
     * @return current month length of days, will be 30, 31, 28 or 29 for Feb
     */
    public static int getMonthLength() {
        YearMonth currentYearMonth = YearMonth.now();
        return currentYearMonth.lengthOfMonth();
    }

    public static String extractDateFromString(String inputString) {
        String regexPattern = "\\b(?:\\d{4}-(?:\\d{1,2}|\\p{Alpha}{3,}|\\p{Alpha}{4})-(?:\\d{1,2}|\\p{Alpha}{3,}|\\p{Alpha}{4})|\\d{1,2}-(?:\\d{1,2}|\\p{Alpha}{3,}|\\p{Alpha}{4})-(?:\\d{4}|\\p{Alpha}{3,}|\\p{Alpha}{4})|(?:\\d{1,2}|\\p{Alpha}{3,}|\\p{Alpha}{4})-(?:\\d{1,2}|\\p{Alpha}{3,}|\\p{Alpha}{4})-\\d{4}|\\d{1,2}-(?:\\p{Alpha}{3,}|\\p{Alpha}{4})-\\d{4}|\\d{1,2}-(?:\\p{Alpha}{3,})-(?:\\d{4})|\\d{1,2}\\s+(?:\\p{Alpha}{3,})\\s+\\d{4})\\b";


        Pattern regex = Pattern.compile(regexPattern);
        Matcher matcher = regex.matcher(inputString);

        try {
            if (matcher.find()) {
                return matcher.group().split(",")[0];
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "No date format found on the string provided :" + inputString;
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
     *
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
     *
     * @param propertyfile desired properties file
     * @return Properties data type
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
     *
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
     * extract number from string given
     *
     * @param baseString    is the String that we want to extract
     * @param targetString  is the String that we want to replace
     * @param replaceString is the String that we want to replace with
     * @return
     */
    public static String formatString(String baseString, String targetString, String replaceString) {
        return baseString.replace(targetString, replaceString);
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

    /**
     * Update time string to required timezone time string
     *
     * @param String actualTimeFormat Time Format for time input
     * @param String time
     * @param String expectedTimeFormat Time Format we want our result to be
     * @param int    icrementDate number by what we need to increment date to
     * @param int    increamentHour Amount of time we need to increment hour to
     * @param int    increamentMinute Amount of time we need to increment minutes to
     * @param int    increamentSeconds Amount of time we need to increment seconds
     *               to
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
    public String updateTime(String actualTimeFormat,
                             String time,
                             String expectedTimeFormat,
                             int increamentDate,
                             int increamentHour,
                             int increamentMinute,
                             int increamentSeconds
    ) throws ParseException {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        DateFormat resultDateFormat = new SimpleDateFormat(expectedTimeFormat);
        Date date = new SimpleDateFormat(actualTimeFormat).parse(time + " " + year); // we're parsing current year
        // incase year not passed
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, increamentDate);
        calendar.add(Calendar.HOUR, increamentHour);
        calendar.add(Calendar.MINUTE, increamentMinute);
        calendar.add(Calendar.SECOND, increamentSeconds);
        return resultDateFormat.format(calendar.getTime());
    }

    //--- String Manipulator ---//

    /**
     * Format string
     *
     * @param format String to format
     * @param args   format args
     * @return String data type
     */
    public static String formatString(String format, Object... args) {
        return String.format(format, args);
    }

    /**
     * Remove extra new line and trim
     *
     * @param removeLineString
     * @return String data type
     */
    public static String removeExtraNewLine(String removeLineString) {
        return removeLineString.replaceAll("[\\r\\n\\t]+", " ").replaceAll("\\s+", " ").trim();
    }

    /**
     * Normalize aria snapshot by removing extra whitespace and standardizing format
     *
     * @param snapshot The aria snapshot string to normalize
     * @return Normalized string
     */
    public static String normalizeAriaSnapshot(String snapshot) {
        return snapshot.trim()
                .replaceAll("\\s+", " ")
                .replaceAll("\\n", "")
                .replaceAll("\\r", "");
    }
    //--- String Manipulator ---//

    /**
     * Generate random Alphanumeric String
     *
     * @param totalChar is total character of generated String
     * @return String random alphanumeric
     */
    public String generateAlphanumeric(int totalChar) {
        return RandomStringUtils.randomAlphanumeric(totalChar);
    }

    /**
     * get string after char
     *
     * @param stringTarget
     * @param character
     * @return example, you have "aba - aka" and you want get string after "-"
     * then use this method will return "aka"
     */
    public static String getStringAfterSpecificChar(String stringTarget, String character) {
        // Find the index of the character
        int indexOfDot = stringTarget.indexOf(character);
        // Extract the substring after the character
        String result = stringTarget.substring(indexOfDot + 1).trim();
        return result;
    }

    /**
     * remove specific char or word on string and also trim it
     *
     * @param stringTarget
     * @param character
     * @return
     */
    public static String removeCharAndWhiteSpaceFromString(String stringTarget, String character) {
        return stringTarget.replace(character, "").trim();
    }
    //--- Encrypt Decrypt ---//

    /**
     * Generate Md5
     *
     * @param md5Target target string
     * @return String data type
     * @throws NoSuchAlgorithmException if md5 algorithm not found
     */
    public static String generateMd5(String md5Target) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(md5Target.getBytes());
        byte[] digest = md.digest();
        return bytesToHexString(digest);
    }

    /**
     * Convert bytes to hex string
     *
     * @param bytes byte array
     * @return
     */
    public static String bytesToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    /**
     * Generate HmacSha256
     *
     * @param secretKey secret key
     * @param message   desired message
     * @return byte array
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     */
    public static byte[] generateHmacSha256(String secretKey, String message)
            throws NoSuchAlgorithmException, InvalidKeyException {
        Mac hmacSha256 = Mac.getInstance("HmacSHA256");
        SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");
        hmacSha256.init(keySpec);
        return hmacSha256.doFinal(message.getBytes());
    }
    //--- Encrypt Decrypt ---//

    //--- To String ---//

    /**
     * Convert List of Object Cookie to List of String
     *
     * @param list List of Object
     * @return List of String
     */
    public static List<String> convertFormatListToString(List<Cookie> list) {
        List<String> stringList = new ArrayList<>();
        for (Object object : list) {
            stringList.add(object.toString());
        }
        return stringList;
    }
}