package Testcases;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.support.Colors;
import org.testng.annotations.Test;
import commonsteps.choosingCategory;
import pageobjects_widgets.ClickOnAccordian;
import pageobjects_widgets.ClickOnAutoComplete;
import pageobjects_widgets.ClickOnDatePicker;
import pageobjects_widgets.ClickOnProgressBar;
import pageobjects_widgets.ClickOnSelectMenu;
import pageobjects_widgets.ClickOnSlider;
import util.baseClass;

public class TC_004_Widgets extends baseClass {
	@Test
	public void Widgets() throws Exception {
		
		reportGenerator.getAttributes("DemoQA", "Widgets", "Pragadees", "TC_004");
		
		//Choosing the Category of Widgets
		reportGenerator.writeStep("Widgets page","User should be able to see Widgets page");
		choosingCategory category = new choosingCategory(driver);
		String category_actual =category.userChoosingTheCategory("Widgets");	
		reportGenerator.verifyOutput(category_actual, "DEMOQA", "Successfully Clicked on Widgets page", "Failed to click Widgets page");
		
		//Selecting the Accordian page
		reportGenerator.writeStep("Accordian page","User should be able to see Accordian page");
		category.InsideChoosingCategory("Accordian");
		ClickOnAccordian accordian = new ClickOnAccordian(driver);
		String accordian_actual =accordian.clickAccordian();
		reportGenerator.verifyOutput(accordian_actual, "DEMOQA", "Successfully worked on Accordian button", "Failed to work a Accordian page");
		
		//Selecting the Auto complete 
		reportGenerator.writeStep("AutoComplete page","User should be able to see AutoComplete page");
		category.InsideChoosingCategory("Auto Complete");
		ClickOnAutoComplete auto = new ClickOnAutoComplete(driver);
//		List<String> colorsList = Arrays.asList(Colors.split(",")); 
//		auto.typeMultipleColors(colorsList);
        String auto_actual =auto.typeSingleColor("Blue");
        reportGenerator.verifyOutput(auto_actual, "DEMOQA", "Successfully worked on AutoComplete page", "Failed to work a AutoComplete page");
        
        //Selecting the Date picker
        reportGenerator.writeStep("DatePicker page","User should be able to see DatePicker page");
		category.InsideChoosingCategory("Date Picker");
		ClickOnDatePicker date = new ClickOnDatePicker(driver);
		String date_actual =date.ClickDataPicker("01/08/2025", "January 23, 2010 11:30 AM");
		reportGenerator.verifyOutput(date_actual, "DEMOQA", "Successfully worked a DatePicker page", "Failed to work a DatePicker page");
		
		//clicking the Slider
		reportGenerator.writeStep("Slider page","User should be able to see Slider page");
		category.InsideChoosingCategory("Slider");
		ClickOnSlider slider = new ClickOnSlider(driver);
		String slider_actual=slider.moveSliderUsingKeyboard(50);
		reportGenerator.verifyOutput(slider_actual, "DEMOQA", "Successfully worked a Slider page", "Failed to work a Slider page");
		
		//Clicking the Progress bar
		reportGenerator.writeStep("ProgressBar page","User should be able to see ProgressBar page");
		category.InsideChoosingCategory("Progress Bar");
		ClickOnProgressBar progressBar = new ClickOnProgressBar(driver);
		String progressBar_actual =progressBar.handleProgressBar(50);
		reportGenerator.verifyOutput(progressBar_actual, "DEMOQA", "Successfully worked on ProgressBar", "Failed to work a ProgressBar page");
		
		//Choosing the Select menu
		reportGenerator.writeStep("SelectMenu page","User should be able to see Select Menu page");
		category.InsideChoosingCategory("Select Menu");
		ClickOnSelectMenu selectMenu = new ClickOnSelectMenu(driver);
		selectMenu.SelectValue("Group 1, option 1");
		selectMenu.SelectOne("Mr.");
		selectMenu.MenuColour("Blue");
		selectMenu.selectOptions(driver, null, null);
		String selectMenu_actual = selectMenu.Standardmultiselect("Volvo");
		reportGenerator.verifyOutput(selectMenu_actual, "DEMOQA", "Successfully worked on a SelectMenu", "Failed to work a SelectMenu page");
	}
}
