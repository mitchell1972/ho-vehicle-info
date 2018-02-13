package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class LandingPage {

    private static WebElement element = null;

    public static void confirmUrl(WebDriver e, String Url){
        assertEquals(Url,e.getCurrentUrl());
        System.out.println(e.getCurrentUrl());
    }


    public static WebElement searchButton(WebDriver e, String className) {
        element = e.findElement(By.className(className));
        return element;
    }


}
