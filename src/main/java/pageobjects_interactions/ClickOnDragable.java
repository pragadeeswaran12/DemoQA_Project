package pageobjects_interactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClickOnDragable {
    
	// Draggable
	
    WebDriver driver;

    @FindBy(id = "dragBox")
    WebElement Btn_DragMe;

    // Constructor to initialize the elements
    public ClickOnDragable(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initializes the PageFactory elements
    }

    public String ClickDragable() throws InterruptedException {
        // Locate and click on the DragMe button
        Btn_DragMe.click();

        // Create an instance of the Actions class
        Actions actions = new Actions(driver);

        // Option 1: Drag by offset (moves 100 pixels to the right)
        actions.dragAndDropBy(Btn_DragMe, 100, 0).perform();

        // Option 2: Click and hold, move, then release
        actions.clickAndHold(Btn_DragMe)
                .moveByOffset(100, 0)
                .release()
                .perform();

        // Add a small wait to see the result
        Thread.sleep(2000);
        
        return driver.getTitle();
    }
}