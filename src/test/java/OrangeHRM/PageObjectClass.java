package OrangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageObjectClass {
WebDriver driver;
	
	public  PageObjectClass(WebDriver d) {
		
		driver=d;
		PageFactory.initElements(d, this);
		
	}
	@FindBy(name="username")
	WebElement UserName;
	public void setUserName(String username) {
		UserName.sendKeys(username);
	}
	@FindBy(name="password")
	WebElement Password;
	public void setPassword(String pass) {
		Password.sendKeys(pass);
	}
	@FindBy(xpath="/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
	WebElement LoginBtn;
	public void clickLoginBtn() {
		LoginBtn.click();
	}
	
	//Clicking Leave Module
	@FindBy(xpath="/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[3]/a")
	WebElement Leave;
	public void ClickLeave() {
		Leave.click();
	}
	
	//Leave Applying Page
	@FindBy(xpath="/html/body/div/div[1]/div[1]/header/div[2]/nav/ul/li[1]")
	WebElement LApply;
	public void ClickLApply() {
		LApply.click();
	}
	
	//Leave Type  
	@FindBy(xpath="/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[2]")
	WebElement LeaveType;
	
	/* public void SelectingLeaveType() {
		Select LT= new Select(LeaveType);
		LT.selectByVisibleText(leavetype);  
		LeaveType.click();
	} */
	
 /*	//Selecting Leave Type
	@FindBy(xpath="/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[1]")
	WebElement Cleavetype;
	
	public void clickingleavetype() {
		Cleavetype.click();
	}
	*/
	
}
