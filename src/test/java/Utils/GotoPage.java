package Utils;

import org.openqa.selenium.WebDriver;

public class GotoPage {

    public static void getUrl(String url,WebDriver e){
        e.get(url);
        e.manage().window().maximize();
    }
    
}
