package com.dal.validator;

import com.dal.ClientData;

import java.util.ArrayList;
import java.util.List;

public class InputProcessor {

    List<IValidator> validatorList = null;

    public InputProcessor() {
        validatorList = new ArrayList<>();
        validatorList.add(new EmailValidator());
        validatorList.add(new NameValidator());
    }

    public boolean validateAll(ClientData clientData){
        for(IValidator iValidator : validatorList){
            if(!iValidator.validate(clientData)){
                return false;
            }
        }
        return true;
    }

    public String nameTransformer(String transformName) {
        return transformName.trim().replaceAll("\s+", " ").replaceAll(" ","_");
    }

}
