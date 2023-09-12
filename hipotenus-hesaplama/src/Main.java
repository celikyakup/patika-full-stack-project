import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("a köşesini giriniz:");
        double a= input.nextInt();
        System.out.print("b köşesini giriniz:");
        double b=input.nextInt();
        System.out.print("c köşesini giriniz:");
        double c=input.nextInt();

        double cevre=(a+b+c);
        double u=cevre/2;
        double alan=Math.sqrt(u*Math.abs(u-a)*Math.abs(u-b)*Math.abs(u-c));
        System.out.println("Üçgenin çevresi "+cevre + " cm'dir.");
        System.out.println("Üçgenin alanı "+alan+ " cm'dir.");
        }
    }
