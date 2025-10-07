package com.njtech.mapper;

import org.apache.ibatis.annotations.Param;

public interface AccountMapper {
    public void incrMoney(@Param("account") String accountName, @Param("money") Integer money);
    public void decrMoney(@Param("account") String accountName, @Param("money") Integer money);
}
