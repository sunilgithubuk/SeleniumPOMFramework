package SunWebOathE2E.domain;

import SunWebOathE2E.POMPages.SunHomePage;
import SunWebOathE2E.POMPages.SunMyAccountPage;
import SunWebOathE2E.POMPages.SunOathPage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {


    private WebDriver driver;
    private SunHomePage sunHomePage;
    private SunOathPage sunOathPage;
    private SunMyAccountPage sunMyAccountPage;

    public PageObjectManager(WebDriver driver){
        this.driver=driver;
    }

    public SunHomePage getSunHomePage() {
        return (sunHomePage==null)?sunHomePage=new SunHomePage(driver):sunHomePage;
    }
    public SunOathPage getSunOathPage(){
        return (sunOathPage==null)?sunOathPage= new SunOathPage(driver):sunOathPage;
    }
    public SunMyAccountPage getSunMyAccountPage(){
        return (sunMyAccountPage== null)?sunMyAccountPage= new SunMyAccountPage(driver):sunMyAccountPage;
    }
}
