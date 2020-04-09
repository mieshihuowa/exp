package com.yangli.experiment.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yangli.experiment.entity.User;
import com.yangli.experiment.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (User)表控制层
 *
 * @author yangli
 * @since 2020-04-04 23:48:44
 */
@CrossOrigin
@RestController
@RequestMapping("x/user")
public class UserController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param user 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<User> page, User user) {
        return success(this.userService.page(page, new QueryWrapper<>(user)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.userService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param user 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody User user) {
        return success(this.userService.save(user));
    }

    /**
     * 修改数据
     *
     * @param user 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody User user) {
        return success(this.userService.updateById(user));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.userService.removeByIds(idList));
    }

    @PostMapping("login")
    public R login(@RequestBody User user){
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("sno",user.getSno()).eq("passwd",user.getPasswd());

        User u = this.userService.getOne(qw);
        List<Object> list = new ArrayList<>() ;
        if (u!=null){
            Map map  = new HashMap();
            map.put("name",u.getSname());
            map.put("no",u.getSno().toString());
            map.put("uuid","20160831");
            map.put("role",u.getRole());
            map.put("cno",u.getCno().toString());
            map.put("token","yangli3042");
            list.add(map);
        } else {
            return failed("账号密码错误");
        }

        return success(list);
    }
}