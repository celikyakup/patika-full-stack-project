package patika.dev.librarymanagementsystem.dto.response.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import patika.dev.librarymanagementsystem.entities.Book;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse {

    private int id;
    private String name;
    private String description;
    private List<Book> bookList;
}
