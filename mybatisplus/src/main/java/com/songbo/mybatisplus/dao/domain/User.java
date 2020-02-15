package com.songbo.mybatisplus.dao.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@TableName(value = "user", resultMap = "BaseResultMap")
public class User implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer userId;

    @TableField
    private String userName;

    @TableField
    private String userPwd;
    @Transient
    //@TableField(exist = false)
    //tmd使用这个注解也不好使啊,包冲突了全部换成mybatisplus即可
    private List<Son> sons = new ArrayList<>();

}