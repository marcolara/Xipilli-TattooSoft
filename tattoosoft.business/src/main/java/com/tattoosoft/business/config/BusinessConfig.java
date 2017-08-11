package com.tattoosoft.business.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;

import com.tattoosoft.business.util.ApplicationContextProvider;

@Configuration
@ComponentScan({ "com.tattoosoft.business","com.tattoosoft.persistence.config" })
@PropertySource({ "classpath:/business.properties" })
public class BusinessConfig {
    @Autowired
    private Environment env;

    @Bean
    public ApplicationContextProvider applicationContextProvider() {
        return new ApplicationContextProvider();
    }

    @Bean
    public JavaMailSenderImpl mailSender(){
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost(env.getProperty("mail.host"));
        sender.setPort(Integer.parseInt(env.getProperty("mail.port")));
        sender.setUsername(env.getProperty("mail.username"));
        sender.setPassword(env.getProperty("mail.password"));
        sender.setJavaMailProperties(new Properties() {{
                setProperty("mail.transport.protocol", env.getProperty("mail.transport.protocol"));
                setProperty("mail.debug", env.getProperty("mail.debug"));
                setProperty("mail.smtp.starttls.enable", env.getProperty("mail.smtp.starttls.enable"));
            }
        });
        return sender;
    }

    @Bean
    public VelocityEngineFactoryBean velocityEngine(){
        VelocityEngineFactoryBean velocity = new VelocityEngineFactoryBean();
        velocity.setVelocityProperties(new Properties() {{
                setProperty("resource.loader", env.getProperty("resource.loader"));
                setProperty("class.resource.loader.class", env.getProperty("class.resource.loader.class"));
            }
        });
        return velocity;
    }

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder(10);
    }
}
