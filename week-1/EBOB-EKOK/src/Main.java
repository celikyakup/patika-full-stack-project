import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        System.out.println("EBOB ve EKOK alınacak sayıları giriniz.");
        System.out.print("1. sayıyı giriniz:");
        int num1= input.nextInt();
        System.out.print("2. sayıyı giriniz:");
        int num2=input.nextInt();
        int ebob=0;
        if (num1<num2){
            int i=1;
            while (i<=num1){
                if (num1%i==0 && num2%i==0){
                    ebob=i;
                }
                i++;
            }
            System.out.println("EBOB:"+ebob);
        }
        else {
            int i=1;
            while (i<=num2){
                if (num1%i==0 && num2%i==0){
                    ebob=i;
                }
                i++;
            }
            System.out.println("EBOB:"+ebob);
        }
        System.out.println("EKOK:"+(num1*num2)/ebob);
    }
}