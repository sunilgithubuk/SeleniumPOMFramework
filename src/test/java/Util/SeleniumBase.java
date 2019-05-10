package Util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Augmenter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SeleniumBase {

    public static WebDriver driver;

    public static WebDriver openWebDriver(){

        String browser=System.getProperty("browser");
        if(browser == null)
            browser="chrome";
        if (System.getProperty("os.name").contains("Mac")) {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/webDrivers/geckodriver");
            System.setProperty("webdriver.chrome.driver", "src/test/resources/webDrivers/MacChromedriver");

        }
        if (System.getProperty("os.name").contains("Win")) {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/webDrivers/geckodriver_win64.exe");
            System.setProperty("webdriver.chrome.driver", "src/test/resources/webDrivers/chromedriver_win32.exe");

        }
        if(browser.contains("firefox")){
            driver = new FirefoxDriver();
        }else if(browser.contains("chrome")){
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
        return driver;

    }

    public static void tearDown(){ driver.quit();}

    public static int generateRandomNumber() {
        Random rnd = new Random();
        int n = 1000000 + rnd.nextInt(900000);
        return n;
    }
    public static String generateUniqieEmail(){
        String email="@yopmail.com";
        email = generateRandomNumber()+email;
        return email;

    }
    public static byte[] takeScreenshot(){
        byte[] screenshot;

            screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);
        return screenshot;
    }

    public void sleep() throws InterruptedException {
        Thread.sleep(2000);
    }
}
