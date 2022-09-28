package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;



public class LoginPageTest extends BasePageTest {
	
	
	@Test(priority=1,description="This is used to test after entering invalid Email reading from properties file and validating error message") 
	  public void validateErrorMessageOnEnteringInvalidEmail() {
	  
	  loginPage.enterUserCredentials(properties.getProperty("INVALIDEMAIL"),properties.getProperty("PASSWORD"),false); 
	  String errorMessage =loginPage.verfiyErrorMessage(properties.getProperty("ERRORMESSAGE"));
	  System.out.println(errorMessage);
	  Assert.assertEquals(properties.getProperty("ERRORMESSAGE"), errorMessage); 
	  }
	 
	
	
	 @Test(priority=2,description="This is used to test after entering invalid Password reading from properties file and validating error message") 
	  public void validateErrorMessageOnEnterInvalidPassword() {
	  
	  loginPage.enterUserCredentials(properties.getProperty("EMAIL"),properties.getProperty("INVALIDPASSWORD"),false); 
	  String errorMessage =loginPage.verfiyErrorMessage(properties.getProperty("ERRORMESSAGE"));
	  System.out.println(errorMessage);
	  Assert.assertEquals(properties.getProperty("ERRORMESSAGE"), errorMessage);
	  
	  }
	 
	  @Test(priority=3,description="This is used to test after entering valid Email and Password reading from properties file and validating pagetitle after successful login") 
	  public void validateValidUserCredentials() {
	  
	  loginPage.enterUserCredentials(properties.getProperty("EMAIL"),properties.getProperty("PASSWORD"),false); 
	  String pageTitle = driver.getTitle();
	  Assert.assertEquals(properties.getProperty("PAGETITLE"), pageTitle); 
	  }
	 
	 @Test(priority=4,description="This is used to validate whether Rememberme checkbox is displayed or not") 
	  public void validateRemembermeCheckboxTextOnLoginScreen() {
		  
		  boolean isRemembermeTextDisplayed= loginPage.isRemembemeCheckboxDisplayed();
		  Assert.assertEquals(true,isRemembermeTextDisplayed);
	}
	
	@Test(priority=5, description="This method used to test the text present in Login screen after navigating from ForgotPassword page")
	public void validateForgotPasswordNavigationLink() {
		loginPage.navigateToForgotPassword();
		boolean isLoginText= loginPage.verifySigninAccountTextFromForgotPasswordPage();
		Assert.assertEquals(true, isLoginText);
		
	}
	
	@Test(priority=6, description="This method used to test the error message with blank email id at the ForgotPassword page")
	public void validateErrorMessageOnForgotPasswordPage() {
		
		loginPage.navigateToForgotPassword();
		String text= loginPage.verifyErrorMessageOnClickSubmitButton();
		Assert.assertEquals(properties.getProperty("BLANKEMAILIDFORGOTPASSWORDPAGE"), text);
	}
	
	
	@Test(priority=7,description="This method used to verify the text on the screen for password reset")
	public void validatePasswordResetSuccessMessageForValidEmail() {
		
		loginPage.navigateToForgotPassword(); 
		boolean isSucccessMessageDisplayed=loginPage.verifySuccessfulPasswordResetMailMessage(properties.getProperty("EMAIL"), properties.getProperty("PASSWORDRESETSUCCESSMESSAGE"));
		Assert.assertEquals(true,isSucccessMessageDisplayed);
	}

	@Test(priority=8,description="This method used to validate error message for the inavlid email in the Forgot password page")
	public void validatePasswordResetSuccessMessageForInvalidEmail() {
		
		loginPage.navigateToForgotPassword(); 
		boolean isSucccessMessageDisplayed=loginPage.verifySuccessfulPasswordResetMailMessage(properties.getProperty("INVALIDEMAIL"), properties.getProperty("PASSWORDRESETSUCCESSMESSAGE"));
		Assert.assertEquals(true,isSucccessMessageDisplayed);
	}
	
	@Test(priority=9, description="This method used to test error messages for blank email and password")
	public void validateErrorMessageOnBlankEmailIDPasword() {
		
		loginPage.enterUserCredentials(" "," ",false); 
		String errorMessage =loginPage.verfiyErrorMessage(properties.getProperty("ERRORMESSAGE"));
		Assert.assertEquals(properties.getProperty("ERRORMESSAGE"), errorMessage);
	}
	
	@Test(priority=10, description="This method used to select particular locale from the dropdown values listed in the login screen ")
	public void validateLocaleDropdownValueTextLoginScreen() {
		boolean isValueSelected= loginPage.selectValueFromLocaleDropdown(properties.getProperty("LOCALEDROPDOWNVALUELOGIN"));
		Assert.assertTrue(isValueSelected);
		
	}
	
	@Test(priority=11, description="This method used to select particular locale from the dropdown values listed in the Forgot password screen" )
	public void validateLocaleDropdownValueTextForgotPasswordPage() {
		
		loginPage.navigateToForgotPassword();
		boolean isValueSelected= loginPage.selectValueFromLocaleDropdown(properties.getProperty("LOCALEDROPDOWNVALUEFORGOTPASSWORD"));
		Assert.assertTrue(isValueSelected);
		
	}
}
