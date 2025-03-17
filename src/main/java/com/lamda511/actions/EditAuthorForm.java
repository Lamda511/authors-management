package com.lamda511.actions;

import com.lamda511.model.Author;
import com.lamda511.service.AuthorsService;
import com.lamda511.util.ActionConstants;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;

public class EditAuthorForm extends AuthorForm implements ModelDriven<Author> {

    @Autowired
    private AuthorsService authorservice;
    private Author author = new Author();
    private File img;

    public EditAuthorForm() {
        super();
    }

    public String getMode() {
        return ActionConstants.ACTION_FORM_MODE_EDIT;
    }

    public File getImg() {
        return img;
    }

    public void setImg(File img) {
        this.img = img;
    }

    @Override
    public Author getModel() {
        return author;
    }

    public void setModel(Author author) {
        this.author = author;
    }

    public String execute() throws Exception {
        setActionName(getText(ActionConstants.ACTION_NAME_EDIT_KEY));
        Author tmp = authorservice.findAuthorById(author.getId());
        author.setName(tmp.getName());
        author.setBiography(tmp.getBiography());
        author.setMiniBio(tmp.getMiniBio());
        author.setLanguage(tmp.getLanguage());
        author.setJoinedOn(tmp.getJoinedOn());
        author.setImgSrc(tmp.getImgSrc());
        img = new File(ServletActionContext.getServletContext().getRealPath("/") + "/images/" + author.getImgSrc());

        return SUCCESS;
    }
}