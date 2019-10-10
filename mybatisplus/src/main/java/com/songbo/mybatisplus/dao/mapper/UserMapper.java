package com.songbo.mybatisplus.dao.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.songbo.mybatisplus.dao.domain.Son;
import com.songbo.mybatisplus.dao.domain.User;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


public interface UserMapper extends Mapper<User> {
    User getSonsByUserId(int id);
    List<Son> getSonById(int id);
    List<User> getUserList();
}