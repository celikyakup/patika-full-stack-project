import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Yıl giriniz:");
        int year=input.nextInt();
        if (year%100==0){
            if(year%400==0){
                System.out.println(year+" Artık yıldır.");
            }
            else{
                System.out.println(year+" Artık yıl değildir.");
            }
        }
        else if (year%4==0){
            System.out.println(year+" Artık yıldır.");
        }
        else{
            System.out.println(year+" Artık yıl değildir.");
        }
    }
}