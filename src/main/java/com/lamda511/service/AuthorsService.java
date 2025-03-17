package com.lamda511.service;

import com.lamda511.dao.AuthorDao;
import com.lamda511.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorsService {

    @Autowired
    private AuthorDao authorDao;

    @Transactional
    public void addAuthor(Author author) {
        authorDao.addAuthor(author);
    }

    @Transactional
    public void updateAuthor(Author author) {
        authorDao.updateAuthor(author);
    }

    @Transactional
    public Author findAuthorById(Long id) {
        return authorDao.findAuthorById(id);
    }

    @Transactional
    public Long checkAuthorNameExists(String authorName) {
        return authorDao.getIdIdForName(authorName);
    }

    @Transactional
    public List<Author> getAuthors() {
        return authorDao.getAuthors();
    }

}
