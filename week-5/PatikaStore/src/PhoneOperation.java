import java.util.Scanner;
public class PhoneOperation {
    Scanner input=new Scanner(System.in);
    //Phone arayüz tasarım işlemleri phoneProcess metodunda yapılıyor.
    public void phoneProcess(){
        boolean isTrue=true;
        while (isTrue) {
            System.out.println("1 - Modelleri listele");
            System.out.println("2 - Yeni model ekle");
            System.out.println("3 - Listeden model kaldır");
            System.out.println("4 - ID numarasına göre filtrele");
            System.out.println("5 - Marka bilgisine göre filtrele");
            System.out.println("0 - Ana menüye dön");
            System.out.println("--------------------------");
            System.out.print("Yapılacak işlemi seçiniz: ");
            int select = input.nextInt();
            System.out.println();
            switch (select){
                case 1->{
                    System.out.println("--------------------------");
                    listPhone();
                    System.out.println("--------------------------");
                }
                case 2->{
                    System.out.println("--------------------------");
                    addPhone();
                    System.out.println("--------------------------");
                }
                case 3 ->{
                    System.out.println("--------------------------");
                    removePhone();
                    System.out.println("--------------------------");
                }
                case 4->{
                    System.out.println("--------------------------");
                    filterPhonebyId();
                    System.out.println("--------------------------");
                }
                case 5->{
                    System.out.println("--------------------------");
                    filterPhoneByBrand();
                    System.out.println("--------------------------");
                }
                case 0->{
                    System.out.println("Ana menüye yönlendiriliyorsunuz....");
                    isTrue=false;
                }
                default -> System.out.println("Hatalı tuşlama yaptınız. Tekrar tuşlama yapınız.");
            }
        }
    }
    //Phone listesini çıktı alma işlemini listPhone methodunda yapıyoruz.
    public void listPhone(){
        System.out.printf("----------------------------------------------------------------------------------------------%n");
        System.out.printf("| %4s | %-20s | %6s | %6s | %8s | %6s | %6s | %4s | %6s |%n", "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran","Pil", "RAM","Renk");
        System.out.printf("----------------------------------------------------------------------------------------------%n");
        for (Phone phone:Phone.phones) {
            System.out.printf("| %4s | %-20s | %6s | %6s | %8s | %6s | %6s | %4s | %6s |%n", phone.getProductId(), phone.getProductName(), phone.getUnitPrice(), phone.getBrandInf().getBrandName(), phone.getMemory(), phone.getScreenSize(),phone.getBatteryPower() ,phone.getRAM(),phone.getColor());
            System.out.printf("----------------------------------------------------------------------------------------------%n");

        }
    }
    //Listeye phone özellikleri ekleme işlemini addPhone metodunda yapıyoruz.
    public void addPhone(){
        System.out.println("Eklemek istediğiniz ürünün özelliklerini yönlendirme sırasına göre giriniz !!");
        input.nextLine();
        System.out.print("Ürün adını giriniz: ");
        String productName=input.nextLine();
        System.out.print("Ürün fiyatını giriniz: ");
        int unitPrice=input.nextInt();
        System.out.print("Ürün markasını giriniz:");
        input.nextLine();
        String brandInfo=input.nextLine();
        String letter=brandInfo.substring(0,1).toUpperCase();
        brandInfo=letter+brandInfo.substring(1).toLowerCase();
        while (!Brand.brands.contains(new Brand(brandInfo))){
            System.out.println("Geçersiz marka ismi girdiniz. Tekrar giriş yapınız.");
            brandInfo=input.next();
            letter=brandInfo.substring(0,1).toUpperCase();
            brandInfo=letter+brandInfo.substring(1).toLowerCase();
        }
        System.out.print("Telefon hafıza bilgisini giriniz: ");
        int memory=input.nextInt();
        System.out.print("Ekran boyutunu giriniz: ");
        double screenSize=input.nextDouble();
        System.out.print("Pil gücünü giriniz:");
        int batteryPower=input.nextInt();
        System.out.print("RAM bilgisini giriniz: ");
        int RAM= input.nextInt();
        System.out.print("Renk bilgisini giriniz:");
        String color=input.next();
        System.out.print("Stok miktarını giriniz:");
        int stock=input.nextInt();
        System.out.print("İndirim oranını giriniz: ");
        int discountRate=input.nextInt();
        Phone.phones.add(new Phone(unitPrice,discountRate,stock,productName,new Brand(brandInfo),screenSize,memory,RAM,color,batteryPower));
        System.out.println(productName+" ürünü sisteme eklendi.");
    }
    //Listeden eleman silme işlemi removePhone metodunda yapıyoruz.
public void removePhone(){
        listPhone();
        System.out.print("Silmek istediğiniz ürün ID'yi giriniz: ");
        int removeId= input.nextInt();
        for (Phone p:Phone.phones){
            if (p.getProductId()==removeId){
                Phone.phones.remove(p);
                System.out.println("Ürünü silme işlemi başarıyla tamamlandı.");
                break;
            }
        }
        System.out.println("Böyle bir ürün ID'si bulunamadı.");
    }
    //ID ye göre filtreleme işlemini filterphonebyId methodunda yapıyoruz.
    public void filterPhonebyId(){
        System.out.print("Filtrelemek istediğiniz notebook ID'sini giriniz: ");
        int filterbyId=input.nextInt();
        System.out.printf("----------------------------------------------------------------------------------------------%n");
        System.out.printf("| %4s | %-20s | %6s | %6s | %8s | %6s | %6s | %4s | %6s |%n", "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran","Pil", "RAM","Renk");
        System.out.printf("----------------------------------------------------------------------------------------------%n");

        for (Phone phone:Phone.phones){
            if (filterbyId == phone.getProductId()){
                System.out.printf("| %4s | %-20s | %6s | %6s | %8s | %6s | %6s | %4s | %6s |%n", phone.getProductId(), phone.getProductName(), phone.getUnitPrice(), phone.getBrandInf().getBrandName(), phone.getMemory(), phone.getScreenSize(),phone.getBatteryPower() ,phone.getRAM(),phone.getColor());
                System.out.printf("----------------------------------------------------------------------------------------------%n");
            }
        }
    }
    // Markaya göre filtreleme işlemini filterPhoneByBrand metodunda yapıyoruz.
    public void filterPhoneByBrand(){
        System.out.print("Filtrelemek istediğiniz notebook markasını giriniz: ");
        input.nextLine();
        String filterByBrand=input.nextLine();
        String letter=filterByBrand.substring(0,1).toUpperCase();
        filterByBrand=letter+filterByBrand.substring(1).toLowerCase();
        while (!Brand.brands.contains(new Brand(filterByBrand))){
            System.out.println("Geçersiz marka ismi girdiniz. Tekrar giriş yapınız.");
            filterByBrand=input.next();
            letter=filterByBrand.substring(0,1).toUpperCase();
            filterByBrand=letter+filterByBrand.substring(1).toLowerCase();
        }
        System.out.printf("----------------------------------------------------------------------------------------------%n");
        System.out.printf("| %4s | %-20s | %6s | %6s | %8s | %6s | %6s | %4s | %6s |%n", "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran","Pil", "RAM","Renk");
        System.out.printf("----------------------------------------------------------------------------------------------%n");

        for (Phone phone:Phone.phones){
            if (filterByBrand.equals(phone.getBrandInf().getBrandName())) {
                System.out.printf("| %4s | %-20s | %6s | %6s | %8s | %6s | %6s | %4s | %6s |%n", phone.getProductId(), phone.getProductName(), phone.getUnitPrice(), phone.getBrandInf().getBrandName(), phone.getMemory(), phone.getScreenSize(),phone.getBatteryPower() ,phone.getRAM(),phone.getColor());
                System.out.printf("----------------------------------------------------------------------------------------------%n");

            }
        }
    }
}

