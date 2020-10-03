package com.ma.bb.service.edu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ma.bb.service.edu.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ma.bb.service.edu.entity.vo.TeacherQueryVo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author Biaob
 * @since 2020-09-28
 */
public interface TeacherService extends IService<Teacher> {

    IPage<Teacher> selectPage(Page<Teacher> pageParam, TeacherQueryVo teacherQueryVo);

    List<Map<String, Object>> selectNameList(String key);

    boolean removeAvatarById(String id);
}
