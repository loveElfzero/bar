package com.mtp.bar.service.impl;

import com.mtp.bar.entity.User;
import com.mtp.bar.mapper.UserMapper;
import com.mtp.bar.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 贴吧用户表 服务实现类
 * </p>
 *
 * @author YuanJing
 * @since 2021-01-06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
