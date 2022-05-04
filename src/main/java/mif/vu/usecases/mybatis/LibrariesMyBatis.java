package mif.vu.usecases.mybatis;

import lombok.Getter;
import mif.vu.mybatis.dao.LibraryMapper;
import mif.vu.mybatis.model.Library;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model
public class LibrariesMyBatis {
    @Inject
    private LibraryMapper libraryMapper;

    @Getter
    private List<Library> allLibraries;

    @PostConstruct
    public void init(){
        loadALlLibs();
    }

    private void loadALlLibs(){
        allLibraries = libraryMapper.getAll();
    }
}
