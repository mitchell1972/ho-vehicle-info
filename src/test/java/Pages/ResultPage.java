package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultPage {

    static WebElement element = null;


    public static WebElement vehicleMake(WebDriver e) {
        element = e.findElement(By.xpath("//*[@id='content']/div[4]/ul/li[1]/span[2]/strong"));
        return element;
    }

    public static WebElement vehicleColour(WebDriver e) {
        element = e.findElement(By.xpath("//*[@id='content']/div[4]/ul/li[9]/span[2]/strong"));
        return element;
    }


}
