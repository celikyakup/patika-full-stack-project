package patika.dev.librarymanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import patika.dev.librarymanagementsystem.entities.Book;

@Repository
public interface IBookRepo extends JpaRepository<Book,Integer> {
}
