package com.tattoosoft.business.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import com.tattoosoft.business.validation.annotation.EmailRegistered;
import com.tattoosoft.business.validation.annotation.ValidUserConfirmToken;

@Component("confirmAccountForm")
@ValidUserConfirmToken.List({
    @ValidUserConfirmToken(first = "emailAddress", second = "password", third = "token", message = "Invalid Token")
})
public class ConfirmAccountForm {
    @NotNull
    protected String token;

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

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * @return the emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * @param emailAddress the emailAddress to set
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }


}
