import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int num;
        int sum=0;
        Scanner input=new Scanner(System.in);
        do {
            System.out.print("Sayıyı giriniz:");
            num= input.nextInt();
            if (num%4==0){
                sum+=num;
            }
        }
        while (num%2==0);
        System.out.println("Sayıların toplamı:"+sum);
    }
}