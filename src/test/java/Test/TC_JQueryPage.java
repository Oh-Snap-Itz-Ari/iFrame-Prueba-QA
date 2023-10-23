package Test;

import Page.PO_PageJQuery;
import Utils.BrowserManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC_JQueryPage {

    PO_PageJQuery obj =  new PO_PageJQuery();

    @Test
    public void T_01_JQuery_DragAndDrop(){
        WebDriver driver = BrowserManager.getDriver("Chrome");
        obj.StartDriver(driver);
        obj.iFrameDragAndDrop();
        obj.GoButtonPage();
        obj.SearchJQueryPage("Test");
        obj.GoAboutPage();
    }
}
