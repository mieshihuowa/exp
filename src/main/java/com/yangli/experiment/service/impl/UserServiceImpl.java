package com.yangli.experiment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangli.experiment.dao.UserDao;
import com.yangli.experiment.entity.User;
import com.yangli.experiment.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * (User)表服务实现类
 *
 * @author yangli
 * @since 2020-04-04 23:48:44
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

}