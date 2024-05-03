package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App2HelloWorldSpring {
    public static void main(String[] args) {
        //1: Launch a Spring Context

        var context =
                new AnnotationConfigApplicationContext(HelloWorlConfiguration.class);

        //2: Configure the things that we want Spring to manage - @Configuration
        //name - @Bean

        //3: Retrieving Beans managed by Spring
        var name = context.getBean("name");
        System.out.println(name);

        var age = context.getBean("age");
        System.out.println(age);

        var person = context.getBean("person");
        System.out.println(person);

        var address = context.getBean("address");
        System.out.println(address);



    }
}
