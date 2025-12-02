package com.DemoWebShop_TestScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.DemoWebShop_GeneralUtility.Base_Test;
import com.DemoWebShop_POM.AddNewAddress_page;
import com.DemoWebShop_POM.Addresses_Page;


public class Testcase_002_Verify_User_Is_able_to_Delete_Address_or_Not extends Base_Test{
	
	@Test
	public void addAddress() throws InterruptedException, IOException
	{
		webdriverUtility.javascriptScrollIntoView(driver, homepage.getAddressesBtn());
		homepage.getAddressesBtn().click();
		
		Addresses_Page addressespage =new Addresses_Page(driver);
		addressespage.getDeleteBtn().click();
		
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		webdriverUtility.webPageScreenShot(driver);
	}

}
