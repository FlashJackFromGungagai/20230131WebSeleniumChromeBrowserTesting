/**
 Trybooking JUnit/Webdriver Tasks:
 1) Navigate to https://www.trybooking.com/book/search (Links to an external site.) and print-to-screen the featured event titles. Store these titles in a suitable variable in your test case (list? arrays?). Update your test case to use assertEquals to compare these titles with a new test case run. You are expected to show that this test case passes.
 2) Navigate to https://www.trybooking.com/book/search (Links to an external site.) as above and check for featured and events near "you". If any such event has '(Cancelled)' in its title, then this test case should fail.
    Example Event Title: Prahran Market Discovery Trail (CANCELLED)
    Example Event URL: https://www.trybooking.com/events/landing?eid=758678
 3) Navigate to https://www.trybooking.com/BUOMO (Links to an external site.) and book to one of the Monday or Thursday sessions, completing all of any optional data collection questions asked, using your student email ID.
 */
package Junit;


import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import selenium.SeleniumDriverFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/*--------------------------------------------------------------------------
* This is a project of... 
* > Michael John Little	: s9905648
* > Michael John Little	:9905648@student.rmit.edu.au 	
* > Michael John Little	:Mob: +61 476 136 482
* 
* -------------------------------------------------------------------------
*            THIS IS THE Try Booking Test class.
* 
* what this class will do:
*  1. This operates on the FireFox browser.
*  2. This checks the title of the Try Booking site.
*  
*  Note:
*  
*  
*    
*     
*   	 
*          
*/



//=========================================================================	
/*  
 *  
 *   
 *   
 */	

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

// Update this class name by replacing S3214321 with your student ID
class  TryBookingTest_S9905648 
{
    static WebDriver myDriver;
    // define 'mydriver' to be of type WebDriver
    
	// here we will instantiate and  initialise EventDisplayNamesArray
   
    StoreDisplayNames PrevEventNames;
    // StoreDisplayNames is an externally defined class,
    // StoreDisplayNames.java
    // This makes PrevEventNames to be of type PrevEventNames
    JavascriptExecutor js = (JavascriptExecutor) myDriver;



	//=========================================================================	
	/*  
	 *  This is the set up that occurs before each test.  
	 *   
	 *	@BeforeEach is used to signal that the annotated method should be executed
 	 *	before each @Test method in the current test class.
	 *   
	 */	
    
    @BeforeEach
    void setUp() 
    {
        SeleniumDriverFactory sdf =new SeleniumDriverFactory ();
       myDriver = sdf.getDriver();

        //myDriver.manage().window().maximize();
        // This maximises the page to window size
    	myDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	PrevEventNames = new StoreDisplayNames();
    	
 
    }// close   
    
    
    
