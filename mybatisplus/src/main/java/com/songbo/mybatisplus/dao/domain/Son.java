package com.songbo.mybatisplus.dao.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.*;

@Data
@TableName("son")
public class Son {
    @TableId(type = IdType.AUTO)
    private Integer sonId;

    @TableField
    private String sonName;

    @TableField
    private Integer sonUserId;
    //@TableField(exist = false)
    @Transient
    private User user;


}