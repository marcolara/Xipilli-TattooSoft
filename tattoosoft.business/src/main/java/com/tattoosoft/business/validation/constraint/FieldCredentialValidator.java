package com.tattoosoft.business.validation.constraint;

import java.lang.reflect.InvocationTargetException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;

import com.tattoosoft.business.validation.annotation.FieldCredentials;

public class FieldCredentialValidator implements
        ConstraintValidator<FieldCredentials, Object> {
    private String first;
    private String second;
    private String message;

    @Autowired
    @Qualifier("authenticationProvider")
    private AuthenticationProvider authenticationProvider;

    @Override
    public void initialize(final FieldCredentials constraintAnnotation) {
        first = constraintAnnotation.first();
        second = constraintAnnotation.second();
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context) {
        try {
            final String emailAddress = BeanUtils.getProperty(value, first);
            final String password = BeanUtils.getProperty(value, second);
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(emailAddress, password);
            UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authenticationProvider.authenticate(token);
        } catch (AuthenticationException e) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addConstraintViolation();
            return false;
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
            return false;
        }
        return true;
    }
}