	//=========================================================================	
	/*  Here we will test that the title of the site matches to
	 *  " Search Events | TryBooking Australia "
	 *   
	 *  
	 *    */
	
    
    @Test
    // @Disabled
    @Order(0)
    @DisplayName("TC00 Sanity test, check we have the Buy tickets | TryBooking Australia site ")
     void Test0()
    {
    	String PageTitle="";
        // When this passes I know I have the webdriver and Junit set up correctly
        String url = "https://www.trybooking.com/book/search";
        myDriver.get(url);
        
        PageTitle=myDriver.getTitle();
        //get the page title in the  <head>..</head>
        assertEquals("Search Events | TryBooking Australia",PageTitle  );
    }// close
     
     
	//=========================================================================	
	/*  
	 * Here we will catch the list if feature events, then wait, and then re-capture the list
	 *
	 *  with this:
	 *  1. Capture the first list of featured events into an arrayList, tmpArrayList1
	 *  2. Wait 90 seconds
	 *  3. Capture the first list of featured events into an arrayList, tmpArrayList2
	 *  4. If the length of tmpArrayList1 is different from tmpArrayList2, then the Test fails
	 *  5. If the length of tmpArrayList1 equals tmpArrayList2, then the first part of the test passes, and then..
	 * 		5.1 check each item of tmpArrayList1, tmpArrayList2 so that the value at [for example] 
	 * 			tmpArrayList1[2] matches the value at tmpArrayList2[2] set a boolean variable  as TRUE
	 * 		5.2 If the value at [for example] tmpArrayList1[2] does not match the value at tmpArrayList2[2] 
	 * 			set a boolean variable  as FALSE, and break out of the loop. TEST FAILS.
	 *  	
	 *  */
	    
	 
	
    
    /// implement your tests cases from here...
    @Test
    // @Disabled
    @Order(1)
    @DisplayName("TC01: Check featured events: Test passes when featured events captured, compared, no change ")
     void Test1() throws Exception
     {
    	List<String> tmpArrayList1 = new ArrayList<>();
    	// this is the array list that is a temporary variable 
    	// to catch the first state of the events.
    	
    	List<String> tmpArrayList2 = new ArrayList<>();
    	// this is the array list that is a temporary variable 
    	// to catch the second state of the events.	
    	
    	boolean FeaturedEventListsMatch =false;
    	
    	myDriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	// sets an implicit timer of 50 seconds
    	
    	String url = "https://www.trybooking.com/book/search";
    	// url contains the page for this script.
    	myDriver.get(url);
    	
    	System.out.println("The featured events for today are:");
    	System.out.println("===============================================:");		
    	
    	//Lets select the parent element of the h2 tag, which is the <div class="inner"> element
    	String parent_Xpath = " //h2[ contains( text(), 'Featured Events') ]//parent::div   " ;
    	By parentElementSelector = By.xpath( parent_Xpath )   ;
    	WebElement parentElement = myDriver.findElement(parentElementSelector);
    	
    	// now lets move down from the parent element to the selected <h6>...</h6> elements
    	String child_Xpath = "./descendant::div//div//a//div//h6";
    	By childElementSelector = By.xpath( child_Xpath)  ;
    	
    	List<WebElement> childElements =parentElement.findElements(childElementSelector);
    	for (WebElement childElement : childElements)
    	{
    		tmpArrayList1.add( childElement.getText()  );
        	System.out.println(childElement.getText()); 
        	//this prints out the featured 
        	
    	}// close for loop
    	
    	System.out.println(" ");
    	System.out.println(" ");
    	System.out.println("lets wait for two minutes.....");
    	Thread.sleep(50000);
    	//Thread.sleep(120000);
    	//myDriver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
    	// sets an implicit timer of 120 seconds
    	
    	
    	
    	//I know I could create a method call to make this code simpler and more 
    	//efficient, but I just want this code to work...
    	
    	
    	System.out.println(" ");
    	System.out.println(" ");
    	System.out.println("Have they changed?.....");
    	
    	System.out.println(" ");
    	System.out.println(" ");
    	System.out.println("The updated featured events for today are:");
    	System.out.println("===============================================:");	

        
    	//Lets select the parent element of the h2 tag, which is the <div class="inner"> element
    	parent_Xpath = " //h2[ contains( text(), 'Featured Events') ]//parent::div   " ;
    	parentElementSelector = By.xpath( parent_Xpath )   ;
    	parentElement = myDriver.findElement(parentElementSelector);
    	
    	// now lets move down from the parent element to the selected <h6>...</h6> elements
    	child_Xpath = "./descendant::div//div//a//div//h6";
    	childElementSelector = By.xpath( child_Xpath)  ;
    	
    	childElements =parentElement.findElements(childElementSelector);
    	for (WebElement childElement : childElements)
    	{
    		tmpArrayList2.add( childElement.getText()  );
        	System.out.println(childElement.getText()); 
        	//this prints out the featured 
        	
    	}// close for loop
    	
    	

    	
    	 // Now test if the list of featured events match
    	 
    	
    	

    	FeaturedEventListsMatch = tmpArrayList1.equals(tmpArrayList2);
    	
    	if (FeaturedEventListsMatch)
    	{
        	System.out.println(" ");
        	System.out.println(" ");
    		System.out.println("The list of events have not changed, lists match!  "); 
    	}
    	
    	
    	assertTrue( FeaturedEventListsMatch);  

    	
     }// close  void Test1()
    



	//=========================================================================	
	/*  
	 * This test will search the event headings for those events that have been cancelled.
	 */
	  
	 
            
