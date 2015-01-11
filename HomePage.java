import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * @author Bojan
 *	This is an intermediate class that 
 *  allows to chose the user or agent interface
 */
public class HomePage {
	
	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		if(driver.getTitle().equals("My Questions")||driver.getTitle().equals("Invitations"))
			this.driver = driver;
		else
			throw new IllegalStateException("This is not the login page:" + driver.getCurrentUrl());
	}
	
	/**
	 * This method opens the AgentHRPage or returns an object of it if it was
	 * already open. This method will throw an exception if the account does not 
	 * have HR Admin permissions
	 * @return
	 */
	public AgentHRPage openAgentInterface()
	{
		if(driver.getTitle().equals("Invitations"))
			return new AgentHRPage(driver);
		else
		{
			driver.findElement(
					By.xpath(".//*[@id='tblMain']/tbody/tr[1]/td[2]/table/tbody/tr/td[6]/img"))
					.click();
			driver.findElement(By.id("popupAccount_lnkAgentInterface")).click();
			return new AgentHRPage(driver);
			
		}	
	}
	
	public UserGettingStartedPage openUserInterface()
	{
		if(driver.getTitle().equals("My Questions"))
			return new UserGettingStartedPage(driver);
		else
		{
			driver.findElement(
					By.xpath(".//*[@id='tblMain']/tbody/tr[1]/td[2]/table/tbody/tr/td[6]/img"))
					.click();
			driver.findElement(By.id("popupAccount_lnkEmployeeInterface")).click();
			return new UserGettingStartedPage(driver);
			
		}	
	}
	
}
