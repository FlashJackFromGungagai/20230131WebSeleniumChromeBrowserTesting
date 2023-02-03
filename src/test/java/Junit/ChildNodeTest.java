package Junit;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import selenium.SeleniumDriverFactory;


import java.util.concurrent.TimeUnit;



public class ChildNodeTest 
{
	// want to identify all the child elements under the h2 heading "
	static WebDriver myDriver;
	// define 'mydriver' to be of type WebDriver
	JavascriptExecutor js = (JavascriptExecutor) myDriver;
	
	
	public static void main(String[] args) 
	{
		
        SeleniumDriverFactory sdf =new SeleniumDriverFactory ();
        myDriver = sdf.getDriver();

      
    	myDriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	// sets an implicit timer of 50 seconds
    	
    	String url = "https://www.trybooking.com/book/search";
    	myDriver.get(url);
    	
    	//Lets select the parent element of the h2 tag, which is the <div class="inner"> element
    	String parent_Xpath = " //h2[ contains( text(), 'Featured Events') ]//parent::div   " ;
    	By parentElementSelector = By.xpath( parent_Xpath )   ;
    	WebElement parentElement = myDriver.findElement(parentElementSelector);
    	
    	// now lets move down from the parent element to the selected <h6>...</h6> elements
    	String child_Xpath = "./descendant::div//div//a//div//h6";
    	By childElementSelector = By.xpath( child_Xpath)  ;
    	//WebElement childElement = parentElement.findElement(childElementSelector);
    	//System.out.println(childElement.getAttribute("data-event-name" ));
    	
    	List<WebElement> childElements =parentElement.findElements(childElementSelector);
    	for (WebElement childElement : childElements)
    	{
  
        	System.out.println(childElement.getText()); //Diagnostic
        	
    	}// close for loop
    	
    	
        myDriver.close();
		
	    

	}// close public static void main(String[] args) 

}// close public class ChildNodes
