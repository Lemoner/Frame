package com.lmr.spring.beanannotation.staticService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author lemonlimengran@didichuxing.com
 * @date 2019-09-11
 * @description
 */
@Component
public class TestUtils {

    @Autowired
    private Block block;

    private static DocService docService;

//    @Autowired
//    private DocService autoDocService;
//
//    @PostConstruct
//    private void beforeInit() {
//        docService = autoDocService;
//    }

//    @Autowired
//    public TestUtils(DocService docService){
//        TestUtils.docService=docService;
//    }

    @Autowired
    public void setDocService(DocService docService){
        TestUtils.docService=docService;
    }

    public static void CallUtil() {
        docService.callMethod();
    }

    public void CallBlock(){
        if(block==null){
            System.out.println("+_+");
        }
        block.callMethod();
    }

}
