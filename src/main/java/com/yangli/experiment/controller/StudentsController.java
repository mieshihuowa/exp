package com.yangli.experiment.controller;

import com.yangli.experiment.entity.Students;
import com.yangli.experiment.service.StudentsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Students)表控制层
 *
 * @author makejava
 * @since 2020-01-23 23:50:26
 */
@RestController
@RequestMapping("students")
public class StudentsController {
    /**
     * 服务对象
     */
    @Resource
    private StudentsService studentsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Students selectOne(Integer id) {
        return this.studentsService.queryById(id);
    }
    @GetMapping("all")
    public List<Object> queryAll(){
        return this.studentsService.allStudents();
    }

    @PutMapping("addStudent")
    public int insertStudent(Students student){
        return this.studentsService.insertStudents(student);
    }

}