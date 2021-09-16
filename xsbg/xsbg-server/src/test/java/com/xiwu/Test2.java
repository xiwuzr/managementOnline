package com.xiwu;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Annotation;

/**
 * @author ：wangjiahao
 * @date ：Created in
 * @description：
 */
@Api
public class Test2 {
    private int a;
    public int b;

}

class TT extends Test2{
    public static void main(String[] args) {
        Annotation[] annotations = new TT().getClass().getAnnotations();
        System.out.println(annotations.length);
        for(Annotation a:annotations){
            System.out.println(a);
        }

    }

}
