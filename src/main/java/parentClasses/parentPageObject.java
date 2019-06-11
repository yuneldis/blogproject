package parentClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
* Esta clase define la clase Padre donde se define los metodos comunes para las Page Objects.
* @author: Yanet Rosales
*/
public class parentPageObject 
{
	protected WebDriver driver;
	private static final int ELEMENT_WAIT_TIMEOUT_IN_SECONDS = 10;
	
	public parentPageObject(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void connectPage(String url)
    {
        driver.manage().window().maximize();
        driver.get(url);
    }
	
	    /**
	    * Método que permite esperar a que se muestre el elemento de la Web pasado por parámetro.
	    * @param element
	    * @return WebElement
	    */
		public WebElement waitForElement(final WebElement element) 
		{
			WebElement result = null;
			try {
				result = new WebDriverWait(driver, ELEMENT_WAIT_TIMEOUT_IN_SECONDS).until(ExpectedConditions.visibilityOf(element));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		    return result;
		}
}
