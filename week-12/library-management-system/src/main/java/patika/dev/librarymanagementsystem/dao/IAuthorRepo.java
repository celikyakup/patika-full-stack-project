package patika.dev.librarymanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import patika.dev.librarymanagementsystem.entities.Author;

public interface IAuthorRepo extends JpaRepository<Author,Integer> {
}
