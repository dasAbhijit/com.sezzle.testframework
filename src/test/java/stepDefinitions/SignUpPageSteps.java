package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import pageObjects.SignUpPage;
import testDataTypes.Merchant;

public class SignUpPageSteps {

    TestContext testContext;
    SignUpPage signUpPage;

    public SignUpPageSteps(TestContext context) {
        testContext = context;
        signUpPage = testContext.getPageObjectManager().getSignUpPage();
    }

    @When("^user submits \\\"(.*)\\\" sign up mailing details$")
    public void user_submits_merchant_sign_up_mailing_details(String merchantName) throws InterruptedException {
        Merchant merchant = FileReaderManager.getInstance().getJsonReader().getMerchantByName(merchantName);
        signUpPage.submitSignUpDetails(merchant);
        Thread.sleep(3_000);
    }
}