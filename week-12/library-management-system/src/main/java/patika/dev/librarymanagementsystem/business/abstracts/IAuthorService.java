package patika.dev.librarymanagementsystem.business.abstracts;

import org.springframework.data.domain.Page;
import patika.dev.librarymanagementsystem.entities.Author;
import patika.dev.librarymanagementsystem.entities.BookBorrowing;

public interface IAuthorService {
    Author getById(int id);
    Author save(Author author);
    Author update(Author author);
    boolean delete(int id);
    Page<Author> cursor(int page, int pageSize);
}
