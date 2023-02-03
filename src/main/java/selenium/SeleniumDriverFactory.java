



package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


////////////////////////////////////////////////////////////////////////////////
/*--------------------------------------------------------------------------
* This is a project of... 
* > Michael John Little	: s9905648
* > Michael John Little	:9905648@student.rmit.edu.au 	
* > Michael John Little	:Mob: +61 476 136 482
* 
* -------------------------------------------------------------------------
*            THIS IS THE SeleniumDriverFactory class.
* 
* what this class will do:
*  This class will allow you to separate the webdriver / browser choice from the test classes
*  
*  Note:
*  1. This java script has been configured for operation on a MacOS machine  
*  To run this class on a Windows OS machine, replace the code:   
*    System.setProperty("webdriver.gecko.driver","geckodriver");
*  With...      
*    System.setProperty("webdriver.gecko.driver","geckodriver.exe");		 
*          
*/ 
public class SeleniumDriverFactory  
{

	//=========================================================================	
	/*  please rename s3214321 this to your own student ID:
	 *  With regards to this, there is no instructions to do this 
	 *  in the assignment "Files to Develop and Submit" instructions.
	 *   
	 *   
	 */	
    public SeleniumDriverFactory()
    {
    	// This is the default constructor. 
    	
    	// this has been commented out for Windows.
    	//System.setProperty("webdriver.gecko.driver","geckodriver.exe");
    	//This is the path for MacOS
    	System.setProperty("webdriver.gecko.driver","geckodriver");
    }// close SeleniumDriverFactory()
    
    
    
    
	//=========================================================================	
	/*  
	 *  
	 *   
	 *   
	 */	
   public  WebDriver getDriver()
    {
        return new FirefoxDriver();
        
    }// close  WebDriver getDriver()

    
	//=========================================================================	
	/*  
	 *  
	 *   
	 *   
	 */	
    public FirefoxDriver getFireFoxDriver()
    {
        return new FirefoxDriver();
        
    }// close  FirefoxDriver getFireFoxDriver()
    
	//=========================================================================	
	/*  
	 *  
	 *   
	 *   
	 */	
    public ChromeDriver getChromeDriver()
    {
        return new ChromeDriver();
        
    } // close  ChromeDriver getChromeDriver()

}//close public class SeleniumDriverFactory  
