import java.util.Scanner;
public class Main {
    static boolean isPrime(int num,int i){
        // Base cases
        if (num < 2) {
            return false;
        } else if ( i== 1) {
            return true;
        } else if (num % i == 0) {
            return false;
        } else {
            return isPrime(num, i - 1);
        }
    }

    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        System.out.print("Değeri giriniz:");
        int num= input.nextInt();
        if(isPrime(num,num-1)) {
            System.out.println(num+" sayısı ASALDIR.");
        }
        else {
            System.out.println(num+" sayısı ASAL DEĞİLDİR!");
        }
    }
}