import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Yarıçapı giriniz:");
        double r=input.nextDouble();
        System.out.print("a açısını giriniz:");
        int a=input.nextInt();

        double alan=(Math.PI*(r*r)*a)/360;
        System.out.println("Dairenin alanı:"+ alan);
        }
    }
