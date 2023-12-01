package patika.dev.librarymanagementsystem.dto.response.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import patika.dev.librarymanagementsystem.entities.Author;
import patika.dev.librarymanagementsystem.entities.BookBorrowing;
import patika.dev.librarymanagementsystem.entities.Category;
import patika.dev.librarymanagementsystem.entities.Publisher;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {
    private int id;
    private String name;
    private int stock;
    private int publicationYear;
    private int author_Id;
    private int publisherId;
}
