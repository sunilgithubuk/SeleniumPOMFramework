package Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {

  private Properties prop;

    public PropertyLoader(){
        loadProperty();
    }

    public void loadProperty(){
        String environment=System.getProperty("env");
        if(environment==null)
            environment="configuration";
        File file = new File(System.getProperty("user.dir")+"/src/test/resources/"+environment+".properties");
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        prop = new Properties();

        //load properties file
        try {
            prop.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String property){


        return prop.getProperty(property);
    }
}
