package mif.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import mif.vu.entities.Author;
import mif.vu.persistance.DAO.AuthorsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class BooksByAuthor {

    @Inject
    private AuthorsDAO authorsDAO;

    @Inject
    private Selectors selectors;

    @Getter
    @Setter
    private Author author;

    @PostConstruct
    public void init(){
        Integer authorId = selectors.getAuthorId();
        if(authorId != null){
            this.author = authorsDAO.findById(authorId);
        }
    }
}
