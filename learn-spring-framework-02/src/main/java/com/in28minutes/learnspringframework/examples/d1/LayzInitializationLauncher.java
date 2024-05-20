package com.in28minutes.learnspringframework.examples.d1;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class ClassA {

}
@Component
@Lazy
class ClassB {
    private ClassA classA;

    public ClassB (ClassA classA) {
        System.out.println("Some Initialization");
        this.classA = classA;
    }
    public void doSometging(){
        System.out.println("Do Something");
    }
}

@Configuration
@ComponentScan
public class LayzInitializationLauncher {

    public static void main(String[] args) {
        try (var context =
                     new AnnotationConfigApplicationContext
                             (LayzInitializationLauncher.class)){

            System.out.println("Initializing Context Completed");

            context.getBean( ClassB.class).doSometging();
        }


    }
}
