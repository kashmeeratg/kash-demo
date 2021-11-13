package Pages;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Customer_Page {
	
	@FindBy(xpath="//div[contains(text(),'My Account')]")
	WebElement myAccountLink;
	
	@FindBy(xpath="//button[contains(text(),\"Let's do this\")]")
	WebElement letsDoThisBtn;
	
	@FindBy(css="div.bx-wrap a[data-click='close']")
	WebElement closeBtn;
	
		
	public Customer_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public boolean myAccountLinkExists() {
		return myAccountLink.isDisplayed();
	}

	public void winATripPopupExist() {
		if (letsDoThisBtn.isDisplayed()) {
			closeBtn.click();
		}
	}
}
