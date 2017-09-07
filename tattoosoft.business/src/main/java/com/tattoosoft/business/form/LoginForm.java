package com.tattoosoft.business.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import com.tattoosoft.business.validation.annotation.EmailRegistered;
import com.tattoosoft.business.validation.annotation.FieldCredentials;

@Component("loginForm")
@FieldCredentials.List({
    @FieldCredentials(first = "emailAddress", second = "password", message = "Invalid credentials")
})
public class LoginForm {
    @NotNull(message = "required")
    @Size(min = 6, max = 254, message = "constraints_size")
    @Length(max = 254, message = "minlength")
    @EmailRegistered
    @Email(message = "email")
    private String emailAddress;

    @NotNull(message = "required")
    @Length(max = 12, message = "minlength")
    @Size(min = 7, max = 12, message = "constraints_size")
    private String	password;

    private boolean rememberMe;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress.toUpperCase();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }
}
