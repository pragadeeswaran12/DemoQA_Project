package pageobjects_interactions;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClickOnSelectable {

  WebDriver driver;

  // Use @FindBy annotation to locate elements
  @FindBy(xpath = "//div[@id='demo-tabpane-list']//ul")
  List<WebElement> List_Selects;

  @FindBy(id = "demo-tab-grid")
  WebElement Btn_Grid;

  @FindBy(xpath = "//div[@id='demo-tabpane-grid']//div//li")
  List<WebElement> List_Grid;

  // Constructor to initialize the PageFactory elements
  public ClickOnSelectable(WebDriver driver) {
      this.driver = driver;
      PageFactory.initElements(driver, this); // Initializes the PageFactory elements
  }

  public String ClickingSelectValue(String SelectValue) {
      try {
          // Create an instance of JavascriptExecutor
          JavascriptExecutor js = (JavascriptExecutor) driver;

          // Scroll to the bottom of the page
          js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

          // Check if there are any select options available
          if (List_Selects.isEmpty()) {
              System.out.println("No Selects value found.");
          } else {
              // Iterate through the options to find the desired value
              for (WebElement select : List_Selects) {
                  if (select.getText().equals(SelectValue)) {
                      select.click(); // Click the matching option
                      break;
                  }
              }
              return driver.getTitle();
          }
      } catch (Exception e) {
          // Log any exceptions that occur during the selection process
          System.err.println("Exception caught: " + e.getMessage());
          throw new AssertionError("Select value could not be clicked.");
      }
	return null;
  }

  public String ClickingGridValue(String GridValue) {
      try {
          // Make sure the grid button is available and clickable
          Btn_Grid.click();

          // Check if there are any grid options available
          if (List_Grid.isEmpty()) {
              System.out.println("No Grid value found.");
          } else {
              // Iterate through the grid options to find the desired value
              for (WebElement grid : List_Grid) {
                  if (grid.getText().equals(GridValue)) {
                      grid.click(); // Click the matching option
                      break;
                  }
              }
              return driver.getTitle();
          }
      } catch (Exception e) {
          // Log any exceptions that occur during the selection process
          System.err.println("Exception caught: " + e.getMessage());
          throw new AssertionError("Grid value could not be clicked.");
      }
	return null;
  }
}
