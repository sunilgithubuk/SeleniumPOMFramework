package SunWebOathE2E.POMPages;

import SunWebOathE2E.domain.CustomerDetails;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SunOathPage {

    public SunOathPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "Sign Up")
    WebElement signUpLink;

    @FindBy(linkText = "Sign In")
    WebElement signInLink;

    @FindBy(xpath = "//input[@name='email']")
    WebElement email;

    @FindBy(xpath = "//input[@name='password']")
    WebElement password;

    @FindBy(xpath = "//input[@name='firstName']")
    WebElement firstName;
    @FindBy(xpath = "//input[@name='lastName']")
    WebElement lastName;

    @FindBy(css = ".consentBox--yes")
    WebElement marketingPermissionsYes;
    @FindBy(css = ".consentBox--no")
    WebElement marketingPermissionsNo;
    @FindBy(id = "terms-input")
    WebElement termConditions;

    @FindBy(name = "submit")
    WebElement submit;

    public void signUp(final CustomerDetails customerDetails, String marketingPermission) throws InterruptedException {
        signUpLink.click();
        email.sendKeys(customerDetails.getEmail());
        password.sendKeys(customerDetails.getPassword());
        firstName.sendKeys(customerDetails.getFirstName());
        lastName.sendKeys(customerDetails.getLastName());
        if (marketingPermission.equalsIgnoreCase("yes"))
            marketingPermissionsYes.click();
        else
        marketingPermissionsNo.click();
        termConditions.click();
        submit.click();
    }

    public void signIn(final String email, final String password){
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        submit.click();
    }
    public Boolean signUpLinkIsDisplayed(){
        return signUpLink.isDisplayed();
    }
}
