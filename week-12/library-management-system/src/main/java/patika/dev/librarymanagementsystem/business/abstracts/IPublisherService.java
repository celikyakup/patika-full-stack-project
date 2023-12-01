package patika.dev.librarymanagementsystem.business.abstracts;

import org.springframework.data.domain.Page;

import patika.dev.librarymanagementsystem.entities.Publisher;

public interface IPublisherService {
    Publisher getById(int id);
    Publisher save(Publisher publisher);
    Publisher update(Publisher publisher);
    boolean delete(int id);
    Page<Publisher> cursor(int page, int pageSize);
}
