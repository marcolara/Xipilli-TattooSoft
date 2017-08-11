package com.tattoosoft.business.service;

import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.tools.ToolContext;
import org.apache.velocity.tools.ToolManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tattoosoft.persistence.model.User;

@Service("emailService")
@Transactional
public class EmailService {
    @Autowired
    private JavaMailSenderImpl mailSender;
    @Autowired
    private VelocityEngine velocityEngine;

    public void sendRegistrationEmail(final User user) {
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                message.setTo(user.getEmailAddress());
                message.setFrom("donotreply@tattoosoft.com");
                message.setSubject("Welcome to TattooSoft");
                Map<String, User> model = new HashMap<String, User>();
                model.put("user", user);

                // velocity engine
                ToolManager toolManager = new ToolManager();
                ToolContext toolContext = toolManager.createContext();
                VelocityContext velocityContext = new VelocityContext(model, toolContext);
                StringWriter resultWriter = new StringWriter();
                velocityEngine.mergeTemplate("email-template/account-registration.vm", "UTF-8", velocityContext, resultWriter);
                message.setText(resultWriter.toString(), true);
            }
        };
        this.mailSender.send(preparator);
    }

    public void sendConfirmationEmail(final User user) {
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                message.setTo(user.getEmailAddress());
                message.setFrom("donotreply@tattoosoft.com");
                message.setSubject("Please confirm your email");
                Map<String, User> model = new HashMap<String, User>();
                model.put("user", user);

                // velocity engine
                ToolManager toolManager = new ToolManager();
                ToolContext toolContext = toolManager.createContext();
                VelocityContext velocityContext = new VelocityContext(model, toolContext);
                StringWriter resultWriter = new StringWriter();
                velocityEngine.mergeTemplate("email-template/account-confirmation.vm", "UTF-8", velocityContext, resultWriter);
                message.setText(resultWriter.toString(), true);
            }
        };
        this.mailSender.send(preparator);
    }

    public void sendPasswordRecoveryEmail(final String tmpPassword, final User user) {
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                message.setTo(user.getEmailAddress());
                message.setFrom("donotreply@tattoosoft.com");
                message.setSubject("Here is your login information");
                Map<String, Object> model = new HashMap<String, Object>();
                model.put("user", user);
                model.put("temp_pasword", tmpPassword);
                model.put("expiration_date", new SimpleDateFormat("MM/dd/yyyy hh:mm aaa").format(user.getTempPswExp()));

                // velocity engine
                ToolManager toolManager = new ToolManager();
                ToolContext toolContext = toolManager.createContext();
                VelocityContext velocityContext = new VelocityContext(model, toolContext);
                StringWriter resultWriter = new StringWriter();
                velocityEngine.mergeTemplate("email-template/account-password-reset.vm", "UTF-8", velocityContext, resultWriter);
                message.setText(resultWriter.toString(), true);
            }
        };
        this.mailSender.send(preparator);
    }
}
