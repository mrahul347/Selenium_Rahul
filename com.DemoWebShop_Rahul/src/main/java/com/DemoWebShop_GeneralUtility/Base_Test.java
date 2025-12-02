package com.DemoWebShop_GeneralUtility;
		
	import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.AfterSuite;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeSuite;
	import org.testng.annotations.BeforeTest;

import com.DemoWebShop_POM.Home_Page;
import com.DemoWebShop_POM.Login_Page;
import com.DemoWebShop_POM.Welcome_Page;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

	public class Base_Test {
		
		public WebDriver driver;
		public static WebDriver sDriver;
		public FileUtility fileUtility=new FileUtility();
		public ExtentSparkReporter spark;
		public ExtentReports reports;
		public ExtentTest test;
		public Welcome_Page welcomepage;
		public Login_Page loginpage;
		public Home_Page homepage;
		public WebDriverUtility webdriverUtility =new WebDriverUtility();
		
		
		
		@BeforeSuite
		public void beforeSuite() {
		    System.out.println("DataBase Connected");
		}
		@BeforeTest
		public void beforetest() {
		    System.out.println("Pre Conditions");
		    
		    spark= new ExtentSparkReporter(FrameWorkConstants.reportsPath);
		    reports= new ExtentReports();
		    reports.attachReporter(spark);
		    test = reports.createTest("Address");
		    
		}
		@BeforeClass
		public void beforeClass() throws IOException {
			System.out.println("Launch Browser");
			
			String browser=fileUtility.readDataFromPropertyFile("browserName");
			String url=fileUtility.readDataFromPropertyFile("url");
			
			
			//String browser = System.getProperty("browserName");
			// String url = System.getProperty("baseUrl");
			if (browser.equalsIgnoreCase("chrome"))
			{
				driver =new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("edge"))
			{
				driver =new EdgeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox"))
			{
				driver =new FirefoxDriver();
			}
			else
			{
				System.out.println("Enter valid browser Name");
			}
			sDriver =driver;
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			driver.get(url);		
		}
		@BeforeMethod
		public void beforeMethod() throws IOException {
			System.out.println("Login");
			welcomepage=new Welcome_Page(driver);
			welcomepage.getLoginLink().click();
			
			loginpage = new Login_Page(driver);
			loginpage.getEmailTextField().sendKeys(fileUtility.readDataFromPropertyFile("username"));
			loginpage.getPasswordTextField().sendKeys(fileUtility.readDataFromPropertyFile("password"));
			loginpage.getLoginBtn().click();
			
			homepage =new Home_Page(driver);
		
			
		}
		 @AfterSuite
		    public void afterSuite() {
		     System.out.println(" DataBase disconnected");
			}
	
	   
	    @AfterTest
	    public void afterTest() {
	      System.out.println("post Condition");
	      reports.flush();

		}
	    @AfterClass
	    public void afterClass() throws InterruptedException {
	    	System.out.println("Close Browser");
	    	Thread.sleep(3000);
	    	driver.quit();
		}
	    @AfterMethod
		public void afterMethod() {
			System.out.println("Logout");
			homepage.getLogOutBtn().click();
		}
	    
		
		
	}


