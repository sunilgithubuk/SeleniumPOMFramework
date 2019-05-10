package SunWebOathE2E.StepDef;

import SunWebOathE2E.Client.SunWebOathTestClient;
import SunWebOathE2E.domain.CustomerDetails;
import Util.SeleniumBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class SunWebOathE2EStepDef {
    private SunWebOathTestClient sunWebOathTestClient;
    private String userName;
    private Boolean isDisplayed;
    private CustomerDetails customerDetails;

    public SunWebOathE2EStepDef(){
        sunWebOathTestClient=new SunWebOathTestClient();
    }

    @Given("^user is on sun homepage$")
    public void user_is_on_sun_homepage() throws Throwable {
        sunWebOathTestClient.OpenWebBrowser();
    }

    @When("^sign up with marketing permission (.*)$")
    public void register_to_sun_site_with_Optin_to_marketing_permission(String marketingPermission) throws Throwable {
        buildCustomerData();
        System.out.println(customerDetails.getEmail());
        userName=sunWebOathTestClient.sigUp(customerDetails,marketingPermission);
    }

    @Then("^user should be logged in on sun$")
    public void user_should_be_logged_in_on_sun() throws Throwable {
        Assert.assertEquals(customerDetails.getFirstName()+" "+customerDetails.getLastName(),userName);
        SeleniumBase.tearDown();
    }

    @When("^log in with existing user credentials$")
    public void log_in_with_existing_user_credentials() throws Throwable {

        userName=sunWebOathTestClient.signIn();
    }

    @Then("^user should get logged in$")
    public void user_should_get_logged_in() throws Throwable {
        Assert.assertEquals("user name do not match","Test Account",userName);
        SeleniumBase.tearDown();

    }

    @When("^click sign out$")
    public void click_sign_out() throws Throwable {
        isDisplayed = sunWebOathTestClient.signOut();
    }

    @Then("^user should get logged out$")
    public void user_should_get_logged_out() throws Throwable {
        Assert.assertTrue("Oath sign up page is not displayed",isDisplayed);
        SeleniumBase.tearDown();
    }


    public void buildCustomerData(){
        customerDetails = CustomerDetails.builder()
                .email(SeleniumBase.generateUniqieEmail())
                .firstName("Test")
                .lastName("Account")
                .password("Password123")
                .build();
    }

}
