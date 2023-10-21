package Test;

import Page.Page_JQuery;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestExecution {

    public static void main(String[] args) throws InterruptedException {

        Page_JQuery PagHome =  new Page_JQuery();

        // Inicialización del Driver
        WebDriver driver;

        // Windows
        // System.setProperty("webdriver.chrome.driver", "D:\\Mr. Blue Sky\\Automatización\\Drivers\\chromedriver.exe");

        // MAC OS
        System.setProperty("webdriver.chrome.driver", "/Volumes/Disco local 1/Mr. Blue Sky/Automatización/Drivers/chromedriver");

        driver = new ChromeDriver();

        PagHome.StartDriver(driver); // Se inicializa el driver

        PagHome.GetLink();
        PagHome.MaximizeWindow();

        // Uso de Objetos POM

        PagHome.SwitchToiFrame(); // Se ingresa dentro del Frame
        Thread.sleep(2000);
        PagHome.DragAndDrop(); // Se hace el Drag and Drop
        Thread.sleep(2000);
        PagHome.SwitchToDefault(); // Se sale del iFrame y permite interactuar con el resto de elementos

        PagHome.ClickButtonPage(); // Se ingresa a la Página Button
        Thread.sleep(2000);

        PagHome.WriteSearch("Prueba QA"); // Se hace una búsqueda
        Thread.sleep(2000);

        PagHome.ClickAboutPage(); // Se ingresa a la página de About
        Thread.sleep(2000);

        PagHome.CloseDriver(); // Se cierra el Driver

    }
}
