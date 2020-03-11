package com.feding.kesimpl.pms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feding.kesimpl.pms.mapper.CommentMapper;
import com.feding.kesimpl.pms.model.Comment;
import com.feding.kesimpl.pms.service.CommentService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品评价表 服务实现类
 * </p>
 *
 * @author hasz
 * @since 2020-03-11
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
