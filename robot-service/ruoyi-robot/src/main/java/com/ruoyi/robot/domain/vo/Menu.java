package com.ruoyi.robot.domain.vo;

import lombok.Data;

import java.util.List;

@Data
public class Menu {

    private Integer id;

    private String key;

    private String title;

    private List<Menu> children;

}
