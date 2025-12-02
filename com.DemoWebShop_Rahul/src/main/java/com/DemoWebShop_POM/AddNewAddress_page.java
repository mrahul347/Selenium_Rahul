package com.DemoWebShop_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewAddress_page {
	
	public AddNewAddress_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "Address_FirstName")
	private WebElement firstNameTextField;
	
	@FindBy(id= "Address_LastName")
	private WebElement lastNameTextField;
	
	@FindBy(id= "Address_Email")
	private WebElement emailTextField;
	
	@FindBy(id ="Address_CountryId")
	private WebElement countryDropDown;
	
	@FindBy(id ="Address_City")
	private WebElement cityTextField;
	
	@FindBy(id = "Address_ZipPostalCode")
	private WebElement postal_Code;
	
	@FindBy(id = "Address_Address1")
	private WebElement adress1_TextField;
	
	@FindBy(id = "Address_PhoneNumber")
	private WebElement phoneNumber;
	
	@FindBy(xpath = "//input[@value='Save']")
	private WebElement save_Btn;

	public WebElement getFirstNameTextField() {
		return firstNameTextField;
	}

	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getCountryDropDown() {
		return countryDropDown;
	}

	public WebElement getCityTextField() {
		return cityTextField;
	}

	public WebElement getPostal_Code() {
		return postal_Code;
	}

	public WebElement getAdress1_TextField() {
		return adress1_TextField;
	}

	public WebElement getPhoneNumber() {
		return phoneNumber;
	}

	public WebElement getSave_Btn() {
		return save_Btn;
	}
	
	
	

	

}
