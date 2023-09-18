import java.util.Scanner;
public class Main {
    static boolean isPrime(int num,int i){
        // Base cases
        if (num <= 2)
            return (num == 2) ? true : false;
        if (num % i == 0)
            return false;
        if (i * i > num)
            return true;
        // Check for next divisor
        return isPrime(num, i + 1);
    }

    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        System.out.print("Değeri giriniz:");
        int num= input.nextInt();
        if(isPrime(num,2)) {
            System.out.println(num+" sayısı ASALDIR.");
        }
        else {
            System.out.println(num+" sayısı ASAL DEĞİLDİR!");
        }
    }
}