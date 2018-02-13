package Pages;

import Utils.ReadFilePath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Utils.ReadFilePath.*;

import static Utils.ReadFilePath.regNumber;

public class SearchPage {
    static WebElement element = null;
    public static WebElement searchField(WebDriver dr,String id) {

        element = dr.findElement(By.id(id));

        return element;

    }

}
