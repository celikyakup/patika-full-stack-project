import java.util.Scanner;
public class Main {
    static void desenOlusturma(int num,int decrease){
        //Metoda girilen num sayısını yazdırmak için nu'ı print ediyoruz.
        System.out.print(num+" ");
        //num 0'dan küçükken return ile koşula göre sayıları tekrar döndürüyoruz.
        if (num<=0){
            return;
        }
        //Koşulumuza kadar çıktı alabilmek için metodu giriyoruz.
        desenOlusturma(num-decrease,decrease);
        //Desenenin her number'ini görebilmek için tekrar print ediyoruz.
        System.out.print(num+" ");
    }
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Sayıyı giriniz:");
        int num= input.nextInt();
        desenOlusturma(num,5);
    }
}