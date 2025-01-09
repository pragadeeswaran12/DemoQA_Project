package Testcases;

import org.testng.annotations.Test;

import BookStoreApplication.ClickOnLogin;
import commonsteps.choosingCategory;
import util.baseClass;

@Test
public class TC_006_BookStore extends baseClass {

	public void BookStore() throws InterruptedException {
		
		reportGenerator.getAttributes("DemoQA", "BookStore", "Pragadees", "TC_006");
		//Choosing Book stoore application
		reportGenerator.writeStep("BookStore page","User should be able to see BookStore page");
		choosingCategory category = new choosingCategory(driver);
		String category_actual = category.userChoosingTheCategory("Book Store Application");
		reportGenerator.verifyOutput(category_actual, "DEMOQA", "Successfully clicked BookStore page", "Failed to click a BookStore page");
		
		//Entering login details
		reportGenerator.writeStep("Login page","User should be able to see Login page");
		category.InsideChoosingCategory("Login");
		ClickOnLogin login = new ClickOnLogin(driver);
		String login_actual = login.LoginPages("mani123@gmail.com", "Spragadee@8");
		reportGenerator.verifyOutput(login_actual, "DEMOQA", "Successfully entered a login details", "Failed to enter a login details");
	}
}