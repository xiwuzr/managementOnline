package com.xiwu;

import com.xiwu.server.mapper.AdminMapper;
import com.xiwu.server.pojo.Admin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ：wangjiahao
 * @date ：Created in 2021/4/11 2:13
 * @description：
 */


public class test1 {

    @Autowired
    public AdminMapper am;
    @Test
    void test01(){
        Admin aa=new Admin();
        aa.setId(678);
        System.out.println(aa);
    }

    @Test
    void test2(){
        System.out.println(am);
    }
}
