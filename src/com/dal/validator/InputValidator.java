package com.dal.validator;

import java.util.regex.Pattern;

public abstract class InputValidator{

    public static boolean emailValidator(String email) {
        return Pattern.compile("^\\S+@\\S+\\.\\S+$")
                .matcher(email.trim())
                .matches();
    }

    public static boolean nameValidator(String name) {
        return name.trim().length() >= 4;
    }

    public static String nameTransformer(String transformName) {
        return transformName.trim().replaceAll("\s+", " ").replaceAll(" ","_");
    }
}
