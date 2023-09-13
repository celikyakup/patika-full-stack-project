import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //Değişkenleri tanımlıyoruz.
        int minUcret=20,taxAcilis=10;
        double kmUcret=2.20;
        //Kullanıcıdan gidilen km miktarını girmesini beklediğimiz için Scanner oluşturuyoruz.
        Scanner input= new Scanner(System.in);
        System.out.print("Mesafeyi km cinsinden giriniz:");
        Double km= input.nextDouble();
        //Taksimetre ücretini hesaplıyoruz.
        double taksimetre=km*2.20+taxAcilis;
        //Koşullarımıza göre çıktı alabilmek için if else döngüsü oluşturuyoruz.
        if (taksimetre<20){
            System.out.println("Ödemeniz gereken ücret:"+minUcret);
        }
        else{
            System.out.println("Ödemeniz gereken ücret:"+taksimetre);
        }
    }
}