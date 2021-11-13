package StepDef;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import Pages.CoachHomepage;
import Pages.Customer_Page;
import Pages.SigninPage;
import eventListeners.myEventListener;
import io.cucumber.core.gherkin.Feature;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.plugin.event.Node.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

public class HomepageCoach {
	WebDriver driver;
	CoachHomepage page;
	SigninPage signInPage;
	Customer_Page customerPage;

	Logger log = LogManager.getLogger(this);

	@Given("user is on home page")
	public void user_is_on_home_page() {

		log.info("=============================================================");
		log.info("             Starting "+Feature.class);
		log.info("=============================================================");
		WebDriverManager.chromedriver().setup();// Will download latest chromedriver
		log.info("Initializing Driver.........");
		driver = new ChromeDriver();

		EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver); // Creating object of EventFiringWebDriver
		myEventListener handler = new myEventListener();
		eventDriver.register(handler);
		driver = eventDriver;

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		log.info("Launching Coach home page");
		driver.get("https://www.coach.com/");

//button[contains(text(),'no thanks, take me to the site')]

	}

	@Then("validate if coach icon is displayed;")
	public void validate_if_coach_icon_is_displayed() {
		page = new CoachHomepage(driver);
		Assert.assertTrue(page.iconDisplayed());
		page.popUpLinkExist();

	}

	@Then("validate if user button is displayed")
	public void validate_if_user_button_is_displayed() {
		Assert.assertTrue(page.userButtonDisplayed());
	}

	@When("user clicks on user button")
	public void user_clicks_on_user_button() {
		page.clickUserButton();
	}

	@Then("validate signin page is displayed")
	public void validate_signin_page_is_displayed() {
		signInPage = new SigninPage(driver);
		Assert.assertTrue(signInPage.signInPageDisplayed());

	}

	@When("^user enter (.*) and (.*)$")
	public void user_enter_username_and_password(String user, String password) {
		signInPage.enterUserName(user);
		signInPage.enterPassword(password);
		signInPage.pressSignInButton();

	}

	@Then("validate user is on customer page")
	public void validate_user_is_on_customer_page() {
		customerPage = new Customer_Page(driver);
		customerPage.winATripPopupExist();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(customerPage.myAccountLinkExists());

	}

	@Then("close the browser")
	public void close_the_browser() {
		driver.close();
		log.info("=============================================================");
		log.info("             End of TC execution     ");
		log.info("=============================================================");

	}
	
	@After
	public void teardown() {
		driver.close();
		log.info("=============================================================");
		log.info("             End of TC execution     ");
		log.info("=============================================================");
	}

}
