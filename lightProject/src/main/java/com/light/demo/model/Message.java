package com.light.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private String msg;

    private Integer strength;

    private Integer frequency;
}
