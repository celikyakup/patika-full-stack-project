import java.util.Comparator;
import java.util.TreeSet;

public class NoteBook extends ProductFeatures {
    public static TreeSet<NoteBook> noteBooks=new TreeSet<>(Comparator.comparing(NoteBook::getProductId));
    public NoteBook(int unitPrice, double discountRate, int stock, String productName, Brand brandInf, double screenSize, int memory, int RAM, String color) {
        super(unitPrice, discountRate, stock, productName, brandInf, screenSize, memory, RAM, color);
    }

}

