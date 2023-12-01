package patika.dev.librarymanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import patika.dev.librarymanagementsystem.entities.BookBorrowing;
@Repository
public interface IBookBorrowingRepo extends JpaRepository<BookBorrowing,Integer> {
}
