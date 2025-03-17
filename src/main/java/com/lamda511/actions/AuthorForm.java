package com.lamda511.actions;

import com.lamda511.util.Constants;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AuthorForm extends ActionSupport {

    protected List<String> languages;
    protected String actionName;

    public AuthorForm() {
        languages = Collections.unmodifiableList(Arrays.asList(
                getText(Constants.LANGUAGE_EN_KEY),
                getText(Constants.LANGUAGE_CH_KEY),
                getText(Constants.LANGUAGE_JA_KEY),
                getText(Constants.LANGUAGE_PT_KEY),
                getText(Constants.LANGUAGE_FR_KEY)
        ));
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

}
