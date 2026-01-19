package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage
{
	//constructor
	
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	//Locators
	
	@FindBy(xpath="//i[@class='fa-solid fa-user']")
	WebElement link_MyAccount;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement link_login;
	
	@FindBy(xpath="//a[normalize-space()='Laptops & Notebooks']")
	WebElement laptops_Notebooks;
	
	@FindBy(xpath="///a[normalize-space()='Show All Laptops & Notebooks']")
	WebElement all_Laptops_Notebooks;
	
			
		
	//ActionMethods
	
	public void clickMyAccount()
	{
		link_MyAccount.click();
		
	}
	
	public void goToLogin()
	{
		link_login.click();
	}
	
	public void clickLaptopNotebooks()
	{
		laptops_Notebooks.click();
	}
	
	public void clickAllLaptopsNotebooks()
	{
		all_Laptops_Notebooks.click();
	}
}
