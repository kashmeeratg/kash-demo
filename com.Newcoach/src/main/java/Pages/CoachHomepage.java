package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoachHomepage {
	@FindBy(css = "a.brand")
	WebElement icon;

	@FindBy(css = "a.account-icon")
	WebElement userbutton;
	
	@FindBy(xpath="//button[contains(text(),'no thanks, take me to the site')]")
	WebElement popUpLink;

	public CoachHomepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean iconDisplayed() {
		
		return icon.isDisplayed();
	}
	
	public boolean userButtonDisplayed() {
		return userbutton.isDisplayed();
	}

	public void clickUserButton() {
		userbutton.click();
	}
	
	public void popUpLinkExist() {
		if (popUpLink.isDisplayed()) {
			popUpLink.click();
		}
	}
}
