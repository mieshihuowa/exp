package com.yangli.experiment.service;

import com.yangli.experiment.entity.Students;
import java.util.List;

/**
 * (Students)表服务接口
 *
 * @author makejava
 * @since 2020-01-23 23:50:22
 */
public interface StudentsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Students queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Students> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param students 实例对象
     * @return 实例对象
     */
    Students insert(Students students);

    /**
     * 修改数据
     *
     * @param students 实例对象
     * @return 实例对象
     */
    Students update(Students students);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    List<Object> allStudents();

    int insertStudents(Students student);
}