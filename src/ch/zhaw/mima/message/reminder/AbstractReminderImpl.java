package ch.zhaw.mima.message.reminder;

import ch.zhaw.mima.addresses.Address;
import ch.zhaw.mima.message.AbstractMessageImpl;
import ch.zhaw.mima.message.Message;

public class AbstractReminderImpl<O extends Message<?>, A extends Address>
		extends AbstractMessageImpl<A> implements Reminder<O> {

	private O originalMessage;

	@Override
	public O getOriginalMessage() {
		return originalMessage;
	}

	@Override
	public void setOriginalMessage(O message) {
		originalMessage = message;

	}

	@Override
	public String getText() {
		StringBuilder builder = new StringBuilder();
		O originalMessage = getOriginalMessage();
		builder.append("REMINDER");
		if (originalMessage != null) {
			String sendTimeFormatted = originalMessage.getSendTimeFormatted();

			builder.append(" scheduled: ").append(sendTimeFormatted);
			builder.append("\n------\n");
			builder.append("reminder Message:\n");
			builder.append(super.getText());
			builder.append("\n------\n");
			builder.append("original Message:\n");

			builder.append(originalMessage.getText());
		}

		return builder.toString();

	}

}
