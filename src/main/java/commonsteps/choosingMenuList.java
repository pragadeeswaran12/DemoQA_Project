package commonsteps;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class choosingMenuList 
{
	WebDriver driver;

    @FindBy(xpath = "//div[@class='element-list collapse show']//li//span")
    List<WebElement> List_MenuList;

    // Constructor to initialize elements
    public choosingMenuList(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void userChoosingTheCategory(String menulistValue) 
    {
        // Check if the list of menulist is empty
        if (List_MenuList.isEmpty()) {
            System.out.println("Menulist values not found");
        } else {
            // Iterate through the list of categories
            for (WebElement menuList : List_MenuList) {
                // Check if the menulist text matches the given value
                if (menuList.getText().trim().equalsIgnoreCase(menulistValue)) {
                    // Click the menulist and exit the loop
                	menuList.click();
                    System.out.println("Successfully clicked on the Menulist: " + menulistValue);
                    break;
                }
            }
        }
    }
}
