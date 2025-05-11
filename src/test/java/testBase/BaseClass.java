package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass(groups= {"Sanity", "Master"})
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException
	{
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		
		logger= LogManager.getLogger(this.getClass());
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities=new DesiredCapabilities();
			
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
				
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No Matching OS");
				return;
			}
			
			switch(br.toLowerCase())
			{
			case "chrome": capabilities.setBrowserName("chrome");break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge");break;
			default: System.out.println("No Matching Browser");return;
			}
			
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		}
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			switch(br.toLowerCase())
			{
			case "chrome":driver=new ChromeDriver();break;
			case "edge":driver=new EdgeDriver();break;
			case "firefox":driver=new FirefoxDriver();break;
			default:System.out.println("Invalid Browser Name...");return;
			
			}
		}
		
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(p.getProperty("URL"));
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups= {"Sanity", "Master"})
	public void tearDown()
	{
		driver.quit();
	}
	
	
	public String captureScreen(String tname) throws IOException {
	    String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	    TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	    File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

	    String relativePath = "screenshots" + File.separator + tname + "_" + timeStamp + ".png";
	    String targetFilePath = System.getProperty("user.dir") + File.separator + relativePath;

	    File targetFile = new File(targetFilePath);
	    FileUtils.copyFile(sourceFile, targetFile);

	    System.out.println("Screenshot saved successfully at: " + targetFilePath);
	    return relativePath;  // return relative path instead of absolute
	}


}
