import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Dönüşüm yapılacak sayıyı giriniz:");
        double num= input.nextDouble();
        System.out.print("Hangi işlemi yapacaksınız yazınız (1:int 2:string 3:double )");
        int islem= input.nextInt();

        switch (islem){
            case 1->{
                int intNum= (int) num;
                System.out.println(intNum);
            }
            case 2->{
                char strNum= (char) num;
                System.out.println(strNum);
            }
            case 3->{
                System.out.println(num);
            }
        }
    }
}