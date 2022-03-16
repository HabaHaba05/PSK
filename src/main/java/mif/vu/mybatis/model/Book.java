package mif.vu.mybatis.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class Book {
    private Integer id;
    private String title;
    private Integer libraryId;

    private Library library;
    private List<Author> authors;
}