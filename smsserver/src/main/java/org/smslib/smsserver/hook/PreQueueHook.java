
package org.smslib.smsserver.hook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smslib.hook.IPreQueueHook;
import org.smslib.message.OutboundMessage;
import org.smslib.message.OutboundMessage.SentStatus;
import org.smslib.smsserver.SMSServer;

public class PreQueueHook implements IPreQueueHook
{
	static Logger logger = LoggerFactory.getLogger(PreQueueHook.class);

	@Override
	public boolean process(OutboundMessage message)
	{
		try
		{
			SMSServer.getInstance().getDatabaseHandler().setMessageStatus(message, SentStatus.Queued);
			return true;
		}
		catch (Exception e)
		{
			logger.error("Error!", e);
			return false;
		}
	}
}
