package mif.vu.persistance.DAO;

import mif.vu.entities.Library;

import java.util.List;

public interface ILibrariesDAO {
    List<Library> getAll();
    void create(Library library);
    Library findById(Integer id);
}
