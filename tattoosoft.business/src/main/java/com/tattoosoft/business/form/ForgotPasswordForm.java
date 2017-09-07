package com.tattoosoft.business.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import com.tattoosoft.business.validation.annotation.EmailRegistered;

@Component("forgotPasswordForm")
public class ForgotPasswordForm {
    @NotNull(message = "required")
    @Size(min = 6, max = 254, message = "constraints_size")
    @Length(max = 254, message = "minlength") 
    @EmailRegistered
    @Email(message = "email")
    protected String emailAddress;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
