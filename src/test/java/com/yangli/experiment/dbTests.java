package com.yangli.experiment;

import com.yangli.experiment.entity.Students;
import com.yangli.experiment.service.impl.StudentsServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class dbTests {
    @Autowired
    StudentsServiceImpl StudentsServiceImpl2;
    @Test
    void test(){
        List<Students> list = StudentsServiceImpl2.allStudents();
        list.forEach(System.out::println);
        System.out.println("xxxx");
    }
}
