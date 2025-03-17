package com.lamda511.actions;

import com.lamda511.util.ActionConstants;
import org.springframework.util.StringUtils;

public class CreateAuthor extends AuthorAction {

    public CreateAuthor() {
        super();
    }

    public String getActionName() {
        return getText(ActionConstants.ACTION_NAME_CREATE_KEY);
    }

    public String execute() throws Exception {
        super.execute();
        if (StringUtils.isEmpty(author.getImgSrc())) {
            author.setImgSrc(ActionConstants.NO_IMAGE_FILE_NAME);
        }

        authorService.addAuthor(author);
        return SUCCESS;
    }

}
