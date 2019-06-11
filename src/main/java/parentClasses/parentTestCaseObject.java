package parentClasses;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class parentTestCaseObject 
{
	protected WebDriver driver;
	boolean disableCookies = true;
	
	//@Parameters({"browser"})
	@BeforeClass
	public void initDesiredCapabilities(/*String browser*/) 
	{
		    String browser = "chrome";
			String currentDir = System.getProperty("user.dir");
	        System.out.println("Current dir using System:" +currentDir);
	        
			// Set specific settings of Firefox
	        switch (browser) 
	        {
            	case "firefox":
					FirefoxProfile profile = new FirefoxProfile();
					if (disableCookies) 
					{
					 	profile.setPreference("network.cookie.cookieBehavior", 2);
					}
					System.setProperty("webdriver.gecko.driver", currentDir + "/src/main/resources/Drivers/geckodriver.exe");
					driver = new FirefoxDriver();
	
				// Set specific settings for Chrome.
            	default:
					System.setProperty("webdriver.chrome.driver", currentDir + "/src/main/resources/Drivers/chromedriver.exe");
					driver = new ChromeDriver();
	        }			
			/* Set performance logger this sends Network enable to the browser*/
			LoggingPreferences logPrefs = new LoggingPreferences();
		    logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public void setdisableCookies(boolean disableCookies) 
	{
		this.disableCookies = disableCookies;
	}
	
	/**
	 * Método que permite cerrar la conexión del WebDriver una vez terminado el TC
	 */
	@AfterClass
	public void quit() 
	{
		this.driver.quit();
	}
	
	

}
