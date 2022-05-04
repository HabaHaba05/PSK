package mif.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import mif.vu.entities.Library;
import mif.vu.persistance.DAO.ILibrariesDAO;
import mif.vu.persistance.DAO.LibrariesDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Libraries{
    @Inject
    private ILibrariesDAO librariesDAO;

    @Getter
    private List<Library> allLibraries;

    @Getter
    @Setter
    private Library libraryToCreate = new Library();

    @PostConstruct
    public void init(){
        loadAllLibraries();
    }

    public void createLibrary(){
        librariesDAO.create(libraryToCreate);
    }

    private void loadAllLibraries(){
        this.allLibraries = librariesDAO.getAll();
    }
}
