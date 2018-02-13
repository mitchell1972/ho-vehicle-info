package Pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class ConfirmVehiclePage {

    static WebElement element = null;

    public static WebElement yesRadioButton(WebDriver e, String id) {
        element = e.findElement(By.id(id));
        return element;
    }

    public static WebElement noRadioButton(WebDriver e, String id) {
        element = e.findElement(By.id(id));
        return element;
    }

    public static WebElement continueButton(WebDriver e,String className) {
        element = e.findElement(By.className(className));
        return element;
    }

    public static void captureScreen(WebDriver e){
        File scrFile = ((TakesScreenshot)e).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("screenshot.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
