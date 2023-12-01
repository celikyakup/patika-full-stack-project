package patika.dev.librarymanagementsystem.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import patika.dev.librarymanagementsystem.business.abstracts.IAuthorService;
import patika.dev.librarymanagementsystem.core.exception.NotFoundException;
import patika.dev.librarymanagementsystem.core.utilies.Message;
import patika.dev.librarymanagementsystem.dao.IAuthorRepo;
import patika.dev.librarymanagementsystem.entities.Author;
@Service
public class AuthorManager implements IAuthorService {
    @Autowired
    private IAuthorRepo authorRepo;
    @Override
    public Author getById(int id) {
        return this.authorRepo.findById(id).orElseThrow(()->new NotFoundException(Message.NOT_FOUND));
    }

    @Override
    public Author save(Author author) {
        return this.authorRepo.save(author);
    }

    @Override
    public Author update(Author author) {
        this.getById(author.getId());
        return this.authorRepo.save(author);
    }

    @Override
    public boolean delete(int id) {
        Author author=this.getById(id);
        this.authorRepo.delete(author);
        return true;
    }

    @Override
    public Page<Author> cursor(int page, int pageSize) {
        Pageable pageable= PageRequest.of(page,pageSize);
        return this.authorRepo.findAll(pageable);
    }
}
