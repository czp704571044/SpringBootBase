package com.czp.demo.Init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value=1)  //加上order注解来生成加载顺序
public class MyStartupRunner  implements CommandLineRunner {
    @Override

    public void run(String... args) throws Exception {

        System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作<<<<<<<<<<<<<");

    }
}
