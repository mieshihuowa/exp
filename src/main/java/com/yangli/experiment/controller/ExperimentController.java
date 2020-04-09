package com.yangli.experiment.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yangli.experiment.entity.Experiment;
import com.yangli.experiment.service.ExperimentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * (Experiment)表控制层
 *
 * @author yangli
 * @since 2020-03-31 00:46:29
 */
@CrossOrigin
@RestController
@RequestMapping("x/experiment")
public class ExperimentController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private ExperimentService experimentService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param experiment 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Experiment> page, Experiment experiment) {
        return success(this.experimentService.page(page, new QueryWrapper<>(experiment)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.experimentService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param experiment 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Experiment experiment) {
        return success(this.experimentService.save(experiment));
    }

    /**
     * 修改数据
     *
     * @param experiment 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Experiment experiment) {
        return success(this.experimentService.updateById(experiment));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.experimentService.removeByIds(idList));
    }

    @GetMapping("noPubExperiment")
    public  R noPubExperiment(Page<Experiment> page,String sno){
        return success(this.experimentService.noPubExperiment(page,sno));
    }

    @GetMapping("noPubStudents")
    public R noPubStudents(Page<Map<String, Object>> page){
        return success(this.experimentService.noPubStudents(page));
    }
}