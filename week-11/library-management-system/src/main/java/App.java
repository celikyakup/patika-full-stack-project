import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("library");
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        EntityTransaction transaction=entityManager.getTransaction();

        transaction.begin();

        //Add BookBorrowing
        BookBorrowing bookBorrowing=new BookBorrowing();
        bookBorrowing.setBorrowerName("yakup");
        bookBorrowing.setBorrowingDate(LocalDate.of(2023,11,10));
        bookBorrowing.setReturnDate(LocalDate.of(2023,11,13));
        entityManager.persist(bookBorrowing);

        //Add Publisher
        Publisher publisher=new Publisher();
        publisher.setName("Kitap kurdu");
        publisher.setAddress("Küçükyalı");
        publisher.setEstablishmentYear(1983);
        entityManager.persist(publisher);

        //Add Author
        Author author=new Author();
        author.setName("bbbbb");
        author.setBirthDate(LocalDate.of(1964,11,11));
        author.setCountry("TR");
        entityManager.persist(author);

        //Add Book
        Book book=new Book();
        book.setName("Aaaaa");
        book.setPublicationYear(2005);
        book.setStock(10);
        book.setAuthor(author);
        book.setBookBorrowing(bookBorrowing);
        book.setPublisher(publisher);
        entityManager.persist(book);

        //
        Category adventure=new Category("adventure");
        Category horror=new Category("horror");
        entityManager.persist(adventure);
        entityManager.persist(horror);

        book=entityManager.find(Book.class,1);
        List<Category> categoryList=new ArrayList<>();
        categoryList.add(adventure);
        categoryList.add(horror);
        book.setCategoryList(categoryList);


        transaction.commit();
    }
}
