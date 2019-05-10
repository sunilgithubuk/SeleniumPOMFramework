package SunWebOathE2E.POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SunMyAccountPage {

    public SunMyAccountPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "bp-welcome")
    WebElement userNameDropDown;
    @FindBy(linkText = "Sign out")
    WebElement signOutLink;


    public String getUserName(){
        return userNameDropDown.getText();
    }
    public void clickUserName(){
        userNameDropDown.click();
    }

    public String getSignoutText(){
        return signOutLink.getText();
    }
    public void clickSignout(){
         signOutLink.click();
    }
}
