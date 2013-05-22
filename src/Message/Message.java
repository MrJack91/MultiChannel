package Message;
/**
 * 
 */

/**
 * @author michael
 *
 */
public interface Message {
	public String	getText();
	
	public String getReceipients();
	
	public int getSendTime();
	
	public void send();
	
}
