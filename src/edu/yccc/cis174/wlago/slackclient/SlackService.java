package edu.yccc.cis174.wlago.slackclient;

import org.springframework.stereotype.Component;

import net.gpedro.integrations.slack.SlackApi;
import net.gpedro.integrations.slack.SlackMessage;

/**
 * Note that this won't compile due to a lack of Spring elements in this repository.
 */

@Component
public class SlackService
{
	private String webHookUrl = "https://hooks.slack.com/services/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";
	private SlackApi api = new SlackApi(webHookUrl);
	
	public void sendMessage(String channel, String userName, String message)
	{
		api.call(new SlackMessage(channel, userName, message));
	}

}
