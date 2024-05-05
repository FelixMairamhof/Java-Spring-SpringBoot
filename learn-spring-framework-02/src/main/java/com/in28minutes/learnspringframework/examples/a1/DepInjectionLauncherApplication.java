package com.in28minutes.learnspringframework.examples.a1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class YourBuisnessClass{
    //@autowired = Field injection
    Dependency1 dependency1;
    //@autowired = Field injection
    Dependency2 dependency2;

    @Autowired //Constructor Injection but works without Autowired
    public YourBuisnessClass(Dependency1 dependency1, Dependency2 dependency2) {
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

    //@Autowired = SetterInjection
    public void setDependency1(Dependency1 dependency1) {
        this.dependency1 = dependency1;
    }
    //@Autowired = SetterInjection
    public void setDependency2(Dependency2 dependency2) {
        this.dependency2 = dependency2;
    }

    @Override
    public String toString() {
        return "dependency1=" + dependency1 + ", dependency2=" + dependency2;
    }
}
@Component
class Dependency1{

}
@Component
class Dependency2{

}



@Configuration
@ComponentScan
public class DepInjectionLauncherApplication {

    public static void main(String[] args) {
        try (var context =
                     new AnnotationConfigApplicationContext
                             (DepInjectionLauncherApplication.class)){

            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);
            System.out.println(context.getBean(YourBuisnessClass.class));
        }
    }
}
