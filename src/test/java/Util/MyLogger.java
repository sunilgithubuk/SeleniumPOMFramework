package Util;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class MyLogger {


    public static final String LOGGER_NAMER ="cucumberTutorial";

    public static final Logger LOGGER = LogManager.getLogger(LOGGER_NAMER);

    public static void info(String message){
        LOGGER.info(message);
    }
}
