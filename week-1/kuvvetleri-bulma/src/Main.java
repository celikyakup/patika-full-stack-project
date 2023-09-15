import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Sınırlama sayısını giriniz:");
        int num = input.nextInt();
        // 4' ün kuvvetlerini yazdırmak için for loopu oluşturuyoruz.
        for (int i = 1; i < num; i *= 4) {
            System.out.print(" " + i);
        }
        //Çıktılar arasına boşluk koymak için println bastırıyoruz.
        System.out.println();
        //5'in kuvvetlerini yazdırmak için for loopu oluşturuyoruz.
        for (int j = 1; j < num; j *= 5) {

            System.out.print(" " + j);
        }
    }
}
