package com.activemq.jms;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JmsConsumerBlockage {

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
        MessageConsumer messageConsumer = session.createConsumer(queue);
        //阻塞式
        while (true) {
            //6、接收队列或主题的消息
            TextMessage textMessage = (TextMessage) messageConsumer.receive();
            if (textMessage != null) {
                //7、获取消息中的数据
                String text = textMessage.getText();
                System.out.println(text);
            } else {
                break;
            }
        }
        //8、关闭资源
        messageConsumer.close();
        session.close();
        connection.close();
    }

}
