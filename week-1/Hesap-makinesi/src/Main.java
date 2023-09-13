import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("1. sayıyı giriniz:");
        double num1= input.nextDouble();
        System.out.print("2.sayıyı giriniz:");
        double num2= input.nextDouble();
        System.out.print("Hangi işlemi yapacaksınız (1 toplama,2 çıkarma, 3 çarpma, 4 bölme):");
        int islem= input.nextInt();

        switch (islem){
            case 1->{
                System.out.println(num1+"+"+num2+"="+(num1+num2));
            }
            case 2->{
                System.out.println(num1+"-"+num2+"="+(num1-num2));
            }
            case 3->{
                System.out.println(num1+"x"+num2+"="+(num1*num2));
            }
            case 4->{
                if (num2!=0){
                    System.out.println(num1+"÷"+num2+"="+(num1/num2));
                }
                else{
                    System.out.println("Bir sayı 0'a bölünemez.");
                }
            }
            default -> {
                System.out.println("Yanlış değer girdiniz.");
            }
        }
    }
}