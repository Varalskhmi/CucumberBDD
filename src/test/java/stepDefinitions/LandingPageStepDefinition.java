package stepDefinitions;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import Utils.TestContextSetup;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LandingPageStepDefinition {
public WebDriver driver;
public String LandingPageProductName;
public String offerPageProductName;
TestContextSetup testContextSetup;

public LandingPageStepDefinition(TestContextSetup testContextSetup)
{
	this.testContextSetup=testContextSetup;
}
	@Given("User is on GreenCart Landing page")
	public void user_is_on_green_cart_landing_page() {
		   WebDriverManager.chromedriver().driverVersion("114.0.5735.90").setup();
		      
		      ChromeOptions options = new ChromeOptions(); 
		      options.addArguments("--remote-allow-origins=*"); 
		      options.addArguments("--start-maximized");
		      
		      driver =  new ChromeDriver(options);
		
		
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\Welcome\\Downloads\\chromedriver_win32");
	 //  WebDriverManager.chromedriver().setup();
	   //
		      testContextSetup.driver=new ChromeDriver();
	   driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}
	
	@When("user searched with Shortname {string} and extracted actual name of product")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
	   testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys("shortName");
	   Thread.sleep(20000);
	   testContextSetup.landingPageProductName=testContextSetup.driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
	   System.out.println(LandingPageProductName+" is extracted from home page");
	   }


	
}
