package com.yangli.experiment.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangli.experiment.dao.ExperimentDao;
import com.yangli.experiment.entity.Experiment;
import com.yangli.experiment.service.ExperimentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * (Experiment)表服务实现类
 *
 * @author yangli
 * @since 2020-03-31 00:46:29
 */
@Service("experimentService")
public class ExperimentServiceImpl extends ServiceImpl<ExperimentDao, Experiment> implements ExperimentService {
    public IPage<Experiment> noPubExperiment (Page page, @Param("sno") String sno){
        return baseMapper.noPubExperiment(page,sno);
    }

    public IPage<Map<String, Object>> noPubStudents(Page page){
        return baseMapper.noPubStudents(page);
    }
}