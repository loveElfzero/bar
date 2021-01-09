package com.mtp.bar.mapper;

import com.mtp.bar.entity.Bar;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author YuanJing
 * @since 2021-01-06
 */
@Repository
@Mapper
public interface BarMapper extends BaseMapper<Bar> {

}
