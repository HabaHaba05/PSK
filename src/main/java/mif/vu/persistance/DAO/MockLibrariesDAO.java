package mif.vu.persistance.DAO;

import mif.vu.entities.Library;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Alternative
@ApplicationScoped
public class MockLibrariesDAO implements ILibrariesDAO {
    private List<Library> libs = new ArrayList<>(Arrays.asList(
            new Library(1, "Trepu Biblioteka", "Trepai"),
            new Library(2, "Vaidilu Biblioteka", "Vaidilai"),
            new Library(3, "Skaudviles Biblioteka", "Skaudvile")
    ));

    public List<Library> getAll() {
        return libs;
    }

    public void create(Library library) {
        library.setId(libs.size()+1);
        libs.add(library);
    }

    public Library findById(Integer id) {
        for (Library lib : libs) {
            if(lib.getId() == id){
                return lib;
            }
        }
        return null;
    }
}
