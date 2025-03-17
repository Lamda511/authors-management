package com.lamda511.actions;

import com.lamda511.model.Author;
import com.lamda511.service.AuthorsService;
import com.lamda511.util.ActionConstants;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ListAuthors extends ActionSupport implements ModelDriven<Author> {

    @Autowired
    private AuthorsService authorService;

    private String actionName;
    private Author author = new Author();
    private List<Author> authorsList = new ArrayList<Author>();


    public String execute() throws Exception {
        setActionName(getText(ActionConstants.ACTION_NAME_LIST_AUTHORS_KEY));
        authorsList = authorService.getAuthors();
        return SUCCESS;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public List<Author> getAuthorsList(){
        return authorsList;
    }

    public void setAuthorsList(List<Author> authorsList) {
        this.authorsList = authorsList;
    }

    @Override
    public Author getModel() {
        return author;
    }
}
