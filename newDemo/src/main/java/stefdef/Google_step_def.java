package stefdef;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Google_Search_Page;

public class Google_step_def {

	WebDriver driver;
	WebElement search;
	Google_Search_Page googlePage;

	@Given("I am on chrome browser")
	public void i_am_on_chrome_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Given("I navigate to google page")
	public void i_navigate_to_google_page() {
		driver.get("https://www.google.com/");
		googlePage = new Google_Search_Page(driver);
	}

	@When("I enter search text")
	public void i_enter_search_text() {
		googlePage.enterSearchText("automation");
	}

	@When("click on enter")
	public void click_on_enter() {
		googlePage.pressEnter();
	}

	@Then("search result page is displayed")
	public void search_result_page_is_displayed() {

	}

}
