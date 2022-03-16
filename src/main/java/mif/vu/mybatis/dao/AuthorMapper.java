package mif.vu.mybatis.dao;

import mif.vu.mybatis.model.Author;
import org.apache.ibatis.annotations.Select;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface AuthorMapper {
    @Select("SELECT ID, NAME FROM PUBLIC.AUTHOR")
    List<Author> selectAll();
}
