package com.lmr.spring.beanannotation.staticService;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author lemonlimengran@didichuxing.com
 * @date 2019-09-12
 * @description
 */
@Component
public class Block {

    public Block(){
        System.out.println("………………");
    }

    public void callMethod(){
        System.out.println("Block is call ...");
    }

}
