package com.xiwu;

import com.rabbitmq.client.Channel;
import com.xiwu.server.pojo.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

/**
 * @author ：wangjiahao
 * @date ：Created in
 * @description：
 */
@Component
public class MailReceiver {

    private static final Logger logger = LoggerFactory.getLogger(MailReceiver.class);
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private MailProperties mailProperties;

    @Autowired
    private TemplateEngine templateEngine;


    @RabbitListener(queues = "mail.welcome")
    public void handler(Employee employee){
//
//        MimeMessage msg=javaMailSender.createMimeMessage();
//        MimeMessageHelper helper=new MimeMessageHelper(msg);

        // 创建消息
        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg);

        try {
            helper.setFrom(mailProperties.getUsername()); // 发件人
            helper.setTo(employee.getEmail()); // 收件人
            helper.setSubject("入职欢迎邮件"); // 主题
            helper.setSentDate(new Date()); // 发送日期
            // 邮件内容
            Context context = new Context();
            context.setVariable("name", employee.getName());
            context.setVariable("posName", employee.getPosition().getName());
            context.setVariable("joblevelName", employee.getJoblevel().getName());
            context.setVariable("departmentName", employee.getDepartment().getName());
            String mail = templateEngine.process("mail", context);
            helper.setText(mail, true);
            javaMailSender.send(msg); // 发送邮件
            logger.info("邮件发送成功！");
        } catch (MessagingException e) {
            logger.info("发送失败:----->"+e.getMessage());
        }
    }

}
