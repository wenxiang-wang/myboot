package com.activemq.jms;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JmsProduce {

    public static final String ACTIVEMQ_URL = "tcp://123.56.25.119:61616";  //ActiveMQ地址
    public static final String QUEUE_NAME = "queue001";  //队列名称

    public static void main(String[] args) throws JMSException {
        //1、创建连接工厂，按照给定的URL地址，采用默认的用户名和密码
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        //2、通过连接工厂，获得连接connection并启动访问
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        //3、创建会话Session（两个参数：transacted=是否开启事务，acknowledgeMode=签收模式）
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //4、创建目的地（具体是队列(queue)还是主题(top)）
        Queue queue = session.createQueue(QUEUE_NAME);
        //5、创建消息的生产者
        MessageProducer messageProducer = session.createProducer(queue);
        //6、创建消息并赋值
        TextMessage textMessage = session.createTextMessage();  //String类型的
        textMessage.setText("fzk");
        //7、发送消息到队列或主题
        messageProducer.send(textMessage);
        //8、关闭资源
        messageProducer.close();
        session.close();
        connection.close();

        System.out.println("消息发送完毕");
    }
}

