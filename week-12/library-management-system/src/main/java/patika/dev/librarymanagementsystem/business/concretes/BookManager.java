package patika.dev.librarymanagementsystem.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import patika.dev.librarymanagementsystem.business.abstracts.IBookService;
import patika.dev.librarymanagementsystem.core.exception.NotFoundException;
import patika.dev.librarymanagementsystem.core.utilies.Message;
import patika.dev.librarymanagementsystem.dao.IBookRepo;
import patika.dev.librarymanagementsystem.entities.Book;
import patika.dev.librarymanagementsystem.entities.BookBorrowing;
import patika.dev.librarymanagementsystem.entities.Category;

import java.util.List;
@Service
public class BookManager implements IBookService {
    @Autowired
    private IBookRepo bookRepo;
    @Override
    public Book getById(int id) {
        return this.bookRepo.findById(id).orElseThrow(()->new NotFoundException(Message.NOT_FOUND));
    }

    @Override
    public Book save(Book book) {
        return this.bookRepo.save(book);
    }

    @Override
    public Book uptade(Book book) {
        this.getById(book.getId());
        return this.bookRepo.save(book);
    }

    @Override
    public boolean delete(int id) {
        Book book=this.getById(id);
        this.bookRepo.delete(book);
        return true;
    }

    @Override
    public Page<Book> cursor(int page, int pageSize) {
        Pageable pageable= PageRequest.of(page,pageSize);

        return this.bookRepo.findAll(pageable);
    }

}
