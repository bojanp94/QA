import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * @author Bojan
 * This class provides the functionality of the login page
 */
public class LoginPage {
	
	private WebDriver driver;
	
	/**
	 * @param driver should be set to the login page 
	 * If the driver is not set to the login page an 
	 * IllegalStateException will be thrown 
	 */
	public LoginPage (WebDriver driver)
	{
		if(driver.getTitle().equals("Login"))
			this.driver = driver;
		else
			throw new IllegalStateException("This is not the login page:" + driver.getCurrentUrl());
	}
	
	/**
	 * This method logs in with the provided credentials.
	 * If the provided credentials are incorrect the method
	 * will throw an exception.
	 * @param username
	 * @param password
	 * @param remeberMe
	 * @return 
	 */
	public HomePage login(String username, String password, boolean remeberMe)
	{
		driver.findElement(By.id("login_UserName_I")).clear();
		driver.findElement(By.id("login_UserName_I")).sendKeys(username);
		driver.findElement(By.id("PasswordLabel")).clear();
		driver.findElement(By.id("login_Password_I")).sendKeys(password);
		
		if(remeberMe)
			driver.findElement(By.id("login_RememberMe_S_D")).click();
		
		driver.findElement(By.id("login_Login_CD")).click();
			
		return new HomePage(driver);
	}
	
	/**
	 * This method returns an ForgotPasswordPage object
	 * @return 
	 */
	public ForgotPasswordPage forgotPassword()
	{
		driver.findElement(By.id("login_linkForgotPassword")).click();
		return new ForgotPasswordPage(driver);
	}
	

}
