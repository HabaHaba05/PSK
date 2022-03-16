package mif.vu.mybatis.dao;

import mif.vu.mybatis.model.BookAuthor;
import org.mybatis.cdi.Mapper;

@Mapper
public interface BookAuthorMapper {
    void insert(BookAuthor bookAuthor);
}
