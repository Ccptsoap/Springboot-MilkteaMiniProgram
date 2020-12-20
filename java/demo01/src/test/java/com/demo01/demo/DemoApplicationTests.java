package com.demo01.demo;

import com.demo01.demo.controller.MilkteaController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    MilkteaController milkteaController;
    @Test
    void contextLoads() {

        System.out.print(milkteaController.countMilktea());
    }

}
