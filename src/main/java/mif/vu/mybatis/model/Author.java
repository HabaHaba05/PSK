package mif.vu.mybatis.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Author {

    private Integer id;
    private String name;

    private List<Book> books;
}