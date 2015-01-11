import org.openqa.selenium.WebDriver;


public class UserGettingStartedPage {
	
	private WebDriver driver;
	
	public UserGettingStartedPage(WebDriver driver)
	{	
		if(driver.getTitle().equals("My Questionss"))
			this.driver = driver;
		else
			throw new IllegalStateException("This is not the user getting startet page page:" + driver.getCurrentUrl());
	}
	
	public LoginPage logout()
	{
		driver.get("https://alpha.insynctiveapps.com/Insynctive.Hub/Logout.aspx");
		return new LoginPage(driver);	
	}

}
