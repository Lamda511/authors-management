package com.lamda511.dao;

import com.lamda511.model.Author;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorDao {

    private static final String UPDATE_QUERY = "UPDATE Author set name = :name, " +
            "biography = :biography, "  +
            "miniBio = :miniBio, " +
            "imgSrc = :imgSrc, " +
            "language = :language, " +
            "joinedOn = :joinedOn " +
            "WHERE id = :employee_id";

    private static final String GET_AUTHORS_QUERY = "from Author";

    private static final String CHECK_AUTHOR_EXISTS_QUERY = "from Author where name = :name";

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addAuthor(Author author) {
        Session session = sessionFactory.getCurrentSession();
        session.save(author);
    }

    public void updateAuthor(Author author) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(UPDATE_QUERY);
        query.setParameter("name", author.getName());
        query.setParameter("biography", author.getBiography());
        query.setParameter("miniBio", author.getMiniBio());
        query.setParameter("imgSrc", author.getImgSrc());
        query.setParameter("language", author.getLanguage());
        query.setParameter("joinedOn", author.getJoinedOn());
        query.setParameter("employee_id", author.getId());
        query.executeUpdate();
    }

    public List<Author> getAuthors() {
        Session session = sessionFactory.getCurrentSession();
        List<Author> authors = session.createQuery(GET_AUTHORS_QUERY).list();
        return authors;
    }

    public Author findAuthorById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Author author = (Author) session.get(Author.class, id);
        return author;
    }

    public Long getIdIdForName(String authorName) {
        Session session = sessionFactory.getCurrentSession();
        Author author = (Author)session
                .createQuery(CHECK_AUTHOR_EXISTS_QUERY)
                .setParameter("name", authorName)
                .uniqueResult();

        if (author != null) {
            return author.getId();
        }
        return null;
    }

}
