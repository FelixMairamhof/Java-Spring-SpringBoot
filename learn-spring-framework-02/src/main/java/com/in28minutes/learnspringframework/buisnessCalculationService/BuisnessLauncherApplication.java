package com.in28minutes.learnspringframework.buisnessCalculationService;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan
public class BuisnessLauncherApplication {
    public static void main(String[] args) {
        try( var context =
                     new AnnotationConfigApplicationContext
                             (BuisnessLauncherApplication.class)){

            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);
            int max = context.getBean(BuisnessCalculationService.class).findMax();
            System.out.println(max);
        }
    }
}
