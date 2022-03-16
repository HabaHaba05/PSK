package mif.vu.mybatis.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Library {
    private Integer id;
    private String address;
    private String name;

    private List<Book> books;
}