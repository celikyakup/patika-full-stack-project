package patika.dev.librarymanagementsystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "publishers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id")
    private int id;

    @Column(name = "publisher_name")
    private String name;

    @Column(name = "establishment_year")
    private int establishmentYear;
    @Column(name="publisher_address")
    private String address;

    @OneToMany(mappedBy = "publisher",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private List<Book> bookList;
}
