package com.light.demo.pojo;

public class Message {
    private Long messageId;

    private String msg;

    private Integer strength;

    private Integer temperature;

    private Integer humidity;

    private String date;

    private Double energyUsed;

    private Double jingdu;

    private Double weidu;

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getEnergyused() {
        return energyUsed;
    }

    public void setEnergyused(Double energyUsed) {
        this.energyUsed = energyUsed;
    }

    public Double getJingdu() {
        return jingdu;
    }

    public void setJingdu(Double jingdu) {
        this.jingdu = jingdu;
    }

    public Double getWeidu() {
        return weidu;
    }

    public void setWeidu(Double weidu) {
        this.weidu = weidu;
    }
}