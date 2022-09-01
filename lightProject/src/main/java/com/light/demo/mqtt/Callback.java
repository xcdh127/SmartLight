package com.light.demo.mqtt;

import com.light.demo.pojo.Error;
import com.light.demo.pojo.Gongdan;
import com.light.demo.service.ErrorService;
import com.light.demo.service.GongdanService;
import com.light.demo.utils.SpringUtil;
import com.light.demo.pojo.Message;

import com.light.demo.service.MessageService;
import com.light.demo.utils.DateUtil;
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
        if (topic.equals("com/iot/message")) {
            String messageStr = new String(message.getPayload());
            Message meg = JsonUtils.parseJson(messageStr, Message.class);
            String dateStr = DateUtil.getCurrentDateStr();
            meg.setDate(dateStr);
            ApplicationContext context = SpringUtil.context;  //获取Spring容器
            MessageService messageService = context.getBean(MessageService.class);  //获取bean
            //先查询数据库，如果没有这一条记录，插入到数据库中
            if (messageService.selectByPrimaryKey(meg.getMessageId()) == null) {
                messageService.insert(meg);
            }
        }

        if (topic.equals("com/iot/test")) {
            String errorStr = new String(message.getPayload());
            Error error = JsonUtils.parseJson(errorStr, Error.class);
            ApplicationContext context = SpringUtil.context;  //获取Spring容器
            ErrorService errorService = context.getBean(ErrorService.class);//获取bean
            //保存错误信息到数据库
            errorService.insertSelective(error);

            if (error.getEnergyerror() == 1) {
                System.out.println("用电量异常");
                Gongdan gongdan=new Gongdan();
                gongdan.setEvent("用电量异常");
                gongdan.setBuildtime(DateUtil.getCurrentDateStr());
                gongdan.setTel("123456789");
                gongdan.setIsdone(0);
                GongdanService gongdanService = context.getBean(GongdanService.class);//获取bean
                gongdanService.insert(gongdan);
                log.info("联系人电话：{},事件：{}",gongdan.getTel(),gongdan.getEvent());
            } else if (error.getHumierror() == 1) {
                System.out.println("湿度异常");
                Gongdan gongdan=new Gongdan();
                gongdan.setEvent("湿度异常");
                gongdan.setBuildtime(DateUtil.getCurrentDateStr());
                gongdan.setTel("123456789");
                gongdan.setIsdone(0);
                GongdanService gongdanService = context.getBean(GongdanService.class);//获取bean
                gongdanService.insert(gongdan);
                log.info("联系人电话：{},事件：{}",gongdan.getTel(),gongdan.getEvent());
            } else if (error.getTemperror() == 1) {
                System.out.println("温度异常");
                Gongdan gongdan=new Gongdan();
                gongdan.setEvent("温度异常");
                gongdan.setBuildtime(DateUtil.getCurrentDateStr());
                gongdan.setTel("123456789");
                gongdan.setIsdone(0);
                GongdanService gongdanService = context.getBean(GongdanService.class);//获取bean
                gongdanService.insert(gongdan);
                log.info("联系人电话：{},事件：{}",gongdan.getTel(),gongdan.getEvent());
            }
        }
    }
}

