package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.GamingConsole;
import com.in28minutes.learnspringframework.game.PacManGame;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.GamingConsole;
import com.in28minutes.learnspringframework.game.PacManGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("com.in28minutes.learnspringframework.game")
public class App3GamingSpringBeans {

    public static void main(String[] args) {
        try (var context =
                     new AnnotationConfigApplicationContext
                             (App3GamingSpringBeans.class)){

            context.getBean(GamingConsole.class).up();

            context.getBean(GameRunner.class).run();

        }


    }
}
