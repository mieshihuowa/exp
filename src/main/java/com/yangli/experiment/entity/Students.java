package com.yangli.experiment.entity;

import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;

/**
 * (Students)实体类
 *
 * @author makejava
 * @since 2020-01-23 23:50:13
 */

public class Students implements Serializable {
    private static final long serialVersionUID = 623216015921023590L;
    
    private Integer id;
    /**
    * 学号
    */
    private Integer sno;
    /**
    * 学生姓名
    */
    private String sname;
    /**
    * 所属班级
    */
    private Integer cno;
    
    private String passwd;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSno() {
        return sno;
    }

    public void setSno(Integer sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getCno() {
        return cno;
    }

    public void setCno(Integer cno) {
        this.cno = cno;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", sno=" + sno +
                ", sname='" + sname + '\'' +
                ", cno=" + cno +
                ", passwd='" + passwd + '\'' +
                '}';
    }
}