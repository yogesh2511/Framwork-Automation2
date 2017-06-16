package com.rangam.SourceVets.Listeners;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.ISuite;
import org.testng.ISuiteListener;

//import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.rangam.SourceVets.Base.TestBase;
import com.rangam.SourceVets.Utilities.MonitoringMail;
import com.rangam.SourceVets.Utilities.TestConfig;
import com.rangam.SourceVets.Utilities.TestUtil;
import com.relevantcodes.extentreports.LogStatus;

public class CustomListeners extends TestBase implements ITestListener, ISuiteListener {

	public void onFinish(ITestContext arg0) {

	}

	public void onStart(ITestContext arg0) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

	}

	public void onTestFailure(ITestResult arg0) {

		System.setProperty("org.uncommons.reportng.escape-output", "false");

		try {

			TestUtil.captureScreenshot();

			// test.log(LogStatus.FAIL, arg0.getName().toUpperCase()+"
			// Failed!");
			// repo.endTest(test);
			// repo.flush();

		} catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Test");
		Reporter.log("Capturing Screenshot");
		Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + ">Click on Screenshot</a>");

		// Reporter.log("<a target=_blank href="+TestUtil.screenshotPath+">Click
		// on Screenshot</a>");

		System.out.println("Test2");
		Reporter.log("<br>");
		// Reporter.log("<a target=\"_blank\"
		// href="+TestUtil.screenshotName+"><img src="+TestUtil.screenshotName+"
		// height=200 width=200></img></a>");
		test.log(LogStatus.FAIL, arg0.getName().toUpperCase() + " Failed!");
		System.out.println("Test3");
		repo.endTest(test);
		repo.flush();

	}

	public void onTestSkipped(ITestResult arg0) {

	}

	public void onTestStart(ITestResult arg0) {

		test = repo.startTest(arg0.getName().toUpperCase());
	}

	public void onTestSuccess(ITestResult arg0) {

		test.log(LogStatus.PASS, arg0.getName().toUpperCase() + " PASS");
		repo.endTest(test);
		repo.flush();

	}

	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ISuite suite) {

		MonitoringMail mail = new MonitoringMail();

		try {
			mail.sendMail(TestConfig.server, TestConfig.port,TestConfig.from, TestConfig.to, TestConfig.subject, TestConfig.messageBody,
					TestConfig.attachmentPath, TestConfig.attachmentName);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
