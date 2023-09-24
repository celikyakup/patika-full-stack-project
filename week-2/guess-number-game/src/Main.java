import java.util.*;
public class Main {
    public static void main(String[] args) {
        int number = (int) (Math.random() * 100);
        System.out.print(number);
        Scanner input = new Scanner(System.in);
        int guess = 0;
        int []wrong= new int[5];
        boolean isWrong=false;
        while (guess < 5) {
            System.out.print("Sayıyı giriniz:");
            int guessNum=input.nextInt();
            if (guessNum<0 || guessNum>99){
                System.out.println("Lütfen 0 ile 100 arasında bir değer giriniz.");
                if (!isWrong){
                    isWrong=true;
                    System.out.println("Bir daha yanlış giriş yaparsanız hakkınızdan düşecektir.\n");
                }
                else {
                    guess++;
                    System.out.println("Çok fazla yanlış giriş yaptınız.Kalan hakkınız:"+(5-guess)+"\n");
                }
                continue;
            }
            if (guessNum!=number){
                wrong[guess]=guessNum;
                guess+=1;
                if (guessNum>number){
                    System.out.println(guessNum+" sayısı gizli sayıdan büyüktür.");
                } else {
                    System.out.println(guessNum+" sayısı gizli sayıdan küçüktür.");
                }
                if (guess==5){
                    System.out.print("\nTahmin hakkınız bitti.Gizli sayıyı bulamadınız.\n");
                    System.out.println("Tahminleriniz:"+Arrays.toString(wrong));
                    break;
                }
            }
            else {
                System.out.print(number+" sayısını bulundunuz. Tebrikler!!");
                break;
            }
            System.out.print("Kalan tahmin hakkınız "+(5-guess)+". Yeni bir tahminde bulununun.\n\n");
        }

    }
}