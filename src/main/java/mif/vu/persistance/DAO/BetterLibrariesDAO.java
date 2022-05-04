package mif.vu.persistance.DAO;

import mif.vu.entities.Library;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Specializes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@Specializes
@ApplicationScoped
public class BetterLibrariesDAO extends LibrariesDAO {
    @Inject
    private EntityManager em;

    public List<Library> getAll() {
        System.out.println("USING SPECIALIZES");
        return em.createNamedQuery("Library.findAll", Library.class).getResultList();
    }
}
