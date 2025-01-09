package pageobjects_widgets;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.support.PageFactory; 
import org.openqa.selenium.JavascriptExecutor; 
 
public class ClickOnSlider { 
    public WebDriver driver; 
     
    public ClickOnSlider(WebDriver driver) { 
        this.driver = driver; 
        PageFactory.initElements(driver, this); 
    } 
     
    public String moveSliderUsingKeyboard(int targetValue) { 
        try { 
            WebElement slider = driver.findElement(By.cssSelector("input[type='range']")); 
             
            // Set focus to slider 
            slider.click(); 
           
            // Set value directly using JavaScript 
            JavascriptExecutor js = (JavascriptExecutor) driver; 
            js.executeScript("arguments[0].value = arguments[1]", slider, String.valueOf(targetValue)); 
            js.executeScript("arguments[0].dispatchEvent(new Event('input', { bubbles: true }));", slider); 
            js.executeScript("arguments[0].dispatchEvent(new Event('change', { bubbles: true }));", slider); 
             
            System.out.println("Slider value set to: " + slider.getAttribute("value")); 
            return driver.getTitle();
             
        } catch (Exception e) { 
            System.out.println("Error setting slider value: " + e.getMessage()); 
            e.printStackTrace(); 
        }
		return null; 
    } 
}