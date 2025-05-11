package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ConsultantsPage;
import pageObjects.LoginPage;
import pageObjects.MarketerHomePage;
import testBase.BaseClass;

public class TC0004_SearchByConsultant extends BaseClass{
	
	@Test(groups={"Regression","Master"})
	public void verifySearchWithValidConsultant() throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserLoginId(p.getProperty("email"));
		lp.setUserPassword(p.getProperty("password"));
		lp.clickOnLoginButton();
		
		MarketerHomePage MHP=new MarketerHomePage(driver);
		MHP.clickOnConsultants();
		
		ConsultantsPage consultantpage=new ConsultantsPage(driver);
		consultantpage.enterConsultantOrSkillInSearchBox("Hasini");
		consultantpage.consultantOrSkillSearchButton();
		
		String actualConsultantName=consultantpage.retrieveConsultantSearchResult();
		String expectedConsultantName="Hasini Amara";
		
		Assert.assertEquals(actualConsultantName,expectedConsultantName);	
	}

}
