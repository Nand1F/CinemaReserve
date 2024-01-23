package com.ferdynan.cinemareserve.persistence.entity.impl;

import com.ferdynan.cinemareserve.persistence.entity.Entity;
import com.ferdynan.cinemareserve.persistence.entity.ErrorTemplate;
import com.ferdynan.cinemareserve.persistence.exception.EntityArgumentException;

import java.time.LocalDate;
import java.util.UUID;
import java.util.regex.Pattern;

public class User extends Entity {
    private String nameUser ;
    private final String password;

    private final LocalDate birthday;
    private final String email;

    public User(String nameUser, String password, LocalDate birthday, String email, UUID id)
    {   super(id);
        setNameUser(nameUser);
        this.password = password;
        this.birthday = birthday;
        this.email = email;
    }

    public String getNameUser() {
        return nameUser;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setNameUser(String nameUser) {
        final String templateName = "логіну";

        if (nameUser.isBlank())
            errors.add(ErrorTemplate.REQUIRED.getTemplate().formatted(templateName));
        this.nameUser = nameUser;
        if (nameUser.length()< 4)
            errors.add(ErrorTemplate.MIN_LENGTH.getTemplate().formatted(templateName, 4));
        if (nameUser.length()>24)
            errors.add(ErrorTemplate.MAX_LENGTH.getTemplate().formatted(templateName, 24));
        var pattern = Pattern.compile("^[a-zA-Z0-9_]+$");

        if (!pattern.matcher(nameUser).matches())
            errors.add(ErrorTemplate.ONLY_LATIN.getTemplate().formatted(templateName));

        if (!errors.isEmpty())
            throw new EntityArgumentException(errors);

        this.nameUser = nameUser;

    }



    @Override
    public String toString() {
        return
                "nameUser='" + nameUser + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", id=" + id ;
    }
}
