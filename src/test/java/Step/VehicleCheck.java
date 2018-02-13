package Step;

import Pages.ConfirmVehiclePage;
import Pages.LandingPage;
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

import static Utils.ReadFilePath.regNumber;


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
        LandingPage.confirmUrl(e, "https://www.gov.uk/get-vehicle-information-from-dvla");

        //Click on start button
        LandingPage.searchButton(e, "button").click();

        //Validate new location
        LandingPage.confirmUrl(e, "https://vehicleenquiry.service.gov.uk/");
        //Located VRM field on search page and populate field with registration number

        SearchPage.searchField(e, "Vrm").sendKeys(regNumber.get(0));

        //Click on Continue button
        LandingPage.searchButton(e, "button").click();

        //Select yes radio button
        ConfirmVehiclePage.yesRadioButton(e, "Correct_True").click();

        //Click on continue
        ConfirmVehiclePage.continueButton(e, "button").click();

        //Validate new location
        LandingPage.confirmUrl(e, "https://vehicleenquiry.service.gov.uk/ViewVehicle");
        ConfirmVehiclePage.captureScreen(e);

    }
}
