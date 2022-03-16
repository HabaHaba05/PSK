package mif.vu.usecases.mybatis;

import lombok.Getter;
import mif.vu.mybatis.dao.AuthorMapper;
import mif.vu.mybatis.model.Author;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model
public class AuthorsMyBatis {
    @Inject
    private AuthorMapper authorMapper;

    @Getter
    private List<Author> allAuthors;

    @PostConstruct
    public void init(){
        loadALlAuthors();
    }

    private void loadALlAuthors(){
        allAuthors = authorMapper.selectAll();
    }
}
