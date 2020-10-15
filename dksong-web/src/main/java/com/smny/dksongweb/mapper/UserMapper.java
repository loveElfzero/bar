package com.smny.dksongweb.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smny.dksongweb.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author YuanJing
 * @since 2020-09-03
 */
@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {
    IPage<User> selectByRoleId(Page page, @Param("user") User user);
}
