package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Utils.TestContextSetup;
import io.cucumber.java.en.Then;




public class OfferPageStepDefinition {

public WebDriver driver;
public String LandingPageProductName;
public String offerPageProductName;
TestContextSetup testContextSetup;
public OfferPageStepDefinition(TestContextSetup testContextSetup)
{
	this.testContextSetup=testContextSetup;
}
	@Then("user searched for {string} shortname in offers page to check if product exits with same name")
	public void user_searched_for_same_shortname_in_offers_page_to_check_if_product_exits(String shotName) throws InterruptedException {
		testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
	  Set<String> s1=testContextSetup.driver.getWindowHandles();
	  Iterator<String> i1=s1.iterator();
	  String parentWindow=i1.next();
	  String childWindow=i1.next();
	  testContextSetup.driver.switchTo().window(childWindow);
	  testContextSetup.driver.findElement(By.xpath("//input[@type='search'")).sendKeys("shortName");
	  Thread.sleep(2000);
	   offerPageProductName=testContextSetup.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
	  
	  
	}
	
	@Then("validate product name in offers page matches with Landing Page")
	public void validate_product_name_in_offers_page()
	{
		Assert.assertEquals(offerPageProductName, LandingPageProductName);
	}
}
