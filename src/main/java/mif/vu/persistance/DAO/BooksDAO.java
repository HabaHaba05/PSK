package mif.vu.persistance.DAO;

import mif.vu.entities.Book;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class BooksDAO {
    @Inject
    private EntityManager em;

    public List<Book> getAll() {
        return em.createNamedQuery("Book.findAll", Book.class).getResultList();
    }

    public void remove(Book book) {
        em.remove(book);
    }

    public void create(Book book){
        this.em.persist(book);
    }

    public Book findById(Integer id) {
        return em.find(Book.class, id);
    }
}
