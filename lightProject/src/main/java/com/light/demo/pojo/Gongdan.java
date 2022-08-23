package com.light.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Gongdan {
    private Long id;

    private String event;

    private String tel;

    private Integer isdone;

    private String buildtime;

    public Gongdan(String event, String tel) {
        this.event = event;
        this.tel = tel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getIsdone() {
        return isdone;
    }

    public void setIsdone(Integer isdone) {
        this.isdone = isdone;
    }

    public String getBuildtime() {
        return buildtime;
    }

    public void setBuildtime(String buildtime) {
        this.buildtime = buildtime;
    }
}