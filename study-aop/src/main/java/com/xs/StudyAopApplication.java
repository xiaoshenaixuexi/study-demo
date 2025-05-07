package com.xs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * ClassName: StudyAopApplication
 * Package: com.xs
 * Description:
 *
 * @Author 高伟
 * @Create 2025/5/7 11:24
 * @Version 1.0
 */


@SpringBootApplication
@EnableScheduling
public class StudyAopApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyAopApplication.class, args);
    }

}
