package com.yangli.experiment.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangli.experiment.dao.UploadDao;
import com.yangli.experiment.entity.Upload;
import com.yangli.experiment.entity.UploadVo;
import com.yangli.experiment.service.UploadService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * (Upload)表服务实现类
 *
 * @author yangli
 * @since 2020-04-05 21:35:31
 */
@Service("uploadService")
public class UploadServiceImpl extends ServiceImpl<UploadDao, Upload> implements UploadService {

    public IPage<Map<String, Object>> uploadExperiment (Page page, @Param(Constants.WRAPPER) Wrapper queryWrapper){
        return this.baseMapper.uploadExperiment(page,queryWrapper);
    }

    public List<Upload> up (Wrapper<Upload> queryWrapper){
        return this.baseMapper.up(queryWrapper);
    }
}