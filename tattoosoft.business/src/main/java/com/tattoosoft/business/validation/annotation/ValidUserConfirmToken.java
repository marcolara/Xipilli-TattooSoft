package com.tattoosoft.business.validation.annotation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.tattoosoft.business.validation.constraint.ValidUserConfirmTokenValidator;

@Documented
@Constraint(validatedBy = ValidUserConfirmTokenValidator.class)
@Target( {
    ElementType.FIELD
})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidUserConfirmToken {
    String message() default "{tattoosoft.business.validation.constraints.ValidUserConfirmToken.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String first();
    String second();
    String third();

    @Target({ TYPE, ANNOTATION_TYPE })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        ValidUserConfirmToken[] value();
    }
}
