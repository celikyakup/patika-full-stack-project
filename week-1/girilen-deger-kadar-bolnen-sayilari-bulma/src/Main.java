import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input=new Scanner(System.in);
        System.out.print("Öncesinde 3 ve 4'ün katı olan sayıların ortalamasını görmek istediğiniz değeri giriniz:");
        int num= input.nextInt();
        //bir toplam değişkeni atadık bölünen sayılar toplayabilmek için
        int sum=0;
        //Ortalama değişkeni atadık ortalamayı aktarabilmek için
        // Her if döngüsüne girdiğinde kaç kere girdiğini görüp ortalama bilgisini bulabilmek için adım değişkeni atadık.
        int avg=0,adim=0;
        for (int i=1;i<=num;i++){
            if (i%3==0 && i%4==0) {
                sum += i;
                adim++;
                avg = sum / adim;
            }

        }

        System.out.println("Verdiğiniz sayıya ve sayıya kadar 3 ve 4 e bölünen sayıların ortalaması:"+avg);
    }
}