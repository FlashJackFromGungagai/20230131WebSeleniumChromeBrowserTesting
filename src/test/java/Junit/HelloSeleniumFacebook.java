package Junit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;


class HelloSeleniumFacebook
{

	//=========================================================================	
	/*	This test checks the that the title of the face book page is
	 * 	is "log in or sign up"
	 *  Test script developed by Michael John Little
	 *  Student number: s9905648J
	 *   
	 *   
	 */	
	@Test
	void checkFacebookTitle() 
	{
        // this has been commented out for Windows.
    	//System.setProperty("webdriver.gecko.driver","geckodriver.exe");
    	//This is the path for MacOS
    	System.setProperty("webdriver.gecko.driver","geckodriver");
        
        WebDriver driver = new FirefoxDriver();
        String baseUrl = "http://facebook.com";
        driver.get(baseUrl);
        
        System.out.println(driver.getTitle()); //diagnostic
        
        assertEquals("Facebook – log in or sign up", driver.getTitle());
        //driver.close();
        // this is not working.. try this...
        driver.quit();
       
	}// close void checkFacebookTitle() 

	//=========================================================================	
	/*  
	 *	This tests that the tagname of the element with id "email is "input"  
	 *   
	 *   
		*/
    @Test
    void checkFacebookEmailInput()
    {
    	
    	// Of course G:\\drivers\\geckodriver.exe should be replaced with
        // the url of where you stored this.

        // this has been commented out for Windows.
    	//System.setProperty("webdriver.gecko.driver","geckodriver.exe");
    	//This is the path for MacOS
    	System.setProperty("webdriver.gecko.driver","geckodriver");
        WebDriver driver = new FirefoxDriver();
        String baseUrl = "http://facebook.com";
        String tagName = "";

        driver.get(baseUrl);
        tagName = driver.findElement(By.id("email")).getTagName();
        
        System.out.println(tagName); //diagnostic
        
        assertEquals("input", tagName);
        //driver.close();
        // this is not working.. try this...
        driver.quit();
       
        
    }// close checkFacebookEmailInput()
    

}// close class HelloSeleniumFacebook