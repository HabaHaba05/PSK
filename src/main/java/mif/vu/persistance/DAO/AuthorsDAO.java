package mif.vu.persistance.DAO;

import mif.vu.dtos.UpdateAuthorDto;
import mif.vu.entities.Author;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
public class AuthorsDAO {
    @Inject
    private EntityManager em;

    public List<Author> getAll() {
        return em.createNamedQuery("Author.findAll", Author.class).getResultList();
    }

    public void create(Author author) {
        this.em.persist(author);
    }

    public Author findById(Integer id) {
        return em.find(Author.class, id);
    }

    public void remove(Integer id) {
        Author author = findById(id);
        em.remove(author);
    }

    @Transactional(value = Transactional.TxType.REQUIRES_NEW)
    public void update(UpdateAuthorDto dto) throws InterruptedException {
        Author author = em.find(Author.class, dto.authorToUpdateId);
        Thread.sleep(7500);
        author.setName(dto.name);
        em.flush();
    }

    @Transactional
    public void update2(UpdateAuthorDto dto){
        Author author = em.find(Author.class, dto.authorToUpdateId);
        author.setName(dto.name);
        em.persist(author);
    }
}
