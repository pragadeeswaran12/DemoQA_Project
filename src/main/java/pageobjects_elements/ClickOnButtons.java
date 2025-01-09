package pageobjects_elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClickOnButtons {

    WebDriver driver;

    // Page Factory annotations for locating elements

    @FindBy(xpath = "//button[text()='Click Me']")
    private WebElement btnClickMe;

    @FindBy(id = "dynamicClickMessage")
    private WebElement btnVerification;

    // Constructor to initialize elements
    public ClickOnButtons(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Combined method to click buttons and verify
    public String ClickButtons(String buttonValue) {
        btnClickMe.click();

        String text = btnVerification.getText();

        // Check if the text matches the expected value
        if (text.equals(buttonValue)) {
            System.out.println("Click Me button successfully clicked");
        } else {
            System.out.println("Click Me button not successfully clicked");
        }
        return driver.getTitle();
    }
}
