package com.DemoWebShop_GeneralUtility;

public interface FrameWorkConstants {
	
	JavaUtility javaUtility= new JavaUtility();
	
	static final String propertyPath ="./src/test/resources/Testdata/properties";
	
	static final String excelPath ="./src/test/resources/TestData/Datafile.xlsx";
	
	static final String screenshotPath="./Screenshots/" + javaUtility.localDateandTime() + ".png";
	
	static final String reportsPath="./reports/" + javaUtility.localDateandTime() + ".html";

}
