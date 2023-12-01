package patika.dev.librarymanagementsystem.business.abstracts;

import org.springframework.data.domain.Page;
import patika.dev.librarymanagementsystem.entities.BookBorrowing;
import patika.dev.librarymanagementsystem.entities.Category;

import java.util.List;

public interface IBookBorrowingService {
    BookBorrowing getById(int id);
    BookBorrowing save(BookBorrowing bookBorrowing);
    BookBorrowing update(BookBorrowing bookBorrowing);
    boolean delete(int id);
    Page<BookBorrowing> cursor(int page, int pageSize);
    List<BookBorrowing> findAll();

}
