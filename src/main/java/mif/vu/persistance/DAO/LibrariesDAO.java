package mif.vu.persistance.DAO;

import mif.vu.entities.Library;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class LibrariesDAO {
    @Inject
    private EntityManager em;

    public List<Library> getAll() {
        return em.createNamedQuery("Library.findAll", Library.class).getResultList();
    }

    public void create(Library library)
    {
        this.em.persist(library);
    }

    public Library findById(Integer id) {
        return em.find(Library.class, id);
    }
}