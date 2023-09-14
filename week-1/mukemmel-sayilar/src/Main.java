import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Sayıyı giriniz:");
        int num=input.nextInt();
        int sum=0;
        // Kullanıcın girdiği sayıdan önceki bütün sayılara bölmek için for döngüsü oluşturuyoruz.
        for(int i=1;i<num;i++){
            // Sayıya tam bölünen sayıları bulabilmek için if ile koşul oluşturuyoruz.
            if (num%i==0){
            //Tam bölünen sayıların toplamını bulmak için i değerlerini toplayıp sum değişkenine aktarıyoruz.
                sum+=i;
                }
            }
        // Tam bölünen değerlerin toplamı sayıyı eşit olduğu yerde mükemmel sayı olduğunu belirtmek için if koşulu oluşturuyoruz.
        if (num==sum){
            System.out.println(num+" mükemmel sayıdır.");
        }
        //Eşit değil ise else koşuluyla programa mükemmel sayı değildir çıktısını veriyoruz.
        else{
            System.out.println(num+" mükemmel sayı değildir.");
        }
    }
}