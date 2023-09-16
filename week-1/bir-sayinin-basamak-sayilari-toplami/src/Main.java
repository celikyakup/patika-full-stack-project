import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Sayıyı giriniz:");
        int num= input.nextInt();
        //Basamak değerlerini ve toplamlarını aktarmak için değişken oluşturuyoruz.
        int basValue=0,sum=0;
        //num değeri 0 olduğunda bitecek bir while döngüsü oluşturduk.
        while (num!=0){
            //num değerindeki basamak değerlerini aktarmak için atama işlemi yaptık.
            basValue=num%10;
            //her basamaktaki değeri alabilmek için 10 bölüyoruz.
            num/=10;
            //basamak değerlerinin toplayarak sum değişkenine atıyoruz.
            sum+=basValue;
        }
        System.out.println("Basamak sayıları toplamı:"+sum);
    }
}