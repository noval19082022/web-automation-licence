package utilities;

import config.global.GlobalConfig;
import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JavaHelpers {


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

    public static String getPropertyValue(String propertyFile, String propertyName) {
        Properties prop = accessPropertiesFile(propertyFile);
        String variable = prop.getProperty(propertyName);
        if (variable != null) {
            return variable;
        } else {
            propertyName = StringUtils.removeEnd(propertyName, "_" + GlobalConfig.ENV);
            return prop.getProperty(propertyName);
        }
    }
}