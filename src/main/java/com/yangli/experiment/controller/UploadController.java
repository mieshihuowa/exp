package com.yangli.experiment.controller;



import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yangli.experiment.entity.Upload;
import com.yangli.experiment.entity.UploadVo;
import com.yangli.experiment.service.UploadService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * (Upload)表控制层
 *
 * @author yangli
 * @since 2020-04-05 21:35:31
 */
@CrossOrigin
@RestController
@RequestMapping("x/upload")
public class UploadController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private UploadService uploadService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param upload 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Upload> page, Upload upload) {
        return success(this.uploadService.page(page, new QueryWrapper<>(upload)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.uploadService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param upload 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Upload upload) {
        return success(this.uploadService.save(upload));
    }

    /**
     * 修改数据
     *
     * @param upload 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Upload upload) {
        return success(this.uploadService.updateById(upload));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.uploadService.removeByIds(idList));
    }

    @GetMapping("uploadExperiment")
    public R uploadExperiment(Page page,String eno,String ename,String cno,String course,String sno){
        QueryWrapper<UploadVo> u = new QueryWrapper();
        if (eno != null){
            u.eq("eno",Integer.parseInt(eno));
        }
        if (ename!=null){
            u.eq("ename",ename);
        }
        if (cno!=null){
            u.eq("cno",Integer.parseInt(cno));
        }
        if (course!=null){
            u.eq("course",course);
        }
        if (sno!=null){
            u.eq("sno",Integer.parseInt(sno));
        }

        return success(this.uploadService.uploadExperiment(page,u));
    }

//    /**
//     * 分页查询所有数据
//     *
//     * @param upload 查询实体
//     * @return 所有数据
//     */
//    @GetMapping("up")
//    public R up (Upload upload,String eno){
//        QueryWrapper<Upload> u = new QueryWrapper<>(upload);
//        if(eno!=null) {
//            u.eq("eno", Integer.parseInt(eno));
//        }
//        return  success(this.uploadService.up(u));
//    }
}