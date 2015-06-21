package mq.all;

import javax.jms.Destination;

import org.springframework.jms.core.JmsTemplate;

/**
 * 消息生产者服务类
 */
public class TopicMessageProducer {
	private JmsTemplate jmsTemplate;
	private Destination notifyTopic;
	private NotifyMessageConverter messageConverter;

	public void sendQueue(PhoneNoticeInfo noticeInfo) {
		sendMessage(noticeInfo);
	}

	private void sendMessage(PhoneNoticeInfo noticeInfo) {
		// TODO Auto-generated method stub
		jmsTemplate.setMessageConverter(messageConverter);
		jmsTemplate.setPubSubDomain(false);
		jmsTemplate.convertAndSend(notifyTopic, noticeInfo);
	}

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}


	public Destination getNotifyTopic() {
		return notifyTopic;
	}

	public void setNotifyTopic(Destination notifyTopic) {
		this.notifyTopic = notifyTopic;
	}

	public NotifyMessageConverter getMessageConverter() {
		return messageConverter;
	}

	public void setMessageConverter(NotifyMessageConverter messageConverter) {
		this.messageConverter = messageConverter;
	}
}