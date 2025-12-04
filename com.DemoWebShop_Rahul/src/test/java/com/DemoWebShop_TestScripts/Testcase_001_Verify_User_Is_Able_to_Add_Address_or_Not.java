package com.DemoWebShop_TestScripts;

import java.io.IOException;

import org.apache.poi.ss.formula.functions.Address;
import org.testng.annotations.Test;

import com.DemoWebShop_GeneralUtility.Base_Test;
import com.DemoWebShop_GeneralUtility.WebDriverUtility;
import com.DemoWebShop_POM.AddNewAddress_page;
import com.DemoWebShop_POM.Addresses_Page;

public class Testcase_001_Verify_User_Is_Able_to_Add_Address_or_Not extends Base_Test {
	
	@Test
	public void addAddress() throws IOException, InterruptedException
	{
		System.out.println("Address added");
		webdriverUtility.javascriptScrollIntoView(driver, homepage.getAddressesBtn());
		homepage.getAddressesBtn().click();
			
		Addresses_Page addresspage =new Addresses_Page(driver);
		addresspage.getAddNewBtn().click();
		
		AddNewAddress_page addNewAddressPage=new AddNewAddress_page(driver);
		
		addNewAddressPage.getFirstNameTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1,0));
		addNewAddressPage.getLastNameTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 1));
		addNewAddressPage.getEmailTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 2));
		
		webdriverUtility.selectByVisibleText(addNewAddressPage.getCountryDropDown(), fileUtility.readDataFromExcelFile("Sheet1", 1,3));
		addNewAddressPage.getCityTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 4));
		addNewAddressPage.getAdress1_TextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 5));
		addNewAddressPage.getPostal_Code().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 6));
		addNewAddressPage.getPhoneNumber().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 7));
		addNewAddressPage.getSave_Btn().click();
		
		Thread.sleep(2000);
		webdriverUtility.webPageScreenShot(driver);
		
		
		
		
		
	}

}
