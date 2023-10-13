import java.util.Scanner;
public class NotebookOperation {
    Scanner input=new Scanner(System.in);
    //Notebook arayüzü tasarım işlemleri notebookProcess metodda çalışıyor.
    public void notebookProcess(){
        boolean isTrue=true;
        while (isTrue) {
            System.out.println("1 - Modelleri listele");
            System.out.println("2 - Yeni model ekle");
            System.out.println("3 - Listeden model kaldır");
            System.out.println("4 - ID numarasına göre filtrele");
            System.out.println("5 - Marka bilgisine göre filtrele");
            System.out.println("0 - Ana Menüye dön");
            System.out.println("--------------------------");
            System.out.print("Yapılacak işlemi seçiniz: ");
            int select = input.nextInt();
            System.out.println();
            switch (select){
                case 1->{
                    System.out.println("--------------------------");
                    listNotebook();
                    System.out.println("--------------------------");
                }
                case 2->{
                    System.out.println("--------------------------");
                    addNotebook();
                    System.out.println("--------------------------");
                }
                case 3 ->{
                    System.out.println("--------------------------");
                    removeNotebook();
                    System.out.println("--------------------------");
                }
                case 4->{
                    System.out.println("--------------------------");
                    filterNotebookbyId();
                    System.out.println("--------------------------");
                }
                case 5->{
                    System.out.println("--------------------------");
                    filterNotebookbyBrand();
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
    //Sisteme eklenen notebookları tablo olarak çıktı işlemi listNotebook ile gerçekleştiriyoruz.
    public void listNotebook(){
        System.out.printf("------------------------------------------------------------------------------%n");
        System.out.printf("| %4s | %-20s | %6s | %6s | %8s | %6s | %6s |%n", "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "RAM");
        System.out.printf("------------------------------------------------------------------------------%n");
        for (NoteBook notebook:NoteBook.noteBooks) {
            System.out.printf("| %4s | %-20s | %6s | %6s | %8s | %6s | %6s |%n", notebook.getProductId(), notebook.getProductName(), notebook.getUnitPrice(), notebook.getBrandInf().getBrandName(), notebook.getMemory(), notebook.getScreenSize(),notebook.getRAM());
            System.out.printf("------------------------------------------------------------------------------%n");

        }
    }
    //Listeye notebook ve özelliklerini ekleme işlemini addNotebook metodu içerisinde yapıyoruz.
    public void addNotebook(){
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
        System.out.print("Notebook hafıza bilgisini giriniz: ");
        int memory=input.nextInt();
        System.out.print("Ekran boyutunu giriniz: ");
        double screenSize=input.nextDouble();
        System.out.print("RAM bilgisini giriniz: ");
        int RAM= input.nextInt();
        System.out.print("Renk bilgisini giriniz:");
        String color=input.next();
        System.out.print("Stok miktarını giriniz:");
        int stock=input.nextInt();
        System.out.print("İndirim oranını giriniz: ");
        int discountRate=input.nextInt();
        NoteBook.noteBooks.add(new NoteBook(unitPrice,discountRate,stock,productName,new Brand(brandInfo),screenSize,memory,RAM,color));
        System.out.println(productName+" ürünü sisteme eklendi.");

    }
    //Liste içerisinden verileri silme işlemini bu metod ile yapıyoruz.
    public void removeNotebook(){
        listNotebook();
        System.out.print("Silmek istediğiniz ürün ID'yi giriniz: ");
        int removeId= input.nextInt();
        for (NoteBook notebook:NoteBook.noteBooks){
            if (notebook.getProductId()==removeId){
                NoteBook.noteBooks.remove(notebook);
                System.out.println("İşlem başarılı.");
                break;
            }
        }
        System.out.println("Yanlış ID numarası girdiniz!!!");
    }
    // ID ye göre filtreleme işlemlerini filterNotebookbyId metody içerisinde hallediyoruz.
    public void filterNotebookbyId(){
        System.out.print("Filtrelemek istediğiniz notebook ID'sini giriniz: ");
        int filterbyId=input.nextInt();
        System.out.printf("------------------------------------------------------------------------------%n");
        System.out.printf("| %4s | %-20s | %6s | %6s | %8s | %6s | %6s |%n", "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "RAM");
        System.out.printf("------------------------------------------------------------------------------%n");

        for (NoteBook notebook:NoteBook.noteBooks){
            if (filterbyId == notebook.getProductId()){
                System.out.printf("| %4s | %-20s | %6s | %6s | %8s | %6s | %6s |%n", notebook.getProductId(), notebook.getProductName(), notebook.getUnitPrice(), notebook.getBrandInf().getBrandName(), notebook.getMemory(), notebook.getScreenSize(),notebook.getRAM());
                System.out.printf("------------------------------------------------------------------------------%n");
            }
        }
    }
    // Marka bilgisine filtreleme işlemini filterNotebookbyBrand metodu içerisinde yapıyoruz.
    public void filterNotebookbyBrand(){
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
        System.out.printf("------------------------------------------------------------------------------%n");
        System.out.printf("| %4s | %-20s | %6s | %6s | %8s | %6s | %6s |%n", "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "RAM");
        System.out.printf("------------------------------------------------------------------------------%n");

        for (NoteBook b:NoteBook.noteBooks){
            if (filterByBrand.equals(b.getBrandInf().getBrandName())) {
                System.out.printf("| %4s | %-20s | %6s | %6s | %8s | %6s | %6s |%n", b.getProductId(), b.getProductName(), b.getUnitPrice(), b.getBrandInf().getBrandName(), b.getMemory(), b.getScreenSize(),b.getRAM());
                System.out.printf("------------------------------------------------------------------------------%n");

            }
        }
    }
}