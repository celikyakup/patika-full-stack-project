package patika.dev.librarymanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import patika.dev.librarymanagementsystem.entities.Publisher;

public interface IPublisherRepo extends JpaRepository<Publisher,Integer> {
}
