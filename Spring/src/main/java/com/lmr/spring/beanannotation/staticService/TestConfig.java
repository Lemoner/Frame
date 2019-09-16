package com.lmr.spring.beanannotation.staticService;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author lemonlimengran@didichuxing.com
 * @date 2019-09-12
 * @description
 */
@Configuration
@ComponentScan
public class TestConfig {

    @Bean(name = "block")
//    @Bean(autowire = Autowire.BY_TYPE)
    public Block getBlock(){
        System.out.println("_()_");
        return new Block();
    }

}
