package com.light.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Light {
    private Integer id;

    private String name;

    private Integer strength;

    private Integer frequency;

    private String messageFre;

    private String messageStr;

    public Light(Integer lightId, String lightName, Integer strength, Integer frequency) {
        this.id = lightId;
        this.name = lightName;
        this.strength = strength;
        this.frequency = frequency;
    }
}