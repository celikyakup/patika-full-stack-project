import java.io.*;
import java.util.Scanner;
public class Main {
    //Faktoriyel işlemini birden fazla kes yapacağımızdan dolayı aynı işlemleri tekrar yapmamak için faktoriyel methodu oluşturduk.
    public int faktoriyel(int a){
        int total=1;
        for (int i=1;i<=a;i++){
            total*=i;
        }
        return total;
    }
    public static void main(String[] args) {
        //Methodumuzu mainle çağırdık.
        Main obj=new Main();
        Scanner input=new Scanner(System.in);
        System.out.print("N'nin r'li kombinasyonundaki n değeri :");
        int N=input.nextInt();
        System.out.print("r değeri:");
        int r=input.nextInt();
        int fark=N-r;
        //Combinasyon hesaplamasını result değişkenine aktardık.
        int result=obj.faktoriyel(N)/(obj.faktoriyel(r)* obj.faktoriyel(fark));
        System.out.println(result);
    }
}