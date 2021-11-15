package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import testDataTypes.Merchant;

public class SignUpPage {

    WebDriver driver;

    @FindBy(how = How.CSS, using = "input[type=email]")
    private WebElement email_txt;

    @FindBy(how = How.CSS, using = "input[name=password]")
    private WebElement password_txt;

    @FindBy(how = How.CSS, using = "input[name=password_confirm]")
    private WebElement confirmPassword_txt;

    @FindBy(how = How.CSS, using = "iframe[title=reCAPTCHA]")
    private WebElement reCaptchaFrame_txt;

    @FindBy(how = How.CSS, using = "span[id=recaptcha-anchor]")
    private WebElement reCaptchaCheckBox_txt;

    @FindBy(how = How.CSS, using = "button[type=submit]")
    private WebElement getStarted_btn;

    public SignUpPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void submitSignUpDetails(Merchant merchant) {
        System.out.println(merchant.email);
        enterEmail(merchant.email);
        enterPassword(merchant.password);
        enterConfirmPassword(merchant.password);
        tickReCaptchaCheckBox();
        clickGetStarted();
    }

    public void clickGetStarted() {
        getStarted_btn.click();
    }

    private void enterEmail(String email) {
        email_txt.sendKeys(email);
    }

    private void enterPassword(String password) {
        password_txt.sendKeys(password);
    }

    private void enterConfirmPassword(String password) {
        confirmPassword_txt.sendKeys(password);
    }

    private void tickReCaptchaCheckBox() {
        driver.switchTo().frame(reCaptchaFrame_txt);
        reCaptchaCheckBox_txt.click();
        driver.switchTo().parentFrame();
    }
}
