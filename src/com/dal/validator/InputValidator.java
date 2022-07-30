package com.dal.validator;

import java.util.regex.Pattern;

public class InputValidator{

    public boolean emailValidator(String email) {
        return Pattern.compile("^\\S+@\\S+\\.\\S+$")
                .matcher(email.trim())
                .matches();
    }

    public boolean nameValidator(String name) {
        return name.trim().length() >= 4;
    }

    public String nameTransformer(String transformName) {
        return transformName.trim().replaceAll("\s+", " ").replaceAll(" ","_");
    }
}
