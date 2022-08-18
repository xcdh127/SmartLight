package com.light.demo.mqtt;

import com.light.demo.config.SpringUtil;
import com.light.demo.pojo.Message;

import com.light.demo.service.MessageService;
import com.light.demo.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;


/**
 * 常规MQTT回调函数
 *
 * @author Mr.Qu
 * @since 2020/1/9 16:26
 */
@Slf4j
@Component
public class Callback implements MqttCallback {

    /**
     * MQTT 断开连接会执行此方法
     */
    @Override
    public void connectionLost(Throwable throwable) {
        log.info("断开了MQTT连接 ：{}", throwable.getMessage());
        log.error(throwable.getMessage(), throwable);
    }

    /**
     * publish发布成功后会执行到这里
     */
    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        log.info("发布消息成功");
    }

    /**
     * subscribe订阅后得到的消息会执行到这里
     */
    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        //  TODO    此处可以将订阅得到的消息进行业务处理、数据存储
        log.info("收到来自 " + topic + " 的消息：{}", new String(message.getPayload()));
        String messageStr = new String(message.getPayload());
        Message meg = JsonUtils.parseJson(messageStr, Message.class);
        ApplicationContext context = SpringUtil.context;  //获取Spring容器
        MessageService messageService = context.getBean(MessageService.class);  //获取bean
        messageService.insert(meg);
    }
}

