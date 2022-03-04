package mif.vu.persistance.DAO;

import mif.vu.entities.Author;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class AuthorsDAO {
    @Inject
    private EntityManager em;

    public List<Author> getAll() {
        return em.createNamedQuery("Author.findAll", Author.class).getResultList();
    }

    public void create(Author author){
        this.em.persist(author);
    }

    public Author findById(Integer id) {
        return em.find(Author.class, id);
    }
}
