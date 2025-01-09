package pageobjects_interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClickOnDropable {

  WebDriver driver;

  // Using @FindBy annotation to locate elements
  @FindBy(xpath = "//div[text()='Drag me']")
  WebElement Btn_DragMe;

  @FindBy(xpath = "(//div[@id='droppable'])[1]")
  WebElement Btn_DropHere;

  @FindBy(xpath = "//a[text()='Revert Draggable']")
  WebElement Btn_RevertDragable;

  @FindBy(xpath = "//div[text()='Will Revert']")
  WebElement Btn_WillRevert;

  @FindBy(xpath = "(//div[@id='droppable'])[3]")
  WebElement Btn_WillRevertDrop;

  // Constructor to initialize the PageFactory elements
  public ClickOnDropable(WebDriver driver) {
      this.driver = driver;
      PageFactory.initElements(driver, this); // Initializes the PageFactory elements
  }

  public String ClickDropable() {
	  driver.findElement(By.id("draggable")).click();
	  
      // Perform drag and drop action for first set of elements
      Actions actions = new Actions(driver);

      // Dragging the element "Drag me" to the target "Drop here"
      actions.dragAndDrop(Btn_DragMe, Btn_DropHere).build().perform();

      // Clicking the "Revert Draggable" button
      Btn_RevertDragable.click();

      // Perform drag and drop action for the second set of elements
      actions.dragAndDrop(Btn_WillRevert, Btn_WillRevertDrop).build().perform();
      
      return driver.getTitle();
  }
}





//public class ClickOnDropable
//{
//	WebDriver driver;
//	By Btn_DragMe          = By.id("draggable");
//	By Btn_DropHere        = By.id("droppable");
//	
//	public ClickOnDropable(WebDriver driver)
//	{
//		this.driver=driver;
//	}
//	
//	public void ClickDropable()
//	{		
//		// Locate the source element (element to be dragged)
//		driver.findElement(Btn_DragMe).click();
//        WebElement sourceElement = driver.findElement(Btn_DragMe);
//
//        // Locate the target element (element to drop onto)
//        WebElement targetElement = driver.findElement(Btn_DropHere);
//
//        // Create an instance of the Actions class
//        Actions actions = new Actions(driver);
//
//        // Perform drag-and-drop action
//        actions.dragAndDrop(sourceElement, targetElement).build().perform();
//	}
//}
