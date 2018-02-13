package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
}
