package com.rangam.SourceVets.Utilities;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;


// For generating Extent Reports
public class ExtentManager {
	
	
	private static ExtentReports extent;
	
	
	public static ExtentReports getInstance()
	{
		
		if(extent==null)
		{
			
			// To store the extent.html file in particular folder
			extent = new ExtentReports(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\extent.html",true,DisplayOrder.OLDEST_FIRST);
			extent.loadConfig(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\extentConfig\\ReportsConfig.xml"));
			
			
		}
		
		return extent;
		
	}

}
