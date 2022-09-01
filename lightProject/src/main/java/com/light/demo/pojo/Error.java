package com.light.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Error {
    private Long id;

    private String msg;

    private Integer temperror;

    private Integer humierror;

    private Integer energyerror;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getTemperror() {
        return temperror;
    }

    public void setTemperror(Integer temperror) {
        this.temperror = temperror;
    }

    public Integer getHumierror() {
        return humierror;
    }

    public void setHumierror(Integer humierror) {
        this.humierror = humierror;
    }

    public Integer getEnergyerror() {
        return energyerror;
    }

    public void setEnergyerror(Integer energyerror) {
        this.energyerror = energyerror;
    }
}