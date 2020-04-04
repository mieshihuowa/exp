package com.yangli.experiment.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (Experiment)表实体类
 *
 * @author yangli
 * @since 2020-03-31 00:46:29
 */
@SuppressWarnings("serial")
public class Experiment extends Model<Experiment> {
    
    private Integer id;
    
    private Integer eno;
    
    private String ename;
    
    private String name;
    
    private String note;
    
    private Integer cno;
    
    private String dir;
    
    private String course;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEno() {
        return eno;
    }

    public void setEno(Integer eno) {
        this.eno = eno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getCno() {
        return cno;
    }

    public void setCno(Integer cno) {
        this.cno = cno;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
    }