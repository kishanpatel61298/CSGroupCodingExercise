package com.dal.validator;

import com.dal.ClientData;

public class NameValidator implements IValidator {

    @Override
    public boolean validate(ClientData clientData) {
        return clientData.getName().trim().length() >= 4;
    }
}
