package com.mtp.bar.mapper;

import com.mtp.bar.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 贴吧用户表 Mapper 接口
 * </p>
 *
 * @author YuanJing
 * @since 2021-01-06
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

}
