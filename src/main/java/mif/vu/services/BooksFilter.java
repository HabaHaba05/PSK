package mif.vu.services;

import mif.vu.entities.Book;
import mif.vu.usecases.Selectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.Iterator;
import java.util.List;

@RequestScoped
public class BooksFilter {

    @Inject
    private Selectors selectors;

    public void filterBooks(List<Book> books){
        if(selectors.getBookTitle() != null ){
            for (Iterator<Book> iterator = books.iterator(); iterator.hasNext(); ) {
                Book book = iterator.next();
                if(!book.getTitle().toLowerCase().contains(
                        selectors.getBookTitle().trim().toLowerCase()
                )){
                    iterator.remove();
                }
            }
        }
    };

}
