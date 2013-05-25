/**
 * 
 */
package ch.zhaw.mima.message.reminder;

import ch.zhaw.mima.addresses.PhoneAddress;
import ch.zhaw.mima.message.SMS;


/**
 * @author michael
 * 
 */
public class SMSReminder extends AbstractReminderImpl<SMS, PhoneAddress> implements SMS,
Reminder<SMS> {

}
