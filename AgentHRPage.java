import org.openqa.selenium.WebDriver;


public class AgentHRPage {
	
	private WebDriver driver;
	
	public AgentHRPage(WebDriver driver)
	{	
		if(driver.getTitle().equals("Invitations"))
			this.driver = driver;
		else
			throw new IllegalStateException("This is not the login page:" + driver.getCurrentUrl());
	}
	

}
