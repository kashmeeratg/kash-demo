package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SigninPage {
	@FindBy(css = "div.login-heading")
	WebElement loginIcon;

	@FindBy(css = "input#login-form-email")
	WebElement userNameBox;

	@FindBy(css = "input#login-form-password")
	WebElement passwordBox;

	@FindBy(css = "div.login-submit-btn")
	WebElement signInBtn;

	public SigninPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public boolean signInPageDisplayed() {
		return loginIcon.isDisplayed();
	}

	public void enterUserName(String userName) {
		userNameBox.sendKeys(userName);

	}

	public void enterPassword(String password) {
		passwordBox.sendKeys(password);

	}
	
	public void pressSignInButton() {
		signInBtn.click();
	}

}
