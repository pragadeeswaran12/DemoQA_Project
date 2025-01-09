package pageobjects_elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClickOnDynamicProperties {
    WebDriver driver;

    // Using @FindBy annotation for the element
    @FindBy(id = "colorChange")
    WebElement btnColourChange;

    // Constructor to initialize the driver and PageFactory
    public ClickOnDynamicProperties(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initializing PageFactory
    }

    // Method to click the Colour Change button
    public String clickOnColourChange() {
        btnColourChange.click();
        return driver.getTitle();
    }
}
