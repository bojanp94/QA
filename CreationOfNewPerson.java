import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class CreationOfNewPerson {
	
	private WebDriver driver;

	@Before
	public void setUp() throws Exception 
	{
	    driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	  
	@After
	public void tearDown() throws Exception 
	{
		driver.quit();
	}
	
	@Test
	  public void testT() throws Exception {
		
	    driver.get("https://alpha.insynctiveapps.com");
	    
	    LoginPage login = new LoginPage(driver);
	    
	    AgentHRPage hrPage = login.login("bpetrovski@insynctive.com", "*********", false).openAgentInterface();
	    
	    hrPage.addPerson("TestUser4", "TestSurname4", "insynctivetest+4@gmail.com", true);
	    
	    driver.get(Mail.getConfirmationURL("insynctivetest@gmail.com","*********"));
	    
	    new NewPasswordPage(driver).setNewPassword("*********");
	}
	
	
}
