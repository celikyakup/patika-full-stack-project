import java.util.Comparator;
import java.util.TreeSet;

public class Brand implements Comparator<Brand> {
    private final int brandNo;
    public static int count;
    private String brandName;
    public static TreeSet<Brand> brands = new TreeSet<>(Comparator.comparing(Brand::getBrandName));

    Brand(String brandName) {
        count++;
        this.brandNo = count;
        this.brandName = brandName;
    }

    public int getBrandNo() {
        return brandNo;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public int compare(Brand o1, Brand o2) {
        return o1.getBrandName().compareTo(o2.getBrandName());
    }
}
