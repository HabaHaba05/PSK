package mif.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import mif.vu.entities.Author;
import mif.vu.persistance.DAO.AuthorsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Authors {
    @Inject
    private AuthorsDAO authorsDAO;

    @Getter
    private List<Author> allAuthors;

    @Getter
    @Setter
    private Author authorToCreate = new Author();

    @PostConstruct
    public void init(){
        loadAllAuthors();
    }

    @Transactional
    public void createAuthor(){
        authorsDAO.create(authorToCreate);
    }

    private void loadAllAuthors(){
        allAuthors= authorsDAO.getAll();
    }
}
