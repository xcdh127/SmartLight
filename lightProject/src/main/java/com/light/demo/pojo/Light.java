package com.light.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Light {
    private Integer id;

    private String name;

    private Integer strength;

    private Integer frequency;

}