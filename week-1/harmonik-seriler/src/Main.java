import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        System.out.print("Sayıyı giriniz:");
        int num= input.nextInt();
        double harNum,sum=0;
        for (double i=1;i<=num;i++){
            harNum=(1/i);
            sum+=harNum;
        }
        System.out.println("Harmonik seri toplam değeri:"+sum);
    }
}