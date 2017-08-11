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
    @NotNull
    @Size(min = 2, max = 254)
    @Length(max = 254)
    @EmailRegistered
    @Email
    private String emailAddress;

    @NotNull
    @Length(max = 12)
    @Size(min = 7, max = 12)
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
