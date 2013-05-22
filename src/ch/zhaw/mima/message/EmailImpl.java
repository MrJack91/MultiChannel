package ch.zhaw.mima.message;
/**
 * 
 */

/**
 * @author michael
 *
 */
public class EmailImpl extends AbstractMessageImpl {

	@Override
	public void send() {
	
		System.out.println("sending Email "+this);
	}

}
