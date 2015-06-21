package mq.all;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Sender {
	/**
	 * 发送点对点信息
	 * 
	 * @param noticeInfo
	 */
	public static void main(String[] args) {
		String[] configLocations = new String[] { "classpath:conf/activeMQ.xml" };
		ApplicationContext context = new ClassPathXmlApplicationContext(
				configLocations);
		QueueMessageProducer notifyMessageProducer = ((QueueMessageProducer) context
				.getBean("queueMessageProducer"));
		PhoneNoticeInfo noticeInfo = new PhoneNoticeInfo();

		// （下面先展示PhoneNoticeInfo 然后是 QueueMessageProducer ）
		noticeInfo.setNoticeContent("Hello Word");
		noticeInfo.setNoticeTitle("hello Word");
		noticeInfo.setReceiver("hello");
		noticeInfo.setReceiverPhone("1111111");
		notifyMessageProducer.sendQueue(noticeInfo);
		
		
		TopicMessageProducer topicNotifyMessageProducer = ((TopicMessageProducer) context
				.getBean("topicMessageProducer"));
		topicNotifyMessageProducer.sendQueue(noticeInfo);
	}

}
