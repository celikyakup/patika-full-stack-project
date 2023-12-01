package patika.dev.librarymanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import patika.dev.librarymanagementsystem.entities.Category;
@Repository
public interface ICategoryRepo extends JpaRepository<Category,Integer> {
}
