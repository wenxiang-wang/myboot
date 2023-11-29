package com.activemq.jms;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

public class JmsConsumeraSynchronousListener {

    public static final String ACTIVEMQ_URL = "tcp://123.56.25.119:61616";
    public static final String QUEUE_NAME = "queue001";

    public static void main(String[] args) throws JMSException, IOException {
        System.out.println("消费者1");
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
        //6、使用异步监听式来获取消息
        messageConsumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                if (message != null && message instanceof TextMessage) {
                    //7、获取消息并通过消息获得数据
                    TextMessage textMessage = (TextMessage) message;
                    try {
                        System.out.println(textMessage.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        System.in.read();  //输入键盘任意键结束
        //8、关闭资源
        messageConsumer.close();
        session.close();
        connection.close();
    }

}
