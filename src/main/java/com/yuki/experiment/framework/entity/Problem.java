package com.yuki.experiment.framework.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class Problem implements Serializable {

    @ApiModelProperty("题干")
    private String stem;

    @ApiModelProperty("具体选项")
    private List<Option> options;

    @ApiModelProperty("参考答案")
    private Option reference;

    @ApiModelProperty("练习分值")
    private BigDecimal score;


}
