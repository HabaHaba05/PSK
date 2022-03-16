package mif.vu.usecases.mybatis;

import lombok.Getter;
import lombok.Setter;
import mif.vu.mybatis.dao.BookAuthorMapper;
import mif.vu.mybatis.dao.BookMapper;
import mif.vu.mybatis.model.Book;
import mif.vu.mybatis.model.BookAuthor;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Model
public class BooksMyBatis {
    @Inject
    private BookMapper bookMapper;
    @Inject
    private BookAuthorMapper bookAuthorMapper;

    @Getter
    private List<Book> allBooks;

    @Getter
    @Setter
    private Book bookToCreate = new Book();

    @Getter
    @Setter
    private List<Integer> authorsIdsOfNewBook = new ArrayList<>();

    @PostConstruct
    public void init(){
        loadAllBooks();
    }

    @Transactional
    public void createBook(){
        bookMapper.insert(bookToCreate);

        for (Integer authorId:authorsIdsOfNewBook) {
            BookAuthor bookAuthor = new BookAuthor();
            bookAuthor.setAuthorId(authorId);
            bookAuthor.setBookId(bookToCreate.getId());
            bookAuthorMapper.insert((bookAuthor));
        }
    }

    private void loadAllBooks(){
        allBooks = bookMapper.selectAll();
    }
}
