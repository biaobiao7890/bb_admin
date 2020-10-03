package com.ma.bb.service.edu.service.impl;

import com.ma.bb.service.edu.entity.Comment;
import com.ma.bb.service.edu.mapper.CommentMapper;
import com.ma.bb.service.edu.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论 服务实现类
 * </p>
 *
 * @author Biaob
 * @since 2020-09-28
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
