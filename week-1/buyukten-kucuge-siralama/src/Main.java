import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
       Scanner input= new Scanner(System.in);
        System.out.print("Değeri giriniz:");
        int num1= input.nextInt();
        System.out.print("Değeri giriniz:");
        int num2=input.nextInt();
        System.out.print("Değeri giriniz:");
        int num3=input.nextInt();

        if (num1>num2 && num1>num3){
            if (num2>num3){
                System.out.printf("%d %d %d",num1,num2,num3);
            }
            else{
                System.out.printf("%d %d %d",num1,num3,num2);
            }
        }
        else if (num2>num1 && num2>num3){
            if (num1>num3){
                System.out.printf("%d %d %d",num2,num1,num3);
            }
            else {
                System.out.printf("%d %d %d",num2,num3,num1);
            }
        }
        else if  (num3>num1 && num3>num2){
            if(num1>num2) {
                System.out.printf("%d %d %d", num3, num1, num2);
            }
            else {
                System.out.printf("%d %d %d",num3,num2,num1);
            }
        }

    }
}