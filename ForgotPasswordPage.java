import org.openqa.selenium.WebDriver;


public class ForgotPasswordPage {
	
	private WebDriver driver;
	
	public ForgotPasswordPage(WebDriver driver) 
	{
		if(driver.getTitle().equals("Forgot Password"))
			this.driver = driver;
		else
			throw new IllegalStateException("This is not the login page:" + driver.getCurrentUrl());
	}

}
