package pageobjects_elements;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClickOnLinks {

    WebDriver driver;

    // Page Factory annotations for locating elements
    @FindBy(xpath = "(//a[text()='Home'])[1]")
    private WebElement btnHome;

    // Constructor to initialize elements
    public ClickOnLinks(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to click on Home button and navigate back
    public String ClicksOnHomeButton() throws InterruptedException {
        btnHome.click();
        
        // Store the current window handle
        String originalWindow = driver.getWindowHandle();

        // Click the button to open a new tab
        btnHome.click();

        // Wait for the new tab to open and switch to it
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        // Perform any necessary actions in the new tab (optional)

        // Close the new tab and switch back to the original window
        driver.close();
        driver.switchTo().window(originalWindow);
        return driver.getTitle();
    }
}
