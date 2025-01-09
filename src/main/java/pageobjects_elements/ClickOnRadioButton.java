package pageobjects_elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class ClickOnRadioButton {

    WebDriver driver;

    // Using PageFactory to locate elements
    @FindBy(xpath = "//label[contains(@class, 'custom-control-label')]")
    private List<WebElement> radioButtonValues;

    @FindBy(xpath = "//span[@class='text-success']")
    private WebElement verificationText;

    // Constructor to initialize PageFactory elements
    public ClickOnRadioButton(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String clickOnRadioButton(String radioButtonValue) throws InterruptedException {
    	Thread.sleep(2000);
        if (radioButtonValues.isEmpty()) {
            System.out.println("Radio values not found");
        } else {
            for (WebElement category : radioButtonValues) {
                if (category.getText().trim().equalsIgnoreCase(radioButtonValue)) {
                    category.click();
                    System.out.println("Successfully clicked on the Radio button: " + radioButtonValue);
                    break;
                }
            }
        }

        String text = verificationText.getText();

        // Check if the text matches the expected radio button value
        if (text.equals(radioButtonValue)) {
            System.out.println("Radio button successfully clicked");
        } else {
            System.out.println("Radio button not successfully clicked");
        }
        return driver.getTitle();
    }
}
