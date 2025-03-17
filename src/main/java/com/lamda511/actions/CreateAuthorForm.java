package com.lamda511.actions;

import com.lamda511.util.ActionConstants;

public class CreateAuthorForm extends AuthorForm {

    public CreateAuthorForm() {
        super();
    }

    public String execute() throws Exception {
        setActionName(getText(ActionConstants.ACTION_NAME_CREATE_KEY));
        return SUCCESS;
    }
}
