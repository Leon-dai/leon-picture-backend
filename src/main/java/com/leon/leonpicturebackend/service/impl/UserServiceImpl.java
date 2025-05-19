package com.leon.leonpicturebackend.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leon.leonpicturebackend.exception.BusinessException;
import com.leon.leonpicturebackend.exception.ErrorCode;
import com.leon.leonpicturebackend.mapper.UserMapper;
import com.leon.leonpicturebackend.model.entity.User;
import com.leon.leonpicturebackend.service.UserService;
import org.springframework.stereotype.Service;

/**
* @author leon
* @description 针对表【user(用户)】的数据库操作Service实现
* @createDate 2025-05-16 21:58:26
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    /**
     * 用户注册
     * @param userAccount    用户账户
     * @param userPassword   用户密码
     * @param checkPassword  校验密码
     * @return 新用户id
     */
    @Override
    public long userRegister(String userAccount, String userPassword, String checkPassword) {
        // 1.校验参数
        if(StrUtil.hasBlank(userAccount, userPassword, checkPassword)){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "参数为空");
        }
        if(userAccount.length() < 4){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户账号过短");
        }
        if(userPassword.length() < 8 || checkPassword.length() < 8){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户密码过短");
        }
        if(!userPassword.equals(checkPassword)){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "两次输入的密码不一致");
        }
        // 2.检查用户账号是否和数据库中已有的重复
        // 3.密码一定要加密
        // 4.插入数据到数据库中
        return 0;
    }
}




