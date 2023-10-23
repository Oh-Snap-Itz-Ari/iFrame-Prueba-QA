package Page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class PO_PageJQuery {

    WebDriver driver;

    public void StartDriver(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this); // Se envia el driver y la clase que estamos trabajando (esta)
    }

    @FindBy(xpath = "/html/body/div/div[2]/div/div[1]/iframe") WebElement iFrame; // Se declaran a través de la utilización de FindBy (Page Factory)
    @FindBy(id = "draggable") WebElement Draggable;
    @FindBy(id = "droppable") WebElement Droppable;
    @FindBy(xpath = "//a[contains(.,'Button')]") WebElement Button_Page;
    @FindBy(xpath = "//a[contains(.,'About')]") WebElement About_Page;
    @FindBy(xpath = "//input[@type='search']") WebElement Search;

    // ---------------------------------------------------------------
    // Methods

    public void SwitchToiFrame(){
        driver.switchTo().frame(iFrame); // Ingresa dentro del iFrame
        Reporter.log("- Switch To iFrame", true);
    }

    public void SwitchToDefault(){
        driver.switchTo().defaultContent(); // Sale del iFrame y permite continuar interactuando con la página
        Reporter.log("- Switch to Default", true);
    }

    public void DragAndDrop(){
        Actions action = new Actions(driver);
        action.dragAndDrop((Draggable),(Droppable)).build().perform(); // Inicio , Final (Destino)
        Reporter.log("- Drag And Drop realizado de forma correcta.", true);
    }

    public void ClickButtonPage(){
        Button_Page.click();
        Reporter.log("- Redirección a la página: " + driver.getTitle(), true);
    }

    public void WriteSearch(String search){
        Search.sendKeys(search);
        Reporter.log("- Texto ingresado en la caja de texto: " + search, true);
    }

    public void ClickAboutPage() {
        About_Page.click();
        Reporter.log("- Redirección a la página: " + driver.getTitle(), true);
    }

    // ---------------------------------------------------------------
    // Business Method

    public void iFrameDragAndDrop () {
        SwitchToiFrame();
        DragAndDrop();
        SwitchToDefault();
    }

    public void GoButtonPage() {
        ClickButtonPage();
        String actual = driver.getTitle();
        String expected = "Button | jQuery UI";
        Assert.assertEquals(actual, expected, "- La aplicación no pudo realizar la redirección a la página de Button."); // Compara y valida si el actual corresponde al Title esperado de la redirección
        Reporter.log("- Redirección realizada con éxito: " + driver.getCurrentUrl(), true);
    }

    public void SearchJQueryPage(String search) {
        WriteSearch(search);
        String actual = driver.getTitle();
        String expected = "Button | jQuery UI";
        Assert.assertEquals(actual, expected, "- La aplicación no pudo realizar la búsqueda de: " + search); // Compara y valida si el actual corresponde al Title esperado de la redirección
        Reporter.log("- Búsqueda realizada con Éxito: "+ search, true);
    }

    public void GoAboutPage() {
        ClickAboutPage();
        String actual = driver.getTitle();
        String expected = "About jQuery UI | jQuery UI";
        Assert.assertEquals(actual, expected, "- La aplicación no pudo realizar la redirección a la página de About."); // Compara y valida si el actual corresponde al Title esperado de la redirección
        Reporter.log("- Redirección realizada con éxito: " + driver.getCurrentUrl(), true);
    }
}
