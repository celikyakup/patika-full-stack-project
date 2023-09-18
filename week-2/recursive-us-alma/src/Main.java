import java.util.Scanner;
public class Main {
    static int usAlma(int num,int us){
        if (us==0){
            return 1;
        }
        return usAlma(num,us-1)*num;
    }
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Üs alınacak sayıyı giriniz:");
        int num= input.nextInt();;
        System.out.print("ÜS değerini giriniz:");
        int us= input.nextInt();
        System.out.println("Sonuc:"+usAlma(num,us));
    }
}