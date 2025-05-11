package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MarketerHomePage extends BasePage{

	
	public MarketerHomePage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//span[normalize-space()='Consultants']")
	WebElement consultantlink;
	
	public boolean getDisplayStatusOfConsultantsLink()
	{
		boolean displayStatus=consultantlink.isDisplayed();
		return displayStatus;
	}
	
	public void clickOnConsultants() {
		consultantlink.click();	
	}
	
}
