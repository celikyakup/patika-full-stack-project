import java.util.*;
public class PatikaStore {
    Scanner input = new Scanner(System.in);

    static {
        Brand.brands.add(new Brand("Samsung"));
        Brand.brands.add(new Brand("Lenovo"));
        Brand.brands.add(new Brand("Apple"));
        Brand.brands.add(new Brand("Huawei"));
        Brand.brands.add(new Brand("Casper"));
        Brand.brands.add(new Brand("Asus"));
        Brand.brands.add(new Brand("HP"));
        Brand.brands.add(new Brand("Xioami"));
        Brand.brands.add(new Brand("Monster"));
        NoteBook.noteBooks.add(new NoteBook(1,1,1,"mac",new Brand("Apple"),15,120,10,"black"));
        NoteBook.noteBooks.add(new NoteBook(1,1,1,"mac pro",new Brand("Apple"),13,150,8,"black"));
        NoteBook.noteBooks.add(new NoteBook(1,1,1,"sam pro",new Brand("Samsung"),17,250,16,"black"));
    }

    public void run() {
        boolean isTrue = true;
        while (isTrue) {
            System.out.println("Patika ürün Yönetim Paneli !");
            System.out.println("1 - Notebook İşlemleri");
            System.out.println("2 - Cep Telefonu İşlemleri");
            System.out.println("3 - Marka Listele ");
            System.out.println("0 - Çıkış Yap");
            System.out.println("--------------------------");
            System.out.print("Tercihiniz : ");
            int select = input.nextInt();
            PhoneOperation po = new PhoneOperation();
            NotebookOperation no=new NotebookOperation();
            switch (select) {
                case 1 -> {
                    System.out.println("--------------------------");
                    System.out.println("Notebook işlemleri");
                    no.notebookProcess();
                    System.out.println("--------------------------");

                }
                case 2 -> {
                    System.out.println("Cep telefonu İşlemleri");
                    po.phoneProcess();
                    System.out.println("--------------------------");
                }
                case 3 -> {
                    System.out.println("Markalarımız");
                    System.out.println("--------------------------");
                    brandList();

                }
                case 0 -> {
                    System.out.println("Sistemden çıkış yapılıyor...");
                    isTrue = false;
                }
                default -> {
                    System.out.println("Yanlış kategori seçimi yaptınız. Tekrar tuşlayınız.");
                    continue;
                }
            }
        }
    }

    public void brandList() {
        for (Brand i : Brand.brands) {
            System.out.println("- " + i.getBrandName());
        }
        System.out.println();
    }
}



