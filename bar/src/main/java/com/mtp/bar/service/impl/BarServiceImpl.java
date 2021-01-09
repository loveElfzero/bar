package com.mtp.bar.service.impl;

import com.mtp.bar.entity.Bar;
import com.mtp.bar.mapper.BarMapper;
import com.mtp.bar.service.BarService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author YuanJing
 * @since 2021-01-06
 */
@Service
public class BarServiceImpl extends ServiceImpl<BarMapper, Bar> implements BarService {

}
