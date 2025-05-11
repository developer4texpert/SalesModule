package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.MarketerHomePage;
import testBase.BaseClass;

public class TC_LoginTest extends BaseClass{
	
 
	@Test(groups={"Sanity", "Master"})
	public void verify_user_login()
	{
		logger.info("******* Starting TC_LoginTest ********");
		
		try
		{
			LoginPage lp=new LoginPage(driver);
			
			lp.setUserLoginId(p.getProperty("email"));
			logger.info("********* Entered User Login ID *********");
			
			lp.setUserPassword(p.getProperty("password"));
			logger.info("******** Entered User Password **********");
			
			lp.clickOnLoginButton();
			logger.info("******* Clicked on Login Button");
			
			
			MarketerHomePage MHP=new MarketerHomePage(driver);
			
			logger.info("***** Login is passed ********");
			Assert.assertTrue(MHP.getDisplayStatusOfConsultantsLink());
			
		}
		
		catch(Exception e)
		{
			logger.error("Test failed.....");
			logger.debug("Debug Logs");
			Assert.fail();
		}
		
		logger.info("***** Finished TC_LoginTest ********");
			
	}	
}
