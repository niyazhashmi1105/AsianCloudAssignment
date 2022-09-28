package pages;

import actionHelper.WebActionHelperMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;
    static WebActionHelperMethods webActionHelperMethods;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        webActionHelperMethods= new WebActionHelperMethods(driver);
    }

}