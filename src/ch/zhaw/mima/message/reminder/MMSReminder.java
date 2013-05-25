/**
 * 
 */
package ch.zhaw.mima.message.reminder;

import ch.zhaw.mima.addresses.PhoneAddress;
import ch.zhaw.mima.message.MMS;


/**
 * @author michael
 * 
 */
public class MMSReminder extends AbstractReminderImpl<MMS, PhoneAddress> implements MMS,
		Reminder<MMS> {

}
