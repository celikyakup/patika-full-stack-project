package patika.dev.librarymanagementsystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int id;

    @Column(name = "category_name")
    private String name;
    @Column(name = "category_description")
    private String description;

    @ManyToMany(mappedBy = "categoryList", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Book> bookList;

}
