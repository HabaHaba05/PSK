package mif.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import mif.vu.entities.Library;
import mif.vu.persistance.DAO.LibrariesDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class BooksInLibrary {
    @Inject
    private LibrariesDAO librariesDAO;

    @Inject
    private Selectors selectors;

    @Getter
    @Setter
    private Library library;

    @PostConstruct
    public void init(){
        Integer libraryId = selectors.getLibraryId();
        if(libraryId != null){
            this.library = librariesDAO.findById(libraryId);
        }
    }
}
