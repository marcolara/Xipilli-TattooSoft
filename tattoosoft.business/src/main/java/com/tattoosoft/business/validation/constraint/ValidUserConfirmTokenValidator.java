package com.tattoosoft.business.validation.constraint;

import java.lang.reflect.InvocationTargetException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.tattoosoft.business.security.exception.AccountBannedException;
import com.tattoosoft.business.security.exception.AccountInactiveException;
import com.tattoosoft.business.security.exception.AccountUnconfirmedException;
import com.tattoosoft.business.service.RegistrationService;
import com.tattoosoft.business.validation.annotation.ValidUserConfirmToken;
import com.tattoosoft.persistence.model.User;

public class ValidUserConfirmTokenValidator implements ConstraintValidator<ValidUserConfirmToken, Object> {
    private String first;
    private String second;
    private String third;
    private String message;

    @Autowired
    @Qualifier("registrationService")
    private RegistrationService registrationService;

    @Autowired
    @Qualifier("authenticationProvider")
    private AuthenticationProvider authenticationProvider;

    @Override
    public void initialize(final ValidUserConfirmToken constraintAnnotation) {
        first = constraintAnnotation.first();
        second = constraintAnnotation.second();
        third = constraintAnnotation.third();
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context) {
        String token = "";
        String emailAddress = "";
        try {
            emailAddress = BeanUtils.getProperty(value, first);
            final String password = BeanUtils.getProperty(value, second);
            token = BeanUtils.getProperty(value, third);
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(emailAddress, password);
            UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authenticationProvider.authenticate(authToken);
        } catch (BadCredentialsException | AccountBannedException | AccountInactiveException e) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addConstraintViolation();
            return false;
        } catch (AccountUnconfirmedException e) {
            User user = registrationService.getUserByEmailAddress(emailAddress);
            return token.equals(user.getConfirmationToken());
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
            return false;
        }
        return false;
    }
}
