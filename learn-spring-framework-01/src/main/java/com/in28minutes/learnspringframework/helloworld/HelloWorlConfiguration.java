package com.in28minutes.learnspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

//Eliminate verbosity of jave
//Public accessor mehtods, constructer, equals, hashcode and toString
//are automaticly created new in JDK 16
record Person (String name, int age, Address address){};
record Address (String firstLine, String city){};

@Configuration
public class HelloWorlConfiguration {

    @Bean
    public String name (){
        return "Ponse";
    }
    @Bean
    public  int age (){
        return 22;
    }
    @Bean
    public Person person(){
        var person = new Person("John", 22, new Address("Mainstreet","Utretch"));
        return person;
    }

    @Bean
    public Person person2MethodCall(){
        return new Person(name(),age(),address()); //name,age
    }
    @Bean
    public Person person3Parameters(String name, int age, Address address3){//name,age,address2
        return new Person(name,age,address3); //name,age
    }
    @Bean(name = "address2")
    @Primary
    public Address address(){
        var address = new Address("Some Street", "Some City");
        return address;
    }
    @Bean(name = "address3")
    @Qualifier("address3qualifier")
    public Address address3(){
        var address = new Address("montigar", "Hyderbad");
        return address;
    }
    @Bean
    //Found 2 adresses multiple matching beans/candidates
    @Primary
    public Person person4Parameters(String name, int age, Address address){//name,age,address2
        return new Person(name,age,address); //name,age
    }
    @Bean
    public Person person5Qualifier(String name, int age,@Qualifier("address3qualifier") Address address){//name,age,address2
        return new Person(name,age,address); //name,age
    }

}
