package com.yangli.experiment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangli.experiment.dao.StudentsDao;
import com.yangli.experiment.entity.Students;
import com.yangli.experiment.service.StudentsService;
import org.springframework.stereotype.Service;

/**
 * (Students)表服务实现类
 *
 * @author yangli
 * @since 2020-03-04 02:13:24
 */
@Service("studentsService")
public class StudentsServiceImpl extends ServiceImpl<StudentsDao, Students> implements StudentsService {

}