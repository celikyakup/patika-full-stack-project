import java.util.Scanner;
public class Main {
    static boolean isPalindrome(String str){
        StringBuilder reverse= new StringBuilder();
        for (int i=str.length()-1;i>=0;i--){
            reverse.append(str.charAt(i));
        }
        if (reverse.toString().equals(str)){
            return true;
        }
        else return false;
    }
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        System.out.print("Test etmek istediğiniz kelimeyi giriniz:");
        String word= input.next();
        if (isPalindrome(word)){
            System.out.println("Palindromik sayıdır.");
        }
        else {
            System.out.println("Palindromik sayı değildir.");
        }

    }
}