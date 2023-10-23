package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

public class BrowserManager {
    public static WebDriver getDriver(String type){

        WebDriver driver = null;

        String url = "https://jqueryui.com/droppable/";

        //MAC OS
        System.setProperty("webdriver.chrome.driver", "/Volumes/Disco local/Mr. Blue Sky/Automatización/Drivers/chromedriver");
        // Windows
        // System.setProperty("webdriver.chrome.driver", "D:\\Mr. Blue Sky\\Automatización\\Drivers\\chromedriver.exe");
        
        if (type.equals("Chrome")){
            driver = new ChromeDriver();
        }

        else if (type.equals("Firefox")){
            driver = new FirefoxDriver();
        }

        else if (type.equals("Edge")){
            driver = new EdgeDriver();
        }

        else{
            Assert.assertTrue(false, "- No fue enviado el tipo de navegador.");
        }

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
        Reporter.log("- Se ingresa al URL en el navegador "+type+" y se ingresa a la URL: "+url, true);
        return driver;
    }
}
