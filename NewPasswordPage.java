import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class NewPasswordPage {
	
private WebDriver driver;
	
	public NewPasswordPage(WebDriver driver) 
	{
		if(driver.getTitle().equals("Change Password"))
			this.driver = driver;
		else
			throw new IllegalStateException("This is not the new password page:" + driver.getCurrentUrl());
	}
	public void setNewPassword(String password)
	{
		driver.findElement(By.id("txtNewPassword_I")).sendKeys(password);
		driver.findElement(By.id("txtConfirmNewPassword_I")).sendKeys(password);
		driver.findElement(By.id("btnChangePassword_CD")).click();
			
	}

}
