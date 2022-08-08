package com.light.demo.mqtt;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


/**
 * 项目启动 监听主题
 *
 * @author Mr.Qu
 * @since 2020/1/10
 */
@Slf4j
@Component
public class MQTTListener implements ApplicationListener<ContextRefreshedEvent> {

    private final MQTTConnect server;

    @Autowired
    public MQTTListener(MQTTConnect server) {
        this.server = server;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            //server.setMqttClient("admin", "public", new Callback());
            server.setMqttClient("aa22&h84sWr7GXZw", "4fdd6aca3e9d965ebb3046d05bd0ecf13f7ce247c90ff3fc15e682437b95bccb", new Callback());
            //server.sub("com/iot/init");
            server.sub("/h84sWr7GXZw/aa22/user/com/iot/init");
            server.sub("/sys/h84sWr7GXZw/aa22/thing/event/property/post");
        } catch (MqttException e) {
            log.error(e.getMessage(), e);
        }
    }
}
