package week8;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstSeleniumTestNG {

	@Test
	public void GoogleSearchOpenNPU() throws Exception {
				    		
		// 1. launch browser (FireFox)
		WebDriver driver = new FirefoxDriver();
		
		// 2. go to http://www.google.com
		driver.get("http://www.google.com"); // make sure should use http:// 
		
		// 3. maximize the browser window
		driver.manage().window().maximize(); // maximum window size
		
		// wait until google home page loaded
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // wait maximum up to 30s until page loaded completely
		Thread.sleep(3000); // wait extra 3s
				
		// 4. type NPU in the search text
	    driver.findElement(By.id("lst-ib")).clear(); // clear the field, good practice
	    driver.findElement(By.id("lst-ib")).sendKeys("NPU"); // type NPU in the search field
	    
		// 5. Hit enter key
	    Actions actions = new Actions(driver);
	    actions.sendKeys(Keys.ENTER).build().perform();
	    
		// 6. wait until the search result appears
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // wait maximum up to 30s until page loaded completely
		Thread.sleep(3000); // wait extra 3s

		// 7. find and click the search result link text Northwestern Polytechnic University to open NPU home page
	    if(driver.findElement(By.linkText("Northwestern Polytechnic University | Welcome to ... - Fremont")).isDisplayed() ){
		    driver.findElement(By.linkText("Northwestern Polytechnic University | Welcome to ... - Fremont")).click(); // Click Search Result Link Text to open NPU homepage
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // wait maximum up to 30s until page loaded completely
		    Thread.sleep(5000); // wait extra 5s
	    } else{
	    	driver.get("http://www.npu.edu"); // if not found the proper search result link text, just open npu.edu web site
	    }

		// 8. wait and verify NPU home page is loaded (check page title)
	    System.out.println("NPU web site page title is: " + driver.getTitle()); //  print out the current page title
		try{
			 Assert.assertTrue(driver.getTitle().equals("Northwestern Polytechnic University | Welcome to Northwestern Polytechnic University")); // check page title is "Northwestern Polytechnic University | Welcome to Northwestern Polytechnic University" 
		} catch(Throwable t){
			 t.getMessage();
			 System.out.println("NPU web page tile is not found.");
		}
		
		// 9. click Capstone Competition of Summer 2016 picture
		driver.findElement(By.xpath("html/body/div[6]/div/div/div/div[1]/div/div/div[2]/div/div/div/div/div/div/figure/a/img")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // wait maximum up to 30s until page loaded completely
		Thread.sleep(2000); // wait 2s

	    // 10. go back to NPU Home page
	    driver.navigate().back(); // go back to previous window
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // wait maximum up to 30s until page loaded completely
		Thread.sleep(2000); // wait 2s

	    // 11. close all and exit
	    driver.quit(); // Close all open windows and kill all WebDriover open sessions
	  }

}
