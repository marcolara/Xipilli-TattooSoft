package com.tattoosoft.business.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;

import com.tattoosoft.business.validation.constraint.EmailNotRegisteredValidator;

@Documented
@Constraint(validatedBy = EmailNotRegisteredValidator.class)
@Target( {
    ElementType.FIELD
})
@Retention(RetentionPolicy.RUNTIME)
@ReportAsSingleViolation
public @interface EmailNotRegistered {
    public abstract String message() default "email_not_registered";
    public abstract Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default { };
}
