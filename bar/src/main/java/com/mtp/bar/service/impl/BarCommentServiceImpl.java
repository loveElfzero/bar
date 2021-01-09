package com.mtp.bar.service.impl;

import com.mtp.bar.entity.BarComment;
import com.mtp.bar.mapper.BarCommentMapper;
import com.mtp.bar.service.BarCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 贴吧评论表 服务实现类
 * </p>
 *
 * @author YuanJing
 * @since 2021-01-06
 */
@Service
public class BarCommentServiceImpl extends ServiceImpl<BarCommentMapper, BarComment> implements BarCommentService {

}
