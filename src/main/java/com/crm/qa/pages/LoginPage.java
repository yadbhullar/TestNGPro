package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory or Object repository means equivalent to find element(By.name or xpath)
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmlogo;
	
	
	// intialize of objects in the object repository means equivalent to driver.find element in constructor
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions means what you want to do
	
	public String validateLoginpageTitle()
	{
		return  driver.getTitle();
	}
	
	public boolean validateCRMImage()
	{
		return crmlogo.isDisplayed();
	}
	
	public HomePage login(String un,String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		
		WebDriverWait wait = new WebDriverWait(driver, 3);
		
		boolean invisible=wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("preloader")));
		
		if(invisible)
		{
			
			loginbtn.click();
		}
		
		
		return new HomePage(); // after login redirect to home page
	}
	
	

}
