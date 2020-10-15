package com.smny.dksongweb.service.impl;

import com.smny.dksongweb.entity.User;
import com.smny.dksongweb.mapper.UserMapper;
import com.smny.dksongweb.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author YuanJing
 * @since 2020-09-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
