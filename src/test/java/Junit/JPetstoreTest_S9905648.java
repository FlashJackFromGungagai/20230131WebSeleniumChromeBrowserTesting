/**
 JPetstore JUnit/Webdriver Tasks:
 1) Check the pet name, price and check if there is stock for one pet of your choice (outside of Male Chihuahua). (as outlined for W11 prac)
 2) Start a menagerie! Select a specific fish, specific cat, and a third pet (they will have a unique item ID). Add 3 multiples of the first, 2 multiples of the cat, and one of the third pet to the cart. Check the subtotal matches the expected price. You are expected to show that this test case passes.  */
package Junit;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.SeleniumDriverFactory;

import static org.junit.jupiter.api.Assertions.*;

/*
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
*/

////////////////////////////////////////////////////////////////////////////////
/*--------------------------------------------------------------------------
* This is a project of... 
* > Michael John Little	: s9905648
* > Michael John Little	:9905648@student.rmit.edu.au 	
* > Michael John Little	:Mob: +61 476 136 482
* 
* -------------------------------------------------------------------------
*            THIS IS THE JPetstoreTest_S9905648 class.
* 
* what this class will do:
* 1. Perform a sanity check
* 2, Check the details of a female bulldog puppy, is one in stock
* 3. start a menagerie that consists of:
*  		Angelfish, 2; 
*  		Manx, 2; 
*  		Iguana, 1.
*/ 





//=========================================================================	
/*  
 *  
 *   
 *   
 */	
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
// Update this class name by replacing S3214321 with your student ID
class JPetstoreTest_S9905648 
{
    WebDriver myDriver;

    
	//=========================================================================	
	/*  Setting up the SeleniumDriverFactory
	 */	
    @BeforeEach
    void setUp() 
    {
        SeleniumDriverFactory sdf =new SeleniumDriverFactory ();
        this.myDriver = sdf.getDriver();
        
    }// close
 
    
    
	//=========================================================================	
	/*  Here we will perform a "Sanity check" to ensure everything is working
	 * properly before executing the test cases. 
	 * 
	*/
    
    @Test
    // @Disabled
    @Order(0)
    @DisplayName("TC00: Sanity test only")
     void sanityTest1() throws InterruptedException 
    {
        // When this passes I know I have the webdriver and Junit set up correctly
        String petStoreURL = "https://petstore.octoperf.com";
        myDriver.get(petStoreURL);
        Thread.sleep(3000); 
        System.out.println("debug:"+myDriver.getTitle());
        assertEquals("JPetStore Demo", myDriver.getTitle());
        //myDriver.findElement(By.linkText("Enter the Store")).click();
        Thread.sleep(3000);  
    }// close

	
   
    
    
	//=========================================================================	
	/*  Here we will login, check on a pet that we want to buy, which is a 
	 * female bulldog puppy, and check that it is in stock.
	 * 
	 * If in stock, test passes; if out of stock, test will fail.
	 *   
	  */
    
    /// implement your tests cases from here...
    @Test
    // @Disabled
    @Order(2)
    @DisplayName("TC01: Check on a Pet you want to buy")
     void Test1()
     {
    	 
    	WebElement we;
    	 // declare 'we' as type WebElement
    	
    	String WeText = "";
    	// this string contains the result of the xpath search  
    	
    	
    	String  FemalePuppyBulldogURL="https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-7"; 
    	myDriver.get ( FemalePuppyBulldogURL ) ;
    	we = myDriver.findElement(By.xpath("//*[contains(text(),'in stock')]"));
        WeText = we.getText(); // see what the text is
        assertTrue( WeText.contains(  "in stock" ), "Item not in Stock" );
     }// close
    
   	
    
    
    
	//=========================================================================	
	/* Here we will start a menagerie that consists of:
	 * FI-SW-01 	Angelfish		3		$16.50ea 	=	$49.5	[Total]
	 * FL-DSH-01 	Manx			2		$58.50ea	=	$117	[Total]
	 * RP-LI-02 	Iguana			1	 	$18.50ea	=	$18.50	[Total]
	 * 
	 * Total cost for the menagerie shall be $185.0
	 *   
	 */	
    
    /// implement your tests cases from here...
    @Test
    // @Disabled
    @Order(3)
    @DisplayName("TC02: Start a menagerie")
    
     
     void Test2() throws InterruptedException
     {
    	WebElement we;
   	    // declare 'we' as type WebElement 
    	
    	String WeText = "";
    	// this string contains the result of the xpath search 
    	
    	String JPetShopStore = "https://petstore.octoperf.com/actions/Catalog.action";
    	myDriver.get (JPetShopStore);
    	
    	//Choosing the angelfish
        myDriver.findElement(By.cssSelector("#QuickLinks > a:nth-child(1) > img")).click();
        myDriver.findElement(By.linkText("FI-SW-01")).click();
        myDriver.findElement(By.linkText("Add to Cart")).click();
        myDriver.findElement(By.name("EST-1")).click();
        myDriver.findElement(By.name("EST-1")).clear();
        myDriver.findElement(By.name("EST-1")).sendKeys("3");
        
        
        myDriver.findElement(By.name("updateCartQuantities")).click();
        
        // return to the main menu, JPet Shop Store front
        myDriver.findElement(By.linkText("Return to Main Menu")).click();
        
        //choosing the Manx
        myDriver.findElement(By.cssSelector("#QuickLinks > a:nth-child(7) > img")).click();
        myDriver.findElement(By.linkText("FL-DSH-01")).click();
        myDriver.findElement(By.linkText("Add to Cart")).click();
        myDriver.findElement(By.name("EST-14")).click();
        myDriver.findElement(By.name("EST-14")).clear();
        myDriver.findElement(By.name("EST-14")).sendKeys("2");
        myDriver.findElement(By.name("updateCartQuantities")).click();
        
        
        // return to the main menu, JPet Shop Store front
        myDriver.findElement(By.linkText("Return to Main Menu")).click();
        
      //choosing the Iguana
        myDriver.findElement(By.cssSelector("a:nth-child(5) > img")).click();
        myDriver.findElement(By.linkText("RP-LI-02")).click();
        myDriver.findElement(By.linkText("Add to Cart")).click();
        
        Thread.sleep(5000); 
        
        we = myDriver.findElement(By.xpath("//*[contains(text(),'Sub Total:')]"));
        
        WeText = we.getText(); // see what the text is
        //assertTrue( WeText=="$185", "Item not in Stock" );
        assertTrue( WeText.contains(  "$185.00" ), "Something went wrong prices do not match" );
    
     }// close
    
    
    
    
	//=========================================================================	
	/*  This closes the SeleniumDriverFactory
	 */	   
    @AfterEach
    void tearDown() 
    {
        //myDriver.close();
        myDriver.quit();
    }// close
    


}// close class JPetstoreTest_S9905648




