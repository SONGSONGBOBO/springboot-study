package com.songbo.mybatisplus.dao.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @ClassName Account
 * @Description TODO
 * @Author songbo
 * @Date 19-10-10 下午5:50
 **/
@Data
@TableName("account")
public class Account {

    @TableId
    private Integer accountId;
    @TableField
    private String accountName;
    @TableField
    private Integer accountStatus;
}