    /// implement your tests cases from here...
    @Test
    // @Disabled
    @Order(2)
    @DisplayName("TC02: Check cancelled events: if test passes, there are no cancelled events")
     void Test2() throws Exception
     {
    	Boolean cancelledFound =true;
    	// change to true if the heading 2 title contains 'cancelled'
    	
    	String toDaysDate ="December 10, 2022";
    	// change this date to the date of the event you are searching for. 
    	
    	//List<String> tmpArrayList = new ArrayList<>();
    	// this will contain the 
    	
    	String eventHeading ="";

    	
    	myDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	myDriver.get("https://www.trybooking.com/book/search");
        //myDriver.manage().window().setSize(new Dimension(980, 1557));
        myDriver.findElement(By.id("txtLocation")).sendKeys("3182 ");

        // select date picker control datePickerControlXpath, datePickerControlSelector, datePickerControl
        
        String datePickerControlXpath  = "//input[@class = 'w-full calendar-icon-black form-control input']";
        By datePickerControlSelector =By.xpath(datePickerControlXpath);
        
        WebElement datePickerControl= myDriver.findElement(datePickerControlSelector);
        //click this to select, and cause the populated date picker to appear.
        // by default, it will populate with today's date
        datePickerControl.click();
        
        // if today's date is contained in $toDaysDate
        // clicking the <span>...</span> for that date should populate the date control....
        // you just need to search by aria-label="November 25, 2022", or aria-label= toDaysDate
        //
        
         String dateTodayXpath ="//span[@aria-label ='" + toDaysDate +"']";
         By dateTodaySelector =By.xpath(dateTodayXpath);
         WebElement dateToday= myDriver.findElement(dateTodaySelector);
         dateToday.click();   
         
         // lets click the "Find Events" button
         myDriver.findElement(By.id("btnSearch")).click();

        Thread.sleep(2000);
        
        // Now need to search the Search Results for those events that have "Cancelled" in it. 
    	//Lets select the parent element of the h2 tag, which is the <div class="inner"> element
    	String parent_Xpath = " //h2[ contains( text(), 'Search Results') ]//parent::div   " ;
    	By parentElementSelector = By.xpath( parent_Xpath )   ;
    	WebElement parentElement = myDriver.findElement(parentElementSelector);
    	
    	// now lets move down from the parent element to the selected <h6>...</h6> elements
    	String child_Xpath = "./descendant::div//div//a//div//h6";
    	By childElementSelector = By.xpath( child_Xpath)  ;
    	
    	List<WebElement> childElements =parentElement.findElements(childElementSelector);
    	for (WebElement childElement : childElements)
    	{
    		//tmpArrayList.add( childElement.getText()  );
    		eventHeading = childElement.getText();
        	System.out.println(eventHeading); 
        	if (eventHeading.contains("(Cancelled)") )
        	{
        		cancelledFound =false;
        	}
        	
        	//this prints out the featured 
        	
    	}// close for loop
        
        
    	assertTrue( cancelledFound);  
        

        
    
        
        
     }// close void Test2() throws Exception
    	
            
    
	//=========================================================================	
	/*  
	 *  
	 * Test passes if the event is sucessfully booked. 
	 */   
	
    
    /// implement your tests cases from here...
    @Test
    // @Disabled
   
