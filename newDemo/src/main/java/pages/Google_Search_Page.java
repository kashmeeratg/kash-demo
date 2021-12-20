package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Google_Search_Page {

	@FindBy (css="input[name='q']")
	WebElement search;
	
 public Google_Search_Page(WebDriver driver) {
	 
	PageFactory.initElements(driver, this);
 }
	
 
 public void enterSearchText(String searchText) {
	 search.sendKeys(searchText);
	 
 }
 
 //This is a method to press enter key test more
 public void pressEnter() {

	 search.sendKeys(Keys.F6);

}
 
	
}
