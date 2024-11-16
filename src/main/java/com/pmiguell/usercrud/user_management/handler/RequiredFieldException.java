package com.pmiguell.usercrud.user_management.handler;

public class RequiredFieldException extends BusinessException {
    public RequiredFieldException(String field) {
        super("The %s field is required!", field);
    }
}
