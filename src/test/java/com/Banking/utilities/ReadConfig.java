package com.Banking.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

    Properties prop;
    public ReadConfig()  {

        try {
            prop= new Properties();
            FileInputStream fis=new FileInputStream("./Configurations//data.properties");
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getApplicationURL(){

        String url = prop.getProperty("url");
        return url;
    }

    public String getBrowser(){

        String browser=prop.getProperty("browser");
        return browser;
    }

    public String getUserName(){

        String username=prop.getProperty("username");
        return username;
    }

    public String getPassword(){
        String password=prop.getProperty("password");
        return password;
    }
}
