package Junit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.SeleniumDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;
import selenium.SeleniumDriverFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class ChildNodes 
{
	
	static WebDriver driver;
	// define 'mydriver' to be of type WebDriver
	
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
        SeleniumDriverFactory sdf =new SeleniumDriverFactory ();
        driver = sdf.getDriver();
        
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.tutorialspoint.com/about/about_careers.htm");
        // identify element
        WebElement t=driver.findElement(By.xpath("//ul[@class='toc chapters']"));
        //identify child nodes with ./child::* expression in xpath
        List<WebElement> c = t.findElements(By.xpath("./child::*"));
        // iterate child nodes
        for ( WebElement i : c ) {
        //getText() to get text for child nodes
        System.out.println(i.getText());}
        driver.close();
		
	    

	}// close public static void main(String[] args) 

}// close public class ChildNodes
