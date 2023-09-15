import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Doğum gününü giriniz:");
        int day= input.nextInt();
        System.out.print("Doğum ayını sayı olarak giriniz:");
        int month= input.nextInt();

        if (day>=1 && day<=31 ){
            if (day>=21 && month==3){
                System.out.println("Koç burcusun.");
            } else if (day<21 && month==3) {
                System.out.println("Balık burcusun.");
            } else if (day<21 && month==4) {
                System.out.println("Koç burcusun.");
            } else if (day>=21 && month==4) {
                System.out.println("Boğa burcusun.");
            } else if (day<=21 && month==5) {
                System.out.println("Boğa burcusun.");
            } else if (day>21 && month==5) {
                System.out.println("ikizler burcusun.");
            } else if (day<=22 && month==6) {
                System.out.println("İkizler burcusun.");
            } else if (day > 22 && month==6) {
                System.out.println("Yengeç burcusun.");
            } else if (day<=22 && month==7) {
                System.out.println("Yengeç burcusun.");
            } else if (day>=23 && month==7) {
                System.out.println("Aslan burcusun.");
            } else if (day<=22 && month==8) {
                System.out.println("Aslan burcusun.");
            } else if (day>22 && month==8) {
                System.out.println("Başak burcusun");
            } else if (day<23 && month==9) {
                System.out.println("Başak burcusun.");
            } else if (day>22 && month==9) {
                System.out.println("Terazi burcusun.");
            } else if (day<23 && month==10) {
                System.out.println("Terazi burcusun.");
            } else if (day>22 && month==10) {
                System.out.println("Akrep burcusun.");
            } else if (day<22 && month==11) {
                System.out.println("Akrep burcusun.");
            } else if (day>21 && month==11) {
                System.out.println("Yay burcusun.");
            } else if (day<22 && month==12) {
                System.out.println("Yay burcusun");
            } else if (day>21 && month==12) {
                System.out.println("Oğlak burcusun.");
            } else if (day<22 && month==1) {
                System.out.println("Oğlak burcusun.");
            } else if (day>21 && month==1) {
                System.out.println("Kova burcusun.");
            } else if (day<20 && month==2) {
                System.out.println("Kova burcusun.");
            } else if (day>19 && month==2) {
                System.out.println("Balık burcusun.");
            }

            }
        else {
            System.out.println("Yanlış giriş yaptınız.");
        }
        }

    }
