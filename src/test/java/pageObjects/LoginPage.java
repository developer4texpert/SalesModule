package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(id="username")
	WebElement userLoginId;
	
	@FindBy(id="password")
	WebElement userLoginPassword;
	
	@FindBy(xpath="/html/body/app-root/app-signin/div[1]/div/div[2]/form/div/div[5]/button")
	WebElement loginButton;
	
	public void setUserLoginId(String loginid)
	{
		userLoginId.sendKeys(loginid);
	}
	
	public void setUserPassword(String password)
	{
		userLoginPassword.sendKeys(password);
	}
	
	public void clickOnLoginButton()
	{
		loginButton.click();
	}

}
