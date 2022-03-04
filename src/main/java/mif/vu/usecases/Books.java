package mif.vu.usecases;

import lombok.Setter;
import lombok.Getter;
import mif.vu.entities.Book;
import mif.vu.persistance.DAO.BooksDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Books {
    @Inject
    private BooksDAO booksDAO;

    @Getter
    private List<Book> allBooks;

    @Getter
    @Setter
    private Book bookToCreate = new Book();

    @PostConstruct
    public void init(){
        loadAllBooks();
    }

    @Transactional
    public void createBook(){
        booksDAO.create(bookToCreate);
    }

    private void loadAllBooks(){
        allBooks = booksDAO.getAll();
    }
}
