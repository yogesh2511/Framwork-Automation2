package com.rangam.SourceVets.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.rangam.SourceVets.Base.TestBase;



public class RegistrationTest extends TestBase  {
	
	
	
	// Email Address Field blank enter password and click on login button
	@Test(priority=1)
	public void loginAsVeteransEmailFieldBlank() throws InterruptedException
	{
		log.debug("Test Case 1 Started!!");
		
		driver.findElement(By.xpath(OR.getProperty("youtubeCloseButton"))).click();
		
		log.debug("Youtube button closed!!");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(OR.getProperty("LoginButton"))).click();
		
		driver.findElement(By.xpath(OR.getProperty("emailAddress"))).clear();
		
		driver.findElement(By.xpath(OR.getProperty("password"))).clear();
		
		driver.findElement(By.xpath(OR.getProperty("password"))).sendKeys("test@123");
		
		driver.findElement(By.xpath(OR.getProperty("SubmitButton"))).click();
		
		Assert.assertEquals(driver.findElement(By.xpath(OR.getProperty("EmailAddressAlertMessage"))).getText(), "Please enter email");
		
		log.debug("Test Case 1 Completed!!");
		
		Reporter.log("Test Case 1 Completed!!");
		
	}
	
	
	// Enter Email address and password field blank and click on login button
	@Test(priority=2)
	public void loginAsVeteransPasswordFieldBlank() throws InterruptedException
	{
		log.debug("Test Case 2 Started!!");
		driver.get(Config.getProperty("testsiteurl"));
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicit.wait")),TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(OR.getProperty("youtubeCloseButton"))).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(OR.getProperty("LoginButton"))).click();
		
		driver.findElement(By.xpath(OR.getProperty("emailAddress"))).clear();
		
		driver.findElement(By.xpath(OR.getProperty("emailAddress"))).sendKeys("test@test.com");
		
		driver.findElement(By.xpath(OR.getProperty("password"))).clear();
		
		driver.findElement(By.xpath(OR.getProperty("SubmitButton"))).click();
		
		Assert.assertEquals(driver.findElement(By.xpath(OR.getProperty("passwordAlertMessage"))).getText(), "Please enter password");
		
		log.debug("Test Case 2 Completed!!");
		
		Reporter.log("Test Case 2 Completed!!");
	}
	
	
	//Enter wrong email address and wrong password  and click on login button 
	@Test(priority=3)
	public void loginAsVetransEnterWrongEmailAddressAndPassword() throws InterruptedException
	{
		log.debug("Test Case 3 Started!!");
		
		driver.get(Config.getProperty("testsiteurl"));
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicit.wait")),TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(OR.getProperty("youtubeCloseButton"))).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(OR.getProperty("LoginButton"))).click();
		
		driver.findElement(By.xpath(OR.getProperty("emailAddress"))).clear();
		
		driver.findElement(By.xpath(OR.getProperty("emailAddress"))).sendKeys("test@test.com");
		
		driver.findElement(By.xpath(OR.getProperty("password"))).clear();
		
		driver.findElement(By.xpath(OR.getProperty("password"))).sendKeys("test@123");
		
		driver.findElement(By.xpath(OR.getProperty("SubmitButton"))).click();
		
		Assert.assertEquals(driver.findElement(By.xpath(OR.getProperty("wrongEmailAddressAndPasswordAlertMessage"))).getText(), "Please enter correct user name and password.");
		
		log.debug("Test Case 3 Completed!!");
		Reporter.log("Test Case 3 Completed!!");
		
	}
	
	// Enter valid email address and and valid password and click on login button
	@Test(priority=4)
	public void loginAsVateransEnterValidEmailAddressAndPaasword() throws InterruptedException
	{
		log.debug("Test Case 4 Started!!");
		
		
		
		driver.get(Config.getProperty("testsiteurl"));
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicit.wait")),TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(OR.getProperty("youtubeCloseButton"))).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(OR.getProperty("LoginButton"))).click();
		
		driver.findElement(By.xpath(OR.getProperty("emailAddress"))).clear();
		
		driver.findElement(By.xpath(OR.getProperty("emailAddress"))).sendKeys("bhavinrana@rangam.com");
		
		driver.findElement(By.xpath(OR.getProperty("password"))).clear();
		
		driver.findElement(By.xpath(OR.getProperty("password"))).sendKeys("rangam@123");
		
		driver.findElement(By.xpath(OR.getProperty("SubmitButton"))).click();
		
		//boolean profileIcon = driver.findElement(By.xpath(OR.getProperty("veteranProfileIcon"))).is;
		
		//Assert.assertEquals(profileIcon, true, "Login Successfully done");
	
		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("veteranProfileIcon"))),"Login not successfully done");
		
		log.debug("Test Case 4 Completed!!");
	//	Reporter.log("Test Case Fail!!!");
		
	
		
		//Reporter.log("<a href=""> Screenshot </a>");
		
		driver.findElement(By.xpath(OR.getProperty("veteranProfileIcon"))).click();
		
		driver.findElement(By.xpath(OR.getProperty("veteranLogOutButton"))).click();
		
	}
	
	
}
