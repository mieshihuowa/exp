package com.yangli.experiment.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yangli.experiment.entity.Experiment;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * (Experiment)表服务接口
 *
 * @author yangli
 * @since 2020-03-31 00:46:29
 */
public interface ExperimentService extends IService<Experiment> {

    IPage<Experiment> noPubExperiment (Page page, @Param("sno") String sno);
    IPage<Map<String, Object>> noPubStudents(Page page);
}