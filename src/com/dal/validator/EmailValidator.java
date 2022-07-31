package com.dal.validator;

import com.dal.ClientData;

import java.util.regex.Pattern;

public class EmailValidator implements IValidator{

    @Override
    public boolean validate(ClientData clientData) {
        return Pattern.compile("^\\S+@\\S+\\.\\S+$")
                .matcher(clientData.getEmail().trim())
                .matches();
    }
}
