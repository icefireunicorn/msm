package mq.persistent.spring;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

public class MessageSender {
	 public JmsTemplate jmsTemplate;  
     
	    /** 
	     * send message 
	     */  
	    public void sendMessage(){  
	        jmsTemplate.convertAndSend("hello jms!");  
	    }  
	    public void setJmsTemplate(JmsTemplate jmsTemplate) {  
	        this.jmsTemplate = jmsTemplate;  
	    }  
	    
	    public static void main(String[] args) throws IOException {  
	        System.out.println("初始化spring！准备开始接收！");  
//	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:conf/amq-queue.xml");  
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:conf/amq-topic.xml");  
	        MessageSender t=(MessageSender) context.getBean("messageSender");  
	        t.sendMessage();  
	    }  
}
