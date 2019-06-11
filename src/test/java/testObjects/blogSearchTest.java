package testObjects;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.blogSearchPage;
import pageObjects.blogSearchResultsPage;
import parentClasses.parentTestCaseObject;

public class blogSearchTest extends parentTestCaseObject {
	
	@Test
	public void blogSearchTestMethod() {
		// Create the Object of the Home Page
		blogSearchPage home_object = new blogSearchPage(driver);

		// Go to Blog Home page.
		home_object.connectBlogSearchPage();		

		// Verify if the Page is correct
		Assert.assertEquals(driver.getTitle(), "Buscar | Mundo Político");

		// Enter the Word
		home_object.getInput_find().sendKeys("disidentes");

		// Click into Search Button
		home_object.getButton_search().click();

		// Create the Object of the Search Result Page
		blogSearchResultsPage result_object = new blogSearchResultsPage(driver);

		// Print the Total of Elements
		int numberOfElementsFound = result_object.getList_result_search().size();
		System.out.println("No. of Elements: " + numberOfElementsFound);
		
		int numeratorItem = 1;
		for (WebElement liWebElement : result_object.getList_result_search()) {
			//sb.append(result_object.getArticuleName(liWebElement).replaceAll(",", ""));
			System.out.println("Element " + numeratorItem + ": " + result_object.getArticuleName(liWebElement));
			/*sb.append(',');
			sb.append(result_object.getArticuleLink(liWebElement));
			System.out.println("   Link " + numeratorItem + ": " + result_object.getArticuleLink(liWebElement));*/
			//sb.append('\n');
			numeratorItem++;
		}

		// Create the File and write the Information
		/*try {

			PrintWriter writer = new PrintWriter(new File("file_output/test.csv"));

			StringBuilder sb = new StringBuilder();
			sb.append("Name: ");
			sb.append(',');
			sb.append("Link: ");
			sb.append('\n');

			int numeratorItem = 1;
			for (WebElement liWebElement : result_object.getList_result_search()) {
				sb.append(result_object.getArticuleName(liWebElement).replaceAll(",", ""));
				System.out.println("Element " + numeratorItem + ": " + result_object.getArticuleName(liWebElement));
				sb.append(',');
				sb.append(result_object.getArticuleLink(liWebElement));
				System.out.println("   Link " + numeratorItem + ": " + result_object.getArticuleLink(liWebElement));
				sb.append('\n');
				numeratorItem++;
			}

			//writer.write(sb.toString());
			System.out.println("Done!");

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}*/
	}

}
