package com.yangli.experiment.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yangli.experiment.entity.Experiment;
import com.yangli.experiment.entity.UploadVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * (Experiment)表数据库访问层
 *
 * @author yangli
 * @since 2020-03-31 00:46:29
 */
public interface ExperimentDao extends BaseMapper<Experiment> {

    @Select("select * from experiment where eno not in (select eno from upload where sno = #{sno})")
    IPage<Experiment> noPubExperiment (Page page, @Param("sno") String sno);

    @Select("select A.eno,A.ename,A.sno,A.sname from (select experiment.eno,experiment.ename,user.sno,user.sname from experiment left join user on user.cno = experiment.cno WHERE sno is NOT null)  AS A left join\n" +
            "upload on upload.sno = A.sno AND upload.eno = A.eno  WHERE upload.dir is null ORDER BY A.eno")
    IPage<Map<String, Object>> noPubStudents(Page page);

}