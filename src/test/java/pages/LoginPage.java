package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//*[@id='username']")
	private WebElement txtboxEmail;
	
	@FindBy(id="password")
	private WebElement txtBoxPass;
	
	@FindBy(id="kc-login")
	private WebElement btnSignin;
	
	@FindBy(id="input-error")
	private WebElement errorMsg;
	
	@FindBy(xpath="//*[@id='rememberMe']")
	private WebElement chkboxRememberMe;
	
	@FindBy(xpath="//*[@class='vue-avatar--wrapper']")
	private WebElement avatar;
	
	@FindBy(xpath="//button[contains(text(),'Logout')]")
	private WebElement btnLogout;
	
	@FindBy(xpath="//a[contains(text(),'Forgot Password?')]")
	private WebElement linkForgotPassword;
	
	@FindBy(xpath="//a[contains(text(),'« Back to Login')]")
	private WebElement linkBacktoLogin;
	
	
	@FindBy(xpath="//h1[@id='kc-page-title']")
	private WebElement txtSignInAccount;
	
	@FindBy(xpath="//*[@id='kc-form-buttons']/input")
	private WebElement btnSubmit;
	
	@FindBy(xpath="//span[@id='input-error-username']")
	private WebElement errorMessageEmailId;
	
	
	@FindBy(xpath="//span[contains(text(),'You should receive an email shortly with further instructions.')]")
	private WebElement passwordResetSuccessMessage;
	
	
	/* This method accepts username and password as parameters and boolean value and sends the
	 * user credentials in the login screen
	 */
	public void enterUserCredentials(String userName, String password,boolean flag) {
		
		if(flag== false) {
			
			webActionHelperMethods.waitForElement(txtboxEmail, 10);
			txtboxEmail.sendKeys(userName);
			txtBoxPass.sendKeys(password);
		}
		else {
				webActionHelperMethods.waitForElement(txtboxEmail, 10);
				txtboxEmail.sendKeys(userName);
				txtBoxPass.sendKeys(password);
				chkboxRememberMe.click();
		}
		webActionHelperMethods.clickbutton(btnSignin);
	}
	
	/*This method used to return the error message*/
	public String verfiyErrorMessage(String errorMessage) {
		errorMessage = errorMsg.getText().trim();
		return errorMessage;
	}
	
	/*This method used to check whether rememberme checkbox displayed or not and return the boolean value*/
	public boolean isRemembemeCheckboxDisplayed() {
		
		boolean isTextDisplayed=chkboxRememberMe.isDisplayed();
		return isTextDisplayed;
	}
	
	/*This method used to navigate to Forgot password page*/
	public void navigateToForgotPassword() {
		webActionHelperMethods.waitForElement(linkForgotPassword, 10);
		webActionHelperMethods.clickElementUsingJS(linkForgotPassword);
	}
	
	/*This method used to verify log in screen text once navigated back from Forgot password page*/
	public boolean verifySigninAccountTextFromForgotPasswordPage() {
		
		linkBacktoLogin.click();
		boolean isTextDisplayed= webActionHelperMethods.compareString("Sign in to your account", txtSignInAccount.getText().trim());
		return isTextDisplayed;
	}
	
	/*This method used to click on Submit button and verify the text in the Forgot password page*/
	public String verifyErrorMessageOnClickSubmitButton() {
		
		btnSubmit.click();
		String errorMessage = errorMessageEmailId.getText().trim();
		return errorMessage;
	}
	
	/*This method used to verify the text once valid email id pass in Forgot password page*/
	public boolean verifySuccessfulPasswordResetMailMessage(String emailId,String message) {
		
		txtboxEmail.sendKeys(emailId);
		btnSubmit.click();
		boolean isTextDisplayed= webActionHelperMethods.containsString(message, passwordResetSuccessMessage.getText().trim());
		return isTextDisplayed;
	}
	
	/*This method used to accept value as an argument and select the value from the locale dropdown*/
	public boolean selectValueFromLocaleDropdown(String value) {
		
		webActionHelperMethods.MouseHover("//div[@id='kc-locale-dropdown']/a");
		webActionHelperMethods.RefreshAndWait(3);
		boolean isValueSelected = webActionHelperMethods.selectdropdown("//ul[@class='pf-c-dropdown__menu pf-m-align-right']/li", value);
		return isValueSelected;
	}
	
}
