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
            server.setMqttClient("admin", "public", new Callback());
            //server.setMqttClient("aa22&h84sWr7GXZw", "b332838b405a7a921d9ce194947700576a0909af453aa13fc6fb52f21be67ac3", new Callback());
            //server.setMqttClient("mzh001&h84sWr7GXZw", "2fe1ccd495048ef4b82a6ccfe93bbb42decec9d71cc72342093067159b12f9ce", new Callback());
            server.sub("com/iot/init");
            server.sub("com/iot/message");
            server.sub("lqj");
            /*server.sub("/h84sWr7GXZw/aa22/user/com/iot/init");
            server.sub("/sys/h84sWr7GXZw/aa22/thing/service/property/set");*/
            //server.sub("/sys/h84sWr7GXZw/mzh001/thing/service/property/set");
        } catch (MqttException e) {
            log.error(e.getMessage(), e);
        }
    }
}
