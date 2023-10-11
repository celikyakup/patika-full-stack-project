import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Book> books1=new TreeSet<>(new OrderBookComperator());
        books1.add(new Book("1984",352,"George Orwel",1984));
        books1.add(new Book("Hayvan Çiftliği",150,"George Orwel",2023));
        books1.add(new Book("Seker Portakalı",257,"Anton Çehov",2005));
        books1.add(new Book("Altın Koğuş",234,"Anton Çehov",2008));
        books1.add(new Book("Var mısın?",115,"Doğan Cüceoğlu",2020));

        for (Book b: books1){
            System.out.println(b.getName());
        }
        System.out.println("------------------------");
        TreeSet<Book> books2=new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getPageNumber()-o2.getPageNumber();
            }
        });
        books2.add(new Book("1984",352,"George Orwel",1984));
        books2.add(new Book("Hayvan Çiftliği",150,"George Orwel",2023));
        books2.add(new Book("Şeker Portakalı",257,"Anton Çehov",2005));
        books2.add(new Book("Altın Koğuş",234,"Anton Çehov",2008));
        books2.add(new Book("Var mısın?",115,"Doğan Cüceoğlu",2020));

        for (Book b: books2){
            System.out.println(b.getName());
        }
    }
}