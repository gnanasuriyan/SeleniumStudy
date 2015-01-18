package com.pointerunits.reference;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainTest {
	public static void main(String args[]) {
		//Creating new instance of firefox driver
		WebDriver driver = new FirefoxDriver();
		//Visit to google.com
		driver.get("http://www.google.com");
		//Find the input text element 
		WebElement element = driver.findElement(By.name("q"));
		//Enter something to search for
		element.sendKeys("sachin");
		//Now submit the form
		element.submit();
		//Check the title of the page
		System.out.println("Page title is: " + driver.getTitle());
		
		 // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("sachin");
            }
        });
        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());
        //Close the browser
        driver.quit();
	}
}
