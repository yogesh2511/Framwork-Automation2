package com.rangam.SourceVets.Base;



//package com.rangam.SourceVets.Base.SourceVets;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.rangam.SourceVets.Utilities.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestBase {

	public static WebDriver driver;

	public static Properties Config = new Properties();

	public static Properties OR = new Properties();

	public static FileInputStream fConfig, fOR;
	
	public static String OS = System.getProperty("os.name").toLowerCase();
	
	public static Logger log = Logger.getLogger("devpinoyLogger");
	
	public ExtentReports repo = ExtentManager.getInstance();
	//This will defiine logs inside test
	public static ExtentTest test;
	
	public static WebDriverWait wait;

	@BeforeSuite
	public void setUp() {
		if (driver == null) {

			
			if(OS.contains("mac os x"))
			{
			try {
				fConfig = new FileInputStream(
						System.getProperty("user.dir") + "//src//test//resources//properties//Config.properties");
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}

			try {
				Config.load(fConfig);
				log.debug("Config File Loading");
			} catch (IOException e) {

				e.printStackTrace();
			}

			try {
				fOR = new FileInputStream(
						System.getProperty("user.dir") + "//src//test//resources//properties//OR.properties");
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}

			try {
				OR.load(fOR);
				log.debug("OR File Loading");
			} catch (IOException e) {

				e.printStackTrace();
			}
			}
			else
			{
				
				try {
					fConfig = new FileInputStream(
							System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
				} catch (FileNotFoundException e) {

					e.printStackTrace();
				}

				try {
					Config.load(fConfig);
					log.debug("Config File Loading!!");
				} catch (IOException e) {

					e.printStackTrace();
				}

				try {
					fOR = new FileInputStream(
							System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
				} catch (FileNotFoundException e) {

					e.printStackTrace();
				}

				try {
					OR.load(fOR);
					log.debug("OR File loading!!");
				} catch (IOException e) {

					e.printStackTrace();
				}
				
			}

		}

		selectbrowser();		
		
	}
	
	private void selectbrowser()
	{
		if(Config.getProperty("browser").equals("firefox"))
		{
			
			/*driver = new FirefoxDriver();
			log.debug("Firefox Browser Opened");*/
			if(OS.contains("mac os x"))
			{
			
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//src//test//resources//executables//geckodriver");
				 driver = new FirefoxDriver();
			/*System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//test//resources//executables//chromedriver" );
			driver = new ChromeDriver();*/
			
			}
			else
			{
			
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\geckodriver.exe");
			
			 driver = new FirefoxDriver();
			}
			
		}
		else if(Config.getProperty("browser").equals("chrome"))
		{
			if(OS.contains("mac os x"))
			{
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//test//resources//executables//chromedriver" );
			driver = new ChromeDriver();
			
			}
			else
			{
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
			
			driver = new ChromeDriver();
			}
			
		}
		else if(Config.getProperty("browser").equals("ie"))
		{
			
			if(OS.contains("mac os x"))
			{
			
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"//src//test//resources//executables//chromedriver" );
			driver = new InternetExplorerDriver();
			
			}
			else
			{
			
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
			
			driver = new InternetExplorerDriver();
			}
			
			
		}
		
		driver.get(Config.getProperty("testsiteurl"));
		log.debug("Navigated  to "+Config.getProperty("testsiteurl"));
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicit.wait")),TimeUnit.SECONDS);
	}
	
	public boolean isElementPresent(By by)
	{
		try{
			
			driver.findElement(by);
			log.debug("Element find By:");
			return true;
		}
		catch(NoSuchElementException e)
		{
			
			return false;
		}
		
		
	}

	@AfterSuite
	public void tearDown() {
		if(driver!=null)
		{
		driver.close();
		}
		
		log.debug("Test Execution Completed!!!");
	}

}
