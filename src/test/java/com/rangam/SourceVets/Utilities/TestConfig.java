package com.rangam.SourceVets.Utilities;
public class TestConfig{


	
	public static String server="mail.rangam.com";
	public static String port="25";
	public static String from = "yogeshsolanki@rangam.com";
	public static String password = "june@2017";
	public static String[] to ={"yogeshsolaki@rangam.com"};
//	public static String[] bcc = {"yogeshsolanki@rangam.com"};
	public static String subject = "SourceVets Automation Report";
	
	public static String messageBody ="Please Find Attachment For the Report";
	public static String attachmentPath=System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\extent.html";
	public static String attachmentName="Report.html";
	
	
	/*
	//SQL DATABASE DETAILS	
	public static String driver="net.sourceforge.jtds.jdbc.Driver"; 
	public static String dbConnectionUrl="jdbc:jtds:sqlserver://192.101.44.22;DatabaseName=monitor_eval"; 
	public static String dbUserName="sa"; 
	public static String dbPassword="$ql$!!1"; 
	
	
	//MYSQL DATABASE DETAILS
	public static String mysqldriver="com.mysql.jdbc.Driver";
	public static String mysqluserName = "root";
	public static String mysqlpassword = "selenium";
	public static String mysqlurl = "jdbc:mysql://localhost:3306/acs";
	
	
	
	*/
	
	
	
	
	
}
