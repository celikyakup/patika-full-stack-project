package patika.dev.librarymanagementsystem.dto.request.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import patika.dev.librarymanagementsystem.entities.BookBorrowing;
import patika.dev.librarymanagementsystem.entities.Category;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookSaveRequest {

    private String name;
    private int stock;
    private int publicationYear;
    private int author_Id;
    private int publisherId;

}
