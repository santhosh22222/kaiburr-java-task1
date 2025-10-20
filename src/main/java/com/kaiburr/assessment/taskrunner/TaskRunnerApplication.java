package com.kaiburr.assessment.taskrunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskRunnerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskRunnerApplication.class, args);
        System.out.println("Kaiburr Task Runner API started successfully!");
    }
}
