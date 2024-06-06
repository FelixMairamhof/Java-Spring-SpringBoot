package com.in28minutes.learnspringframework.examples.f1;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class someClass {
    private SomeDependency someDependency;

    public someClass (SomeDependency someDependency) {
        super();
        this.someDependency = someDependency;
        System.out.println("All Dependencies are ready");
    }
    @PostConstruct
    public void initialize () {
        someDependency.getReady();
    }

    @PreDestroy
    public void cleanup(){
        System.out.println("Clean up");
    }
}
@Component
class SomeDependency{

    public void getReady() {
        System.out.println("Do logic");
    }
}
@Configuration
@ComponentScan
public class PrePostAnnotationsContextLauncherApplication {

    public static void main(String[] args) {
        try (var context =
                     new AnnotationConfigApplicationContext
                             (PrePostAnnotationsContextLauncherApplication.class)){

            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);

        }


    }
}
