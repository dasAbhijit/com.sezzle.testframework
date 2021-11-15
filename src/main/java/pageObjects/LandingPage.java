package pageObjects;

import managers.FileReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    WebDriver driver;

    @FindBy(how = How.CSS, using = "header > div:nth-child(2) > button:nth-child(2)")
    private WebElement signUp_btn;

    @FindBy(how = How.CSS, using = ".btn-transparent.mx-2.my-4")
    private WebElement merchantSignUp_btn;

    public LandingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToLandingPage() {
        driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
    }

    public void clickOnSignUpButton() {
        signUp_btn.click();
    }

    public void clickOnMerchantSignUpButton() {
        merchantSignUp_btn.click();
    }
}
