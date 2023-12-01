package patika.dev.librarymanagementsystem.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import patika.dev.librarymanagementsystem.business.abstracts.IPublisherService;
import patika.dev.librarymanagementsystem.core.exception.NotFoundException;
import patika.dev.librarymanagementsystem.core.utilies.Message;
import patika.dev.librarymanagementsystem.dao.IPublisherRepo;
import patika.dev.librarymanagementsystem.entities.Publisher;

@Service
public class PublisherManager implements IPublisherService {

    @Autowired
    private IPublisherRepo publisherRepo;
    @Override
    public Publisher getById(int id) {
        return this.publisherRepo.findById(id).orElseThrow(()->new NotFoundException(Message.NOT_FOUND));
    }

    @Override
    public Publisher save(Publisher publisher) {
        return this.publisherRepo.save(publisher);
    }

    @Override
    public Publisher update(Publisher publisher) {
        return this.publisherRepo.save(publisher);
    }

    @Override
    public boolean delete(int id) {
        Publisher publisher=this.getById(id);
        this.publisherRepo.delete(publisher);
        return true;
    }

    @Override
    public Page<Publisher> cursor(int page, int pageSize) {
        Pageable pageable= PageRequest.of(page,pageSize);
        return this.publisherRepo.findAll(pageable);
    }
}
