import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        System.out.print("Sayıyı giriniz:");
        int a= input.nextInt();
        System.out.print("Sayıyı giriniz:");
        int b= input.nextInt();
        System.out.print("Sayıyı giriniz:");
        int c= input.nextInt();

        System.out.println(a+b*c-b);
    }
}