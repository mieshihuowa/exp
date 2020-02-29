package com.yangli.experiment.service.impl;

import com.yangli.experiment.entity.Students;
import com.yangli.experiment.dao.StudentsDao;
import com.yangli.experiment.service.StudentsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Students)表服务实现类
 *
 * @author makejava
 * @since 2020-01-23 23:50:24
 */
@Service("studentsService")
public class StudentsServiceImpl implements StudentsService {
    @Resource
    private StudentsDao studentsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Students queryById(Integer id) {
        return this.studentsDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Students> queryAllByLimit(int offset, int limit) {
        return this.studentsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param students 实例对象
     * @return 实例对象
     */
    @Override
    public Students insert(Students students) {
        this.studentsDao.insert(students);
        return students;
    }

    /**
     * 修改数据
     *
     * @param students 实例对象
     * @return 实例对象
     */
    @Override
    public Students update(Students students) {
        this.studentsDao.update(students);
        return this.queryById(students.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.studentsDao.deleteById(id) > 0;
    }

    public List<Object> allStudents(){
        return this.studentsDao.queryAll();
    }

    public int insertStudents(Students student){
        return this.studentsDao.insert(student);
    }
}