package pageobjects_interactions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ClickOnSortable
{
	WebDriver driver;

	By List_Sort           = By.xpath("//div[@id='demo-tabpane-list']//div//div");
	By Btn_Grid            = By.id("demo-tab-grid");
	By List_Grid         = By.xpath("//div[@id='demo-tabpane-grid']//div//div//div");
	
	public ClickOnSortable(WebDriver driver)
	{
		this.driver=driver;
	}	
	
	public String SortablePage()
	{
		List<WebElement> items = driver.findElements(By.xpath("//div[@id='demo-tabpane-list']//div//div"));
		
		// Example: Move "Five" to the top position
      WebElement sourceElement = items.stream()
          .filter(item -> item.getText().equals("Five"))
          .findFirst()
          .orElseThrow(() -> new RuntimeException("Source element not found"));
          
      WebElement targetElement = items.get(0); // First element
      
      Actions actions = new Actions(driver);
      // Perform drag and drop
      actions.clickAndHold(sourceElement)
             .moveToElement(targetElement)
             .release()
             .perform();
      return driver.getTitle();
	}
}

