package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import parentClasses.parentPageObject;

public class blogSearchPage extends parentPageObject
{
	@FindBy(how = How.CLASS_NAME,using="form-text")
	private WebElement input_find;
	
	@FindBy(how = How.CLASS_NAME,using="form-submit")
	private WebElement button_search;
	
	private String url = "http://localhost/blogpolitica/search";
	
	public blogSearchPage(WebDriver driver) 
	{
		super(driver);
	}
	
	public WebElement getInput_find()
	{
		return waitForElement(input_find);
	}
	public WebElement getButton_search() 
	{
		return waitForElement(button_search);
	}
	public void connectBlogSearchPage() 
	{
		connectPage(url);
	}
}
