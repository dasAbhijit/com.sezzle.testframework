package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.*;

public class PageObjectManager {
	private WebDriver driver;
	private LandingPage landingPage;
	private SignUpPage signUpPage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public LandingPage getLandingPage() {
		return (landingPage == null) ? landingPage = new LandingPage(driver) : landingPage;
	}
	public SignUpPage getSignUpPage() {
		return (signUpPage == null) ? signUpPage = new SignUpPage(driver) : signUpPage;
	}
}