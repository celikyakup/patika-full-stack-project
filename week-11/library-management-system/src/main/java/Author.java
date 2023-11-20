import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private int id;
    @Column(name = "author_name")
    private String name;
    @Column(name = "author_birthDate")
    private LocalDate birthDate;
    @Column(name = "author_country")
    private String country;

    @OneToMany(mappedBy = "author",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private List<Book> bookList;

    public Author() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String  getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name=" + name +
                ", birthDate=" + birthDate +
                ", country='" + country + '\'' +
                ", bookList=" + bookList +
                '}';
    }
}
