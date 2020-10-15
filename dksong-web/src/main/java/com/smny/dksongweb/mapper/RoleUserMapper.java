package com.smny.dksongweb.mapper;

import com.smny.dksongweb.entity.RoleUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author YuanJing
 * @since 2020-09-08
 */
@Repository
@Mapper
public interface RoleUserMapper extends BaseMapper<RoleUser> {

}
