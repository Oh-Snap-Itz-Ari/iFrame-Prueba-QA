package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Page_JQuery{

    //Page Factory permite optimizar el código con las nomenclaturas/anotaciones que permite Page Factory

    WebDriver driver;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[1]/iframe") WebElement iFrame; // Se declaran a través de la utilización de FindBy (Page Factory)

    @FindBy(id = "draggable") WebElement Draggable;
    @FindBy(id = "droppable") WebElement Droppable;
    @FindBy(xpath = "//a[@href='https://jqueryui.com/button/'][contains(.,'Button')]") WebElement Button_Page;
    @FindBy(xpath = "//a[@href='https://jqueryui.com/about/'][contains(.,'About')]") WebElement About_Page;
    @FindBy(xpath = "//button[@class='ui-button ui-widget ui-corner-all'][contains(.,'A button element')]") WebElement btn_Element;
    @FindBy(xpath = "//input[@type='search']") WebElement Search;

    public void StartDriver(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this); // Se envia el driver y la clase que estamos trabajando (esta)
    }

    public void GetLink(){
        driver.get("https://jqueryui.com/droppable/");
    }

    public void MaximizeWindow(){
        driver.manage().window().maximize();
    }

    public void CloseDriver(){
        driver.close(); // Se indica que el driver que nos envien es el que tenemos en nuestra clase
    }

    public void SwitchToiFrame(){
        driver.switchTo().frame(iFrame); // Ingresa dentro del iFrame
    }

    public void SwitchToDefault(){
        driver.switchTo().defaultContent(); // Sale del iFrame y permite continuar interactuando con la página
    }

    public void DragAndDrop(){
        Actions action = new Actions(driver);
        action.dragAndDrop((Draggable),(Droppable)).build().perform(); // Inicio , Final (Destino)
    }

    public void ClickButtonPage(){
        Button_Page.click();
    }

    public void ClickButton(){
        btn_Element.click();
    }

    public void WriteSearch(String search){
        Search.sendKeys(search);
    }

    public void ClickAboutPage() {
        About_Page.click();
    }

}
