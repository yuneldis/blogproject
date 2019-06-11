package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import parentClasses.parentPageObject;

import java.util.List;

public class blogSearchResultsPage extends parentPageObject
{
	@FindBy(how = How.CLASS_NAME,using="search-results")
	private WebElement list_result_search;

	public blogSearchResultsPage(WebDriver driver) 
	{
		super(driver);
	}
	public List<WebElement> getList_result_search() 
	{		
		return waitForElement(list_result_search).findElements(By.className("search-result"));
	}
	
	public String getArticuleName(WebElement liWebElement)
	{
		return waitForElement(liWebElement.findElement(By.className("title"))).getText();
	}
	/*public String getArticuleLink(WebElement liWebElement)
	{
		return waitForElement(liWebElement.findElement(By.cssSelector(("a.item__info-link.item__js-link ")))).getAttribute("href");
	}*/
}
