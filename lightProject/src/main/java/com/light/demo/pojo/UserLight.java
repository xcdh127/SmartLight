package com.light.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
public class UserLight {

    private Integer userLightId; //用户下载id

    private Integer userId; //下载资源

    private Integer lightId; //下载用户
}
