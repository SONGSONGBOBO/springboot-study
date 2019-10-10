package com.songbo.mybatisplus.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.Mapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.songbo.mybatisplus.dao.domain.Account;
import org.apache.ibatis.annotations.Param;

public interface AccountMapper extends Mapper<Account> {

    IPage<Account> getAccountPage(Page<Account> page, @Param("status") Integer status);
}
