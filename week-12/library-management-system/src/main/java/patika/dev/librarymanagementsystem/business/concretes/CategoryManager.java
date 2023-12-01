package patika.dev.librarymanagementsystem.business.concretes;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import patika.dev.librarymanagementsystem.business.abstracts.IBookService;
import patika.dev.librarymanagementsystem.business.abstracts.ICategoryService;
import patika.dev.librarymanagementsystem.core.exception.NotFoundException;
import patika.dev.librarymanagementsystem.core.utilies.Message;
import patika.dev.librarymanagementsystem.dao.IBookRepo;
import patika.dev.librarymanagementsystem.dao.ICategoryRepo;
import patika.dev.librarymanagementsystem.entities.Book;
import patika.dev.librarymanagementsystem.entities.Category;

import java.util.List;

@Service
public class CategoryManager implements ICategoryService {
    @Autowired
    private ICategoryRepo categoryRepo;
    @Autowired
    IBookRepo bookRepo;
    @Override
    public Category getById(int id) {
        return this.categoryRepo.findById(id).orElseThrow(()->new NotFoundException(Message.NOT_FOUND));
    }

    @Override
    public Category save(Category category) {
        return this.categoryRepo.save(category);
    }

    @Override
    public Category update(Category category) {
        this.getById(category.getId());
        return this.categoryRepo.save(category);
    }

    @Override
    public boolean delete(int id) {
        Category category=this.getById(id);
        if (category.getBookList().isEmpty()){
            this.categoryRepo.delete(category);
            return true;
        }
        return false;
    }

    @Override
    public Page<Category> cursor(int page, int pageSize) {
        Pageable pageable= PageRequest.of(page,pageSize);
        return this.categoryRepo.findAll(pageable);
    }

    @Override
    public List<Category> findAll() {
        return this.categoryRepo.findAll();
    }

    @Override
    public Category assignBookToCategory(int categoryId, int bookId) {
        List<Book> bookList=null;
        Category category=categoryRepo.findById(categoryId).orElseThrow(()->new NotFoundException(Message.NOT_FOUND));
        Book book=bookRepo.findById(bookId).orElseThrow(()->new NotFoundException(Message.NOT_FOUND));
        bookList=category.getBookList();
        bookList.add(book);
        category.setBookList(bookList);
        return this.categoryRepo.save(category);
    }

}
