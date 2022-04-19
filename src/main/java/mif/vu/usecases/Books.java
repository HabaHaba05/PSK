package mif.vu.usecases;

import lombok.Setter;
import lombok.Getter;
import mif.vu.entities.Book;
import mif.vu.persistance.DAO.BooksDAO;
import mif.vu.services.BooksFilter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Books {

    @Inject
    private BooksFilter booksFilter;

    @Inject
    private BooksDAO booksDAO;

    @Getter
    private List<Book> allBooks;

    @Getter
    @Setter
    private Book bookToCreate = new Book();

    @Getter
    @Setter
    private Book bookToDelete = new Book();

    @PostConstruct
    public void init(){
        loadAllBooks();
        booksFilter.filterBooks(this.allBooks);
    }

    @Transactional
    public void createBook(){
        booksDAO.create(bookToCreate);
    }

    @Transactional
    public void removeBook(int id){
        booksDAO.remove(booksDAO.findById(id));
    }



    private void loadAllBooks(){
        allBooks = booksDAO.getAll();
    }
}
