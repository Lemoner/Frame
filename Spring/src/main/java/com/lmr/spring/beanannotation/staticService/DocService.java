package com.lmr.spring.beanannotation.staticService;

import org.springframework.stereotype.Service;

/**
 * @author lemonlimengran@didichuxing.com
 * @date 2019-09-11
 * @description
 */
@Service
public class DocService {

    public void callMethod(){
        System.out.println("DocService is call ...");
    }

}
