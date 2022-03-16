package mif.vu.mybatis.dao;

import mif.vu.mybatis.model.Book;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    int insert(Book record);
    List<Book> selectAll();
}