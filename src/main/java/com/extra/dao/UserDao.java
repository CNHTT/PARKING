package com.extra.dao;

import com.extra.model.ManagerBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    ManagerBean selectManagerBySignIn(@Param("username")String username,@Param("pwd")String pwd);
}
