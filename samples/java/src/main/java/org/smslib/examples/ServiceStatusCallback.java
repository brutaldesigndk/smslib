
package org.smslib.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smslib.callback.IServiceStatusCallback;
import org.smslib.callback.events.ServiceStatusCallbackEvent;

public class ServiceStatusCallback implements IServiceStatusCallback
{
	final Logger logger = LoggerFactory.getLogger(ServiceStatusCallback.class);

	@Override
	public boolean process(ServiceStatusCallbackEvent event)
	{
		logger.info("[ServiceStatusCallback] " + event.getOldStatus() + " -> " + event.getNewStatus());
		return true;
	}
}
