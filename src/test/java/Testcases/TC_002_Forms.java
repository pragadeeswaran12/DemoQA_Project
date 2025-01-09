package Testcases;

import org.testng.annotations.Test;

import commonsteps.choosingCategory;
import pageobjects_forms.EnteringPracticeFormDetails;
import util.baseClass;

public class TC_002_Forms extends baseClass {
	@Test
	public void Forms() throws InterruptedException {
		
		reportGenerator.getAttributes("DemoQA", "Forms", "Pragadees", "TC_002");
		
		reportGenerator.writeStep("Practice Form page","User should be able see practice form page");
		//Choosing the Category of Elements
		choosingCategory category = new choosingCategory(driver);
		category.userChoosingTheCategory("Forms");
		
		category.InsideChoosingCategory("Practice Form");
		EnteringPracticeFormDetails practice = new EnteringPracticeFormDetails(driver);
		String practice_actual = practice.practiceFormDetails("Pragdees", "S", "mani123@gmail.com", "Male", "9856743516", "12-May-2023","Nothing", "Music","C:\\Users\\pragadeeswaran\\Desktop\\DemoQA.txt", "Bangalore","NCR","Delhi");
		reportGenerator.verifyOutput(practice_actual, "DEMOQA", "Successfully entered all the details", "Failed to enter a details");
	}

}
