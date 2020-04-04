package com.yangli.experiment.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (Students)表实体类
 *
 * @author yangli
 * @since 2020-03-04 02:14:15
 */
@SuppressWarnings("serial")
public class Students extends Model<Students> {
    
    private Integer id;
    //学号
    private Integer sno;
    //学生姓名
    private String sname;
    //所属班级
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