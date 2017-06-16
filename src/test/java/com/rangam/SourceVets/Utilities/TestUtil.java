package com.rangam.SourceVets.Utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.rangam.SourceVets.Base.TestBase;

public class TestUtil extends TestBase {

	public static String screenshotPath;
	public static String screenshotName;
	// public static String screenshotPath;

	public static void captureScreenshot() {
		// Source file
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		System.out.println(d);

		String screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		// String screenshotName = System.currentTimeMillis()+".jpg";

		// screenshotName = "Desert.jpg";

		// Destination File
		// File screenshotPath = new
		// File(System.getProperty("user.dir")+"//target//surefire-reports//html//"+screenshotName)
		// ;

		try {
			FileUtils.copyFile(scrFile,
					new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName));

			System.out.println("Test util 1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Test util 2");
		}

	}

}
