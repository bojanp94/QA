import java.util.Properties;

import javax.mail.*;
import javax.mail.search.SubjectTerm;

/**
 * @author Bojan
 * This class contains static functions that can be used for mail handling
 * This is an abstract class
 */
public abstract class Mail {
	
	/**
	 * This function uses the javax.mail library to access an Gmail 
	 * Account in the background and retrieve the confirmation URL for
	 * new account creation. You can use the Gmail account:
	 * username: insynctivetest@gmail.com
	 * password: automation123456
	 * @param email
	 * @param password
	 * @return
	 * @throws Exception This function can throw an exception if: the
	 * Gmail credential are wrong, the Gmail account has two step validation,
	 * the Gmail account is not set up to use less secure apps, the process 
	 * are interrupted or the email does not arrive. 
	 */
	public static String getConfirmationURL(String email, String password) throws Exception
	{
		Properties props = System.getProperties();
		props.setProperty("mail.store.protocol", "imaps");

		Session session = Session.getDefaultInstance(props, null);
		Store store = session.getStore("imaps");
		store.connect("imap.gmail.com",email,password);
		
		Folder folder = store.getFolder("INBOX");
		folder.open(Folder.READ_WRITE);
		
		Message[] messages = null;
		boolean isMailFound = false;
		Message regMail = null;
		
		// Search for mails that have the appropriate title and wait for a max of 50s
		for (int i = 0; i < 5; i++) 
		{
			messages = folder.search(new SubjectTerm("Insynctive Account Credentials"), folder.getMessages());
			if (messages.length == 0) 
			{
				Thread.sleep(10000);
			}
		}
		// Search for unread mail from messages
		// This is to avoid using the mail for which
		// Registration is already done
		for (Message mail : messages) 
		{
			if (!mail.isSet(Flags.Flag.SEEN)) 
			{
					regMail = mail;
					isMailFound = true;
			}
		}
		// Test fails if no unread mail was found 
		if (!isMailFound) 
		{
			throw new Exception("Could not find new registration mail");		
		}
		// Read the content of mail and get registration URL
		else 
		{
			Multipart mp = (Multipart) regMail.getContent();
            BodyPart bp = mp.getBodyPart(0);
            String htmlofMail = bp.getContent().toString();
            int start = htmlofMail.indexOf("https");
            int end = htmlofMail.indexOf("style=\"background-color:#5cbf2a");
            return htmlofMail.substring(start, end-2);
            
		}
	}
}
