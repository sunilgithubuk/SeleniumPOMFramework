package SunWebOathE2E.POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SunHomePage {

    public SunHomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(linkText = "Sign in")
    WebElement signInLink;

    @FindBy(linkText = "View Profile")
    WebElement viewProfileLink;

    public void clickSignIn(){
        signInLink.click();
    }
    public Boolean viewProfileLink(){
        return viewProfileLink.isDisplayed();
    }
    public void clickViewProfileLink(){
         viewProfileLink.click();
    }



}
