public abstract class  ProductFeatures {
    private final int productId;
    private int unitPrice;
    private double discountRate;
    private int stock;
    private String productName;
    Brand brandInf;
    private double screenSize;
    private int RAM;
    private int memory;
    private String color;
    private int storage;
    public static int count;

    public ProductFeatures(int unitPrice, double discountRate, int stock, String productName, Brand brandInf, double screenSize, int memory,int RAM,String color) {
        count++;
        this.productId = count;
        this.unitPrice = unitPrice;
        this.discountRate = discountRate;
        this.stock = stock;
        this.productName = productName;
        this.brandInf = brandInf;
        this.screenSize = screenSize;
        this.RAM = RAM;
        this.memory=memory;
        this.color = color;
    }

    public Brand getBrandInf() {
        return brandInf;
    }

    public void setBrandInf(Brand brandInf) {
        this.brandInf = brandInf;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getProductId() {
        return productId;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }
}
