package core;

import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    private static ReadProperties instance;
    protected Properties properties;

    public ReadProperties(){
        properties = new Properties();

        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ReadProperties getInstance(){
        if(instance == null){
            instance = new ReadProperties();
        }
        return instance;
    }
    public String getTestRailURL() {return properties.getProperty("testrail_url");}
    public String getTestRailUsername() {return properties.getProperty("api_username");}
    public String getTestRailPassword() {return properties.getProperty("api_password");}

    public String getURL() {return properties.getProperty("url");}

    public String getBrowser() {return properties.getProperty("browser");}

    public String getUsername() {return properties.getProperty("username");}

    public String getPassword() {return properties.getProperty("password");}

    public int getTimeout() {return Integer.parseInt(properties.getProperty("timeout"));}
    public boolean getHeadless() {return Boolean.parseBoolean(properties.getProperty("headless"));}
}
