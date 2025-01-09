package pageobjects_alerts;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClickOnBrowserWindows {

    WebDriver driver;

    @FindBy(xpath = "//button[text()='New Tab']")
    private WebElement btnNewTab;

    @FindBy(xpath = "//button[text()='New Window']")
    private WebElement btnNewWindow;

    @FindBy(id = "messageWindowButton")
    private WebElement btnNewWindowsMessage;

    // Constructor
    public ClickOnBrowserWindows(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize Page Factory
    }

    // Action Method
    public String clickBrowserWindows() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", btnNewTab);
        btnNewTab.click();
        
     // Store the original tab handle
        String originalWindow = driver.getWindowHandle();

        // Get all window handles
        Set<String> allWindows = driver.getWindowHandles();

        for (String window : allWindows) {
            if (!window.equals(originalWindow)) {
                // Switch to the new tab
                driver.switchTo().window(window);
                System.out.println("Switched to new tab: " + driver.getTitle());
                break;
            }
        }
        driver.close();
        driver.switchTo().window(originalWindow);

        return driver.getTitle();
        // I have to write Getwindowhandles method because new tap opening
    }
}