    @Order(3)
    @DisplayName("TC03: Book into an event (ADVANCED TASK): True if booking successful")
     void Test3() throws Exception
     {
    	String dateEventBooked ="2022-12-11";
    	// date booking event is to be booked. 
    	
    	//boolean eventBooked=false;
    	//this is a flag to confirm if the test past or not.
    	
    	// Search for the event to book
    	
    	 myDriver.get("https://www.trybooking.com/book/search");
    	 //WebDriverWait wait = new WebDriverWait(  myDriver, Duration.ofSeconds(51) );
    	 //myDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	 
    	 //populate the Search Events form
    	 myDriver.findElement(By.id("txtKeyword")).sendKeys("Makerspace");
    	 // this finds and enters the name of the event into the form element
    	 
    	 myDriver.findElement(By.id("txtLocation")).sendKeys("CARLTON SOUTH, 3053, VIC");
    	 // choose the location as post code "3053"
    	 
    	 myDriver.findElement(By.id("btnSearch")).click();
    	 // search for the "Makerspace" events in post code "3053"
    	 
    	 Thread.sleep(4000);
    	 
    	 //Select the Event "Robogals at Kathleen Syme Library" 
    	 String selectedEventXpath ="//h6[ contains( text(), 'Robogals at Kathleen Syme Library') ]";
    	 By selectedEventSelector =By.xpath(selectedEventXpath);
    	 WebElement selectedEvent= myDriver.findElement(selectedEventSelector);
    	 
    	 selectedEvent.click();  
    	 
    	 //myDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	
    	 
    	 // this selects the date of the event
    	 String dateBookedXpath ="//td[@data-date ='" + dateEventBooked +"']";
    	 By dateBookedSelector =By.xpath(dateBookedXpath);
    	 WebElement dateBooked= myDriver.findElement(dateBookedSelector);
    	 dateBooked.click(); 
    	
    	 //this books the event by clicking the "Book Now" event
    	 String BookNowEventXpath ="//a[ contains( text(), 'Book now') ]";
    	 By BookNowEventSelector =By.xpath(BookNowEventXpath);
    	 WebElement BookNowEvent= myDriver.findElement(BookNowEventSelector);
    	 BookNowEvent.click();  
    	 
    	 //myDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	 
    	 //increment the number of attendees by one by clicking the "+" symbol
    	 //String IncrementBtnXpath ="//button[ contains( text(), '+') ]";
    	 String IncrementBtnXpath =" //button[@class ='step plus'] ";
    	 By IncrementBtnSelector =By.xpath(IncrementBtnXpath);
    	 WebElement IncrementBtn= myDriver.findElement(IncrementBtnSelector);
    	 IncrementBtn.click(); 
    	 
    	 
    	 
    	 
    	//this performs the next step operation and 
    	 String NextStepXpath ="//a[ contains( text(), 'Next') ]";
    	 By NextStepSelector =By.xpath(NextStepXpath);
    	 WebElement NextStep= myDriver.findElement(NextStepSelector);
    	 NextStep.click();  
    	 
    	 Thread.sleep(4000);
    	
    	 
    	 // Complete the Booking details to check out the subscription
    	 
    	 myDriver.findElement(By.id("txtFirstName")).sendKeys("Peter Francis");
    	 // Booking details, First Name
    	 
    	 myDriver.findElement(By.id("txtLastName")).sendKeys("Liddle");
    	 // Booking details, Last Name
    	 
    	 String selectedCountryXpath ="//option[ contains( text(), 'Australia') ]";
    	 By selectedCountrySelector =By.xpath(selectedCountryXpath);
    	 WebElement selectedCountry= myDriver.findElement(selectedCountrySelector);
    	 selectedCountry.click();  
    	 //Booking details, Country
    	 
    	 myDriver.findElement(By.id("txtPhoneNumber")).sendKeys("0476136593");
    	 // Booking details, phone number
    	 
    	 myDriver.findElement(By.id("txtAddress")).sendKeys("36 Lasder Road");
    	 // Booking details, street address
    	 
    	 myDriver.findElement(By.id("txtCity")).sendKeys("Croydon");
    	 // Booking details, city
    	 
    	 myDriver.findElement(By.id("txtPostCode")).sendKeys("3136");
    	 // Booking details, post code
    	 
    	 myDriver.findElement(By.id("txtEmailAddress")).sendKeys("s9905648@student.rmit.edu.au");
    	 // Booking details, Email Address
    	 
    	 myDriver.findElement(By.id("txtConfirmEmailAddress")).sendKeys("s9905648@student.rmit.edu.au");
    	 // Booking details, Confirm Email Address
    	 
    	 String PurchaseBtnXpath ="//button[ contains( text(), 'Purchase') ]";
    	 By PurchaseBtnSelector =By.xpath(PurchaseBtnXpath);
    	 WebElement PurchaseBtn= myDriver.findElement(PurchaseBtnSelector);
    	 
    	 Thread.sleep(4000);
    	 
    	 PurchaseBtn.click();  
    	 //this purchases the selected event that has been populated with booking details 
    	 
    	 String child_Xpath = "//span[ contains( text(), 'Transaction successful') ]";
    	 By childElementSelector = By.xpath( child_Xpath)  ;
    	 WebElement childElement =myDriver.findElement(childElementSelector);
    	 String tmp=childElement.getText();
    	 
    	 System.out.println(tmp);
    	 // This is a diagnostic
    	 assertEquals("Transaction successful",tmp  );
    	 // if they match, test passes. 

    	
     }// close void Test3()
    
	


    
    
    
	//=========================================================================	
	/*  
	 *  This method closes the browser...
	 *   
	 *   
	 */	
    @AfterEach
    void tearDown() 
    {
        //myDriver.close();
        myDriver.quit();
    }// close
    
    
    

    
    
    
    
}// close