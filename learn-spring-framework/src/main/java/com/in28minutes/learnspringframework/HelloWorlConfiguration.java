package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Eliminate verbosity of jave
//Public accessor mehtods, constructer, equals, hashcode and toString
//are automaticly created new in JDK 16
record Person (String name, int age){};
record Address (String firstLine, String city){};

@Configuration
public class HelloWorlConfiguration {
    @Bean
    public String name (){
        return "Hello World";
    }
    @Bean
    public  int age (){
        return 22;
    }
    @Bean
    public Person person(){
        var person = new Person("John", 22);
        return person;
    }
    @Bean
    public Address address(){
        var address = new Address("Some Street", "Some City");
        return address;
    }
}
