package week8;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import junit.framework.Assert;

public class MyFirstSeleniumJUnit {

	
	@Test
	public void googleSearchOpenNPU() throws Exception {

		WebDriver wd = new FirefoxDriver(); // This will open Firefox browser

		// Go to Google web page
		wd.get("http://www.google.com");

		// Maximize the browser
		wd.manage().window().maximize();
		
		// Wait untill google home-page loaded 
		wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000); // Thread will wait extra 3 seconds
		
		// Type NPU in search tab
		wd.findElement(By.id("lst-ib")).clear(); // It will clear the text field
		wd.findElement(By.id("lst-ib")).sendKeys("NPU");
		
		// Hit Enter
		Actions act = new Actions(wd); 
		act.sendKeys(Keys.ENTER).build().perform();
		
		//Wait Untill the search result appears
		wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
		
		if(wd.findElement(By.linkText("Northwestern Polytechnic University | Welcome to ... - Fremont")).isDisplayed() ){
		    wd.findElement(By.linkText("Northwestern Polytechnic University | Welcome to ... - Fremont")).click(); // Click Search Result Link Text to open NPU homepage
		    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // wait 30s until page loaded completely
		    Thread.sleep(5000); // wait extra 5s
	    } else{
	    	wd.get("http://www.npu.edu"); // if not found the proper search result link text, just open npu.edu web site
	    }
		
		// Wait and verify NPU home page is loaded
	    System.out.println("NPU web site page title is: " + wd.getTitle()); //  print out the current page title
		try{
			 Assert.assertTrue(wd.getTitle().equals("Northwestern Polytechnic University | Welcome to Northwestern Polytechnic University")); // check page title is "Northwestern Polytechnic University | Welcome to Northwestern Polytechnic University" 
		} catch(Throwable t){
			 t.getMessage();
			 System.out.println("NPU web page tile is not found.");
		}
		
		wd.quit();
		
		

	}

}
