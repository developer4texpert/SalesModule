package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConsultantsPage extends BasePage{

	public ConsultantsPage(WebDriver driver)
	{
		super(driver);
	}
	
	// Web Elements
	@FindBy(xpath="//input[@placeholder='Search by consultant or skill']")
	private WebElement searchBox;
	
	@FindBy(xpath="(//span[@class='p-button-label ng-star-inserted'])[1]")
	private WebElement searchButton;
	
	@FindBy(xpath="(//tbody[@class='p-element p-datatable-tbody']//td[@title='Hasini Amara']//span)[1]")
	private WebElement consultantSearchResult;
	
	@FindBy(xpath="(//tbody[@class='p-element p-datatable-tbody']//td)[2]//span")
	private WebElement skillSearchResult;
	
	@FindBy(xpath="//span[normalize-space()='INSERT CONSULTANT']")
	private WebElement insertConsultantButton;
	
	
	
	// Action Methods
	public void enterConsultantOrSkillInSearchBox(String searchText)
	{
		searchBox.sendKeys(searchText);
	}
	
	public void consultantOrSkillSearchButton()
	{
		searchButton.click();
	}
	
	public String retrieveConsultantSearchResult()
	{
		String consultantText=consultantSearchResult.getText();
		return consultantText;
	}
	
	public String retrieveSkillSearchResult()
	{
		String skillText=skillSearchResult.getText();
		return skillText;
	}
	
	public void clickOnInsertConsultant()
	{
		insertConsultantButton.click();
	}
}


