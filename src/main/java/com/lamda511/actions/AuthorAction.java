package com.lamda511.actions;

import com.lamda511.model.Author;
import com.lamda511.service.AuthorsService;
import com.lamda511.util.ActionConstants;
import com.lamda511.util.FileUtil;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;

public class AuthorAction extends AuthorForm implements ModelDriven<Author> {

    @Autowired
    protected AuthorsService authorService;

    @Autowired
    protected FileUtil fileUtil;

    protected Author author = new Author();
    protected String originalName;
    protected String filename;
    protected File img;

    public AuthorAction() {
        super();
    }

    public void setImg(File file) {
        this.img = file;
    }

    public void setImgFileName(String filename) {
        this.filename = filename;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    @Override
    public Author getModel() {
        return author;
    }

    public void setModel(Author author) {
        this.author = author;
    }

    public String execute() throws Exception {
        if (img != null) {
            String uniqueFileName = fileUtil.generateUniqueName(filename);
            fileUtil.copyFileToServer(img, ServletActionContext.getServletContext().getRealPath("/"), uniqueFileName);
            author.setImgSrc(uniqueFileName);
        }

        return SUCCESS;
    }

    @Override
    public void validate(){
        Long authorId = author.getId();
        Long idOfName = authorService.checkAuthorNameExists(author.getName());

        if ((idOfName != null) && ((authorId == null) || (authorId != idOfName))){
            addFieldError("name", String.format(getText(ActionConstants.AUTHOR_ALREADY_EXISTS_KEY), author.getName()));
        }

        if (img != null && img.exists()) {
            double megaBytes = (img.length() / (1024.0 * 1024.0));
            if (megaBytes >= 2d) {
                addFieldError("img", String.format(getText(ActionConstants.SIZE_TOO_LARGE_KEY), "Image File", "2 MB"));
            }
        }
    }
}
