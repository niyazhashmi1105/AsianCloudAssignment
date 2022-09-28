package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterPageTest extends BasePageTest {
	
	
	@Test(priority=1,description="This method used to validate text on the login screen once navigated back from Register Page")
	public void validateRegisterNavigationLink() {
		registerPage.navigateToRegisterPage();
		boolean isLoginTextDisplayed= registerPage.verifySigninAccountTextFromRegisterPage();
		Assert.assertEquals(true, isLoginTextDisplayed);
	}
	
	@Test(priority=2,description="This method used to validate error message from Register Page")
	public void validateErrorMessageOnRegisterButtonClick() {
		registerPage.navigateToRegisterPage();
		boolean isErrorMessageDisplayed= registerPage.verifyErrorMessageOnClickRegisterButton();
		Assert.assertEquals(true, isErrorMessageDisplayed);
	}
	

	@Test(priority=3,description="This method used to validate page title once the account successfully registered")
	public void validateRegisterAccount() {
		
		registerPage.navigateToRegisterPage();
		registerPage.enterRegisterPageCredentials(properties.getProperty("REGISTEREMAIL"), properties.getProperty("REGISTERPASSWORD"), properties.getProperty("REGISTERCONFIRMPASSWORD"));
		String pageTitle=driver.getTitle();
		Assert.assertEquals(properties.getProperty("REGISTERPAGETITLE"), pageTitle);
	}
	
	@Test(priority=4,description="This method used to test error message for the same email already registered")
	public void validateEmailAlreadyExistsErrorMessage() {
		
		registerPage.navigateToRegisterPage();
		registerPage.enterRegisterPageCredentials(properties.getProperty("EMAIL"), properties.getProperty("PASSWORD"), properties.getProperty("PASSWORD"));
		boolean isErrorMessageDisplayed=registerPage.verifyEmailAlreadyExistsErrorMessage();
		Assert.assertEquals(true, isErrorMessageDisplayed);
	}
	
	@Test(priority=5,description="This method used to validate password mismatch error message ")
	public void validatePasswordMismatchErrorMessage() {
		
		registerPage.navigateToRegisterPage();
		registerPage.enterRegisterPageCredentials(properties.getProperty("EMAIL"), properties.getProperty("PASSWORD"), properties.getProperty("REGISTERPASSWORD"));
		boolean isPasswordMismatchErrorMessageDisplayed=registerPage.verifyPasswordMismatchErrorMessage(properties.getProperty("PASSWORDMISMATCH"));
		Assert.assertEquals(true, isPasswordMismatchErrorMessageDisplayed);
	}
	
	@Test(priority=6,description="This method used to select particular locale from the dropdown values listed in the Register screen ")
	public void validateLocaleDropdownValueTextRegisterPage() {
		
		registerPage.navigateToRegisterPage();
		boolean isValueSelected= loginPage.selectValueFromLocaleDropdown(properties.getProperty("LOCALEDROPDOWNVALUEREGISTER"));
		Assert.assertTrue(isValueSelected);
		
	}
}
