package com.yangli.experiment.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yangli.experiment.entity.Upload;
import com.yangli.experiment.entity.UploadVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * (Upload)表服务接口
 *
 * @author yangli
 * @since 2020-04-05 21:35:31
 */
public interface UploadService extends IService<Upload> {

    IPage<Map<String, Object>> uploadExperiment (Page page, @Param(Constants.WRAPPER) Wrapper<UploadVo> queryWrapper);
    /**
     * 翻页查询
     *
     * @param queryWrapper 实体对象封装操作类 {@link com.baomidou.mybatisplus.core.conditions.query.QueryWrapper}
     */
    List<Upload> up (Wrapper<Upload> queryWrapper);
}