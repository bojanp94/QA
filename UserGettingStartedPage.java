import org.openqa.selenium.WebDriver;


public class UserGettingStartedPage {
	
	private WebDriver driver;
	
	public UserGettingStartedPage(WebDriver driver)
	{	
		if(driver.getTitle().equals("Invitations"))
			this.driver = driver;
		else
			throw new IllegalStateException("This is not the login page:" + driver.getCurrentUrl());
	}

}
