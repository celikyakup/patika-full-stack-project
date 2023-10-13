import java.util.Comparator;
import java.util.TreeSet;

public class Phone extends ProductFeatures{
    private int batteryPower;
    public static TreeSet<Phone> phones=new TreeSet<>(Comparator.comparing(Phone::getProductId));

    public Phone(int unitPrice, double discountRate, int stock, String productName, Brand brandInf, double screenSize, int memory, int RAM, String color, int batteryPower) {
        super(unitPrice, discountRate, stock, productName, brandInf, screenSize, memory, RAM,  color);
        this.batteryPower = batteryPower;
    }

    public int getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(int batteryPower) {
        this.batteryPower = batteryPower;
    }
}
