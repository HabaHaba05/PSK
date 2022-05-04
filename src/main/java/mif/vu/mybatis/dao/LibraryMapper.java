package mif.vu.mybatis.dao;

import mif.vu.mybatis.model.Library;
import org.apache.ibatis.annotations.Select;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface LibraryMapper{
    @Select("SELECT ID, NAME, ADDRESS FROM PUBLIC.LIBRARY")
    List<Library> getAll();
}
