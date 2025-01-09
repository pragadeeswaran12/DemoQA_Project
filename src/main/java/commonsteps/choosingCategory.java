package commonsteps;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class choosingCategory {
	WebDriver driver;

	@FindBy(xpath = "//div[@class='category-cards']//div//h5")
	List<WebElement> List_Category;

	@FindBy(xpath = "//ul[@class='menu-list']//li//span")
	List<WebElement> List_InsideCategory;

	@FindBy(xpath = "//h5[text()='Elements']")
	private WebElement elementsSection;

	// Constructor to initialize elements
	public choosingCategory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String userChoosingTheCategory(String categoryValue) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", elementsSection);
		System.out.println("Scrolled to the 'Elements' section.");

		// Check if the list of categories is empty
		if (List_Category.isEmpty()) {
			System.out.println("Category values not found");
		} else {
			// Iterate through the list of categories
			for (WebElement category : List_Category) {
				// Check if the category text matches the given value
				if (category.getText().trim().equalsIgnoreCase(categoryValue)) {
					// Click the category and exit the loop
					category.click();
					System.out.println("Successfully clicked on the category: " + categoryValue);
					break;
				}
			}
			return driver.getTitle();
		}
		return null;
	}

	public String InsideChoosingCategory(String categoryValue) throws InterruptedException {
		Thread.sleep(2000);
		// Check if the list of categories is empty
		if (List_InsideCategory.isEmpty()) {
			System.out.println("Category values not found");
		} else {
			// Iterate through the list of categories
			for (WebElement category : List_InsideCategory) {
				// Check if the category text matches the given value
				if (category.getText().trim().equalsIgnoreCase(categoryValue)) {
					// Click the category and exit the loop
			           JavascriptExecutor js = (JavascriptExecutor) driver;
			            js.executeScript("arguments[0].scrollIntoView(true);", category);
					category.click();
					System.out.println("Successfully clicked on the category: " + categoryValue);
					break;
				}
			}
			return driver.getTitle();
		}
		return null;
	}
}
