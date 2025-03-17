package com.lamda511.model;

import java.io.Serializable;
import java.util.Date;

public class Author implements Serializable {

    private Long id;
    private String name;
    private String biography;
    private String miniBio;
    private String imgSrc;
    private String language;
    private Date joinedOn;

    public Author() {
    }

    public Author(String name, String biography, String miniBio, String imgSrc, String language, Date joinedOn) {
        this.name = name;
        this.biography = biography;
        this.miniBio = miniBio;
        this.imgSrc = imgSrc;
        this.language = language;
        this.joinedOn = joinedOn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getMiniBio() {
        return miniBio;
    }

    public void setMiniBio(String miniBio) {
        this.miniBio = miniBio;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Date getJoinedOn() {
        return joinedOn;
    }

    public void setJoinedOn(Date joinedOn) {
        this.joinedOn = joinedOn;
    }
}
