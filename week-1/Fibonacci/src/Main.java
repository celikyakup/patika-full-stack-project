import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        System.out.print("Kaç elemanlı fibonacci serisi oluşturacaksın:");
        int eleman= input.nextInt();
        // fibonacci sersinin ilk iki elemanını değişkene atıyorum.
        int fibonacci=0,a=0,b=1;
        for(int i=1;i<=eleman;i++){
            //0 ı görebilmek için üstte çıktı veriyoruz.
            System.out.print(a+"  ");
            fibonacci=a+b;
            a=b;
            b=fibonacci;

            }

        }
    }
