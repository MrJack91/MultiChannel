package ch.zhaw.mima.message;

import java.util.ArrayList;
import java.util.List;

import ch.zhaw.mima.Recipient;

/**
 * 
 */

/**
 * @author michael
 * 
 */
public abstract class AbstractMessageImpl implements Message {

	private String text;
	private List<Recipient> recipients;
	private int sendTime;

	public AbstractMessageImpl() {
		recipients = new ArrayList<Recipient>();
	}

	public String getText() {
		return text;
	}

	@Override
	public List<Recipient> getRecipient() {
		return recipients;
	}

	@Override
	public int getSendTime() {
		return sendTime;
	}

	@Override
	public void setText(String text) {
		this.text = text;

	}

	@Override
	public void addRecipient(Recipient recipient) {
		recipients.add(recipient);

	}

	@Override
	public void setSendTime(int sendTime) {
		this.sendTime = sendTime;
	}

}
