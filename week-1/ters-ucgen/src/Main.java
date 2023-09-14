import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Kaç basamaklı üçgen olacak giriniz:");
        int bas= input.nextInt();
        //örüntüyü olmuşturmak için basamak sayısıyla başlayıp 1 kadar azalan bir for döngüsü oluşturuyoruz.
        for(int i=bas;i>=1;i--){
            //Her satırda sol taraftaki boşlukları oluşturmak için for içinde for döngüsü oluşturuyoruz.
            // Her döngüye girdiğinde basamak değeri sabit kalıp i azalacağı için aşağı doğru indikçe boşluk sayısı artacak.
            for(int j=0;j<= bas-i;j++){
                System.out.print(" ");
            }
            // Yıldızları (2*n)-1 kuralına göre yazdırması için for döngüsüne entegre ediyoruz.
            for(int k=1;k<=2*i-1;k++){
                System.out.print("*");
            }
            // Her döngü bittiğinde bir alt satıra geçmesi için println komutu atıyoruz.
            System.out.println("");
        }


    }
}