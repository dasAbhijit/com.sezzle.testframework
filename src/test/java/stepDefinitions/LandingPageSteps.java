package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;

public class LandingPageSteps {

    TestContext testContext;
    LandingPage landingPage;

    public LandingPageSteps(TestContext context) {
        testContext = context;
        landingPage = testContext.getPageObjectManager().getLandingPage();
    }

    @Given("user is on landing page")
    public void user_is_on_landing_page() {
        landingPage.navigateToLandingPage();
    }

    @When("user clicks on sign up button")
    public void user_clicks_on_sign_up_button(){
        landingPage.clickOnSignUpButton();
    }

    @And("user clicks on merchant sign up button")
    public void user_clicks_on_merchant_sign_up_button() {
        landingPage.clickOnMerchantSignUpButton();
    }


}