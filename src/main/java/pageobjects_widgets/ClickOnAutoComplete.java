package pageobjects_widgets;


import org.openqa.selenium.By; 
import org.openqa.selenium.Keys; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement; 
import java.util.List; 
 
public class ClickOnAutoComplete { 
    WebDriver driver; 
 
    public ClickOnAutoComplete(WebDriver driver) { 
        this.driver = driver; 
    } 
 
    // Method to handle multiple color names 
    public void typeMultipleColors(List<String> colors) { 
        WebElement autoCompleteInput = driver.findElement(By.id("autoCompleteMultipleInput")); // Replace with actual locator 
         
        for (String color : colors) { 
            autoCompleteInput.sendKeys(color); // Type the color name 
            autoCompleteInput.sendKeys(Keys.ENTER); // Press Enter to select the suggestion 
            System.out.println("Typed and selected color: " + color); 
        }} 
     
        // Method to type and select a single color 
        public String typeSingleColor(String color) { 
            WebElement autoCompleteInput = driver.findElement(By.id("autoCompleteSingleInput")); // Replace with actual locator 
             
            autoCompleteInput.sendKeys(color); // Type the color name 
            autoCompleteInput.sendKeys(Keys.ARROW_DOWN); // Navigate to the suggestion 
            autoCompleteInput.sendKeys(Keys.ENTER); // Select the suggestion 
            System.out.println("Typed and selected single color: " + color); 
            return driver.getTitle();
    } 
}  




//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//public class ClickOnAutoComplete {
//
//    WebDriver driver;
//
//    @FindBy(xpath = "(//div[@id='autoCompleteMultipleContainer']//div)[1]")
//    private WebElement txt_MultipleColorName;
//
//    @FindBy(xpath = "(//div[@id='autoCompleteSingleContainer']//div)[1]")
//    private WebElement txt_SingleColorName;
//
//    // Constructor to initialize Page Factory
//    public ClickOnAutoComplete(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }
//
//    // Method to handle auto-complete functionality
//    public void clickAutoComplete(String multipleColorName1, String multipleColorName2, String singleColorName) throws InterruptedException {
//        // Select the first color in multiple selection
//    	
//    	WebElement dropdown = driver.findElement(By.xpath("(//div[@id='autoCompleteMultipleContainer']//div)[1]")); 
//        dropdown.sendKeys(multipleColorName1); // Pass the state name dynamically 
//        dropdown.sendKeys(Keys.ENTER);
//        
//        dropdown.sendKeys(multipleColorName2); // Pass the state name dynamically 
//        dropdown.sendKeys(Keys.ENTER);
//        
////        JavascriptExecutor js = (JavascriptExecutor) driver;
////        js.executeScript("arguments[0].scrollIntoView(true);", txt_MultipleColorName);
////        txt_MultipleColorName.click();
////        txt_MultipleColorName.sendKeys(multipleColorName1);
////        Actions actions = new Actions(driver);
////        actions.sendKeys(Keys.ENTER).perform();
////
////        // Select the second color in multiple selection
////        txt_MultipleColorName.sendKeys(multipleColorName2);
////        actions.sendKeys(Keys.ENTER).perform();
//
//        // Select the single color
//        txt_SingleColorName.sendKeys(singleColorName);
//    }
//}
