import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        System.out.print("Matematik notunu giriniz:");
        int mat= input.nextInt();
        System.out.print("Türkçe notunu giriniz:");
        int turk=input.nextInt();
        System.out.print("Fizik notunu giriniz:");
        int fiz=input.nextInt();
        System.out.print("Kimya notunu giriniz:");
        int kim=input.nextInt();
        System.out.print("Tarih notunu giriniz:");
        int tar= input.nextInt();
        System.out.print("Müzik notunu giriniz:");
        int muz=input.nextInt();

        int ort= (mat+turk+fiz+kim+tar+muz)/6;
        String result=(ort>60)?" Sınıfı Geçtin":" Sınıfta Kaldın";
        System.out.println("Ortalamanız:"+ort+ result);

    }
}