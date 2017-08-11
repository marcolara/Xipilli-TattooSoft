package com.tattoosoft.business.form;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.stereotype.Component;

import com.tattoosoft.business.form.field.ProfileFormField;
import com.tattoosoft.business.validation.annotation.FieldMatch;
import com.tattoosoft.business.validation.annotation.EmailNotRegistered;

@Component("shopAccountForm")
@FieldMatch.List({
    @FieldMatch(first = "accountPassword", second = "confirmPassword", message = "fieldMatch")
})
public class ShopAccountForm {
    @NotNull
    @Size(min = 2, max = 254, message="size")
    @Email
    @Pattern(regexp=".+@.+\\..+", message="email")
    @EmailNotRegistered(message = "notEmailRegistered")
    protected String emailAddress;

    @NotNull
    @Size(min = 7, max = 12, message="size")
    protected String accountPassword;

    @NotNull
    @Size(min = 7, max = 12, message="size")
    protected String confirmPassword;

    protected List<ProfileFormField> profileFields = new ArrayList<ProfileFormField>();

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress.toUpperCase();
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public List<ProfileFormField> getProfileFields() {
        return profileFields;
    }

    public void setProfileFields(List<ProfileFormField> profileFields) {
        this.profileFields = profileFields;
    }
}
