package com.me.usermanage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(value = "com.me.usermanage.mapper")
//不加会有Mapper注解不能被识别的错

public class MeUserManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(MeUserManageApplication.class, args);
    }

}
