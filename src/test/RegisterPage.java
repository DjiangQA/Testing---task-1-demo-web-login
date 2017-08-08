package test;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage {
	
	@FindBy (css = "td.auto-style1  td:nth-child(1)  tr:nth-child(1) td:nth-child(2) input")
	private WebElement userNameInput;
	
	@FindBy (css = "td.auto-style1  td:nth-child(1)  tr:nth-child(2) input[type=\"password\"]")
	private WebElement passWordInput;
	
	@FindBy (xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input")
	private WebElement submitButton;
	
	public void enterUserName (String userName) {userNameInput.sendKeys(userName);}
	public void enterPassword (String passWord) {passWordInput.sendKeys(passWord);}
	public void clickSubmit () {submitButton.click();}
}
