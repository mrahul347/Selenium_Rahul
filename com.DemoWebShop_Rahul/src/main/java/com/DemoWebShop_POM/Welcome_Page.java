package com.DemoWebShop_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Welcome_Page {
	
	public Welcome_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//a[text()='Log in']")
	private WebElement loginLink;
	
	@FindBy(id="dropdownMenuButton")
	private WebElement dropdown;
	@FindBy(linkText = "Logout")
    private WebElement logoutLink;

    // Action method for logout
    public void clickLogout() {
        dropdown.click();
        logoutLink.click();
    }

	public WebElement getLoginLink()
	{
		return loginLink;
	}

	public WebElement getDropdown() {
		return dropdown;
	}
	public WebElement getLogoutLink() {
		return logoutLink;
	}

}
