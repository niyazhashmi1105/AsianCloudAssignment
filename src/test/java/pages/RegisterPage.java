package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {
	
	
	public RegisterPage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath="//a[contains(text(),'« Back to Login')]")
	WebElement linkBacktoLogin;
	
	@FindBy(xpath="//a[contains(text(),'Register')]")
	private WebElement linkRegister;
	
	@FindBy(xpath="//h1[@id='kc-page-title']")
	private WebElement txtSignInAccount;
	
	@FindBy(xpath="//input[@value='Register']")
	private WebElement btnRegister;
	
	@FindBy(xpath="//span[@class='pf-c-alert__title kc-feedback-text']")
	private WebElement errorMessage;
	
	@FindBy(id="email")
	private WebElement txtboxEmail;
	
	@FindBy(id="password")
	private WebElement txtboxPassword;
	
	@FindBy(id="password-confirm")
	private WebElement txtboxConfirmPassword;
	
	@FindBy(xpath="//span[@class='pf-c-alert__title kc-feedback-text']")
	private WebElement emailAlreadyExistsErrorMessage;
	
	/* This method navigated to Register Page*/
	public void navigateToRegisterPage() {
		
		webActionHelperMethods.waitForElement(linkRegister, 10);
		webActionHelperMethods.clickElementUsingJS(linkRegister);
	}

	/*This method used to verify log in screen text once navigated back from Register page*/
	public boolean verifySigninAccountTextFromRegisterPage() {
		
		linkBacktoLogin.click();
		boolean isTextDisplayed= webActionHelperMethods.compareString("Sign in to your account", txtSignInAccount.getText().trim());
		return isTextDisplayed;
		
	}
	
	/*This method used to verify Error message on click of Register Button in Register page*/
	public boolean verifyErrorMessageOnClickRegisterButton() {
		
		webActionHelperMethods.waitForElement(btnRegister, 10);
		webActionHelperMethods.clickElementUsingJS(btnRegister);
		//System.out.println(errorMessage.getText().trim());
		boolean isErrorMessage = webActionHelperMethods.checkForSubstring("Please specify username.",errorMessage.getText().trim());
		return isErrorMessage;
	}
	
	/* This method accepts username and password as parameters and boolean value and sends the
	 * user credentials in the login screen*/
	 public void enterRegisterPageCredentials(String email, String password, String confirmPassword) {
		
		txtboxEmail.sendKeys(email);
		txtboxPassword.sendKeys(password);
		txtboxConfirmPassword.sendKeys(confirmPassword);
		webActionHelperMethods.waitForElement(btnRegister, 10);
		webActionHelperMethods.clickElementUsingJS(btnRegister);
		
	}
	
	 /*This method used to verify same email if registered already*/
	public boolean verifyEmailAlreadyExistsErrorMessage() {
		boolean isErrorMessageDisplayed=emailAlreadyExistsErrorMessage.isDisplayed();
		return isErrorMessageDisplayed;
	}
	
	 /*This method used to verify password mismatch error message*/
	public boolean verifyPasswordMismatchErrorMessage(String errorMessage) {
		//System.out.println( emailAlreadyExistsErrorMessage.getText().trim());
		boolean isPasswordMismatchErrorMessage=webActionHelperMethods.checkForSubstring(errorMessage, emailAlreadyExistsErrorMessage.getText().trim());
		return isPasswordMismatchErrorMessage;
	}
}
