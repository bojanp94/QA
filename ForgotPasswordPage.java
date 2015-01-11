import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class ForgotPasswordPage {
	
	private WebDriver driver;
	
	public ForgotPasswordPage(WebDriver driver) 
	{
		if(driver.getTitle().equals("Forgot Password"))
			this.driver = driver;
		else
			throw new IllegalStateException("This is not the login page:" + driver.getCurrentUrl());
	}
	public LoginPage sendRequest(String email)
	{
		driver.findElement(By.id("txtEmail_I")).clear();
		driver.findElement(By.id("txtEmail_I")).sendKeys(email);
		driver.findElement(By.id("btnSend_CD")).click();
		driver.findElement(By.id("btnOK_CD")).click();
		
		return new LoginPage(driver);
	}
	public LoginPage cancel()
	{
		driver.findElement(By.id("btnCancel_CD")).click();
		
		return new LoginPage(driver);
	}

}
