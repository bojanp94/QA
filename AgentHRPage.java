import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AgentHRPage {
	
	private WebDriver driver;
	
	public AgentHRPage(WebDriver driver)
	{	
		if(driver.getTitle().equals("Invitations"))
			this.driver = driver;
		else
			throw new IllegalStateException("This is not the agent HR page page:" + driver.getCurrentUrl());
	} 
	public LoginPage logout()
	{
		driver.get("https://alpha.insynctiveapps.com/Insynctive.Hub/Logout.aspx");
		return new LoginPage(driver);	
	}
	public void addPerson(String name, String surname, String email, boolean selfservice)
	{
		driver.findElement(By.id("tds_body_mainTab_TPTCR_btnAddPerson_0")).click();
		driver.findElement(By.id("tds_body_popupAddPerson_txtFirstName_I")).sendKeys(name);
		driver.findElement(By.id("tds_body_popupAddPerson_txtLastName_I")).sendKeys(surname);
		driver.findElement(By.id("tds_body_popupAddPerson_txtEmail_I")).sendKeys(email);
		
		if(selfservice)
			driver.findElement(By.id("tds_body_popupAddPerson_chkInvite_S_D")).click();
		
		driver.findElement(By.id("tds_body_popupAddPerson_btnAddHRAdmin_CD")).click();
	}

}
