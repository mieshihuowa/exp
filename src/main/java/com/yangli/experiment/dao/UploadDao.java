package com.yangli.experiment.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yangli.experiment.entity.Upload;
import com.yangli.experiment.entity.UploadVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * (Upload)表数据库访问层
 *
 * @author yangli
 * @since 2020-04-05 21:35:31
 */
public interface UploadDao extends BaseMapper<Upload> {
    /**
     * 根据 entity 条件，查询全部记录（并翻页）
     *
     * @param queryWrapper 实体对象封装操作类（可以为 null）
     */
    @Select("select id,eno,sno,dir from upload ${ew.customSqlSegment}")
    List<Upload> up (@Param(Constants.WRAPPER) Wrapper queryWrapper);

    @Select("select * from (select up.eno as eno,exp.ename,exp.cno,exp.name,exp.course,up.sno,up.sname,up.dir from upload up left join experiment exp on up.eno = exp.eno ) as A  ${ew.customSqlSegment}")
    IPage<Map<String, Object>> uploadExperiment (Page page, @Param(Constants.WRAPPER) Wrapper<UploadVo> queryWrapper);



}