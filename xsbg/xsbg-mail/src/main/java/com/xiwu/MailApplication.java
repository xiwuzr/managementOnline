package com.xiwu;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @author ：wangjiahao
 * @date ：Created in
 * @description：
 */
@SpringBootApplication/*(exclude = {DataSourceAutoConfiguration.class})*/
public class MailApplication {
    public static void main(String[] args) {
        SpringApplication.run(MailApplication.class, args);
    }


    /**
     * 绑定队列
     * @return
     */
    @Bean
    public Queue queue() {
        return new Queue("mail.welcome",true);
    }

}
