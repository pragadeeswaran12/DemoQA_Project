package pageobjects_interactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ClickOnResizable {

    WebDriver driver;

    // Using @FindBy annotation to locate the element
    @FindBy(xpath = "(//*[contains(@class, 'react-resizable-handle react-resizable-handle-se')])[1]")
    WebElement Btn_Press;

    // Constructor to initialize the PageFactory elements
    public ClickOnResizable(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initializes the PageFactory elements
    }

    public void ClickResizable() {
        // Wait for the resize handle to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement resizeHandle = wait.until(ExpectedConditions.elementToBeClickable(Btn_Press));

        // Create an instance of the Actions class
        Actions actions = new Actions(driver);

        // Perform resize action with delay for more stability
        actions.clickAndHold(resizeHandle)
               .moveByOffset(100, 50)  // Try smaller offset values first
               .release()
               .perform();
    }
}
