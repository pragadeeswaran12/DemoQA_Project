package Testcases;

import java.awt.AWTException;

import org.testng.annotations.Test;
import commonsteps.choosingCategory;
import pageobjects_elements.ClickOnButtons;
import pageobjects_elements.ClickOnCheckBox;
import pageobjects_elements.ClickOnDynamicProperties;
import pageobjects_elements.ClickOnLinks;
import pageobjects_elements.ClickOnRadioButton;
import pageobjects_elements.ClickOnTextBox;
import pageobjects_elements.ClickOnUploadAndDownload;
import pageobjects_elements.ClickOnWebTable;
import util.baseClass;

public class TC_001_Elements extends baseClass {

	@Test
	public void Elements() throws InterruptedException, AWTException
	{
		reportGenerator.getAttributes("DemoQA", "Elements", "Pragadees", "TC_001");
		//Choosing the Category of Elements
		reportGenerator.writeStep("Elements page","User should be able to see Element page");
		choosingCategory category = new choosingCategory(driver);
		String category_actual = category.userChoosingTheCategory("Elements");
		reportGenerator.verifyOutput(category_actual, "DEMOQA", "Successfully Clicked on Category", "Failed to click Category");
		
		//Entering TextBox values
		reportGenerator.writeStep("Text box page","User should be able see Text box");
		category.InsideChoosingCategory("Text Box");	
		ClickOnTextBox textbox = new ClickOnTextBox(driver);
		String textbox_actual = textbox.fillTextboxAndVerifyDetails("Pragadees","mani123@gmail.com","Bangalore","Karnataka");
		reportGenerator.verifyOutput(textbox_actual, "DEMOQA", "Successfully entered the Textbox details", "Failed to enter the Textbox details");
		
		//Clicking the CheckBox values
		reportGenerator.writeStep("Check box page","User should be able to see check box page");
		category.InsideChoosingCategory("Check Box");
		ClickOnCheckBox checkbox = new ClickOnCheckBox(driver);
		String checkbox_actual = checkbox.selectAndVerifyCheckBox("Public");
		reportGenerator.verifyOutput(checkbox_actual, "DEMOQA", "Successfully Clicked on Checkbox values", "Failed to click Checkbox values");
	
		//Clicking the Radio button
		reportGenerator.writeStep("Radio button page","User should be able to see radio button page");
		category.InsideChoosingCategory("Radio Button");
		ClickOnRadioButton radiobtn = new ClickOnRadioButton(driver);
		String radio_actual = radiobtn.clickOnRadioButton("Yes");
		reportGenerator.verifyOutput(radio_actual, "DEMOQA", "Successfully Clicked on Radio button", "Failed to click Radio button");
		
		//Updating Web Tables
		reportGenerator.writeStep("Web Table page","User should be able to see web table page");
		category.InsideChoosingCategory("Web Tables");
		ClickOnWebTable webtable = new ClickOnWebTable(driver);
		String webtable_actual = webtable.WebTables("Cierra", "pragadeeswaran", "34");
		reportGenerator.verifyOutput(webtable_actual, "DEMOQA", "Successfully entered Webtable values", "Failed to enter a Webtable values");
		
		//Clicking the Buttons
		reportGenerator.writeStep("Button page","User should be able to see button page");
		category.InsideChoosingCategory("Buttons");
		ClickOnButtons button = new ClickOnButtons(driver);
		String button_actual = button.ClickButtons("You have done a dynamic click");
		reportGenerator.verifyOutput(button_actual, "DEMOQA", "Successfully Clicked on buttons", "Failed to click a button");
		
		//Clicking the Links
		reportGenerator.writeStep("Links page","User should be able to see links page");
		category.InsideChoosingCategory("Links");
		ClickOnLinks links = new ClickOnLinks(driver);
		String link_actual = links.ClicksOnHomeButton();
		reportGenerator.verifyOutput(link_actual, "DEMOQA", "Successfully Clicked on Links", "Failed to click a Links");
		
		//FIle Uploaded and Downloaded
		reportGenerator.writeStep("Uploaded page","User should be able to see uploaded page");
		category.InsideChoosingCategory("Upload and Download");
		ClickOnUploadAndDownload upload = new ClickOnUploadAndDownload(driver);
		String upload_actual = upload.uploadFile("D:\\Shubham\\New folder\\SHUBHAM\\shubham\\UploadFile\\TestData");
		reportGenerator.verifyOutput(upload_actual, "DEMOQA", "Successfully uploaded file", "Failed to upload a file");
		
		//Clicking the Dynamic
		reportGenerator.writeStep("Dynamic page","User should be able to see Dynamic page");
		category.InsideChoosingCategory("Dynamic Properties");
		ClickOnDynamicProperties dynamic = new ClickOnDynamicProperties(driver);
		String dynamic_actual =dynamic.clickOnColourChange();	
		reportGenerator.verifyOutput(dynamic_actual, "DEMOQA", "Successfully Clicked on Dynamic button", "Failed to click a Dynamic button");
	}
}
