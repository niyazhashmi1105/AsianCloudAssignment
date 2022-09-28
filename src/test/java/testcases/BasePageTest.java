package testcases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import driverManager.DriverManagerType;
import driverManager.WebDrivers;
import pages.LoginPage;
import pages.RegisterPage;
import util.Utility;

public class BasePageTest {
	 
	protected LoginPage loginPage;
	protected RegisterPage registerPage;
	WebDriver driver;
	Properties properties;
	static String URL;

	    @BeforeMethod
	    public void setUp() {
	        String propertyPath = System.getProperty("user.dir") + "//src//test//resources//env.properties";
	        try {
	            driver = WebDrivers.getDriver(DriverManagerType.CHROME);
	            properties = Utility.loadProperties(propertyPath);
	            URL = properties.getProperty("URL");
	            loginPage = new LoginPage(driver);
	            registerPage = new RegisterPage(driver);
	            driver.get(URL);
	            driver.manage().window().maximize();
	           } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	    }

	    @AfterMethod
	    public void destroyDriver() {
	        driver.quit();
	    }

}
