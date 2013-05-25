/**
 * 
 */
package ch.zhaw.mima.message.reminder;

import ch.zhaw.mima.addresses.PrinterAddress;
import ch.zhaw.mima.message.PrinterJob;


/**
 * @author michael
 * 
 */
public class PrintJobReminder extends AbstractReminderImpl<PrinterJob, PrinterAddress> implements PrinterJob,
Reminder<PrinterJob> {

}
