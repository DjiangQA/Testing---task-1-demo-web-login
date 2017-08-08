package test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Navigation {
	
	String addUserx = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]";
	String loginx = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]";
	
	@FindBy (xpath = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]")
	private WebElement addUser;
	
	@FindBy (xpath = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")
	private WebElement login;
	
	public void clickadduser () {addUser.click();}
	public void clicklogin () {login.click();}
	
	

}
