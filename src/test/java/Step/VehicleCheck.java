package Step;

import Pages.ConfirmVehiclePage;
import Pages.LandingPage;
import Pages.ResultPage;
import Pages.SearchPage;
import Utils.GotoPage;
import Utils.ReadFilePath;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static Pages.ConfirmVehiclePage.captureScreen;
import static Pages.ConfirmVehiclePage.continueButton;
import static Pages.ConfirmVehiclePage.yesRadioButton;
import static Pages.LandingPage.confirmUrl;
import static Pages.LandingPage.searchButton;
import static Pages.ResultPage.vehicleColour;
import static Pages.ResultPage.vehicleMake;
import static Utils.ReadFilePath.colourOfVehicle;
import static Utils.ReadFilePath.makeOfVehicle;
import static Utils.ReadFilePath.regNumber;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;


public class VehicleCheck {

    WebDriver e = new ChromeDriver();
    WebElement element = null;

    @Before
    public void setUpData() {
        ReadFilePath.readCsvFile();
    }

    @After
    public void teardDown() {
        e.close();
    }


    @Test
    public void checkAndValidateVehicleDetails() {

        //Open Landing Page
        GotoPage.getUrl("https://www.gov.uk/get-vehicle-information-from-dvla", e);
        // Validate Location
        confirmUrl(e, "https://www.gov.uk/get-vehicle-information-from-dvla");

        //Click on start button
        searchButton(e, "button").click();

        //Validate new location
        confirmUrl(e, "https://vehicleenquiry.service.gov.uk/");
        //Located VRM field on search page and populate field with registration number

        SearchPage.searchField(e, "Vrm").sendKeys(regNumber.get(0));

        //Click on Continue button
        searchButton(e, "button").click();

        //Select yes radio button
        yesRadioButton(e, "Correct_True").click();

        //Click on continue
        continueButton(e, "button").click();

        //Validate new location
        confirmUrl(e, "https://vehicleenquiry.service.gov.uk/ViewVehicle");
        captureScreen(e);

        if(!makeOfVehicle.get(0).equalsIgnoreCase(vehicleMake(e).getText())){
            System.out.println("Expected make of vehicle: "+ makeOfVehicle.get(0)+" --- Actual Make is: "+  vehicleMake(e).getText());
             fail();
        }

        if(!colourOfVehicle.get(0).equalsIgnoreCase(vehicleColour(e).getText())){
            System.out.println("Expected colour of vehicle: "+ colourOfVehicle.get(0) +" --- Actual Make is: "+  vehicleColour(e).getText());
            fail();
        }
    }
}
