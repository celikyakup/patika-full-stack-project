package patika.dev.librarymanagementsystem.business.abstracts;

import org.springframework.data.domain.Page;
import patika.dev.librarymanagementsystem.entities.Book;
import patika.dev.librarymanagementsystem.entities.Category;

import java.util.List;

public interface IBookService {

    Book getById(int id);
    Book save(Book book);

    Book uptade(Book book);

    boolean delete(int id);

    Page<Book> cursor(int page, int pageSize);
}
