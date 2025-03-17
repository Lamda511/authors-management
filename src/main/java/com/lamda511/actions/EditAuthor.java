package com.lamda511.actions;

import com.lamda511.util.ActionConstants;

public class EditAuthor extends AuthorAction {

    public EditAuthor() {
        super();
    }

    public String getMode() {
        return ActionConstants.ACTION_FORM_MODE_EDIT;
    }

    public String getActionName() {
        return getText(ActionConstants.ACTION_NAME_EDIT_KEY);
    }

    public String execute() throws Exception {
        super.execute();
        authorService.updateAuthor(author);
        return SUCCESS;
    }
}
