package com.dal.validator;

import com.dal.ClientData;

public interface IValidator {
    boolean validate(ClientData clientData);
//    boolean emailValidator(String email);
//    boolean nameValidator(String name);
//    String nameTransformer(String transformName);
}
