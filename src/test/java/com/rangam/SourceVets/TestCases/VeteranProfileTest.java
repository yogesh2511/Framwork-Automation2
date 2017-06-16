package com.rangam.SourceVets.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.rangam.SourceVets.Base.TestBase;

//import sun.security.x509.IssuerAlternativeNameExtension;

public class VeteranProfileTest extends TestBase {
	
	@Test(priority=1)
	public void veteranProfileTestMandatoryFieldRequiredAlertMessageVerification() throws InterruptedException
	{
		
		driver.get(Config.getProperty("testsiteurl"));
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicit.wait")),TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(OR.getProperty("youtubeCloseButton"))).click();
		
		
		Thread.sleep(3000);
		
	//	driver.findElement(By.xpath(OR.getProperty("LoginButton"))).click();
		
		driver.findElement(By.xpath(OR.getProperty("LoginButton"))).click();
		
	//	driver.findElement(By.linkText("LOGIN")).click();
		
		driver.findElement(By.xpath(OR.getProperty("emailAddress"))).clear();
		
		driver.findElement(By.xpath(OR.getProperty("emailAddress"))).sendKeys("bhavinrana@rangam.com");
		
		driver.findElement(By.xpath(OR.getProperty("password"))).clear();
		
		driver.findElement(By.xpath(OR.getProperty("password"))).sendKeys("rangam@123");
		
		driver.findElement(By.xpath(OR.getProperty("SubmitButton"))).click();
		
	//	Assert.assertEquals(driver.findElement(By.xpath("PersonalInformationTab")).getText(), "Personal Information");
		
		//Assert.assertTrue(isElementPresent(By.xpath("PersonalInformationTab")), "Profile Information Tab is not active");
		
	//	Assert.assertTrue((new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(OR.getProperty("PersonalInformationTab")))))).isSelected(),"Profile Information Tab is not Selected");
		
		driver.findElement(By.xpath(OR.getProperty("VeteranFirstName"))).clear();
		
		driver.findElement(By.xpath(OR.getProperty("VeteranMiddleName"))).clear();
		
		driver.findElement(By.xpath(OR.getProperty("VeteranLastName"))).clear();
		
		driver.findElement(By.xpath(OR.getProperty("VeteranContactNo"))).clear();
		
		driver.findElement(By.xpath(OR.getProperty("VeteranOtherEmailAddress"))).clear();
		
		driver.findElement(By.xpath(OR.getProperty("SaveButton"))).click();
				
		Assert.assertEquals(driver.findElement(By.xpath(OR.getProperty("VeteranFirstNameErrorMessage"))).getText(), "Please enter first name");
		
		Assert.assertEquals(driver.findElement(By.xpath(OR.getProperty("VeteranMiddleNameErrorMessage"))).getText(), "Please enter middle name");
		
		Assert.assertEquals(driver.findElement(By.xpath(OR.getProperty("VeteranLastNameErrorMessage"))).getText(), "Please enter last name");
		
		Assert.assertEquals(driver.findElement(By.xpath(OR.getProperty("VeteranContactNoErrorMessage"))).getText(), "Please enter contact number");
		
		Assert.assertEquals(driver.findElement(By.xpath(OR.getProperty("VeteranEmailAddressErrorMessage"))).getText(), "Please enter e-mail address");
		
		driver.findElement(By.xpath(OR.getProperty("veteranProfileIcon"))).click();
		
		driver.findElement(By.xpath(OR.getProperty("veteranLogOutButton"))).click();
	}
	
	
	
	@Test(priority=2)
	public void goToCarrerInterestTab() throws InterruptedException
	{
		
		Thread.sleep(3000);
		
		driver.get(Config.getProperty("testsiteurl"));
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicit.wait")),TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(OR.getProperty("youtubeCloseButton"))).click();
		
		
		Thread.sleep(4000);
		
	//	driver.findElement(By.xpath(OR.getProperty("LoginButton"))).click();
		
		driver.findElement(By.xpath(OR.getProperty("LoginButton"))).click();
		
	//	driver.findElement(By.linkText("LOGIN")).click();
		
		driver.findElement(By.xpath(OR.getProperty("emailAddress"))).clear();
		
		driver.findElement(By.xpath(OR.getProperty("emailAddress"))).sendKeys("bhavinrana@rangam.com");
		
		driver.findElement(By.xpath(OR.getProperty("password"))).clear();
		
		driver.findElement(By.xpath(OR.getProperty("password"))).sendKeys("rangam@123");
		
		driver.findElement(By.xpath(OR.getProperty("SubmitButton"))).click();
		
	//	Assert.assertEquals(driver.findElement(By.xpath("PersonalInformationTab")).getText(), "Personal Information");
		
		//Assert.assertTrue(isElementPresent(By.xpath("PersonalInformationTab")), "Profile Information Tab is not active");
		
	//	Assert.assertTrue((new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(OR.getProperty("careerInterestTab")))))).isSelected(),"Profile Information Tab is not Selected");
		
		
		driver.findElement(By.xpath(OR.getProperty("careerInterestTab"))).click();
		
		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("finishButton"))), "Carrer Interest Page not activated");
				
		driver.findElement(By.xpath(OR.getProperty("veteranProfileIcon"))).click();
		
		driver.findElement(By.xpath(OR.getProperty("veteranLogOutButton"))).click();
		
	}

	

}
