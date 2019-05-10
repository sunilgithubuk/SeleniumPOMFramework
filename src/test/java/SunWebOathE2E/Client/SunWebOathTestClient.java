package SunWebOathE2E.Client;


import SunWebOathE2E.POMPages.SunHomePage;
import SunWebOathE2E.domain.PageObjectManager;
import SunWebOathE2E.POMPages.SunMyAccountPage;
import SunWebOathE2E.POMPages.SunOathPage;
import SunWebOathE2E.domain.CustomerDetails;
import Util.PropertyLoader;
import Util.SeleniumBase;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SunWebOathTestClient extends SeleniumBase {

    private WebDriver driver;
    public SunHomePage sunHomePage;
    private SunOathPage sunOathPage;
    private SunMyAccountPage sunMyAccountPage;
    private PropertyLoader propertyLoader;
    private PageObjectManager pageObjectManager;
    public SunWebOathTestClient(){
        driver=openWebDriver();
        propertyLoader= new PropertyLoader();
        pageObjectManager= new PageObjectManager(driver);
        sunHomePage=pageObjectManager.getSunHomePage();
        sunOathPage=pageObjectManager.getSunOathPage();
        sunMyAccountPage=pageObjectManager.getSunMyAccountPage();
    }




    public void OpenWebBrowser() throws IOException {

        try{

            // sun web takes ages to load hence we need to stop the page
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
            driver.get(propertyLoader.getProperty("sun_web_homepage_url"));

        }catch(Exception e){
        }finally {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
        }
    }

    public String sigUp(CustomerDetails customerDetails, String marketingPermission) throws InterruptedException, IOException {
        sunHomePage.clickSignIn();
        sunOathPage.signUp(customerDetails,marketingPermission);
        System.out.println(driver.getCurrentUrl());
        Boolean status =false;
        for(int i=0;i<5;i++){
            if(driver.getCurrentUrl().equalsIgnoreCase(propertyLoader.getProperty("sun_web_homepage_url"))){
                System.out.println(driver.getCurrentUrl());
                pressEscapeButton(driver);
                status=true;
                break;
            }else
                sleep();
        }
        if(status==false)
            Assert.assertTrue("Sun homepage is not displayed",status);
        System.out.println(sunHomePage.viewProfileLink());
        sunHomePage.clickViewProfileLink();
        sleep();
        String userName =sunMyAccountPage.getUserName();
        sunMyAccountPage.clickUserName();
        System.out.println(sunMyAccountPage.getSignoutText());
        return userName;

    }

    public String signIn() throws InterruptedException {
        sunHomePage.clickSignIn();
        sunOathPage.signIn(propertyLoader.getProperty("existingUserEmail"),propertyLoader.getProperty("existingUserPassword"));
        sleep();
        System.out.println(sunHomePage.viewProfileLink());
        sunHomePage.clickViewProfileLink();
        sleep();
        String userName =sunMyAccountPage.getUserName();
        return userName;

    }
        public boolean signOut() throws InterruptedException {
            sunMyAccountPage.clickUserName();
            sunMyAccountPage.clickSignout();
            sleep();
            sleep();
            return sunOathPage.signUpLinkIsDisplayed();
        }


    public void pressEscapeButton(WebDriver driver){
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ESCAPE).build().perform();

    }


}
