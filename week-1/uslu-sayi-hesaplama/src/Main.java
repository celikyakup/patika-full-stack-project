import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Üssü alınacak sayıyı giriniz:");
        int num= input.nextInt();
        System.out.print("Üs olacak sayıyı giriniz:");
        int us= input.nextInt();
        int sum=1;
        for (int i=1;i<=us;i++){
            sum*=num;
        }
        System.out.println(sum);
    }
}